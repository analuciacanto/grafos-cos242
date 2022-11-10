package trabalho1;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		String file = "C:/Users/analu/eclipse-workspace/grafos/src/grafos/example"
				+ ".txt";
		Grafo grafo = new Grafo();
		grafo.getNumVertices(file);
		

		ListaAdjacencia listaAdjacencia = new ListaAdjacencia();

		listaAdjacencia.getListaAdjacencia(grafo, file);
		listaAdjacencia.getComponentesConexasBFS(5, grafo);
	}	
	
}

