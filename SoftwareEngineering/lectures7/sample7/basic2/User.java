package sample7.basic2;

public class User {
    String firstName;
    String familyName;

    User(String firstName, String familyName) {
        this.firstName = firstName;
        this.familyName = familyName;
    }

    String getName() {
        return String.format("%s %s", familyName, firstName);
    }
}