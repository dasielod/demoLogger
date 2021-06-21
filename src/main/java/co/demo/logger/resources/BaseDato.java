package co.demo.logger.resources;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import co.demo.logger.config.LogConfiguration;

public class BaseDato implements Serializable {

	private static final long serialVersionUID = 1L;

	private static BaseDato instance = null;
	private LogConfiguration configuration;
	
	private BaseDato(LogConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public static synchronized BaseDato getInstance(LogConfiguration configuration) {
		if (instance == null) {
			instance = new BaseDato(configuration);
		}
		return instance;
	}

	public Connection getConnection() {
		Connection connection ;
		try {
			Class.forName(configuration.getProperty("demo.bd.jdbcDriver"));
			String userName = configuration.getProperty("demo.bd.userName");
			String password = configuration.getProperty("demo.bd.password");
			connection = DriverManager.getConnection(configuration.getProperty("demo.bd.dbUrl"), userName, password);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("Error de Conexion.", e);
		}
		return connection;
	}
	
	public Statement getStatment(Connection coneccion) {
		try {
			return coneccion.createStatement();
		} catch (SQLException e) {
			throw new RuntimeException("Error de conexion.", e);
		}
	}
	
	public void crearTabla() {
		Connection connection ;
		Statement statement ;
		try {
			connection = getConnection();
			statement = getStatment(connection);
			statement.executeUpdate("create table IF NOT EXISTS Log_Values(message varchar(255), type int)");
		} catch (SQLException e) {
			throw new RuntimeException("Error al crear la tabla.", e);
		} finally {
			//close
		}
	}

	public void insertarMensaje(String mensaje, int tipoMensaje) {
		Connection connection ;
		Statement statement ;
		try {
			connection = getConnection();
			statement = getStatment(connection);
			statement.execute("INSERT INTO Log_Values(message, type) VALUES('" + mensaje + "', " +tipoMensaje + ")");
		} catch (SQLException e) {
			throw new RuntimeException("Error al insertar el mensaje", e);
		} finally {
			//close
		}
	}
	

}
