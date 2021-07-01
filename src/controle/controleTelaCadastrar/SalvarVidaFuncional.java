package controle.controleTelaCadastrar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.JOptionPane;

import modelo.Fachada;
import modelo.VOs.Funcionario;
import modelo.VOs.VidaFuncional;

import view.Historico;

public class SalvarVidaFuncional implements ActionListener {

	private Historico tela;
	private Fachada fachada;

	public SalvarVidaFuncional(Historico tela) {

		this.tela = tela;
		this.fachada = new Fachada();

	}

	public void actionPerformed(ActionEvent arg0) {
		
		if(tela.getTable_vidaFunc().getRowCount() > 0){
			
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			Funcionario func = new Funcionario();
			VidaFuncional hist;
			
			func.historico = new ArrayList<VidaFuncional>();
			
			for (int i = 0; i < tela.getTable_vidaFunc().getRowCount(); i++) {
			
				try {
					
					hist = new VidaFuncional();
					hist.idVidaFunc = 0;
					
					hist.port = tela.getTable_vidaFunc().getValueAt(i, 0).toString();
					hist.dataNomeacao = new Date((formatter.parse(tela.getTable_vidaFunc().getValueAt(i, 1).toString())).getTime());
					hist.dataExercicio = new Date((formatter.parse(tela.getTable_vidaFunc().getValueAt(i, 2).toString())).getTime());
					hist.dataLicenca = new Date((formatter.parse(tela.getTable_vidaFunc().getValueAt(i, 3).toString())).getTime());
					hist.dataAlteracao = new Date((formatter.parse(tela.getTable_vidaFunc().getValueAt(i, 4).toString())).getTime());
					hist.cargo = tela.getTable_vidaFunc().getValueAt(i, 5).toString();
					hist.fs = tela.getTable_vidaFunc().getValueAt(i, 6).toString();
					hist.p = tela.getTable_vidaFunc().getValueAt(i, 7).toString();
					hist.secretaria = tela.getTable_vidaFunc().getValueAt(i, 8).toString();
					hist.localizacao = tela.getTable_vidaFunc().getValueAt(i, 9).toString();
					hist.observacao = tela.getTable_vidaFunc().getValueAt(i, 10).toString();
					
					func.historico.add(hist);
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
			
			try {
				
				fachada.cadastrarFuncionario(func);
				JOptionPane.showMessageDialog(tela, "Cadastro Realizado com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
				tela.limpar_tabela(tela.getModelo_vidaFunc());
				
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(tela, e.getMessage());
			}
			
		}else JOptionPane.showMessageDialog(tela, "Tabela Vazia.", "Atenção", JOptionPane.WARNING_MESSAGE);
	}

}
