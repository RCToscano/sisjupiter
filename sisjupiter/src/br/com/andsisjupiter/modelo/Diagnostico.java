package br.com.andsisjupiter.modelo;

import java.io.Serializable;

public class Diagnostico implements Serializable {
	
	private Long idDiagnostico;
	private Long idComunidade;
	private Long tpInstalacao;
	private Long situacaoImovel;
	private Long tipoContrucao;
	private Long categoriaImovel1;
	private Long categoriaImovel2;
	private Long categoriaImovel3;
	private Long categoriaImovel4;
	private String atividadeImovel;
	private Long tpUsoImovel;
	private Long qtdeCasa;
	private Long tempoOcupacao;
	private Long energiaEletr;
	private Long energiaEletrIrreg;	
	private String numInstalacao;
	private String numMedidor;
	private Long calcamento;
	private Long coletaLixo;
	private Long abastAgua;
	private Long abastAguaIrreg;
	private String hidrometro;
	private Long destinoEsgoto;
	
	private String nomeCliente;
	private String cpfCliente;
	private String rgCliente;
	private Long nacionalidade;
	private String estadoNasc;
	private String municipioNasc;
	private String dtNascCliente;
	private String sexo;
	private Long telResidencia;
	private Long telCelular;
	private Long estadoCivil;
	private String email;
	private String endereco;
	private Long numAtual;
	private Long numAntigo;
	private String complemento;
	private String bairro;
	private String municipio;
	private String estado;
	private String cep;
	private Long qtdeAdulto;
	private Long qtdeCrianca;
	private Long contaExiste;
	private String banco;
	private Long cartaoDebitoExiste;
	private Double rendaTotal;
	private Long percentualMedio;
	private Long meioTransporte1;
	private Long meioTransporte2;
	private Long meioTransporte3;
	private Long meioTransporte4;
	private Long meioTransporte5;
	private Long acessoInternet;
	private Long acessoInternetTp1;
	private Long acessoInternetTp2;
	
	private Long qtdeCarro;
	private Long qtdeBicicleta;
	private Long qtdeMoto;
	private String benefBcpNum;
	private String benefNisNum;
	private Long tarifaSocialAgua;
	private Long bolsaFamilia;
	private String benefNome;
	private String benefCpf;
	private String benefRG;
	private String benefSexo;
	private String benefDtNasc;
	private String benefObs;
	private Long membroVulner60Anos;
	private Long membroVulner18Anos;
	private Long membroVulner1Ano;
	private Long pessoasDefVisu;
	private Long pessoasDefAud;
	private Long pessoasDefFis;
	private Long pessoasDefIntel;
	private Long pessoasDefOutr;
	private Long membroTratDoenca1;
	private Long membroTratDoenca2;
	private Long membroTratDoenca3;
	private Long membroTratDoenca4;
	private Long membroTratDoenca5;
	private Long membroTratDoenca6;
	private Long membroTratDoenca7;
	private Long membroTratDoenca8;
	private Long membroTratDoenca9;
	private Long membroTratDoenca10;
	private Long membroTratDoenca11;
	private String membroTratDoencaDesc;
	private Long doenca1;
	private String membroDoenca1;
	private Long doenca2;
	private String membroDoenca2;
	private Long doenca3;
	private String membroDoenca3;
	private Long doenca4;
	private String membroDoenca4;
	private Long doenca5;
	private String membroDoenca5;
	private Long doenca6;
	private String membroDoenca6;
	private Long doenca7;
	private String membroDoenca7;
	private Long doenca8;
	private String membroDoenca8;
	private Long doenca9;
	private String membroDoenca9;
	private Long doenca10;
	private String membroDoenca10;
	private Long doenca11;
	private String membroDoenca11;
	private Long doenca12;
	private String membroDoenca12;
	private Long doenca13;
	private String membroDoenca13;
	private Long doenca14;
	private String membroDoenca14;
	private Long doenca15;
	private String membroDoenca15;
	private Long doenca16;
	private String membroDoenca16;

	private Double detalheFinanDoacao;
	private Double detalheFinanAposen;
	private Double detalheFinanPensao;
	private Double detalheFinanSegDes;
	private Double detalheFinanInfor;
	private Double detalheFinanFormal;
	private Double detalheFinanBolsaF;
	private Double detalheFinanOutro;
	private String detalheFinanOutroDescr;
	private Long grauEscol;
	private Long grauEscolCompl;
	private Long grauEscolAnalfLer;
	private Long grauEscolAnalfEscr;
	private String profRespFamilia;
	private Long negocDebEner;
	private Double negocDebEnerValParc;
	private Long negocDebEnerQtdeParc;
	private Long negocDebEnerVenc;
	private Long negocDebAgua;
	private Double negocDebAguaValParc;
	private Long negocDebAguaQtdeParc;
	private Long negocDebAguaVenc;
	private String conheciObra;
	private Long benefObraSan1;
	private Long benefObraSan2;
	private Long benefObraSan3;
	private Long benefObraSan4;
	private String obsGerais;
	
	private Long idEquipe;
	private String coordX;
	private String coordY;
	private Long situacao;
	private String dtInsert;
	
	public Long getIdDiagnostico() {
		return idDiagnostico;
	}
	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	public Long getIdComunidade() {
		return idComunidade;
	}
	public void setIdComunidade(Long idComunidade) {
		this.idComunidade = idComunidade;
	}
	public Long getTpInstalacao() {
		return tpInstalacao;
	}
	public void setTpInstalacao(Long tpInstalacao) {
		this.tpInstalacao = tpInstalacao;
	}
	public Long getSituacaoImovel() {
		return situacaoImovel;
	}
	public void setSituacaoImovel(Long situacaoImovel) {
		this.situacaoImovel = situacaoImovel;
	}
	public Long getTipoContrucao() {
		return tipoContrucao;
	}
	public void setTipoContrucao(Long tipoContrucao) {
		this.tipoContrucao = tipoContrucao;
	}
	public Long getCategoriaImovel1() {
		return categoriaImovel1;
	}
	public void setCategoriaImovel1(Long categoriaImovel1) {
		this.categoriaImovel1 = categoriaImovel1;
	}
	public Long getCategoriaImovel2() {
		return categoriaImovel2;
	}
	public void setCategoriaImovel2(Long categoriaImovel2) {
		this.categoriaImovel2 = categoriaImovel2;
	}
	public Long getCategoriaImovel3() {
		return categoriaImovel3;
	}
	public void setCategoriaImovel3(Long categoriaImovel3) {
		this.categoriaImovel3 = categoriaImovel3;
	}
	public Long getCategoriaImovel4() {
		return categoriaImovel4;
	}
	public void setCategoriaImovel4(Long categoriaImovel4) {
		this.categoriaImovel4 = categoriaImovel4;
	}
	public String getAtividadeImovel() {
		return atividadeImovel;
	}
	public void setAtividadeImovel(String atividadeImovel) {
		this.atividadeImovel = atividadeImovel;
	}
	public Long getTpUsoImovel() {
		return tpUsoImovel;
	}
	public void setTpUsoImovel(Long tpUsoImovel) {
		this.tpUsoImovel = tpUsoImovel;
	}
	public Long getQtdeCasa() {
		return qtdeCasa;
	}
	public void setQtdeCasa(Long qtdeCasa) {
		this.qtdeCasa = qtdeCasa;
	}
	public Long getTempoOcupacao() {
		return tempoOcupacao;
	}
	public void setTempoOcupacao(Long tempoOcupacao) {
		this.tempoOcupacao = tempoOcupacao;
	}
	public Long getEnergiaEletr() {
		return energiaEletr;
	}
	public void setEnergiaEletr(Long energiaEletr) {
		this.energiaEletr = energiaEletr;
	}
	public Long getEnergiaEletrIrreg() {
		return energiaEletrIrreg;
	}
	public void setEnergiaEletrIrreg(Long energiaEletrIrreg) {
		this.energiaEletrIrreg = energiaEletrIrreg;
	}
	public String getNumInstalacao() {
		return numInstalacao;
	}
	public void setNumInstalacao(String numInstalacao) {
		this.numInstalacao = numInstalacao;
	}
	public String getNumMedidor() {
		return numMedidor;
	}
	public void setNumMedidor(String numMedidor) {
		this.numMedidor = numMedidor;
	}
	public Long getCalcamento() {
		return calcamento;
	}
	public void setCalcamento(Long calcamento) {
		this.calcamento = calcamento;
	}
	public Long getColetaLixo() {
		return coletaLixo;
	}
	public void setColetaLixo(Long coletaLixo) {
		this.coletaLixo = coletaLixo;
	}
	public Long getAbastAgua() {
		return abastAgua;
	}
	public void setAbastAgua(Long abastAgua) {
		this.abastAgua = abastAgua;
	}
	public Long getAbastAguaIrreg() {
		return abastAguaIrreg;
	}
	public void setAbastAguaIrreg(Long abastAguaIrreg) {
		this.abastAguaIrreg = abastAguaIrreg;
	}
	public String getHidrometro() {
		return hidrometro;
	}
	public void setHidrometro(String hidrometro) {
		this.hidrometro = hidrometro;
	}
	public Long getDestinoEsgoto() {
		return destinoEsgoto;
	}
	public void setDestinoEsgoto(Long destinoEsgoto) {
		this.destinoEsgoto = destinoEsgoto;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getRgCliente() {
		return rgCliente;
	}
	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}
	public Long getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(Long nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getEstadoNasc() {
		return estadoNasc;
	}
	public void setEstadoNasc(String estadoNasc) {
		this.estadoNasc = estadoNasc;
	}
	public String getMunicipioNasc() {
		return municipioNasc;
	}
	public void setMunicipioNasc(String municipioNasc) {
		this.municipioNasc = municipioNasc;
	}
	public String getDtNascCliente() {
		return dtNascCliente;
	}
	public void setDtNascCliente(String dtNascCliente) {
		this.dtNascCliente = dtNascCliente;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Long getTelResidencia() {
		return telResidencia;
	}
	public void setTelResidencia(Long telResidencia) {
		this.telResidencia = telResidencia;
	}
	public Long getTelCelular() {
		return telCelular;
	}
	public void setTelCelular(Long telCelular) {
		this.telCelular = telCelular;
	}
	public Long getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(Long estadoCivil) {
		this.estadoCivil = estadoCivil;
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
	public Long getNumAtual() {
		return numAtual;
	}
	public void setNumAtual(Long numAtual) {
		this.numAtual = numAtual;
	}
	public Long getNumAntigo() {
		return numAntigo;
	}
	public void setNumAntigo(Long numAntigo) {
		this.numAntigo = numAntigo;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Long getQtdeAdulto() {
		return qtdeAdulto;
	}
	public void setQtdeAdulto(Long qtdeAdulto) {
		this.qtdeAdulto = qtdeAdulto;
	}
	public Long getQtdeCrianca() {
		return qtdeCrianca;
	}
	public void setQtdeCrianca(Long qtdeCrianca) {
		this.qtdeCrianca = qtdeCrianca;
	}
	public Long getContaExiste() {
		return contaExiste;
	}
	public void setContaExiste(Long contaExiste) {
		this.contaExiste = contaExiste;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public Long getCartaoDebitoExiste() {
		return cartaoDebitoExiste;
	}
	public void setCartaoDebitoExiste(Long cartaoDebitoExiste) {
		this.cartaoDebitoExiste = cartaoDebitoExiste;
	}
	public Double getRendaTotal() {
		return rendaTotal;
	}
	public void setRendaTotal(Double rendaTotal) {
		this.rendaTotal = rendaTotal;
	}
	public Long getPercentualMedio() {
		return percentualMedio;
	}
	public void setPercentualMedio(Long percentualMedio) {
		this.percentualMedio = percentualMedio;
	}
	public Long getMeioTransporte1() {
		return meioTransporte1;
	}
	public void setMeioTransporte1(Long meioTransporte1) {
		this.meioTransporte1 = meioTransporte1;
	}
	public Long getMeioTransporte2() {
		return meioTransporte2;
	}
	public void setMeioTransporte2(Long meioTransporte2) {
		this.meioTransporte2 = meioTransporte2;
	}
	public Long getMeioTransporte3() {
		return meioTransporte3;
	}
	public void setMeioTransporte3(Long meioTransporte3) {
		this.meioTransporte3 = meioTransporte3;
	}
	public Long getMeioTransporte4() {
		return meioTransporte4;
	}
	public void setMeioTransporte4(Long meioTransporte4) {
		this.meioTransporte4 = meioTransporte4;
	}
	public Long getMeioTransporte5() {
		return meioTransporte5;
	}
	public void setMeioTransporte5(Long meioTransporte5) {
		this.meioTransporte5 = meioTransporte5;
	}
	public Long getAcessoInternet() {
		return acessoInternet;
	}
	public void setAcessoInternet(Long acessoInternet) {
		this.acessoInternet = acessoInternet;
	}
	public Long getAcessoInternetTp1() {
		return acessoInternetTp1;
	}
	public void setAcessoInternetTp1(Long acessoInternetTp1) {
		this.acessoInternetTp1 = acessoInternetTp1;
	}
	public Long getAcessoInternetTp2() {
		return acessoInternetTp2;
	}
	public void setAcessoInternetTp2(Long acessoInternetTp2) {
		this.acessoInternetTp2 = acessoInternetTp2;
	}
	public Long getQtdeCarro() {
		return qtdeCarro;
	}
	public void setQtdeCarro(Long qtdeCarro) {
		this.qtdeCarro = qtdeCarro;
	}
	public Long getQtdeBicicleta() {
		return qtdeBicicleta;
	}
	public void setQtdeBicicleta(Long qtdeBicicleta) {
		this.qtdeBicicleta = qtdeBicicleta;
	}
	public Long getQtdeMoto() {
		return qtdeMoto;
	}
	public void setQtdeMoto(Long qtdeMoto) {
		this.qtdeMoto = qtdeMoto;
	}
	public String getBenefBcpNum() {
		return benefBcpNum;
	}
	public void setBenefBcpNum(String benefBcpNum) {
		this.benefBcpNum = benefBcpNum;
	}
	public String getBenefNisNum() {
		return benefNisNum;
	}
	public void setBenefNisNum(String benefNisNum) {
		this.benefNisNum = benefNisNum;
	}
	public Long getTarifaSocialAgua() {
		return tarifaSocialAgua;
	}
	public void setTarifaSocialAgua(Long tarifaSocialAgua) {
		this.tarifaSocialAgua = tarifaSocialAgua;
	}
	public Long getBolsaFamilia() {
		return bolsaFamilia;
	}
	public void setBolsaFamilia(Long bolsaFamilia) {
		this.bolsaFamilia = bolsaFamilia;
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
	public String getBenefRG() {
		return benefRG;
	}
	public void setBenefRG(String benefRG) {
		this.benefRG = benefRG;
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
	public Long getMembroVulner60Anos() {
		return membroVulner60Anos;
	}
	public void setMembroVulner60Anos(Long membroVulner60Anos) {
		this.membroVulner60Anos = membroVulner60Anos;
	}
	public Long getMembroVulner18Anos() {
		return membroVulner18Anos;
	}
	public void setMembroVulner18Anos(Long membroVulner18Anos) {
		this.membroVulner18Anos = membroVulner18Anos;
	}
	public Long getMembroVulner1Ano() {
		return membroVulner1Ano;
	}
	public void setMembroVulner1Ano(Long membroVulner1Ano) {
		this.membroVulner1Ano = membroVulner1Ano;
	}
	public Long getPessoasDefVisu() {
		return pessoasDefVisu;
	}
	public void setPessoasDefVisu(Long pessoasDefVisu) {
		this.pessoasDefVisu = pessoasDefVisu;
	}
	public Long getPessoasDefAud() {
		return pessoasDefAud;
	}
	public void setPessoasDefAud(Long pessoasDefAud) {
		this.pessoasDefAud = pessoasDefAud;
	}
	public Long getPessoasDefFis() {
		return pessoasDefFis;
	}
	public void setPessoasDefFis(Long pessoasDefFis) {
		this.pessoasDefFis = pessoasDefFis;
	}
	public Long getPessoasDefIntel() {
		return pessoasDefIntel;
	}
	public void setPessoasDefIntel(Long pessoasDefIntel) {
		this.pessoasDefIntel = pessoasDefIntel;
	}
	public Long getPessoasDefOutr() {
		return pessoasDefOutr;
	}
	public void setPessoasDefOutr(Long pessoasDefOutr) {
		this.pessoasDefOutr = pessoasDefOutr;
	}
	public Long getMembroTratDoenca1() {
		return membroTratDoenca1;
	}
	public void setMembroTratDoenca1(Long membroTratDoenca1) {
		this.membroTratDoenca1 = membroTratDoenca1;
	}
	public Long getMembroTratDoenca2() {
		return membroTratDoenca2;
	}
	public void setMembroTratDoenca2(Long membroTratDoenca2) {
		this.membroTratDoenca2 = membroTratDoenca2;
	}
	public Long getMembroTratDoenca3() {
		return membroTratDoenca3;
	}
	public void setMembroTratDoenca3(Long membroTratDoenca3) {
		this.membroTratDoenca3 = membroTratDoenca3;
	}
	public Long getMembroTratDoenca4() {
		return membroTratDoenca4;
	}
	public void setMembroTratDoenca4(Long membroTratDoenca4) {
		this.membroTratDoenca4 = membroTratDoenca4;
	}
	public Long getMembroTratDoenca5() {
		return membroTratDoenca5;
	}
	public void setMembroTratDoenca5(Long membroTratDoenca5) {
		this.membroTratDoenca5 = membroTratDoenca5;
	}
	public Long getMembroTratDoenca6() {
		return membroTratDoenca6;
	}
	public void setMembroTratDoenca6(Long membroTratDoenca6) {
		this.membroTratDoenca6 = membroTratDoenca6;
	}
	public Long getMembroTratDoenca7() {
		return membroTratDoenca7;
	}
	public void setMembroTratDoenca7(Long membroTratDoenca7) {
		this.membroTratDoenca7 = membroTratDoenca7;
	}
	public Long getMembroTratDoenca8() {
		return membroTratDoenca8;
	}
	public void setMembroTratDoenca8(Long membroTratDoenca8) {
		this.membroTratDoenca8 = membroTratDoenca8;
	}
	public Long getMembroTratDoenca9() {
		return membroTratDoenca9;
	}
	public void setMembroTratDoenca9(Long membroTratDoenca9) {
		this.membroTratDoenca9 = membroTratDoenca9;
	}
	public Long getMembroTratDoenca10() {
		return membroTratDoenca10;
	}
	public void setMembroTratDoenca10(Long membroTratDoenca10) {
		this.membroTratDoenca10 = membroTratDoenca10;
	}
	public Long getMembroTratDoenca11() {
		return membroTratDoenca11;
	}
	public void setMembroTratDoenca11(Long membroTratDoenca11) {
		this.membroTratDoenca11 = membroTratDoenca11;
	}
	public String getMembroTratDoencaDesc() {
		return membroTratDoencaDesc;
	}
	public void setMembroTratDoencaDesc(String membroTratDoencaDesc) {
		this.membroTratDoencaDesc = membroTratDoencaDesc;
	}
	public Long getDoenca1() {
		return doenca1;
	}
	public void setDoenca1(Long doenca1) {
		this.doenca1 = doenca1;
	}
	public String getMembroDoenca1() {
		return membroDoenca1;
	}
	public void setMembroDoenca1(String membroDoenca1) {
		this.membroDoenca1 = membroDoenca1;
	}
	public Long getDoenca2() {
		return doenca2;
	}
	public void setDoenca2(Long doenca2) {
		this.doenca2 = doenca2;
	}
	public String getMembroDoenca2() {
		return membroDoenca2;
	}
	public void setMembroDoenca2(String membroDoenca2) {
		this.membroDoenca2 = membroDoenca2;
	}
	public Long getDoenca3() {
		return doenca3;
	}
	public void setDoenca3(Long doenca3) {
		this.doenca3 = doenca3;
	}
	public String getMembroDoenca3() {
		return membroDoenca3;
	}
	public void setMembroDoenca3(String membroDoenca3) {
		this.membroDoenca3 = membroDoenca3;
	}
	public Long getDoenca4() {
		return doenca4;
	}
	public void setDoenca4(Long doenca4) {
		this.doenca4 = doenca4;
	}
	public String getMembroDoenca4() {
		return membroDoenca4;
	}
	public void setMembroDoenca4(String membroDoenca4) {
		this.membroDoenca4 = membroDoenca4;
	}
	public Long getDoenca5() {
		return doenca5;
	}
	public void setDoenca5(Long doenca5) {
		this.doenca5 = doenca5;
	}
	public String getMembroDoenca5() {
		return membroDoenca5;
	}
	public void setMembroDoenca5(String membroDoenca5) {
		this.membroDoenca5 = membroDoenca5;
	}
	public Long getDoenca6() {
		return doenca6;
	}
	public void setDoenca6(Long doenca6) {
		this.doenca6 = doenca6;
	}
	public String getMembroDoenca6() {
		return membroDoenca6;
	}
	public void setMembroDoenca6(String membroDoenca6) {
		this.membroDoenca6 = membroDoenca6;
	}
	public Long getDoenca7() {
		return doenca7;
	}
	public void setDoenca7(Long doenca7) {
		this.doenca7 = doenca7;
	}
	public String getMembroDoenca7() {
		return membroDoenca7;
	}
	public void setMembroDoenca7(String membroDoenca7) {
		this.membroDoenca7 = membroDoenca7;
	}
	public Long getDoenca8() {
		return doenca8;
	}
	public void setDoenca8(Long doenca8) {
		this.doenca8 = doenca8;
	}
	public String getMembroDoenca8() {
		return membroDoenca8;
	}
	public void setMembroDoenca8(String membroDoenca8) {
		this.membroDoenca8 = membroDoenca8;
	}
	public Long getDoenca9() {
		return doenca9;
	}
	public void setDoenca9(Long doenca9) {
		this.doenca9 = doenca9;
	}
	public String getMembroDoenca9() {
		return membroDoenca9;
	}
	public void setMembroDoenca9(String membroDoenca9) {
		this.membroDoenca9 = membroDoenca9;
	}
	public Long getDoenca10() {
		return doenca10;
	}
	public void setDoenca10(Long doenca10) {
		this.doenca10 = doenca10;
	}
	public String getMembroDoenca10() {
		return membroDoenca10;
	}
	public void setMembroDoenca10(String membroDoenca10) {
		this.membroDoenca10 = membroDoenca10;
	}
	public Long getDoenca11() {
		return doenca11;
	}
	public void setDoenca11(Long doenca11) {
		this.doenca11 = doenca11;
	}
	public String getMembroDoenca11() {
		return membroDoenca11;
	}
	public void setMembroDoenca11(String membroDoenca11) {
		this.membroDoenca11 = membroDoenca11;
	}
	public Long getDoenca12() {
		return doenca12;
	}
	public void setDoenca12(Long doenca12) {
		this.doenca12 = doenca12;
	}
	public String getMembroDoenca12() {
		return membroDoenca12;
	}
	public void setMembroDoenca12(String membroDoenca12) {
		this.membroDoenca12 = membroDoenca12;
	}
	public Long getDoenca13() {
		return doenca13;
	}
	public void setDoenca13(Long doenca13) {
		this.doenca13 = doenca13;
	}
	public String getMembroDoenca13() {
		return membroDoenca13;
	}
	public void setMembroDoenca13(String membroDoenca13) {
		this.membroDoenca13 = membroDoenca13;
	}
	public Long getDoenca14() {
		return doenca14;
	}
	public void setDoenca14(Long doenca14) {
		this.doenca14 = doenca14;
	}
	public String getMembroDoenca14() {
		return membroDoenca14;
	}
	public void setMembroDoenca14(String membroDoenca14) {
		this.membroDoenca14 = membroDoenca14;
	}
	public Long getDoenca15() {
		return doenca15;
	}
	public void setDoenca15(Long doenca15) {
		this.doenca15 = doenca15;
	}
	public String getMembroDoenca15() {
		return membroDoenca15;
	}
	public void setMembroDoenca15(String membroDoenca15) {
		this.membroDoenca15 = membroDoenca15;
	}
	public Long getDoenca16() {
		return doenca16;
	}
	public void setDoenca16(Long doenca16) {
		this.doenca16 = doenca16;
	}
	public String getMembroDoenca16() {
		return membroDoenca16;
	}
	public void setMembroDoenca16(String membroDoenca16) {
		this.membroDoenca16 = membroDoenca16;
	}
	public Double getDetalheFinanDoacao() {
		return detalheFinanDoacao;
	}
	public void setDetalheFinanDoacao(Double detalheFinanDoacao) {
		this.detalheFinanDoacao = detalheFinanDoacao;
	}
	public Double getDetalheFinanAposen() {
		return detalheFinanAposen;
	}
	public void setDetalheFinanAposen(Double detalheFinanAposen) {
		this.detalheFinanAposen = detalheFinanAposen;
	}
	public Double getDetalheFinanPensao() {
		return detalheFinanPensao;
	}
	public void setDetalheFinanPensao(Double detalheFinanPensao) {
		this.detalheFinanPensao = detalheFinanPensao;
	}
	public Double getDetalheFinanSegDes() {
		return detalheFinanSegDes;
	}
	public void setDetalheFinanSegDes(Double detalheFinanSegDes) {
		this.detalheFinanSegDes = detalheFinanSegDes;
	}
	public Double getDetalheFinanInfor() {
		return detalheFinanInfor;
	}
	public void setDetalheFinanInfor(Double detalheFinanInfor) {
		this.detalheFinanInfor = detalheFinanInfor;
	}
	public Double getDetalheFinanFormal() {
		return detalheFinanFormal;
	}
	public void setDetalheFinanFormal(Double detalheFinanFormal) {
		this.detalheFinanFormal = detalheFinanFormal;
	}
	public Double getDetalheFinanBolsaF() {
		return detalheFinanBolsaF;
	}
	public void setDetalheFinanBolsaF(Double detalheFinanBolsaF) {
		this.detalheFinanBolsaF = detalheFinanBolsaF;
	}
	public Double getDetalheFinanOutro() {
		return detalheFinanOutro;
	}
	public void setDetalheFinanOutro(Double detalheFinanOutro) {
		this.detalheFinanOutro = detalheFinanOutro;
	}
	public String getDetalheFinanOutroDescr() {
		return detalheFinanOutroDescr;
	}
	public void setDetalheFinanOutroDescr(String detalheFinanOutroDescr) {
		this.detalheFinanOutroDescr = detalheFinanOutroDescr;
	}
	public Long getGrauEscol() {
		return grauEscol;
	}
	public void setGrauEscol(Long grauEscol) {
		this.grauEscol = grauEscol;
	}
	public Long getGrauEscolCompl() {
		return grauEscolCompl;
	}
	public void setGrauEscolCompl(Long grauEscolCompl) {
		this.grauEscolCompl = grauEscolCompl;
	}
	public Long getGrauEscolAnalfLer() {
		return grauEscolAnalfLer;
	}
	public void setGrauEscolAnalfLer(Long grauEscolAnalfLer) {
		this.grauEscolAnalfLer = grauEscolAnalfLer;
	}
	public Long getGrauEscolAnalfEscr() {
		return grauEscolAnalfEscr;
	}
	public void setGrauEscolAnalfEscr(Long grauEscolAnalfEscr) {
		this.grauEscolAnalfEscr = grauEscolAnalfEscr;
	}
	public String getProfRespFamilia() {
		return profRespFamilia;
	}
	public void setProfRespFamilia(String profRespFamilia) {
		this.profRespFamilia = profRespFamilia;
	}
	public Long getNegocDebEner() {
		return negocDebEner;
	}
	public void setNegocDebEner(Long negocDebEner) {
		this.negocDebEner = negocDebEner;
	}
	public Double getNegocDebEnerValParc() {
		return negocDebEnerValParc;
	}
	public void setNegocDebEnerValParc(Double negocDebEnerValParc) {
		this.negocDebEnerValParc = negocDebEnerValParc;
	}
	public Long getNegocDebEnerQtdeParc() {
		return negocDebEnerQtdeParc;
	}
	public void setNegocDebEnerQtdeParc(Long negocDebEnerQtdeParc) {
		this.negocDebEnerQtdeParc = negocDebEnerQtdeParc;
	}
	public Long getNegocDebEnerVenc() {
		return negocDebEnerVenc;
	}
	public void setNegocDebEnerVenc(Long negocDebEnerVenc) {
		this.negocDebEnerVenc = negocDebEnerVenc;
	}
	public Long getNegocDebAgua() {
		return negocDebAgua;
	}
	public void setNegocDebAgua(Long negocDebAgua) {
		this.negocDebAgua = negocDebAgua;
	}
	public Double getNegocDebAguaValParc() {
		return negocDebAguaValParc;
	}
	public void setNegocDebAguaValParc(Double negocDebAguaValParc) {
		this.negocDebAguaValParc = negocDebAguaValParc;
	}
	public Long getNegocDebAguaQtdeParc() {
		return negocDebAguaQtdeParc;
	}
	public void setNegocDebAguaQtdeParc(Long negocDebAguaQtdeParc) {
		this.negocDebAguaQtdeParc = negocDebAguaQtdeParc;
	}
	public Long getNegocDebAguaVenc() {
		return negocDebAguaVenc;
	}
	public void setNegocDebAguaVenc(Long negocDebAguaVenc) {
		this.negocDebAguaVenc = negocDebAguaVenc;
	}
	public String getConheciObra() {
		return conheciObra;
	}
	public void setConheciObra(String conheciObra) {
		this.conheciObra = conheciObra;
	}
	public Long getBenefObraSan1() {
		return benefObraSan1;
	}
	public void setBenefObraSan1(Long benefObraSan1) {
		this.benefObraSan1 = benefObraSan1;
	}
	public Long getBenefObraSan2() {
		return benefObraSan2;
	}
	public void setBenefObraSan2(Long benefObraSan2) {
		this.benefObraSan2 = benefObraSan2;
	}
	public Long getBenefObraSan3() {
		return benefObraSan3;
	}
	public void setBenefObraSan3(Long benefObraSan3) {
		this.benefObraSan3 = benefObraSan3;
	}
	public Long getBenefObraSan4() {
		return benefObraSan4;
	}
	public void setBenefObraSan4(Long benefObraSan4) {
		this.benefObraSan4 = benefObraSan4;
	}
	public String getObsGerais() {
		return obsGerais;
	}
	public void setObsGerais(String obsGerais) {
		this.obsGerais = obsGerais;
	}
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
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
