package com.holddie.spring.dynamic.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/19 18:27
 */
public class ApplicationConfigurer {

    private static Logger logger = LoggerFactory.getLogger(ApplicationConfigurer.class);

    public static final String SPRING_CONFIG_LOCATION = "spring.config.location";

    /**
     * 自定义配置加载，方法定义为static的，保证优先加载
     * @return
     */
    @Bean
    public static PropertyPlaceholderConfigurer properties() {
        final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setIgnoreResourceNotFound(true);
        final List<Resource> resourceLst = new ArrayList<Resource>();

        if(System.getProperty(SPRING_CONFIG_LOCATION) != null){
            String configFilePath = System.getProperty(SPRING_CONFIG_LOCATION);
            String[] configFiles = configFilePath.split(",|;");

            FileSystemResource res =null;
            for (String configFile : configFiles) {
                if (configFile.startsWith("file:")){
                    resourceLst.add(new FileSystemResource(configFile));
                }else {
                    resourceLst.add( new ClassPathResource(configFile));
                }
            }
        }else {
            resourceLst.add(new ClassPathResource("config/application.properties"));
            resourceLst.add(new ClassPathResource("config/kafka.properties"));
        }
        ppc.setLocations(resourceLst.toArray(new Resource[]{}));
        return ppc;
    }
}
