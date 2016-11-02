package pacote.apresentaArvore;

import pacote.interfaces.InterfaceApresentacoes;
import pacote.no.NoBB;

public class ApresentaArvore implements InterfaceApresentacoes<NoBB>{
	
	@Override
	public void apresentaPreOrdem(NoBB raiz) {
		if(raiz != null){
			System.out.println(raiz.getValor());
			apresentaPreOrdem(raiz.getNoEsq());
			apresentaPreOrdem(raiz.getNoDir());
		}
		
	}
	
	@Override
	public void apresentaEmOrdem(NoBB raiz) {		
		if(raiz != null){
			apresentaEmOrdem(raiz.getNoEsq());
			System.out.println(raiz.getValor());
			apresentaEmOrdem(raiz.getNoDir());
		}
		
	}
	
	@Override
	public void apresentaPosOrdem(NoBB raiz) {
		if(raiz != null){			
			apresentaPosOrdem(raiz.getNoEsq());			
			apresentaPosOrdem(raiz.getNoDir());
			System.out.println(raiz.getValor());
		}
		
	}
	
}
