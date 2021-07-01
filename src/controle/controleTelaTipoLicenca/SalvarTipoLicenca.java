package controle.controleTelaTipoLicenca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Fachada;
import modelo.VOs.Tipo_Licenca;

import view.CadastrarLicenca;

public class SalvarTipoLicenca implements ActionListener{
	
	private CadastrarLicenca tela;
	private Fachada fachada;
	
	public SalvarTipoLicenca(CadastrarLicenca tela) {
		this.tela = tela;
		this.fachada = new Fachada();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		Tipo_Licenca tipoLicenVO = new Tipo_Licenca();
		
		tipoLicenVO.setIdTipo(0);
		tipoLicenVO.setNomeTipo(tela.textField.getText());
		
		try {
			
			fachada.cadastrarTipoLicenca(tipoLicenVO);
			JOptionPane.showMessageDialog(tela, "Cadastro Realizado com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
			tela.limpar_form(tela.desktopPane);
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(tela, e.getMessage());
		}
		
		
	}

}
