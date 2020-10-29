package sample1;

import sample1.pkg2.EngineeringStudent;
import sample1.pkg2.EngineeringTeacher;
import sample1.pkg1.Programmer;

public class Main {
    public static void main(String[] args) {
        EngineeringStudent st= new EngineeringStudent("1234", "Taro", 1);
        EngineeringTeacher pr= new EngineeringTeacher("1", "Bruh", "Assoc. Prof.");

        System.out.printf(st.getProfile());
        checkSkill(st);

        System.out.printf(pr.getProfile());
        checkSkill(pr);
    }

    private static void checkSkill(Programmer p){
        if (p.canWritePython()){
            System.out.println("I can write Python.");
        }
        if (p.canWriteC()){
            System.out.println("I can write C.");
        }
        if (p.canWriteJava()){
            System.out.println("I can write Java.");
        }
    }
}