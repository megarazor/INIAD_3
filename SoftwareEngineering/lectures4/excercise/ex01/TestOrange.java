public class TestOrange {
    public static void main(String... args){
        Orange orange1= new Orange();
        Orange orange2= new Orange();

        orange1.peel();
        System.out.println("Orange1: " + orange1.getState());
        System.out.println("Orange2: " + orange2.getState());
    }
}
