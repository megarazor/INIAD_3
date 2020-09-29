import java.util.Random;
import java.util.Scanner;

public class Janken {
    private static int getRandomInt(int min, int max) {
		Random n = new Random();
		return n.nextInt((max - min) + 1) + min;
	}
    public static void main(String[] args) {
        System.out.println("あなたの手？０：グー、１：チョキ、２：パー");
        Scanner in= new Scanner(System.in);
        try {
            int user_janken= Integer.valueOf(in.nextLine());
            int comp_janken= getRandomInt(0, 2);
            System.out.printf("あなた：%d\n", user_janken);
            System.out.printf("コンピュータ：%d\n", comp_janken);
            if (user_janken == comp_janken){
                System.out.println("引き分け");
            }
            else if (user_janken == 0){
                if (comp_janken == 1){
                    System.out.println("あなたの勝");
                }
                else {
                    System.out.println("コンピュータの勝");
                }
            }
            else if (user_janken == 1){
                if (comp_janken == 0){
                    System.out.println("コンピュータの勝");
                }
                else {
                    System.out.println("あなたの勝");
                }
            }
            else if (user_janken == 2) {
                if (comp_janken == 0){
                    System.out.println("あなたの勝");
                }
                else {
                    System.out.println("コンピュータの勝");
                }
            }
            else {
                System.out.println("０〜２を入力してください");
            }

        } catch(NumberFormatException ex){
            System.out.printf("Integerを入力してください\n");
        }        
        
    }
}
