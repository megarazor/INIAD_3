package five;

public class Main {
    public static void main(String[] args) {
        Shelf shelf = new Shelf();
        shelf.push(new Item("INIAD"));
        shelf.push(new Item("TOYO"));
        shelf.push(new Item("AKABNE"));
        shelf.print();
    }
}