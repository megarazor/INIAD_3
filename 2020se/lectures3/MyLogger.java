import java.io.FileWriter;
import java.io.IOException;

public class MyLogger {
    private String fileName;
    private int writeCount= 0;
    private static int loggerCount= 0;
    public MyLogger(String fileName){
        if (loggerCount >= 3){
            throw new UnsupportedOperationException();
        }
        else{
            this.fileName= fileName;
            loggerCount+= 1;
        }
    }
    public void write(String content){
        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            myWriter.write(content);
            myWriter.write("\n\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            writeCount+= 1;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public int count(){
        return writeCount;
    }
}
