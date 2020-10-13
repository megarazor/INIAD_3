package assignment1;

public class Main {
    public static void main(String[] args) {
        Figure f = new Figure(4);
        Pyramid p = new Pyramid(4);
        Rectangle r = new Rectangle(4, 6);
        Square s = new Square(10);
        System.out.printf("Figure: %d\n", f.height);
        System.out.printf("Pyramid: %d\n", p.height);
        System.out.printf("Rectangle: %d x %d\n", r.width, r.height);
        System.out.printf("Square: %d x %d\n", s.width, s.height);
    }
}