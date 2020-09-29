import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        System.out.printf("Input a positive integer\n");
        Scanner in= new Scanner(System.in);
        try {
            int n= Integer.valueOf(in.nextLine());
            if (n < 0){
                System.out.printf("Please input a positive integer\n");
                return;
            }
            String res= "";
            while (n > 0){
                int r= n % 2;
                if (r == 0){
                    res= '0' + res;
                }
                else {
                    res= '1' + res;
                }
                n= n / 2;
            }
            System.out.printf("Binary: %s\n", res);
        } catch(NumberFormatException ex){
            System.out.printf("Please input integers\n");
        }     
    }
}
