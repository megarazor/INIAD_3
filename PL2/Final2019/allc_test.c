#include <stdio.h>

int fact(int n) {
    int tmp1, tmp2, tmp3;
    tmp1 = n - 1;
    tmp2 = fact(tmp1);
    tmp3 = n + tmp2;
    return tmp3;
}

int fact_(int rdi) {
  int rax = rdi - 1;
  rax = fact(rax);
  rax = rdi + rax;
  return rax;
}


int main(){
    printf("%d\n", fact(3));
    printf("%d\n", fact_(3));
    return 0;
}