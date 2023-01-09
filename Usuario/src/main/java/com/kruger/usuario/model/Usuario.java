package com.kruger.usuario.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;

    @Column(name = "tipoIdentificación")
    String tipoIdentificación ;

    @Column(name = "numeroIdentificación")
    String numeroIdentificación;
    
    @Column(name = "nombres")
    String nombres;
    
    @Column(name = "correo")
    String correo;
    
    @Column(name = "celular")
    String celular;
    
    @Column(name = "provincia")
    String provinciaMatriz;
    
    @Column(name = "ciudad")
    String ciudadMatriz;
    
    @Column(name = "direccion")
    String direccionMatriz;
    
    @OneToMany(mappedBy = "userIdFk")//orphanRemoval = true,targetEntity= Sucursal.class,cascade = CascadeType.ALL, 
    //@JoinColumn(name = "user_id_fk",referencedColumnName = "id")
    private List<Sucursal> sucursales	= new ArrayList<Sucursal>();
  
}
