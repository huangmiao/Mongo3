package com.mhuang.async.vo;

import java.io.Serializable;

/**
 * 异步调用返回值参数
 * @author huangmiao
 */
public class AsyncResultVo<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	private String msg;//返回消息内容
	
	private boolean success;//调用成功后是否正确
	
	private T obj;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public AsyncResultVo(String msg,boolean success,T obj) {
		this.msg = msg;
		this.success = success;
		this.obj = obj;
	}
	
	public static <T>AsyncResultVo<T> result(String msg,boolean success,T obj){
		return new AsyncResultVo<T>(msg, success, obj);
	}
}
