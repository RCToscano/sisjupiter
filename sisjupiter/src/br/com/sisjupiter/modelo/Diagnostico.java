package br.com.sisjupiter.modelo;

import java.math.BigDecimal;

public class Diagnostico {
	
	private Long idDiagnostico;
	private String data;
	private String dtInsert;
	private Long idComunidade;
	private Long idEquipe;
	private Long idUser;
	private String coordY;
	private String coordX;
	private Integer codServ;
	private Integer idSitImovel;
	private Integer idTpConstr;
	private Integer idTpInstal;
	private Integer categoria1;
	private Integer categoria2;
	private Integer categoria3;
	private Integer categoria4;
	private Integer idTpUso;
	private Integer qtdeCasas;
	private Integer tempoOcup;
	private String atividade;
	private Integer energEletr;
	private Integer energEletrIrreg;
	private String instalacao;
	private String medidor;
	private Integer pavimeExiste;
	private Integer colLixoExiste;
	private Integer idAbastAgua;
	private Integer abastAguaIrreg;
	private String hidrometro;
	private Integer idDestEsgoto;
	private String nome;
	private String cpf;
	private String rg;
	private Integer nacionalidade;
	private String ufNasc;
	private String munNasc;
	private String dtNasc;
	private String sexo;
	private Integer telRes;
	private Integer telCel;
	private Integer idEstadoCivil;
	private String email;
	private String endereco;
	private Integer numAtual;
	private Integer numAntigo;
	private String compl;
	private String bairro;
	private String mun;
	private String uf;
	private String cep;
	private Integer qtdeAdulto;
	private Integer qtdeCrianca;
	private Integer possuiConta;
	private String banco;
	private Integer possuiCDeb;
	private BigDecimal rendaTotal;
	private Integer rendaPerceUtil;
	private Integer meioTransp1;
	private Integer meioTransp2;
	private Integer meioTransp3;
	private Integer meioTransp4;
	private Integer meioTransp5;
	private Integer internetAcess;
	private Integer internetWifi;
	private Integer internet3g;
	private Integer qtdeCarro;
	private Integer qtdeMoto;
	private Integer qtdeBicicleta;
	private String benefBCPNum;
	private String benefNISNum;
	private Integer possuiTarSocial;
	private Integer possuiBolsaFamil;
	private Integer benefEntrev;
	private String benefNome;
	private String benefCpf;
	private String benefRg;
	private String benefSexo;
	private String benefDtNasc;
	private String benefObs;
	private Integer maior59Qtde;
	private Integer menor19Qtde;
	private Integer menor1Qtde;
	private Integer defVisualQtde;
	private Integer defAuditQtde;
	private Integer defFisQtde;
	private Integer defIntelecQtde;
	private Integer defOutrosQtde;
	private Integer tratCancer;
	private Integer tratTuber;
	private Integer tratHansen;
	private Integer tratMental;
	private Integer tratEscler;
	private Integer tratParal;
	private Integer tratHepat;
	private Integer tratCardiac;
	private Integer tratParkins;
	private Integer tratRenal;
	private Integer tratOutro;
	private String tratOutroDesc;
	private Integer amebiase;
	private String amebiaseMemb;
	private Integer gastroent;
	private String gastroentMemb;
	private Integer giardiase;
	private String giardiaseMemb;
	private Integer febreTifo;
	private String febreTifoMemb;
	private Integer hepatite;
	private String hepatiteMemb;
	private Integer colera;
	private String coleraMemb;
	private Integer esquitosso;
	private String esquitossoMemb;
	private Integer ascaridiase;
	private String ascaridiaseMemb;
	private Integer teniase;
	private String teniaseMemb;
	private Integer leptospirose;
	private String leptospiroseMemb;
	private Integer malaria;
	private String malariaMemb;
	private Integer dengue;
	private String dengueMemb;
	private Integer febreAmar;
	private String febreAmarMemb;
	private Integer chikung;
	private String chikungMemb;
	private Integer zicaVirus;
	private String zicaVirusMemb;
	private Integer cianobacter;
	private String cianobacterMemb;
	private BigDecimal valDoacao;
	private BigDecimal valAposent;
	private BigDecimal valPensaoAlimen;
	private BigDecimal valSegDesempr;
	private BigDecimal valEmprInformal;
	private BigDecimal valEmprFormal;
	private BigDecimal valBolsaFamil;
	private BigDecimal valOutro;
	private String valOutroDescr;
	private Integer idGrauEscol;
	private Integer grauEscolCompl;
	private Integer sabeEscrever;
	private Integer sabeLer;
	private Integer ensinoFunMembro;
	private Integer ensinoMedMembro;
	private Integer ensinoSupMembro;
	private Integer ensinoPosMembro;
	private Integer ensinoCurMembro;
	private Integer analfabMembro;
	private String profissRespFamil;
	private Integer energNegoc;
	private BigDecimal energNegocParcVal;
	private Integer energNegocParcQtde;
	private Integer energNegocDia;
	private Integer aguaNegoc;
	private BigDecimal aguaNegocParcVal;
	private Integer aguaNegocParcQtde;
	private Integer aguaNegocDia;
	private String obraSaneamConhe;
	private Integer benefObraSanSaude;
	private Integer benefObraSanEco;
	private Integer benefObraSanImob;
	private Integer benefObraSanTuri;
	private String obsGerais;
	
	
	
	public Long getIdDiagnostico() {
		return idDiagnostico;
	}
	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDtInsert() {
		return dtInsert;
	}
	public void setDtInsert(String dtInsert) {
		this.dtInsert = dtInsert;
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
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getCoordY() {
		return coordY;
	}
	public void setCoordY(String coordY) {
		this.coordY = coordY;
	}
	public String getCoordX() {
		return coordX;
	}
	public void setCoordX(String coordX) {
		this.coordX = coordX;
	}
	public Integer getCodServ() {
		return codServ;
	}
	public void setCodServ(Integer codServ) {
		this.codServ = codServ;
	}
	public Integer getIdSitImovel() {
		return idSitImovel;
	}
	public void setIdSitImovel(Integer idSitImovel) {
		this.idSitImovel = idSitImovel;
	}
	public Integer getIdTpConstr() {
		return idTpConstr;
	}
	public void setIdTpConstr(Integer idTpConstr) {
		this.idTpConstr = idTpConstr;
	}
	public Integer getIdTpInstal() {
		return idTpInstal;
	}
	public void setIdTpInstal(Integer idTpInstal) {
		this.idTpInstal = idTpInstal;
	}
	public Integer getCategoria1() {
		return categoria1;
	}
	public void setCategoria1(Integer categoria1) {
		this.categoria1 = categoria1;
	}
	public Integer getCategoria2() {
		return categoria2;
	}
	public void setCategoria2(Integer categoria2) {
		this.categoria2 = categoria2;
	}
	public Integer getCategoria3() {
		return categoria3;
	}
	public void setCategoria3(Integer categoria3) {
		this.categoria3 = categoria3;
	}
	public Integer getCategoria4() {
		return categoria4;
	}
	public void setCategoria4(Integer categoria4) {
		this.categoria4 = categoria4;
	}
	public Integer getIdTpUso() {
		return idTpUso;
	}
	public void setIdTpUso(Integer idTpUso) {
		this.idTpUso = idTpUso;
	}
	public Integer getQtdeCasas() {
		return qtdeCasas;
	}
	public void setQtdeCasas(Integer qtdeCasas) {
		this.qtdeCasas = qtdeCasas;
	}
	public Integer getTempoOcup() {
		return tempoOcup;
	}
	public void setTempoOcup(Integer tempoOcup) {
		this.tempoOcup = tempoOcup;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public Integer getEnergEletr() {
		return energEletr;
	}
	public void setEnergEletr(Integer energEletr) {
		this.energEletr = energEletr;
	}
	public Integer getEnergEletrIrreg() {
		return energEletrIrreg;
	}
	public void setEnergEletrIrreg(Integer energEletrIrreg) {
		this.energEletrIrreg = energEletrIrreg;
	}
	public String getInstalacao() {
		return instalacao;
	}
	public void setInstalacao(String instalacao) {
		this.instalacao = instalacao;
	}
	public String getMedidor() {
		return medidor;
	}
	public void setMedidor(String medidor) {
		this.medidor = medidor;
	}
	public Integer getPavimeExiste() {
		return pavimeExiste;
	}
	public void setPavimeExiste(Integer pavimeExiste) {
		this.pavimeExiste = pavimeExiste;
	}
	public Integer getColLixoExiste() {
		return colLixoExiste;
	}
	public void setColLixoExiste(Integer colLixoExiste) {
		this.colLixoExiste = colLixoExiste;
	}
	public Integer getIdAbastAgua() {
		return idAbastAgua;
	}
	public void setIdAbastAgua(Integer idAbastAgua) {
		this.idAbastAgua = idAbastAgua;
	}
	public Integer getAbastAguaIrreg() {
		return abastAguaIrreg;
	}
	public void setAbastAguaIrreg(Integer abastAguaIrreg) {
		this.abastAguaIrreg = abastAguaIrreg;
	}
	public String getHidrometro() {
		return hidrometro;
	}
	public void setHidrometro(String hidrometro) {
		this.hidrometro = hidrometro;
	}
	public Integer getIdDestEsgoto() {
		return idDestEsgoto;
	}
	public void setIdDestEsgoto(Integer idDestEsgoto) {
		this.idDestEsgoto = idDestEsgoto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Integer getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(Integer nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getUfNasc() {
		return ufNasc;
	}
	public void setUfNasc(String ufNasc) {
		this.ufNasc = ufNasc;
	}
	public String getMunNasc() {
		return munNasc;
	}
	public void setMunNasc(String munNasc) {
		this.munNasc = munNasc;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getTelRes() {
		return telRes;
	}
	public void setTelRes(Integer telRes) {
		this.telRes = telRes;
	}
	public Integer getTelCel() {
		return telCel;
	}
	public void setTelCel(Integer telCel) {
		this.telCel = telCel;
	}
	public Integer getIdEstadoCivil() {
		return idEstadoCivil;
	}
	public void setIdEstadoCivil(Integer idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumAtual() {
		return numAtual;
	}
	public void setNumAtual(Integer numAtual) {
		this.numAtual = numAtual;
	}
	public Integer getNumAntigo() {
		return numAntigo;
	}
	public void setNumAntigo(Integer numAntigo) {
		this.numAntigo = numAntigo;
	}
	public String getCompl() {
		return compl;
	}
	public void setCompl(String compl) {
		this.compl = compl;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getMun() {
		return mun;
	}
	public void setMun(String mun) {
		this.mun = mun;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getQtdeAdulto() {
		return qtdeAdulto;
	}
	public void setQtdeAdulto(Integer qtdeAdulto) {
		this.qtdeAdulto = qtdeAdulto;
	}
	public Integer getQtdeCrianca() {
		return qtdeCrianca;
	}
	public void setQtdeCrianca(Integer qtdeCrianca) {
		this.qtdeCrianca = qtdeCrianca;
	}
	public Integer getPossuiConta() {
		return possuiConta;
	}
	public void setPossuiConta(Integer possuiConta) {
		this.possuiConta = possuiConta;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public Integer getPossuiCDeb() {
		return possuiCDeb;
	}
	public void setPossuiCDeb(Integer possuiCDeb) {
		this.possuiCDeb = possuiCDeb;
	}
	public BigDecimal getRendaTotal() {
		return rendaTotal;
	}
	public void setRendaTotal(BigDecimal rendaTotal) {
		this.rendaTotal = rendaTotal;
	}
	public Integer getRendaPerceUtil() {
		return rendaPerceUtil;
	}
	public void setRendaPerceUtil(Integer rendaPerceUtil) {
		this.rendaPerceUtil = rendaPerceUtil;
	}
	public Integer getMeioTransp1() {
		return meioTransp1;
	}
	public void setMeioTransp1(Integer meioTransp1) {
		this.meioTransp1 = meioTransp1;
	}
	public Integer getMeioTransp2() {
		return meioTransp2;
	}
	public void setMeioTransp2(Integer meioTransp2) {
		this.meioTransp2 = meioTransp2;
	}
	public Integer getMeioTransp3() {
		return meioTransp3;
	}
	public void setMeioTransp3(Integer meioTransp3) {
		this.meioTransp3 = meioTransp3;
	}
	public Integer getMeioTransp4() {
		return meioTransp4;
	}
	public void setMeioTransp4(Integer meioTransp4) {
		this.meioTransp4 = meioTransp4;
	}
	public Integer getMeioTransp5() {
		return meioTransp5;
	}
	public void setMeioTransp5(Integer meioTransp5) {
		this.meioTransp5 = meioTransp5;
	}
	public Integer getInternetAcess() {
		return internetAcess;
	}
	public void setInternetAcess(Integer internetAcess) {
		this.internetAcess = internetAcess;
	}
	public Integer getInternetWifi() {
		return internetWifi;
	}
	public void setInternetWifi(Integer internetWifi) {
		this.internetWifi = internetWifi;
	}
	public Integer getInternet3g() {
		return internet3g;
	}
	public void setInternet3g(Integer internet3g) {
		this.internet3g = internet3g;
	}
	public Integer getQtdeCarro() {
		return qtdeCarro;
	}
	public void setQtdeCarro(Integer qtdeCarro) {
		this.qtdeCarro = qtdeCarro;
	}
	public Integer getQtdeMoto() {
		return qtdeMoto;
	}
	public void setQtdeMoto(Integer qtdeMoto) {
		this.qtdeMoto = qtdeMoto;
	}
	public Integer getQtdeBicicleta() {
		return qtdeBicicleta;
	}
	public void setQtdeBicicleta(Integer qtdeBicicleta) {
		this.qtdeBicicleta = qtdeBicicleta;
	}
	public String getBenefBCPNum() {
		return benefBCPNum;
	}
	public void setBenefBCPNum(String benefBCPNum) {
		this.benefBCPNum = benefBCPNum;
	}
	public String getBenefNISNum() {
		return benefNISNum;
	}
	public void setBenefNISNum(String benefNISNum) {
		this.benefNISNum = benefNISNum;
	}
	public Integer getPossuiTarSocial() {
		return possuiTarSocial;
	}
	public void setPossuiTarSocial(Integer possuiTarSocial) {
		this.possuiTarSocial = possuiTarSocial;
	}
	public Integer getPossuiBolsaFamil() {
		return possuiBolsaFamil;
	}
	public void setPossuiBolsaFamil(Integer possuiBolsaFamil) {
		this.possuiBolsaFamil = possuiBolsaFamil;
	}
	public Integer getBenefEntrev() {
		return benefEntrev;
	}
	public void setBenefEntrev(Integer benefEntrev) {
		this.benefEntrev = benefEntrev;
	}
	public String getBenefNome() {
		return benefNome;
	}
	public void setBenefNome(String benefNome) {
		this.benefNome = benefNome;
	}
	public String getBenefCpf() {
		return benefCpf;
	}
	public void setBenefCpf(String benefCpf) {
		this.benefCpf = benefCpf;
	}
	public String getBenefRg() {
		return benefRg;
	}
	public void setBenefRg(String benefRg) {
		this.benefRg = benefRg;
	}
	public String getBenefSexo() {
		return benefSexo;
	}
	public void setBenefSexo(String benefSexo) {
		this.benefSexo = benefSexo;
	}
	public String getBenefDtNasc() {
		return benefDtNasc;
	}
	public void setBenefDtNasc(String benefDtNasc) {
		this.benefDtNasc = benefDtNasc;
	}
	public String getBenefObs() {
		return benefObs;
	}
	public void setBenefObs(String benefObs) {
		this.benefObs = benefObs;
	}
	public Integer getMaior59Qtde() {
		return maior59Qtde;
	}
	public void setMaior59Qtde(Integer maior59Qtde) {
		this.maior59Qtde = maior59Qtde;
	}
	public Integer getMenor19Qtde() {
		return menor19Qtde;
	}
	public void setMenor19Qtde(Integer menor19Qtde) {
		this.menor19Qtde = menor19Qtde;
	}
	public Integer getMenor1Qtde() {
		return menor1Qtde;
	}
	public void setMenor1Qtde(Integer menor1Qtde) {
		this.menor1Qtde = menor1Qtde;
	}
	public Integer getDefVisualQtde() {
		return defVisualQtde;
	}
	public void setDefVisualQtde(Integer defVisualQtde) {
		this.defVisualQtde = defVisualQtde;
	}
	public Integer getDefAuditQtde() {
		return defAuditQtde;
	}
	public void setDefAuditQtde(Integer defAuditQtde) {
		this.defAuditQtde = defAuditQtde;
	}
	public Integer getDefFisQtde() {
		return defFisQtde;
	}
	public void setDefFisQtde(Integer defFisQtde) {
		this.defFisQtde = defFisQtde;
	}
	public Integer getDefIntegerelecQtde() {
		return defIntelecQtde;
	}
	public void setDefIntelecQtde(Integer defIntelecQtde) {
		this.defIntelecQtde = defIntelecQtde;
	}
	public Integer getDefOutrosQtde() {
		return defOutrosQtde;
	}
	public void setDefOutrosQtde(Integer defOutrosQtde) {
		this.defOutrosQtde = defOutrosQtde;
	}
	public Integer getTratCancer() {
		return tratCancer;
	}
	public void setTratCancer(Integer tratCancer) {
		this.tratCancer = tratCancer;
	}
	public Integer getTratTuber() {
		return tratTuber;
	}
	public void setTratTuber(Integer tratTuber) {
		this.tratTuber = tratTuber;
	}
	public Integer getTratHansen() {
		return tratHansen;
	}
	public void setTratHansen(Integer tratHansen) {
		this.tratHansen = tratHansen;
	}
	public Integer getTratMental() {
		return tratMental;
	}
	public void setTratMental(Integer tratMental) {
		this.tratMental = tratMental;
	}
	public Integer getTratEscler() {
		return tratEscler;
	}
	public void setTratEscler(Integer tratEscler) {
		this.tratEscler = tratEscler;
	}
	public Integer getTratParal() {
		return tratParal;
	}
	public void setTratParal(Integer tratParal) {
		this.tratParal = tratParal;
	}
	public Integer getTratHepat() {
		return tratHepat;
	}
	public void setTratHepat(Integer tratHepat) {
		this.tratHepat = tratHepat;
	}
	public Integer getTratCardiac() {
		return tratCardiac;
	}
	public void setTratCardiac(Integer tratCardiac) {
		this.tratCardiac = tratCardiac;
	}
	public Integer getTratParkins() {
		return tratParkins;
	}
	public void setTratParkins(Integer tratParkins) {
		this.tratParkins = tratParkins;
	}
	public Integer getTratRenal() {
		return tratRenal;
	}
	public void setTratRenal(Integer tratRenal) {
		this.tratRenal = tratRenal;
	}
	public Integer getTratOutro() {
		return tratOutro;
	}
	public void setTratOutro(Integer tratOutro) {
		this.tratOutro = tratOutro;
	}
	public String getTratOutroDesc() {
		return tratOutroDesc;
	}
	public void setTratOutroDesc(String tratOutroDesc) {
		this.tratOutroDesc = tratOutroDesc;
	}
	public Integer getAmebiase() {
		return amebiase;
	}
	public void setAmebiase(Integer amebiase) {
		this.amebiase = amebiase;
	}
	public String getAmebiaseMemb() {
		return amebiaseMemb;
	}
	public void setAmebiaseMemb(String amebiaseMemb) {
		this.amebiaseMemb = amebiaseMemb;
	}
	public Integer getGastroent() {
		return gastroent;
	}
	public void setGastroent(Integer gastroent) {
		this.gastroent = gastroent;
	}
	public String getGastroentMemb() {
		return gastroentMemb;
	}
	public void setGastroentMemb(String gastroentMemb) {
		this.gastroentMemb = gastroentMemb;
	}
	public Integer getGiardiase() {
		return giardiase;
	}
	public void setGiardiase(Integer giardiase) {
		this.giardiase = giardiase;
	}
	public String getGiardiaseMemb() {
		return giardiaseMemb;
	}
	public void setGiardiaseMemb(String giardiaseMemb) {
		this.giardiaseMemb = giardiaseMemb;
	}
	public Integer getFebreTifo() {
		return febreTifo;
	}
	public void setFebreTifo(Integer febreTifo) {
		this.febreTifo = febreTifo;
	}
	public String getFebreTifoMemb() {
		return febreTifoMemb;
	}
	public void setFebreTifoMemb(String febreTifoMemb) {
		this.febreTifoMemb = febreTifoMemb;
	}
	public Integer getHepatite() {
		return hepatite;
	}
	public void setHepatite(Integer hepatite) {
		this.hepatite = hepatite;
	}
	public String getHepatiteMemb() {
		return hepatiteMemb;
	}
	public void setHepatiteMemb(String hepatiteMemb) {
		this.hepatiteMemb = hepatiteMemb;
	}
	public Integer getColera() {
		return colera;
	}
	public void setColera(Integer colera) {
		this.colera = colera;
	}
	public String getColeraMemb() {
		return coleraMemb;
	}
	public void setColeraMemb(String coleraMemb) {
		this.coleraMemb = coleraMemb;
	}
	public Integer getEsquitosso() {
		return esquitosso;
	}
	public void setEsquitosso(Integer esquitosso) {
		this.esquitosso = esquitosso;
	}
	public String getEsquitossoMemb() {
		return esquitossoMemb;
	}
	public void setEsquitossoMemb(String esquitossoMemb) {
		this.esquitossoMemb = esquitossoMemb;
	}
	public Integer getAscaridiase() {
		return ascaridiase;
	}
	public void setAscaridiase(Integer ascaridiase) {
		this.ascaridiase = ascaridiase;
	}
	public String getAscaridiaseMemb() {
		return ascaridiaseMemb;
	}
	public void setAscaridiaseMemb(String ascaridiaseMemb) {
		this.ascaridiaseMemb = ascaridiaseMemb;
	}
	public Integer getTeniase() {
		return teniase;
	}
	public void setTeniase(Integer teniase) {
		this.teniase = teniase;
	}
	public String getTeniaseMemb() {
		return teniaseMemb;
	}
	public void setTeniaseMemb(String teniaseMemb) {
		this.teniaseMemb = teniaseMemb;
	}
	public Integer getLeptospirose() {
		return leptospirose;
	}
	public void setLeptospirose(Integer leptospirose) {
		this.leptospirose = leptospirose;
	}
	public String getLeptospiroseMemb() {
		return leptospiroseMemb;
	}
	public void setLeptospiroseMemb(String leptospiroseMemb) {
		this.leptospiroseMemb = leptospiroseMemb;
	}
	public Integer getMalaria() {
		return malaria;
	}
	public void setMalaria(Integer malaria) {
		this.malaria = malaria;
	}
	public String getMalariaMemb() {
		return malariaMemb;
	}
	public void setMalariaMemb(String malariaMemb) {
		this.malariaMemb = malariaMemb;
	}
	public Integer getDengue() {
		return dengue;
	}
	public void setDengue(Integer dengue) {
		this.dengue = dengue;
	}
	public String getDengueMemb() {
		return dengueMemb;
	}
	public void setDengueMemb(String dengueMemb) {
		this.dengueMemb = dengueMemb;
	}
	public Integer getFebreAmar() {
		return febreAmar;
	}
	public void setFebreAmar(Integer febreAmar) {
		this.febreAmar = febreAmar;
	}
	public String getFebreAmarMemb() {
		return febreAmarMemb;
	}
	public void setFebreAmarMemb(String febreAmarMemb) {
		this.febreAmarMemb = febreAmarMemb;
	}
	public Integer getChikung() {
		return chikung;
	}
	public void setChikung(Integer chikung) {
		this.chikung = chikung;
	}
	public String getChikungMemb() {
		return chikungMemb;
	}
	public void setChikungMemb(String chikungMemb) {
		this.chikungMemb = chikungMemb;
	}
	public Integer getZicaVirus() {
		return zicaVirus;
	}
	public void setZicaVirus(Integer zicaVirus) {
		this.zicaVirus = zicaVirus;
	}
	public String getZicaVirusMemb() {
		return zicaVirusMemb;
	}
	public void setZicaVirusMemb(String zicaVirusMemb) {
		this.zicaVirusMemb = zicaVirusMemb;
	}
	public Integer getCianobacter() {
		return cianobacter;
	}
	public void setCianobacter(Integer cianobacter) {
		this.cianobacter = cianobacter;
	}
	public String getCianobacterMemb() {
		return cianobacterMemb;
	}
	public void setCianobacterMemb(String cianobacterMemb) {
		this.cianobacterMemb = cianobacterMemb;
	}
	public BigDecimal getValDoacao() {
		return valDoacao;
	}
	public void setValDoacao(BigDecimal valDoacao) {
		this.valDoacao = valDoacao;
	}
	public BigDecimal getValAposent() {
		return valAposent;
	}
	public void setValAposent(BigDecimal valAposent) {
		this.valAposent = valAposent;
	}
	public BigDecimal getValPensaoAlimen() {
		return valPensaoAlimen;
	}
	public void setValPensaoAlimen(BigDecimal valPensaoAlimen) {
		this.valPensaoAlimen = valPensaoAlimen;
	}
	public BigDecimal getValSegDesempr() {
		return valSegDesempr;
	}
	public void setValSegDesempr(BigDecimal valSegDesempr) {
		this.valSegDesempr = valSegDesempr;
	}
	public BigDecimal getValEmprInformal() {
		return valEmprInformal;
	}
	public void setValEmprInformal(BigDecimal valEmprInformal) {
		this.valEmprInformal = valEmprInformal;
	}
	public BigDecimal getValEmprFormal() {
		return valEmprFormal;
	}
	public void setValEmprFormal(BigDecimal valEmprFormal) {
		this.valEmprFormal = valEmprFormal;
	}
	public BigDecimal getValBolsaFamil() {
		return valBolsaFamil;
	}
	public void setValBolsaFamil(BigDecimal valBolsaFamil) {
		this.valBolsaFamil = valBolsaFamil;
	}
	public BigDecimal getValOutro() {
		return valOutro;
	}
	public void setValOutro(BigDecimal valOutro) {
		this.valOutro = valOutro;
	}
	public String getValOutroDescr() {
		return valOutroDescr;
	}
	public void setValOutroDescr(String valOutroDescr) {
		this.valOutroDescr = valOutroDescr;
	}
	public Integer getIdGrauEscol() {
		return idGrauEscol;
	}
	public void setIdGrauEscol(Integer idGrauEscol) {
		this.idGrauEscol = idGrauEscol;
	}
	public Integer getGrauEscolCompl() {
		return grauEscolCompl;
	}
	public void setGrauEscolCompl(Integer grauEscolCompl) {
		this.grauEscolCompl = grauEscolCompl;
	}
	public Integer getSabeEscrever() {
		return sabeEscrever;
	}
	public void setSabeEscrever(Integer sabeEscrever) {
		this.sabeEscrever = sabeEscrever;
	}
	public Integer getSabeLer() {
		return sabeLer;
	}
	public void setSabeLer(Integer sabeLer) {
		this.sabeLer = sabeLer;
	}
	public Integer getEnsinoFunMembro() {
		return ensinoFunMembro;
	}
	public void setEnsinoFunMembro(Integer ensinoFunMembro) {
		this.ensinoFunMembro = ensinoFunMembro;
	}
	public Integer getEnsinoMedMembro() {
		return ensinoMedMembro;
	}
	public void setEnsinoMedMembro(Integer ensinoMedMembro) {
		this.ensinoMedMembro = ensinoMedMembro;
	}
	public Integer getEnsinoSupMembro() {
		return ensinoSupMembro;
	}
	public void setEnsinoSupMembro(Integer ensinoSupMembro) {
		this.ensinoSupMembro = ensinoSupMembro;
	}
	public Integer getEnsinoPosMembro() {
		return ensinoPosMembro;
	}
	public void setEnsinoPosMembro(Integer ensinoPosMembro) {
		this.ensinoPosMembro = ensinoPosMembro;
	}
	public Integer getEnsinoCurMembro() {
		return ensinoCurMembro;
	}
	public void setEnsinoCurMembro(Integer ensinoCurMembro) {
		this.ensinoCurMembro = ensinoCurMembro;
	}
	public Integer getAnalfabMembro() {
		return analfabMembro;
	}
	public void setAnalfabMembro(Integer analfabMembro) {
		this.analfabMembro = analfabMembro;
	}
	public String getProfissRespFamil() {
		return profissRespFamil;
	}
	public void setProfissRespFamil(String profissRespFamil) {
		this.profissRespFamil = profissRespFamil;
	}
	public Integer getEnergNegoc() {
		return energNegoc;
	}
	public void setEnergNegoc(Integer energNegoc) {
		this.energNegoc = energNegoc;
	}
	public BigDecimal getEnergNegocParcVal() {
		return energNegocParcVal;
	}
	public void setEnergNegocParcVal(BigDecimal energNegocParcVal) {
		this.energNegocParcVal = energNegocParcVal;
	}
	public Integer getEnergNegocParcQtde() {
		return energNegocParcQtde;
	}
	public void setEnergNegocParcQtde(Integer energNegocParcQtde) {
		this.energNegocParcQtde = energNegocParcQtde;
	}
	public Integer getEnergNegocDia() {
		return energNegocDia;
	}
	public void setEnergNegocDia(Integer energNegocDia) {
		this.energNegocDia = energNegocDia;
	}
	public Integer getAguaNegoc() {
		return aguaNegoc;
	}
	public void setAguaNegoc(Integer aguaNegoc) {
		this.aguaNegoc = aguaNegoc;
	}
	public BigDecimal getAguaNegocParcVal() {
		return aguaNegocParcVal;
	}
	public void setAguaNegocParcVal(BigDecimal aguaNegocParcVal) {
		this.aguaNegocParcVal = aguaNegocParcVal;
	}
	public Integer getAguaNegocParcQtde() {
		return aguaNegocParcQtde;
	}
	public void setAguaNegocParcQtde(Integer aguaNegocParcQtde) {
		this.aguaNegocParcQtde = aguaNegocParcQtde;
	}
	public Integer getAguaNegocDia() {
		return aguaNegocDia;
	}
	public void setAguaNegocDia(Integer aguaNegocDia) {
		this.aguaNegocDia = aguaNegocDia;
	}
	public String getObraSaneamConhe() {
		return obraSaneamConhe;
	}
	public void setObraSaneamConhe(String obraSaneamConhe) {
		this.obraSaneamConhe = obraSaneamConhe;
	}
	public Integer getBenefObraSanSaude() {
		return benefObraSanSaude;
	}
	public void setBenefObraSanSaude(Integer benefObraSanSaude) {
		this.benefObraSanSaude = benefObraSanSaude;
	}
	public Integer getBenefObraSanEco() {
		return benefObraSanEco;
	}
	public void setBenefObraSanEco(Integer benefObraSanEco) {
		this.benefObraSanEco = benefObraSanEco;
	}
	public Integer getBenefObraSanImob() {
		return benefObraSanImob;
	}
	public void setBenefObraSanImob(Integer benefObraSanImob) {
		this.benefObraSanImob = benefObraSanImob;
	}
	public Integer getBenefObraSanTuri() {
		return benefObraSanTuri;
	}
	public void setBenefObraSanTuri(Integer benefObraSanTuri) {
		this.benefObraSanTuri = benefObraSanTuri;
	}
	public String getObsGerais() {
		return obsGerais;
	}
	public void setObsGerais(String obsGerais) {
		this.obsGerais = obsGerais;
	}
	
}
