package sample10.template2;

public class PyramidActivity extends Activity{
    protected void onStart() {
        System.out.println("PyramidActivity starts.");
    }

    protected void onStop() {
        System.out.println("PyramidActivity stops.");
    }
    
    protected void onInput(String input) {
        try{
            int height= Integer.parseInt(input);
            int width= height * 2;
            for (int i= 1; i <= height; i++){
                for (int j= 0; j < (width - i * 2) / 2; j++){
                    System.out.print(" ");
                }
                for (int j= 0; j < i * 2; j++){
                    System.out.print("#");
                }
                for (int j= 0; j < (width - i * 2) / 2; j++){
                    System.out.print(" ");
                }
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.out.println("Input a number.");
        }
    }
}
