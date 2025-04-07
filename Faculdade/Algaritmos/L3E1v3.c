#include <stdio.h>
#include <stdlib.h>

struct TNoDeCaractere{
    char caractere;
    struct TNoDeCaractere *proximo;

};
struct TNoDeCaractere *inicio = NULL;

void inserir(char valor){
    struct TNoDeCaractere *p, *np;

    np = (struct TNoDeCaractere *)malloc(sizeof(struct TNoDeCaractere));
    if(np == NULL){
        printf("Erro ao alocar memoria\n");
        exit(1);
    }

    (*np).caractere = valor;
    (*np).proximo = NULL;

    if(inicio == NULL){
        inicio = np;
    } else {
        p = inicio;
        while((*p).proximo != NULL){
            p = (*p).proximo;
        }
        (*p).proximo = np;
    }
}

void excluir(){
    struct TNoDeCaractere *e;
    struct TNoDeCaractere *pe;
    e = inicio;
    while((*e).proximo != NULL){
        pe = e;
        e = (*e).proximo;
    }
    (*e).caractere = NULL;
    (*pe).proximo = NULL;

}

void ignorarPrimeiro(){
    inicio = (*inicio).proximo;

}

void mostrar(){
    struct TNoDeCaractere *m;

    m = inicio;

    while(m != NULL){
        printf("[%c]", (*m).caractere);
        m = (*m).proximo;
    }
}

void main(){
    char valor;
    for(int i = 0; i < 4; i++){
        scanf(" %c", &valor);
        inserir(valor);
    }
    mostrar();
    //excluir();
    printf("\n");
    //ignorarPrimeiro();
    mostrar();

}
