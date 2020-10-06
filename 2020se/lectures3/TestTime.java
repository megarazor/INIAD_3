public class TestTime {
    public static void main(String[] args){
        Time t= new Time(16, 7, 30);
        t.hour+= 1;
        System.out.printf("Current time: %s\n", t.getCurrentTime());
    }
}
