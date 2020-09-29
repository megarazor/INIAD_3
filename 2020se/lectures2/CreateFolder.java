import java.io.File;

public class CreateFolder {
    public static void main(String[] args){
        File newfolder= new File("./Practice2-1");
        if (newfolder.mkdir()){
            System.out.println("Succeeded");
        }
        else{
            System.out.println("Failed");
        }
    }
}
