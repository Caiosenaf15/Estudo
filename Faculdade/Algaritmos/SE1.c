#include <stdio.h>
#include <stdlib.h>

typedef struct TCharNode {
    int pos; // Posi��o do n� na string
    char inf; // Caractere presente no n�
    struct TCharNode *nxt; // Ponteiro para o pr�ximo n�
} charNode;

typedef struct TStr {
    charNode *fst; // Ponteiro para o primeiro n� da string
    charNode *lst; // Ponteiro para o �ltimo n� da string
    int len; // Comprimento da string
} str;

// Fun��o para inicializar a string
void initStr(str *s) {
    (*s).fst = NULL;  // Nenhum n� inicial
    (*s).lst = NULL;  // Nenhum n� final
    (*s).len = 0;     // Comprimento da string � 0
}

// Fun��o para exibir a string armazenada na lista encadeada
void showStr(str *s) {
    charNode *temp = (*s).fst;
    while (temp != NULL) {
        printf("%c", (*temp).inf);
        temp = (*temp).nxt;
    }
    printf("\n");
}

// Fun��o para adicionar um caractere ao final da string
void addChar(str *s, char c) {
    charNode *newNode = (charNode *)malloc(sizeof(charNode));
    if (newNode == NULL) {
        printf("Erro ao alocar mem�ria\n");
        exit(1);
    }

    (*newNode).inf = c;
    (*newNode).pos = (*s).len;  // Posi��o do n� na string
    (*newNode).nxt = NULL;

    if ((*s).fst == NULL) {
        // Se a lista est� vazia, o novo n� � o primeiro e o �ltimo
        (*s).fst = newNode;
        (*s).lst = newNode;
    } else {
        // Caso contr�rio, adiciona ao final
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
