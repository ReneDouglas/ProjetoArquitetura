package modelo.VOs;

public class Alistamento {
	
	private int idAlist;
	private String situacaoMilitar;
	private String serie;
	private String esp;
		
	public Alistamento() {
		// TODO Auto-generated constructor stub
	}

	public int getIdAlist() {
		return idAlist;
	}

	public void setIdAlist(int chaveFunc) {
		this.idAlist = chaveFunc;
	}

	public String getSituacaoMilitar() {
		return situacaoMilitar;
	}

	public void setSituacaoMilitar(String situacaoMilitar) {
		this.situacaoMilitar = situacaoMilitar;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getEsp() {
		return esp;
	}

	public void setEsp(String esp) {
		this.esp = esp;
	}
	
		
}
