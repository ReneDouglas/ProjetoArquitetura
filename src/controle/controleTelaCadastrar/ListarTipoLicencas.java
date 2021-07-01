package controle.controleTelaCadastrar;

import java.util.ArrayList;

import modelo.Fachada;
import modelo.VOs.Tipo_Licenca;

public class ListarTipoLicencas {
	
	public static String[] preencherComboBox(){
		
		Fachada fachada = new Fachada();
		ArrayList<Tipo_Licenca> tipos = new ArrayList<Tipo_Licenca>();
		String[] preencher = null;
		
		try {
			
			tipos = fachada.getTipoLicencas();
			preencher = new String[tipos.size()];
			
			for (int i = 0; i < preencher.length; i++) {
				preencher[i] = tipos.get(i).getNomeTipo();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return preencher;
		
	}

}
