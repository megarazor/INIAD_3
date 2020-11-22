import java.time.LocalDate;

public class Test {
    public static void main(String... args){
        User u1= new User("Bruh", "Moment", LocalDate.parse("1998-01-13"));
        User u2= new User("Bruh", "afnt", LocalDate.parse("1998-01-01"));
        User u3= new User("Bruh", "ADFment", LocalDate.parse("1998-12-23"));
        LocalDate ld= LocalDate.now();
        System.out.printf("%s is %d years old\n", u1.getName(), u1.getAge(ld));
        System.out.printf("%s is %d years old\n", u2.getName(), u2.getAge(ld));
        System.out.printf("%s is %d years old\n", u3.getName(), u3.getAge(ld));
    }
}
