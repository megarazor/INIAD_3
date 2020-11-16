package assignment1.figures;

import assignment1.base.Writable;
import assignment1.figures.Pyramid;
import java.io.FileWriter; 
import java.io.IOException;

public class WritablePyramid extends Pyramid implements Writable {
    public WritablePyramid(int height){
        super(height);
    }
    @Override 
    public void write(String filename){
        try{
            FileWriter writer= new FileWriter(filename);
            StringBuffer sb= new StringBuffer("");
        
            int length= height * 2 - 1;
            for (int star= 1; star <= length; star+= 2){
                int blank= length - star;
                for (int i= 0; i < blank / 2; i++){
                    // System.out.print(" ");
                    sb.append(" ");
                }
                for (int i= 0; i < star; i++){
                    // System.out.print("*");
                    sb.append("*");
                }
                for (int i= 0; i < blank / 2; i++){
                    // System.out.print(" ");
                    sb.append(" ");
                }
                // System.out.println();
                sb.append("\n");
            }
            writer.write(sb.toString());
            writer.close();
        }
        catch(IOException e){
            System.out.println("An error has ocurred while writing to file.");
        }
        
    }
    
}
