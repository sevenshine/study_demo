package com.yjm.springbootdemo.rocketmq.observertest;

public class CurrentConditionDisplay implements Observer,DisplayElement {
    private float temperature;
    private float humidity;
    private  Subject weatherData;

    @Override
    public void display() {
        System.out.println("Curent conditions:"+temperature+"F degrees and "+humidity+"% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature=temp;
        this.humidity=humidity;
        display();
    }

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
}
