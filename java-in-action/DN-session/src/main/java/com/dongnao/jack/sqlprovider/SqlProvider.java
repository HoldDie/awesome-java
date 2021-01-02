package com.dongnao.jack.sqlprovider;

import java.util.Map;

public class SqlProvider {
    
    public String areaSql(Map paramMap) {
        
        Map map = (Map)paramMap.get("paramMap");
        String sql = "select * from consult_configarea where areaName='"
                + map.get("areaName") + "'";
        return sql;
    }
}
