package principal.controller;


import principal.model.Socio;

public class ControladorSocio extends SuperControladorJPA{
	private static ControladorSocio instance = null;
	
	
	public ControladorSocio() {
		super("socio" , Socio.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControladorSocio getInstance() {
		if (instance == null) {
			instance = new ControladorSocio();
		}
		return instance;
	}
}
