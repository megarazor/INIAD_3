public class Book extends Item{
    public Book(String name, int price){
        super(name, price);
    }
    @Override
    public int getTaxPrice(){
        return price + (price / 10);
    }
}
