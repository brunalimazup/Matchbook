package com.br.matchbook.models;

public class ValidationFailures {

	private String message;
	private String field;

	public ValidationFailures(String message, String field) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder modelo = new StringBuilder();

		modelo.append(this.field);
		modelo.append(this.message);
		return modelo.toString();

	}
}
