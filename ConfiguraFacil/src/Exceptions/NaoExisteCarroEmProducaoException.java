/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author pmcca
 */
public class NaoExisteCarroEmProducaoException extends Exception{
	public NaoExisteCarroEmProducaoException(){
		super();
	}

	public NaoExisteCarroEmProducaoException(String s){
		super(s);
	}
}
