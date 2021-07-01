package modelo.VOs;

public class Endereco {

	private int idEnd;
	private String rua;
	private String numero;
	private String bairro;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public int getIdEnd() {
		return idEnd;
	}

	public void setIdEnd(int chaveFunc) {
		this.idEnd = chaveFunc;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
