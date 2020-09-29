import java.util.Scanner;

public class Sum {
    public static void main(String... args){
        System.out.printf("Input two numbers\n");
        Scanner in= new Scanner(System.in);
        try {
        int a= Integer.valueOf(in.nextLine());
        int b= Integer.valueOf(in.nextLine());
        System.out.printf("%d plus %d = %d\n", a, b, a + b);
        } catch(NumberFormatException ex){
            System.out.printf("Please input integers\n");
        }         
    }   
}
