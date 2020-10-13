import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args){
        try{
            File newfile= new File("./Practice2-1/sample.txt");
            if (newfile.createNewFile()){
                System.out.println("File created");
            }
            else{
                System.out.println("File already exists");
            }
            FileWriter writer= new FileWriter("./Practice2-1/sample.txt");
            writer.write("Hello INIAD");
            writer.close();
            System.out.println("File writing succeeded");
        } catch(IOException e){
            System.out.println("Error occurred");
            return;
        }
        
    }
}
