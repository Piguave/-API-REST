package com.kruger.usuario.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kruger.usuario.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{
	Iterable<Sucursal>  findByuserIdFk(Integer userIdFk);

}
