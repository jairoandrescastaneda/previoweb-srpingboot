package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lenguaje database table.
 * 
 */
@Entity
@NamedQuery(name="Lenguaje.findAll", query="SELECT l FROM Lenguaje l")
public class Lenguaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Solucion
	@OneToMany(mappedBy="lenguaje")
	private List<Solucion> solucions;

	public Lenguaje() {
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

	public List<Solucion> getSolucions() {
		return this.solucions;
	}

	public void setSolucions(List<Solucion> solucions) {
		this.solucions = solucions;
	}

	public Solucion addSolucion(Solucion solucion) {
		getSolucions().add(solucion);
		solucion.setLenguaje(this);

		return solucion;
	}

	public Solucion removeSolucion(Solucion solucion) {
		getSolucions().remove(solucion);
		solucion.setLenguaje(null);

		return solucion;
	}

}