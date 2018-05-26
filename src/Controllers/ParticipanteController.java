package Controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Dao.DaoParticipante;
import model.Equipo;
import model.Participante;

@RestController
public class ParticipanteController {

	
	public ParticipanteController() {
		// TODO Auto-generated constructor stub
	}
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/participante/")
	@ResponseBody
	public ArrayList<Participante>listarParticipante(){
		DaoParticipante daoparticipante = new DaoParticipante();
		return (ArrayList<Participante>) daoparticipante.list();
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/participante/create/" , params = {
	"clave",
	"genero",
	"telefono",
	"nombre",
	"correo"
	}
	,
	method=RequestMethod.POST)
	public ResponseEntity CrearParticipante(@RequestParam("clave") String clave,
			@RequestParam("correo") String correo, @RequestParam("genero") String genero, 
			@RequestParam("nombre") String nombre , @RequestParam("telefono") String telefono)
	{
		
		Participante  p = new Participante();
			p.setNombre(nombre);
		p.setClave(clave);
		p.setCorreo(correo);
		p.setTelefono(telefono);
		
		DaoParticipante dao = new DaoParticipante();
		
		dao.insert(p);
		
		
		
		return ResponseEntity.ok(HttpStatus.OK);
	}

	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/participante/edit/",
			 params = {
						"clave",
						"genero",
						"telefono",
						"nombre",
						"correo",
						"id"
						},
			 method=RequestMethod.POST)
	public ResponseEntity Editar(@RequestParam("clave") String clave,
			@RequestParam("correo") String correo, @RequestParam("genero") String genero, 
			@RequestParam("nombre") String nombre , @RequestParam("telefono") String telefono,
			@RequestParam("id") int  id) {
		
		Participante  p = new Participante();
		DaoParticipante dao = new DaoParticipante();
		p = dao.find(id);
			p.setNombre(nombre);
		p.setClave(clave);
		p.setCorreo(correo);
		p.setTelefono(telefono);
		
		
		
		dao.update(p);
		
		
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/participante/delete/", params = {
			"id_participante"
			
			},method=RequestMethod.POST)
	public ResponseEntity Borrado(
			@RequestParam("id_particiopante") int  id_participante) {
		
		Participante  p = new Participante();
		DaoParticipante dao = new DaoParticipante();
		p = dao.find(id_participante);
		dao.delete(p);
		
		
		
		
		
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	
}
