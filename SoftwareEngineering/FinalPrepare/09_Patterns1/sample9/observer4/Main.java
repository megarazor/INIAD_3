package sample9.observer4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        SensorReader sr = new SensorReader("USER_NAME","PASSWORD");
        Observer ob= new SensorObserver();
        sr.addObserver(ob);
        sr.execute("3205");
    }
}