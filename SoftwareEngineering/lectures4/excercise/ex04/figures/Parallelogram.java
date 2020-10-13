// Parallelogram.java

package figures;

public class Parallelogram extends Trapezoid{
    protected double base;

    public Parallelogram(double height, double base){
        super(height, base, base);
        this.base= base;
    }

    @Override
    public double getArea(){
        return base * height;
    }
}
