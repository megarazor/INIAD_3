package org.iniad.se.sample11.sample2;

public class Fib {
    public static int fib(int n) {
        if(n < 0) {
            throw new UnsupportedOperationException();
        }
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int f= 0, n2= 0, n1= 1;
        while(n >= 2){
            f= n1 + n2;
            n2= n1;
            n1= f;
            n--;
        }
        return f;
    }
}
