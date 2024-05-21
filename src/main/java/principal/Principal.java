package principal;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import principal.view.res.PanelClasificacion;
import principal.view.res.PanelGestionSocios;
import principal.view.res.PanelSociosDeEquipo;


public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	JTabbedPane panelTabbed;  
	static Principal instance = null;

	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;    
	}
  
	public Principal() {
		super("Gestion Voleibol");
		this.setBounds(0, 0, 800, 600);
		panelTabbed = new JTabbedPane();

		PanelGestionSocios pgs = new PanelGestionSocios();
		PanelSociosDeEquipo psde = new PanelSociosDeEquipo();
		PanelClasificacion pc = new PanelClasificacion();
		
		panelTabbed.addTab("Gestión de Socios", pgs);
		panelTabbed.addTab("Socios de Equipo", psde);
		panelTabbed.addTab("Clasificación ", pc);
		
		panelTabbed.setSelectedIndex(0);
		this.getContentPane().add(panelTabbed);

	}

	public static void main(String[] args) {
		Principal.getInstance().setVisible(true);

	}

}
