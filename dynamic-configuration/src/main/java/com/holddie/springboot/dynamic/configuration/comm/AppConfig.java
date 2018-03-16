package com.holddie.springboot.dynamic.configuration.comm;

import com.alibaba.druid.pool.DruidDataSource;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.holddie.springboot.dynamic.configuration.entitiy.RedisConfig;
import com.holddie.springboot.dynamic.configuration.mapper.RedisConfigMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import javax.sql.DataSource;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * 配置
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/15 8:09
 */
@Configuration
@MapperScan(basePackages = "com.holddie.springboot.dynamic.configuration.mapper")
public class AppConfig {

    private Environment environment;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 设置mybatis会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Primary
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);

        // 设置mybatis xml文件扫描路径
        factory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/*Mapper.xml"));
        return factory.getObject();
    }

    /**
     * Redis连接工厂
     * @param mapper 这个非常重要，必须在mapper被创建了之后才能创建Redis连接工厂
     * @return
     */
    @Primary
    @Bean("redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory(RedisConfigMapper mapper) {

        // 获取redis连接信息
        List<RedisConfig> redisConfigs = mapper.getRedisConfig();
        List<String> clusterNodes = new ArrayList<>();
        for (RedisConfig rc : redisConfigs) {
            clusterNodes.add(rc.getUrl() + ":" + rc.getPort());
        }

        // 获取Redis集群配置信息
        RedisClusterConfiguration rcf = new RedisClusterConfiguration(clusterNodes);

        return new JedisConnectionFactory(rcf);
    }

    /**
     * 创建redis模板
     *
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Primary
    @Bean("redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // redis value使用的序列化器
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // redis key使用的序列化器
        template.setKeySerializer(jackson2JsonRedisSerializer);


        template.afterPropertiesSet();
        return template;
    }
}
