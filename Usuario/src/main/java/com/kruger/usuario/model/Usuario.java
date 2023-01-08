package com.kruger.usuario.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;

    @Column(name = "tipo-identificación")
    String tipo_identificación ;

    @Column(name = "numeroIdentificación")
    String numeroIdentificación;
    
    @Column(name = "nombres")
    String nombres;
    
    @Column(name = "correo")
    String correo;
    
    @Column(name = "celular")
    String celular;
    
    @OneToMany(mappedBy = "user")
    List<Sucursal> sucursal;
  
}
