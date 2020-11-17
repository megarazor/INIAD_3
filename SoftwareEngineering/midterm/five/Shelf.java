package five;
import java.util.*;

public class Shelf {
    private List<Item> lst= new ArrayList<Item>();
    public void push(Item item){
        lst.add(item);
    }
    public void print(){
        Collections.sort(lst);
        for (Item i : lst){
            System.out.println(i.getName());
        }
    }
}
