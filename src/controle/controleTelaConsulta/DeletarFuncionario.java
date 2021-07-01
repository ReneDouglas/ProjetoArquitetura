package controle.controleTelaConsulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Fachada;

import view.Consultar;

public class DeletarFuncionario implements ActionListener{

	private Consultar tela;
	private Fachada fachada;
	
	public DeletarFuncionario(Consultar tela) {
		this.tela = tela;
		fachada = new Fachada();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int decisao = JOptionPane.showConfirmDialog(tela, "Ao excluir o funcionário todos os dados relacionados a ele serão excluídos.", "Confirmação", JOptionPane.YES_NO_OPTION);
		
		if(decisao == JOptionPane.YES_OPTION){
				if(tela.table.getSelectedRow() > -1){
					
					try {
						
						fachada.excluirFuncionario(Integer.valueOf((String)tela.table.getValueAt(tela.table.getSelectedRow(), 0)));
						JOptionPane.showMessageDialog(tela, "Exclusão Realizada com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
						
						new ConsultarFuncionario(tela).construirTabelaComHistorico();
						tela.scrollPane.repaint();
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(tela, e1.getMessage(),"Erro!", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
				} else JOptionPane.showMessageDialog(tela, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);
			}
		}

}
