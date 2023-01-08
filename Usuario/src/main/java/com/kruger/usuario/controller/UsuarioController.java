package com.kruger.usuario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public Usuario save(@RequestBody Usuario entity) {
		return service.save(entity);
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

}
