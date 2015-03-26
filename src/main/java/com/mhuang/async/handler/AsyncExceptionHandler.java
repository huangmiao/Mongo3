package com.mhuang.async.handler;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

/**
 * 异步请求异常处理
 * @author huangmiao
 *
 */
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler{

	public void handleUncaughtException(Throwable ex, Method method,
			Object... params) {
		System.out.println("调用异步任务错误,message:"+ex.getMessage());
	}
}
