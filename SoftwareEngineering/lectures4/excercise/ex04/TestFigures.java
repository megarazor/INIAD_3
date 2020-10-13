// TestFigures.java

import figures.*;

public class TestFigures {
    public static void main(String... args){
        Trapezoid tra= new Trapezoid(4, 2, 5);
        Parallelogram par= new Parallelogram(3, 5);
        Rhombus rho= new Rhombus(3, 7, 6);
        Rectangle rec= new Rectangle(4, 9);
        Square squ= new Square(10);

        System.out.printf("Trapezoid area: %f\n", tra.getArea());
        System.out.printf("Parallelogram area: %f\n", par.getArea());
        System.out.printf("Rhombus area: %f\n", rho.getArea());
        System.out.printf("Rectangle area: %f\n", rec.getArea());
        System.out.printf("Square area: %f\n", squ.getArea());
    }
}
