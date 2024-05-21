package principal;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


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
		super("Gestion de Ficheros");
		this.setBounds(0, 0, 800, 600);
		panelTabbed = new JTabbedPane();

		PanelCopiaFicheros pcf = new PanelCopiaFicheros();
		PanelTablaYFicheros ptyf = new PanelTablaYFicheros();
		PanelTablaConSlider ptcs = new PanelTablaConSlider();
		panelTabbed.addTab("Copiado de Carpetas", pcf);
		panelTabbed.addTab("Busqueda de Ficheros", ptyf);
		panelTabbed.addTab("Selección ficheros por tamaño", ptcs);
		
		panelTabbed.setSelectedIndex(0);
		this.getContentPane().add(panelTabbed);

	}

	public static void main(String[] args) {
		Principal.getInstance().setVisible(true);

	}

}
