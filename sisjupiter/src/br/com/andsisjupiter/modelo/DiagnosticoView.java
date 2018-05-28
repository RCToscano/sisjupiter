package br.com.andsisjupiter.modelo;

public class DiagnosticoView {
	
	private String id_diagnostico;
	private String id_comunidade;
	private String comunidade;
	private String data_diagnos;
	private String data_insert;
	private String id_equipe;
	private String executor;
	private String id_user;
	private String situacao_imovel;
	private String tipo_contrucao;
	private String tipo_instalacao;
	private String residencia;
	private String comercio;
	private String industria;
	private String publica;
	private String uso_imovel;
	private String qtde_casas;
	private String tempo_ocupacao;
	private String atividade;
	private String energia_eletrica;
	private String energia_eletrica_irreg;
	private String instalacao;
	private String medidor;
	private String pavimentacao;
	private String coleta_lixo;
	private String abastec_agua;
	private String abastec_agua_irreg;
	private String hidrometro;
	private String destino_esgoto;
	private String cliente;
	private String cpf;
	private String rg;
	private String nacionalidade;
	private String uf_nasc;
	private String mun_nasc;
	private String dtnasc;
	private String sexo;
	private String telres;
	private String telcel;
	private String estado_civil;
	private String email;
	private String endereco;
	private String numatual;
	private String numantigo;
	private String compl;
	private String bairro;
	private String mun;
	private String uf;
	private String cep;
	private String qtde_adulto;
	private String qtde_crianca;
	private String tem_conta;
	private String banco;
	private String tem_cartao_debito;
	private String rendatotal;
	private String compro_financ;
	private String transp_carro_proprio;
	private String transp_onibus;
	private String transp_trem;
	private String transp_metro;
	private String transp_taxi;
	private String acesso_internet;
	private String wifi;
	private String internet3g;
	private String qtde_carro;
	private String qtde_moto;
	private String qtde_bicicleta;
	private String benef_bcpnum;
	private String benef_nisnum;
	private String tarifa_social;
	private String bolsa_familia;
	private String benef_nome;
	private String benef_cpf;
	private String benef_rg;
	private String benef_sexo;
	private String benef_dtnasc;
	private String benef_obs;
	private String anos60_ou_maior;
	private String anos18_ou_menor;
	private String menor_1_ano;
	private String qtde_def_visual;
	private String qtde_def_auditivo;
	private String qtde_def_fisico;
	private String qtde_def_intelect;
	private String qtde_def_outros;
	private String trata_cancer;
	private String trata_tuberculose;
	private String trata_hansen;
	private String trata_alie_mental;
	private String trata_esclerose;
	private String trata_paralisia;
	private String trata_hepatite;
	private String trata_cardiaco;
	private String trata_parkinson;
	private String trata_renal;
	private String trata_outro;
	private String trat_outro_desc;
	private String membro_amebiase;
	private String membro_amebiase_parent;
	private String membro_gastro;
	private String membro_gastro_parent;
	private String membro_giardiase;
	private String membro_giardiase_parent;
	private String membro_febre_tifoide;
	private String membro_febre_tifoide_parent;
	private String membro_hepatite;
	private String membro_hepatite_parent;
	private String membro_colera;
	private String membro_colera_parent;
	private String membro_esquitosso;
	private String membro_esquitosso_parent;
	private String membro_ascaridiase;
	private String membro_ascaridiase_parent;
	private String membro_teniase;
	private String membro_teniase_parent;
	private String membro_leptospirose;
	private String membro_leptospirose_parent;
	private String membro_malaria;
	private String membro_malaria_parent;
	private String membro_dengue;
	private String membro_dengue_parent;
	private String membro_febreamar;
	private String membro_febreamar_parent;
	private String membro_chikung;
	private String membro_chikung_parent;
	private String membro_zicavirus;
	private String membro_zicavirus_parent;
	private String membro_cianobacter;
	private String membro_cianobacter_parent;
	private String val_doacao;
	private String val_aposent;
	private String val_pensao_alimen;
	private String val_seg_desempr;
	private String val_empr_informal;
	private String val_empr_formal;
	private String val_bolsa_famil;
	private String val_outro;
	private String val_outr_descr;
	private String grau_escolar;
	private String grau_escolar_compl;
	private String sabe_escrever;
	private String sabe_ler;
	private String profissao_resp_familia;
	private String negociacao_deb_energia;
	private String valor_parcela_energ;
	private String qtde_parcela_energ;
	private String venc_parcela_energ;
	private String negociacao_deb_agua;
	private String valor_parcela_agua;
	private String qtde_parcela_agua;
	private String venc_parcela_agua;
	private String conhec_obra_saneam;
	private String benef_sanea_prev_doenca;
	private String benef_sanea_fortal_econo;
	private String benef_sanea_valori_imob;
	private String benef_sanea_valor_turism;
	private String obs_gerais;
	private String moradores;
	private String resp_casa_nome1;
	private String resp_casa_tel1;
	private String resp_casa_nome2;
	private String resp_casa_tel2;
	private String vizinho_nome1;
	private String vizinho_tel1;
	private String vizinho_nome2;
	private String vizinho_tel2;
	private String contato_altern_nome1;
	private String contato_altern_tel1;
	private String contato_altern_nome2;
	private String contato_altern_tel2;
	private String contato_prof_nome1;
	private String contato_prof_te1;
	private String contato_prof_nome2;
	private String contato_prof_te2;
	private String equip_publico;
	private String relacaoviz;
	private String rel_recor_vizinho;
	private String rel_recor_vizinho_freq;
	private String consideracoes_familias_ao_redor;
	private String hospital_nome;
	private String ref_nome;
	private String coordx;
	private String coordy;
	private String coordxdiag;
	private String coordydiag;
	
	
	public String getId_diagnostico() {
		return id_diagnostico;
	}
	public void setId_diagnostico(String id_diagnostico) {
		this.id_diagnostico = id_diagnostico;
	}
	public String getId_comunidade() {
		return id_comunidade;
	}
	public void setId_comunidade(String id_comunidade) {
		this.id_comunidade = id_comunidade;
	}
	public String getComunidade() {
		return comunidade;
	}
	public void setComunidade(String comunidade) {
		this.comunidade = comunidade;
	}
	public String getData_diagnos() {
		return data_diagnos;
	}
	public void setData_diagnos(String data_diagnos) {
		this.data_diagnos = data_diagnos;
	}
	public String getData_insert() {
		return data_insert;
	}
	public void setData_insert(String data_insert) {
		this.data_insert = data_insert;
	}
	public String getId_equipe() {
		return id_equipe;
	}
	public void setId_equipe(String id_equipe) {
		this.id_equipe = id_equipe;
	}
	public String getExecutor() {
		return executor;
	}
	public void setExecutor(String executor) {
		this.executor = executor;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getSituacao_imovel() {
		return situacao_imovel;
	}
	public void setSituacao_imovel(String situacao_imovel) {
		this.situacao_imovel = situacao_imovel;
	}
	public String getTipo_contrucao() {
		return tipo_contrucao;
	}
	public void setTipo_contrucao(String tipo_contrucao) {
		this.tipo_contrucao = tipo_contrucao;
	}
	public String getTipo_instalacao() {
		return tipo_instalacao;
	}
	public void setTipo_instalacao(String tipo_instalacao) {
		this.tipo_instalacao = tipo_instalacao;
	}
	public String getResidencia() {
		return residencia;
	}
	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}
	public String getComercio() {
		return comercio;
	}
	public void setComercio(String comercio) {
		this.comercio = comercio;
	}
	public String getIndustria() {
		return industria;
	}
	public void setIndustria(String industria) {
		this.industria = industria;
	}
	public String getPublica() {
		return publica;
	}
	public void setPublica(String publica) {
		this.publica = publica;
	}
	public String getUso_imovel() {
		return uso_imovel;
	}
	public void setUso_imovel(String uso_imovel) {
		this.uso_imovel = uso_imovel;
	}
	public String getQtde_casas() {
		return qtde_casas;
	}
	public void setQtde_casas(String qtde_casas) {
		this.qtde_casas = qtde_casas;
	}
	public String getTempo_ocupacao() {
		return tempo_ocupacao;
	}
	public void setTempo_ocupacao(String tempo_ocupacao) {
		this.tempo_ocupacao = tempo_ocupacao;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public String getEnergia_eletrica() {
		return energia_eletrica;
	}
	public void setEnergia_eletrica(String energia_eletrica) {
		this.energia_eletrica = energia_eletrica;
	}
	public String getEnergia_eletrica_irreg() {
		return energia_eletrica_irreg;
	}
	public void setEnergia_eletrica_irreg(String energia_eletrica_irreg) {
		this.energia_eletrica_irreg = energia_eletrica_irreg;
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
	public String getPavimentacao() {
		return pavimentacao;
	}
	public void setPavimentacao(String pavimentacao) {
		this.pavimentacao = pavimentacao;
	}
	public String getColeta_lixo() {
		return coleta_lixo;
	}
	public void setColeta_lixo(String coleta_lixo) {
		this.coleta_lixo = coleta_lixo;
	}
	public String getAbastec_agua() {
		return abastec_agua;
	}
	public void setAbastec_agua(String abastec_agua) {
		this.abastec_agua = abastec_agua;
	}
	public String getAbastec_agua_irreg() {
		return abastec_agua_irreg;
	}
	public void setAbastec_agua_irreg(String abastec_agua_irreg) {
		this.abastec_agua_irreg = abastec_agua_irreg;
	}
	public String getHidrometro() {
		return hidrometro;
	}
	public void setHidrometro(String hidrometro) {
		this.hidrometro = hidrometro;
	}
	public String getDestino_esgoto() {
		return destino_esgoto;
	}
	public void setDestino_esgoto(String destino_esgoto) {
		this.destino_esgoto = destino_esgoto;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
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
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getUf_nasc() {
		return uf_nasc;
	}
	public void setUf_nasc(String uf_nasc) {
		this.uf_nasc = uf_nasc;
	}
	public String getMun_nasc() {
		return mun_nasc;
	}
	public void setMun_nasc(String mun_nasc) {
		this.mun_nasc = mun_nasc;
	}
	public String getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(String dtnasc) {
		this.dtnasc = dtnasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTelres() {
		return telres;
	}
	public void setTelres(String telres) {
		this.telres = telres;
	}
	public String getTelcel() {
		return telcel;
	}
	public void setTelcel(String telcel) {
		this.telcel = telcel;
	}
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
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
	public String getNumatual() {
		return numatual;
	}
	public void setNumatual(String numatual) {
		this.numatual = numatual;
	}
	public String getNumantigo() {
		return numantigo;
	}
	public void setNumantigo(String numantigo) {
		this.numantigo = numantigo;
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
	public String getQtde_adulto() {
		return qtde_adulto;
	}
	public void setQtde_adulto(String qtde_adulto) {
		this.qtde_adulto = qtde_adulto;
	}
	public String getQtde_crianca() {
		return qtde_crianca;
	}
	public void setQtde_crianca(String qtde_crianca) {
		this.qtde_crianca = qtde_crianca;
	}
	public String getTem_conta() {
		return tem_conta;
	}
	public void setTem_conta(String tem_conta) {
		this.tem_conta = tem_conta;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getTem_cartao_debito() {
		return tem_cartao_debito;
	}
	public void setTem_cartao_debito(String tem_cartao_debito) {
		this.tem_cartao_debito = tem_cartao_debito;
	}
	public String getRendatotal() {
		return rendatotal;
	}
	public void setRendatotal(String rendatotal) {
		this.rendatotal = rendatotal;
	}
	public String getCompro_financ() {
		return compro_financ;
	}
	public void setCompro_financ(String compro_financ) {
		this.compro_financ = compro_financ;
	}
	public String getTransp_carro_proprio() {
		return transp_carro_proprio;
	}
	public void setTransp_carro_proprio(String transp_carro_proprio) {
		this.transp_carro_proprio = transp_carro_proprio;
	}
	public String getTransp_onibus() {
		return transp_onibus;
	}
	public void setTransp_onibus(String transp_onibus) {
		this.transp_onibus = transp_onibus;
	}
	public String getTransp_trem() {
		return transp_trem;
	}
	public void setTransp_trem(String transp_trem) {
		this.transp_trem = transp_trem;
	}
	public String getTransp_metro() {
		return transp_metro;
	}
	public void setTransp_metro(String transp_metro) {
		this.transp_metro = transp_metro;
	}
	public String getTransp_taxi() {
		return transp_taxi;
	}
	public void setTransp_taxi(String transp_taxi) {
		this.transp_taxi = transp_taxi;
	}
	public String getAcesso_internet() {
		return acesso_internet;
	}
	public void setAcesso_internet(String acesso_internet) {
		this.acesso_internet = acesso_internet;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getInternet3g() {
		return internet3g;
	}
	public void setInternet3g(String internet3g) {
		this.internet3g = internet3g;
	}
	public String getQtde_carro() {
		return qtde_carro;
	}
	public void setQtde_carro(String qtde_carro) {
		this.qtde_carro = qtde_carro;
	}
	public String getQtde_moto() {
		return qtde_moto;
	}
	public void setQtde_moto(String qtde_moto) {
		this.qtde_moto = qtde_moto;
	}
	public String getQtde_bicicleta() {
		return qtde_bicicleta;
	}
	public void setQtde_bicicleta(String qtde_bicicleta) {
		this.qtde_bicicleta = qtde_bicicleta;
	}
	public String getBenef_bcpnum() {
		return benef_bcpnum;
	}
	public void setBenef_bcpnum(String benef_bcpnum) {
		this.benef_bcpnum = benef_bcpnum;
	}
	public String getBenef_nisnum() {
		return benef_nisnum;
	}
	public void setBenef_nisnum(String benef_nisnum) {
		this.benef_nisnum = benef_nisnum;
	}
	public String getTarifa_social() {
		return tarifa_social;
	}
	public void setTarifa_social(String tarifa_social) {
		this.tarifa_social = tarifa_social;
	}
	public String getBolsa_familia() {
		return bolsa_familia;
	}
	public void setBolsa_familia(String bolsa_familia) {
		this.bolsa_familia = bolsa_familia;
	}
	public String getBenef_nome() {
		return benef_nome;
	}
	public void setBenef_nome(String benef_nome) {
		this.benef_nome = benef_nome;
	}
	public String getBenef_cpf() {
		return benef_cpf;
	}
	public void setBenef_cpf(String benef_cpf) {
		this.benef_cpf = benef_cpf;
	}
	public String getBenef_rg() {
		return benef_rg;
	}
	public void setBenef_rg(String benef_rg) {
		this.benef_rg = benef_rg;
	}
	public String getBenef_sexo() {
		return benef_sexo;
	}
	public void setBenef_sexo(String benef_sexo) {
		this.benef_sexo = benef_sexo;
	}
	public String getBenef_dtnasc() {
		return benef_dtnasc;
	}
	public void setBenef_dtnasc(String benef_dtnasc) {
		this.benef_dtnasc = benef_dtnasc;
	}
	public String getBenef_obs() {
		return benef_obs;
	}
	public void setBenef_obs(String benef_obs) {
		this.benef_obs = benef_obs;
	}
	public String getAnos60_ou_maior() {
		return anos60_ou_maior;
	}
	public void setAnos60_ou_maior(String anos60_ou_maior) {
		this.anos60_ou_maior = anos60_ou_maior;
	}
	public String getAnos18_ou_menor() {
		return anos18_ou_menor;
	}
	public void setAnos18_ou_menor(String anos18_ou_menor) {
		this.anos18_ou_menor = anos18_ou_menor;
	}
	public String getMenor_1_ano() {
		return menor_1_ano;
	}
	public void setMenor_1_ano(String menor_1_ano) {
		this.menor_1_ano = menor_1_ano;
	}
	public String getQtde_def_visual() {
		return qtde_def_visual;
	}
	public void setQtde_def_visual(String qtde_def_visual) {
		this.qtde_def_visual = qtde_def_visual;
	}
	public String getQtde_def_auditivo() {
		return qtde_def_auditivo;
	}
	public void setQtde_def_auditivo(String qtde_def_auditivo) {
		this.qtde_def_auditivo = qtde_def_auditivo;
	}
	public String getQtde_def_fisico() {
		return qtde_def_fisico;
	}
	public void setQtde_def_fisico(String qtde_def_fisico) {
		this.qtde_def_fisico = qtde_def_fisico;
	}
	public String getQtde_def_intelect() {
		return qtde_def_intelect;
	}
	public void setQtde_def_intelect(String qtde_def_intelect) {
		this.qtde_def_intelect = qtde_def_intelect;
	}
	public String getQtde_def_outros() {
		return qtde_def_outros;
	}
	public void setQtde_def_outros(String qtde_def_outros) {
		this.qtde_def_outros = qtde_def_outros;
	}
	public String getTrata_cancer() {
		return trata_cancer;
	}
	public void setTrata_cancer(String trata_cancer) {
		this.trata_cancer = trata_cancer;
	}
	public String getTrata_tuberculose() {
		return trata_tuberculose;
	}
	public void setTrata_tuberculose(String trata_tuberculose) {
		this.trata_tuberculose = trata_tuberculose;
	}
	public String getTrata_hansen() {
		return trata_hansen;
	}
	public void setTrata_hansen(String trata_hansen) {
		this.trata_hansen = trata_hansen;
	}
	public String getTrata_alie_mental() {
		return trata_alie_mental;
	}
	public void setTrata_alie_mental(String trata_alie_mental) {
		this.trata_alie_mental = trata_alie_mental;
	}
	public String getTrata_esclerose() {
		return trata_esclerose;
	}
	public void setTrata_esclerose(String trata_esclerose) {
		this.trata_esclerose = trata_esclerose;
	}
	public String getTrata_paralisia() {
		return trata_paralisia;
	}
	public void setTrata_paralisia(String trata_paralisia) {
		this.trata_paralisia = trata_paralisia;
	}
	public String getTrata_hepatite() {
		return trata_hepatite;
	}
	public void setTrata_hepatite(String trata_hepatite) {
		this.trata_hepatite = trata_hepatite;
	}
	public String getTrata_cardiaco() {
		return trata_cardiaco;
	}
	public void setTrata_cardiaco(String trata_cardiaco) {
		this.trata_cardiaco = trata_cardiaco;
	}
	public String getTrata_parkinson() {
		return trata_parkinson;
	}
	public void setTrata_parkinson(String trata_parkinson) {
		this.trata_parkinson = trata_parkinson;
	}
	public String getTrata_renal() {
		return trata_renal;
	}
	public void setTrata_renal(String trata_renal) {
		this.trata_renal = trata_renal;
	}
	public String getTrata_outro() {
		return trata_outro;
	}
	public void setTrata_outro(String trata_outro) {
		this.trata_outro = trata_outro;
	}
	public String getTrat_outro_desc() {
		return trat_outro_desc;
	}
	public void setTrat_outro_desc(String trat_outro_desc) {
		this.trat_outro_desc = trat_outro_desc;
	}
	public String getMembro_amebiase() {
		return membro_amebiase;
	}
	public void setMembro_amebiase(String membro_amebiase) {
		this.membro_amebiase = membro_amebiase;
	}
	public String getMembro_amebiase_parent() {
		return membro_amebiase_parent;
	}
	public void setMembro_amebiase_parent(String membro_amebiase_parent) {
		this.membro_amebiase_parent = membro_amebiase_parent;
	}
	public String getMembro_gastro() {
		return membro_gastro;
	}
	public void setMembro_gastro(String membro_gastro) {
		this.membro_gastro = membro_gastro;
	}
	public String getMembro_gastro_parent() {
		return membro_gastro_parent;
	}
	public void setMembro_gastro_parent(String membro_gastro_parent) {
		this.membro_gastro_parent = membro_gastro_parent;
	}
	public String getMembro_giardiase() {
		return membro_giardiase;
	}
	public void setMembro_giardiase(String membro_giardiase) {
		this.membro_giardiase = membro_giardiase;
	}
	public String getMembro_giardiase_parent() {
		return membro_giardiase_parent;
	}
	public void setMembro_giardiase_parent(String membro_giardiase_parent) {
		this.membro_giardiase_parent = membro_giardiase_parent;
	}
	public String getMembro_febre_tifoide() {
		return membro_febre_tifoide;
	}
	public void setMembro_febre_tifoide(String membro_febre_tifoide) {
		this.membro_febre_tifoide = membro_febre_tifoide;
	}
	public String getMembro_febre_tifoide_parent() {
		return membro_febre_tifoide_parent;
	}
	public void setMembro_febre_tifoide_parent(String membro_febre_tifoide_parent) {
		this.membro_febre_tifoide_parent = membro_febre_tifoide_parent;
	}
	public String getMembro_hepatite() {
		return membro_hepatite;
	}
	public void setMembro_hepatite(String membro_hepatite) {
		this.membro_hepatite = membro_hepatite;
	}
	public String getMembro_hepatite_parent() {
		return membro_hepatite_parent;
	}
	public void setMembro_hepatite_parent(String membro_hepatite_parent) {
		this.membro_hepatite_parent = membro_hepatite_parent;
	}
	public String getMembro_colera() {
		return membro_colera;
	}
	public void setMembro_colera(String membro_colera) {
		this.membro_colera = membro_colera;
	}
	public String getMembro_colera_parent() {
		return membro_colera_parent;
	}
	public void setMembro_colera_parent(String membro_colera_parent) {
		this.membro_colera_parent = membro_colera_parent;
	}
	public String getMembro_esquitosso() {
		return membro_esquitosso;
	}
	public void setMembro_esquitosso(String membro_esquitosso) {
		this.membro_esquitosso = membro_esquitosso;
	}
	public String getMembro_esquitosso_parent() {
		return membro_esquitosso_parent;
	}
	public void setMembro_esquitosso_parent(String membro_esquitosso_parent) {
		this.membro_esquitosso_parent = membro_esquitosso_parent;
	}
	public String getMembro_ascaridiase() {
		return membro_ascaridiase;
	}
	public void setMembro_ascaridiase(String membro_ascaridiase) {
		this.membro_ascaridiase = membro_ascaridiase;
	}
	public String getMembro_ascaridiase_parent() {
		return membro_ascaridiase_parent;
	}
	public void setMembro_ascaridiase_parent(String membro_ascaridiase_parent) {
		this.membro_ascaridiase_parent = membro_ascaridiase_parent;
	}
	public String getMembro_teniase() {
		return membro_teniase;
	}
	public void setMembro_teniase(String membro_teniase) {
		this.membro_teniase = membro_teniase;
	}
	public String getMembro_teniase_parent() {
		return membro_teniase_parent;
	}
	public void setMembro_teniase_parent(String membro_teniase_parent) {
		this.membro_teniase_parent = membro_teniase_parent;
	}
	public String getMembro_leptospirose() {
		return membro_leptospirose;
	}
	public void setMembro_leptospirose(String membro_leptospirose) {
		this.membro_leptospirose = membro_leptospirose;
	}
	public String getMembro_leptospirose_parent() {
		return membro_leptospirose_parent;
	}
	public void setMembro_leptospirose_parent(String membro_leptospirose_parent) {
		this.membro_leptospirose_parent = membro_leptospirose_parent;
	}
	public String getMembro_malaria() {
		return membro_malaria;
	}
	public void setMembro_malaria(String membro_malaria) {
		this.membro_malaria = membro_malaria;
	}
	public String getMembro_malaria_parent() {
		return membro_malaria_parent;
	}
	public void setMembro_malaria_parent(String membro_malaria_parent) {
		this.membro_malaria_parent = membro_malaria_parent;
	}
	public String getMembro_dengue() {
		return membro_dengue;
	}
	public void setMembro_dengue(String membro_dengue) {
		this.membro_dengue = membro_dengue;
	}
	public String getMembro_dengue_parent() {
		return membro_dengue_parent;
	}
	public void setMembro_dengue_parent(String membro_dengue_parent) {
		this.membro_dengue_parent = membro_dengue_parent;
	}
	public String getMembro_febreamar() {
		return membro_febreamar;
	}
	public void setMembro_febreamar(String membro_febreamar) {
		this.membro_febreamar = membro_febreamar;
	}
	public String getMembro_febreamar_parent() {
		return membro_febreamar_parent;
	}
	public void setMembro_febreamar_parent(String membro_febreamar_parent) {
		this.membro_febreamar_parent = membro_febreamar_parent;
	}
	public String getMembro_chikung() {
		return membro_chikung;
	}
	public void setMembro_chikung(String membro_chikung) {
		this.membro_chikung = membro_chikung;
	}
	public String getMembro_chikung_parent() {
		return membro_chikung_parent;
	}
	public void setMembro_chikung_parent(String membro_chikung_parent) {
		this.membro_chikung_parent = membro_chikung_parent;
	}
	public String getMembro_zicavirus() {
		return membro_zicavirus;
	}
	public void setMembro_zicavirus(String membro_zicavirus) {
		this.membro_zicavirus = membro_zicavirus;
	}
	public String getMembro_zicavirus_parent() {
		return membro_zicavirus_parent;
	}
	public void setMembro_zicavirus_parent(String membro_zicavirus_parent) {
		this.membro_zicavirus_parent = membro_zicavirus_parent;
	}
	public String getMembro_cianobacter() {
		return membro_cianobacter;
	}
	public void setMembro_cianobacter(String membro_cianobacter) {
		this.membro_cianobacter = membro_cianobacter;
	}
	public String getMembro_cianobacter_parent() {
		return membro_cianobacter_parent;
	}
	public void setMembro_cianobacter_parent(String membro_cianobacter_parent) {
		this.membro_cianobacter_parent = membro_cianobacter_parent;
	}
	public String getVal_doacao() {
		return val_doacao;
	}
	public void setVal_doacao(String val_doacao) {
		this.val_doacao = val_doacao;
	}
	public String getVal_aposent() {
		return val_aposent;
	}
	public void setVal_aposent(String val_aposent) {
		this.val_aposent = val_aposent;
	}
	public String getVal_pensao_alimen() {
		return val_pensao_alimen;
	}
	public void setVal_pensao_alimen(String val_pensao_alimen) {
		this.val_pensao_alimen = val_pensao_alimen;
	}
	public String getVal_seg_desempr() {
		return val_seg_desempr;
	}
	public void setVal_seg_desempr(String val_seg_desempr) {
		this.val_seg_desempr = val_seg_desempr;
	}
	public String getVal_empr_informal() {
		return val_empr_informal;
	}
	public void setVal_empr_informal(String val_empr_informal) {
		this.val_empr_informal = val_empr_informal;
	}
	public String getVal_empr_formal() {
		return val_empr_formal;
	}
	public void setVal_empr_formal(String val_empr_formal) {
		this.val_empr_formal = val_empr_formal;
	}
	public String getVal_bolsa_famil() {
		return val_bolsa_famil;
	}
	public void setVal_bolsa_famil(String val_bolsa_famil) {
		this.val_bolsa_famil = val_bolsa_famil;
	}
	public String getVal_outro() {
		return val_outro;
	}
	public void setVal_outro(String val_outro) {
		this.val_outro = val_outro;
	}
	public String getVal_outr_descr() {
		return val_outr_descr;
	}
	public void setVal_outr_descr(String val_outr_descr) {
		this.val_outr_descr = val_outr_descr;
	}
	public String getGrau_escolar() {
		return grau_escolar;
	}
	public void setGrau_escolar(String grau_escolar) {
		this.grau_escolar = grau_escolar;
	}
	public String getGrau_escolar_compl() {
		return grau_escolar_compl;
	}
	public void setGrau_escolar_compl(String grau_escolar_compl) {
		this.grau_escolar_compl = grau_escolar_compl;
	}
	public String getSabe_escrever() {
		return sabe_escrever;
	}
	public void setSabe_escrever(String sabe_escrever) {
		this.sabe_escrever = sabe_escrever;
	}
	public String getSabe_ler() {
		return sabe_ler;
	}
	public void setSabe_ler(String sabe_ler) {
		this.sabe_ler = sabe_ler;
	}
	public String getProfissao_resp_familia() {
		return profissao_resp_familia;
	}
	public void setProfissao_resp_familia(String profissao_resp_familia) {
		this.profissao_resp_familia = profissao_resp_familia;
	}
	public String getNegociacao_deb_energia() {
		return negociacao_deb_energia;
	}
	public void setNegociacao_deb_energia(String negociacao_deb_energia) {
		this.negociacao_deb_energia = negociacao_deb_energia;
	}
	public String getValor_parcela_energ() {
		return valor_parcela_energ;
	}
	public void setValor_parcela_energ(String valor_parcela_energ) {
		this.valor_parcela_energ = valor_parcela_energ;
	}
	public String getQtde_parcela_energ() {
		return qtde_parcela_energ;
	}
	public void setQtde_parcela_energ(String qtde_parcela_energ) {
		this.qtde_parcela_energ = qtde_parcela_energ;
	}
	public String getVenc_parcela_energ() {
		return venc_parcela_energ;
	}
	public void setVenc_parcela_energ(String venc_parcela_energ) {
		this.venc_parcela_energ = venc_parcela_energ;
	}
	public String getNegociacao_deb_agua() {
		return negociacao_deb_agua;
	}
	public void setNegociacao_deb_agua(String negociacao_deb_agua) {
		this.negociacao_deb_agua = negociacao_deb_agua;
	}
	public String getValor_parcela_agua() {
		return valor_parcela_agua;
	}
	public void setValor_parcela_agua(String valor_parcela_agua) {
		this.valor_parcela_agua = valor_parcela_agua;
	}
	public String getQtde_parcela_agua() {
		return qtde_parcela_agua;
	}
	public void setQtde_parcela_agua(String qtde_parcela_agua) {
		this.qtde_parcela_agua = qtde_parcela_agua;
	}
	public String getVenc_parcela_agua() {
		return venc_parcela_agua;
	}
	public void setVenc_parcela_agua(String venc_parcela_agua) {
		this.venc_parcela_agua = venc_parcela_agua;
	}
	public String getConhec_obra_saneam() {
		return conhec_obra_saneam;
	}
	public void setConhec_obra_saneam(String conhec_obra_saneam) {
		this.conhec_obra_saneam = conhec_obra_saneam;
	}
	public String getBenef_sanea_prev_doenca() {
		return benef_sanea_prev_doenca;
	}
	public void setBenef_sanea_prev_doenca(String benef_sanea_prev_doenca) {
		this.benef_sanea_prev_doenca = benef_sanea_prev_doenca;
	}
	public String getBenef_sanea_fortal_econo() {
		return benef_sanea_fortal_econo;
	}
	public void setBenef_sanea_fortal_econo(String benef_sanea_fortal_econo) {
		this.benef_sanea_fortal_econo = benef_sanea_fortal_econo;
	}
	public String getBenef_sanea_valori_imob() {
		return benef_sanea_valori_imob;
	}
	public void setBenef_sanea_valori_imob(String benef_sanea_valori_imob) {
		this.benef_sanea_valori_imob = benef_sanea_valori_imob;
	}
	public String getBenef_sanea_valor_turism() {
		return benef_sanea_valor_turism;
	}
	public void setBenef_sanea_valor_turism(String benef_sanea_valor_turism) {
		this.benef_sanea_valor_turism = benef_sanea_valor_turism;
	}
	public String getObs_gerais() {
		return obs_gerais;
	}
	public void setObs_gerais(String obs_gerais) {
		this.obs_gerais = obs_gerais;
	}
	public String getMoradores() {
		return moradores;
	}
	public void setMoradores(String moradores) {
		this.moradores = moradores;
	}
	public String getResp_casa_nome1() {
		return resp_casa_nome1;
	}
	public void setResp_casa_nome1(String resp_casa_nome1) {
		this.resp_casa_nome1 = resp_casa_nome1;
	}
	public String getResp_casa_tel1() {
		return resp_casa_tel1;
	}
	public void setResp_casa_tel1(String resp_casa_tel1) {
		this.resp_casa_tel1 = resp_casa_tel1;
	}
	public String getResp_casa_nome2() {
		return resp_casa_nome2;
	}
	public void setResp_casa_nome2(String resp_casa_nome2) {
		this.resp_casa_nome2 = resp_casa_nome2;
	}
	public String getResp_casa_tel2() {
		return resp_casa_tel2;
	}
	public void setResp_casa_tel2(String resp_casa_tel2) {
		this.resp_casa_tel2 = resp_casa_tel2;
	}
	public String getVizinho_nome1() {
		return vizinho_nome1;
	}
	public void setVizinho_nome1(String vizinho_nome1) {
		this.vizinho_nome1 = vizinho_nome1;
	}
	public String getVizinho_tel1() {
		return vizinho_tel1;
	}
	public void setVizinho_tel1(String vizinho_tel1) {
		this.vizinho_tel1 = vizinho_tel1;
	}
	public String getVizinho_nome2() {
		return vizinho_nome2;
	}
	public void setVizinho_nome2(String vizinho_nome2) {
		this.vizinho_nome2 = vizinho_nome2;
	}
	public String getVizinho_tel2() {
		return vizinho_tel2;
	}
	public void setVizinho_tel2(String vizinho_tel2) {
		this.vizinho_tel2 = vizinho_tel2;
	}
	public String getContato_altern_nome1() {
		return contato_altern_nome1;
	}
	public void setContato_altern_nome1(String contato_altern_nome1) {
		this.contato_altern_nome1 = contato_altern_nome1;
	}
	public String getContato_altern_tel1() {
		return contato_altern_tel1;
	}
	public void setContato_altern_tel1(String contato_altern_tel1) {
		this.contato_altern_tel1 = contato_altern_tel1;
	}
	public String getContato_altern_nome2() {
		return contato_altern_nome2;
	}
	public void setContato_altern_nome2(String contato_altern_nome2) {
		this.contato_altern_nome2 = contato_altern_nome2;
	}
	public String getContato_altern_tel2() {
		return contato_altern_tel2;
	}
	public void setContato_altern_tel2(String contato_altern_tel2) {
		this.contato_altern_tel2 = contato_altern_tel2;
	}
	public String getContato_prof_nome1() {
		return contato_prof_nome1;
	}
	public void setContato_prof_nome1(String contato_prof_nome1) {
		this.contato_prof_nome1 = contato_prof_nome1;
	}
	public String getContato_prof_te1() {
		return contato_prof_te1;
	}
	public void setContato_prof_te1(String contato_prof_te1) {
		this.contato_prof_te1 = contato_prof_te1;
	}
	public String getContato_prof_nome2() {
		return contato_prof_nome2;
	}
	public void setContato_prof_nome2(String contato_prof_nome2) {
		this.contato_prof_nome2 = contato_prof_nome2;
	}
	public String getContato_prof_te2() {
		return contato_prof_te2;
	}
	public void setContato_prof_te2(String contato_prof_te2) {
		this.contato_prof_te2 = contato_prof_te2;
	}
	public String getEquip_publico() {
		return equip_publico;
	}
	public void setEquip_publico(String equip_publico) {
		this.equip_publico = equip_publico;
	}
	public String getRelacaoviz() {
		return relacaoviz;
	}
	public void setRelacaoviz(String relacaoviz) {
		this.relacaoviz = relacaoviz;
	}
	public String getRel_recor_vizinho() {
		return rel_recor_vizinho;
	}
	public void setRel_recor_vizinho(String rel_recor_vizinho) {
		this.rel_recor_vizinho = rel_recor_vizinho;
	}
	public String getRel_recor_vizinho_freq() {
		return rel_recor_vizinho_freq;
	}
	public void setRel_recor_vizinho_freq(String rel_recor_vizinho_freq) {
		this.rel_recor_vizinho_freq = rel_recor_vizinho_freq;
	}
	public String getConsideracoes_familias_ao_redor() {
		return consideracoes_familias_ao_redor;
	}
	public void setConsideracoes_familias_ao_redor(String consideracoes_familias_ao_redor) {
		this.consideracoes_familias_ao_redor = consideracoes_familias_ao_redor;
	}
	public String getHospital_nome() {
		return hospital_nome;
	}
	public void setHospital_nome(String hospital_nome) {
		this.hospital_nome = hospital_nome;
	}
	public String getRef_nome() {
		return ref_nome;
	}
	public void setRef_nome(String ref_nome) {
		this.ref_nome = ref_nome;
	}
	public String getCoordx() {
		return coordx;
	}
	public void setCoordx(String coordx) {
		this.coordx = coordx;
	}
	public String getCoordy() {
		return coordy;
	}
	public void setCoordy(String coordy) {
		this.coordy = coordy;
	}
	public String getCoordxdiag() {
		return coordxdiag;
	}
	public void setCoordxdiag(String coordxdiag) {
		this.coordxdiag = coordxdiag;
	}
	public String getCoordydiag() {
		return coordydiag;
	}
	public void setCoordydiag(String coordydiag) {
		this.coordydiag = coordydiag;
	}
	

}
