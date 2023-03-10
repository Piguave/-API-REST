package com.kruger.usuario.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.usuario.model.Sucursal;
import com.kruger.usuario.model.repository.SucursalRepository;

@Service
public class SucursalService {
	
	@Autowired
	SucursalRepository repository;
	
	
	public Iterable<Sucursal> findAll(){
		return repository.findAll();
	}
	
	public Sucursal save(Sucursal entity) {
		return repository.save(entity);
		
	}
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public Optional<Sucursal> findById(Integer id){
		return repository.findById(id);
	}

}
