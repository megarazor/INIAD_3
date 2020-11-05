public class Animal {
    protected String stomach;

    String getStomach(){
        return stomach;
    }

    void eat(){
        stomach= "full";
    }

    void run(){
        stomach= "hungry";
    }
}
