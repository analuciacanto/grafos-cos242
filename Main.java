package grafos;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		String file = "C:/Users/analu/eclipse-workspace/grafos/src/grafos/grafo_6"
				+ ".txt";
		Grafo grafo = new Grafo();
		grafo.getNumVertices(file);

		ListaAdjacencia listaAdjacencia = new ListaAdjacencia();
		//BFS

		listaAdjacencia.getListaAdjacencia(grafo, file);
		listaAdjacencia.getComponentesConexasBFS(3, grafo);
	}	
}

