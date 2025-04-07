#include <stdlib.h>
#include <stdio.h>

struct TNoDeCaractere{
    char caractere;
    struct TNoDeCaractere *proximo;
};
struct TNoDeCaractere *inicio;
void inserir(char carac){
    struct TNoDeCaractere *p, *np;
    if(inicio == NULL){
        np = (struct TNoDeCaractere *)malloc(sizeof(struct TNoDeCaractere));
        (*np).caractere = carac;
        (*np).proximo = NULL;
        inicio = np;
    }
    else{
        p = inicio;
        while((*p).proximo != NULL)
            p = (*p).proximo;
        np = malloc(sizeof(struct TNoDeCaractere));
        (*np).caractere = carac;
        (*np).proximo = NULL;
        (*p).proximo = np;
    }
}

void listar(){
    struct TNoDeCaractere *l;
    l = inicio;
    while(l != NULL){
        printf("[%c] ", (*l).caractere);
        l = (*l).proximo;
    }
}

void main(){
    inicio = NULL;
    char carac;

    for(int i = 0; i < 6; i++){
        scanf("%c", &carac);
        inserir(carac);
    }
    listar();

}
