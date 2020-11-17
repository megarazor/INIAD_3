package five;

public class Item implements Comparable<Item>{
    private String name;
    public Item(String name){
        this.name= name;
    }
    public String getName(){
        return name;
    }
    public int compareTo(Item i){
        return name.compareTo(i.name);
    }
}
