package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ejercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Ejercicio.findAll", query="SELECT e FROM Ejercicio e")
public class Ejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String enunciado;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="ejercicio")
	private List<Test> tests;

	public Ejercicio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnunciado() {
		return this.enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setEjercicio(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setEjercicio(null);

		return test;
	}

}