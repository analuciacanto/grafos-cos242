package trabalho2;

public class HeapElement{	

	private int vertice;
	private float distancia;
	
	public HeapElement(int vertice, float distancia) {
	       this.vertice = vertice;
	       this.distancia = distancia;
	}
	
	public int getVertice() {
		return vertice;
	}
	public void setVertice(int vertice) {
		this.vertice = vertice;
	}
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	
	@Override
	public String toString() {
		return Float.toString(distancia);
	}
}
