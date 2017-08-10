package com.solmit.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.solmit.entidad.Usuario;
import com.solmit.service.UsuarioService;
import com.solmit.usuario.dto.UsuarioDto;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/usuario2")
public class Controller {

	@Autowired
	private UsuarioService usuarioService;

	private static final Logger LOGGER = Logger.getLogger(Controller.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/lista", method = GET)
  	public ResponseEntity greet() throws ClassNotFoundException, SQLException {
        System.out.println("entro al metodo traer lista");
	try {
	
	List<Usuario> listaUsuarios = this.usuarioService.obtener_todo();                    
	
	       UsuarioDto user=null;
	       List<UsuarioDto>listaUser=new ArrayList<>();
	
	   for (Usuario lista : listaUsuarios) {
	       System.out.println("=>"+lista.getEstado()); 
	       user=new UsuarioDto();
	       user.setId(lista.getIdUsuario());
	       user.setClave(lista.getClave());
	       user.setCorreo(lista.getCorreo());
	       user.setDireccion(lista.getDireccion());
	       user.setMaterno(lista.getMaterno());
	       user.setPaterno(lista.getPaterno());
	        user.setNombres(lista.getNombres());
	       user.setEstado(lista.getEstado());
	       listaUser.add(user);
	       
   }
   return new ResponseEntity<>(listaUser, HttpStatus.OK);

} catch (Exception e) {
   LOGGER.error(e.getMessage());
   return new ResponseEntity(e.getMessage(), HttpStatus.OK);

}

}
	
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/obtenerxid", method = RequestMethod.GET)
    public ResponseEntity obtener(@RequestParam("i") String id) {
        try {
        	Usuario usuario = this.usuarioService.obetenerxid(id);
            if (usuario != null) {
            	UsuarioDto usuarioDto = new UsuarioDto(usuario.getIdUsuario(), usuario.getClave(),usuario.getNombres(),usuario.getPaterno()
            			,usuario.getMaterno(),usuario.getCorreo(),usuario.getDireccion(),usuario.getTelefono(),usuario.getEstado());
                return new ResponseEntity(usuarioDto, HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
    }
    
    

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "guardar", method = RequestMethod.POST)
    public ResponseEntity guardarUsuario(@RequestBody UsuarioDto usuarioDto) {
        try {
            String id = usuarioDto.getId();
            String nombre = usuarioDto.getNombres();
            String paterno = usuarioDto.getPaterno();
            
            Usuario u=new Usuario();
            u.setIdUsuario(id);
            u.setNombres(nombre);
            u.setPaterno(paterno);
            
            this.usuarioService.addUsuario(u);

            return new ResponseEntity("usuario guardado", HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }

    }
	
	
	
    

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateUsuario(@RequestBody UsuarioDto usuarioDto) {
        try {
            String id = usuarioDto.getId();
            String nombre = usuarioDto.getNombres();
            String paterno = usuarioDto.getPaterno();
            String materno = usuarioDto.getMaterno();
            String clave = usuarioDto.getClave();
            
            Usuario u=new Usuario();
            u.setIdUsuario(id);
            u.setNombres(nombre);
            u.setPaterno(paterno);
            u.setMaterno(materno);
            u.setClave(clave);
            
            this.usuarioService.updateUsuario(u);

            return new ResponseEntity("moneda guardada", HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }

    }
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/eliminarUsuario", method = RequestMethod.GET)
    public ResponseEntity eliminar(@RequestParam("i") String id) {
        try {
        	  this.usuarioService.deleteUsuario(id);
 
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
    }
	
}
