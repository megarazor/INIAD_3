package quiz;

public class Main {
    public static void main(String... args){
        Apple a= new Apple(4.2, 5);
        System.out.printf("Price: %d\n", a.getPrice());
        System.out.printf("Color: %s\n", a.getColor());
    }
}
