public class FreshFood extends Product {
    private static final double tax= 0.08;
    FreshFood(String name, double price){
        super.name= name;
        super.price= price;
    }
    @Override double getTaxIncludedPrice(){
        return price + price * tax;
    }
}
