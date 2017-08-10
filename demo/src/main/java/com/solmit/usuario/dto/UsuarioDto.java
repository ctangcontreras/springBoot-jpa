/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solmit.usuario.dto;

/**
 *
 * @author DESARROLLO34
 */
 

import lombok.Getter;
import lombok.Setter;

 
public class UsuarioDto {
    private String id;
    private String clave;
    private String nombres;
    private String paterno;
    private String materno;
    private String correo;
    private String direccion;
    private String telefono;
    private Character estado;
    
    
    public UsuarioDto(){}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getPaterno() {
		return paterno;
	}


	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}


	public String getMaterno() {
		return materno;
	}


	public void setMaterno(String materno) {
		this.materno = materno;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Character getEstado() {
		return estado;
	}


	public void setEstado(Character estado) {
		this.estado = estado;
	}


	public UsuarioDto(String id, String clave, String nombres, String paterno, String materno, String correo,
			String direccion, String telefono, Character estado) {
		super();
		this.id = id;
		this.clave = clave;
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
	}
}
