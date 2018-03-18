
package br.com.sisjupiter.modelo;

public class Comunidade {
    
    private Long idComunidade;
    private Long idContrato;
    private String nome;
    private String situacao;
    private String dtInsert;

    public Long getIdComunidade() {
        return idComunidade;
    }

    public void setIdComunidade(Long idComunidade) {
        this.idComunidade = idComunidade;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDtInsert() {
        return dtInsert;
    }

    public void setDtInsert(String dtInsert) {
        this.dtInsert = dtInsert;
    }
    
}
