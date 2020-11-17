public final class AdvancedMachine extends Machine{
    private static int totalPrice= 0;
    public static int getTotalPrice(){
        return totalPrice;
    }

    public AdvancedMachine(String model, int price){
        super(model, price);
        totalPrice+= super.getPrice();
    }

    @Override
    public int getPrice(){
        int p= super.getPrice();
        return p + p / 10;
    }
}
