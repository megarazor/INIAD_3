// Rectangle.java

package figures;

public class Rectangle extends Parallelogram{
    protected double side1;
    protected double side2;

    public Rectangle(double side1, double side2){
        super(side1, side2);
        this.side1= side1;
        this.side2= side2;
    }

    @Override
    public double getArea(){
        return side1 * side2;
    }
}

