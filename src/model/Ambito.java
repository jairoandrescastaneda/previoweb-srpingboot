package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ambito database table.
 * 
 */
@Entity
@NamedQuery(name="Ambito.findAll", query="SELECT a FROM Ambito a")
public class Ambito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Jornada
	@OneToMany(mappedBy="ambito")
	private List<Jornada> jornadas;

	public Ambito() {
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

	public List<Jornada> getJornadas() {
		return this.jornadas;
	}

	public void setJornadas(List<Jornada> jornadas) {
		this.jornadas = jornadas;
	}

	public Jornada addJornada(Jornada jornada) {
		getJornadas().add(jornada);
		jornada.setAmbito(this);

		return jornada;
	}

	public Jornada removeJornada(Jornada jornada) {
		getJornadas().remove(jornada);
		jornada.setAmbito(null);

		return jornada;
	}

}