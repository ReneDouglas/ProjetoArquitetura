package modelo.fabrica.DAOs;

import java.util.ArrayList;

import modelo.VOs.Tipo_Licenca;

public abstract class Tipo_LicencaDAO {
	
	public abstract void inserir(Tipo_Licenca tipolicenVO) throws Exception;
	public abstract void atualizar(Tipo_Licenca tipolicenVO) throws Exception;
	public abstract void excluir(int id) throws Exception;
	public abstract Tipo_Licenca pesquisar(int id) throws Exception;
	public abstract Tipo_Licenca pesquisar(String nome) throws Exception;
	public abstract ArrayList<Tipo_Licenca> getTipos() throws Exception;

}
