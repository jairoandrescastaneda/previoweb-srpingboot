package Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Dao.DaoParticipante;
import Dao.DaoUniversidad;
import model.Participante;
import model.Universidad;

@RestController
public class UniversidadController {

	public UniversidadController() {
		// TODO Auto-generated constructor stub
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/universidad/")
	@ResponseBody
	public ArrayList<Universidad>listarParticipante(){
		DaoUniversidad daouniversidad = new DaoUniversidad();
		return (ArrayList<Universidad>) daouniversidad.list();
	}
	

}
