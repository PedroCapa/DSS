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
public class PecaNaoExisteException extends Exception{
	public PecaNaoExisteException(){
		super();
	}

	public PecaNaoExisteException(String s){
		super(s);
	}
}
