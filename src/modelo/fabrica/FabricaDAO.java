package modelo.fabrica;

import modelo.fabrica.DAOs.AlistamentoDAO;
import modelo.fabrica.DAOs.CarteiraDeTrabalhoDAO;
import modelo.fabrica.DAOs.DependenteDAO;
import modelo.fabrica.DAOs.EnderecoDAO;
import modelo.fabrica.DAOs.FeriasDAO;
import modelo.fabrica.DAOs.FuncionarioDAO;
import modelo.fabrica.DAOs.IdentidadeDAO;
import modelo.fabrica.DAOs.LicencaDAO;
import modelo.fabrica.DAOs.NaturalidadeDAO;
import modelo.fabrica.DAOs.Tipo_LicencaDAO;
import modelo.fabrica.DAOs.TituloEleitoralDAO;
import modelo.fabrica.DAOs.UsuarioDAO;
import modelo.fabrica.DAOs.VidaFuncionalDAO;

public abstract class FabricaDAO {

	private static FabricaDAO instancia = null;
	
	@SuppressWarnings("unused")
	public static synchronized FabricaDAO getFabricaDAO(){
		
		if(instancia == null){
			if(true){
				instancia = new FabricaDAOMySql();
			} else{
				instancia = new FabricaDAOOracle();
			}
		}
		return instancia;
		
	}
	
	public abstract AlistamentoDAO criarAlistamentoDAO();
	
	public abstract CarteiraDeTrabalhoDAO criarCarteiraDeTrabalhoDAO();
	
	public abstract DependenteDAO criarDependenteDAO();
	
	public abstract EnderecoDAO criarEnderecoDAO();
	
	public abstract FeriasDAO criarFeriasDAO();
	
	public abstract FuncionarioDAO criarFuncionarioDAO();
	
	public abstract IdentidadeDAO criarIdentidadeDAO();
	
	public abstract LicencaDAO criarLicencaDAO();
	
	public abstract NaturalidadeDAO criarNaturalidadeDAO();
	
	public abstract Tipo_LicencaDAO criarTipoLicencaDAO();
	
	public abstract TituloEleitoralDAO criarTituloEleitoralDAO();
	
	public abstract VidaFuncionalDAO criarVidaFuncionalDAO();
	
	public abstract UsuarioDAO criarUsuarioDAO();
	
	
}
