package Exceptions;
/**
 * Classe que reporta a excecao no caso de nao existir a peca
 *
 */
public class PecaNaoExisteException extends Exception{
	/** Mensagem vazia no caso de nao existir a peca*/
        public PecaNaoExisteException(){
		super();
	}

	public PecaNaoExisteException(String s){
		super(s);
	}
}
