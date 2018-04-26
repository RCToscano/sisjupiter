package br.com.andsisjupiter.modelo;

public class FotoDiag {

	private Long idFotoDiag;
	private Long idComunidade;
	private Long idEquipe;
	private Long idDiagnosticoApp;
    private String coordX;
    private String coordY;
	private String arquivo;
	private Long tpFoto;
	private Long situacao;
	private String dtInsert;
	public Long getIdFotoDiag() {
		return idFotoDiag;
	}
	public void setIdFotoDiag(Long idFotoDiag) {
		this.idFotoDiag = idFotoDiag;
	}
	public Long getIdComunidade() {
		return idComunidade;
	}
	public void setIdComunidade(Long idComunidade) {
		this.idComunidade = idComunidade;
	}
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public Long getIdDiagnosticoApp() {
		return idDiagnosticoApp;
	}
	public void setIdDiagnosticoApp(Long idDiagnosticoApp) {
		this.idDiagnosticoApp = idDiagnosticoApp;
	}
	public String getCoordX() {
		return coordX;
	}
	public void setCoordX(String coordX) {
		this.coordX = coordX;
	}
	public String getCoordY() {
		return coordY;
	}
	public void setCoordY(String coordY) {
		this.coordY = coordY;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public Long getTpFoto() {
		return tpFoto;
	}
	public void setTpFoto(Long tpFoto) {
		this.tpFoto = tpFoto;
	}
	public Long getSituacao() {
		return situacao;
	}
	public void setSituacao(Long situacao) {
		this.situacao = situacao;
	}
	public String getDtInsert() {
		return dtInsert;
	}
	public void setDtInsert(String dtInsert) {
		this.dtInsert = dtInsert;
	}
	
}
