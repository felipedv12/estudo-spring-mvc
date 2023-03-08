package com.felipe.dev.cobranca.model;

public enum Status {

	PENDING (1, "Pendente"),
	RECEIVED (2, "Recebido");
	
	private Integer code;
	
	private String description;
	
	Status(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	};
}
