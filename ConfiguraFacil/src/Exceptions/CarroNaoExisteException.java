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
public class CarroNaoExisteException extends Exception{
	public CarroNaoExisteException(){
		super();
	}

	public CarroNaoExisteException(String s){
		super(s);
	}
}
