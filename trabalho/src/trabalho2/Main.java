package trabalho2;
import trabalho1.Grafo;
import trabalho1.ListaAdjacencia;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		String file = "C:/Users/analu/OneDrive/Documentos/UFRJ/grafos-cos242/trabalho/src/trabalho2/data/example"
				+ ".txt";
	
		Grafo grafo = new Grafo();
		grafo.getNumVertices(file);
					
		ListaAdjacencia listaAdjacencia = new ListaAdjacencia();
		listaAdjacencia.getListaAdjacencia(grafo, file, false);
		listaAdjacencia.imprimirListaAdjacencia(grafo);
		
		
		System.out.println("Lista de Adjacência");
		//listaAdjacencia.imprimirListaAdjacencia(grafo);		
	
		Distancia distancia = new Distancia();		
		//distancia.dijkstraHeap(grafo,5, 4);
		//distancia.dijkstra(grafo, 10);	
		
		MST mst = new MST();		
		mst.prim(grafo, 1);
	
	}	
}

