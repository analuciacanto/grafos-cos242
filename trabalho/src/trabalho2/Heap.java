package trabalho2;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.List;

public class Heap {

	private List<Float> heap = new ArrayList<Float>();
	
	public void addElement(float element){					
			heap.add(element);	
			heapifyUp(heap.size());				
	}
	
	public void updateElement(int i, float element) {
		heap.set(i, element);
		heapifyUp(i);
		heapifyDown(i);
	}
	
	public void deleteElement(int i) {
		heap.remove(i);
		heapifyDown(i);		
	}
	
	private void heapifyDown(int i){
		int n = heap.size();
		int j = 0;
		
		if (2*i > n) {
			return;
		}
		else if (2*i < n) {
			int left = 2*i;
			int right = 2*i + 1;
			j =  heap.indexOf(Math.min(heap.get(left), heap.get(right)));	
		}
		else if(2*i == n) {
			j = 2*i;
		}
		
		if (heap.get(j) < heap.get(i)) {
			heap.set(i, heap.get(j));
			heap.set(j, heap.get(i));		
			heapifyDown(j);
		} 
	}
	
	
	private void heapifyUp(int i) {
		if (i > 1) {
			
			int parent_i = i/2;
			
			if (heap.get(i) < heap.get(parent_i)) {
				//swap the array entries 
				heap.set(i, heap.get(parent_i));
				heap.set(parent_i, heap.get(i));		
				heapifyUp(parent_i);
			}
		}	
	}	
}