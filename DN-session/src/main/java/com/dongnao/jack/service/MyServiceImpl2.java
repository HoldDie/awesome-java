package com.dongnao.jack.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dongnao.jack.bean.ConsultIdCardInfo;
import com.dongnao.jack.dao.CommonMapper;

@Service
public class MyServiceImpl2 implements MyService {
    
    @Autowired
    CommonMapper dao;
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void execute() {
        //        System.out.println("MyServiceImpl2 execute");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ConsultIdCardInfo user = new ConsultIdCardInfo();
        user.setActiveTime(sdf.format(new Date()));
        user.setAddress("XXXX");
        user.setBirthday("19");
        user.setName("测试2");
        user.setNation("2");
        user.setPicture("xxxx");
        user.setPsptId("1242344");
        user.setSex("0");
        dao.saveUser(user);
        
        throw new RuntimeException("回滚");
    }
    
}
