package four;

public abstract class Plant {
    private int price;
    public Plant(int price){
        this.price= price;
    }
    public int getPrice(){
        return price;
    }
    public abstract String getColor();

}
