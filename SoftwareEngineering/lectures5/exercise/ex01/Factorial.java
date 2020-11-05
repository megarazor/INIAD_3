public class Factorial implements Function {
    @Override
    public double evaluate(double x){
        double res= 1;
        for (int i= 1; i <= x; i++){
            res*= i;
        }
        return res;
    }
}
