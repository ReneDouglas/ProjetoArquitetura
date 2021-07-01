package modelo.fabrica.DAOs;

import modelo.VOs.CarteiraDeTrabalho;

public abstract class CarteiraDeTrabalhoDAO {
	
	public abstract void inserir(CarteiraDeTrabalho carteiraVO) throws Exception;
	public abstract void atualizar(CarteiraDeTrabalho carteiraVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract CarteiraDeTrabalho pesquisar(int id) throws Exception;

}
