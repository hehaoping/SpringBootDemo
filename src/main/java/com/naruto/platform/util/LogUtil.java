package com.naruto.platform.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月23日
 */
public class LogUtil {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void info(String msg) {
		logger.info(msg);
	}

	public void warn(String msg) {
		logger.warn(msg);
	}

	public void error(String msg) {
		logger.error(msg);
	}

}
