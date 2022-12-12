package trabalho3;
import java.util.LinkedList;
import java.util.Queue;

import trabalho1.Grafo;
import trabalho1.ListaAdjacencia;
import trabalho1.No;
import trabalho1.NoArvore;

public class FordFulkerson {
	
	public boolean bfs(Grafo grafo, int[] pai, boolean[] isDescoberto,  int s, int t, float delta) {
		Queue<No> descobertos =  new LinkedList<No> ();
		Queue<No> explorados =  new LinkedList<No> ();	
		
		No noInicio = grafo.getListaAdjacencia()[s - 1 ];
		//Criando raiz da árvore
				
		isDescoberto[noInicio.getVertice() - 1] = true;
		descobertos.add(noInicio);			   
		
		while(!descobertos.isEmpty()) {				
			   noInicio =  grafo.getListaAdjacencia()[noInicio.getVertice() - 1];
			   
			   if (!isDescoberto[noInicio.getVertice() - 1]) {
		
				   isDescoberto[noInicio.getVertice() - 1] = true;
				   descobertos.add(noInicio);			   
					
			   }			 
			   		   			  
			   	No proximoNo = noInicio.getProximoNo();	  

			   while (proximoNo != null) {
					   if (!isDescoberto[proximoNo.getVertice() - 1] && proximoNo.getCapacity() >= delta) {		
						   
							pai[proximoNo.getVertice() -1] = noInicio.getVertice();					
						   	descobertos.add(proximoNo);
						   	isDescoberto[proximoNo.getVertice() - 1] = true;
					   }
					   	proximoNo = proximoNo.getProximoNo();
			   }
			   
			   descobertos.remove(descobertos.element());	
			   explorados.add(noInicio);
			   if (descobertos.size() > 0) {
				   noInicio = descobertos.element();
			   }
			}	
		grafo.addOrdemExploradosBFS(explorados);
	   	return isDescoberto[t-1];
	} 	
	
	public void fordFulkerson(Grafo grafo, int s, int t)  {		
	   	    
	    boolean[] isDescoberto = new boolean[grafo.getMaxVertices()];    
	    int[] pai = new int[grafo.getMaxVertices()];   
	    
	    float fluxo_maximo = 0;
	    float delta = 1;
	    
	    while(delta < getCapacidadeSaida(grafo, s)) {
	    	delta = delta*2;
	    }
	    
	    delta = delta/2;
	    
	    while(delta > 0) {

	        while(bfs(grafo, pai , isDescoberto,  s,  t, delta)) {
		    	
 		    	
			    float fluxo_caminho = Integer.MAX_VALUE;		    
			    //Encontrar a capacidade residual minima ao longo do caminho	

			    for (int v = t; v!=s; v = pai[v-1]) {
			    	int u = pai[v-1];
			    	if (getElementoListaADjacencia(grafo, u, v) != null){
					    fluxo_caminho = Float.min(fluxo_caminho, getElementoListaADjacencia(grafo, u, v).getCapacity());    	
			    	}
			    }
			    
			    //Atualizar as capacidades residuais das arestas
			    for (int v = t; v!=s; v = pai[v-1]) {
			    	int u = pai[v-1];
			    	updateResiduo(grafo, u, v, fluxo_caminho);
			    	updateResiduo(grafo, v, v, -fluxo_caminho);  	
			    }
			    
			    fluxo_maximo += fluxo_caminho;		
			    pai = new int[grafo.getMaxVertices()];  
			    isDescoberto = new boolean[grafo.getMaxVertices()];
			    
				ListaAdjacencia listaAdjacencia = new ListaAdjacencia();
			  //  listaAdjacencia.imprimirListaAdjacencia(grafo);			
			    
		        }
	        	delta = delta/2;
		    }		        
	
    	System.out.println("O fluxo Maximo e: " + fluxo_maximo);
	}
	
	private void updateResiduo(Grafo grafo, int u, int v, float fluxo_caminho) {
		No noInicio =  grafo.getListaAdjacencia()[u -1];	
		No proximoNo = noInicio.getProximoNo();
		boolean foundIt = false;
		
		while(proximoNo != null){
			if (proximoNo.getVertice() == v ){
				proximoNo.setCapacity(proximoNo.getCapacity() - fluxo_caminho);	
				foundIt = true;
				
			}
			proximoNo = proximoNo.getProximoNo();
		}
		
		if (!foundIt) {
			ListaAdjacencia lista = new ListaAdjacencia(); 
			lista.addAresta(u, v, 0, -fluxo_caminho,grafo);			
		}
	}
	
	private No getElementoListaADjacencia(Grafo grafo, int u, int v) {
	
		No noInicio =  grafo.getListaAdjacencia()[u -1];
		No no = null;
		while(noInicio.getProximoNo() != null){
			if (noInicio.getProximoNo().getVertice() == v ){
				no = noInicio.getProximoNo();
				return no;
			}
			noInicio = noInicio.getProximoNo();
		}
		return no;
	}
	
	private float getCapacidadeSaida(Grafo grafo, int s){
		No noInicio =  grafo.getListaAdjacencia()[s -1];
		float capacidade = 0;
		while(noInicio.getProximoNo() != null){
				capacidade += noInicio.getProximoNo().getCapacity();
				noInicio = noInicio.getProximoNo();
			}	
		
		return capacidade;
		}

	}



