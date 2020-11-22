import java.time.LocalDate;

public class User {
    private static int idCounter= 1;
    private int id;
    private String firstName;
    private String familyName;
    private LocalDate birthday;

    public User(String firstName, String familyName, LocalDate birthday){
        this.id= idCounter;
        this.firstName= firstName;
        this.familyName= familyName;
        this.birthday= birthday;
        idCounter++;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return String.format("%s %s", familyName, firstName);
    }
    public int getAge(LocalDate when){
        LocalDate today= LocalDate.now();
        int thisYear= today.getYear();
        LocalDate birthdayThisYear= birthday.withYear(thisYear);

        int dif= today.getYear() - birthday.getYear();

        if (today.compareTo(birthdayThisYear) < 0){
            dif-= 1;
        }
        return dif;
    }

}
