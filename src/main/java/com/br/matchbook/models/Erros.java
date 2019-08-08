package com.br.matchbook.models;

public class Erros {
	private String msg;
	private String field;
	
	public Erros(String msg, String field) {
		this.field = field;
		this.msg = msg;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsq(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		String modelo = "";
		modelo += this.field;
		modelo += "\n" + this.msg;
		return modelo;
	}
}
