public class Bmi {
    public static void printRisk(int age, double h, double w) {
        double bmi= w / (h * h);
        if (bmi < 22.0){
            if (age < 45){
                System.out.println("Low");
            }
            else{
                System.out.println("Medium");
            }
        }
        else {
            if (age < 45){
                System.out.println("Medium");
            }
            else {
                System.out.println("High");
            }
        }
    }

    public static void main(String[] args) {
        int age = 30;
        double h = 170.0;
        double w = 70.0;

        printRisk(age, h, w);
    }
}