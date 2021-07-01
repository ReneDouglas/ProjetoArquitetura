package controle.controleTelaUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Fachada;
import modelo.VOs.Usuario;

import view.CadastrarUsuario;

public class SalvarUsuario implements ActionListener{

	private CadastrarUsuario tela;
	private Fachada fachada;
	
	public SalvarUsuario(CadastrarUsuario tela) {
		
		this.tela = tela;
		this.fachada = new Fachada();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(tela.textField_1.getText().equals(tela.textField_2.getText())){
			Usuario usuarioVO = new Usuario();
		
			usuarioVO.setIdUsuario(0);
			usuarioVO.setLogin(tela.textField.getText());
			usuarioVO.setSenha(tela.textField_1.getText());
			
			try {
				
				fachada.cadastrarUsuario(usuarioVO);
				JOptionPane.showMessageDialog(tela, "Cadastro Realizado com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
				tela.limpar_form(tela.desktopPane);
				
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(tela, e1.getMessage());
			}
			
			
		}else JOptionPane.showMessageDialog(tela, "Senhas Diferentes.", "Atenção", JOptionPane.WARNING_MESSAGE);
		
		
	}

}
