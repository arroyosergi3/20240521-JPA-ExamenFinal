package principal.view.res;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.persistence.internal.jpa.metadata.structures.ArrayAccessor;

import principal.controller.ControladorEquipo;
import principal.controller.DatosDeTabla;
import principal.model.Equipo;
import principal.model.Socio;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelSociosDeEquipo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JComboBox <Equipo> jcbEquipo;
	private JRadioButton rdbtnNombre;
	private JRadioButton rdbtnPrimerApellido;
	private JRadioButton rdbtnSegundoApellido;
	private JRadioButton rdbtnFechaNacimiento;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTablaTodos();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();
	private DefaultTableModel dtm = null;
	private JScrollPane scrollPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public List<Socio> currentSociosMostrados = null;
	


	/**
	 * Create the panel.
	 */
	public PanelSociosDeEquipo() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{173, 250, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblSociosDeEquipos = new JLabel("Socios de Equipos");
		GridBagConstraints gbc_lblSociosDeEquipos = new GridBagConstraints();
		gbc_lblSociosDeEquipos.gridwidth = 2;
		gbc_lblSociosDeEquipos.insets = new Insets(0, 0, 5, 0);
		gbc_lblSociosDeEquipos.gridx = 0;
		gbc_lblSociosDeEquipos.gridy = 0;
		add(lblSociosDeEquipos, gbc_lblSociosDeEquipos);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		GridBagConstraints gbc_lblEquipo = new GridBagConstraints();
		gbc_lblEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipo.anchor = GridBagConstraints.EAST;
		gbc_lblEquipo.gridx = 0;
		gbc_lblEquipo.gridy = 1;
		add(lblEquipo, gbc_lblEquipo);
		
		 jcbEquipo = new JComboBox<Equipo>();
		 
		 jcbEquipo.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		cambiarTabla();
		 	}
		 });
		GridBagConstraints gbc_jcbEquipo = new GridBagConstraints();
		gbc_jcbEquipo.insets = new Insets(0, 0, 5, 0);
		gbc_jcbEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEquipo.gridx = 1;
		gbc_jcbEquipo.gridy = 1;
		add(jcbEquipo, gbc_jcbEquipo);
		
		 rdbtnNombre = new JRadioButton("Ordenar Por Nombre");
		 rdbtnNombre.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ordenar();
		 	}
		 });
		 cargarTodosEquipos();
		 buttonGroup.add(rdbtnNombre);
		GridBagConstraints gbc_rdbtnNombre = new GridBagConstraints();
		gbc_rdbtnNombre.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNombre.gridx = 0;
		gbc_rdbtnNombre.gridy = 2;
		add(rdbtnNombre, gbc_rdbtnNombre);
		
		 rdbtnPrimerApellido = new JRadioButton("Ordenar Por Primer Apellido");
		 rdbtnPrimerApellido.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ordenar();
		 	}
		 });
		 buttonGroup.add(rdbtnPrimerApellido);
		GridBagConstraints gbc_rdbtnPrimerApellido = new GridBagConstraints();
		gbc_rdbtnPrimerApellido.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnPrimerApellido.gridx = 1;
		gbc_rdbtnPrimerApellido.gridy = 2;
		add(rdbtnPrimerApellido, gbc_rdbtnPrimerApellido);
		
		 rdbtnSegundoApellido = new JRadioButton("Ordenar Por Segundo Apellido");
		 rdbtnSegundoApellido.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ordenar();
		 	}
		 });
		 buttonGroup.add(rdbtnSegundoApellido);
		GridBagConstraints gbc_rdbtnSegundoApellido = new GridBagConstraints();
		gbc_rdbtnSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSegundoApellido.gridx = 0;
		gbc_rdbtnSegundoApellido.gridy = 3;
		add(rdbtnSegundoApellido, gbc_rdbtnSegundoApellido);
		
		 rdbtnFechaNacimiento = new JRadioButton("Ordenar Por Fecha de Nacimiento");
		 rdbtnFechaNacimiento.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ordenar();
		 	}
		 });
		 buttonGroup.add(rdbtnFechaNacimiento);
		GridBagConstraints gbc_rdbtnFechaNacimiento = new GridBagConstraints();
		gbc_rdbtnFechaNacimiento.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnFechaNacimiento.gridx = 1;
		gbc_rdbtnFechaNacimiento.gridy = 3;
		add(rdbtnFechaNacimiento, gbc_rdbtnFechaNacimiento);
		
		 scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		

		Equipo equipo = (Equipo) this.jcbEquipo.getSelectedItem();
		currentSociosMostrados = (List<Socio>) DatosDeTabla.getListaDeSocios(equipo);
		
		this.dtm = getDefaultTableModelNoEditable();
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				// Compruebo el doble clic
				if (e.getClickCount() > 1) {
					if (table.getSelectedRow() > -1) {
						
						mostrarInfoDeSocio(currentSociosMostrados.get(table.getSelectedRow()));
					}
				}
			}
			
		});
		
		cambiarTabla();
		
	}
	
	
	
	public void cambiarTabla() {
		if (rdbtnFechaNacimiento != null) {
			rdbtnFechaNacimiento.setSelected(false);
			rdbtnNombre.setSelected(false);
			rdbtnPrimerApellido.setSelected(false);
			rdbtnSegundoApellido.setSelected(false);
		}

		Equipo eq = (Equipo) this.jcbEquipo.getSelectedItem();
		Object[][]  l = DatosDeTabla.getDatosDeTabla(eq);
		this.dtm = new DefaultTableModel(l, titulosEnTabla) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		if (scrollPane != null) {
			this.table = new JTable(dtm);
			this.scrollPane.setViewportView(this.table);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					
					// Compruebo el doble clic
					if (e.getClickCount() > 1) {
						if (table.getSelectedRow() > -1) {
							
							mostrarInfoDeSocio(currentSociosMostrados.get(table.getSelectedRow()));
						}
					}
				}
				
			});
		}
		
		
	}
	
	
	public void mostrarInfoDeSocio(Socio s) {
		JOptionPane.showMessageDialog(null, "Has seleccionado a " + s.getNombre() + " con id: " + s.getId());
	}
	
	public void ordenar(){
		Object[][]  l = null;
		Equipo eq = (Equipo) this.jcbEquipo.getSelectedItem();
		if (rdbtnFechaNacimiento.isSelected()) {
			l = DatosDeTabla.getDatosDeTablaOrdenados("fechaNacimiento",eq);
		}
		if (rdbtnNombre.isSelected()) {
			l = DatosDeTabla.getDatosDeTablaOrdenados("nombre", eq);
		}
		if (rdbtnPrimerApellido.isSelected()) {
			l = DatosDeTabla.getDatosDeTablaOrdenados("apellido1", eq);
		}
		if (rdbtnSegundoApellido.isSelected()) {
			l = DatosDeTabla.getDatosDeTablaOrdenados("apellido2", eq);
		}
		
		this.dtm = new DefaultTableModel(l, titulosEnTabla) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.table = new JTable(dtm);
		this.scrollPane.setViewportView(this.table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				// Compruebo el doble clic
				if (e.getClickCount() > 1) {
					if (table.getSelectedRow() > -1) {
						
						mostrarInfoDeSocio(currentSociosMostrados.get(table.getSelectedRow()));
					}
				}
			}
			
		});
		
	}
	
	
	
	
	
	private DefaultTableModel getDefaultTableModelNoEditable() {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {

			/**
			 * La sobreescritura de este método nos permite controlar qué celdas queremos
			 * que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
//				if (column != 1) {
//					return false;
//				}
//				return false;
				return false;
			}
		};
		return dtm;
	}

	
	
	
	
	
	public void cargarTodosEquipos() {
		List<Equipo> l = (List<Equipo>) ControladorEquipo.getInstance().findAll();
		
		for (Equipo equipo : l) {
			this.jcbEquipo.addItem(equipo);
		}
	}
	
	
	
	
	
	

}
