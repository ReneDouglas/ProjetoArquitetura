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
import modelo.VOs.Funcionario;
import modelo.VOs.Licenca;
import modelo.VOs.Tipo_Licenca;
import view.Historico;

public class SalvarLicenca implements ActionListener{

	private Historico tela;
	private Fachada fachada;
	
	public SalvarLicenca(Historico tela) {

		this.tela = tela;
		this.fachada = new Fachada();

	}
	
	public void actionPerformed(ActionEvent arg0) {

		if(tela.getTable_licenca().getRowCount() > 0){
			
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Funcionario func = new Funcionario();
			Licenca licen;
			
			func.licencas = new ArrayList<Licenca>();
			
			for (int i = 0; i < tela.getTable_licenca().getRowCount(); i++) {
				
				
				try {
					
					licen = new Licenca();
					licen.idLicenca = 0;
					licen.tipo_Licenca = new Tipo_Licenca();
					
					licen.tipo_Licenca.setNomeTipo(tela.getTable_licenca().getValueAt(i, 0).toString());
					licen.inicio = new Date((formatter.parse(tela.getTable_licenca().getValueAt(i, 1).toString())).getTime());
					licen.termino =  new Date((formatter.parse(tela.getTable_licenca().getValueAt(i, 2).toString())).getTime());
					licen.portaria = tela.getTable_licenca().getValueAt(i, 3).toString();
					licen.observ = tela.getTable_licenca().getValueAt(i, 4).toString();
					
					func.licencas.add(licen);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			try {
				
				fachada.cadastrarFuncionario(func);
				JOptionPane.showMessageDialog(tela, "Cadastro Realizado com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
				tela.limpar_tabela(tela.getModelo_Licenca());
				
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(tela, e.getMessage());
			}
			
			
			
		}else JOptionPane.showMessageDialog(tela, "Tabela Vazia.", "Atenção", JOptionPane.WARNING_MESSAGE);
		
	}

}
