#include <stdlib.h>
#include <stdio.h>

struct TNoDeCaractere {
    char caractere;
    struct TNoDeCaractere *proximo;
};
struct TNoDeCaractere *inicio;

void armazenar(char valor) {
    struct TNoDeCaractere *p, *np;

    // Alocação de memória para o novo nó
    np = (struct TNoDeCaractere *)malloc(sizeof(struct TNoDeCaractere));
    if (np == NULL) {
        printf("Erro ao alocar memória.\n");
        exit(1);
    }
    (*np).caractere = valor;
    (*np).proximo = NULL;

    // Inserção no final da lista
    if (inicio == NULL) {
        inicio = np;
    } else {
        p = inicio;
        while ((*p).proximo != NULL) {
            p = (*p).proximo;
        }
        (*p).proximo = np;
    }
}

void remover(char valor) {
    struct TNoDeCaractere *atual, *anterior;
    atual = inicio;
    anterior = NULL;

    while (atual != NULL) {
        if ((*atual).caractere == valor) {
            if (anterior == NULL) { // Remover o primeiro nó
                inicio = (*atual).proximo;
            } else { // Remover um nó intermediário ou final
                (*anterior).proximo = (*atual).proximo;
            }
            free(atual);
            printf("Excluido o caracter: %c\n", valor);
            return;
        }
        anterior = atual;
        atual = (*atual).proximo;
    }
    printf("Caracter %c não encontrado na lista.\n", valor);
}

void mostrar() {
    struct TNoDeCaractere *v;
    v = inicio;
    printf("Lista: ");
    while (v != NULL) {
        printf("%c ", (*v).caractere);
        v = (*v).proximo;
    }
    printf("\n");
}

int main() {
    inicio = NULL;
    char caracter;

    // Inserir 5 caracteres na lista
    for (int i = 0; i < 5; i++) {
        printf("Escreva um caractere: ");
        scanf(" %c", &caracter); // Espaço antes de %c para ignorar '\n'
        armazenar(caracter);
    }

    mostrar();

    // Remover um caractere específico
    char rem = 'c';
    remover(rem);

    mostrar();

    return 0;
}
