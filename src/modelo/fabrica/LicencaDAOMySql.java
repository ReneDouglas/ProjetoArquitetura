package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.AdmBancoSql;
import modelo.VOs.Licenca;
import modelo.VOs.Tipo_Licenca;
import modelo.fabrica.DAOs.LicencaDAO;

public class LicencaDAOMySql extends LicencaDAO{

	protected LicencaDAOMySql() {
	}
	
	public void inserir(Licenca licenVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO licenca (chaveFunc, tipoLicenca , inicio, termino, portaria, observ) VALUES (?,?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, licenVO.idLicenca);
			ps.setInt(2, licenVO.tipo_Licenca.getIdTipo());
			ps.setDate(3, licenVO.inicio);
			ps.setDate(4, licenVO.termino);
			ps.setString(5, licenVO.portaria);
			ps.setString(6, licenVO.observ);

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

	public void atualizar(Licenca licenVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE licenca SET tipoLicenca=?,inicio=?,termino=?, observ=? WHERE chaveFunc=? AND portaria=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, licenVO.tipo_Licenca.getIdTipo());
			ps.setDate(2, licenVO.inicio);
			ps.setDate(3, licenVO.termino);
			ps.setString(4, licenVO.observ);
			ps.setInt(5, licenVO.idLicenca);
			ps.setString(6, licenVO.portaria);
			
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

	public ArrayList<Licenca> listar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		ArrayList<Licenca> licencas = new ArrayList<Licenca>();
		Licenca licenVO;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM licenca WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
					
					licenVO = new Licenca();
					licenVO.tipo_Licenca = new Tipo_Licenca();
			
					licenVO.idLicenca = result.getInt("chaveFunc");
					licenVO.tipo_Licenca.setIdTipo(result.getInt("tipoLicenca"));
					licenVO.portaria = result.getString("portaria");
					licenVO.inicio = result.getDate("inicio");
					licenVO.termino = result.getDate("termino");
					licenVO.observ = result.getString("observ");
					
					licencas.add(licenVO);
					
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
		
		return licencas;
		
	}

	@Override
	public Licenca pesquisar(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
