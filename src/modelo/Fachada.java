package modelo;

import java.util.ArrayList;

import modelo.VOs.Funcionario;
import modelo.VOs.Licenca;
import modelo.VOs.Tipo_Licenca;
import modelo.VOs.Usuario;
import modelo.fabrica.FabricaDAO;
import modelo.fabrica.DAOs.AlistamentoDAO;
import modelo.fabrica.DAOs.CarteiraDeTrabalhoDAO;
import modelo.fabrica.DAOs.DependenteDAO;
import modelo.fabrica.DAOs.EnderecoDAO;
import modelo.fabrica.DAOs.FuncionarioDAO;
import modelo.fabrica.DAOs.IdentidadeDAO;
import modelo.fabrica.DAOs.NaturalidadeDAO;
import modelo.fabrica.DAOs.Tipo_LicencaDAO;
import modelo.fabrica.DAOs.TituloEleitoralDAO;
import modelo.fabrica.DAOs.UsuarioDAO;

public class Fachada {
	
	FuncionarioBO funcBO = new FuncionarioBO();
	private FabricaDAO fabrica = FabricaDAO.getFabricaDAO();
	
	public void cadastrarFuncionario(Funcionario funcVO) throws Exception{
		
		funcBO.LogicaCadastrarFuncionario(funcVO);
		
	}
	
	public void editarFuncionario(Funcionario funcVO, int controle) throws Exception{
		
		funcBO.LogicaEditarFuncionario(funcVO, controle);
		
	}
	
	public void excluirFuncionario(int id) throws Exception{
		
		FuncionarioDAO funcDAO = fabrica.criarFuncionarioDAO();
		funcDAO.excluir(id);
		
	}
	
	public void cadastrarUsuario(Usuario usuarioVO) throws Exception{
		
		UsuarioDAO usuarioDAO = fabrica.criarUsuarioDAO();
		usuarioDAO.inserir(usuarioVO);
		
	}
	
	public Usuario consultarUsuario(Usuario usuarioVO) throws Exception{
		
		UsuarioDAO usuarioDAO = fabrica.criarUsuarioDAO();
		
		return usuarioDAO.pesquisar(usuarioVO.getLogin(), usuarioVO.getSenha());
		
	}
	
	public void cadastrarTipoLicenca(Tipo_Licenca tipoLicenVO) throws Exception{
		
		Tipo_LicencaDAO tipoDAO = fabrica.criarTipoLicencaDAO();
		tipoDAO.inserir(tipoLicenVO);
		
	}
	
	public void cadastrarDependentes(Funcionario funcVO) throws Exception{
		
		DependenteDAO depDAO = fabrica.criarDependenteDAO();
		
		for (int i = 0; i < funcVO.dependentes.size(); i++) {
			depDAO.inserir(funcVO.dependentes.get(i));
		}
		
	}
	
	public ArrayList<Funcionario>getFuncionarios() throws Exception{
		
		FuncionarioDAO funcDAO = fabrica.criarFuncionarioDAO();
		
		return funcDAO.listar();
		
	}
	
	public Funcionario getFuncionario(int id) throws Exception{
		
		Funcionario func = new Funcionario();
		FuncionarioDAO funcDAO = fabrica.criarFuncionarioDAO();
		AlistamentoDAO alistDAO = fabrica.criarAlistamentoDAO();
		CarteiraDeTrabalhoDAO cartDAO = fabrica.criarCarteiraDeTrabalhoDAO();
		EnderecoDAO endDAO = fabrica.criarEnderecoDAO();
		IdentidadeDAO identDAO = fabrica.criarIdentidadeDAO();
		NaturalidadeDAO natDAO = fabrica.criarNaturalidadeDAO();
		TituloEleitoralDAO tituloDAO = fabrica.criarTituloEleitoralDAO();
		
		func = funcDAO.pesquisar(id);
		func.alistamento = alistDAO.pesquisar(id);
		func.carteira = cartDAO.pesquisar(id);
		func.endereco = endDAO.pesquisar(id);
		func.identidade = identDAO.pesquisar(id);
		func.naturalidade = natDAO.pesquisar(id);
		func.titulo = tituloDAO.pesquisar(id);
		
		return func;
	}
	
	public ArrayList<Tipo_Licenca> getTipoLicencas() throws Exception{
		
		Tipo_LicencaDAO tipoDAO = fabrica.criarTipoLicencaDAO();
		
		return tipoDAO.getTipos();
	
	}
	
	public Tipo_Licenca getTipoLicenca(Licenca licenVO) throws Exception{
		
		Tipo_LicencaDAO tipoDAO = fabrica.criarTipoLicencaDAO();
		
		return tipoDAO.pesquisar(licenVO.tipo_Licenca.getIdTipo());
	}
	
	public void RealizarBackup(){
		
	}
	
	public void RestaurarDados(){
		
	}

}
