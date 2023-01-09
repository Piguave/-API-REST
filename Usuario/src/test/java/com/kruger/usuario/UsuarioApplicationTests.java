package com.kruger.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.kruger.usuario.model.Sucursal;
import com.kruger.usuario.model.Usuario;
import com.kruger.usuario.model.repository.SucursalRepository;
import com.kruger.usuario.model.repository.usuarioRepository;
import com.kruger.usuario.model.service.SucursalService;
import com.kruger.usuario.model.service.usuarioService;

@SpringBootTest(classes = {UsuarioApplication.class})
class UsuarioApplicationTests {
	
	@Mock
	SucursalRepository repository;
	@Mock
	usuarioRepository U_repository;
	
	
	//service
	@InjectMocks
	SucursalService service;
	@InjectMocks
	usuarioService U_service;
	
	List<Sucursal> addsucursal;
	List<Usuario> myUser;
	@Test
	@Order(1)
	public void test_1_FindAll() {
		System.out.println("findAll sucursal");
		
		List<Sucursal> adddirections = new ArrayList<Sucursal>();
		adddirections.add(new Sucursal(1, "Pichincha", "Quito", "plaza central",2));
		adddirections.add(new Sucursal(2, "Manabí", "Portoviejo", "Crucita",2));
		
		
		when(repository.findAll()).thenReturn(adddirections);
		//List<FootBallPlayer> playerlist= new ArrayList<FootBallPlayer>();
		List<Sucursal> sucursallist=(List<Sucursal>) service.findAll();

		assertEquals(2, sucursallist.size());
	}
	
	
	@Test
	@Order(2)
	public void test_2_FindAll() {
		System.out.println("findAll Usuarios");
		
		List<Usuario> addUser = new ArrayList<Usuario>();
		addUser.add(new Usuario(1, "CEDULA", "1312729104", "Piguave Bermello Angel Ariel","arielpiguave@gmail,com","0990320062", "Manabí","Portoviejo","Crucita, sector Los Arenales", null));
		addUser.add(new Usuario(2, "CEDULA", "1312729105", "Piguave Bermello Angel Ariel","arielpiguave@gmail,com","0990320062", "Manabí","Portoviejo","Crucita, sector Los Arenales", null));
		
		
		when(U_repository.findAll()).thenReturn(addUser);
		//List<FootBallPlayer> playerlist= new ArrayList<FootBallPlayer>();
		List<Usuario> Userslist=(List<Usuario>) U_service.findAll();

		assertEquals(2, Userslist.size());
	}
	
	@Test
	@Order(3)
	public void test_3_save_User() {
		System.out.println("save user");
		Usuario newuser=new Usuario(1, "CEDULA", "1312729104", "Piguave Bermello Angel Ariel","arielpiguave@gmail,com","0990320062", "Manabí","Portoviejo","Crucita, sector Los Arenales", null);
		when(U_repository.save(newuser)).thenReturn(newuser);
		assertEquals(newuser,U_service.save(newuser));
	}
	
	@Test
	@Order(4)
	public void test_4_save_sucursal() {
		System.out.println("save sucursal");
		Sucursal newadd=new Sucursal(1, "Pichincha", "Quito", "plaza central",2);
		when(repository.save(newadd)).thenReturn(newadd);
		assertEquals("se añádio una direccion al Usuario con el id:2 de forma exitosa",service.save(newadd));
	}
}
