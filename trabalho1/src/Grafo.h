
#ifndef GRAFO_H
#define GRAFO_H

#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <iostream>
#include <fstream>
#include <vector>
#include <tuple>

using namespace std;

typedef vector<vector<string>> Arestas;
typedef vector<string> Aresta;
typedef int **Matriz;
typedef int **Lista;

typedef struct No
{
    int vertice;
    struct No *proximoElemento;
} No;

typedef struct ListaAdjacencia
{
    No *inicio;
    int tamanho;

} ListaAdjacencia;

class Grafo
{
private:
    int maxVertices;
    Arestas arestas;
    ListaAdjacencia listaAdjacencia;
    Matriz matrizAdjacencias;

public:
    // Construtor
    Grafo();
    void obterMatrizAdjacencia();
    void obterListaAdjacencia();
    void imprimirListaAdjacencia();
    tuple<int, Arestas> lerArquivo();
};
#endif
