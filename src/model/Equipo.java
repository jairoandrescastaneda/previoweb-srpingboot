package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipo database table.
 * 
 */
@Table(name="equipo")
@Entity
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Participante
	@ManyToOne
	@JoinColumn(name="couch")
	private Participante participante;

	//bi-directional many-to-one association to Universidad
	@ManyToOne
	@JoinColumn(name="universidad",insertable=false, updatable=false)
	private Universidad universidadBean;

	//bi-directional many-to-many association to Participante
	@ManyToMany(mappedBy="equipos2")
	private List<Participante> participantes;

	//bi-directional many-to-one association to Inscripcion
	@OneToMany(mappedBy="equipo")
	private List<Inscripcion> inscripcions;

	public Equipo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Participante getParticipante() {
		return this.participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Universidad getUniversidadBean() {
		return this.universidadBean;
	}

	public void setUniversidadBean(Universidad universidadBean) {
		this.universidadBean = universidadBean;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public List<Inscripcion> getInscripcions() {
		return this.inscripcions;
	}

	public void setInscripcions(List<Inscripcion> inscripcions) {
		this.inscripcions = inscripcions;
	}

	public Inscripcion addInscripcion(Inscripcion inscripcion) {
		getInscripcions().add(inscripcion);
		inscripcion.setEquipo(this);

		return inscripcion;
	}

	public Inscripcion removeInscripcion(Inscripcion inscripcion) {
		getInscripcions().remove(inscripcion);
		inscripcion.setEquipo(null);

		return inscripcion;
	}

}