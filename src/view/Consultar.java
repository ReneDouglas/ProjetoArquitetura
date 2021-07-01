package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import controle.controleTelaConsulta.ConsultarFuncionario;
import controle.controleTelaConsulta.DeletarFuncionario;
import controle.controleTelaConsulta.EditarFuncionario;

public class Consultar extends JDesktopPane implements KeyListener{

	private static final long serialVersionUID = 1L;
	public JComboBox<String> comboBoxPesquisa;
	public JComboBox<String> comboBoxOrganiza;
	public JTextField textFieldPesquisa;
	public JLabel lblOrganizarPor;
	public JButton btnImprimir;
	public JButton btnEditar;
	public JButton btnDeletar;
	public JRadioButton rdbtnConsultaSemHistrico;
	public JScrollPane scrollPane;
	public JTable table;
	public DefaultTableModel modelo_1 = null, modelo_2 = null;
	private Background bg;
	

	public Consultar(Aplicacao api) {
		
		UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		

		
		JLabel lblPesquisarPor = new JLabel("Pesquisar por:");
		lblPesquisarPor.setForeground(Color.WHITE);
		lblPesquisarPor.setBounds(23, 23, 89, 20);
		this.add(lblPesquisarPor);
		
		comboBoxPesquisa = new JComboBox<String>();
		comboBoxPesquisa.setBounds(112, 21, 109, 25);
		this.add(comboBoxPesquisa);
		
		comboBoxPesquisa.addItem("ID");
		comboBoxPesquisa.addItem("Nome");
		comboBoxPesquisa.addItem("CPF");
		comboBoxPesquisa.addItem("Cargo");
		comboBoxPesquisa.setSelectedIndex(0);
		
		lblOrganizarPor = new JLabel("Organizar por:");
		lblOrganizarPor.setBounds(799, 24, 77, 20);
		this.add(lblOrganizarPor);
		
		comboBoxOrganiza = new JComboBox<String>();
		comboBoxOrganiza.setBounds(886, 23, 117, 25);
		this.add(comboBoxOrganiza);
		
		comboBoxOrganiza.addItem("ID");
		comboBoxOrganiza.addItem("Nome");
		comboBoxOrganiza.addItem("CPF");
		comboBoxOrganiza.addItem("Cargo");
		comboBoxOrganiza.setSelectedIndex(1);
		comboBoxOrganiza.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
						
				//construirTabela_1();
				
			}
		});
		
		textFieldPesquisa = new JTextField();
		textFieldPesquisa.setBounds(231, 21, 381, 26);
		this.add(textFieldPesquisa);
		textFieldPesquisa.addKeyListener(this);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(237, 85, 100, 27);
		btnImprimir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnConsultaSemHistrico.isSelected()){
					/*if(table_2.getSelectedRow() > -1){
						
				
					}else JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);*/
				}
				else{
					if(table.getSelectedRow() > -1){
						
						
					}else JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela.","Erro!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		this.add(btnImprimir);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(130, 85, 100, 27);
		btnDeletar.addActionListener(new DeletarFuncionario(this));
		this.add(btnDeletar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 115, 980, 482);
		this.add(scrollPane);
		
		//construirTabela_1();
		
		rdbtnConsultaSemHistrico = new JRadioButton("Consulta sem hist\u00F3rico");
		rdbtnConsultaSemHistrico.setBounds(628, 25, 150, 18);
		rdbtnConsultaSemHistrico.addActionListener(new ConsultarFuncionario(this));
		this.add(rdbtnConsultaSemHistrico);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new EditarFuncionario(this, api));
		btnEditar.setBounds(24, 85, 100, 27);
		//btnEditar.addActionListener(this);
		this.add(btnEditar);
			
		bg = new Background("CRHCurvasBG.png");
		bg.setSize(1024, 718);
		this.add(bg);
		
		new ConsultarFuncionario(this).construirTabelaComHistorico();
		
		setSize(1024, 718);
		setVisible(true);
	}
	

	
	public void atualizarComboBox(){
		
		comboBoxPesquisa.removeAllItems();
		comboBoxOrganiza.removeAllItems();
		
		if(rdbtnConsultaSemHistrico.isSelected() == false){
			
			comboBoxPesquisa.addItem("ID");
			comboBoxPesquisa.addItem("Nome");
			comboBoxPesquisa.addItem("CPF");
			comboBoxPesquisa.addItem("Cargo");
			comboBoxPesquisa.setSelectedIndex(0);
			
			comboBoxOrganiza.addItem("ID");
			comboBoxOrganiza.addItem("Nome");
			comboBoxOrganiza.addItem("CPF");
			comboBoxOrganiza.addItem("Cargo");
			comboBoxOrganiza.setSelectedIndex(1);
			
		}
		
		else{
			
			comboBoxPesquisa.addItem("ID");
			comboBoxPesquisa.addItem("Nome");
			comboBoxPesquisa.addItem("Data de Nasc.");
			comboBoxPesquisa.addItem("CPF");
			comboBoxPesquisa.setSelectedIndex(0);
			
			comboBoxOrganiza.addItem("ID");
			comboBoxOrganiza.addItem("Nome");
			comboBoxOrganiza.addItem("Data de Nasc.");
			comboBoxOrganiza.addItem("CPF");
			comboBoxOrganiza.setSelectedIndex(1);
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		
		/*if((e.getSource() == textFieldPesquisa) && (rdbtnConsultaSemHistrico.isSelected())){
			
			atualizarTabela_2((String)comboBoxPesquisa.getSelectedItem(), (String)comboBoxOrganiza.getSelectedItem(), textFieldPesquisa.getText());
			
		}
		else if((e.getSource() == textFieldPesquisa) && !(rdbtnConsultaSemHistrico.isSelected())){
			
			atualizarTabela_1((String)comboBoxPesquisa.getSelectedItem(), (String)comboBoxOrganiza.getSelectedItem(), textFieldPesquisa.getText());
		
		}*/
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
