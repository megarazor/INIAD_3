public class Status {
    private static Status instance= new Status();
    private int state;

    private Status() {
    }

    public static Status getInstance(){
        return instance;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
