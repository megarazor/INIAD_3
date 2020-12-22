package com.example.observertest;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class LightManager implements SensorEventListener {
    private List<Observer> observers= new ArrayList<>();
    private final SensorManager sensorManager;
    private final Sensor lightSensor;
    private float lastValue;
    private LightMode lightMode;

    public LightManager(Context context){
        sensorManager= (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        lightSensor= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        lightMode= LightMode.OFF;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void deleteObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(Observer o : observers){
            o.update(this);
        }
    }

    public void execute(){
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stopExecute(){
        sensorManager.unregisterListener(this);
    }

    public float getLastValue(){
        return lastValue;
    }

    public LightMode getLightMode(){
        return lightMode;
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        Log.d("LightManager", "val:" + event.values[0]);
        lastValue= event.values[0];
        LightMode prevMode= lightMode, newMode;
        if (lastValue >= 30000){
            newMode= LightMode.FULL;
        }
        else if (lastValue >= 10000){
            newMode= LightMode.DIM;
        }
        else{
            newMode= LightMode.OFF;
        }
        if (newMode != prevMode){
            lightMode= newMode;
            this.notifyObservers();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){}
}
