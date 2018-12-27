package Exceptions;
/**
 * Classe que reporta a excecao no caso de se tentar inserir uma peça que ja exista
 *
 */
public class PecaJaExisteException extends Exception{
        /** Mensagem vazia no caso de existir a peca*/	
        public PecaJaExisteException(){
		super();
	}
        /** Mensagem no caso de existir a peca*/
	public PecaJaExisteException(String s){
		super(s);
	}
}
