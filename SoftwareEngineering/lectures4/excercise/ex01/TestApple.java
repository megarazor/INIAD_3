public class TestApple {
    public static void main(String... args){
        Apple a1= new Apple();
        Apple a2= new Apple();

        a1.peel();
        System.out.println("a1: " + a1.getState());
        System.out.println("a2: " + a2.getState());
    }
}
