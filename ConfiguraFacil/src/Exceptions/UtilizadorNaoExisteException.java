package Exceptions;

/**
 * Classe que reporta a excecao de no caso de não existir o utilizador
 *
 */
public class UtilizadorNaoExisteException extends Exception{
	 /** Mensagem vazia no caso de não existir um certo utilizador*/
        public UtilizadorNaoExisteException(){
		super();
	}
        /** Mensagem no caso de não existir um certo utilizador*/
	public UtilizadorNaoExisteException(String s){
		super(s);
	}
}
