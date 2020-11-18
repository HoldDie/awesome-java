package com.holddie.boot.jpa.dao.projection;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/3 11:04
 */
public interface PersonSummary {
    String getFirstname();

    String getLastname();

    AddressSummary getAddress();

    interface AddressSummary {
        String getCity();
    }
}
