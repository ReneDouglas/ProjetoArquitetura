package modelo.fabrica.DAOs;

import java.util.ArrayList;

import modelo.VOs.Dependente;

public abstract class DependenteDAO {
	
	public abstract void inserir(Dependente depVO) throws Exception;
	public abstract void atualizar(Dependente depVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract ArrayList<Dependente> listar(int id) throws Exception;
	public abstract Dependente pesquisar(int id) throws Exception;

}
