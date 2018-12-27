
package Exceptions;
/**
 * Classe que reporta a excecao no caso de se houver pecas que ainda nao foram escolhidas
 *
 */
public class FaltamEscolherPecasException extends Exception{
	/** Mensagem vazia no caso de faltarem escolher peças*/
        public FaltamEscolherPecasException(){
		super();
	}
        /** Mensagem no caso de faltarem escolher peças*/
	public FaltamEscolherPecasException(String s){
		super(s);
	}
}