package assignment1.figures;

import assignment1.base.Writable;
import java.io.FileWriter;
import java.io.IOException;

public class WritablePyramid extends Pyramid implements Writable{
    public WritablePyramid(int height){
        super(height);
    }

    @Override
    public void write(String filename){
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            StringBuffer content= new StringBuffer();

            int length= height * 2 - 1;
            for (int star= 1; star <= length; star+= 2){
                int blank= length - star;
                for (int i= 0; i < blank / 2; i++){
                    content.append(" ");
                }
                for (int i= 0; i < star; i++){
                    content.append("*");
                }
                for (int i= 0; i < blank / 2; i++){
                    content.append(" ");
                }
                content.append("\n");
            }

            myWriter.write(content.toString());
            myWriter.flush();
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }    
}
