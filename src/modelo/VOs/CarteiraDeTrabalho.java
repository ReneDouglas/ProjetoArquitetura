package modelo.VOs;

import java.sql.Date;

public class CarteiraDeTrabalho {

	private int idCarteira;
	private String ctpsNumero;
	private String serie;
	private Date data;
	
	public CarteiraDeTrabalho() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCarteira() {
		return idCarteira;
	}


	public void setIdCarteira(int idCart) {
		this.idCarteira = idCart;
	}


	public String getCtpsNumero() {
		return ctpsNumero;
	}


	public void setCtpsNumero(String ctpsNumero) {
		this.ctpsNumero = ctpsNumero;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	
	
}
