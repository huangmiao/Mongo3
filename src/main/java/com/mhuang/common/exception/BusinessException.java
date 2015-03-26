package com.mhuang.common.exception;

/**
 * 业务异常类
 * @author huangmiao
 */
public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BusinessException(String msg){
		super(msg);
	}
	
	public BusinessException(String msg,Throwable ex){
		super(msg, ex);
	}
}
