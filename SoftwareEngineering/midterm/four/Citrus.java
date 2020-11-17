package four;

public class Citrus extends Plant implements Edible {
    private String color;
    private boolean sweet;

    public Citrus(int price, String color, boolean sweet){
        super(price);
        this.color= color;
        this.sweet= sweet;
    }
    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean isSweet(){
        return sweet;
    }
    @Override
    public boolean isSour(){
        return true;
    }
}
