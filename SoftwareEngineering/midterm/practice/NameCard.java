public class NameCard{
    private final String firstName;
    private final String familyName;
    private final int id;
    private static int idCounter= 1;
    NameCard (String firstName, String familyName){
        this.firstName= firstName;
        this.familyName= familyName;
        id= idCounter;
        idCounter+= 1;
    }

    public String getLabel(){
        return "No. " + id + ": " + firstName + " " + familyName;
    }

    public static void main(String[] args) {
        NameCard n1 = new NameCard("Taro", "Yamada");
        NameCard n2 = new NameCard("Jiro", "Tanaka");
        System.out.println(n1.getLabel());
        System.out.println(n2.getLabel());
    }

}
