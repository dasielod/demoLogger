package co.demo.logger;

import java.util.logging.Level;

import co.demo.logger.config.LogConfiguration;
import co.demo.logger.exception.MessageException;
import co.demo.logger.resources.Consola;
import co.demo.logger.interfaces.DemoLogger;
import org.apache.logging.log4j.util.Strings;

public class LoggerConsola implements DemoLogger {
	
	private Consola manager;
	
	public LoggerConsola(LogConfiguration configuration) {
		this.manager = Consola.getInstance(configuration);
		logger.addHandler(this.manager.getConsoleHandler());
	}
	
	public void adicionaMensaje(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Especificar Mensaje");
		}
		logger.log(Level.INFO, message);
	}

	public void adicionaWarning(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Especificar Warning");
		}
		logger.log(Level.WARNING, message);
	}

	public void adicionaError(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Especificar Error");
		}
		logger.log(Level.SEVERE, message);
	}

}