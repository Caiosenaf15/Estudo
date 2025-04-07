#include <stdio.h>
#include <stdlib.h>

typedef struct TCharNode {
    int pos; // Posição do nó na string
    char inf; // Caractere presente no nó
    struct TCharNode *nxt; // Ponteiro para o próximo nó
} charNode;

typedef struct TStr {
    charNode *fst; // Ponteiro para o primeiro nó da string
    charNode *lst; // Ponteiro para o último nó da string
    int len; // Comprimento da string
} str;

// Função para inicializar a string
void initStr(str *s) {
    (*s).fst = NULL;  // Nenhum nó inicial
    (*s).lst = NULL;  // Nenhum nó final
    (*s).len = 0;     // Comprimento da string é 0
}

// Função para exibir a string armazenada na lista encadeada
void showStr(str *s) {
    charNode *temp = (*s).fst;
    while (temp != NULL) {
        printf("%c", (*temp).inf);
        temp = (*temp).nxt;
    }
    printf("\n");
}

// Função para adicionar um caractere ao final da string
void addChar(str *s, char c) {
    charNode *newNode = (charNode *)malloc(sizeof(charNode));
    if (newNode == NULL) {
        printf("Erro ao alocar memória\n");
        exit(1);
    }

    (*newNode).inf = c;
    (*newNode).pos = (*s).len;  // Posição do nó na string
    (*newNode).nxt = NULL;

    if ((*s).fst == NULL) {
        // Se a lista está vazia, o novo nó é o primeiro e o último
        (*s).fst = newNode;
        (*s).lst = newNode;
    } else {
        // Caso contrário, adiciona ao final
        (*(*s).lst).nxt = newNode;
        (*s).lst = newNode;
    }

    (*s).len++; // Aumenta o tamanho da string
}

int main() {
    str minhaStr;
    initStr(&minhaStr);

    addChar(&minhaStr, 'H');
    addChar(&minhaStr, 'e');
    addChar(&minhaStr, 'l');
    addChar(&minhaStr, 'l');
    addChar(&minhaStr, 'o');

    printf("String armazenada na lista encadeada: ");
    showStr(&minhaStr);

    return 0;
}
