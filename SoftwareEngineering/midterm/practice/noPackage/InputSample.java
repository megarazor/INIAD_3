import java.util.Scanner;
import java.lang.StringBuffer;

public class InputSample {
    public static void main(String[] args) {
        StringBuffer s= new StringBuffer("");
        Scanner in= new Scanner(System.in);
        while (in.hasNextLine()){
            String new_s= in.nextLine();
            if (new_s.isEmpty()){
                if (s.length() != 0){
                    s.deleteCharAt(s.length() - 1);
                }
                System.out.println(s);
                in.close();
                break;
            }
            else{
                s.append(new_s);
                s.append("\n");               
            }
        }
    }
}