package Exceptions;
/**
 * Classe que reporta a excecao no caso de se tentar registar um utilizador ja existente
 *
 */
public class UtilizadorJaRegistadoException extends Exception{
	/** Mensagem vazia no caso de existir um certo utilizador*/
        public UtilizadorJaRegistadoException(){
		super();
	}
        /** Mensagem no caso de existir um certo utilizador*/
	public UtilizadorJaRegistadoException(String s){
		super(s);
	}
}