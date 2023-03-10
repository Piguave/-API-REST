package com.kruger.usuario.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.usuario.model.Usuario;
import com.kruger.usuario.model.repository.usuarioRepository;

@Service
public class usuarioService {
	
	@Autowired
	private usuarioRepository repository;
	
	public Iterable<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario save(Usuario entity) {
		return repository.save(entity);
		
	}
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public Optional<Usuario> findById(Integer id){
		return repository.findById(id);
	}

}
