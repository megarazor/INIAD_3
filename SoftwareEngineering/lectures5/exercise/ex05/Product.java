public abstract class Product {
    protected String name;
    protected double price;
    String getName(){
        return name;
    }
    double getPrice(){
        return price;
    }
    abstract double getTaxIncludedPrice();
}
