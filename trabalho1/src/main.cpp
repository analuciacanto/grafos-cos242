#include "Grafo.h"

#include <iostream>
#include <vector>
#include <string>
#include <stdio.h>
#include <conio.h>
#include <fstream>
#include <list>
using namespace std;

int main()
{

    Grafo grafo;
    grafo.obterMatrizAdjacencia();

    // Criando um arquivo de saída
    ofstream dataOut;

    dataOut.open("result.txt");

    // Escreve no arquivo
    dataOut
        << "Número de vértices: "
        << "";
    dataOut
        << "Número de arestas: "
        << "";
    dataOut
        << "Grau mínimo: "
        << "";
    dataOut
        << "Grau máximo: "
        << "";
    dataOut
        << "Mediana do grau: "
        << "";
    dataOut
        << "Mediana do grau: "
        << "";

    // Fecha o arquivo
    dataOut.close();

    return 0;
}
