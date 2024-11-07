#include <stdlib.h>
#include <stdio.h>

    void main(){
        int num;
        printf("Insira um numero: ");
        scanf("%i", &num);
        int fat = 1;
        for(int i = 1; i <=  num; i++){
            fat = fat * i;
        }
        printf("O fatorial de %i e: %i", num, fat);
    }
