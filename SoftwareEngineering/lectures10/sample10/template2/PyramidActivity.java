package sample10.template2;

public class PyramidActivity extends Activity {
    protected void onStart(){
        System.out.println("PyramidActivity starts.");
    }

    protected void onStop(){
        System.out.println("PyramidActivity stops.");
    }

    protected void onInput(String input) {
        try {
            int height = Integer.parseInt(input);
            int width= height * 2;
            int charNum= 0;
            for (int i= 0; i < height; i++){
                charNum+= 2;
                int spaceNum= (width - charNum) / 2;
                for (int j= 0; j < spaceNum; j++){
                    System.out.print(' ');
                }
                for (int j= 0; j < charNum; j++){
                    System.out.print('#');
                }
                for (int j= 0; j < spaceNum; j++){
                    System.out.print(' ');
                }
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.out.println("Input a number.");
        }
    }
}
