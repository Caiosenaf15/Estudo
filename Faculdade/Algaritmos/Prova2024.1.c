#include <stdlib.h>
#include <stdio.h>

struct TPilha
{
int * valores;
int tamanho;
};

int bubbleSort(TPilha *p){
    int aux;
    int cont = 0;
    while(cont != (*p).tamanho){
        for(int i = 0; i < (*p).tamanho; i++){
            if((*p).valores[i] > (*p).valores[i+1]){
                aux = (*p).valores[i];
                (*p).valores[i] = (*p).valores[i+1];
                (*p).valores[i+1] = aux;
            } else cont++;
        }
    }
}

void criarPilha (TPilha *p);
int buscarNaPilha (TPilha p, int x);

int inserirNaPilha (TPilha *p, int x){
    if(buscarNaPilha(p, x) != -1)
        return 0; //o elemento ja existe
    else{
    if((*p).tamanho == 0){
        (*p).valores = (int*)malloc(sizeof(int));
    } else{
        (*p).valores = realloc((*p).valores, (*p).tamanho + 1);
    }
    (*p).valores[(*p).tamanho] = x;
    (*p).tamanho = (*p).tamanho + 1;
    return 1;
    }
}

int excluirDaPilha (TPilha *p){
    if((*p).tamanho > 0){
        (*p).valores[(*p).tamanho] = NULL;
        (*p).valores = realloc((*p).valores, (*p).tamanho - 1);
        (*p).tamanho = (*p).tamanho - 1;
        if((*p).tamanho == 0) (*p).valores == NULL;
    } else return -1;
}
void eliminarPilha (TPilha *p);
void imprimirPilha (TPilha p);

void criarPilha(TPilha *p)
{
(*p).valores = NULL;
(*p).tamanho = 0;
}

int buscarNaPilha(TPilha p, int x)
{
int i, busca;
busca = -1; //flag para erro
for (i=0; i <= p.tamanho-1; i = i + 1)
if (p.valores[i] == x)
{
busca = i;
break;
}
return busca;
}
void eliminarPilha(TPilha *p)
{
    (*p).tamanho = 0;
    free((*p).valores);
    (*p).valores = NULL;
}
void imprimirPilha(TPilha p)
{
int i;
for(i = 0; i < p.tamanho; i++)
printf("%d ", p.valores[i]);
}
