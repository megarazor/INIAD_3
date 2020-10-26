import java.util.ArrayList; 

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Human> myList= new ArrayList<Human>();
        Human a= new Human("Alice");
        Human b= new Human("Bob");
        myList.add(a);
        myList.add(b);
        System.out.println(myList.get(0).getName());
        System.out.println(myList.get(1).getName());
    }
}
