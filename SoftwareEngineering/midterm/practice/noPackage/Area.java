import java.util.Random;
import java.lang.Math;

public class Area {
    public static void main(String... args){
        Random random= new Random();
        int r= random.nextInt(10);
        System.out.printf("The area of a circle with a radius of %d is %f\n", r, r * r * Math.PI);
    }
}
