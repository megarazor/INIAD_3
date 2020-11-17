public class One {
    public static void main(String[] args) {
        System.out.println(product(args));
    }

    public static int product(String[] args) {
        int res= 1;
        for (String s : args){
            try{
                res*= Integer.parseInt(s);
            }
            catch (NumberFormatException e){
                return 0;
            }
        }
        return res;
    }
}