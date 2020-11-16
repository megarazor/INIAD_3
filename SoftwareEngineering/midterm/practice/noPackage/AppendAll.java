public class AppendAll {
    public static void main(String[] args) {
        System.out.println(appendAll(args));
    }

    public static String appendAll(String[] args) {
        StringBuffer sb= new StringBuffer("");
        for (String s : args){
            sb.append(s);
            sb.append(";");
        }
        return sb.toString();
    }
}