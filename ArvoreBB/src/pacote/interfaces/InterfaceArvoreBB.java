package pacote.interfaces;

public interface InterfaceArvoreBB <T, Q>{
	T adicionar(Q valor);
	T excluir(Q valor);
	T atualizar(Q valor, Q novoValor);
	T buscar(Q valor);
	int getQuantidadeNos(T raiz);
	int getAlturaArvore(T raiz);
}
