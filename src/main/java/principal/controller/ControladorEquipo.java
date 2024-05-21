package principal.controller;

import java.util.List;

import principal.model.Equipo;


public class ControladorEquipo  extends SuperControladorJPA{
private static ControladorEquipo instance = null;
	
	
	public ControladorEquipo() {
		super("equipo" , Equipo.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControladorEquipo getInstance() {
		if (instance == null) {
			instance = new ControladorEquipo();
		}
		return instance;
	}
	
	
	
	
	
	
}
