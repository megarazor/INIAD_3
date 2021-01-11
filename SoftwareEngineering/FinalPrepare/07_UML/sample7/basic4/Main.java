package sample7.basic4;

import java.time.LocalDate;

public class Main{
    public static void main(String[] args) {
        LocalDate when= LocalDate.parse("2021-01-13");
        User user1 = new User("Enryo", "Inoue", LocalDate.parse("1998-01-13"));
        User user2 = new User("Yukichi", "Fukuzawa", LocalDate.parse("1998-01-14"));
        User user3 = new User("Bruh", "Moment", LocalDate.parse("1980-01-12"));

        System.out.printf("Id : %d \n", user1.getId());
        System.out.printf("Name : %s \n", user1.getName());
        System.out.printf("Age: %d\n", user1.getAge(when));

        System.out.printf("Id : %d \n", user2.getId());
        System.out.printf("Name : %s \n", user2.getName());
        System.out.printf("Age: %d\n", user2.getAge(when));

        System.out.printf("Id : %d \n", user3.getId());
        System.out.printf("Name : %s \n", user3.getName());
        System.out.printf("Age: %d\n", user3.getAge(when));

       

    }
}
