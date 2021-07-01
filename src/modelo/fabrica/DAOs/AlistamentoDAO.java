package modelo.fabrica.DAOs;

import modelo.VOs.Alistamento;

public abstract class AlistamentoDAO {
	
	public abstract void inserir(Alistamento alistVO) throws Exception;
	public abstract void atualizar(Alistamento alistVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract Alistamento pesquisar(int id) throws Exception;
	

}
