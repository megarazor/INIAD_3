public class Quiz {
    public static void main(String[] args) {
        System.out.println(sumAll(args));
    }

    public static String appendAll(String[] args) {
        int n= args.length;
        String res= "";
        for (int i= 0; i < n; i++){
            res+= args[i] + ";";
        }
        return res;
    }

    public static int sumAll(String[] args) {
        int res= 0;
        int n= args.length;
        for (int i= 0; i < n; i++){
            try{
                res+= Integer.parseInt(args[i]);
            }
            catch (NumberFormatException nfe)
            {
                res+= 0;
            }
            
        }
        return res;
    }
}