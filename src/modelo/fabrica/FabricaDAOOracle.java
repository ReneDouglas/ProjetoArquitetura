package modelo.fabrica;

import modelo.fabrica.DAOs.*;

public class FabricaDAOOracle extends FabricaDAO{

	protected FabricaDAOOracle() {}
	
	public AlistamentoDAO criarAlistamentoDAO() {
		// TODO Auto-generated method stub
		return new AlistamentoDAOOracle();
	}

	@Override
	public CarteiraDeTrabalhoDAO criarCarteiraDeTrabalhoDAO() {
		// TODO Auto-generated method stub
		return new CarteiraDeTrabalhoDAOOracle();
	}

	@Override
	public DependenteDAO criarDependenteDAO() {
		// TODO Auto-generated method stub
		return new DependenteDAOOracle();
	}

	@Override
	public EnderecoDAO criarEnderecoDAO() {
		// TODO Auto-generated method stub
		return new EnderecoDAOOracle();
	}

	@Override
	public FeriasDAO criarFeriasDAO() {
		// TODO Auto-generated method stub
		return new FeriasDAOOracle();
	}

	@Override
	public FuncionarioDAO criarFuncionarioDAO() {
		// TODO Auto-generated method stub
		return new FuncionarioDAOOracle();
	}

	@Override
	public IdentidadeDAO criarIdentidadeDAO() {
		// TODO Auto-generated method stub
		return new IdentidadeDAOOracle();
	}

	@Override
	public LicencaDAO criarLicencaDAO() {
		// TODO Auto-generated method stub
		return new LicencaDAOOracle();
	}

	@Override
	public NaturalidadeDAO criarNaturalidadeDAO() {
		// TODO Auto-generated method stub
		return new NaturalidadeDAOOracle();
	}

	@Override
	public Tipo_LicencaDAO criarTipoLicencaDAO() {
		// TODO Auto-generated method stub
		return new TipoLicencaDAOOracle();
	}

	@Override
	public TituloEleitoralDAO criarTituloEleitoralDAO() {
		// TODO Auto-generated method stub
		return new TituloEleitoralDAOOracle();
	}

	@Override
	public VidaFuncionalDAO criarVidaFuncionalDAO() {
		// TODO Auto-generated method stub
		return new VidaFuncionalDAOOracle();
	}

	@Override
	public UsuarioDAO criarUsuarioDAO() {
		// TODO Auto-generated method stub
		return new UsuarioDAOOracle();
	}

}
