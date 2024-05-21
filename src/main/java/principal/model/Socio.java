package principal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the socio database table.
 * 
 */
@Entity
@Table(name="socio")
@NamedQuery(name="Socio.findAll", query="SELECT s FROM Socio s")
public class Socio extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private boolean activo;

	private int antiguedadAnios;

	private String apellido1;

	private String apellido2;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	private String nombre;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="idEquipo")
	private Equipo equipo;

	public Socio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getAntiguedadAnios() {
		return this.antiguedadAnios;
	}

	public void setAntiguedadAnios(int antiguedadAnios) {
		this.antiguedadAnios = antiguedadAnios;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

}