
package Exceptions;
/**
 * Classe que reporta a excecao no caso de do carro não exitir
 *
 */
public class CarroNaoExisteException extends Exception{
	/** Mensagem vazia no caso de nao existir um certo carro*/
        public CarroNaoExisteException(){
		super();
	}
        /** Mensagem no caso de nao existir um certo carro*/
	public CarroNaoExisteException(String s){
		super(s);
	}
}
