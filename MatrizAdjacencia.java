package grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MatrizAdjacencia {
	
	public void dfs(int verticeInicio, Grafo grafo) {
		Stack<Integer> descobertos = new Stack<Integer>();	
		Stack<Integer> explorados = new Stack<Integer>();			
		descobertos.add(verticeInicio);	
		
		//Criando raiz da árvore
		//System.out.println("Raiz: " + raiz.getVertice());		
		
		 int[][] matrizAdjacencia;	
		 matrizAdjacencia = grafo.getMatrizAdjacencia();		 
						
		
		while (!descobertos.isEmpty()) {			
					
			int i = 0;
			while(i < grafo.getMaxVertices()) {
				if (matrizAdjacencia[verticeInicio - 1][i] == 1) {
					 if (!descobertos.contains(i + 1) && !explorados.contains(i + 1)) {					   		
						   	descobertos.add(i + 1);
						   	break;
					   }
				}
				 i++;

				}
			}			
	}
	
	public void bfs(int verticeInicio, Grafo grafo) {
		Queue<Integer> descobertos =  new LinkedList<Integer> ();
		Queue<Integer>explorados =  new LinkedList<Integer> ();	
		
	
		while(descobertos.isEmpty() ) {	
			   int[][] matrizAdjacencia;	

			   matrizAdjacencia = grafo.getMatrizAdjacencia();	  //Pega matriz	 		   
			   			  			   
			   if (!descobertos.contains(verticeInicio) ){
				   descobertos.add(verticeInicio);
			   }
			   
			   int i = 0;
			   while (i < grafo.getMaxVertices()) {			   
				   
				   if (matrizAdjacencia[verticeInicio - 1][i] == 1) {
					   if (!descobertos.contains(i + 1) && !explorados.contains(i + 1)) {					   		
						   	descobertos.add(i + 1);
					   }
				   }			   
				   i++;
			   }

			   descobertos.remove(verticeInicio);	
			   explorados.add(verticeInicio);
			   if (descobertos.size() > 0) {
				   verticeInicio = descobertos.element();
			   }
			}	
		//	System.out.println("Descobertos:" + descobertos + " -- " +  "Explorados:" + explorados + "--" + "Desconhecidos: " + desconhecidos);
		} 	
	
	
	
	public void imprimirMatrizAdjacencia(Grafo grafo) {
		int maxVertices = grafo.getMaxVertices();
	
		 for (int i = 0; i < maxVertices; i++) {		
			 for (int j = 0; j < maxVertices; j++) {
				 System.out.print(grafo.getMatrizAdjacencia()[i][j]); 
			 }	
			 System.out.print(" \n"); 
		 }	
		
	}
	
	public void addAresta(int de, int para, Grafo grafo) {
		grafo.getMatrizAdjacencia()[de - 1 ][para - 1] = 1;
		grafo.getMatrizAdjacencia()[para - 1][de - 1] = 1;		
	}
	
	public void getMatrizAdjacencia(Grafo grafo, String file) throws InterruptedException {
		int maxVertices = grafo.getMaxVertices();
		int[][] matrizAdjacencia =  new int[maxVertices][maxVertices];
		 
		 //Populando a lista com o início
		 for (int i = 0; i < maxVertices; i++) {		
			 for (int j = 0; j < maxVertices; j++) {
				 matrizAdjacencia[i][j] = 0;
			 }			 
		 }		
		 
		 grafo.setMatrizAdjacencia(matrizAdjacencia);
		 
			  try(BufferedReader br = new BufferedReader(new FileReader(file))) 
		        {
		            String line;
		            int j = 0;	     

		            while ((line = br.readLine()) != null) {			            	
		            	if (j>0) {
		            		
		    	            String[] vertices = line.split(" ");
		    	            addAresta(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]), grafo);	
		    	            addAresta(Integer.parseInt(vertices[1]), Integer.parseInt(vertices[0]), grafo);	
		            	}
		            	j++;									
					}
		        }  catch (IOException e) {
		            System.out.println("Erro ao ler o arquivo.");
		            e.printStackTrace();
		        }		  							
	}

}
