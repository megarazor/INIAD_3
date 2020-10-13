// Trapezoid.java

package figures;

public class Trapezoid {
    protected double height;
    protected double smaller_base;
    protected double bigger_base;

    public Trapezoid(double height, double smaller_base, double bigger_base){
        this.height= height;
        this.smaller_base= smaller_base;
        this.bigger_base= bigger_base;
    }

    public double getArea(){
        return (smaller_base + bigger_base) * height / 2;
    }
}
