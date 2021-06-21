package co.demo.logger.factory;

import co.demo.logger.LoggerConsola;
import co.demo.logger.LoggerDB;
import co.demo.logger.LoggerArchivo;
import co.demo.logger.config.DefaultConfiguration;
import co.demo.logger.enums.TipoLogger;
import co.demo.logger.exception.LoggerTypeException;
import co.demo.logger.interfaces.DemoLogger;

public class LoggerFactory {
	
	private LoggerFactory() {
		super();
	}
	
	public static DemoLogger getLogger(String type) {
		if (TipoLogger.FILE.getType().equals(type)) {
			return new LoggerArchivo(new DefaultConfiguration());
		} else if (TipoLogger.CONSOLE.getType().equals(type)) {
			return new LoggerConsola(new DefaultConfiguration());
		} else if (TipoLogger.DATABASE.getType().equals(type)) {
			return new LoggerDB(new DefaultConfiguration());
		} else {
			throw new LoggerTypeException("Configuracion Invalida, el log no es correcto");
		}
	}


}
