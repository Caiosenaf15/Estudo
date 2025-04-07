#include <stdio.h>
#include <stdlib.h>

// Definição das structs fornecidas
typedef struct TCharNode {
    int pos; // Posição do caractere na string
    char inf; // Caractere armazenado
    struct TCharNode *nxt; // Ponteiro para o próximo nó
} charNode;

typedef struct TStr {
    charNode *fst; // Ponteiro para o primeiro nó da string
    charNode *lst; // Ponteiro para o último nó da string
    int len; // Comprimento da string
} str;

// a) Função initStr: inicializa uma string vazia
void initStr(str *s) {
    (*s).fst = NULL;
    (*s).lst = NULL;
    (*s).len = 0;
}

// b) Função freeStr: libera a memória alocada para a string
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

// c) Função getStr: lê uma string do teclado e armazena em uma lista encadeada
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

// d) Função printStr: imprime todos os caracteres armazenados na string
void printStr(str s) {
    charNode *current = s.fst;
    while (current != NULL) {
        printf("%c", (*current).inf);
        current = (*current).nxt;
    }
    printf("\n");
}

// Função principal para testar as funções
int main() {
    str s;
    initStr(&s);
    getStr(&s);
    printf("Seu texto:\n");
    printStr(s);
    freeStr(&s);
    return 0;
}
