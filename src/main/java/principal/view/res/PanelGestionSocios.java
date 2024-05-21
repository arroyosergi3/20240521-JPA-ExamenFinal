package principal.view.res;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;

import principal.controller.ControladorEquipo;
import principal.controller.ControladorSocio;
import principal.model.Equipo;
import principal.model.Socio;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;


import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelGestionSocios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfNombre;
	private JTextField jtfPrimerApellido;
	private JTextField jtfSegundoApellido;
	Socio currentSocio = null;
	private JSlider jsdAntiguedad;
	private JComboBox <Equipo>jcbEquipo;
	private JCheckBox chckbxSocioActivo;
	private JFormattedTextField jtfFechaNacimiento;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JLabel lblanios;




	/**
	 * Create the panel.
	 */
	public PanelGestionSocios() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		 btnPrimero = new JButton("");
		 btnPrimero.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		mostrarPrimero();
		 	}
		 });
		btnPrimero.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/principal/view/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		 btnAnterior = new JButton("");
		 btnAnterior.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		mostrarAnterior();
		 	}
		 });
		btnAnterior.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/principal/view/res/previous.png")));
		toolBar.add(btnAnterior);
		
		 btnSiguiente = new JButton("");
		 btnSiguiente.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		mostrarSiguiente();
		 	}
		 });
		btnSiguiente.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/principal/view/res/next.png")));
		toolBar.add(btnSiguiente);
		
		 btnUltimo = new JButton("");
		 btnUltimo.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		mostrarUltimo();
		 	}
		 });
		btnUltimo.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/principal/view/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		 btnNuevo = new JButton("");
		 btnNuevo.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		nuevo();
		 	}
		 });
		btnNuevo.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/principal/view/res/nuevo.png")));
		toolBar.add(btnNuevo);
		
		 btnGuardar = new JButton("");
		 btnGuardar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		guardarSocio();
		 	}
		 });
		btnGuardar.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/principal/view/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		 btnEliminar = new JButton("");
		 btnEliminar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		eliminar();
		 	}
		 });
		btnEliminar.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/principal/view/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 177, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblGestinDeSocios = new JLabel("Gestión de Socios");
		GridBagConstraints gbc_lblGestinDeSocios = new GridBagConstraints();
		gbc_lblGestinDeSocios.gridwidth = 3;
		gbc_lblGestinDeSocios.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeSocios.gridx = 0;
		gbc_lblGestinDeSocios.gridy = 0;
		panel.add(lblGestinDeSocios, gbc_lblGestinDeSocios);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.gridx = 0;
		gbc_lblPrimerApellido.gridy = 2;
		panel.add(lblPrimerApellido, gbc_lblPrimerApellido);
		
		jtfPrimerApellido = new JTextField();
		GridBagConstraints gbc_jtfPrimerApellido = new GridBagConstraints();
		gbc_jtfPrimerApellido.gridwidth = 2;
		gbc_jtfPrimerApellido.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPrimerApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrimerApellido.gridx = 1;
		gbc_jtfPrimerApellido.gridy = 2;
		panel.add(jtfPrimerApellido, gbc_jtfPrimerApellido);
		jtfPrimerApellido.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.gridx = 0;
		gbc_lblSegundoApellido.gridy = 3;
		panel.add(lblSegundoApellido, gbc_lblSegundoApellido);
		
		jtfSegundoApellido = new JTextField();
		GridBagConstraints gbc_jtfSegundoApellido = new GridBagConstraints();
		gbc_jtfSegundoApellido.gridwidth = 2;
		gbc_jtfSegundoApellido.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSegundoApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSegundoApellido.gridx = 1;
		gbc_jtfSegundoApellido.gridy = 3;
		panel.add(jtfSegundoApellido, gbc_jtfSegundoApellido);
		jtfSegundoApellido.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 0;
		gbc_lblFechaDeNacimiento.gridy = 4;
		panel.add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		
		 jtfFechaNacimiento = new JFormattedTextField();
		 jtfFechaNacimiento.addFocusListener(new FocusAdapter() {
		 	@Override
		 	public void focusLost(FocusEvent e) {
		 		esFechaValida();
		 	}
		 });
		GridBagConstraints gbc_jtfFechaNacimiento = new GridBagConstraints();
		gbc_jtfFechaNacimiento.gridwidth = 2;
		gbc_jtfFechaNacimiento.anchor = GridBagConstraints.NORTH;
		gbc_jtfFechaNacimiento.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaNacimiento.gridx = 1;
		gbc_jtfFechaNacimiento.gridy = 4;
		panel.add(jtfFechaNacimiento, gbc_jtfFechaNacimiento);
		
		JLabel lblAntigedadaos = new JLabel("Antigüedad (años):");
		GridBagConstraints gbc_lblAntigedadaos = new GridBagConstraints();
		gbc_lblAntigedadaos.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntigedadaos.gridx = 0;
		gbc_lblAntigedadaos.gridy = 5;
		panel.add(lblAntigedadaos, gbc_lblAntigedadaos);
		
		
		lblanios = new JLabel("New label");
		GridBagConstraints gbc_lblanios = new GridBagConstraints();
		gbc_lblanios.insets = new Insets(0, 0, 5, 0);
		gbc_lblanios.gridx = 2;
		gbc_lblanios.gridy = 5;
		panel.add(lblanios, gbc_lblanios);
		
		 jsdAntiguedad = new JSlider();
		 jsdAntiguedad.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		
		 			lblanios.setText(jsdAntiguedad.getValue() + " años");
				
		 		
		 	}
		 });
		 jsdAntiguedad.setMaximum(200);
		GridBagConstraints gbc_jsdAntiguedad = new GridBagConstraints();
		gbc_jsdAntiguedad.insets = new Insets(0, 0, 5, 5);
		gbc_jsdAntiguedad.gridx = 1;
		gbc_jsdAntiguedad.gridy = 5;
		panel.add(jsdAntiguedad, gbc_jsdAntiguedad);
		
		 
		
		 chckbxSocioActivo = new JCheckBox("Socio Activo");
		GridBagConstraints gbc_chckbxSocioActivo = new GridBagConstraints();
		gbc_chckbxSocioActivo.gridwidth = 3;
		gbc_chckbxSocioActivo.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxSocioActivo.gridx = 0;
		gbc_chckbxSocioActivo.gridy = 6;
		panel.add(chckbxSocioActivo, gbc_chckbxSocioActivo);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		GridBagConstraints gbc_lblEquipo = new GridBagConstraints();
		gbc_lblEquipo.insets = new Insets(0, 0, 0, 5);
		gbc_lblEquipo.anchor = GridBagConstraints.EAST;
		gbc_lblEquipo.gridx = 0;
		gbc_lblEquipo.gridy = 7;
		panel.add(lblEquipo, gbc_lblEquipo);
		
		 jcbEquipo = new JComboBox<Equipo>();
		GridBagConstraints gbc_jcbEquipo = new GridBagConstraints();
		gbc_jcbEquipo.gridwidth = 2;
		gbc_jcbEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEquipo.gridx = 1;
		gbc_jcbEquipo.gridy = 7;
		panel.add(jcbEquipo, gbc_jcbEquipo);
		
		//CARGO TODOS LOS EQUIPOS
		cargarTodosEquipos();
		
		//MUESTRO NADA MAS CREARSE EL PANEL EL PRIMERO
		mostrarPrimero();

	}
	
	public void eliminar() {
		try {
			String respuestas[] = new String[] {"Sí", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(
					null, 
					"¿Realmente desea eliminar el registro?", 
					"Eliminación de fabricante", 
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.WARNING_MESSAGE, 
			        null, respuestas, 
			        respuestas[1]);
		    
			if(opcionElegida == 0) {
				ControladorSocio.getInstance().remove(currentSocio);
		    	  
		    	  // Decido qué registro voy a mostrar en pantalla.
		    	  // Voy a comprobar si existe un anterior, si existe lo muestro
		    	  // Si no existe anterior compruebo si existe siguiente, 
		    	  // si existe lo muestro. En caso contrario, no quedan registros
		    	  // así que muestro en blanco la pantalla
		    	  this.currentSocio = ControladorSocio.getInstance().findPrevious(this.currentSocio.getId());
		    	  if (this.currentSocio != null) { // Existe un anterior, lo muestro
		    		  mostrarSocio(currentSocio);
		    	  }
		    	  else {
		    		  this.currentSocio = ControladorSocio.getInstance().findNext(this.currentSocio.getId());
			    	  if (this.currentSocio != null) { // Existe un anterior, lo muestro
			    		  mostrarSocio(currentSocio);
			    	  }
		    		  else { // No quedan registros en la tabla
		    			  nuevo();
		    		  }
		    	  }
		      }
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	
	}
	
	
	private void guardarSocio() {
		this.currentSocio.setNombre(this.jtfNombre.getText());
		this.currentSocio.setFechaNacimiento(getDateFromFormattedString("dd/MM/yyyy", this.jtfFechaNacimiento.getText()));
		this.currentSocio.setApellido1(this.jtfPrimerApellido.getText());
		this.currentSocio.setApellido2(this.jtfSegundoApellido.getText());
		this.currentSocio.setActivo(this.chckbxSocioActivo.isSelected());
		this.currentSocio.setAntiguedadAnios(this.jsdAntiguedad.getValue());
		this.currentSocio.setEquipo((Equipo) this.jcbEquipo.getSelectedItem());
		
		try {
			ControladorEquipo.getInstance().save(currentSocio);
			JOptionPane.showMessageDialog(null, "Socio guardado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "NO se ha guardado el contrato. ERROR");
		}
	}
	
	
	
	
	
	public void esFechaValida() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			sdf.parse(this.jtfFechaNacimiento.getText());
			this.jtfFechaNacimiento.setBackground(Color.WHITE);

		} catch (ParseException e) {
			this.jtfFechaNacimiento.setBackground(Color.RED);
			JOptionPane.showMessageDialog(null, "Error, la fecha no tiene un formato válido");
			
		}
		
	}
	
	
	
	
	
	
	public void nuevo() {
		currentSocio = new Socio();
		this.currentSocio.setId(0);
		this.jtfNombre.setText("");
		this.jtfPrimerApellido.setText("");
		this.jtfSegundoApellido.setText("");
		this.jtfFechaNacimiento.setText("");
		this.jsdAntiguedad.setValue(0);
		this.chckbxSocioActivo.setSelected(true);
		
	}
	
	
	public void mostrarPrimero() {
		Socio s = ControladorSocio.getInstance().findFirst();
		if (s != null) {
			mostrarSocio(s);
		}
	}
	
	
	public void mostrarAnterior() {
		Socio s = ControladorSocio.getInstance().findPrevious(currentSocio.getId());
		if (s != null) {
			mostrarSocio(s);
		}
	}
	
	
	public void mostrarSiguiente() {
		Socio s = ControladorSocio.getInstance().findNext(currentSocio.getId());
		if (s != null) {
			mostrarSocio(s);
		}
	}
	
	
	public void mostrarUltimo() {
		Socio s = ControladorSocio.getInstance().findLast();
		if (s != null) {
			mostrarSocio(s);
		}
	}
	
	
	
	public void mostrarSocio(Socio s) {
		if (s != null) {
			currentSocio = s;
		}
		this.jtfNombre.setText(currentSocio.getNombre());
		this.jtfFechaNacimiento.setText(getFormattedStringFromDate("dd/MM/yyyy", currentSocio.getFechaNacimiento()));
		this.jtfPrimerApellido.setText(currentSocio.getApellido1());
		this.jtfSegundoApellido.setText(currentSocio.getApellido2());
		this.jsdAntiguedad.setValue(currentSocio.getAntiguedadAnios());
		this.chckbxSocioActivo.setSelected(currentSocio.getActivo());
		
		
		for (int i = 0; i < this.jcbEquipo.getItemCount(); i++) {
			Equipo e = this.jcbEquipo.getItemAt(i);
			if (e.getId() == currentSocio.getEquipo().getId()) {
				this.jcbEquipo.setSelectedIndex(i);
			}
		}
		lblanios.setText(currentSocio.getAntiguedadAnios() + " años");
		
	}
	
	
	
	
	public void cargarTodosEquipos() {
		List<Equipo> l = (List<Equipo>) ControladorEquipo.getInstance().findAll();
		
		for (Equipo equipo : l) {
			this.jcbEquipo.addItem(equipo);
		}
	}
	
	
	public static String getFormattedStringFromDate (String dateFormat, Date date) {
		try {
			return new SimpleDateFormat(dateFormat).format(date);
		}
		catch (Exception ex) {
			System.out.println("Unable to format date: " + date + " with format: " + dateFormat);
			return "";
		}
	}
	
	
	
	public static Date getDateFromFormattedString (String dateFormat, String strDate) {
		try {
			return new SimpleDateFormat(dateFormat).parse(strDate);
		}
		catch (Exception ex) {
		
			System.out.println("Unable to parse string: " + strDate + " to java.util.Date with format: " + dateFormat);
			return null;
		}
	}
	
	
	
	
	
	
	
	

}
