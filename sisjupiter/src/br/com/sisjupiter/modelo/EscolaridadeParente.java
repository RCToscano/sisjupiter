
package br.com.sisjupiter.modelo;

public class EscolaridadeParente {
    
    private Long idDiagnoEscolParente;
    private Long idGrauEscol;
    private Long idDiagnostico;
    private String nome;
    private String parentesco;
	
    
    public Long getIdDiagnoEscolParente() {
		return idDiagnoEscolParente;
	}
	public void setIdDiagnoEscolParente(Long idDiagnoEscolParente) {
		this.idDiagnoEscolParente = idDiagnoEscolParente;
	}
	public Long getIdGrauEscol() {
		return idGrauEscol;
	}
	public void setIdGrauEscol(Long idGrauEscol) {
		this.idGrauEscol = idGrauEscol;
	}
	public Long getIdDiagnostico() {
		return idDiagnostico;
	}
	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
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
    
}
