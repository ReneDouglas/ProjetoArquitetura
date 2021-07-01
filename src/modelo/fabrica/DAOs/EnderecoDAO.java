package modelo.fabrica.DAOs;

import modelo.VOs.Endereco;

public abstract class EnderecoDAO {
	
	public abstract void inserir(Endereco endVO) throws Exception;
	public abstract void atualizar(Endereco endVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract Endereco pesquisar(int id) throws Exception;

}
