package modelo.fabrica.DAOs;

import java.util.ArrayList;

import modelo.VOs.Licenca;

public abstract class LicencaDAO {
	
	public abstract void inserir(Licenca licenVO) throws Exception;
	public abstract void atualizar(Licenca licenVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract ArrayList<Licenca> listar(int id) throws Exception;
	public abstract Licenca pesquisar(int id) throws Exception;

}
