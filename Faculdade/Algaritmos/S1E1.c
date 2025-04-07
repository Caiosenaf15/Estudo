#include <stdio.h>
#include <stdlib.h>

typedef struct TCharNode{
    int pos;
    char inf;
    struct TCharNode *nxt;
} charNode;

typedef struct TStr{
    charNode *fst;
    charNode *lst;
    int len;
} str;

void initStr(str *s){
    (*s).fst = NULL;
    (*s).lst = NULL;
    (*s).len = 0;
}

void getStr(str *s){
    char aux = NULL;
    while(aux != )
}

void freeStr(str *s) {
    charNode *temp = (*s).fst;
    while (temp != NULL) {
        charNode *next = (*temp).nxt; // Guarda referência do próximo nó
        free(temp); // Libera o nó atual
        temp = next; // Move para o próximo nó
    }
    (*s).fst = NULL;
    (*s).lst = NULL;
    (*s).len = 0;
}

void main(){

}
