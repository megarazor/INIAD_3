import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        try {
            int n= Integer.valueOf(in.nextLine());
            for (int i= 1; i <= 10; i++){
                System.out.printf("%d x %d = %d\n", n, i, n * i);
            }
        } catch(NumberFormatException ex){
            System.out.printf("Please input integers\n");
        }
        in.close();     
    }
}
