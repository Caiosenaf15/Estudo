#include <stdlib.h>
#include <stdio.h>

struct TNoDeCaractere{
    char caractere;
    struct TNoDeCaractere *proximo;
};

struct TNoDeCaractere *inicio = NULL;

void inserir(char valor){
    struct TNoDeCaractere *p, *np, *pp;
    np = (struct TNoDeCaractere *)malloc(sizeof(struct TNoDeCaractere));
    if(np == NULL){
        printf("Erro ao alocar memoria");
        exit(1);
    }

    (*np).caractere = valor;
    (*np).proximo = inicio;
    inicio = np;

}

void excluir(){
    struct TNoDeCaractere *e, *ae;
    e = inicio;
    while((*e).proximo != NULL){
        ae = e;
        e = (*e).proximo;
    }
    (*e).caractere = NULL;
    (*ae).proximo = NULL;
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
    char aux;
    for(int i = 0; i < 5; i++){
        scanf(" %c", &aux);
        inserir(aux);
    }
    mostrar();
    excluir();
    printf("\n");
    mostrar();
}
