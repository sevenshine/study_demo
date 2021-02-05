package com.yjm.springbootdemo.rocketmq.observertest;

/**
 * 主题(Subject)
 * 主题只关心观察者实现了Observer接口，主题并不关心观察者的细节
 */
public interface Subject {
    public void notifyObserver();
    public void removeObserver(Observer observer);
    public void registerObserver(Observer observer);
}
