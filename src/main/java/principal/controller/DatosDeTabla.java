package principal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import principal.model.Equipo;
import principal.model.Socio;

public class DatosDeTabla {

	private static Object[][] datos = null;
 	
	
	public static List<Socio> getListaDeSocios(Equipo eq){
		return (List<Socio>) ControladorSocio.getInstance().findAllDeEquipo(eq);
		
	}
	
	public static List<Socio> getListaDeSociosOrdenados(String campo , Equipo eq){
		return (List<Socio>) ControladorSocio.getInstance().findOrdenados(campo, eq);
		
	}
	
	
	
	
	public static Object[][] getDatosDeTablaOrdenados(String campo, Equipo eq){
		List<Socio> sociosOrdenados = (List<Socio>) ControladorSocio.getInstance().findOrdenados(campo, eq);
		datos = new Object[sociosOrdenados.size()][4];
		for (int i = 0; i < sociosOrdenados.size(); i++) {
			Socio e = sociosOrdenados.get(i);
			datos[i][0] = e.getNombre();
			datos[i][1] = e.getApellido1();
			datos[i][2] = e.getApellido2();
			datos[i][3] = getFormattedStringFromDate("dd/MM/yyyy", e.getFechaNacimiento());
		}
		return datos;
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
	
	
	
	
	
	
	public static String[] getTitulosColumnas() {
		return new String[] {"Nombre", "Primer Apellido", "Segundo Apellido", "Fecha de Nacimiento"};
	}
	
	
	public static Object[][] getDatosDeTabla(Equipo eq) {
		if (datos == null) {
			List<Socio> contratos = (List<Socio>) ControladorSocio.getInstance().findAllDeEquipo(eq);
			datos = new Object[contratos.size()][4];
			for (int i = 0; i < contratos.size(); i++) {
				Socio e = contratos.get(i);
				datos[i][0] = e.getNombre();
				datos[i][1] = e.getApellido1();
				datos[i][2] = e.getApellido2();
				datos[i][3] = getFormattedStringFromDate("dd/MM/yyyy", e.getFechaNacimiento());
				
//				System.out.println("Dato añadido a tabla: " + datos[i][0]);
			}
		}
		
		return datos;
	}

	public static Object[][] getDatosDeTablaTodos() {
		if (datos == null) {
			List<Socio> contratos = (List<Socio>) ControladorSocio.getInstance().findAll();
			datos = new Object[contratos.size()][4];
			for (int i = 0; i < contratos.size(); i++) {
				Socio e = contratos.get(i);
				datos[i][0] = e.getNombre();
				datos[i][1] = e.getApellido1();
				datos[i][2] = e.getApellido2();
				datos[i][3] = getFormattedStringFromDate("dd/MM/yyyy", e.getFechaNacimiento());
				
//				System.out.println("Dato añadido a tabla: " + datos[i][0]);
			}
		}
		
		return datos;
	}
	
	
}
