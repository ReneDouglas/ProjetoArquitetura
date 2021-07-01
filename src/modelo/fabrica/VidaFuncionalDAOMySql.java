package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.AdmBancoSql;
import modelo.VOs.VidaFuncional;
import modelo.fabrica.DAOs.VidaFuncionalDAO;


public class VidaFuncionalDAOMySql extends VidaFuncionalDAO{

	protected VidaFuncionalDAOMySql() {
	}
	
	public void inserir(VidaFuncional vidaFuncVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO historico (chaveFunc, portaria , dataNomeacao, dataExercicio," +
					"dataLicenca, dataAlteracao, cargo, fs, p, secretaria, localizacao, observacao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, vidaFuncVO.idVidaFunc);
			ps.setString(2, vidaFuncVO.port);
			ps.setDate(3, vidaFuncVO.dataNomeacao);
			ps.setDate(4, vidaFuncVO.dataExercicio);
			ps.setDate(5, vidaFuncVO.dataLicenca);
			ps.setDate(6, vidaFuncVO.dataAlteracao);
			ps.setString(7, vidaFuncVO.cargo);
			ps.setString(8, vidaFuncVO.fs);
			ps.setString(9, vidaFuncVO.p);
			ps.setString(10, vidaFuncVO.secretaria);
			ps.setString(11, vidaFuncVO.localizacao);
			ps.setString(12, vidaFuncVO.observacao);

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

	public void atualizar(VidaFuncional vidaFuncVO) throws Exception {

		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE historico SET dataNomeacao=?, dataExercicio=?," +
					"dataLicenca=?, dataAlteracao=?, cargo=?, fs=?, p=?, observacao=? WHERE chaveFunc=? AND portaria=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setDate(1, vidaFuncVO.dataNomeacao);
			ps.setDate(2, vidaFuncVO.dataExercicio);
			ps.setDate(3, vidaFuncVO.dataLicenca);
			ps.setDate(4, vidaFuncVO.dataAlteracao);
			ps.setString(5, vidaFuncVO.cargo);
			ps.setString(6, vidaFuncVO.fs);
			ps.setString(7, vidaFuncVO.p);
			ps.setString(8, vidaFuncVO.observacao);
			ps.setInt(9, vidaFuncVO.idVidaFunc);
			ps.setString(10, vidaFuncVO.port);
			
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

	public ArrayList<VidaFuncional> listar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		ArrayList<VidaFuncional> lista = new ArrayList<VidaFuncional>();
		VidaFuncional histVO;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM historico WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
					
					histVO = new VidaFuncional();
			
					histVO.idVidaFunc = result.getInt("chaveFunc");
					histVO.port = result.getString("portaria");
					histVO.dataNomeacao = result.getDate("dataNomeacao");
					histVO.dataExercicio = result.getDate("dataExercicio");
					histVO.dataLicenca = result.getDate("dataLicenca");
					histVO.dataAlteracao = result.getDate("dataAlteracao");
					histVO.cargo = result.getString("cargo");
					histVO.fs = result.getString("fs");
					histVO.p = result.getString("p");
					histVO.secretaria = result.getString("secretaria");
					histVO.localizacao = result.getString("localizacao");
					histVO.observacao = result.getString("observacao");
					
					
					lista.add(histVO);
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
		return lista;
		
	}

	@Override
	public VidaFuncional pesquisar(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
