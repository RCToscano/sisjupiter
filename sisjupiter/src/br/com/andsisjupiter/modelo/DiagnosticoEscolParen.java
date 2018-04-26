package br.com.andsisjupiter.modelo;

public class DiagnosticoEscolParen {

	private Long idDiagnosticoEscolParen;
	private Long idDiagnostico;	
	private Long idEquipe;
	private Long idComunidade;
	private String nome;
	private String parentesco;
	private Long grauEscol;
	private String coordX;
	private String coordY;
	private Long situacao;
	private String dtInsert;
	
	public Long getIdDiagnosticoEscolParen() {
		return idDiagnosticoEscolParen;
	}
	public void setIdDiagnosticoEscolParen(Long idDiagnosticoEscolParen) {
		this.idDiagnosticoEscolParen = idDiagnosticoEscolParen;
	}
	public Long getIdDiagnostico() {
		return idDiagnostico;
	}
	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public Long getIdComunidade() {
		return idComunidade;
	}
	public void setIdComunidade(Long idComunidade) {
		this.idComunidade = idComunidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public Long getGrauEscol() {
		return grauEscol;
	}
	public void setGrauEscol(Long grauEscol) {
		this.grauEscol = grauEscol;
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
