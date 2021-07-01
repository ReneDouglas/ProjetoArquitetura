package modelo.fabrica.DAOs;

import java.util.ArrayList;

import modelo.VOs.Funcionario;

public abstract class FuncionarioDAO {
	
	public abstract void inserir(Funcionario funcVO) throws Exception;
	public abstract void atualizar(Funcionario funcVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract Funcionario pesquisar(int id) throws Exception;
	public abstract ArrayList<Funcionario> listar() throws Exception;
	public abstract int getIdFunc() throws Exception;

}
