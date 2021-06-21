package co.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import co.demo.logger.LoggerArchivo;
import co.demo.logger.exception.LoggerTypeException;
import co.demo.logger.interfaces.DemoLogger;
import co.demo.logger.resources.Archivo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.demo.logger.config.DefaultConfiguration;
import co.demo.logger.enums.TipoLogger;
import co.demo.logger.factory.LoggerFactory;

public class LoggerArchivoTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void tipoArchivo() {
		DemoLogger logger = LoggerFactory.getLogger(TipoLogger.FILE.getType());
        assertEquals(true, logger instanceof LoggerArchivo);
    }

	@Test
    public void handlerValido() {
		Archivo archivo = new Archivo(new DefaultConfiguration());
		assertNotNull(archivo.getFileHandler());
    }
	@Test
	public void adicionaVariosMensajes() {
		DemoLogger logger = LoggerFactory.getLogger(TipoLogger.FILE.getType());
		logger.adicionaMensaje("Mensaje");
		logger.adicionaWarning("Warning");
		assertEquals(true, logger instanceof LoggerArchivo);
	}

	@Test
    public void adicionaMensaje() {
		DemoLogger logger = LoggerFactory.getLogger(TipoLogger.FILE.getType());
		logger.adicionaMensaje("Mensaje");
        assertEquals(true, logger instanceof LoggerArchivo);
    }
	

	
}
