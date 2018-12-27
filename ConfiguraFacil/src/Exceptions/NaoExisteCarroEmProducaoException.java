package Exceptions;
/**
 * Classe que reporta a excecao no caso de se tentar colocar um carro pronto que não esteja em producao
 *
 */
public class NaoExisteCarroEmProducaoException extends Exception{
	/** Mensagem vazia no caso de nao existir um carro em producao*/
        public NaoExisteCarroEmProducaoException(){
		super();
	}
        /** Mensagem no caso de nao existir um carro em producao*/
	public NaoExisteCarroEmProducaoException(String s){
		super(s);
	}
}
