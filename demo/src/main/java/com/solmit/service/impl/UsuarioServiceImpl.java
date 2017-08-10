/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solmit.service.impl;

import com.solmit.entidad.Usuario;
import com.solmit.repository.UsuarioRepository;
import com.solmit.service.UsuarioService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DESARROLLO34
 */
 
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private static final Logger LOGGER = Logger.getLogger(UsuarioRepository.class);

	@Transactional
	@Override
	public List<Usuario> obtener_todo() throws Exception {

		return this.usuarioRepository.obtener_todo();

	}

	@Transactional
	@Override
	public Usuario obetenerxid(String id) {

		Usuario usr = this.usuarioRepository.obetenerxid(id);

		return usr;
	}

	@Transactional
	@Override
	public void addUsuario(Usuario usuario) {
		this.usuarioRepository.addUsuario(usuario);
	}

	@Transactional
	@Override
	public void updateUsuario(Usuario usuario) {
		this.usuarioRepository.updateUsuario(usuario);
	}

	@Transactional
	@Override
	public void deleteUsuario(String id) {
		this.usuarioRepository.deleteUsuario(id);

	}

}
