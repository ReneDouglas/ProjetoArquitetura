package controle.controleTelaEditar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Historico;

import modelo.Fachada;

public class AlterarFerias implements ActionListener{

	@SuppressWarnings("unused")
	private Historico tela;
	@SuppressWarnings("unused")
	private Fachada fachada;
	
	public AlterarFerias(Historico tela) {
		this.tela = tela;
		fachada = new Fachada();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
