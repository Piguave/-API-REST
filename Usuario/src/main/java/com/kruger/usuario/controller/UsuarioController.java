package com.kruger.usuario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kruger.usuario.model.Usuario;
import com.kruger.usuario.model.repository.usuarioRepository;
import com.kruger.usuario.model.service.usuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	usuarioService service; 
	@Autowired 
	usuarioRepository repository_U;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json" )
	public Iterable<Usuario> findAll(){
		return service.findAll();
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Usuario> save(@RequestBody Usuario entity) {
		
        Optional<Usuario> peopleExistsIdenti = repository_U.findBynumeroIdentificación(entity.getNumeroIdentificación()); 
        
        if (peopleExistsIdenti.isEmpty()) {
        	//return  service.save(entity);
        	
        	try {
    			
    			Usuario guardar=service.save(entity);
    			 return ResponseEntity.ok(guardar);
    		    } catch (Exception e) {
    		        throw new ResponseStatusException(
    		                HttpStatus.INTERNAL_SERVER_ERROR,
    		                "Failed to save request", e);
    		    }
        // return ("successMessage People has been registered successfully");
        	
        	
        }else {
        	       	
        	throw new ResponseStatusException(
		                HttpStatus.INTERNAL_SERVER_ERROR,
		                "There is already a person registered with the nic provided");
            //return  "There is already a person registered with the nic provided";
        }
  
		
		
	}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Usuario> edit(@PathVariable(value = "id") Integer id, @RequestBody Usuario entity) {
		//return service.save(entity);
		
	       Optional<Usuario> peopleExistsIdenti = repository_U.findBynumeroIdentificación(entity.getNumeroIdentificación()); 
	        
	       if(peopleExistsIdenti.isPresent()) {
	        	
	    	   throw new ResponseStatusException(
		                HttpStatus.INTERNAL_SERVER_ERROR,
		                "There is already a person registered with the nic provided");	
	        }
	       Optional<Usuario> NotIdenti = service.findById(id);
	       if(NotIdenti.isPresent()) {
	        	    
	    	   Usuario newdata = service.findById(id).get();
	    	   newdata.setNombres(entity.getNombres());
	    	   newdata.setCorreo(entity.getCorreo());
	    	   newdata.setCelular(entity.getCelular());
	    	  // newdata.setProvinciaMatriz(entity.getProvinciaMatriz());
	    	   //newdata.setDireccionMatriz(entity.getDireccionMatriz());
	    	   //newdata.setCiudadMatriz(entity.getCiudadMatriz());
	    	   return ResponseEntity.ok(service.save(newdata));
	        	
	        }else {
	        	throw new ResponseStatusException(
		                HttpStatus.INTERNAL_SERVER_ERROR,
		                "user not found");
            //return  "There is already a person registered with the nic provided";
	        }
		
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String delete(@PathVariable Integer id) {
		return service.deleteById(id);
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
		 	public Optional<Usuario>  findBynumeroIdentificación(@PathVariable String id){
			return service.findBynumeroIdentificación(id);
	}

}
