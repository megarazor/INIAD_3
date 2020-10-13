package assignment1;

public class Pyramid extends Figure{
    Pyramid(int height){
        super(height);
    }
    @Override
    void draw(){
        int length= height * 2 - 1;
        for (int star= 1; star <= length; star+= 2){
            int blank= length - star;
            for (int i= 0; i < blank / 2; i++){
                System.out.print(" ");
            }
            for (int i= 0; i < star; i++){
                System.out.print("*");
            }
            for (int i= 0; i < blank / 2; i++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
