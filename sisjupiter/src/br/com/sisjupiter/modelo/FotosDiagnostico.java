package br.com.sisjupiter.modelo;

public class FotosDiagnostico {
	
	private long idDiagnostico;
	private long idFotoDiag;
	private long idComunidade;
	private long idEquipe;
	private long idDiagnosticoApp;
	private String coordX;
	private String coodY;
	private String arquivo;
	private int tpFoto;
	private String dtApp;
	private String dtInsert;
	
	
	
	public long getIdDiagnostico() {
		return idDiagnostico;
	}
	public void setIdDiagnostico(long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	public long getIdFotoDiag() {
		return idFotoDiag;
	}
	public void setIdFotoDiag(long idFotoDiag) {
		this.idFotoDiag = idFotoDiag;
	}
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
	public long getIdDiagnosticoApp() {
		return idDiagnosticoApp;
	}
	public void setIdDiagnosticoApp(long idDiagnosticoApp) {
		this.idDiagnosticoApp = idDiagnosticoApp;
	}
	public String getCoordX() {
		return coordX;
	}
	public void setCoordX(String coordX) {
		this.coordX = coordX;
	}
	public String getCoodY() {
		return coodY;
	}
	public void setCoodY(String coodY) {
		this.coodY = coodY;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public int getTpFoto() {
		return tpFoto;
	}
	public void setTpFoto(int tpFoto) {
		this.tpFoto = tpFoto;
	}
	public String getDtApp() {
		return dtApp;
	}
	public void setDtApp(String dtApp) {
		this.dtApp = dtApp;
	}
	public String getDtInsert() {
		return dtInsert;
	}
	public void setDtInsert(String dtInsert) {
		this.dtInsert = dtInsert;
	}

}
