package com.dongnao.jack.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dongnao.jack.bean.ConsultConfigArea;
import com.dongnao.jack.dao.CommonMapper;

public class MyServiceImpl implements MyService {
    private static Logger logger = Logger.getLogger(MyServiceImpl.class);
    
    @Autowired
    @Qualifier("myServiceImpl2")
    MyService service2;
    
    @Autowired
    CommonMapper dao;
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void execute() {
        //        System.out.println("execute执行");
        logger.info("execute执行");
        
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("106");
        area.setAreaName("测试2");
        area.setState(0);
        dao.saveArea(area);
        service2.execute();
    }
}
