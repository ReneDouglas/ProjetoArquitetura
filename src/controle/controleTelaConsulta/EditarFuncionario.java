package controle.controleTelaConsulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Aplicacao;
import view.Consultar;
import view.Editar;

public class EditarFuncionario implements ActionListener{

	private Consultar tela;
	private Aplicacao api;
	
	public EditarFuncionario(Consultar tela, Aplicacao api) {
		this.tela = tela;
		this.api = api;
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if(tela.table.getSelectedRow() > -1){
			
			this.api.pane.remove(tela);
			this.api.pane.add(new Editar(Integer.valueOf((String) tela.table.getValueAt(tela.table.getSelectedRow(), 0))));
			
			
		} else JOptionPane.showMessageDialog(tela, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);
		
	}

}
