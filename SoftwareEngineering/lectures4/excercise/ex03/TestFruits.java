import fruit.*;

public class TestFruits {
    public static void main(String... args){
        Durian d= new Durian();
        Orange o= new Orange();        
        Apple a= new Apple();

        System.out.println("Durian: " + d.getState());
        System.out.println("Orange: " + o.getState());
        System.out.println("Apple: " + a.getState());

        d.peel();
        o.peel();
        a.peel();

        System.out.println("Durian: " + d.getState());
        System.out.println("Orange: " + o.getState());
        System.out.println("Apple: " + a.getState());
    }
}
