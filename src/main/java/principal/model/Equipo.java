package principal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipo database table.
 * 
 */
@Entity
@Table(name="equipo")
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Socio
	@OneToMany(mappedBy="equipo")
	private List<Socio> socios;

	public Equipo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Socio> getSocios() {
		return this.socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}

	public Socio addSocio(Socio socio) {
		getSocios().add(socio);
		socio.setEquipo(this);

		return socio;
	}

	public Socio removeSocio(Socio socio) {
		getSocios().remove(socio);
		socio.setEquipo(null);

		return socio;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
	
	

}