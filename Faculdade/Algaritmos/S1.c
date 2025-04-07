#include <stdio.h>
#include <stdlib.h>

// Defini��o das structs fornecidas
typedef struct TCharNode {
    int pos; // Posi��o do caractere na string
    char inf; // Caractere armazenado
    struct TCharNode *nxt; // Ponteiro para o pr�ximo n�
} charNode;

typedef struct TStr {
    charNode *fst; // Ponteiro para o primeiro n� da string
    charNode *lst; // Ponteiro para o �ltimo n� da string
    int len; // Comprimento da string
} str;

// a) Fun��o initStr: inicializa uma string vazia
void initStr(str *s) {
    (*s).fst = NULL;
    (*s).lst = NULL;
    (*s).len = 0;
}

// b) Fun��o freeStr: libera a mem�ria alocada para a string
void freeStr(str *s) {
    charNode *current = (*s).fst;
    while (current != NULL) {
        charNode *temp = current;
        current = (*current).nxt;
        free(temp);
    }
    (*s).fst = NULL;
    (*s).lst = NULL;
    (*s).len = 0;
}

// c) Fun��o getStr: l� uma string do teclado e armazena em uma lista encadeada
void getStr(str *s) {
    freeStr(s);  // Reseta qualquer valor existente
    char c;
    int pos = 0;
    printf("Digite o texto (pressione ENTER para finalizar):\n");
    while (1) {
        scanf("%c", &c);
        if (c == '\n') break;  // Finaliza a leitura ao encontrar ENTER

        charNode *newNode = (charNode *)malloc(sizeof(charNode));
        (*newNode).inf = c;
        (*newNode).pos = pos++;
        (*newNode).nxt = NULL;

        if ((*s).fst == NULL) {
            (*s).fst = newNode;
            (*s).lst = newNode;
        } else {
            (*(*s).lst).nxt = newNode;
            (*s).lst = newNode;
        }
        (*s).len++;
    }
}

// d) Fun��o printStr: imprime todos os caracteres armazenados na string
void printStr(str s) {
    charNode *current = s.fst;
    while (current != NULL) {
        printf("%c", (*current).inf);
        current = (*current).nxt;
    }
    printf("\n");
}

// Fun��o principal para testar as fun��es
int main() {
    str s;
    initStr(&s);
    getStr(&s);
    printf("Seu texto:\n");
    printStr(s);
    freeStr(&s);
    return 0;
}
