package trabalho2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import trabalho1.Grafo;
import trabalho1.No;

public class Distancia {
	
	public void dijkstra(Grafo grafo, int s) {
		float[] distancia = new float[grafo.getMaxVertices()]; //Vetor inicial de tamanho n
		ArrayList<Integer> naoExplorados = new ArrayList<Integer>();   //V-S 

		for(int i=0; i<=grafo.getMaxVertices() -1; i++)
		{
			distancia[i] = Float.POSITIVE_INFINITY;  // Preenchendo com inifinito
			naoExplorados.add(i+1);
		}
		
		distancia[s - 1] = 0;
		while (naoExplorados.size() > 0) {
		
			int verticeMenorDistancia = retornaMenorValor(distancia, naoExplorados);	        

				No u = grafo.getListaAdjacencia()[verticeMenorDistancia];

			   	No vizinho = u.getProximoNo(); 

				while (vizinho != null) {
					
					if (vizinho.getPeso() < 0) {
						System.err.println("Ainda nao e possivel trabalhar com pesos negativos.");
						return;
					}
					
					if (distancia[vizinho.getVertice() - 1] > distancia[u.getVertice() - 1] + vizinho.getPeso()) { 
						distancia[vizinho.getVertice() - 1] = (distancia[u.getVertice() - 1] + vizinho.getPeso());
					}					
					vizinho = vizinho.getProximoNo();
				}
				int indiceExcluir = naoExplorados.indexOf(verticeMenorDistancia + 1);
				naoExplorados.remove(indiceExcluir);
			    }		
	        String stringArr = Arrays.toString(distancia);
	        System.out.println("Distancia: " + stringArr);
	}
	
	public void dijkstraHeap(Grafo grafo, int s) {
		Heap heap = new Heap();		
		ArrayList<Integer> naoExplorados = new ArrayList<Integer>();   //V-S 

		for(int i=0; i<=grafo.getMaxVertices() -1; i++)
		{
			heap.addElement(Float.POSITIVE_INFINITY); // Preenchendo com inifinito
			naoExplorados.add(i+1);
		}
		
	
	}
	
	
	
	
	public static int retornaMenorValor(float[] vetor, ArrayList<Integer> naoExplorados ) {
	    double aux;
        int indice = naoExplorados.get(0) - 1;
	    if(vetor != null && vetor.length > 0) {   
	        aux = vetor[indice];
	        for (int i = 0; i < vetor.length;  i++) {
	        
	        	if ((vetor[i] < aux) && naoExplorados.contains(i + 1)) {
	        		aux = vetor[i];
	        		indice = i;	        		
	        	}
	        }
	    }
	    return indice;
	}

}
