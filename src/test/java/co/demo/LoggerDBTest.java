package co.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import co.demo.logger.LoggerDB;
import co.demo.logger.interfaces.DemoLogger;
import co.demo.logger.resources.BaseDato;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.demo.logger.config.DefaultConfiguration;
import co.demo.logger.enums.TipoLogger;
import co.demo.logger.enums.TipoMensaje;
import co.demo.logger.factory.LoggerFactory;

public class LoggerDBTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void tipoBaseDatos() {
		DemoLogger logger = LoggerFactory.getLogger(TipoLogger.DATABASE.getType());
        assertEquals(true, logger instanceof LoggerDB);
    }
	
	@Test
    public void conexionValida() {
		BaseDato bdManager = BaseDato.getInstance(new DefaultConfiguration());
		try {
			assertTrue(bdManager.getConnection().isValid(0));
		} catch (SQLException e) {
			assertTrue(false);
		}
    }
	
	@Test
    public void insertarMensaje() {
		try {
			BaseDato bdManager = BaseDato.getInstance(new DefaultConfiguration());
			bdManager.crearTabla();
			bdManager.insertarMensaje("Mensaje", TipoMensaje.MESSAGE.getId());
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
    }
	
	@Test
    public void adicionarLog() {
		try {
			DemoLogger logger = LoggerFactory.getLogger(TipoLogger.DATABASE.getType());
			logger.adicionaWarning("Warning");
			logger.adicionaMensaje("Mensaje");
	        assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
    }
	
}
