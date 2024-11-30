#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void criarLista(int ***l, int n)
{
  int i;
  *l = (int **)malloc(sizeof(int*[n]));

  if (*l == NULL) { // Verifica se a alocação foi bem-sucedida
        fprintf(stderr, "Erro ao alocar memória - FUNÇÃ0 criarLista\n");
        exit(1); // Encerra o programa com erro
    }

  for(i=0; i < n; i = i+1)
    (*l)[i] = NULL;
}

void limparLista(int ***l, int n)
{
  int i;
  for(i=0; i < n; i = i+1)
    if ((*l)[i] != NULL)
    {
      free((*l)[i]);
      (*l)[i] = NULL; // Previne o uso de ponteiro pendente
    }
  if (*l != NULL)
  {
      free(*l);
      *l = NULL; // Previne o uso de ponteiro pendente
  }
}

int elementosNaLista(int ** l, int n)
{
  int i;
  for(i=0; i < n; i = i+1)
    if (l[i] == NULL) break;
  return i;
}

int  buscarNaLista(int ** l, int n, int x)
{
  int i, busca;
  busca = -1; //flag para erro
  for (i=0; i < n; i = i+1)
  {
    if (l[i] == NULL) break;
    else if (*(l[i]) == x)
         {
           busca = i;
           break;
         }
  }

  return busca;
}

int inserirNaLista(int ** l, int n, int x)
{
  int i, M;
  M = elementosNaLista(l,n);
  if (M<n)
    if (buscarNaLista(l, n, x)  == -1)
    {
       l[M] = (int *)malloc(sizeof(int));

       if (l[M] == NULL) { // Verifica se a alocação foi bem-sucedida
        fprintf(stderr, "Erro ao alocar memória - FUNÇÃ0 inserirNaLista\n");
        exit(1); // Encerra o programa com erro
       }

      *l[M] = x;
      return 1;
    }
    else return 0; //Elemento já existe
  else return -1; //Overflow
}

int excluirDaLista(int ** l, int n, int x)
{
  int i, indice, M;
  M = elementosNaLista(l,n);
  if (M != 0)
  {
    indice = buscarNaLista(l, n, x);
    if (indice != -1)
    {
      if (indice == n-1)
      {
        free(l[indice]);
        l[indice] = NULL; // Previne o uso de ponteiro pendente
      }
      else {
             for (i = indice; i < M; i = i+1) l[i] = l[i+1];
             l[M-1] = NULL;
           }
      return 1;
    }
    else return 0; //Elemento não encontrado
  }
  else return -1; //Underflow
}

void imprimirLista(int ** l, int n)
{
  int i, M;
  for (i = 0; i < n; i = i+1)
    if (l[i] == NULL)
      printf("NULL\n");
    else printf("%d\n", *(l[i]));
  printf("\n");
}

int main()
{
  int N, **lista, i, opcao, chave;

  setlocale(LC_ALL, "Portuguese");

  lista = NULL;

  printf("Tamanho da lista: ");
  scanf("%d", &N);

  criarLista(&lista, N);

  do
  {
    system ("CLS");

    printf("Menu de Opções\n\n");
    printf("1 - INCLUIR\n");
    printf("2 - EXCLUIR\n");
    printf("3 - IMPRIMIR\n");
    printf("4 - SAIR\n\n");
    printf("Entre sua Opção: ");
    scanf("%d", &opcao);
    switch(opcao)
    {
      case 1: if (elementosNaLista(lista, N) != N)
              {
                printf("Entre o elemento a ser incluído: ");
                scanf("%d", &chave);
                switch(inserirNaLista(lista, N, chave))
                {
                  case  0: printf("Elemento já existente. Inserção não realizada.\n\n"); break;
                  case -1: printf("Cenário de overflow. Inserção não realizada.\n\n"); break;
                }
              }
              else printf("Cenário de overflow. Inserção não realizada.\n\n");
              break;
      case 2: if (elementosNaLista(lista, N) != 0)
              {
                printf("Entre o elemento a ser excluído: ");
                scanf("%d", &chave);
                switch(excluirDaLista(lista, N, chave))
                {
                  case  0: printf("Elemento não encontrado. Exclusão não realizada.\n\n"); break;
                  case -1: printf("Cenário de underflow. Exclusão não realizada.\n\n"); break;
                }
              }
              else printf("Cenário de underflow. Exclusão não realizada.\n\n");
              break;
      case 3: printf("ELEMENTOS DA LISTA:\n");
              imprimirLista(lista, N);
              break;
    }
    system("PAUSE");
  } while (opcao != 4);

  limparLista(&lista, N);

  return 0; // Retorna 0 indicando sucesso
}
