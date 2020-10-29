package assignment1;

import assignment1.base.Figure;
import assignment1.figures.Pyramid;
import assignment1.figures.Rectangle;
import assignment1.figures.Square;
import assignment1.figures.WritablePyramid;

public class Main {
    public static void main(String[] args) {
        Pyramid p = new Pyramid(4);
        Rectangle r = new Rectangle(4, 6);
        Square s = new Square(10);
        System.out.println("---");
        p.draw();
        System.out.println("---");
        r.draw();
        System.out.println("---");
        s.draw();

        WritablePyramid wp= new WritablePyramid(13);
        wp.write("output.txt");
    }
}