package com.kruger.usuario.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kruger.usuario.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{
	Iterable<Sucursal>  findByuserIdFk(Integer userIdFk);

}
