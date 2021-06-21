package co.demo.logger.enums;

public enum TipoLogger {

	DATABASE ("database"),
	CONSOLE ("console"),
	FILE ("file");
	
	private String type;
	
	TipoLogger(final String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	

}
