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
	private int codServ;
	private int idSitImovel;
	private int idTpConstr;
	private int idTpInstal;
	private int categoria1;
	private int categoria2;
	private int categoria3;
	private int categoria4;
	private int idTpUso;
	private int qtdeCasas;
	private int tempoOcup;
	private String atividade;
	private int energEletr;
	private int energEletrIrreg;
	private String instalacao;
	private String medidor;
	private int pavimeExiste;
	private int colLixoExiste;
	private int idAbastAgua;
	private int abastAguaIrreg;
	private String hidrometro;
	private int idDestEsgoto;
	private String nome;
	private String cpf;
	private String rg;
	private int nacionalidade;
	private String ufNasc;
	private String munNasc;
	private String dtNasc;
	private String sexo;
	private int telRes;
	private int telCel;
	private int idEstadoCivil;
	private String email;
	private String endereco;
	private int numAtual;
	private int numAntigo;
	private String compl;
	private String bairro;
	private String mun;
	private String uf;
	private String cep;
	private int qtdeAdulto;
	private int qtdeCrianca;
	private int possuiConta;
	private String banco;
	private int possuiCDeb;
	private BigDecimal rendaTotal;
	private int rendaPerceUtil;
	private int meioTransp1;
	private int meioTransp2;
	private int meioTransp3;
	private int meioTransp4;
	private int meioTransp5;
	private int internetAcess;
	private int internetWifi;
	private int internet3g;
	private int qtdeCarro;
	private int qtdeMoto;
	private int qtdeBicicleta;
	private String benefBCPNum;
	private String benefNISNum;
	private int possuiTarSocial;
	private int possuiBolsaFamil;
	private int benefEntrev;
	private String benefNome;
	private String benefCpf;
	private String benefRg;
	private String benefSexo;
	private String benefDtNasc;
	private String benefObs;
	private int maior59Qtde;
	private int menor19Qtde;
	private int menor1Qtde;
	private int defVisualQtde;
	private int defAuditQtde;
	private int defFisQtde;
	private int defIntelecQtde;
	private int defOutrosQtde;
	private int tratCancer;
	private int tratTuber;
	private int tratHansen;
	private int tratMental;
	private int tratEscler;
	private int tratParal;
	private int tratHepat;
	private int tratCardiac;
	private int tratParkins;
	private int tratRenal;
	private int tratOutro;
	private String tratOutroDesc;
	private int amebiase;
	private String amebiaseMemb;
	private int gastroent;
	private String gastroentMemb;
	private int giardiase;
	private String giardiaseMemb;
	private int febreTifo;
	private String febreTifoMemb;
	private int hepatite;
	private String hepatiteMemb;
	private int colera;
	private String coleraMemb;
	private int esquitosso;
	private String esquitossoMemb;
	private int ascaridiase;
	private String ascaridiaseMemb;
	private int teniase;
	private String teniaseMemb;
	private int leptospirose;
	private String leptospiroseMemb;
	private int malaria;
	private String malariaMemb;
	private int dengue;
	private String dengueMemb;
	private int febreAmar;
	private String febreAmarMemb;
	private int chikung;
	private String chikungMemb;
	private int zicaVirus;
	private String zicaVirusMemb;
	private int cianobacter;
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
	private int idGrauEscol;
	private int grauEscolCompl;
	private int sabeEscrever;
	private int sabeLer;
	private int ensinoFunMembro;
	private int ensinoMedMembro;
	private int ensinoSupMembro;
	private int ensinoPosMembro;
	private int ensinoCurMembro;
	private int analfabMembro;
	private String profissRespFamil;
	private int energNegoc;
	private BigDecimal energNegocParcVal;
	private int energNegocParcQtde;
	private int energNegocDia;
	private int aguaNegoc;
	private BigDecimal aguaNegocParcVal;
	private int aguaNegocParcQtde;
	private int aguaNegocDia;
	private String obraSaneamConhe;
	private int benefObraSanSaude;
	private int benefObraSanEco;
	private int benefObraSanImob;
	private int benefObraSanTuri;
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
	public int getCodServ() {
		return codServ;
	}
	public void setCodServ(int codServ) {
		this.codServ = codServ;
	}
	public int getIdSitImovel() {
		return idSitImovel;
	}
	public void setIdSitImovel(int idSitImovel) {
		this.idSitImovel = idSitImovel;
	}
	public int getIdTpConstr() {
		return idTpConstr;
	}
	public void setIdTpConstr(int idTpConstr) {
		this.idTpConstr = idTpConstr;
	}
	public int getIdTpInstal() {
		return idTpInstal;
	}
	public void setIdTpInstal(int idTpInstal) {
		this.idTpInstal = idTpInstal;
	}
	public int getCategoria1() {
		return categoria1;
	}
	public void setCategoria1(int categoria1) {
		this.categoria1 = categoria1;
	}
	public int getCategoria2() {
		return categoria2;
	}
	public void setCategoria2(int categoria2) {
		this.categoria2 = categoria2;
	}
	public int getCategoria3() {
		return categoria3;
	}
	public void setCategoria3(int categoria3) {
		this.categoria3 = categoria3;
	}
	public int getCategoria4() {
		return categoria4;
	}
	public void setCategoria4(int categoria4) {
		this.categoria4 = categoria4;
	}
	public int getIdTpUso() {
		return idTpUso;
	}
	public void setIdTpUso(int idTpUso) {
		this.idTpUso = idTpUso;
	}
	public int getQtdeCasas() {
		return qtdeCasas;
	}
	public void setQtdeCasas(int qtdeCasas) {
		this.qtdeCasas = qtdeCasas;
	}
	public int getTempoOcup() {
		return tempoOcup;
	}
	public void setTempoOcup(int tempoOcup) {
		this.tempoOcup = tempoOcup;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public int getEnergEletr() {
		return energEletr;
	}
	public void setEnergEletr(int energEletr) {
		this.energEletr = energEletr;
	}
	public int getEnergEletrIrreg() {
		return energEletrIrreg;
	}
	public void setEnergEletrIrreg(int energEletrIrreg) {
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
	public int getPavimeExiste() {
		return pavimeExiste;
	}
	public void setPavimeExiste(int pavimeExiste) {
		this.pavimeExiste = pavimeExiste;
	}
	public int getColLixoExiste() {
		return colLixoExiste;
	}
	public void setColLixoExiste(int colLixoExiste) {
		this.colLixoExiste = colLixoExiste;
	}
	public int getIdAbastAgua() {
		return idAbastAgua;
	}
	public void setIdAbastAgua(int idAbastAgua) {
		this.idAbastAgua = idAbastAgua;
	}
	public int getAbastAguaIrreg() {
		return abastAguaIrreg;
	}
	public void setAbastAguaIrreg(int abastAguaIrreg) {
		this.abastAguaIrreg = abastAguaIrreg;
	}
	public String getHidrometro() {
		return hidrometro;
	}
	public void setHidrometro(String hidrometro) {
		this.hidrometro = hidrometro;
	}
	public int getIdDestEsgoto() {
		return idDestEsgoto;
	}
	public void setIdDestEsgoto(int idDestEsgoto) {
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
	public int getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(int nacionalidade) {
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
	public int getTelRes() {
		return telRes;
	}
	public void setTelRes(int telRes) {
		this.telRes = telRes;
	}
	public int getTelCel() {
		return telCel;
	}
	public void setTelCel(int telCel) {
		this.telCel = telCel;
	}
	public int getIdEstadoCivil() {
		return idEstadoCivil;
	}
	public void setIdEstadoCivil(int idEstadoCivil) {
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
	public int getNumAtual() {
		return numAtual;
	}
	public void setNumAtual(int numAtual) {
		this.numAtual = numAtual;
	}
	public int getNumAntigo() {
		return numAntigo;
	}
	public void setNumAntigo(int numAntigo) {
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
	public int getQtdeAdulto() {
		return qtdeAdulto;
	}
	public void setQtdeAdulto(int qtdeAdulto) {
		this.qtdeAdulto = qtdeAdulto;
	}
	public int getQtdeCrianca() {
		return qtdeCrianca;
	}
	public void setQtdeCrianca(int qtdeCrianca) {
		this.qtdeCrianca = qtdeCrianca;
	}
	public int getPossuiConta() {
		return possuiConta;
	}
	public void setPossuiConta(int possuiConta) {
		this.possuiConta = possuiConta;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public int getPossuiCDeb() {
		return possuiCDeb;
	}
	public void setPossuiCDeb(int possuiCDeb) {
		this.possuiCDeb = possuiCDeb;
	}
	public BigDecimal getRendaTotal() {
		return rendaTotal;
	}
	public void setRendaTotal(BigDecimal rendaTotal) {
		this.rendaTotal = rendaTotal;
	}
	public int getRendaPerceUtil() {
		return rendaPerceUtil;
	}
	public void setRendaPerceUtil(int rendaPerceUtil) {
		this.rendaPerceUtil = rendaPerceUtil;
	}
	public int getMeioTransp1() {
		return meioTransp1;
	}
	public void setMeioTransp1(int meioTransp1) {
		this.meioTransp1 = meioTransp1;
	}
	public int getMeioTransp2() {
		return meioTransp2;
	}
	public void setMeioTransp2(int meioTransp2) {
		this.meioTransp2 = meioTransp2;
	}
	public int getMeioTransp3() {
		return meioTransp3;
	}
	public void setMeioTransp3(int meioTransp3) {
		this.meioTransp3 = meioTransp3;
	}
	public int getMeioTransp4() {
		return meioTransp4;
	}
	public void setMeioTransp4(int meioTransp4) {
		this.meioTransp4 = meioTransp4;
	}
	public int getMeioTransp5() {
		return meioTransp5;
	}
	public void setMeioTransp5(int meioTransp5) {
		this.meioTransp5 = meioTransp5;
	}
	public int getInternetAcess() {
		return internetAcess;
	}
	public void setInternetAcess(int internetAcess) {
		this.internetAcess = internetAcess;
	}
	public int getInternetWifi() {
		return internetWifi;
	}
	public void setInternetWifi(int internetWifi) {
		this.internetWifi = internetWifi;
	}
	public int getInternet3g() {
		return internet3g;
	}
	public void setInternet3g(int internet3g) {
		this.internet3g = internet3g;
	}
	public int getQtdeCarro() {
		return qtdeCarro;
	}
	public void setQtdeCarro(int qtdeCarro) {
		this.qtdeCarro = qtdeCarro;
	}
	public int getQtdeMoto() {
		return qtdeMoto;
	}
	public void setQtdeMoto(int qtdeMoto) {
		this.qtdeMoto = qtdeMoto;
	}
	public int getQtdeBicicleta() {
		return qtdeBicicleta;
	}
	public void setQtdeBicicleta(int qtdeBicicleta) {
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
	public int getPossuiTarSocial() {
		return possuiTarSocial;
	}
	public void setPossuiTarSocial(int possuiTarSocial) {
		this.possuiTarSocial = possuiTarSocial;
	}
	public int getPossuiBolsaFamil() {
		return possuiBolsaFamil;
	}
	public void setPossuiBolsaFamil(int possuiBolsaFamil) {
		this.possuiBolsaFamil = possuiBolsaFamil;
	}
	public int getBenefEntrev() {
		return benefEntrev;
	}
	public void setBenefEntrev(int benefEntrev) {
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
	public int getMaior59Qtde() {
		return maior59Qtde;
	}
	public void setMaior59Qtde(int maior59Qtde) {
		this.maior59Qtde = maior59Qtde;
	}
	public int getMenor19Qtde() {
		return menor19Qtde;
	}
	public void setMenor19Qtde(int menor19Qtde) {
		this.menor19Qtde = menor19Qtde;
	}
	public int getMenor1Qtde() {
		return menor1Qtde;
	}
	public void setMenor1Qtde(int menor1Qtde) {
		this.menor1Qtde = menor1Qtde;
	}
	public int getDefVisualQtde() {
		return defVisualQtde;
	}
	public void setDefVisualQtde(int defVisualQtde) {
		this.defVisualQtde = defVisualQtde;
	}
	public int getDefAuditQtde() {
		return defAuditQtde;
	}
	public void setDefAuditQtde(int defAuditQtde) {
		this.defAuditQtde = defAuditQtde;
	}
	public int getDefFisQtde() {
		return defFisQtde;
	}
	public void setDefFisQtde(int defFisQtde) {
		this.defFisQtde = defFisQtde;
	}
	public int getDefIntelecQtde() {
		return defIntelecQtde;
	}
	public void setDefIntelecQtde(int defIntelecQtde) {
		this.defIntelecQtde = defIntelecQtde;
	}
	public int getDefOutrosQtde() {
		return defOutrosQtde;
	}
	public void setDefOutrosQtde(int defOutrosQtde) {
		this.defOutrosQtde = defOutrosQtde;
	}
	public int getTratCancer() {
		return tratCancer;
	}
	public void setTratCancer(int tratCancer) {
		this.tratCancer = tratCancer;
	}
	public int getTratTuber() {
		return tratTuber;
	}
	public void setTratTuber(int tratTuber) {
		this.tratTuber = tratTuber;
	}
	public int getTratHansen() {
		return tratHansen;
	}
	public void setTratHansen(int tratHansen) {
		this.tratHansen = tratHansen;
	}
	public int getTratMental() {
		return tratMental;
	}
	public void setTratMental(int tratMental) {
		this.tratMental = tratMental;
	}
	public int getTratEscler() {
		return tratEscler;
	}
	public void setTratEscler(int tratEscler) {
		this.tratEscler = tratEscler;
	}
	public int getTratParal() {
		return tratParal;
	}
	public void setTratParal(int tratParal) {
		this.tratParal = tratParal;
	}
	public int getTratHepat() {
		return tratHepat;
	}
	public void setTratHepat(int tratHepat) {
		this.tratHepat = tratHepat;
	}
	public int getTratCardiac() {
		return tratCardiac;
	}
	public void setTratCardiac(int tratCardiac) {
		this.tratCardiac = tratCardiac;
	}
	public int getTratParkins() {
		return tratParkins;
	}
	public void setTratParkins(int tratParkins) {
		this.tratParkins = tratParkins;
	}
	public int getTratRenal() {
		return tratRenal;
	}
	public void setTratRenal(int tratRenal) {
		this.tratRenal = tratRenal;
	}
	public int getTratOutro() {
		return tratOutro;
	}
	public void setTratOutro(int tratOutro) {
		this.tratOutro = tratOutro;
	}
	public String getTratOutroDesc() {
		return tratOutroDesc;
	}
	public void setTratOutroDesc(String tratOutroDesc) {
		this.tratOutroDesc = tratOutroDesc;
	}
	public int getAmebiase() {
		return amebiase;
	}
	public void setAmebiase(int amebiase) {
		this.amebiase = amebiase;
	}
	public String getAmebiaseMemb() {
		return amebiaseMemb;
	}
	public void setAmebiaseMemb(String amebiaseMemb) {
		this.amebiaseMemb = amebiaseMemb;
	}
	public int getGastroent() {
		return gastroent;
	}
	public void setGastroent(int gastroent) {
		this.gastroent = gastroent;
	}
	public String getGastroentMemb() {
		return gastroentMemb;
	}
	public void setGastroentMemb(String gastroentMemb) {
		this.gastroentMemb = gastroentMemb;
	}
	public int getGiardiase() {
		return giardiase;
	}
	public void setGiardiase(int giardiase) {
		this.giardiase = giardiase;
	}
	public String getGiardiaseMemb() {
		return giardiaseMemb;
	}
	public void setGiardiaseMemb(String giardiaseMemb) {
		this.giardiaseMemb = giardiaseMemb;
	}
	public int getFebreTifo() {
		return febreTifo;
	}
	public void setFebreTifo(int febreTifo) {
		this.febreTifo = febreTifo;
	}
	public String getFebreTifoMemb() {
		return febreTifoMemb;
	}
	public void setFebreTifoMemb(String febreTifoMemb) {
		this.febreTifoMemb = febreTifoMemb;
	}
	public int getHepatite() {
		return hepatite;
	}
	public void setHepatite(int hepatite) {
		this.hepatite = hepatite;
	}
	public String getHepatiteMemb() {
		return hepatiteMemb;
	}
	public void setHepatiteMemb(String hepatiteMemb) {
		this.hepatiteMemb = hepatiteMemb;
	}
	public int getColera() {
		return colera;
	}
	public void setColera(int colera) {
		this.colera = colera;
	}
	public String getColeraMemb() {
		return coleraMemb;
	}
	public void setColeraMemb(String coleraMemb) {
		this.coleraMemb = coleraMemb;
	}
	public int getEsquitosso() {
		return esquitosso;
	}
	public void setEsquitosso(int esquitosso) {
		this.esquitosso = esquitosso;
	}
	public String getEsquitossoMemb() {
		return esquitossoMemb;
	}
	public void setEsquitossoMemb(String esquitossoMemb) {
		this.esquitossoMemb = esquitossoMemb;
	}
	public int getAscaridiase() {
		return ascaridiase;
	}
	public void setAscaridiase(int ascaridiase) {
		this.ascaridiase = ascaridiase;
	}
	public String getAscaridiaseMemb() {
		return ascaridiaseMemb;
	}
	public void setAscaridiaseMemb(String ascaridiaseMemb) {
		this.ascaridiaseMemb = ascaridiaseMemb;
	}
	public int getTeniase() {
		return teniase;
	}
	public void setTeniase(int teniase) {
		this.teniase = teniase;
	}
	public String getTeniaseMemb() {
		return teniaseMemb;
	}
	public void setTeniaseMemb(String teniaseMemb) {
		this.teniaseMemb = teniaseMemb;
	}
	public int getLeptospirose() {
		return leptospirose;
	}
	public void setLeptospirose(int leptospirose) {
		this.leptospirose = leptospirose;
	}
	public String getLeptospiroseMemb() {
		return leptospiroseMemb;
	}
	public void setLeptospiroseMemb(String leptospiroseMemb) {
		this.leptospiroseMemb = leptospiroseMemb;
	}
	public int getMalaria() {
		return malaria;
	}
	public void setMalaria(int malaria) {
		this.malaria = malaria;
	}
	public String getMalariaMemb() {
		return malariaMemb;
	}
	public void setMalariaMemb(String malariaMemb) {
		this.malariaMemb = malariaMemb;
	}
	public int getDengue() {
		return dengue;
	}
	public void setDengue(int dengue) {
		this.dengue = dengue;
	}
	public String getDengueMemb() {
		return dengueMemb;
	}
	public void setDengueMemb(String dengueMemb) {
		this.dengueMemb = dengueMemb;
	}
	public int getFebreAmar() {
		return febreAmar;
	}
	public void setFebreAmar(int febreAmar) {
		this.febreAmar = febreAmar;
	}
	public String getFebreAmarMemb() {
		return febreAmarMemb;
	}
	public void setFebreAmarMemb(String febreAmarMemb) {
		this.febreAmarMemb = febreAmarMemb;
	}
	public int getChikung() {
		return chikung;
	}
	public void setChikung(int chikung) {
		this.chikung = chikung;
	}
	public String getChikungMemb() {
		return chikungMemb;
	}
	public void setChikungMemb(String chikungMemb) {
		this.chikungMemb = chikungMemb;
	}
	public int getZicaVirus() {
		return zicaVirus;
	}
	public void setZicaVirus(int zicaVirus) {
		this.zicaVirus = zicaVirus;
	}
	public String getZicaVirusMemb() {
		return zicaVirusMemb;
	}
	public void setZicaVirusMemb(String zicaVirusMemb) {
		this.zicaVirusMemb = zicaVirusMemb;
	}
	public int getCianobacter() {
		return cianobacter;
	}
	public void setCianobacter(int cianobacter) {
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
	public int getIdGrauEscol() {
		return idGrauEscol;
	}
	public void setIdGrauEscol(int idGrauEscol) {
		this.idGrauEscol = idGrauEscol;
	}
	public int getGrauEscolCompl() {
		return grauEscolCompl;
	}
	public void setGrauEscolCompl(int grauEscolCompl) {
		this.grauEscolCompl = grauEscolCompl;
	}
	public int getSabeEscrever() {
		return sabeEscrever;
	}
	public void setSabeEscrever(int sabeEscrever) {
		this.sabeEscrever = sabeEscrever;
	}
	public int getSabeLer() {
		return sabeLer;
	}
	public void setSabeLer(int sabeLer) {
		this.sabeLer = sabeLer;
	}
	public int getEnsinoFunMembro() {
		return ensinoFunMembro;
	}
	public void setEnsinoFunMembro(int ensinoFunMembro) {
		this.ensinoFunMembro = ensinoFunMembro;
	}
	public int getEnsinoMedMembro() {
		return ensinoMedMembro;
	}
	public void setEnsinoMedMembro(int ensinoMedMembro) {
		this.ensinoMedMembro = ensinoMedMembro;
	}
	public int getEnsinoSupMembro() {
		return ensinoSupMembro;
	}
	public void setEnsinoSupMembro(int ensinoSupMembro) {
		this.ensinoSupMembro = ensinoSupMembro;
	}
	public int getEnsinoPosMembro() {
		return ensinoPosMembro;
	}
	public void setEnsinoPosMembro(int ensinoPosMembro) {
		this.ensinoPosMembro = ensinoPosMembro;
	}
	public int getEnsinoCurMembro() {
		return ensinoCurMembro;
	}
	public void setEnsinoCurMembro(int ensinoCurMembro) {
		this.ensinoCurMembro = ensinoCurMembro;
	}
	public int getAnalfabMembro() {
		return analfabMembro;
	}
	public void setAnalfabMembro(int analfabMembro) {
		this.analfabMembro = analfabMembro;
	}
	public String getProfissRespFamil() {
		return profissRespFamil;
	}
	public void setProfissRespFamil(String profissRespFamil) {
		this.profissRespFamil = profissRespFamil;
	}
	public int getEnergNegoc() {
		return energNegoc;
	}
	public void setEnergNegoc(int energNegoc) {
		this.energNegoc = energNegoc;
	}
	public BigDecimal getEnergNegocParcVal() {
		return energNegocParcVal;
	}
	public void setEnergNegocParcVal(BigDecimal energNegocParcVal) {
		this.energNegocParcVal = energNegocParcVal;
	}
	public int getEnergNegocParcQtde() {
		return energNegocParcQtde;
	}
	public void setEnergNegocParcQtde(int energNegocParcQtde) {
		this.energNegocParcQtde = energNegocParcQtde;
	}
	public int getEnergNegocDia() {
		return energNegocDia;
	}
	public void setEnergNegocDia(int energNegocDia) {
		this.energNegocDia = energNegocDia;
	}
	public int getAguaNegoc() {
		return aguaNegoc;
	}
	public void setAguaNegoc(int aguaNegoc) {
		this.aguaNegoc = aguaNegoc;
	}
	public BigDecimal getAguaNegocParcVal() {
		return aguaNegocParcVal;
	}
	public void setAguaNegocParcVal(BigDecimal aguaNegocParcVal) {
		this.aguaNegocParcVal = aguaNegocParcVal;
	}
	public int getAguaNegocParcQtde() {
		return aguaNegocParcQtde;
	}
	public void setAguaNegocParcQtde(int aguaNegocParcQtde) {
		this.aguaNegocParcQtde = aguaNegocParcQtde;
	}
	public int getAguaNegocDia() {
		return aguaNegocDia;
	}
	public void setAguaNegocDia(int aguaNegocDia) {
		this.aguaNegocDia = aguaNegocDia;
	}
	public String getObraSaneamConhe() {
		return obraSaneamConhe;
	}
	public void setObraSaneamConhe(String obraSaneamConhe) {
		this.obraSaneamConhe = obraSaneamConhe;
	}
	public int getBenefObraSanSaude() {
		return benefObraSanSaude;
	}
	public void setBenefObraSanSaude(int benefObraSanSaude) {
		this.benefObraSanSaude = benefObraSanSaude;
	}
	public int getBenefObraSanEco() {
		return benefObraSanEco;
	}
	public void setBenefObraSanEco(int benefObraSanEco) {
		this.benefObraSanEco = benefObraSanEco;
	}
	public int getBenefObraSanImob() {
		return benefObraSanImob;
	}
	public void setBenefObraSanImob(int benefObraSanImob) {
		this.benefObraSanImob = benefObraSanImob;
	}
	public int getBenefObraSanTuri() {
		return benefObraSanTuri;
	}
	public void setBenefObraSanTuri(int benefObraSanTuri) {
		this.benefObraSanTuri = benefObraSanTuri;
	}
	public String getObsGerais() {
		return obsGerais;
	}
	public void setObsGerais(String obsGerais) {
		this.obsGerais = obsGerais;
	}
	
}
