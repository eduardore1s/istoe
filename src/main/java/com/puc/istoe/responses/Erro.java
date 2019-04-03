package com.puc.istoe.responses;

public class Erro {

	private String erroMessage;
	
	public Erro(String message) {
		this.erroMessage = message;
	}

	public String getErroMessage() {
		return erroMessage;
	}

	public void setErroMessage(String erroMessage) {
		this.erroMessage = erroMessage;
	}
	
	
}
