/**
 * 
 */
package grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author analu
 *
 */

public class Grafo {
	
	private int maxVertices;
	private No[]  listaAdjacencia;
	private NoArvore raizArvoreDFS;
	private NoArvore raizArvoreBFS;
	private int[][] matrizAdjacencia;	
	private Stack<No> ordemExploradosDFS = new Stack<No>();
	private Queue<No> ordemExploradosBFS = new LinkedList<No>();
		
	public void getNumVertices(String file) {
	       int vertices = 0;
	       try(BufferedReader br = new BufferedReader(new FileReader(file))) 
	        {
	            String line;
	            int i = 0;	     
	            while ((line = br.readLine()) != null) {
	            	if (i == 0) {
	            		vertices = Integer.parseInt(line);
	            		break;
	            		}		            
	        }
	            }
	        catch (IOException e) {
	            System.out.println("Erro ao ler o arquivo.");
	            e.printStackTrace();
	        }
		maxVertices = vertices;
	}	
		
	
	public No [] getListaAdjacencia() {
		return listaAdjacencia;
	}
	
	public void setListaAdjacencia(No []  listaAdjacencia2) {
		this.listaAdjacencia = listaAdjacencia2;
	}	
	
	public int getMaxVertices() {
		return maxVertices;
	}
	public void setMaxVertices(int maxVertices) {
		this.maxVertices = maxVertices;
	}

	public int[][] getMatrizAdjacencia() {
		return matrizAdjacencia;
	}

	public void setMatrizAdjacencia(int[][] matrizAdjacencia) {
		this.matrizAdjacencia = matrizAdjacencia;
	}

	public NoArvore getRaizArvoreDFS() {
		return raizArvoreDFS;
	}


	public void setRaizArvoreDFS(NoArvore raizArvore) {
		this.raizArvoreDFS = raizArvore;
	}

	@Override
	public String toString() {
		return "Grafo [maxVertices=" + maxVertices + ", listaAdjacencia=" + listaAdjacencia 
				+ "]";
	}
	
	public Queue<No> getOrdemExploradosBFS() {
		return ordemExploradosBFS;
	}


	public void setOrdemExploradosBFS(Queue<No> ordemExploradosBFS) {
		this.ordemExploradosBFS = ordemExploradosBFS;
	}


	public void setOrdemExploradosDFS(Stack<No> ordemExploradosDFS) {
		this.ordemExploradosDFS = ordemExploradosDFS;
	}


	public Stack<No> getOrdemExploradosDFS() {
		return ordemExploradosDFS;
	}


	public void addOrdemExploradosDFS(Stack<No> ordemExplorados) {
		this.ordemExploradosDFS.addAll(ordemExplorados);
	}	
	
	public void addOrdemExploradosBFS(Queue<No> explorados) {
		this.ordemExploradosBFS.addAll(explorados);
	}


	public NoArvore getRaizArvoreBFS() {
		return raizArvoreBFS;
	}


	public void setRaizArvoreBFS(NoArvore raizArvoreBFS) {
		this.raizArvoreBFS = raizArvoreBFS;
	}	
}
