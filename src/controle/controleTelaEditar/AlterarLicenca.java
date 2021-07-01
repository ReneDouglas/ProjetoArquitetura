package controle.controleTelaEditar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Fachada;
import view.Historico;

public class AlterarLicenca implements ActionListener{

	@SuppressWarnings("unused")
	private Historico tela;
	@SuppressWarnings("unused")
	private Fachada fachada;
	
	public AlterarLicenca(Historico tela) {
		this.tela = tela;
		fachada = new Fachada();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
