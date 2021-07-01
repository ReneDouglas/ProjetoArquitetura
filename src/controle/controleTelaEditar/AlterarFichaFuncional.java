package controle.controleTelaEditar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import modelo.Fachada;
import modelo.VOs.Funcionario;

import view.FichaFuncional;

public class AlterarFichaFuncional implements ActionListener{

	private FichaFuncional tela;
	private Fachada fachada;
	private int id;
	
	public AlterarFichaFuncional(FichaFuncional tela, int id) {
		this.tela = tela;
		this.id = id;
		this.fachada = new Fachada();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String sexo = (tela.getRdbtnMasc().isSelected()) ? "Masculino": "Feminino";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
				
			Funcionario funcionario = new Funcionario();
			
			funcionario.idFunc = id;
			funcionario.nome = tela.getTextField_nome().getText();
			funcionario.nomePai = tela.getTextField_pai().getText();
			funcionario.nomeMae = tela.getTextField_mae().getText();
			funcionario.dataNasc = new java.sql.Date((formatter.parse(tela.getTextField_nasc().getText())).getTime());
			funcionario.sexo = sexo;
			funcionario.estCivil = tela.getTextField_civil().getText();
			funcionario.pasep = tela.getTextField_pasep().getText();
			funcionario.matricula = tela.getTextField_matr().getText();
			funcionario.cpf = tela.getTextField_cpf().getText();
			funcionario.grauDeInst = tela.getTextField_grau().getText();
			
			funcionario.identidade.setData(new java.sql.Date((formatter.parse(tela.getTextField_dataIdent().getText())).getTime()));
			funcionario.identidade.setNumero(tela.getTextField_identNum().getText());
			funcionario.identidade.setSsp(tela.getTextField_ssp().getText());
			
			funcionario.carteira.setCtpsNumero(tela.getTextField_ctps().getText());
			funcionario.carteira.setData(new java.sql.Date((formatter.parse(tela.getTextField_dataCtps().getText())).getTime()));
			funcionario.carteira.setSerie(tela.getTextField_serieCtps().getText());
			
			funcionario.endereco.setBairro(tela.getTextField_bairro().getText());
			funcionario.endereco.setRua(tela.getTextField_rua().getText());
			funcionario.endereco.setNumero(tela.getTextField_numero().getText());
			
			funcionario.naturalidade.setCidade(tela.getTextField_cidade().getText());
			funcionario.naturalidade.setEstado(tela.getComboBox().getSelectedItem().toString());
			
			funcionario.titulo.setNumero(tela.getTextField_numTitulo().getText());
			funcionario.titulo.setSecao(tela.getTextField_secao().getText());
			funcionario.titulo.setZona(tela.getTextField_zona().getText());
			
			if(sexo == "Masculino"){
			
				funcionario.alistamento.setSituacaoMilitar(tela.getTextField_situacaoMil().getText());
				funcionario.alistamento.setSerie(tela.getTextField_serieMil().getText());
				funcionario.alistamento.setEsp(tela.getTextField_esp().getText());
			}
			
			
			fachada.editarFuncionario(funcionario, 0);
			
			JOptionPane.showMessageDialog(tela, "Cadastro Alterado com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
			tela.limpar_form(tela);
			
		} catch (ParseException e1) {
			
			e1.printStackTrace();
			JOptionPane.showMessageDialog(tela, e1.getMessage());
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			JOptionPane.showMessageDialog(tela, e1.getMessage());
		}
		
		
	}
	
}
