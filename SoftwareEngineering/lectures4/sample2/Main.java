package sample2;

public class Main {
    public static void main(String[] args) {
        Student st = new Student("1234", "Taro", 10);
        System.out.println(st.getProfile());
        Teacher te = new Teacher("1", "Bruh", "Asso. Prof.");
        System.out.println(te.getProfile());
    }
}