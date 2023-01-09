package com.kruger.usuario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kruger.usuario.model.Usuario;
import com.kruger.usuario.model.service.usuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	usuarioService service; 
	
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json" )
	public Iterable<Usuario> findAll(){
		return service.findAll();
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Usuario> save(@RequestBody Usuario entity) {
		
		 
		try {
			Usuario guardar=service.save(entity);
			 return ResponseEntity.ok(guardar);
		    } catch (Exception e) {
		        throw new ResponseStatusException(
		                HttpStatus.INTERNAL_SERVER_ERROR,
		                "Failed to save request", e);
		    }
		
	}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public Usuario edit(@PathVariable Integer id, @RequestBody Usuario entity) {
		return service.save(entity);
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}
	 @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	 public Optional<Usuario> findById(@PathVariable Integer id){
		return service.findById(id);
	}
	 
	//buscar direccion adicionales de usuarios mendiante id_user
		 @RequestMapping(value = "/showname/{name}", method = RequestMethod.GET, produces = "application/json")
		 	public Iterable<Usuario>  findBynombres(@PathVariable String name){
			return service.findBynombres(name);
	}
		 
		//buscar direccion adicionales de usuarios mendiante id_user
		 @RequestMapping(value = "/showid/{id}", method = RequestMethod.GET, produces = "application/json")
		 	public Iterable<Usuario>  findBynumeroIdentificación(@PathVariable String id){
			return service.findBynumeroIdentificación(id);
	}

}
