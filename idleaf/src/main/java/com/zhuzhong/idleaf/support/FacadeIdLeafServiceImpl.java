package com.zhuzhong.idleaf.support;

import com.zhuzhong.idleaf.IdLeafService;

import java.util.Map;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/16 9:28
 */
public class FacadeIdLeafServiceImpl {

    private Map<String, IdLeafService> idLeafServiceMap;

    public FacadeIdLeafServiceImpl(Map<String, IdLeafService> idLeafServiceMap) {
        this.idLeafServiceMap = idLeafServiceMap;
    }
}
