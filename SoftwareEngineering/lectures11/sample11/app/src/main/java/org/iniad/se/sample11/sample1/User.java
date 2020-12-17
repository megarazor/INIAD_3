package org.iniad.se.sample11.sample1;

import java.time.LocalDate;

public class User {
    private String firstName;
    private String familyName;
    private LocalDate birthday;

    public User(String firstName, String familyName, LocalDate birthday) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getName() {
        return String.format("%s %s", firstName, familyName);
    }

    public int getAge(LocalDate when) {
        return birthday.until(when).getYears();
    }
}