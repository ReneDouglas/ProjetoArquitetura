package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.AdmBancoSql;
import modelo.VOs.Usuario;
import modelo.fabrica.DAOs.UsuarioDAO;

public class UsuarioDAOMySql extends UsuarioDAO{

	protected UsuarioDAOMySql() {
	}
	
	@Override
	public void inserir(Usuario usuarioVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO usuario (login, senha) VALUES (?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setString(1, usuarioVO.getLogin());
			ps.setString(2, usuarioVO.getSenha());

			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
            throw new Exception("SQLException: " + sqle.getMessage()+"\n"+
                                    "SQLState: " + sqle.getSQLState()+"\n"+
                                    "VendorError: " + sqle.getErrorCode());
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
	}

	@Override
	public void atualizar(Usuario usuarioVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario pesquisar(String login, String senha) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Usuario usuario=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM usuario WHERE login=? AND senha=?");
			ps.setString(1, login);
			ps.setString(2, senha);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					int idUsuario = result.getInt("idUsuario");
					String loginUser = result.getString("login");
					String senhaUser = result.getString("senha");
					
					usuario = new Usuario(idUsuario, loginUser, senhaUser);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
	            throw new Exception("Exception: " + e.getMessage());
			}
			
		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
            throw new Exception("SQLException: " + sqle.getMessage()+"\n"+
                                    "SQLState: " + sqle.getSQLState()+"\n"+
                                    "VendorError: " + sqle.getErrorCode());
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return usuario;		
		
	}

}
