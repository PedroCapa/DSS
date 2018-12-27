package Exceptions;
/**
 * Classe que reporta a excecao no caso da palavra passe estar incorreta
 *
 */
public class PasswordIncorretaException extends Exception{
	/** Mensagem vazia no caso da palavra passe estar incorreta*/
        public PasswordIncorretaException(){
		super();
	}
        /** Mensagem no caso da palavra passe estar incorreta*/
	public PasswordIncorretaException(String s){
		super(s);
	}
}
