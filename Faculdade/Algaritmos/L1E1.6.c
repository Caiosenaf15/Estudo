#include <stdio.h>
#include <stdlib.h>

void main(){
    int num;
    printf("Insira um numero: ");
    scanf("%i", &num);
    int n = 1;
    int aux = 1;
    int f;
    for(int i = 0; i < num-2; i++){
        f = n + aux;
        aux = n;
        n = f;
    }
    printf("%i", f);
}
