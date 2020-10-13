// Rhombus.java

package figures;

public class Rhombus extends Parallelogram{
    protected double side;
    protected double diagonal1;
    protected double diagonal2;

    public Rhombus(double side, double diagonal1, double diagonal2){
        super((diagonal1 * diagonal2 / 2) / side, side);  
        this.side= side;
        this.diagonal1= diagonal1;
        this.diagonal2= diagonal2;    
    }

    @Override
    public double getArea(){
        return (diagonal1 * diagonal2 / 2);
    }
}
