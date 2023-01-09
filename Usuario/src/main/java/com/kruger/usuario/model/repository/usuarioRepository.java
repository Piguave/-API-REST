package com.kruger.usuario.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.kruger.usuario.model.Usuario;

public interface usuarioRepository extends CrudRepository<Usuario, Integer>{
	
	Iterable<Usuario>  findBynombres(String nombres);
	Optional<Usuario>  findBynumeroIdentificación(String numeroIdentificación);


}
