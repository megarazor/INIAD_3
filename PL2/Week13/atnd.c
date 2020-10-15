// int add_five_num(int a, int b, int c, int d, int e){
//    return a + b + c + d + e;
// }

int add_five_num(int a, int b, int c, int d, int e){
    int tmp1 = a + b;
    int tmp2 = tmp1 + c;
    int tmp3 = tmp2 + d;
    int tmp4 = tmp3 + e;
    return tmp4;
}

// a = 10
// b = 9
// b += 1
// a =  a + b

a0= 10;
b0= 9;
b1= b0 + 1;
a1= a0 + b1;