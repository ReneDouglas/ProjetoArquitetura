package controle.controleTelaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Fachada;
import modelo.VOs.Usuario;

import view.Aplicacao;
import view.Login;

public class RealizarLogin implements ActionListener{

	Login tela;
	
	public RealizarLogin(Login tela) {
		this.tela = tela;
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		if(tela.textField.getText().equals("") || tela.textField_1.getText().equals("")){
			JOptionPane.showMessageDialog(tela, "Preencha todos os campos.");
		}
		else{
			Fachada fachada = new Fachada();
			Usuario usuarioVO = new Usuario();
			usuarioVO.setLogin(tela.textField.getText());
			usuarioVO.setSenha(tela.textField_1.getText());
			
			try {
				if(fachada.consultarUsuario(usuarioVO) != null){
					
					tela.dispose();
					new Aplicacao();
					
				}
				else{
					JOptionPane.showMessageDialog(tela, "Usuário n"+(char)227+"o encontrado.\nLogin ou Senha inválidos.");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(tela, e1.getMessage());
			}
		}
		
	}

}
