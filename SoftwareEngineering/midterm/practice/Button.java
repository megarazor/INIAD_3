public class Button {
    public final String label;
    private boolean pressed;
    private static int numPressed= 0;

    public Button(String label){
        this.label= label;
        pressed= false;
    }

    public Button(){
        label= "Untitled";
        pressed= false;
    }

    public void press(){
        pressed= true;
        numPressed+= 1;
    }

    public void release(){
        pressed= false;
        numPressed-= 1;
    }

    public boolean isPressed(){
        return pressed;
    }

    public int getNumPressed(){
        return numPressed;
    }

    public static void main(String[] args) {
        Button btn1 = new Button("My button");
        Button btn2 = new Button();        
        btn1.press();
        if(btn1.isPressed()) {
            System.out.printf("%s is pressed.\n", btn1.label);
            System.out.printf("%d buttons are pressed.\n", btn1.getNumPressed());
        } 
        btn2.press();
        if(btn2.isPressed()) {
            System.out.printf("%s is pressed.\n", btn2.label);
            System.out.printf("%d buttons are pressed.\n", btn2.getNumPressed());
        } 
        btn2.release();
        if(! btn2.isPressed()) {
            System.out.printf("%s is not pressed.\n", btn2.label);
            System.out.printf("%d buttons are pressed.\n", btn2.getNumPressed());
        }
        btn1.release();
        if(! btn1.isPressed()) {
            System.out.printf("%s is not pressed.\n", btn1.label);
            System.out.printf("%d buttons are pressed.\n", btn1.getNumPressed());
        }
    }
}