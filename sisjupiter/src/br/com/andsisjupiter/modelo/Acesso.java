
package br.com.andsisjupiter.modelo;

public class Acesso {
    
    private Long idAcesso;
    private Long idEquipe;
    private String dtAcesso;
    private String imei;
    private Long vCode;
    private String vName;
    private String cel;
    private String app;
    private String gps;
    private Long bateria;

    public Long getIdAcesso() {
        return idAcesso;
    }

    public void setIdAcesso(Long idAcesso) {
        this.idAcesso = idAcesso;
    }

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getDtAcesso() {
        return dtAcesso;
    }

    public void setDtAcesso(String dtAcesso) {
        this.dtAcesso = dtAcesso;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Long getvCode() {
        return vCode;
    }

    public void setvCode(Long vCode) {
        this.vCode = vCode;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public Long getBateria() {
        return bateria;
    }

    public void setBateria(Long bateria) {
        this.bateria = bateria;
    }
    
}
