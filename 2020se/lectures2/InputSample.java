import java.util.Scanner;
import java.lang.StringBuffer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.BufferedWriter;

public class InputSample {
    public static void main(String[] args) throws IOException {
        StringBuffer s= new StringBuffer("");
        Scanner in= new Scanner(System.in);
        while (in.hasNextLine()){
            String new_s= in.nextLine();
            if (new_s.isEmpty()){
                BufferedWriter outFile = new BufferedWriter(new FileWriter(new File("result.txt")));
                System.out.println(s);
                in.close();
                outFile.write(s.toString());
                outFile.flush();
                outFile.close();
                break;
            }
            else{
                s.append(new_s);
                s.append("\n");
                // System.out.println(new_s);                
            }
        }
    }
}
