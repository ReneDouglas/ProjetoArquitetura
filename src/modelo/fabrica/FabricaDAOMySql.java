package modelo.fabrica;

import modelo.fabrica.DAOs.*;

public class FabricaDAOMySql extends FabricaDAO{

	protected FabricaDAOMySql() {}
	
	public AlistamentoDAO criarAlistamentoDAO() {
		// TODO Auto-generated method stub
		return new AlistamentoDAOMySql();
	}

	@Override
	public CarteiraDeTrabalhoDAO criarCarteiraDeTrabalhoDAO() {
		// TODO Auto-generated method stub
		return new CarteiraDeTrabalhoDAOMySql();
	}

	@Override
	public DependenteDAO criarDependenteDAO() {
		// TODO Auto-generated method stub
		return new DependenteDAOMySql();
	}

	@Override
	public EnderecoDAO criarEnderecoDAO() {
		// TODO Auto-generated method stub
		return new EnderecoDAOMySql();
	}

	@Override
	public FeriasDAO criarFeriasDAO() {
		// TODO Auto-generated method stub
		return new FeriasDAOMySql();
	}

	@Override
	public FuncionarioDAO criarFuncionarioDAO() {
		// TODO Auto-generated method stub
		return new FuncionarioDAOMySql();
	}

	@Override
	public IdentidadeDAO criarIdentidadeDAO() {
		// TODO Auto-generated method stub
		return new IdentidadeDAOMySql();
	}

	@Override
	public LicencaDAO criarLicencaDAO() {
		// TODO Auto-generated method stub
		return new LicencaDAOMySql();
	}

	@Override
	public NaturalidadeDAO criarNaturalidadeDAO() {
		// TODO Auto-generated method stub
		return new NaturalidadeDAOMySql();
	}

	@Override
	public Tipo_LicencaDAO criarTipoLicencaDAO() {
		// TODO Auto-generated method stub
		return new TipoLicencaDAOMySql();
	}

	@Override
	public TituloEleitoralDAO criarTituloEleitoralDAO() {
		// TODO Auto-generated method stub
		return new TituloEleitoralDAOMySql();
	}

	@Override
	public VidaFuncionalDAO criarVidaFuncionalDAO() {
		// TODO Auto-generated method stub
		return new VidaFuncionalDAOMySql();
	}

	@Override
	public UsuarioDAO criarUsuarioDAO() {
		// TODO Auto-generated method stub
		return new UsuarioDAOMySql();
	}

}
