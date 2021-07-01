package modelo.fabrica.DAOs;

import modelo.VOs.Naturalidade;

public abstract class NaturalidadeDAO {
	
	public abstract void inserir(Naturalidade natVO) throws Exception;
	public abstract void atualizar(Naturalidade natVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract Naturalidade pesquisar(int id) throws Exception;

}
