public class Button {
    final public String label;
    private boolean pressed;
    private static int numPressed= 0;
    public Button(String label){
        this.label= label;
        this.pressed= false;
    }
    public Button(){
        this.label= "Untitled";
        this.pressed= false;
    }
    public void press(){
        if (this.pressed == false){
            this.pressed= true;
            numPressed+= 1;
        }
    }
    public void release(){
        if (this.pressed == true){
            this.pressed= false;
            numPressed-= 1;
        }
    }
    public boolean isPressed(){
        return pressed;
    }
    public static int getNumPressed(){
        return numPressed;
    }
}
