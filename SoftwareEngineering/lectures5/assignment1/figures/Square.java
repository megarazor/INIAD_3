package assignment1.figures;

public class Square extends Rectangle{
    public Square(int edge){
        super(edge, edge);
    }

    @Override
    public void draw(){
        for (int i= 0; i < height; i++){
            for (int j= 0; j < height; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
