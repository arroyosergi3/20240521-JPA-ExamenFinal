package principal.view.res;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import java.util.List;

import javax.swing.JScrollPane;
import principal.controller.ControladorEquipo;
import principal.model.Equipo;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelClasificacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnReset;
	private JButton btnArriba;
	private JButton btnAbajo;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JList<Equipo> list;
	private DefaultListModel<Equipo> currentDlm = null;

	/**
	 * Create the panel.
	 */
	public PanelClasificacion() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblClaficiacin = new JLabel("Claficiación");
		GridBagConstraints gbc_lblClaficiacin = new GridBagConstraints();
		gbc_lblClaficiacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblClaficiacin.gridx = 0;
		gbc_lblClaficiacin.gridy = 0;
		add(lblClaficiacin, gbc_lblClaficiacin);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEquipos();
			}
		});
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 5, 0);
		gbc_btnReset.gridx = 1;
		gbc_btnReset.gridy = 1;
		add(btnReset, gbc_btnReset);

		btnArriba = new JButton("Arriba");
		btnArriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arriba();
			}
		});
		GridBagConstraints gbc_btnArriba = new GridBagConstraints();
		gbc_btnArriba.insets = new Insets(0, 0, 5, 0);
		gbc_btnArriba.gridx = 1;
		gbc_btnArriba.gridy = 2;
		add(btnArriba, gbc_btnArriba);

		btnAbajo = new JButton("Abajo");
		btnAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abajo();
			}
		});
		GridBagConstraints gbc_btnAbajo = new GridBagConstraints();
		gbc_btnAbajo.insets = new Insets(0, 0, 5, 0);
		gbc_btnAbajo.gridx = 1;
		gbc_btnAbajo.gridy = 3;
		add(btnAbajo, gbc_btnAbajo);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminar.gridx = 1;
		gbc_btnEliminar.gridy = 4;
		add(btnEliminar, gbc_btnEliminar);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		list = new JList<Equipo>();
		scrollPane.setViewportView(list);
		mostrarEquipos();

	}
	
	
	public void arriba() {
		if (this.list.getSelectedIndex() > 0) {
			int pos = this.list.getSelectedIndex();
			Equipo e1 = this.currentDlm.get(list.getSelectedIndex());
//			System.out.println(e1.getDescripcion() + " posicion: " + list.getSelectedIndex());
			
			Equipo e2 = this.currentDlm.get(list.getSelectedIndex() - 1);
//			System.out.println(e2.getDescripcion() + " posicion: " + (list.getSelectedIndex() - 1));

//			System.out.println(this.currentDlm.getSize());

			this.currentDlm.insertElementAt(e1, list.getSelectedIndex() - 1);
			this.currentDlm.insertElementAt(e2, list.getSelectedIndex());
			
//			System.out.println( "tamaño total: " + this.currentDlm.getSize());
//			System.out.println("Posiciones a borrar " + (list.getSelectedIndex() +1) + " , " + (list.getSelectedIndex() +2) );
			this.currentDlm.remove(list.getSelectedIndex() +1);
			this.currentDlm.remove(list.getSelectedIndex());
		
			
			
			this.list.setSelectedIndex(pos - 1);
		}
		
	}
	
	
	
	
	
	public void abajo() {
//		System.out.println(list.getSelectedIndex() + " es menor que " + currentDlm.getSize() + " ?");
		if ((this.list.getSelectedIndex() + 1) < currentDlm.getSize()) {
			int pos = this.list.getSelectedIndex();
			Equipo e1 = this.currentDlm.get(list.getSelectedIndex());
//			System.out.println(e1.getDescripcion() + " posicion: " + list.getSelectedIndex());
			
			Equipo e2 = this.currentDlm.get(list.getSelectedIndex() + 1);
//			System.out.println(e2.getDescripcion() + " posicion: " + (list.getSelectedIndex() + 1));

//			System.out.println(this.currentDlm.getSize());

			this.currentDlm.insertElementAt(e1, list.getSelectedIndex() + 1);
			this.currentDlm.insertElementAt(e2, list.getSelectedIndex());
			
//			System.out.println( "tamaño total: " + this.currentDlm.getSize());
//			System.out.println("Posiciones a borrar " + (list.getSelectedIndex() +1) + " , " + (list.getSelectedIndex() +2) );
			
//			Equipo e3 = this.currentDlm.get(list.getSelectedIndex() + 1);
//			System.out.println("Eliminando a " + e3.getDescripcion() + " posicion: " + (list.getSelectedIndex() + 1));
			
			this.currentDlm.remove(list.getSelectedIndex() + 1);
			this.currentDlm.remove(list.getSelectedIndex() + 2);
		
			
			
			this.list.setSelectedIndex(pos + 1);
		}
		
	}
	
	

	public void eliminar() {
		currentDlm.remove(list.getSelectedIndex());
	}
	
	
	
	public void mostrarEquipos() {
		if (currentDlm != null) {
			currentDlm.clear();

		}
		
		
	
		List<Equipo> todosEquipos = (List<Equipo>) ControladorEquipo.getInstance().findAll();
		DefaultListModel<Equipo> dlm = new DefaultListModel<Equipo>();
		dlm.addAll(todosEquipos);
		list = new JList<Equipo>(dlm);
		this.scrollPane.setViewportView(list);
		currentDlm = dlm;
	}

}
