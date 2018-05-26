package Controllers;

import org.mockito.internal.matchers.EqualsWithDelta;

import Dao.DaoEquipo;
import Dao.DaoParticipante;
import Dao.DaoUniversidad;
import model.Equipo;
import model.Participante;
import model.Universidad;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		
		Participante p = new  Participante();
		DaoParticipante daoparticipante = new DaoParticipante();
		
		p.setClave("prueba2232");
		p.setCorreo("prueba323s2@pruebas.com");
		p.setGenero("M");
		p.setNombre("josue");
		p.setTelefono("232");
		daoparticipante.insert(p);
		
		//buscar participante
		p = daoparticipante.find(1);
		
		
		Universidad u = new Universidad();
		DaoUniversidad daouniversidad = new DaoUniversidad();
		//u.setCiudad("Cucuta");
		//u.setNombre("Ufps");
		//daouniversidad.insert(u);
		
		
		//buscar universidad
		u = daouniversidad.find(1);
		
		Equipo equipo = new Equipo();
		equipo.setNombre("Barcelona");
		equipo.setParticipante(p);
		equipo.setUniversidadBean(u);
		DaoEquipo daoequipo = new DaoEquipo();
		daoequipo.insert(equipo);
		
		
		
	}
}
