public class MyLoggerTest {
    public static void main(String[] args) {
        MyLogger log1= new MyLogger("out1.txt");
        MyLogger log2= new MyLogger("out2.txt");
        MyLogger log3= new MyLogger("out3.txt");
        log1.write("Bruh!");
        log2.write("Skrattar du!");
        log2.write("Folorar du!");
        System.out.printf("log1 is written %d times.\n", log1.count()); 
        System.out.printf("log2 is written %d times.\n", log2.count()); 
        System.out.printf("log3 is written %d times.\n", log3.count()); 


        MyLogger log4= new MyLogger("out4.txt");
    }
}