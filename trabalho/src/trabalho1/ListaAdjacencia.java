package trabalho1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ListaAdjacencia {
	
public void getComponentesConexasDFS(int verticeInicio, Grafo grafo) {
		boolean[] isDescoberto = dfs(verticeInicio,grafo, 10, new boolean[grafo.getMaxVertices()]);
		int tamanhoExplorados = grafo.getOrdemExploradosDFS().size();
		int quantidadeComponentesConexas = 1;
		int tamanhoMenorComponente = tamanhoExplorados;
		int tamanhoMaiorComponente = tamanhoExplorados;
	
		while(tamanhoExplorados < grafo.getMaxVertices()) {
			
			int i =	0;			
			while(isDescoberto[i]) {
				i++;				
				if (i == grafo.getMaxVertices() - 1) {
					break;
				}
			}
	
			dfs(i+1, grafo, 10, isDescoberto);
			
			if (grafo.getOrdemExploradosDFS().size() - tamanhoExplorados > tamanhoMaiorComponente ) {
				tamanhoMaiorComponente = grafo.getOrdemExploradosDFS().size() - tamanhoExplorados;
			}
			if (grafo.getOrdemExploradosDFS().size() - tamanhoExplorados < tamanhoMenorComponente) {
				tamanhoMenorComponente = grafo.getOrdemExploradosDFS().size() - tamanhoExplorados;
			}
			tamanhoExplorados = grafo.getOrdemExploradosDFS().size();

			quantidadeComponentesConexas++;

		}
		System.out.println("O grafo possui: " + quantidadeComponentesConexas + " compoenentes conexas" );
		System.out.println("Maior componente: " + tamanhoMaiorComponente );
		System.out.println("Menor componente: " + tamanhoMenorComponente);

	}

public void getComponentesConexasBFS(int verticeInicial , Grafo grafo) {
	boolean[] isDescoberto = bfs(verticeInicial, grafo, new boolean[grafo.getMaxVertices()]);
	int tamanhoExplorados = grafo.getOrdemExploradosBFS().size();
	
	int quantidadeComponentesConexas = 1;
	int tamanhoMenorComponente = tamanhoExplorados;
	int tamanhoMaiorComponente = tamanhoExplorados;
	

	while(tamanhoExplorados < grafo.getMaxVertices()) {
		
		int i =	0;			
		while(isDescoberto[i]) {
			i++;				
			if (i == grafo.getMaxVertices() - 1) {
				break;
			}
		}
		bfs(i+1, grafo, isDescoberto);
		
		if (grafo.getOrdemExploradosBFS().size() - tamanhoExplorados > tamanhoMaiorComponente ) {
			tamanhoMaiorComponente = grafo.getOrdemExploradosBFS().size() - tamanhoExplorados;
		}
		if (grafo.getOrdemExploradosBFS().size() - tamanhoExplorados < tamanhoMenorComponente) {
			tamanhoMenorComponente = grafo.getOrdemExploradosBFS().size() - tamanhoExplorados;
		}
		tamanhoExplorados = grafo.getOrdemExploradosBFS().size();

		quantidadeComponentesConexas++;
	}
	System.out.println("O grafo possui: " + quantidadeComponentesConexas + " compoenentes conexas" );
	System.out.println("Maior componente: " + tamanhoMaiorComponente );
	System.out.println("Menor componente: " + tamanhoMenorComponente);
}

	public boolean[] dfs(int verticeInicial , Grafo grafo, int verticeEncontrarPai, boolean[] isDescoberto) {	
		
		Stack<No> descobertos = new Stack<No>();	
		Stack<No> explorados = new Stack<No>();	
		int nivelArvore = 0;
		
		No noInicio = grafo.getListaAdjacencia()[verticeInicial - 1 ];
		
		//Criando raiz da árvore
		NoArvore raiz =  new NoArvore(noInicio.getVertice());	
		grafo.setRaizArvoreDFS(raiz);
		
		isDescoberto[verticeInicial -1] = true;
		descobertos.add(noInicio);
		
		noInicio =  descobertos.lastElement();	
		raiz = new NoArvore(noInicio.getVertice());	
				
		//System.out.println("Raiz: " + raiz.getVertice());		
								
		while (!descobertos.isEmpty()) {			
			noInicio = grafo.getListaAdjacencia()[noInicio.getVertice() - 1 ];
					
			if (!isDescoberto[noInicio.getVertice() - 1]) {	
				NoArvore folha = new NoArvore(noInicio.getVertice());
				folha.setPai(raiz);		
				
				if (noInicio.getVertice() == 10 || noInicio.getVertice() == 20 || noInicio.getVertice() == 30 ) {
		//			System.out.println("Pai: " + folha.getPai().getVertice() + " -- Folha:" + folha.getVertice());
				}
				
				descobertos.add(noInicio);
				isDescoberto[noInicio.getVertice() - 1] = true;
				noInicio = descobertos.lastElement();				
				raiz = new NoArvore(noInicio.getVertice());	
				nivelArvore++;
			}
			
			else {
				
					while(isDescoberto[noInicio.getVertice() - 1]) {						
						if (noInicio.getProximoNo() != null) {
							noInicio = noInicio.getProximoNo();	
						}
						else {
							explorados.add(descobertos.lastElement());
							descobertos.remove(descobertos.lastElement());
							if (!descobertos.isEmpty())	{
								noInicio = descobertos.lastElement();
								raiz = new NoArvore(noInicio.getVertice());
								}					
							else 	{
								System.out.println("Descobertos:" + descobertos + " -- " +  "Explorados:" + explorados + "--" );
							}
							break;
						}
					}				
			}
		}	
		
		grafo.addOrdemExploradosDFS(explorados);
		return isDescoberto;
	} 	
		
	public boolean[] bfs(int verticeInicio, Grafo grafo, boolean[] isDescoberto) {
		Queue<No> descobertos =  new LinkedList<No> ();
		Queue<No> explorados =  new LinkedList<No> ();	
		
		No noInicio = grafo.getListaAdjacencia()[verticeInicio - 1 ];
		//Criando raiz da árvore
		NoArvore raiz =  new NoArvore(noInicio.getVertice());	
		grafo.setRaizArvoreBFS(raiz);
				
		System.out.println("Raiz: " + raiz.getVertice());	
		isDescoberto[noInicio.getVertice() - 1] = true;
		descobertos.add(noInicio);			   
		raiz = new NoArvore(noInicio.getVertice());			

		
		while(!descobertos.isEmpty()) {				
		   // System.out.println("Descobertos:" + descobertos + " -- " +  "ExploFrados:" + explorados);
			   noInicio =  grafo.getListaAdjacencia()[noInicio.getVertice() - 1];
			   
			   if (!isDescoberto[noInicio.getVertice() - 1]) {
					raiz = new NoArvore(noInicio.getVertice());			
		
				   isDescoberto[noInicio.getVertice() - 1] = true;
				   descobertos.add(noInicio);			   
					
			   }			 
			   		   			  
			   	No proximoNo = noInicio.getProximoNo();	  

			   while (proximoNo != null) {
			//  	System.out.println("Descobertos:" + descobertos + " -- " +  "Explorados:" + explorados + "--");

					   if (!isDescoberto[proximoNo.getVertice() - 1]) {		
						   
						   	NoArvore folha = new NoArvore(proximoNo.getVertice());
							folha.setPai(raiz);		
							
							if (proximoNo.getVertice() == 10 || proximoNo.getVertice() == 20 || proximoNo.getVertice() == 30 ) {
								System.out.println("Pai: " + folha.getPai().getVertice() + " -- Folha:" + folha.getVertice());
							}
						   	descobertos.add(proximoNo);
						   	isDescoberto[proximoNo.getVertice() - 1] = true;
					   }
					   	proximoNo = proximoNo.getProximoNo();
			   }
			   
			   descobertos.remove(descobertos.element());	
			   explorados.add(noInicio);
			   if (descobertos.size() > 0) {
				   noInicio = descobertos.element();
				   raiz = new NoArvore(noInicio.getVertice());
			   }
			}	
		grafo.addOrdemExploradosBFS(explorados);
	  // 	System.out.println("Descobertos:" + descobertos + " -- " +  "Explorados:" + explorados + "--");
	   	return isDescoberto;
		} 	
	
		public void addAresta(int de, int para, float peso, float capacity, Grafo grafo) {
			No novo = new No(para);
			novo.setPeso(peso);
			novo.setCapacity(capacity);
			No anterior = null;
			No inicio = grafo.getListaAdjacencia()[de -1];
			No proximo = grafo.getListaAdjacencia()[de -1].getProximoNo();
			
			if (proximo == null) {
		    	inicio.setProximoNo(novo);			
			}			
			else {
				while (proximo != null && proximo.getVertice() < para)
				    {
				        anterior = proximo;				      			       
					    proximo = proximo.getProximoNo();				       				       
				    }
					   if (anterior == null)
				    {				    	
				    	//aqui
				    	novo.setProximoNo(inicio.getProximoNo());
				    	inicio.setProximoNo(novo);
				    }
				    else
				    {	        
				        novo.setProximoNo(anterior.getProximoNo());
				        anterior.setProximoNo(novo);	
				    }				
			}
		
		}
	
		public void getListaAdjacencia(Grafo grafo, String file, boolean isDirecionado) throws InterruptedException {
			int maxVertices = grafo.getMaxVertices();
			
			@SuppressWarnings("unchecked")
			No [] listaAdjacencia =  new No[maxVertices];
			 
			 //Populando a lista com o n[o início
			 for (int i = 0; i < maxVertices; i++) {	
				 No no = new No(i+1);
				 listaAdjacencia[i] = no;
			 }		
			 
			 grafo.setListaAdjacencia(listaAdjacencia);
			 
				  try(BufferedReader br = new BufferedReader(new FileReader(file))) 
			        {
			            String line;
			            int j = 0;	     

			            while ((line = br.readLine()) != null) {			            	
			            	if (j>0) {
			            		
			    	            String[] vertices = line.split(" ");
			    	             if (vertices.length == 3){
				    	             addAresta(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]), Float.parseFloat(vertices[2]),Float.parseFloat(vertices[2]), grafo);
			    	            	 if (!isDirecionado){

						    	          addAresta(Integer.parseInt(vertices[1]), Integer.parseInt(vertices[0]), Float.parseFloat(vertices[2]),Float.parseFloat(vertices[2]), grafo);	
			    	            	 }
			    	             }	
			    	             else if (vertices.length == 4){
					    	          addAresta(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]), Float.parseFloat(vertices[2]), Float.parseFloat(vertices[3]), grafo);	

			    	            	 if (!isDirecionado){
						    	          addAresta(Integer.parseInt(vertices[1]), Integer.parseInt(vertices[0]), Float.parseFloat(vertices[2]), Float.parseFloat(vertices[3]), grafo);	
			    	            	 }
			    	             }	
			    	             else {
			    	            	  addAresta(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]), 0, 0, grafo);	
				    	            	 if (!isDirecionado){
							    	          addAresta(Integer.parseInt(vertices[1]), Integer.parseInt(vertices[0]), 0, 0, grafo);	
				    	            	 }

			    	             }
			            	}
			            	j++;									
						}
			        }  catch (IOException e) {
			            System.out.println("Erro ao ler o arquivo.");
			            e.printStackTrace();
			        }		  							
		}		
		
		public void imprimirListaAdjacencia(Grafo grafo) {
			 for (int i = 0; i < grafo.getMaxVertices() ; i++)
			    {
					No inicio = grafo.getListaAdjacencia()[i];
		        	String lista = "";

			        while (inicio != null)
			        {
			        //	lista = lista + "(" +  inicio.getVertice().toString() + "," +  inicio.getPeso()  + "," +  inicio.getCapacity() + ")" +  "-> " ;   
				       lista = lista + "(" +  inicio.getVertice().toString()  + "," +  inicio.getCapacity() + ")" +  "-> " ;   

			        	inicio = inicio.getProximoNo();
			        }
		            System.out.println(lista);
			    }
		}	
	
}
