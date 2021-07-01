package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.AdmBancoSql;
import modelo.VOs.CarteiraDeTrabalho;
import modelo.fabrica.DAOs.CarteiraDeTrabalhoDAO;


public class CarteiraDeTrabalhoDAOMySql extends CarteiraDeTrabalhoDAO {

	protected CarteiraDeTrabalhoDAOMySql() {
	}
	
	@Override
	public void inserir(CarteiraDeTrabalho carteiraVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO carteira_de_trabalho (chaveFunc, ctpsNumero , serie, data) VALUES (?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, carteiraVO.getIdCarteira());
			ps.setString(2, carteiraVO.getCtpsNumero());
			ps.setString(3, carteiraVO.getSerie());
			ps.setDate(4, carteiraVO.getData());

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

	public void atualizar(CarteiraDeTrabalho carteiraVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE carteira_de_trabalho SET ctpsNumero=?,serie=?,data=? WHERE chaveFunc=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, carteiraVO.getCtpsNumero());
			ps.setString(2, carteiraVO.getSerie());
			ps.setDate(3, carteiraVO.getData());
			ps.setInt(4, carteiraVO.getIdCarteira());

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
	public CarteiraDeTrabalho pesquisar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		CarteiraDeTrabalho cartTrab=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM carteira_de_trabalho WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
			
					cartTrab = new CarteiraDeTrabalho();
					
					cartTrab.setCtpsNumero(result.getString("ctpsNumero"));
					cartTrab.setSerie(result.getString("serie"));
					cartTrab.setData(result.getDate("data"));
					
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
		return cartTrab;
		
		
	}

}
