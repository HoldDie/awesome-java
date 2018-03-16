package com.holddie.springboot.dynamic.configuration.entitiy;

/**
 * redis 配置实体
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/14 23:43
 */
public class RedisConfig {
    private String url;
    private int port;
    private String username;
    private String password;

    public RedisConfig(String url, int port, String username, String password) {
        this.url = url;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
