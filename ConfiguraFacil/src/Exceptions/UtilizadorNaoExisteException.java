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
public class UtilizadorNaoExisteException extends Exception{
	public UtilizadorNaoExisteException(){
		super();
	}

	public UtilizadorNaoExisteException(String s){
		super(s);
	}
}
