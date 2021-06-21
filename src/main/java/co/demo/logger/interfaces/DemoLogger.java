package co.demo.logger.interfaces;

import java.util.logging.Logger;

public interface DemoLogger {
	
	public static final Logger logger = Logger.getLogger("DemoLogger");
	
	public void adicionaMensaje(String message);
	public void adicionaWarning(String message);
	public void adicionaError(String message);

}
