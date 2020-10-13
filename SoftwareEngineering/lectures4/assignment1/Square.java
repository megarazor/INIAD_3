package assignment1;

public class Square extends Rectangle{
    Square(int edge){
        super(edge, edge);
    }
    @Override
    void draw(){
        for (int i= 0; i < height; i++){
            for (int j= 0; j < height; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
