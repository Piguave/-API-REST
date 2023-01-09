package com.kruger.usuario.model.repository;

import org.springframework.data.repository.CrudRepository;


import com.kruger.usuario.model.Usuario;

public interface usuarioRepository extends CrudRepository<Usuario, Integer>{
	
	Iterable<Usuario>  findBynombres(String nombres);
	Iterable<Usuario>  findBynumeroIdentificación(String numeroIdentificación);


}
