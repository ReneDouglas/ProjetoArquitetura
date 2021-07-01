package controle.controleTelaCadastrar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Fachada;
import modelo.VOs.Ferias;
import modelo.VOs.Funcionario;
import view.Historico;

public class SalvarFerias implements ActionListener{

	private Historico tela;
	private Fachada fachada;
	
	public SalvarFerias(Historico tela) {
		
		this.tela = tela;
		this.fachada = new Fachada();
		
	}
	
	public void actionPerformed(ActionEvent arg0) {

		if(tela.getTable_ferias().getRowCount() > 0){
			
			Funcionario func = new Funcionario();
			Ferias ferias;
			func.ferias = new ArrayList<Ferias>();
			
			for (int i = 0; i < tela.getTable_ferias().getRowCount(); i++) {
				
				ferias = new Ferias();
				ferias.idFerias = 0;
				ferias.periodoAq = tela.getTable_ferias().getValueAt(i, 0).toString();
				ferias.periodoGozo = tela.getTable_ferias().getValueAt(i, 1).toString();
				ferias.portaria = tela.getTable_ferias().getValueAt(i, 2).toString();
				
				func.ferias.add(ferias);
				
			}
			
			try {

				fachada.cadastrarFuncionario(func);
				JOptionPane.showMessageDialog(tela, "Cadastro Realizado com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
				tela.limpar_tabela(tela.getModelo_Ferias());

			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(tela, e.getMessage());
			}
			
			
		}else JOptionPane.showMessageDialog(tela, "Tabela Vazia.", "Atenção", JOptionPane.WARNING_MESSAGE);
		
	}

}
