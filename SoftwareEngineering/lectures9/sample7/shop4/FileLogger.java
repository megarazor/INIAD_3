package sample7.shop4;

import java.io.FileWriter; 
import java.io.IOException;
import java.io.File;
import java.lang.UnsupportedOperationException;

public class FileLogger implements Logger {
    private static FileLogger instance= new FileLogger();
    private File file= new File("log.txt");

    private FileLogger() {
    }

    public static FileLogger getInstance(){
        return instance;
    }

    public void purchase(Customer customer, Item item) {
        String content= String.format("[Purchase] %s: %s(%d yen).\n", customer.getName(), item.getName(), item.getPrice());
        try{
            FileWriter writer= new FileWriter(file, true);
            writer.write(content);
            writer.close();
        }
        catch(IOException e){
            System.out.println("An error has ocurred while writing to file.");
        }
    }

    public void balance(User user) {
        String content= String.format("[Balance] %s: %d yen.\n", user.getName(), user.getBalance());
        try{
            FileWriter writer= new FileWriter(file, true);
            writer.write(content);
            writer.close();
        }
        catch(IOException e){
            System.out.println("An error has ocurred while writing to file.");
        }
    }

    public void error(User user, String error) {
        String content= String.format("[Error] %s: %s.\n", user.getName(), error);
        try{
            FileWriter writer= new FileWriter(file, true);
            writer.write(content);
            writer.close();
        }
        catch(IOException e){
            System.out.println("An error has ocurred while writing to file.");
        }
    }
}