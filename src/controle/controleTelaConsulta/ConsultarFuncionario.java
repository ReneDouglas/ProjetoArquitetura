package controle.controleTelaConsulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Fachada;
import modelo.VOs.Funcionario;
import view.Consultar;

public class ConsultarFuncionario implements ActionListener{

	private Consultar tela;
	private Fachada fachada;
	private ArrayList<Funcionario> funcVOList;
	

	public ConsultarFuncionario(Consultar tela) {
		
		this.tela = tela;
		this.fachada = new Fachada();
		this.funcVOList = new ArrayList<Funcionario>();
		
		try {
			
			funcVOList = fachada.getFuncionarios();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		if(tela.rdbtnConsultaSemHistrico.isSelected()){
			
			construirTabelaSemHistorico();
			
		}
		else{
			
			construirTabelaComHistorico();
		}
		
		tela.atualizarComboBox();
		
	}
	
	public void construirTabelaComHistorico(){
	
	String[] colunas = new String[5];
	
	colunas[0] = "ID";
	colunas[1] = "Nome";
	colunas[2] = "CPF";
	colunas[3] = "RG";
	colunas[4] = "Cargo Atual";
	
	if(tela.modelo_1 == null){
		
		for (int i = 0; i < funcVOList.size(); i++) {
			funcVOList.get(i).getHistorico();
		}
		
		tela.modelo_1 = new DefaultTableModel(new Object[][]{}, colunas);
		
		for (int i = 0; i < funcVOList.size(); i++) {
			
			if(funcVOList.get(i).historico.size() != 0){
				tela.modelo_1.addRow(new String[]{""+funcVOList.get(i).idFunc, ""+funcVOList.get(i).nome, ""+funcVOList.get(i).cpf, ""+
						funcVOList.get(i).identidade.getNumero(), ""+funcVOList.get(i).historico.get(funcVOList.get(i).historico.size()-1).cargo});
			}
		}
					
	}
	
	tela.table = new JTable(tela.modelo_1);
	tela.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tela.table.setSelectionMode(0);
	tela.table.getColumnModel().getColumn(0).setPreferredWidth(50);
	tela.table.getColumnModel().getColumn(1).setPreferredWidth(400);
	tela.table.getColumnModel().getColumn(2).setPreferredWidth(130);
	tela.table.getColumnModel().getColumn(3).setPreferredWidth(110);
	tela.table.getColumnModel().getColumn(4).setPreferredWidth(284);
	tela.table.setFillsViewportHeight(true);
	tela.table.getTableHeader().setReorderingAllowed(false);
	
	tela.scrollPane.setViewportView(tela.table);
	
	}
	
	public void construirTabelaSemHistorico(){
		
	String[] colunas = new String[6];
	
	colunas[0] = "ID";
	colunas[1] = "Nome";
	colunas[2] = "CPF";
	colunas[3] = "RG";
	colunas[4] = "Data de Nasc.";
	colunas[5] = "Grau de Inst.";

	if(tela.modelo_2 == null){

		tela.modelo_2 = new DefaultTableModel(new Object[][]{}, colunas);
	
		for (int i = 0; i < funcVOList.size(); i++) {
			tela.modelo_2.addRow(new String[]{""+funcVOList.get(i).idFunc, ""+funcVOList.get(i).nome, ""+funcVOList.get(i).cpf, ""+
					funcVOList.get(i).identidade.getNumero(), ""+new SimpleDateFormat("dd/MM/yyyy").format(funcVOList.get(i).dataNasc), ""+
						funcVOList.get(i).grauDeInst});
		}
	}
	
	tela.table = new JTable(tela.modelo_2);
	tela.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tela.table.setSelectionMode(0);
	tela.table.getColumnModel().getColumn(0).setPreferredWidth(50);
	tela.table.getColumnModel().getColumn(1).setPreferredWidth(350);
	tela.table.getColumnModel().getColumn(2).setPreferredWidth(130);
	tela.table.getColumnModel().getColumn(3).setPreferredWidth(110);
	tela.table.getColumnModel().getColumn(4).setPreferredWidth(142);
	tela.table.getColumnModel().getColumn(5).setPreferredWidth(192);
	tela.table.setFillsViewportHeight(true);
	tela.table.getTableHeader().setReorderingAllowed(false);
	
	tela.scrollPane.setViewportView(tela.table);	
	}
	
	
}
