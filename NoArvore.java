package grafos;

public class NoArvore {
	
	int vertice;
	
	NoArvore pai;
	
	public NoArvore getPai() {
		return pai;
	}

	public void setPai(NoArvore pai) {
		this.pai = pai;
	}
	
	NoArvore(int vertice)
    {
        this.vertice = vertice;
        this.pai = null;
    }
	
	public int getVertice() {
		return vertice;
	}

	public void setVertice(int vertice) {
		this.vertice = vertice;
	}

	
}
