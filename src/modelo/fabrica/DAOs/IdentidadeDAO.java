package modelo.fabrica.DAOs;

import modelo.VOs.Identidade;

public abstract class IdentidadeDAO {
	
	public abstract void inserir(Identidade identVO) throws Exception;
	public abstract void atualizar(Identidade identVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract Identidade pesquisar(int id) throws Exception;

}
