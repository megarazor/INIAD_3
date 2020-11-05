import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> items;
    private double total;
    private double totalWithTax;
    public ShoppingCart(){
        items= new ArrayList<Product>();
        total= 0;
        totalWithTax= 0;
    }

    void addItem(Product p){
        items.add(p);
    }

    void removeItem(String name){
        for (int i= 0; i < items.size(); i++){
            Product p= items.get(i);
            if (p.getName() == name){
                items.remove(i);
            }
        }
    }

    String getReceipt(){
        String result= "";
        double total= 0, taxIncludedTotal= 0;
        
        for (int i= 0; i < items.size(); i++){
            Product p= items.get(i);
            String name= p.getName();
            double price= p.getPrice();
            double taxIncludedPrice= p.getTaxIncludedPrice();

            result+= String.format("%d %s: %f\n", i + 1, name, taxIncludedPrice);

            total+= price;
            taxIncludedTotal+= taxIncludedPrice;          
        }
        result+= String.format("--------------\nTax: %f\nPrice after tax: %f\n", taxIncludedTotal - total, taxIncludedTotal);
        return result;
    }
}
