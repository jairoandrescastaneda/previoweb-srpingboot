package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the participante database table.
 * 
 */
@Table(name="participante")
@Entity
@NamedQuery(name="Participante.findAll", query="SELECT p FROM Participante p")
public class Participante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String clave;

	private String correo;

	private String genero;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Equipo
	@JsonBackReference
	@OneToMany(mappedBy="participante")
	private List<Equipo> equipos1;

	//bi-directional many-to-many association to Equipo
	@ManyToMany
	@JoinTable(
		name="equipoparticipante"
		, joinColumns={
			@JoinColumn(name="idparticipante")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idequipo")
			}
		)
	private List<Equipo> equipos2;

	public Participante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Equipo> getEquipos1() {
		return this.equipos1;
	}

	public void setEquipos1(List<Equipo> equipos1) {
		this.equipos1 = equipos1;
	}

	public Equipo addEquipos1(Equipo equipos1) {
		getEquipos1().add(equipos1);
		equipos1.setParticipante(this);

		return equipos1;
	}

	public Equipo removeEquipos1(Equipo equipos1) {
		getEquipos1().remove(equipos1);
		equipos1.setParticipante(null);

		return equipos1;
	}

	public List<Equipo> getEquipos2() {
		return this.equipos2;
	}

	public void setEquipos2(List<Equipo> equipos2) {
		this.equipos2 = equipos2;
	}

}