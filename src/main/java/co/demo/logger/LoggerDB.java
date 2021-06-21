package co.demo.logger;

import co.demo.logger.config.LogConfiguration;
import co.demo.logger.enums.TipoMensaje;
import co.demo.logger.exception.MessageException;
import co.demo.logger.interfaces.DemoLogger;
import co.demo.logger.resources.BaseDato;
import org.apache.logging.log4j.util.Strings;

public class LoggerDB implements DemoLogger {
	
	private BaseDato manager;
	
	public LoggerDB(LogConfiguration configuration) {
		this.manager = BaseDato.getInstance(configuration);
	}
	
	public void adicionaMensaje(String mensaje) {
		if (Strings.isBlank(mensaje)) {
			throw new MessageException("Especificar Mensaje");
		}
		String errorMessage = mensaje;
		this.manager.insertarMensaje(errorMessage, TipoMensaje.MESSAGE.getId());
	}

	public void adicionaWarning(String mensaje) {
		if (Strings.isBlank(mensaje)) {
			throw new MessageException("Especificar Warning");
		}
		String errorMessage =  mensaje;
		this.manager.insertarMensaje(errorMessage, TipoMensaje.WARNING.getId());
	}

	public void adicionaError(String mensaje) {
		if (Strings.isBlank(mensaje)) {
			throw new MessageException("Especificar Error");
		}
		String errorMessage = mensaje;
		this.manager.insertarMensaje(errorMessage, TipoMensaje.ERROR.getId());
	}

}