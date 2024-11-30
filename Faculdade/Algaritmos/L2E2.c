#include <stdio.h>
#include <stdlib.h>

int buscarNaLista(int *lista, int n, int x){
    for(int i = 0; i < n; i++){
        printf("%d\n",i);
        if(lista[i] == x){
            printf("Aqui\n");
            return i;
        } if(lista[i] > x) {
            return -2;
        } if(lista[i] = NULL){
            printf("Entrou\n");
            return -1;
        }
    }

}

void main(){
    int *l;
    int n = 4;
    int numero = 5;
    l = (int*)malloc(sizeof(int[n]));
    l[0] = 1;
    l[1] = 4;
    l[2] = 5;
    l[3] = 9;
    printf("O numero esta na posicao: %d", buscarNaLista(&l,n,numero));
}
