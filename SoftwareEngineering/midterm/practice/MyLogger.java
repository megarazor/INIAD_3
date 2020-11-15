import java.io.FileWriter; 
import java.io.IOException;
import java.lang.UnsupportedOperationException;

public class MyLogger {
    private String fileName;
    private int writeCount= 0;
    private static int instanceCount= 0;

    public MyLogger(String fileName){
        if (instanceCount >= 3){
            throw new UnsupportedOperationException("Can only create up to 3 MyLogger objects.");
        }
        this.fileName= fileName;
        instanceCount+= 1;
    }
    public void write(String content){
        writeCount+= 1;
        try{
            FileWriter writer= new FileWriter(fileName, true);
            writer.write(content);
            writer.write("\n\n");
            writer.close();
        }
        catch(IOException e){
            System.out.println("An error has ocurred while writing to file.");
        }
        
    }
    public int count(){
        return writeCount;
    }

    public static void main(String... args){
        MyLogger log1= new MyLogger("log1.txt");
        MyLogger log2= new MyLogger("log2.txt");
        MyLogger log3= new MyLogger("log1.txt");

        System.out.printf("log1's write count: %d\n", log1.count());
        log1.write("Bruh");
        log1.write("Moment");
        log2.write("Skrattar du");
        log2.write("Folorar du");
        log3.write("More bruh");
        System.out.printf("log1's write count: %d\n", log1.count());
        System.out.printf("log2's write count: %d\n", log2.count());
        System.out.printf("log3's write count: %d\n", log3.count());

        MyLogger log4= new MyLogger("log4.txt");
        MyLogger log5= new MyLogger("log5.txt");
    }
}
