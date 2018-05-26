package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the jornada database table.
 * 
 */
@Entity
@NamedQuery(name="Jornada.findAll", query="SELECT j FROM Jornada j")
public class Jornada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time horafin;

	private Time horaini;

	private String lugar;

	//bi-directional many-to-one association to Inscripcion
	@OneToMany(mappedBy="jornada")
	private List<Inscripcion> inscripcions;

	//bi-directional many-to-one association to Ambito
	@ManyToOne
	@JoinColumn(name="idambito")
	private Ambito ambito;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="jornada")
	private List<Test> tests;

	public Jornada() {
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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHorafin() {
		return this.horafin;
	}

	public void setHorafin(Time horafin) {
		this.horafin = horafin;
	}

	public Time getHoraini() {
		return this.horaini;
	}

	public void setHoraini(Time horaini) {
		this.horaini = horaini;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public List<Inscripcion> getInscripcions() {
		return this.inscripcions;
	}

	public void setInscripcions(List<Inscripcion> inscripcions) {
		this.inscripcions = inscripcions;
	}

	public Inscripcion addInscripcion(Inscripcion inscripcion) {
		getInscripcions().add(inscripcion);
		inscripcion.setJornada(this);

		return inscripcion;
	}

	public Inscripcion removeInscripcion(Inscripcion inscripcion) {
		getInscripcions().remove(inscripcion);
		inscripcion.setJornada(null);

		return inscripcion;
	}

	public Ambito getAmbito() {
		return this.ambito;
	}

	public void setAmbito(Ambito ambito) {
		this.ambito = ambito;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setJornada(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setJornada(null);

		return test;
	}

}