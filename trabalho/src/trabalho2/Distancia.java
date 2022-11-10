package trabalho2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
			System.out.println("Vetor");
			System.out.println("Distancia ate o vertice 20:  " + distancia[19]);
			System.out.println("Distancia ate o vertice 30:  " + distancia[29]);
			System.out.println("Distancia ate o vertice 40:  " + distancia[39]);
			System.out.println("Distancia ate o vertice 50:  " + distancia[49]);
			System.out.println("Distancia ate o vertice 60:  " + distancia[59]);
		}
	
	public void dijkstraHeap(Grafo grafo, int s, int finalVertice) {
		Heap heap = new Heap(grafo.getMaxVertices());		
		float[] distancia = new float[grafo.getMaxVertices()]; //Vetor inicial de tamanho n
		HeapElement[] elements = new HeapElement[grafo.getMaxVertices() ];
		List<Integer> caminho = new ArrayList<>();
		
		for(int i=0; i < grafo.getMaxVertices()  ; i++)
		{
			HeapElement element = new HeapElement(i+1, Float.POSITIVE_INFINITY);
			heap.addElement(element);
			elements[i] = element;
			distancia[i] = Float.POSITIVE_INFINITY;
		}		

		heap.updateElement(elements[s-1], 0);
		distancia[s-1] = 0;					
		
		while (heap.getTail() >= 0) {			
			
			HeapElement element = heap.removeElement();
			int verticeMenorDistancia = element.getVertice() - 1; 
			
			caminho.add(element.getVertice());

			/*if (element.getVertice() == finalVertice) {
				System.out.println(caminho);
				return;
			}*/
				
			No u = grafo.getListaAdjacencia()[verticeMenorDistancia];

		   	No vizinho = u.getProximoNo(); 

		   	while (vizinho != null) {		
			    
				if (vizinho.getPeso() < 0) {
					System.err.println("Ainda nao e possivel trabalhar com pesos negativos.");
					return;
				}	
				
				if (distancia[vizinho.getVertice() - 1] > (distancia[u.getVertice() - 1] + vizinho.getPeso())) { 			
					heap.updateElement(elements[vizinho.getVertice() - 1], distancia[u.getVertice() - 1] + vizinho.getPeso());
					distancia[vizinho.getVertice() - 1] = (distancia[u.getVertice() - 1] + vizinho.getPeso());		
				//	pai[vizinho.getVertice() - 1] = element.getVertice(); 
				}
				vizinho = vizinho.getProximoNo();
			}				
		}			
		
		/*//System.out.println(caminho);
		System.out.println("HEAP");
		System.out.println("Distancia ate o vertice 20:  " + distancia[19]);
		System.out.println("Distancia ate o vertice 30:  " + distancia[29]);
		System.out.println("Distancia ate o vertice 40:  " + distancia[39]);
		System.out.println("Distancia ate o vertice 50:  " + distancia[49]);
		System.out.println("Distancia ate o vertice 60:  " + distancia[59]);		*/

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
