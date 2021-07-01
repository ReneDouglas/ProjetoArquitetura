package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import controle.controleTelaLogin.RealizarLogin;

public class Login extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField textField;
	public JPasswordField textField_1;
	private JButton btnEntrar;
	private JLabel folder;
	private ImageIcon imgFolder;
	
	public Login() {
		super("Acesso ao Sistema");
		
		try {

			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		setSize(705, 525);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 700, 500);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		imgFolder = new ImageIcon(getClass().getClassLoader().getResource("CRHCurvasLogin.png"));
		folder = new JLabel();
		folder.setIcon(imgFolder);
		folder.setBounds(0, 0, imgFolder.getIconWidth(), imgFolder.getIconHeight());
		
		
		JLabel lblLogin = new JLabel("LOGIN:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblLogin.setBounds(214, 213, 51, 14);
		panel.add(lblLogin);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSenha.setBounds(214, 259, 51, 14);
		panel.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(214, 229, 237, 28);
		//textField.setDocument(new UpperCaseDocument());
		textField.addActionListener(new RealizarLogin(this));
		panel.add(textField);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(214, 275, 237, 28);
		//textField_1.setDocument(new UpperCaseDocument());
		textField_1.addActionListener(new RealizarLogin(this));
		panel.add(textField_1);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(285, 322, 90, 28);
		btnEntrar.addActionListener(new RealizarLogin(this));
		panel.add(btnEntrar);
		
		panel.add(folder);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Login();
	}
	
}
