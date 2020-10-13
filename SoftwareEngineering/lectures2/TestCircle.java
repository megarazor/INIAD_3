public class TestCircle {
    public static void main(String[] args){
        Circle c1= new Circle(5.0, "green", 5, 10);
        Circle c2= new Circle(3.0, "yellow", -3, 5);
        System.out.printf("Area of c1: %f\n", c1.getArea());
        System.out.printf("Circumference of c2: %f\n", c2.getCircumference());
        System.out.printf("Distance between c1 and c2: %f\n", c1.getDistance(c2));
    }
}
