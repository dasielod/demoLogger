package co.demo.logger.config;

public class DefaultConfiguration extends LogConfiguration {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getProperty(final String property) {
		String message = null;
		if (property.equals("demo.logFilePath")) {
			message = "./data/logFile.txt";
		} else if (property.equals("demo.bd.userName")) {
			message = "admin";
		} else if (property.equals("demo.bd.password")) {
			message = "admin";
		} else if (property.equals("demo.bd.jdbcDriver")) {
			message = "org.h2.Driver";
		} else if (property.equals("demo.bd.dbUrl")) {
			message = "jdbc:h2:./data/logDB";
		}
		
		return message;
	}

}