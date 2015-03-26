package com.mhuang.common.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理类
 * @author huangmiao
 */
@Lazy(false)
public class ExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("exception", ex);
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.addAllObjects(modelMap);
		if(ex instanceof SQLException){//  == new ModelAndView(ViewName,Modelmap)方式
			modelAndView.setViewName("sql");
		}else if(ex instanceof BusinessException){
			modelAndView.setViewName("business");
		}else{
			modelAndView.setViewName("unknown");
		}
		return modelAndView;
	}

}
