package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.AdmBancoSql;
import modelo.VOs.Alistamento;
import modelo.fabrica.DAOs.AlistamentoDAO;

public class AlistamentoDAOMySql extends AlistamentoDAO{
	
	protected AlistamentoDAOMySql() {
	}

	@Override
	public void inserir(Alistamento alistVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO alistamento (chaveFunc, situacaoMilitar , serie, esp) VALUES (?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, alistVO.getIdAlist());
			ps.setString(2, alistVO.getSituacaoMilitar());
			ps.setString(3, alistVO.getSerie());
			ps.setString(4, alistVO.getEsp());

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

	public void atualizar(Alistamento alistVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE alistamento SET situacaoMilitar=?, serie=?," +
					"esp=? WHERE chaveFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, alistVO.getSituacaoMilitar());
			ps.setString(2, alistVO.getSerie());
			ps.setString(3, alistVO.getEsp());
			ps.setInt(4, alistVO.getIdAlist());
			
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
	public Alistamento pesquisar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Alistamento alistamento=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM alistamento WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
					
					alistamento = new Alistamento();
					
					alistamento.setSituacaoMilitar(result.getString("situacaoMilitar"));
					alistamento.setSerie(result.getString("serie"));
					alistamento.setEsp(result.getString("esp"));
					
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
		return alistamento;
		
		
	}

}
