
package Exceptions;
/**
 * Classe que reporta a excecao no caso do custo de configura Otimo seja demasiado baixo
 *
 */
public class CustoDemasiadoBaixoException extends Exception{
	/** Mensagem vazia no caso do orçamento ser demasiado baixo*/
        public CustoDemasiadoBaixoException(){
		super();
	}
        /** Mensagem no caso do orçamento ser demasiado baixo*/
	public CustoDemasiadoBaixoException(String s){
		super(s);
	}
}