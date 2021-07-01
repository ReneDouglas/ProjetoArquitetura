package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.AdmBancoSql;
import modelo.VOs.Dependente;
import modelo.fabrica.DAOs.DependenteDAO;

public class DependenteDAOMySql extends DependenteDAO{
	
	protected DependenteDAOMySql() {
	}

	public void inserir(Dependente depVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO dependente (chaveFunc, nome , parentesco, dataNasc, inicio, termino) VALUES (?,?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, depVO.idDep);
			ps.setString(2, depVO.nome);
			ps.setString(3, depVO.parentesco);
			ps.setDate(4, depVO.dataNasc);
			ps.setDate(5, depVO.inicio);
			ps.setDate(6, depVO.termino);

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

	public void atualizar(Dependente depVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE dependente SET parentesco=?,dataNasc=?, inicio=?, termino=? WHERE chaveFunc=? AND nome=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, depVO.parentesco);
			ps.setDate(2, depVO.dataNasc);
			ps.setDate(3, depVO.inicio);
			ps.setDate(4, depVO.termino);
			ps.setInt(5, depVO.idDep);
			ps.setString(6, depVO.nome);
			
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

	public ArrayList<Dependente> listar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		ArrayList<Dependente>dependentes = new ArrayList<Dependente>();
		Dependente depVO;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM dependente WHERE chaveFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
					
					depVO = new Dependente();
			
					depVO.idDep = result.getInt("chaveFunc");
					depVO.nome = result.getString("nome");
					depVO.parentesco = result.getString("parentesco");
					depVO.dataNasc = result.getDate("dataNasc");
					depVO.inicio = result.getDate("inicio");
					depVO.termino = result.getDate("termino");
					
					dependentes.add(depVO);
					
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
		return dependentes;
		
	}

	@Override
	public Dependente pesquisar(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
