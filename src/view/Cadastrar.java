package view;

import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;


public class Cadastrar extends JDesktopPane{

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTabbedPane tab;
	private FichaFuncional fichaFuncional;
	private Historico historico;
	private Dependentes dependentes;
	private Background bg;

	public Cadastrar() {
		
		UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.fichaFuncional = new FichaFuncional();
		this.historico = new Historico();
		this.dependentes = new Dependentes();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 996, 650);//710
		scrollPane.setViewportView(this.historico);
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setBounds(10, 11, 996, 640);//710-50
		this.add(tab);
		tab.addTab("Ficha Funcional", null, this.fichaFuncional);
		tab.addTab("Histórico", null, this.scrollPane);
		tab.addTab("Dependentes", null, this.dependentes);
		bg = new Background("CRHCurvasBG.png");
		bg.setSize(1024, 718);
		this.add(bg);
	
		setSize(1024, 710);//718
		this.setLayout(null);
		
		setVisible(true);
				
	}
	

	public FichaFuncional getFichaFuncional() {
		return fichaFuncional;
	}

	public void setFichaFuncional(FichaFuncional fichaFuncional) {
		this.fichaFuncional = fichaFuncional;
	}

	public Dependentes getDependentes() {
		return dependentes;
	}

	public void setDependentes(Dependentes dependentes) {
		this.dependentes = dependentes;
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public Background getBg() {
		return bg;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

	
}
