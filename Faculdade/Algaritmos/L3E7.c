#include <stdlib.h>

#include <stdio.h>

struct TNoDeNumero {

    int numero;

    struct TNoDeNumero * proximo;

};

struct TNoDeNumero *inicio;

void armazenar(int num){

    struct TNoDeNumero *p, *np;

    if(inicio == NULL){

        np = (struct TNoDeNumero *)malloc(sizeof(struct TNoDeNumero));

        (*np).numero = num;

        (*np).proximo = NULL;

        inicio = np;

    }

    else{

        p = inicio;

        while((*p).proximo != NULL)

            p = (*p).proximo;

        np = malloc(sizeof(struct TNoDeNumero));

        (*np).numero = num;

        (*np).proximo = NULL;

        (*p).proximo = np;

    }

}

void listar(){

    struct TNoDeNumero *p;
    p = inicio;
    while(p != NULL){
        printf("[%d] ", (*p).numero);
        p = (*p).proximo;
    }

}

void mudarLista1(){

    int num1;
    struct TNoDeNumero *l, *l1;
    l1 = (struct TNoDeNumero *)malloc(sizeof(struct TNoDeNumero));
    num1 = (*inicio).numero;
    l = (*inicio).proximo;
    inicio = l;
    while((*l).proximo != NULL){
        l = (*l).proximo;
    }
    (*l).proximo = l1;
    (*l1).numero = num1;
}

struct TNoDeNumero * inicio;

void main(){

    inicio = NULL;

    int num;

for(int i = 0; i < 5; i++){

    scanf("%d", &num);

    armazenar(num);

}

listar();

printf("\n");

mudarLista1();

listar();

}

