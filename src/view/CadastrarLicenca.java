package view;


import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controle.controleTelaTipoLicenca.SalvarTipoLicenca;



public class CadastrarLicenca extends JDialog implements ControleComponentes{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JDesktopPane desktopPane;
	public JTextField textField;
	private JLabel lblTipoDeLicena ;
	private JButton btnSalvar;

	public CadastrarLicenca() {
		
		UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		setSize(299,218);
		setTitle("Cadastrar Tipo de Licença");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(6, 6, 279, 172);
		desktopPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(desktopPane);
		
		lblTipoDeLicena = new JLabel("TIPO DE LICEN\u00C7A");
		lblTipoDeLicena.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTipoDeLicena.setBounds(69, 34, 146, 20);
		desktopPane.add(lblTipoDeLicena);
		
		textField = new JTextField();
		//textField.setDocument(new UpperCaseDocument());
		textField.setBounds(69, 65, 146, 26);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(125, 117, 90, 28);
		btnSalvar.addActionListener(new SalvarTipoLicenca(this));
		desktopPane.add(btnSalvar);
		
		setModal(true);
		setVisible(true);
		
	}

	@Override
	public void carregar_mascaras() {
		// TODO Auto-generated method stub
		
	}

	public void limpar_form(JDesktopPane pane) {
		
		for (int i=0; i < pane.getComponentCount(); i++) {     
            
            Component c = pane.getComponent(i);  
            
            if(c instanceof JFormattedTextField){
            	JFormattedTextField field = (JFormattedTextField) c;
            	field.setValue(null);
            }
            else if (c instanceof JTextField) {                             
                JTextField field = (JTextField) c;     
                field.setText("");                        
            }
            
        } 
		
	}

	@Override
	public void limpar_tabela(DefaultTableModel modelo) {
		// TODO Auto-generated method stub
		
	}
}
