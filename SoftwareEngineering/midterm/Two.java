import java.util.Scanner;
import java.lang.StringBuffer;

public class Two {
    public static void main(String[] args) {
        StringBuffer s= new StringBuffer("");
        Scanner in= new Scanner(System.in);
        while (true){
            String new_s= in.nextLine();
            if (new_s.isEmpty()){
                System.out.println(s);
                in.close();
                return;
            }
            else{
                s.append(new_s.charAt(0));             
            }
        }
    }
}