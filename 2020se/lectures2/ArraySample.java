public class ArraySample {
    public static void main(String[] args) {
        int[] array1 = {1, -2, 3, 4, -5};
        int result = positive(array1);
        System.out.println(result);

        String[] array2 = {"Information", "Networking", "for", "Innovation", "And", "Design"};
        printOdd(array2);
    }
		
    public static int positive(int[] array) {
        int sum= 0;
        for (int x : array){
            if (x > 0){
                sum+= x;
            }
        }
        return sum;
    }
    
    public static void printOdd(String[] array) {
        for (String s : array){
            if (s.length() % 2 == 1){
                System.out.println(s);
            }
        }     
    }
}