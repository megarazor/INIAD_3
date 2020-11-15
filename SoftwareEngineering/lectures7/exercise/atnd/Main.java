import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String... args){
        List<Student> lst= new ArrayList<Student>();
        lst.add(new Student("Bob"));
        lst.add(new Student("Alice"));

        for (Student s:lst){
            System.out.println(s.getName());
        }      
    }
}
