package trabalho1;
public class No {
	
	private Integer vertice;
	private No proximoNo;
	private float peso;
	private float capacity;
	private float residuo;	
	private float distancia;
	boolean explorado;
	
	public No(Integer vertice) {
	this.vertice = vertice;
	this.proximoNo = null;
	this.explorado = false;
	this.setResiduo(0);
	}
	
	public final boolean isExplorado() {
		return explorado;
	}

	public final void setExplorado(boolean explorado) {
		this.explorado = explorado;
	}

	public No(Integer vertice, No proximoElemento, No noAnterior) {
		this.vertice = vertice;
		this.proximoNo = proximoElemento;
		this.explorado = false;		
	}	
	
	public Integer getVertice() {
		return vertice;
	}
	public void setVertice(Integer vertice) {
		this.vertice = vertice;
	}
	public No getProximoNo() {
		return proximoNo;
	}
	public void setProximoNo(No proximoNo) {
		this.proximoNo = proximoNo;
	}
	
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	
	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}

	public float getResiduo() {
		return residuo;
	}

	public void setResiduo(float residuo) {
		this.residuo = residuo;
	}


	/*@Override
	public String toString() {
		return vertice.toString();				
	}
*/
	
}
