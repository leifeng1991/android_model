package com.leifeng.android.model.rxjava;

public class MyEventBus {
    private static MyEventBus instance = null;
    
    private MyEventBus(){}
    
    public MyEventBus getInstance(){
        if (instance == null){
            synchronized (MyEventBus.class){
                if (instance == null){
                    instance = new MyEventBus();
                }
            }
        }
        return instance;
    }
}
