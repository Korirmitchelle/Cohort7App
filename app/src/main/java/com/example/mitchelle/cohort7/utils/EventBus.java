package com.example.mitchelle.cohort7.utils;
import com.squareup.otto.Bus;
/**
 * Created by mitchelle on 9/1/16.
 */
public class EventBus extends Bus {
    public static final EventBus bus  =  new EventBus();

    public static Bus getInstance(){
        return bus;
    }
    private EventBus(){}
}
