package quiz;
import java.util.*;  

public class FruitsBasket{
    private List<Fruit> list= new ArrayList<Fruit>();

    public void add(Fruit fruit){
        list.add(fruit);
    }

    public void print(){
        for (Fruit f:list){
            System.out.println(f.getColor());
        }
    }
}
