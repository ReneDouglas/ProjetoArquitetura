package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.AdmBancoSql;
import modelo.VOs.Naturalidade;
import modelo.fabrica.DAOs.NaturalidadeDAO;

public class NaturalidadeDAOMySql extends NaturalidadeDAO{

	protected NaturalidadeDAOMySql() {
	}
	
	@Override
	public void inserir(Naturalidade natVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO naturalidade (chaveFunc, cidadeNat , estadoNat) VALUES (?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, natVO.getIdNat());
			ps.setString(2, natVO.getCidade());
			ps.setString(3, natVO.getEstado());

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

	public void atualizar(Naturalidade natVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE naturalidade SET cidadeNat=?, estadoNat=? WHERE chaveFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, natVO.getCidade());
			ps.setString(2, natVO.getEstado());
			ps.setInt(3, natVO.getIdNat());
			
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
	}

	@Override
	public void excluir(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Naturalidade pesquisar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Naturalidade naturalidade=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM naturalidade WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					naturalidade = new Naturalidade();
					
					naturalidade.setCidade(result.getString("cidadeNat"));
					naturalidade.setEstado(result.getString("estadoNat"));
					
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
		return naturalidade;
		
	}

}
