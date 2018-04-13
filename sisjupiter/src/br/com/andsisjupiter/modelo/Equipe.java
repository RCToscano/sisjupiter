
package br.com.andsisjupiter.modelo;

public class Equipe {

    private Long idEquipe;
    private Long idEquipeTp;
    private String equipeTp;
    private Long idEquipeSit;
    private String equipe;
    private String login;
    private String senha;
    private String ckImei;
    private String dtSituacao;
    private String dtInsert;

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Long getIdEquipeTp() {
        return idEquipeTp;
    }

    public void setIdEquipeTp(Long idEquipeTp) {
        this.idEquipeTp = idEquipeTp;
    }

    public String getEquipeTp() {
        return equipeTp;
    }

    public void setEquipeTp(String equipeTp) {
        this.equipeTp = equipeTp;
    }

    public Long getIdEquipeSit() {
        return idEquipeSit;
    }

    public void setIdEquipeSit(Long idEquipeSit) {
        this.idEquipeSit = idEquipeSit;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCkImei() {
        return ckImei;
    }

    public void setCkImei(String ckImei) {
        this.ckImei = ckImei;
    }

    public String getDtSituacao() {
        return dtSituacao;
    }

    public void setDtSituacao(String dtSituacao) {
        this.dtSituacao = dtSituacao;
    }

    public String getDtInsert() {
        return dtInsert;
    }

    public void setDtInsert(String dtInsert) {
        this.dtInsert = dtInsert;
    }
    
    public static void main(String[] args) {
		
    	try {
		
    		try {
    			
    			Long a = Long.parseLong("W");
			}
    		catch (Exception e) {
    			System.out.println("caiu primeiro catch");
    		}
    		finally {
    			System.out.println("caiu primeiro finally");
			}
		} 
    	catch (Exception e) {

    		System.out.println("caiu segundo catch");
		}
    	finally {
    		
    		System.out.println("caiu segundo finally");
		}
	}
}
