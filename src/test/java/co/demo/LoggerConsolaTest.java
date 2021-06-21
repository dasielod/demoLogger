package co.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import co.demo.logger.LoggerConsola;
import co.demo.logger.interfaces.DemoLogger;
import co.demo.logger.resources.Consola;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.demo.logger.config.DefaultConfiguration;
import co.demo.logger.enums.TipoLogger;
import co.demo.logger.factory.LoggerFactory;

public class LoggerConsolaTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	

	
	@Test
    public void handlerValido() {
		Consola consola = Consola.getInstance(new DefaultConfiguration());
		assertNotNull(consola.getConsoleHandler());
    }
	

	
	@Test
    public void adicionaVariosMensajes() {
		DemoLogger logger = LoggerFactory.getLogger(TipoLogger.CONSOLE.getType());
		logger.adicionaError("Error");
		logger.adicionaMensaje("Mensaje");
		logger.adicionaWarning("Warning");

        assertEquals(true, logger instanceof LoggerConsola);
    }
	@Test
	public void adicionaMensaje() {
		DemoLogger logger = LoggerFactory.getLogger(TipoLogger.CONSOLE.getType());
		logger.adicionaMensaje("Mensaje ");
		assertEquals(true, logger instanceof LoggerConsola);
	}
	@Test
	public void tipoConsola() {
		DemoLogger logger = LoggerFactory.getLogger(TipoLogger.CONSOLE.getType());
		assertEquals(true, logger instanceof LoggerConsola);
	}
	
}
