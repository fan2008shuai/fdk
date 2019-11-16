package org.fan.fdk.yaml.task;

/**
 * Created by fan.shuai on 2019/11/16.
 */
public class Resources {
    private String redis;
    private String service;

    public String getRedis() {
        return redis;
    }

    public void setRedis(String redis) {
        this.redis = redis;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "redis='" + redis + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}
