package modelo.fabrica.DAOs;

import java.util.ArrayList;

import modelo.VOs.Ferias;

public abstract class FeriasDAO {
	
	public abstract void inserir(Ferias feriasVO) throws Exception;
	public abstract void atualizar(Ferias feriasVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract ArrayList<Ferias> listar(int id) throws Exception;
	public abstract Ferias pesquisar(int id) throws Exception;

}
