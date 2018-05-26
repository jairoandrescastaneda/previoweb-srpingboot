package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inscripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Inscripcion.findAll", query="SELECT i FROM Inscripcion i")
public class Inscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="idequipo")
	private Equipo equipo;

	//bi-directional many-to-one association to Jornada
	@ManyToOne
	@JoinColumn(name="idjornada")
	private Jornada jornada;

	//bi-directional many-to-one association to Solucion
	@OneToMany(mappedBy="inscripcion")
	private List<Solucion> solucions;

	public Inscripcion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Jornada getJornada() {
		return this.jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public List<Solucion> getSolucions() {
		return this.solucions;
	}

	public void setSolucions(List<Solucion> solucions) {
		this.solucions = solucions;
	}

	public Solucion addSolucion(Solucion solucion) {
		getSolucions().add(solucion);
		solucion.setInscripcion(this);

		return solucion;
	}

	public Solucion removeSolucion(Solucion solucion) {
		getSolucions().remove(solucion);
		solucion.setInscripcion(null);

		return solucion;
	}

}