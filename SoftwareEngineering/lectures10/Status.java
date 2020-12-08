public class Status {
    private static Status status= new Status();
    private int state;

    private Status(){
    }

    public static Status getInstance(){
        return status;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
