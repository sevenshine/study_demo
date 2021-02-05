package com.yjm.springbootdemo.rocketmq.observertest;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题实现
 *
 */
public class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void notifyObserver() {

        for (Observer obs :
                observers) {
            obs.update(temperature, humidity, pressure);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void measurementChanged()
    {
        notifyObserver();
    }

    public void setMeasurement(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}


