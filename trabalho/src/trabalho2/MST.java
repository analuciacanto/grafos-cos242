package trabalho2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import trabalho1.Grafo;
import trabalho1.No;

public class MST {
	
	public void prim(Grafo grafo, int verticeInicial)
	{
		float[] custo = new float[grafo.getMaxVertices()];
		List<Integer> explorados = new ArrayList<Integer>();
		Heap heap = new Heap(grafo.getMaxVertices());
		HeapElement[] elements = new HeapElement[grafo.getMaxVertices()];

		//Inicializando 
		for (int i =0; i < grafo.getMaxVertices(); i++) {
			custo[i] = Float.POSITIVE_INFINITY;		
			HeapElement element = new HeapElement(i+1, Float.POSITIVE_INFINITY);
			elements[i] = element;
			heap.addElement(element);
		}
		
		//Atualizando custo do vértice inicial
		heap.updateElement(elements[verticeInicial-1], 0);
		custo[verticeInicial -1] = 0;
		
		while(explorados.size() < grafo.getMaxVertices()) {
			System.out.println(heap.getHeap());

			//Selecionar custo mínimo			
			HeapElement element = heap.removeElement();	
			int verticeMenorDistancia = element.getVertice() - 1;

			//Acessando lista de adjacência
			No u = grafo.getListaAdjacencia()[verticeMenorDistancia];
			
			No vizinho = u.getProximoNo();			

			while(vizinho != null) {
				if (vizinho.getPeso() < 0) {
					System.err.println("Ainda nao e possivel trabalhar com pesos negativos.");
					return;
				}	
				
				if (custo[vizinho.getVertice() - 1] > vizinho.getPeso() ) { 			
					heap.updateElement(elements[vizinho.getVertice() - 1], vizinho.getPeso());
					custo[vizinho.getVertice() - 1] = vizinho.getPeso();		
				}					
				vizinho = vizinho.getProximoNo();
			}
			explorados.add(element.getVertice());
		}				

		float custoMST = 0;
	    for (int i =0; i < grafo.getMaxVertices(); i++) {
	    	custoMST += custo[i];
		}
	    System.out.println("Custo toal: "  + custoMST);
	}
}
