package modelo.VOs;

import java.sql.Date;

public class Identidade {

	private int idIdent;
	private String numero;
	private String ssp;
	private Date data;
	
	public Identidade() {
		// TODO Auto-generated constructor stub
	}

	public int getIdIdent() {
		return idIdent;
	}

	public void setIdIdent(int chaveFunc) {
		this.idIdent = chaveFunc;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSsp() {
		return ssp;
	}

	public void setSsp(String ssp) {
		this.ssp = ssp;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
		
}
