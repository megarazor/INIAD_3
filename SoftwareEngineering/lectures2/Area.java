import java.util.Random;
import java.lang.Math.*;

public class Area {
    private static int getRandomInt(int min, int max) {
		Random n = new Random();
		return n.nextInt((max - min) + 1) + min;
    }
    public static void main(String[] args) {
        int r= getRandomInt(0, 10);
        double area= r * r * Math.PI;
        System.out.printf("The area of a circle with a radius of %d is %f\n", r, area);
    }
}
