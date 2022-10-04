
#include "grafo.h"
#include "utils.cpp"
#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <tuple>

using namespace std;

typedef string TipoItem;

Grafo::Grafo()
{
    tie(maxVertices, arestas) = lerArquivo();
    matrizAdjacencias = new int *[maxVertices];
    listaAdjacencia.inicio = NULL;
    listaAdjacencia.tamanho = 0;
}

void Grafo::imprimirListaAdjacencia()
{
    No *inicio = listaAdjacencia.inicio;
    while (inicio != NULL)
    {
        printf("%d", inicio->vertice);
        inicio = inicio->proximoElemento;
    }
}

void Grafo::obterListaAdjacencia()
{
    No *primeiroNo = (No *)malloc(sizeof(No)); // Criando um ponteiro com alocação dinâmica de memória.
    primeiroNo->vertice = 1;
    primeiroNo->proximoElemento = NULL;

    listaAdjacencia.inicio = primeiroNo;

    // Inserir os vertices

    for (Aresta aresta : arestas)
    {
        if (stol(aresta[0]) == 1)
        {
            No *novoNo = (No *)malloc(sizeof(No));
            novoNo->vertice = stol(aresta[1]);
            primeiroNo->proximoElemento = novoNo;
            listaAdjacencia.inicio = novoNo;
        }
        if (stol(aresta[1]) == 1)
        {
            No *novoNo = (No *)malloc(sizeof(No));
            novoNo->vertice = stol(aresta[0]);
            primeiroNo->proximoElemento = novoNo;
            listaAdjacencia.inicio = novoNo;
        }
    }
    imprimirListaAdjacencia();
}

void Grafo::obterMatrizAdjacencia()
{
    // Criando uma matriz
    for (int i = 0; i < maxVertices; i++)
    {
        matrizAdjacencias[i] = new int[maxVertices];
    }

    // Preenchendo a matriz
    for (int i = 0; i < maxVertices; i++)
    {
        for (int j = 0; j < maxVertices; j++)
        {
            matrizAdjacencias[i][j] = 0;
        }
    }

    for (Aresta aresta : arestas)
    {
        matrizAdjacencias[stol(aresta[0]) - 1][stol(aresta[1]) - 1] = 1;
        matrizAdjacencias[stol(aresta[1]) - 1][stol(aresta[0]) - 1] = 1;
    }

    // Imprimindo a matriz
    cout << "Matriz de adjacencias: \n";
    for (int i = 0; i < maxVertices; i++)
    {
        for (int j = 0; j < maxVertices; j++)
        {
            cout << matrizAdjacencias[i][j] << " ";
        }
        cout << endl;
    }
}

tuple<int, Arestas> Grafo::lerArquivo()
{
    ifstream data;
    data.open("teste.txt");

    string line;
    int numVertices;

    int i = 0;
    Arestas arestas;

    if (data.is_open())
    {
        while (getline(data, line))
        {
            if (i == 0)
            {
                numVertices = stol(line);
            }
            else
            {
                // Separando as strings
                vector<string> aresta = splitString(line, ' ');
                arestas.push_back(aresta);
            }
            i++;
        }
        data.close();
    }
    else
    {
        cout << "Não foi possível abrir o arquivo" << endl;
    }

    return make_tuple(numVertices, arestas);
};
