package controle.controleTelaCadastrar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Fachada;
import modelo.VOs.Dependente;
import modelo.VOs.Funcionario;

import view.Dependentes;

public class SalvarDependentes implements ActionListener{

	private Dependentes tela;
	private Fachada fachada;
	
	public SalvarDependentes(Dependentes tela) {

		this.tela = tela;
		this.fachada = new Fachada();
		
	}
	
	public void actionPerformed(ActionEvent e) {

		if(tela.getTable().getRowCount() > 0){
			
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Funcionario func = new Funcionario();
			Dependente depVO;
			
			func.dependentes = new ArrayList<Dependente>();
			
			for (int i = 0; i < tela.getTable().getRowCount(); i++) {
				
				try {
					
					depVO = new Dependente();
				
					depVO.idDep = 0;
					depVO.nome = tela.getTable().getValueAt(i, 1).toString();
					depVO.parentesco = tela.getTable().getValueAt(i, 2).toString();
					depVO.dataNasc = new Date((formatter.parse(tela.getTable().getValueAt(i, 3).toString())).getTime());
					depVO.inicio = new Date((formatter.parse(tela.getTable().getValueAt(i, 4).toString())).getTime());
					depVO.termino = new Date((formatter.parse(tela.getTable().getValueAt(i, 5).toString())).getTime());
					
					func.dependentes.add(depVO);
					
					fachada.cadastrarFuncionario(func);
					JOptionPane.showMessageDialog(tela, "Cadastro Realizado com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
					tela.limpar_tabela(tela.getModelo());
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(tela, e2.getMessage());
				}
				
			}
			
		} else JOptionPane.showMessageDialog(tela, "Tabela Vazia.", "Atenção", JOptionPane.WARNING_MESSAGE);
		
	}

	
}
