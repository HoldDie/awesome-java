package com.dongnao.jack.mybatisInterceptor;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.util.ReflectionUtils;

import com.alibaba.fastjson.JSONArray;
import com.dongnao.jack.redis.RedisApi;

@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class ResultSetCacheInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof DefaultResultSetHandler) {
            DefaultResultSetHandler rsh = (DefaultResultSetHandler)invocation.getTarget();
            Field boundSqlf = getField(rsh, "boundSql");
            boundSqlf.setAccessible(true);
            BoundSql boundSql = (BoundSql)boundSqlf.get(rsh);
            Map map = (Map)boundSql.getParameterObject();
            if (map.get("isCache") != null
                    && Boolean.valueOf(map.get("isCache").toString())) {
                List<Object> results = (List<Object>)invocation.proceed();
                String resultStr = JSONArray.toJSONString(results);
                RedisApi.set(map.get("cacheKey").toString(), resultStr);
                return results;
            }
        }
        
        return invocation.proceed();
    }
    
    private Field getField(Object obj, String name) {
        Field field = ReflectionUtils.findField(obj.getClass(), name);
        field.setAccessible(true);
        return field;
    }
    
    @Override
    public Object plugin(Object target) {
        if (target instanceof ResultSetHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }
    
    @Override
    public void setProperties(Properties properties) {
        // TODO Auto-generated method stub
        
    }
    
}
