package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {

	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(LoggerHelper.class);

	public static Logger getLogger(Class<?> clazz) {
		return LogManager.getLogger(clazz);
	}

}
