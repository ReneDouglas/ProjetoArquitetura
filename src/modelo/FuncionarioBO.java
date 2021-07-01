package modelo;

import modelo.VOs.Funcionario;
import modelo.fabrica.FabricaDAO;
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
import modelo.fabrica.DAOs.VidaFuncionalDAO;

public class FuncionarioBO {
	
	private FabricaDAO fabrica = FabricaDAO.getFabricaDAO();
	private FuncionarioDAO funcDAO = fabrica.criarFuncionarioDAO();
	
	public void LogicaCadastrarFuncionario(Funcionario funcVO) throws Exception{
		
		if(funcVO.historico == null && funcVO.licencas == null && funcVO.ferias == null && funcVO.dependentes == null){
			
			cadastrarFichaFuncional(funcVO);
			
		}
		else if(funcVO.licencas == null && funcVO.ferias == null && funcVO.dependentes == null){
			
			cadastrarHistorico(funcVO);
			
		}
		else if(funcVO.historico == null && funcVO.ferias == null && funcVO.dependentes == null){
			
			cadastrarLicenca(funcVO);
			
		}
		else if(funcVO.historico == null && funcVO.licencas == null && funcVO.dependentes == null){
			
			cadastrarFerias(funcVO);
			
		}
		else if(funcVO.historico == null && funcVO.licencas == null && funcVO.ferias == null){
			
			cadastrarDependentes(funcVO);
			
		}
		
	}
	
	public void LogicaEditarFuncionario(Funcionario funcVO, int controle) throws Exception{
		
		switch (controle) {
		case 0:
			
			editarFichaFuncional(funcVO);
			break;
			
		case 1:
			
			editarHistorico(funcVO);
			break;
			
		case 2:
			
			editarLicenca(funcVO);
			break;
			
		case 3:
			
			editarFerias(funcVO);
			break;
			
		case 4:
			
			editarDependentes(funcVO);
			break;

		default:
			break;
		}
		
	}
	
	private void cadastrarFichaFuncional(Funcionario funcVO) throws Exception{
				
		AlistamentoDAO alistDAO = fabrica.criarAlistamentoDAO();
		CarteiraDeTrabalhoDAO carteiraDAO = fabrica.criarCarteiraDeTrabalhoDAO();
		EnderecoDAO enderecoDAO = fabrica.criarEnderecoDAO();
		IdentidadeDAO identDAO = fabrica.criarIdentidadeDAO();
		NaturalidadeDAO natDAO = fabrica.criarNaturalidadeDAO();
		TituloEleitoralDAO tituloDAO = fabrica.criarTituloEleitoralDAO();
		
		funcDAO.inserir(funcVO);
		
		//funcVO.idFunc = funcDAO.getIdFunc();
		funcVO.alistamento.setIdAlist(funcVO.idFunc);
		funcVO.carteira.setIdCarteira(funcVO.idFunc);
		funcVO.endereco.setIdEnd(funcVO.idFunc);
		funcVO.identidade.setIdIdent(funcVO.idFunc);
		funcVO.naturalidade.setIdNat(funcVO.idFunc);
		funcVO.titulo.setIdTitulo(funcVO.idFunc);
		
		alistDAO.inserir(funcVO.alistamento);
		carteiraDAO.inserir(funcVO.carteira);
		enderecoDAO.inserir(funcVO.endereco);
		identDAO.inserir(funcVO.identidade);
		natDAO.inserir(funcVO.naturalidade);
		tituloDAO.inserir(funcVO.titulo);
		
		
	}
	
	private void cadastrarHistorico(Funcionario funcVO) throws Exception{
		
		VidaFuncionalDAO histDAO = fabrica.criarVidaFuncionalDAO();
		funcVO.idFunc = funcDAO.getIdFunc();
		
		for (int i = 0; i < funcVO.historico.size(); i++) {
			funcVO.historico.get(i).idVidaFunc = funcVO.idFunc;
			histDAO.inserir(funcVO.historico.get(i));
		}
		
		
	}
	
	private void cadastrarFerias(Funcionario funcVO) throws Exception{
		
		FeriasDAO feriasDAO = fabrica.criarFeriasDAO();
		funcVO.idFunc = funcDAO.getIdFunc();
		
		for (int i = 0; i < funcVO.ferias.size(); i++) {
			funcVO.ferias.get(i).idFerias = funcVO.idFunc;
			feriasDAO.inserir(funcVO.ferias.get(i));
		}
		
	}
	
	private void cadastrarLicenca(Funcionario funcVO) throws Exception{
		
		LicencaDAO licencaDAO = fabrica.criarLicencaDAO();
		Tipo_LicencaDAO tipoDAO = fabrica.criarTipoLicencaDAO();
		
		funcVO.idFunc = funcDAO.getIdFunc();
		
		for (int i = 0; i < funcVO.licencas.size(); i++) {
			
			funcVO.licencas.get(i).tipo_Licenca.setIdTipo(tipoDAO.pesquisar(funcVO.licencas.get(i).tipo_Licenca.getNomeTipo()).getIdTipo());
			funcVO.licencas.get(i).idLicenca = funcVO.idFunc;
			licencaDAO.inserir(funcVO.licencas.get(i));
		}
		
	}
	
	private void cadastrarDependentes(Funcionario funcVO) throws Exception{
		
		DependenteDAO depDAO = fabrica.criarDependenteDAO();
		funcVO.idFunc = funcDAO.getIdFunc();
		
		for (int i = 0; i < funcVO.dependentes.size(); i++) {
			funcVO.dependentes.get(i).idDep = funcVO.idFunc;
			depDAO.inserir(funcVO.dependentes.get(i));
		}
		
	}
	
	private void editarFichaFuncional(Funcionario funcVO) throws Exception{
		
		AlistamentoDAO alistDAO = fabrica.criarAlistamentoDAO();
		CarteiraDeTrabalhoDAO carteiraDAO = fabrica.criarCarteiraDeTrabalhoDAO();
		EnderecoDAO enderecoDAO = fabrica.criarEnderecoDAO();
		IdentidadeDAO identDAO = fabrica.criarIdentidadeDAO();
		NaturalidadeDAO natDAO = fabrica.criarNaturalidadeDAO();
		TituloEleitoralDAO tituloDAO = fabrica.criarTituloEleitoralDAO();
		
		funcVO.alistamento.setIdAlist(funcVO.idFunc);
		funcVO.carteira.setIdCarteira(funcVO.idFunc);
		funcVO.endereco.setIdEnd(funcVO.idFunc);
		funcVO.identidade.setIdIdent(funcVO.idFunc);
		funcVO.naturalidade.setIdNat(funcVO.idFunc);
		funcVO.titulo.setIdTitulo(funcVO.idFunc);
		
		funcDAO.atualizar(funcVO);
		alistDAO.atualizar(funcVO.alistamento);
		carteiraDAO.atualizar(funcVO.carteira);
		enderecoDAO.atualizar(funcVO.endereco);
		identDAO.atualizar(funcVO.identidade);
		natDAO.atualizar(funcVO.naturalidade);
		tituloDAO.atualizar(funcVO.titulo);
		
	}
	
	private void editarHistorico(Funcionario funcVO) throws Exception{
		
		VidaFuncionalDAO histDAO = fabrica.criarVidaFuncionalDAO();
		
		for (int i = 0; i < funcVO.historico.size(); i++) {
			funcVO.historico.get(i).idVidaFunc = funcVO.idFunc;
			histDAO.atualizar(funcVO.historico.get(i));
		}
		
	}
	
	private void editarLicenca(Funcionario funcVO) throws Exception{
		
		LicencaDAO licencaDAO = fabrica.criarLicencaDAO();
		Tipo_LicencaDAO tipoDAO = fabrica.criarTipoLicencaDAO();
		
		for (int i = 0; i < funcVO.licencas.size(); i++) {
			
			funcVO.licencas.get(i).tipo_Licenca.setIdTipo(tipoDAO.pesquisar(funcVO.licencas.get(i).tipo_Licenca.getNomeTipo()).getIdTipo());
			funcVO.licencas.get(i).idLicenca = funcVO.idFunc;
			licencaDAO.atualizar(funcVO.licencas.get(i));
			
		}
		
	}
	
	private void editarFerias(Funcionario funcVO) throws Exception{
		
		FeriasDAO feriasDAO = fabrica.criarFeriasDAO();
		
		for (int i = 0; i < funcVO.ferias.size(); i++) {
			funcVO.ferias.get(i).idFerias = funcVO.idFunc;
			feriasDAO.atualizar(funcVO.ferias.get(i));
		}
		
	}
	
	private void editarDependentes(Funcionario funcVO) throws Exception{
		
		DependenteDAO depDAO = fabrica.criarDependenteDAO();
		
		for (int i = 0; i < funcVO.dependentes.size(); i++) {
			funcVO.dependentes.get(i).idDep = funcVO.idFunc;
			depDAO.atualizar(funcVO.dependentes.get(i));
		}
		
	}

}
