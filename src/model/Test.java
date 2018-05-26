package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int puntos;

	//bi-directional many-to-one association to Solucion
	@OneToMany(mappedBy="test")
	private List<Solucion> solucions;

	//bi-directional many-to-one association to Ejercicio
	@ManyToOne
	@JoinColumn(name="idejercicio")
	private Ejercicio ejercicio;

	//bi-directional many-to-one association to Jornada
	@ManyToOne
	@JoinColumn(name="idjornada")
	private Jornada jornada;

	public Test() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public List<Solucion> getSolucions() {
		return this.solucions;
	}

	public void setSolucions(List<Solucion> solucions) {
		this.solucions = solucions;
	}

	public Solucion addSolucion(Solucion solucion) {
		getSolucions().add(solucion);
		solucion.setTest(this);

		return solucion;
	}

	public Solucion removeSolucion(Solucion solucion) {
		getSolucions().remove(solucion);
		solucion.setTest(null);

		return solucion;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Jornada getJornada() {
		return this.jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

}