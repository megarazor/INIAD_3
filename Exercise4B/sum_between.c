#include <stdio.h>

int sum_between(int x, int y){
    if (x > y){
        int tmp= x;
        x= y;
        y= tmp;
    }
    int sum= 0;
    for (int i= x; i <= y; i ++){
        sum+= i;
    }
    return sum;
}

int main(){
    printf("%d\n", sum_between(10, 12));
    return 0;
}
