package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.AdmBancoSql;
import modelo.VOs.Identidade;
import modelo.fabrica.DAOs.IdentidadeDAO;

public class IdentidadeDAOMySql extends IdentidadeDAO{

	protected IdentidadeDAOMySql() {
	}
	
	@Override
	public void inserir(Identidade identVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO identidade (chaveFunc, numero , ssp, data) VALUES (?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, identVO.getIdIdent());
			ps.setString(2, identVO.getNumero());
			ps.setString(3, identVO.getSsp());
			ps.setDate(4, identVO.getData());

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

	public void atualizar(Identidade identVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE identidade SET numero=?, ssp=?," +
					"data=? WHERE chaveFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, identVO.getNumero());
			ps.setString(2, identVO.getSsp());
			ps.setDate(3, identVO.getData());
			ps.setInt(4, identVO.getIdIdent());
			
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
	public void excluir(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Identidade pesquisar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Identidade identidade=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM identidade WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
					
					identidade = new Identidade();
					
					identidade.setNumero(result.getString("numero"));
					identidade.setSsp(result.getString("ssp"));
					identidade.setData(result.getDate("data"));
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
	            throw new Exception("SQLException: " + e.getMessage());
				
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
            throw new Exception("SQLException: " + sqle.getMessage()+"\n"+
                                    "SQLState: " + sqle.getSQLState()+"\n"+
                                    "VendorError: " + sqle.getErrorCode());
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return identidade;
		
	}

}
