package com.dongnao.jack.aop;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dongnao.jack.dao.CommonMapper;
import com.dongnao.jack.mybatisInterceptor.Page;
import com.dongnao.jack.service.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:config/spring/spring-dispatcher.xml")
public class MyTest implements ApplicationContextAware {
    
    public ApplicationContext context;
    
    @Autowired
    @Qualifier("myServiceImpl2")
    MyService service2;
    
    @Autowired
    CommonMapper mapper;
    
    @Autowired
    MapperFactoryBean mapperFactoryBean;
    
    @Test
    public void test1() {
        MyService service = (MyService)context.getBean("myservice");
        service.execute();
        //        service2.execute();
    }
    
    @Test
    public void test2() {
        IntroductionIntf service = (IntroductionIntf)context.getBean("myservice");
        service.extend();
    }
    
    @Test
    public void test3() {
        //        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        Map map = new HashMap();
        //        map.put("areaName", "测试1");
        //        List<ConsultConfigArea> areas = mapper.qryArea(map);
        //        System.out.println(areas);
        Page page = new Page();
        page.setNeedPage(true);
        page.setBeginPage(1);
        page.setPageSize(15);
        map.put("page", page);
        map.put("isCache", true);
        map.put("cacheKey", "queryContent");
        map.put("type", 1);
        map.put("expireTime", 30000);
        System.out.println(mapper.queryContent(map));
        //        mapper.queryContent(map);
    }
    
    @Test
    public void test4() {
        SqlSession session = mapperFactoryBean.getSqlSession();
        Map map = new HashMap();
        //        map.put("areaName", "测试1");
        //        List<ConsultConfigArea> areas = mapper.qryArea(map);
        //        System.out.println(areas);
        Page page = new Page();
        page.setNeedPage(true);
        page.setBeginPage(1);
        page.setPageSize(15);
        map.put("page", page);
        session.selectList("com.dongnao.jack.dao.CommonMapper.queryContent",
                map);
    }
    
    //    @Test
    //    public void test3() {
    //        System.out.println(mapper.queryContent(new HashMap()));
    //    }
    @Override
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        this.context = arg0;
        
    }
    
}
