public class NameCard {
    private final String firstName;
    private final String familyName;
    private static int nameCardCount= 1;
    private final int id;
    public NameCard(String firstName, String familyName){
        this.firstName= firstName;
        this.familyName= familyName;
        this.id= nameCardCount;
        nameCardCount+= 1;
    }
    public String getLabel(){
        return "No. " + Integer.toString(this.id) + ": " + this.firstName + " " + this.familyName;
    }

}
