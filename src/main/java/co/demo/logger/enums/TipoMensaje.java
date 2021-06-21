package co.demo.logger.enums;


public enum TipoMensaje {
	
	MESSAGE (1, "Mensaje"),
	ERROR (2, "Error"),
	WARNING (3, "Warning");
	
	private int id;
	private String name;
	
	TipoMensaje(final int id, final String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

}
