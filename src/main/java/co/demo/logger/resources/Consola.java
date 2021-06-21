package co.demo.logger.resources;

import java.io.Serializable;
import java.util.logging.ConsoleHandler;

import co.demo.logger.config.LogConfiguration;

public class Consola implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Consola instance = null;
	
	private Consola(LogConfiguration configuration) {
		super();
	}
	
	public static synchronized Consola getInstance(LogConfiguration configuration) {
		if (instance == null) {
			instance = new Consola(configuration);
		}
		return instance;
	}
	
	public ConsoleHandler getConsoleHandler() {
		return new ConsoleHandler();
	}

}
