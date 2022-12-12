package trabalho3;

import trabalho1.Grafo;
import trabalho1.ListaAdjacencia;

public class Main {
		
		public static void main(String[] args) throws InterruptedException {

			String file = "C:/Users/analu/OneDrive/Documentos/UFRJ/grafos-cos242/trabalho/src/trabalho3/data/grafo_rf_7"
					+ ".txt";
				
			Grafo grafo = new Grafo();
			grafo.getNumVertices(file);
			
			ListaAdjacencia listaAdjacencia = new ListaAdjacencia();

			listaAdjacencia.getListaAdjacencia(grafo, file, true);
		//	listaAdjacencia.imprimirListaAdjacencia(grafo);
			
			FordFulkerson ford = new FordFulkerson();
			
			long tempoInicial = System.currentTimeMillis();

			// execução do método
			ford.fordFulkerson(grafo, 1, 2);

			System.out.println("o metodo executou em " + (System.currentTimeMillis() - tempoInicial)/100);
		}	
		
	}

