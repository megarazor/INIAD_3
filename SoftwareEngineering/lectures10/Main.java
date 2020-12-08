public class Main {
    public static void main(String[] args) {
        Status.getInstance().setState(1);
        System.out.printf("Status:%d\n", Status.getInstance().getState());
    }
}
