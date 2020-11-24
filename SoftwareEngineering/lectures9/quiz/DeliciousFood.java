public class DeliciousFood extends Item implements Eatable{
    public DeliciousFood(String name, int price){
        super(name, price);
    }
    @Override
    public int getTaxPrice(){
        return price + (price * 8 / 100);
    }
    @Override
    public String getTaste(){
        return "Delicious";
    }
}
