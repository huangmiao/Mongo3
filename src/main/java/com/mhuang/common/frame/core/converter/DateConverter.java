package com.mhuang.common.frame.core.converter;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换
 * @author huangmiao
 *
 */
public class DateConverter implements Converter<String, Date> {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public Date convert(String source) {
		try {
			return DateUtils.parseDate(source, "yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss");
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
}
