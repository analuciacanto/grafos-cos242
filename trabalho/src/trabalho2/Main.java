package trabalho2;

import trabalho1.Grafo;
import trabalho1.ListaAdjacencia;
public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		//Criando a lista de adjacencia
		
		String file = "C:/Users/analu/OneDrive/Documentos/UFRJ/grafos-cos242/trabalho/src/trabalho2/example"
				+ ".txt";
		Grafo grafo = new Grafo();
		grafo.getNumVertices(file);
		

		ListaAdjacencia listaAdjacencia = new ListaAdjacencia();
		listaAdjacencia.getListaAdjacencia(grafo, file);
		listaAdjacencia.imprimirListaAdjacencia(grafo);
		
		Distancia distancia = new Distancia();
		distancia.dijkstra(grafo,1);
	}	
}

