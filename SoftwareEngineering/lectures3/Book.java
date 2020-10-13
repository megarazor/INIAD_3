public class Book {
    private String name;
    private Author author;
    private int price;
    public Book(String name, Author author){
        this.name= name;
        this.author= author;
        this.price= 0;
    }
    public Book(String name, Author author, int price){
        this.name= name;
        this.author= author;
        this.price= price;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author.toString();
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int newPrice){
        price= newPrice;
    }    
}
