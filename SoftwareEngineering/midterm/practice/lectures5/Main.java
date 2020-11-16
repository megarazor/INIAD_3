import assignment1.figures.WritablePyramid;

public class Main {
    public static void main(String... args){
        WritablePyramid p= new WritablePyramid(10);
        p.write("pyramid.txt");
        p.draw();
    }
}
