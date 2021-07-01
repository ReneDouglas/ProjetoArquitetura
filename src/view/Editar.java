package view;

import controle.controleTelaEditar.ControlePreencherTelaEditar;

public class Editar extends Cadastrar{


	private static final long serialVersionUID = 1L;
	
	public Editar(int idFunc) {
		super();

		new ControlePreencherTelaEditar(this, idFunc);
		
	}


}