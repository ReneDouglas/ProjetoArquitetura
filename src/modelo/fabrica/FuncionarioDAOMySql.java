package modelo.fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.AdmBancoSql;
import modelo.VOs.Funcionario;
import modelo.VOs.Identidade;
import modelo.fabrica.DAOs.FuncionarioDAO;

public class FuncionarioDAOMySql extends FuncionarioDAO{

	protected FuncionarioDAOMySql() {
	}
	
	@Override
	public void inserir(Funcionario funcVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		
		try{
			String stringSQL="INSERT INTO funcionario (idFunc, nome, nomePai," +
					"nomeMae, dataNasc, sexo, estCivil, pasep, matricula, cpf, grauDeInst) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, funcVO.idFunc);
			ps.setString(2, funcVO.nome);
			ps.setString(3, funcVO.nomePai);
			ps.setString(4, funcVO.nomeMae);
			ps.setDate(5, funcVO.dataNasc);
			ps.setString(6, funcVO.sexo);
			ps.setString(7, funcVO.estCivil);
			ps.setString(8, funcVO.pasep);
			ps.setString(9, funcVO.matricula);
			ps.setString(10, funcVO.cpf);
			ps.setString(11, funcVO.grauDeInst);

			ps.executeUpdate();
			
			PreparedStatement ps2 = null;
			ps2 = conn.prepareStatement("select last_insert_id()");
			result = ps2.executeQuery();
			
			if(result.next()) funcVO.idFunc = result.getInt(1);
			
			
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
	public void atualizar(Funcionario funcVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE funcionario SET nome=?, nomePai=?," +
					"nomeMae=?, dataNasc=?, sexo=?, estCivil=?, pasep=?, matricula=?, cpf=?, grauDeInst=? WHERE idFunc=?";
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, funcVO.nome);
			ps.setString(2, funcVO.nomePai);
			ps.setString(3, funcVO.nomeMae);
			ps.setDate(4, funcVO.dataNasc);
			ps.setString(5, funcVO.sexo);
			ps.setString(6, funcVO.estCivil);
			ps.setString(7, funcVO.pasep);
			ps.setString(8, funcVO.matricula);
			ps.setString(9, funcVO.cpf);
			ps.setString(10, funcVO.grauDeInst);
			ps.setInt(11, funcVO.idFunc);
			
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

	public void excluir(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("DELETE FROM funcionario WHERE idFunc = ?");
			ps.setInt(1, id);
			
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
	public Funcionario pesquisar(int id) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		Funcionario funcionario=null;
		
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM funcionario WHERE idFunc=?");
			ps.setInt(1, id);
			result = ps.executeQuery();
			
			try {
				while( result.next() ){
					
					funcionario = new Funcionario();
					
					funcionario.nome = result.getString("nome");
					funcionario.nomePai = result.getString("nomePai");
					funcionario.nomeMae = result.getString("nomeMae");
					funcionario.dataNasc = result.getDate("dataNasc");
					funcionario.sexo = result.getString("sexo");
					funcionario.estCivil = result.getString("estCivil");
					funcionario.pasep = result.getString("pasep");
					funcionario.matricula = result.getString("matricula");
					funcionario.cpf = result.getString("cpf");
					funcionario.grauDeInst = result.getString("grauDeInst");
					
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
		return funcionario;
		
	}

	@Override
	public int getIdFunc() throws Exception {

			PreparedStatement ps = null;
			Connection conn = null;
			ResultSet result = null;
			
			int idFunc = 0;
			
			try {
				
				conn = AdmBancoSql.getConnection();
				ps = conn.prepareStatement("SELECT MAX(idFunc) FROM Funcionario");
				result = ps.executeQuery();
				
				while(result.next()){
					idFunc = result.getInt("MAX(idFunc)");
				}	
				
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				new Exception("Erro: "+sqle.getMessage());
			} finally {
				AdmBancoSql.closeConnection(conn, ps, result);
			}
			return idFunc;
			
		
		
	}

	public ArrayList<Funcionario> listar() throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;	
		ArrayList<Funcionario> list = new ArrayList<Funcionario>();
		Funcionario funcVO;
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM funcionario AS f INNER JOIN identidade AS i ON f.idFunc = i.chaveFunc");
			result = ps.executeQuery();
			
			while( result.next() )
			{
				
				funcVO = new Funcionario();
				funcVO.identidade = new Identidade();
				funcVO.idFunc = result.getInt("idFunc");
				funcVO.nome = result.getString("nome");
				funcVO.dataNasc = result.getDate("dataNasc");
				funcVO.cpf = result.getString("cpf");
				funcVO.identidade.setNumero(result.getString("i.numero"));
				funcVO.grauDeInst = result.getString("grauDeInst");
				
				list.add(funcVO);
			}
		} catch (SQLException sqle) {
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return list;
	}

}
