package modelo;

import java.util.List;

public interface IUserDAO {
	
	List<Usuario> getListaUsuarios();
	
	boolean existeUsuario(Usuario usuario);
	
	boolean actualizarUsuario(Usuario usuario);
	
	boolean addUsuario(Usuario usuario);
	
	Usuario getUsuario(String login);
	
	boolean borrarUsuario(Usuario usuario);
	
}
