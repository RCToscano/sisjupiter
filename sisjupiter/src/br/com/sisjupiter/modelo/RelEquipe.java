package br.com.sisjupiter.modelo;

public class RelEquipe {
	
	private long idComunidade;
	private long idEquipe;
	private long idDiagnostico;
	private long qtde;
	private String nomeEquipe;
	private String loginEquipe;
	private String data;
	
	
	
	public long getIdComunidade() {
		return idComunidade;
	}
	public void setIdComunidade(long idComunidade) {
		this.idComunidade = idComunidade;
	}
	public long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public long getIdDiagnostico() {
		return idDiagnostico;
	}
	public void setIdDiagnostico(long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	public long getQtde() {
		return qtde;
	}
	public void setQtde(long qtde) {
		this.qtde = qtde;
	}
	public String getNomeEquipe() {
		return nomeEquipe;
	}
	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLoginEquipe() {
		return loginEquipe;
	}
	public void setLoginEquipe(String loginEquipe) {
		this.loginEquipe = loginEquipe;
	}
	

}
