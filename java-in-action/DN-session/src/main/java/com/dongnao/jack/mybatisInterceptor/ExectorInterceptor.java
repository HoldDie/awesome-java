package com.dongnao.jack.mybatisInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dongnao.jack.bean.ConsultContent;
import com.dongnao.jack.redis.RedisApi;

@Intercepts({@Signature(method = "query", type = Executor.class, args = {
        MappedStatement.class, Object.class, RowBounds.class,
        ResultHandler.class})})
public class ExectorInterceptor implements Interceptor {
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof Executor) {
            Map map = (Map)invocation.getArgs()[1];
            String cacheKey = map.containsKey("cacheKey") ? map.get("cacheKey")
                    .toString() : "";
            String cacheStr = RedisApi.get(cacheKey);
            if (cacheStr != null && !"".equals(cacheStr)) {
                JSONArray ja = JSONArray.parseArray(cacheStr);
                List<ConsultContent> list = new ArrayList<ConsultContent>();
                for (Object o : ja) {
                    list.add(JSONObject.parseObject(o.toString(),
                            ConsultContent.class));
                }
                return list;
            }
        }
        return invocation.proceed();
    }
    
    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        }
        return target;
    }
    
    @Override
    public void setProperties(Properties properties) {
        // TODO Auto-generated method stub
        
    }
    
}
