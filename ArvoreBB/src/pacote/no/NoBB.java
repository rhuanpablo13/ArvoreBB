package pacote.no;

public class NoBB {

	private NoBB noEsq;
	private NoBB noDir;
	private Integer valor;
	
	
	public NoBB(int valor) {
		this.valor = valor;
	}
	
	
	public NoBB getNoEsq() {
		return noEsq;
	}
	public void setNoEsq(NoBB noEsq) {
		this.noEsq = noEsq;
	}
	public NoBB getNoDir() {
		return noDir;
	}
	public void setNoDir(NoBB noDir) {
		this.noDir = noDir;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	
	
	
	
}
