public abstract class Item {
    private String name;
    protected int price;

    public Item(String name, int price){
        this.name= name;
        this.price= price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public abstract int getTaxPrice();
}
