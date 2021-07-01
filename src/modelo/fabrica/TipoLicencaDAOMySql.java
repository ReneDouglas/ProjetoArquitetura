package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.AdmBancoSql;
import modelo.VOs.Tipo_Licenca;
import modelo.fabrica.DAOs.Tipo_LicencaDAO;

public class TipoLicencaDAOMySql extends Tipo_LicencaDAO{

	protected TipoLicencaDAOMySql() {
	}
	
	@Override
	public void inserir(Tipo_Licenca tipolicenVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO tipolicenca (idTipo, nomeTipo) VALUES (?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, tipolicenVO.getIdTipo());
			ps.setString(2, tipolicenVO.getNomeTipo());
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
	public void atualizar(Tipo_Licenca tipolicenVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tipo_Licenca pesquisar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Tipo_Licenca tipo = new Tipo_Licenca();
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT nomeTipo FROM tipolicenca WHERE idTipo=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				
				if(result.next()){				
					tipo.setNomeTipo(result.getString("nomeTipo"));	
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
		
		return tipo;
		
	}
	
	
	public Tipo_Licenca pesquisar(String nome) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Tipo_Licenca tipo = new Tipo_Licenca();
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT idTipo FROM tipolicenca WHERE nomeTipo=?");
			ps.setString(1, nome);
			result = ps.executeQuery();
			
			try {
				
				if(result.next()){				
					tipo.setIdTipo(result.getInt("idTipo"));	
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
		
		return tipo;
		
	}
	
	public ArrayList<Tipo_Licenca> getTipos() throws Exception{
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;	
		ArrayList<Tipo_Licenca> list = new ArrayList<Tipo_Licenca>();
		Tipo_Licenca tipLicenVO;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT nomeTipo FROM tipolicenca");
			result = ps.executeQuery();
			while( result.next() )
			{
				tipLicenVO = new Tipo_Licenca();		
				tipLicenVO.setNomeTipo(result.getString("nomeTipo"));
				list.add(tipLicenVO);
				
			}
			
		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
			throw new Exception("SQLException: " + sqle.getMessage()+"\n"+
                    "SQLState: " + sqle.getSQLState()+"\n"+
                    "VendorError: " + sqle.getErrorCode());
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		
		return list;
	}

	

}
