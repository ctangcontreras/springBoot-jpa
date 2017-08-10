/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solmit.repository.impl;

import com.solmit.entidad.Usuario;
import com.solmit.repository.UsuarioRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DESARROLLO34
 */
@Repository
public class UsuarioRepositoryImpl  implements UsuarioRepository{
    @PersistenceContext
    private EntityManager entityManager;
    private static final Logger LOGGER=Logger.getLogger(UsuarioRepositoryImpl.class);

 
    @Override
    public List<Usuario> obtener_todo() {	
    	String hql = "FROM Usuario ";
    	return (List<Usuario>) entityManager.createQuery(hql).getResultList();
	}
    
    

	@Override
	public Usuario obetenerxid(String id) {
		return entityManager.find(Usuario.class, id);

	}

	@Override
	public void addUsuario(Usuario usuario) {
		entityManager.persist(usuario);

	}

	@Override
	public void updateUsuario(Usuario usuario) {
		
		System.out.println("usuario : "+usuario);
		
		Usuario usr = obetenerxid(usuario.getIdUsuario());
		usr.setClave(usuario.getClave());
		usr.setCorreo(usuario.getCorreo());
		usr.setDireccion(usuario.getDireccion());
		usr.setNombres(usuario.getNombres());
		usr.setPaterno(usuario.getPaterno());
		usr.setMaterno(usuario.getMaterno());
		
		entityManager.flush();
	}

	@Override
	public void deleteUsuario(String id) {
		entityManager.remove(obetenerxid(id));

	}
    
}
