package com.yjm.springbootdemo.rocketmq.observertest;

/**
 * 观察者(Observer)
 */
public interface Observer {
    public void update(float temp,float humidity,float pressure);
}
