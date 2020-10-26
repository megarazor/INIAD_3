public class Electronics extends Product {
    private static final double tax= 0.10;
    Electronics(String name, double price){
        super.name= name;
        super.price= price;
    }
    @Override double getTaxIncludedPrice(){
        return price + price * tax;
    }
}
