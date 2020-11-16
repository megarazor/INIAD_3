public class SumAll {
    public static void main(String[] args) {
        System.out.println(sumAll(args));
    }

    public static int sumAll(String[] args) {
        int sum= 0;
        for (String s : args){
            try{
                sum+= Integer.parseInt(s);
            }
            catch (NumberFormatException e){
                return 0;
            }
        }
        return sum;
    }
}