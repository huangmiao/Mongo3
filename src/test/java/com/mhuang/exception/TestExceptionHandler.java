package com.mhuang.exception;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.mhuang.common.exception.BusinessException;

@ContextConfiguration(locations = {"classpath*:spring*.xml" })
public class TestExceptionHandler {

	@Test
	public void test(){
			try {
				throw new BusinessException("你好");
			} catch (BusinessException e) {
				e.printStackTrace();
			}
	}
}
