package trabalho2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap {	

	private List<HeapElement> heap;
	private int tail; //tamanho do vetor
	private List<Integer> position;
	  
    public List<Integer> getPosition() {
		return position;
	}

	public void setPosition(List<Integer> position) {
		this.position = position;
	}

	public Heap(int tamanho) {
        this.heap = new ArrayList<HeapElement>();
        this.tail = -1;
        this.position = new ArrayList<Integer>();
        
        for (int i =0; i<tamanho; i++) {
        	position.add(Integer.MAX_VALUE);
        }
    }
        	    
    public HeapElement findMin(){   	        	
    	return  heap.get(0);
    }
        
	public void addElement(HeapElement element){	
		tail = tail +1;
		position.set(element.getVertice() - 1, tail);
		//Sempre inserir no final
		if (tail == 0 ) {
			heap.add(element);
		}
		else {
			heap.add(element);
			heapifyUp(tail);	
		}		
	}
	
	public void updateElement(HeapElement element, float distancia) {		
				
		int index = position.get(element.getVertice() - 1);		
		element.setDistancia(distancia);			

		heapifyUp(index);	
		heapifyDown(index);				
	}
	
	
	public HeapElement removeElement() {
		//Remove sempre o menor elemento
		HeapElement element = heap.get(0);		
		HeapElement lastElement = heap.get(tail);
   		Collections.swap(position, element.getVertice() - 1, lastElement.getVertice() - 1);   	
   		Collections.swap(heap, 0,tail);

		heap.remove(tail);
		tail = tail - 1;
		heapifyDown(0);	
		return element;
	}
	
	private void heapifyDown(int i){
		int n = heap.size() - 1;
		int j = 0;
		
		if (i < 0) return;
		if (2*i > n) {
			return;
		}
		else if (2*i < n) {
			int left = 2*i;
			int right = 2*i + 1;
			float min = Math.min(heap.get(left).getDistancia(), heap.get(right).getDistancia());
			if (heap.get(left).getDistancia() == min) j = left;
			else j = right;
		}
		else if(2*i == n) {
			j = 2*i;
		}
		
		if (heap.get(j).getDistancia() < heap.get(i).getDistancia()) {
	   		Collections.swap(position, heap.get(i).getVertice() - 1, heap.get(j).getVertice() - 1);
			Collections.swap(heap, i, j);
		    heapifyDown(j);
		} 
	}
	
	
	private void heapifyUp(int i) {	
		int parent_i = i/2;
		if (i > 1) {			
			if (heap.get(i).getDistancia() < heap.get(parent_i).getDistancia()) {
				//swap the array entries 
		   		Collections.swap(position, heap.get(i).getVertice() - 1, heap.get(parent_i).getVertice() - 1);
				Collections.swap(heap, i, parent_i);	
				heapifyUp(parent_i);
			}
		}		
	}	
	
	public List<HeapElement> getHeap() {
		return heap;
	}

	public void setHeap(List<HeapElement> heap) {
		this.heap = heap;
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) {
		this.tail = tail;
	}

	 
}