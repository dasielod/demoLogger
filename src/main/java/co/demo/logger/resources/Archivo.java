package co.demo.logger.resources;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;

import co.demo.logger.config.LogConfiguration;
import co.demo.logger.exception.HandlerException;
import co.demo.logger.exception.LogFileException;

public class Archivo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private LogConfiguration config;
	
	public Archivo(LogConfiguration config) {
		super();
		this.config = config;
	}
	
	public File getLogFile() {
		File logFile = new File(this.config.getProperty("demo.logFilePath"));
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				throw new LogFileException("Error al crear el archivo.", e);
			}
		}
		return logFile;
	}
	
	public FileHandler getFileHandler() {
		try {
			getLogFile();
			return new FileHandler(this.config.getProperty("demo.logFilePath"));
		} catch (SecurityException | IOException e) {
			throw new  HandlerException("Error al o.", e);
		}
	}

}
