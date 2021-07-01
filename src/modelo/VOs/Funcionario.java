package modelo.VOs;

import java.sql.Date;
import java.util.ArrayList;

import modelo.fabrica.FabricaDAO;
import modelo.fabrica.DAOs.DependenteDAO;
import modelo.fabrica.DAOs.FeriasDAO;
import modelo.fabrica.DAOs.LicencaDAO;
import modelo.fabrica.DAOs.VidaFuncionalDAO;

public class Funcionario{

	public int idFunc;
	public String nome;
	public String nomePai;
	public String nomeMae;
	public Date dataNasc;
	public String sexo;
	public String estCivil;
	public String pasep;
	public String matricula;
	public String cpf;
	public String grauDeInst;
	public ArrayList<VidaFuncional> historico = null;
	public ArrayList<Licenca> licencas = null;
	public ArrayList<Ferias> ferias = null;
	public ArrayList<Dependente> dependentes = null;
	public Alistamento alistamento = new Alistamento();
	public CarteiraDeTrabalho carteira = new CarteiraDeTrabalho();
	public Endereco endereco = new Endereco();
	public Identidade identidade = new Identidade();
	public Naturalidade naturalidade = new Naturalidade();
	public TituloEleitoral titulo = new TituloEleitoral();
	
	public Funcionario(){
		
		
	}
	
	public ArrayList<VidaFuncional> getHistorico(){
		
		
		if(this.historico == null){
			
			FabricaDAO fabrica = FabricaDAO.getFabricaDAO();
			VidaFuncionalDAO histDAO = fabrica.criarVidaFuncionalDAO();
			try {
				this.historico = histDAO.listar(this.idFunc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return this.historico;
		
	}
	
	public ArrayList<Licenca> getLicencas(){
		
		if(this.licencas == null){
			
			FabricaDAO fabrica = FabricaDAO.getFabricaDAO();
			LicencaDAO licenDAO = fabrica.criarLicencaDAO();
			
			try {
				this.licencas = licenDAO.listar(this.idFunc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return this.licencas;
	}
	
	public ArrayList<Ferias> getFerias(){
		
		if(this.ferias == null){
			
			FabricaDAO fabrica = FabricaDAO.getFabricaDAO();
			FeriasDAO feriasDAO = fabrica.criarFeriasDAO();
			
			try {
				this.ferias = feriasDAO.listar(this.idFunc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return this.ferias;
		
	}
	
	public ArrayList<Dependente> getDependentes(){
		
		if(this.dependentes == null){
			
			FabricaDAO fabrica = FabricaDAO.getFabricaDAO();
			DependenteDAO depDAO = fabrica.criarDependenteDAO();
			
			try {
				this.dependentes = depDAO.listar(this.idFunc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.dependentes;
	}
	
		
}
