package pacote.arvoreBB;

import pacote.interfaces.InterfaceArvoreBB;
import pacote.no.NoBB;

public class ArvoreBB implements InterfaceArvoreBB<NoBB, Integer>{

	private NoBB raiz;
	
	
	/**
	 * ADICIONA UM NOVO NÓ NA ARVORE
	 */
	@Override
	public NoBB adicionar(Integer valor){		
		return this.adicionar(new NoBB(valor), getRaiz());
	}
		
	
	/**
	 * ATUALIZA UM NÓ DA ARVORE
	 */
	@Override
	public NoBB atualizar(Integer valor, Integer novoValor) {		
		NoBB r;
		r = excluir(getRaiz(), valor);
		if(r != null)	
			r = adicionar(novoValor);		
		return r;
	}
	
	
	/**
	 * BUSCA UM NÓ DA ARVORE
	 */
	@Override
	public NoBB buscar(Integer  valor) {	
		NoBB corrente = raiz;
		
		while(corrente != null){			
			if(corrente.getValor() == valor){
				return corrente;
			
			}else if(valor < corrente.getValor()){
				corrente = corrente.getNoEsq();			
			}else {
				corrente = corrente.getNoDir();
			}
		}
		return null;
	}
	
	
	/**
	 * EXCLUI UM NÓ DA ARVORE
	 */
	@Override
	public NoBB excluir(Integer valor){
		return this.excluir(getRaiz(), valor);
	}
	
	
	/*******************************  IMPLEMENTAÇÕES  **************************************/
	
	
	/**
	 * IMPLEMENTAÇÃO DO MÉTODO DE ADICIONAR 
	 * @param novoNo
	 * @param noAnterior
	 * @return no
	 */
	private NoBB adicionar(NoBB novoNo, NoBB noAnterior) {
		
		if(getRaiz() == null){
			setRaiz(novoNo);
			return getRaiz();
		
		}
		if(buscar(novoNo.getValor()) != null){
			return null;
		}
		if(noAnterior != null){
								
				if(novoNo.getValor() < noAnterior.getValor()){					
					noAnterior.setNoEsq(adicionar(novoNo, noAnterior.getNoEsq()));
				
				}else if(novoNo.getValor() > noAnterior.getValor()){					
					noAnterior.setNoDir(adicionar(novoNo, noAnterior.getNoDir()));
				
				}else{
					return null;				
				}
		}else{			
			noAnterior = novoNo;			
		}	
		return noAnterior;
	}
	
	
	/**
	 * IMPLEMENTAÇÃO DO MÉTODO DE EXCLUIR
	 * @param raiz da arvore
	 * @param valor a ser excluido
	 * @return no
	 */
	private NoBB excluir(NoBB raiz, Integer valor) {
		
		
		if(raiz == null){
			System.out.println("raiz nula");
			return null;
		
		} else if(raiz.getValor() > valor){
			
			raiz.setNoEsq(excluir(raiz.getNoEsq(), valor));
		
		} else if(raiz.getValor() < valor){
			
			raiz.setNoDir(excluir(raiz.getNoDir(), valor));
		
		} else{ 
			
			//aqui remove as folhas
			if(raiz.getNoEsq() == null && raiz.getNoDir() == null){
				raiz = null;
				
			
			}else if(raiz.getNoEsq() == null){ //só tem filho a direita								
				raiz = raiz.getNoDir();
				
			
			}else if(raiz.getNoDir() == null){ //só tem filho a esquerda				
				raiz = raiz.getNoEsq();
			
			}else{
				
				NoBB no3 = raiz.getNoEsq();
				
				while(no3.getNoDir() != null){
					
					no3 = no3.getNoDir();
				}
				
				//troca informações
				raiz.setValor(no3.getValor());
				no3.setValor(valor);
				raiz.setNoEsq(excluir(raiz.getNoEsq(), valor));
			}			
		}		
		return raiz;
	}
	
	
	
	/**
	 *  RETORNA A ALTURA DA ÁRVORE
	 */	
	@Override
	public int getAlturaArvore(NoBB raiz){
		if(getRaiz() == null)
			return -1;
		
		if(getRaiz().getNoDir() == null && getRaiz().getNoEsq() == null)
			return 0;
		
		else if(getRaiz().getNoEsq() == null)
		    return 1 + getAlturaArvore(getRaiz().getNoDir());
		
		else if(getRaiz().getNoDir() == null)
			return 1 + getAlturaArvore(getRaiz().getNoEsq());
		
		else
			return 1 + Math.max(getAlturaArvore(getRaiz().getNoEsq()), getAlturaArvore(getRaiz().getNoDir()));
	}
	
	
		
	
	/**
	 * RETORNA A QUANTIDADE DE NÓS DA ARVORE 
	 */
	@Override
	public int getQuantidadeNos(NoBB raiz){
		return (getRaiz() == null) ? 0 : (1 + getQuantidadeNos(getRaiz().getNoEsq()) + getQuantidadeNos(getRaiz().getNoEsq()));
	}
	
	
	
	
	/***************************************************************/
	public NoBB getRaiz() {
		return raiz;
	}



	public void setRaiz(NoBB raiz) {
		this.raiz = raiz;
	}
	
}
