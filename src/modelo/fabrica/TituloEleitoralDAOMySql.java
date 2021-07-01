package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.AdmBancoSql;
import modelo.VOs.TituloEleitoral;
import modelo.fabrica.DAOs.TituloEleitoralDAO;

public class TituloEleitoralDAOMySql extends TituloEleitoralDAO{

	protected TituloEleitoralDAOMySql() {
	}
	
	@Override
	public void inserir(TituloEleitoral tituloVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO tituloeleitoral (chaveFunc, numero, zona, secao) VALUES (?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, tituloVO.getIdTitulo());
			ps.setString(2, tituloVO.getNumero());
			ps.setString(3, tituloVO.getZona());
			ps.setString(4, tituloVO.getSecao());

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
	public void atualizar(TituloEleitoral tituloVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TituloEleitoral pesquisar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		TituloEleitoral titulo=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM tituloeleitoral WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					titulo = new TituloEleitoral();
					
					titulo.setNumero(result.getString("numero"));
					titulo.setZona(result.getString("zona"));
					titulo.setSecao(result.getString("secao"));
					
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
		return titulo;
		
		
	}

}
