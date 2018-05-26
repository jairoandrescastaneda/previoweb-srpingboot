package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the solucion database table.
 * 
 */
@Entity
@NamedQuery(name="Solucion.findAll", query="SELECT s FROM Solucion s")
public class Solucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte correcta;

	@Lob
	private String solucion;

	//bi-directional many-to-one association to Inscripcion
	@ManyToOne
	@JoinColumn(name="idinscripcion")
	private Inscripcion inscripcion;

	//bi-directional many-to-one association to Lenguaje
	@ManyToOne
	@JoinColumn(name="idlenguaje")
	private Lenguaje lenguaje;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="idtest")
	private Test test;

	public Solucion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getCorrecta() {
		return this.correcta;
	}

	public void setCorrecta(byte correcta) {
		this.correcta = correcta;
	}

	public String getSolucion() {
		return this.solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public Inscripcion getInscripcion() {
		return this.inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public Lenguaje getLenguaje() {
		return this.lenguaje;
	}

	public void setLenguaje(Lenguaje lenguaje) {
		this.lenguaje = lenguaje;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}