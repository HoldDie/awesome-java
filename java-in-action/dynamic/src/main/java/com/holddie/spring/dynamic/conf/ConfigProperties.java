package com.holddie.spring.dynamic.conf;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/19 18:30
 */
@Configuration
public class ConfigProperties extends PreferencesPlaceholderConfigurer {

    private String query ="select property_key,property_value from t_config_properties where status > 0";
    @Override
    protected Properties mergeProperties() throws IOException {
        Properties result = new Properties();

        if (this.localOverride) {
            loadProperties(result);
        }

        if (this.localProperties != null) {
            for (Properties localProp : this.localProperties) {
                CollectionUtils.mergePropertiesIntoMap(localProp, result);
            }
        }

        if (!(this.localOverride)) {
            loadProperties(result);
        }
        //解析完成后 开始读取数据库配置文件
        //用connection 因为DataSource通过properties加载配置完成后才能注入!
        Connection connection = null;
        try {
            //result为最终Spring全部加载的properties,所有可以直接取到数据库的配置
            Class.forName(result.getProperty("master.driverClassName"));
            connection = DriverManager.getConnection(result.getProperty("master.url"), result.getProperty("master.username"), result.getProperty("master.password"));
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String key = rs.getString(1);
                String value = rs.getString(2);
                if (!StringUtils.isBlank(key) && !StringUtils.isBlank(value)) {
                    result.setProperty(key, value);
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        }

        return result;
    }
}
