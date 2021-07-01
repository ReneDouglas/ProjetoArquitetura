package modelo.fabrica.DAOs;

import modelo.VOs.TituloEleitoral;

public abstract class TituloEleitoralDAO {
	
	public abstract void inserir(TituloEleitoral tituloVO) throws Exception;
	public abstract void atualizar(TituloEleitoral tituloVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract TituloEleitoral pesquisar(int id) throws Exception;

}
