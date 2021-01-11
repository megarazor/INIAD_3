package sample7.basic4;

import java.time.LocalDate;

public class User {
    private static int idCounter = 1;

    private int id;
    private String firstName;
    private String familyName;
    private LocalDate birthday;

    public User(String firstName, String familyName, LocalDate birthday) {
        this.id = idCounter;
        this.firstName = firstName;
        this.familyName = familyName;
        this.birthday= birthday;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return String.format("%s %s", familyName, firstName);
    }

    public int getAge(LocalDate when){
        if (when.compareTo(birthday) <= 0){
            return 0;
        }
        int yearDif= when.getYear() - birthday.getYear();

        LocalDate birthdayThisYear= birthday.plusYears((long) yearDif);

        // System.out.println(birthdayThisYear);
        // System.out.println(when);

        if (when.compareTo(birthdayThisYear) < 0){
            return yearDif - 1;
        }
        else{
            return yearDif;
        }
    }
}
