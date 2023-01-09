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
	
	public String save(Sucursal entity) {
		 repository.save(entity);
		 return "se añádio una direccion al Usuario con el id:" +entity.getUserIdFk()+" de forma exitosa";
		
	}
	public String saveedit(Sucursal entity) {
		 repository.save(entity);
		 return "se actualizo al Usuario con el id:" +entity.getUserIdFk()+" de forma exitosa";
		
	}
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public Optional<Sucursal> findById(Integer id){
		return repository.findById(id);
	}
	//buscar direccion adicionales de usuarios mendiante id_user
	public Iterable<Sucursal> findByuserIdFk(Integer userIdFk){
		return (Iterable<Sucursal>) repository.findByuserIdFk(userIdFk);
	}

}
