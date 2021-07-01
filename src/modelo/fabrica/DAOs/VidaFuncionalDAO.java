package modelo.fabrica.DAOs;

import java.util.ArrayList;

import modelo.VOs.VidaFuncional;

public abstract class VidaFuncionalDAO {
	
	public abstract void inserir(VidaFuncional vidaFuncVO) throws Exception;
	public abstract void atualizar(VidaFuncional vidaFuncVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract ArrayList<VidaFuncional> listar(int id) throws Exception;
	public abstract VidaFuncional pesquisar(int id) throws Exception;

}
