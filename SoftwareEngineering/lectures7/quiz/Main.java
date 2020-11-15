package quiz;

public class Main {
    public static void main(String[] args) {
        FruitsBasket fb = new FruitsBasket();
        fb.add(new Apple());
        fb.add(new Grape());
        fb.add(new Apple());
        fb.print();
    }
}
