package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.AdmBancoSql;
import modelo.VOs.Ferias;
import modelo.fabrica.DAOs.FeriasDAO;

public class FeriasDAOMySql extends FeriasDAO{

	protected FeriasDAOMySql() {
	}
	
	public void inserir(Ferias feriasVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO ferias (chaveFunc, periodoAq , periodoGozo, portaria) VALUES (?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, feriasVO.idFerias);
			ps.setString(2, feriasVO.periodoAq);
			ps.setString(3, feriasVO.periodoGozo);
			ps.setString(4, feriasVO.portaria);

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

	
	public void atualizar(Ferias feriasVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE ferias SET periodoAq=?,periodoGozo=? WHERE chaveFunc=? AND portaria=?";
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, feriasVO.periodoAq);
			ps.setString(2, feriasVO.periodoGozo);
			ps.setInt(3, feriasVO.idFerias);
			ps.setString(4, feriasVO.portaria);
			
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

	public void excluir(int id, String port) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("DELETE FROM ferias WHERE chaveFunc = ? AND portaria = ?");
			ps.setInt(1, id);
			ps.setString(2, port);
			
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
	public ArrayList<Ferias> listar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		ArrayList<Ferias> ferias=new ArrayList<Ferias>();
		Ferias feriasVO;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM ferias WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
					
					feriasVO = new Ferias();
			
					feriasVO.idFerias = result.getInt("chaveFunc");
					feriasVO.periodoAq = result.getString("periodoAq");
					feriasVO.periodoGozo = result.getString("periodoGozo");
					feriasVO.portaria = result.getString("portaria");
					
					ferias.add(feriasVO);
					
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
		return ferias;
		
		
	}

	@Override
	public void excluir(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Ferias pesquisar(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
