package com.izs.zsipedidos.resources.exception;

import java.io.Serializable;

import lombok.Data;

@Data
public class StarndardError implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private Long timeStamp;
	
	public StarndardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	
	
}
