package pacote.view;
import java.util.Scanner;

import pacote.apresentaArvore.ApresentaArvore;
import pacote.arvoreBB.ArvoreBB;

public class View {
	
	private ArvoreBB arvore;
	private ApresentaArvore apresenta;
	
	public View() {
		// TODO Auto-generated constructor stub
		this.arvore = new ArvoreBB();
		this.apresenta = new ApresentaArvore();
	}
	
	
	
	/**
	 * NAVEGAÇÃO PRINCIPAL DO PROGRAMA
	 */
	public void navegacao(){		
		int opcao;
		do{
				menuPrincipal();
				opcao = getValorUsuario("\nInforme uma opção: ");				
		
				switch (opcao) {
				case 0:					
					System.out.println("\nSaiu menu principal");					
					break;

				case 1:
					if(this.arvore.adicionar(popularNo()) == null){print("Erro ao adicionar nó");}else{print("Adicionado com sucesso!\n");}
					apresentaArvorePadrao();					
					break;
					
				case 2:
					if(this.arvore.atualizar(getValorUsuario("Informe o nó a ser atualizado: "), getValorUsuario("Informe o novo valor: ")) == null){print("Erro ao atualizar!");} else {print("Atualizado com Sucesso!\n");}
					apresentaArvorePadrao();					
					break;
					
				case 3:
					if(this.arvore.excluir(getValorUsuario("Informe o nó para excluir")) == null){print("Erro ao excluir!");}else{print("Excluido com sucesso!\n");}
					apresentaArvorePadrao();
					break;
				
				/**
				 * NAVEGAÇÃO DO MENU DE APRESENTAÇÃO DA ÁRVORE	
				 */
				case 4:
					do{
						menuListarArvore();
						opcao = getValorUsuario("Informe o tipo de apresentação:");
						switch (opcao) {
						case 0:
							print("\nSaiu menu apresentação");							
							break;

						case 1:
							this.apresenta.apresentaEmOrdem(arvore.getRaiz());
							break;
						
						case 2:							
							this.apresenta.apresentaPosOrdem(arvore.getRaiz());							
							break;
							
						case 3:							
							this.apresenta.apresentaPreOrdem(arvore.getRaiz());							
							break;
							
						default:
							print("\nOpção incorreta!");	
						}
						
					}while(opcao != 0);
					opcao = -1;
					break;
					
				default:
					print("\nOpção incorreta!");
				
				}
		}while(opcao != 0);
		
		
	}
	
	
	
	
	
	/**
	 * LIMPA O CONSOLE (GATO)
	 */
	private void limpaTela(){
		for (int i = 0; i < 10; i++) {
			System.out.println("\n");
		}
	}
	
	
	/**
	 * APRESENTA A ÁRVORE (EM ORDEM) PARA O USUÁRIO CONFORME ELE MODIFICÁ-LA
	 */
	private void apresentaArvorePadrao(){
		limpaTela();
		print("-------------ARVORE BINÁRIA DE BUSCA---------------");		
		this.apresenta.apresentaEmOrdem(this.arvore.getRaiz());
		print("---------------------------------------------------");		
	}
	
	
	/**
	 * IMPRIME UMA STRING
	 * @param msg
	 */
	private void print(String msg){
		System.out.println(msg);
	}
	
	
	
	/**
	 * PEGA UM VALOR DIGITADO PELO USUÁRIO (NÃO VALIDA PARA CARÁCTER)
	 * @param msg
	 * @return um int
	 */
	private int getValorUsuario(String msg){
		print(msg);
		return new Scanner(System.in).nextInt();
	}
	
	
	/**
	 * PREENCHE UM NÓ COM UM VALOR INFORMADO PELO USUÁRIO
	 * @return um int
	 */
	public int popularNo(){	  
		return (getValorUsuario("Informe o valor para inserir: "));
	}	
	
	
	
	/**
	 * IMPRIME O MENU PRINCIPAL
	 */
	private void menuPrincipal(){
		print("0 - sair");
		print("1 - adicionar");
		print("2 - editar");
		print("3 - excluir");
		print("4 - listar");
	}
	
	
	/**
	 * IMPRIME O SUB MENU DE APRESENTAÇÃO DA ÁRVORE
	 */
	private void menuListarArvore(){
		print("0 - sair");
		print("1 - em ordem");
		print("2 - pós ordem");
		print("3 - pré ordem");
	}
	
	

}
