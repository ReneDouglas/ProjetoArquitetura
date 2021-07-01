package modelo.fabrica.DAOs;

import modelo.VOs.Usuario;

public abstract class UsuarioDAO {
	
	public abstract void inserir(Usuario usuarioVO) throws Exception;
	public abstract void atualizar(Usuario usuarioVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract Usuario pesquisar(String login, String senha) throws Exception; 

}
