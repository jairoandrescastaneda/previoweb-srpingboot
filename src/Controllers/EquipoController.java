package Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Dao.DaoParticipante;
import model.Participante;

@RestController
public class EquipoController {

	public EquipoController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/equipo/create/" , params = {
	"nombre",
	"participante",
	"universidad"
	}
	,
	method=RequestMethod.POST)
	public ResponseEntity Crear(@RequestParam("nombre") String nombre,
			@RequestParam("participante") String correo, 
			@RequestParam("universidad") String universidad )
	{
		
		
		
		return ResponseEntity.ok(HttpStatus.OK);
	}

}
