/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solmit.service;

import com.solmit.entidad.Usuario;
import java.util.List;

/**
 *
 * @author DESARROLLO34
 */
public interface UsuarioService {
    
    public List<Usuario> obtener_todo() throws Exception;
    Usuario obetenerxid(String id);
    void addUsuario(Usuario usuario);
    void updateUsuario(Usuario usuario);
    void deleteUsuario(String id);
    

}
