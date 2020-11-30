package sample9.observer4;

public class SensorObserver implements Observer{
    public void update(SensorReader subject){
        System.out.printf("Illuminance: %f\n", subject.getIlluminance());
        System.out.printf("Humiditity: %f\n", subject.getHumidity());
        System.out.printf("Air pressure: %f\n", subject.getAirpressure());
        System.out.printf("Temperature: %f\n", subject.getTemperature());
    }
}
