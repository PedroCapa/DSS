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
public class PasswordIncorretaException extends Exception{
	public PasswordIncorretaException(){
		super();
	}

	public PasswordIncorretaException(String s){
		super(s);
	}
}
