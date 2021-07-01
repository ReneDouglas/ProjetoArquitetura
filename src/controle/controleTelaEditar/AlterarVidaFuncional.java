package controle.controleTelaEditar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Fachada;
import modelo.VOs.Funcionario;
import modelo.VOs.VidaFuncional;

import view.Historico;

public class AlterarVidaFuncional implements ActionListener{

	
	private Historico tela;
	private Fachada fachada;
	private int id;
	
	public AlterarVidaFuncional(Historico tela, int id) {
		this.tela = tela;
		this.id = id;
		fachada = new Fachada();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(tela.getTable_vidaFunc().getRowCount() > 0){
			
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Funcionario func = new Funcionario();
			func.idFunc = id;
			func.historico = new ArrayList<VidaFuncional>();
			VidaFuncional histVO;
			
			
			for (int i = 0; i < tela.getTable_vidaFunc().getRowCount(); i++) {
				
				histVO = new VidaFuncional();
				
				try {
					
					histVO.port = tela.getTable_vidaFunc().getValueAt(i, 0).toString();
					histVO.dataNomeacao = new Date(formatter.parse(tela.getTable_vidaFunc().getValueAt(i, 1).toString()).getTime());
					histVO.dataExercicio = new Date(formatter.parse(tela.getTable_vidaFunc().getValueAt(i, 2).toString()).getTime());
					histVO.dataLicenca = new Date(formatter.parse(tela.getTable_vidaFunc().getValueAt(i, 3).toString()).getTime());
					histVO.dataAlteracao = new Date(formatter.parse(tela.getTable_vidaFunc().getValueAt(i, 4).toString()).getTime());
					histVO.cargo = tela.getTable_vidaFunc().getValueAt(i, 5).toString();
					histVO.fs = tela.getTable_vidaFunc().getValueAt(i, 6).toString();
					histVO.p = tela.getTable_vidaFunc().getValueAt(i, 7).toString();
					histVO.secretaria = tela.getTable_vidaFunc().getValueAt(i, 8).toString();
					histVO.localizacao = tela.getTable_vidaFunc().getValueAt(i, 9).toString();
					histVO.observacao = tela.getTable_vidaFunc().getValueAt(i, 10).toString();
					
					func.historico.add(histVO);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			try {
				fachada.editarFuncionario(func, 1);
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(tela, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
			}
			
			JOptionPane.showMessageDialog(tela, "Cadastro Alterado com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
			
			tela.limpar_tabela(tela.getModelo_vidaFunc());
		} else JOptionPane.showMessageDialog(tela, "Tabela Vazia!");
		
	}
	
}
