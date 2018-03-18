<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Deep</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="./css/menucustomcolor.css" rel="stylesheet"/>
        <link href="./css/footercustom.css" rel="stylesheet"/>
        <script src="./js/jquery-1.11.3.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css" />
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
		<script type="text/javascript" src="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>
    </head>
    <body>
        <jsp:include page="../../menu/${sessionScope.user.perfil.menu}" ></jsp:include>
        <div class="container">
	        <ul class="breadcrumb">
			    <li><a href="HomeBO?acao=home">Home</a></li>
			    <li><a href="ServicoBO?acao=consultar">Servi&ccedil;o</a></li>
			    <li><a href="ServicoBO?acao=consultar">Consulta</a></li>
			    <li><a href="ServicoBO?acao=pesquisar">Lista</a></li>
			    <li class="active">Formul&aacute;rio</li>
			</ul>
			
			<c:if test="${aviso != ''}">
				<div class="alert alert-danger">
					<strong><c:out value="${aviso}"/></strong>
				</div>
			</c:if>
		
			<form action="ServicoBO?acao=inserir" method="post">
				<h2>Formul&aacute;rio de Diagn&oacute;stico</h2>
				<div class="panel-group">
				
					<div class="panel panel-primary">
						<div class="panel-heading"><label>Servi&ccedil;o</label></div>
						<div class="panel-body">
						
						
							<div class="col-sm-6">
								<div class="form-group">
									<label for="sel1">Cadastrante:</label> 
									<select class="form-control" name="cadastrante" id="cadastrante" >
	                                	<option value="nenhum" selected>Selecione...</option>
	<%--                                     <c:forEach var="listaComunidades" items="${listaComunidades}"> --%>
	<%--                                     	<c:choose> --%>
	<%-- 	                                        <c:when test="${modelo.idComunidade == listaComunidades.idComunidade}"> --%>
	<%-- 	                                            <option value="${listaComunidades.idComunidade}" selected="true">${listaComunidades.descComunidade}</option> --%>
	<%-- 	                                        </c:when> --%>
	<%-- 	                                        <c:otherwise> --%>
	<%-- 	                                        	<option value="${listaComunidades.idComunidade}" >${listaComunidades.descComunidade}</option> --%>
	<%-- 	                                        </c:otherwise> --%>
	<%--                                         </c:choose> --%>
	<%--                                     </c:forEach> --%>
	                                </select>
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="dtExecucao">Data de Execu&ccedil;&atilde;o: </label> 
									<input type="text" class="form-control input-sm" name="dtExecucao" id="dtExecucao" data-date-format="DD/MM/YYYY" placeholder="dd/mm/aaaa" maxlength="10" value="${modelo.data}" required />
								</div>
							</div>
							
							<div class="col-sm-12"></div>
							
							<div class="col-sm-2"> 
								<div class="form-group">
									<label for="codServico">C&oacute;digo do Servi&ccedil;o: </label> 
									<input type="text" class="form-control input-sm" name="codServico" id="codServico" maxlength="15" value="${modelo.codServ}" />
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<label for="sel1">Comunidade:</label> 
									<select class="form-control" name="comunidade" id="comunidade" >
	                                    <option value="nenhum" selected>Selecione...</option>
	<%--                                     <c:forEach var="listaComunidades" items="${listaComunidades}"> --%>
	<%--                                     	<c:choose> --%>
	<%-- 	                                        <c:when test="${modelo.idComunidade == listaComunidades.idComunidade}"> --%>
	<%-- 	                                            <option value="${listaComunidades.idComunidade}" selected="true">${listaComunidades.descComunidade}</option> --%>
	<%-- 	                                        </c:when> --%>
	<%-- 	                                        <c:otherwise> --%>
	<%-- 	                                        	<option value="${listaComunidades.idComunidade}" >${listaComunidades.descComunidade}</option> --%>
	<%-- 	                                        </c:otherwise> --%>
	<%--                                         </c:choose> --%>
	<%--                                     </c:forEach> --%>
	<!--                                 </select> -->
									</select>
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<label>Tipo de Instala&ccedil;&atilde;o: </label>
									<c:forEach items="${listaTpInstalacao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.idTpInstal}">
													<input type="radio" name="radioTpInst" id="tpInstRegular${total.descricao}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioTpInst" id="tpInstRegular${total.descricao}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<label for="email">Tipo de Constru&ccedil;&atilde;o: </label> 
									<c:forEach items="${listaTpContrucao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.idTpConstr}">
													<input type="radio" name="radioTpConstrucao" id="tpConstrucao${total.descricao}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioTpConstrucao" id="tpConstrucao${total.descricao}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label for="email">Situa&ccedil;&atilde;o do Im&oacute;vel: </label> 
									<c:forEach items="${listaSituacaoImovel}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.idSitImovel}">
													<input type="radio" name="radioSitImovel" id="sitImovel${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioSitImovel" id="sitImovel${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<label for="email">Categoria do Im&oacute;vel: </label> 
									<label class="checkbox-inline">
										<input type="checkbox" name="checkTpImovelResidencia" id="checkTpImovelResidencia" >Resid&ecirc;ncia</input>
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" name="checkTpImovelComercio" id="checkTpImovelComercio" >Com&eacute;rcio</input>
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" name="checkTpImovelIndustria" id="checkTpImovelIndustria" >Ind&uacute;stria</input>
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" name="checkTpImovelPublica" id="checkTpImovelPublica" >P&uacute;blica</input>
									</label>
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<label for="imovel">Im&oacute;vel: </label> 
									<c:forEach items="${listaTipoImovel}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.idTpUso}">
													<input type="radio" name="radioImovel" id="imovel${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioImovel" id="imovel${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							 
							<div class="col-sm-4">
								<div class="form-group">
									<label for="qtdeCasas">Qtde. de Casas no Mesmo Endere&ccedil;o/Terreno</label> 
									<input type="text" class="form-control input-sm" name="qtdeCasas" id="qtdeCasas" maxlength="2" value="${modelo.qtdeCasas}" />
								</div>
							</div>
							 
							<div class="col-sm-2">
								<div class="form-group">
									<label for="ocupacao">Tempo de Ocupa&ccedil;&atilde;o</label> 
									<input type="text" class="form-control input-sm" name="ocupacao" id="ocupacao" maxlength="100" value="${modelo.tempoOcup}" />
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label for="atividade">Atividade</label> 
									<input type="text" class="form-control input-sm" name="atividade" id="atividade" maxlength="100" value="${modelo.atividade}" />
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="form-group">
									<label for="irregularidade">Energia El&eacute;trica: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.energEletr}">
													<input type="radio" name="radioEnergia" id="energia${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioEnergia" id="energia${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
	
							<div class="col-sm-6">
								<div class="form-group">
									<label for="irregularidade">Suspeito de Irregularidade: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.energEletrIrreg}">
													<input type="radio" name="radioEnergiaIrregular" id="irregularEnerg${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioEnergiaIrregular" id="irregularEnerg${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="numeroInstalacao">N&deg; Instala&ccedil;&atilde;o</label> 
									<input type="text" class="form-control input-sm" name="numeroInstalacao" id="numeroInstalacao" maxlength="50" value="${modelo.instalacao}" />
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="numeroMedidor">N&deg; Medidor</label> 
									<input type="text" class="form-control input-sm" name="numeroMedidor" id="numeroMedidor" maxlength="50" value="${modelo.medidor}"  />
								</div>
							</div>
							
							<div class="col-sm-12"></div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<label for="pavimento">Cal&ccedil;amento / Pavimenta&ccedil;&atilde;o em Frente a Resid&ecirc;ncia: </label>
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.pavimeExiste}">
													<input type="radio" name="radioPavimento" id="pavimento${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioPavimento" id="pavimento${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach> 
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<label for="lixo">Coleto de Lixo: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.colLixoExiste}">
													<input type="radio" name="radioLixo" id="lixo${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioLixo" id="lixo${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label for="abastecimento">Forma de Abastecimento do Im&oacute;vel: </label> 
									<c:forEach items="${listaAbastecimentoAgua}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.idAbastAgua}">
													<input type="radio" name="radioAbastecimento" id="abast${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioAbastecimento" id="abast${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label for="irregularidade">Suspeito de Irregularidade: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.abastAguaIrreg}">
													<input type="radio" name="radioAguaIrregular" id="irregularAgua${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioAguaIrregular" id="irregularAgua${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="hidrometro">Hidr&ocirc;metro</label> 
									<input type="text" class="form-control input-sm" name="hidrometro" id="hidrometro" maxlength="15" value="${modelo.hidrometro}"  />
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label for="esgoto">Destino Esgoto: </label> 
									<c:forEach items="${listaDestinoEsgoto}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.idDestEsgoto}">
													<input type="radio" name="radioEsgoto" id="esgoto${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioEsgoto" id="esgoto${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
						</div> <!-- Fim Painel Body -->
					</div> <!-- Fim Painel -->
						
					<div class="panel panel-primary">
						<div class="panel-heading"><label>Dados do Cliente</label></div>
						<div class="panel-body">
							<div class="col-sm-12">
								<div class="form-group">
									<label for="nomeCliente">Nome Completo</label> 
									<input type="text" class="form-control input-sm" name="nomeCliente" id="nomeCliente" maxlength="100" value="${modelo.nome}" />
								</div>
							</div>
						
							<div class="col-sm-2">
								<div class="form-group">
									<label for="cpfCliente">CPF</label> 
									<input type="text" class="form-control input-sm" name="cpfCliente" id="cpfCliente" maxlength="14" value="${modelo.cpf}" />
								</div>
							</div>
								
							<div class="col-sm-2">
								<div class="form-group">
									<label for="rgCliente">RG</label> 
									<input type="text" class="form-control input-sm" name="rgCliente" id="rgCliente" maxlength="45" value="${modelo.rg}"  />
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="municipioNascimento">Munic&iacute;pio de Nascimento</label> 
									<input type="text" class="form-control input-sm" name="municipioNascimento" id="municipioNascimento" maxlength="100" value="${modelo.munNasc}" />
								</div>
							</div>
	
						<div class="col-sm-3">
							<div class="form-group">
								<label for="sel1">Estado de Nascimento:</label> 
								<select class="form-control" name="estadoNascimento" id="estadoNascimento" >
									<option value="nenhum" selected>Selecione...</option>
									<c:forEach items="${listaEstados}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.ufNasc}">
													<option value="${total.id}" selected>${total.descricao}</option>
												</c:when>
												<c:otherwise>
													<option value="${total.id}">${total.descricao}</option>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</select>
							</div>
						</div>
	
						<div class="col-sm-2">
								<div class="form-group">
									<label for="dtNascimento">Data de Nascimento</label> 
									<input type="text" class="form-control input-sm" name="dtNascimento" id="dtNascimento" maxlength="10" value="${modelo.dtNasc}" data-date-format="DD/MM/YYYY" placeholder="dd/mm/aaaa"  />
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="form-group">
									<label for="sexo">Nacionalidade: </label> 
									<c:forEach items="${listaNacionalidade}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.nacionalidade}">
													<input type="radio" name="radioNacionalidade" id="nacionalidade${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioNacionalidade" id="nacionalidade${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="sexo">Sexo: </label> 
									<c:forEach items="${listaSexo}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.sexo}">
													<input type="radio" name="radioSexo" id="sexo${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioSexo" id="sexo${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="form-group">
									<label for="imovel">Estado Civil: </label> 
									<c:forEach items="${listaEstadoCivil}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.idEstadoCivil}">
													<input type="radio" name="radioEstadoCivil" id="estCivil${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioEstadoCivil" id="estCivil${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="telefone">Telefone Resid&ecirc;ncial</label> 
									<input type="text" class="form-control input-sm" name="telefone" id="telefone" maxlength="13" value="${modelo.telRes}"  />
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="celular">Celular</label> 
									<input type="text" class="form-control input-sm" name="celular" id="celular" maxlength="14" value="${modelo.telCel}"  />
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="form-group">
									<label for="email">E-mail</label> 
									<input type="email" class="form-control input-sm" name="email" id="email" maxlength="50" value="${modelo.email}"  />
								</div>
							</div>
							
							<div class="col-sm-10">
								<div class="form-group">
									<label for="endereco">Endere&ccedil;o</label> 
									<input type="text" class="form-control input-sm" name="endereco" id="endereco" maxlength="100" value="${modelo.endereco}"  />
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="numeroAtualEndereco">N&deg; Atual</label> 
									<input type="number" class="form-control input-sm" name="numeroAtualEndereco" id="numeroAtualEndereco" max="99999" value="${modelo.numAtual}"  />
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="numeroAntigoEndereco">N&deg; Antigo</label> 
									<input type="number" class="form-control input-sm" name="numeroAntigoEndereco" id="numeroAntigoEndereco" max="99999" value="${modelo.numAntigo}"  />
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="complementoEndereco">Complemento</label> 
									<input type="text" class="form-control input-sm" name="complementoEndereco" id="complementoEndereco" maxlength="30" value="${modelo.compl}"  />
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="form-group">
									<label for="bairroEndereco">Bairro</label> 
									<input type="text" class="form-control input-sm" name="bairroEndereco" id="bairroEndereco" maxlength="30" value="${modelo.bairro}"  />
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="municipioEndereco">Munic&iacute;pio</label> 
									<input type="text" class="form-control input-sm" name="municipioEndereco" id="municipioEndereco" maxlength="100" value="${modelo.mun}"  />
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="estadoEndereco">Estado</label> 
									<input type="text" class="form-control input-sm" name="estadoEndereco" id="estadoEndereco" maxlength="30" value="${modelo.uf}"  />
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="cepEndereco">CEP</label> 
									<input type="text" class="form-control input-sm" name="cepEndereco" id="cepEndereco" maxlength="9" value="${modelo.cep}"  />
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="qtdeAdultos">Qtde. Adultos</label> 
									<input type="text" class="form-control input-sm" name="qtdeAdultos" id="qtdeAdultos" maxlength="2" value="${modelo.qtdeAdulto}"  />
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="qtdeCriancas">Qtde. Crian&ccedil;as</label> 
									<input type="text" class="form-control input-sm" name="qtdeCriancas" id="qtdeCriancas" maxlength="2" value="${modelo.qtdeCrianca}"  />
								</div>
							</div>
							
							<div class="col-sm-12"></div>
							
							<div class="col-sm-4">
								<div class="form-group">
									<label for="banco">Tem Conta Banc&oacute;ria: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.possuiConta}">
													<input type="radio" name="radioBanco" id="banco${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioBanco" id="banco${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<label for="cartaoDebito">Possui Cart&atilde;o de D&eacute;bito: </label>
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.possuiCDeb}">
													<input type="radio" name="radioCartaoDebito" id="cartaoDebito${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioCartaoDebito" id="cartaoDebito${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach> 
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="descBanco">Qual Banco</label> 
									<input type="text" class="form-control input-sm" name="descBanco" id="descBanco" maxlength="100" value="${modelo.banco}"  />
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="rendaFamilia">Renda Total da Fam&iacute;lia</label> 
									<input type="text" class="form-control input-sm" name="rendaFamilia" id="rendaFamilia" maxlength="16" value="${modelo.rendaTotal}"  />
								</div>
							</div>
	
							<div class="col-sm-6">
								<div class="form-group">
									<label for="financeiroMensal">Qual &eacute; o % M&eacute;dio de Comprometimento  Financeiro Mensal</label> 
									<input type="number" class="form-control input-sm" name="financeiroMensal" id="financeiroMensal" maxlength="2" value="${modelo.rendaPerceUtil}"  />
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label for="sel3">Meios de Transporte: </label> 
									<label class="checkbox-inline">
										<input type="checkbox" name="checkTransporteCarro" id="checkTransporteCarro" >Carro Pr&oacute;prio</input>
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" name="checkTransporteOnibus" id="checkTransporteOnibus" >&Ocirc;nibus</input>
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" name="checkTransporteTrem" id="checkTransporteTrem" >Trem</input>
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" name="checkTransporteMetro" id="checkTransporteMetro" >Metro</input>
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" name="checkTransporteTaxi" id="checkTransporteTaxi" >Taxi</input>
									</label>
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="form-group">
									<label for="cartaoDebito">Acesso a Internet: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.internetAcess}">
													<input type="radio" name="radioInternet" id="internet${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioInternet" id="internet${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="form-group">
									<label for="email">Tipo de Internet: </label> 
									<label class="checkbox-inline">
										<input type="checkbox" name="checkWifi" id="checkWifi" >WI-FI</input>
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" name="check3g" id="check3g" >3G</input>
									</label>
								</div>
							</div>
	
							<div class="col-sm-12"></div>
							
							<div class="col-sm-12">
								<label>Algum familiar que reside na moradia possui (Quantidade): </label> 
							</div>
							
							<div class="col-sm-1">
								<div class="form-group">
									<label for="carro">Carro</label> 
									<input type="number" class="form-control input-sm" name="qtdeCarro" id="qtdeCarro" placeholder="Digite a quantidade" maxlength="2" value="${modelo.qtdeCarro}" />
								</div>
							</div>
							
							<div class="col-sm-1">
								<div class="form-group">
									<label for="moto">Moto</label> 
									<input type="number" class="form-control input-sm" name="qtdeMoto" id="qtdeMoto" placeholder="Digite a quantidade" maxlength="2" value="${modelo.qtdeMoto}" />
								</div>
							</div>
							
							<div class="col-sm-1">
								<div class="form-group">
									<label for="bicicleta">Bicicleta</label> 
									<input type="number" class="form-control input-sm" name="qtdeBicicleta" id="qtdeBicicleta" placeholder="Digite a quantidade" maxlength="2" value="${modelo.qtdeBicicleta}" />
								</div>
							</div>
						</div>
					</div>
					
					<div class="panel panel-primary">
						<div class="panel-heading"><label>Benef&iacute;cios Sociais</label></div>
						<div class="panel-body">
							
							<div class="col-sm-6">
								<div class="form-group">
									<label for="numeroBPC">N&uacute;mero do Benef&iacute;cio (BENEF&Iacute;CIO DE PRESTA&Ccedil;&Atilde;O CONTINUADA-BPC)</label> 
									<input type="text" class="form-control input-sm" name="numeroBPC" id="numeroBPC" maxlength="50" value="${modelo.benefBCPNum}"  />
								</div>
							</div>
	
							<div class="col-sm-6">
								<div class="form-group">
									<label for="nis">NIS - N&uacute;mero de Inscri&ccedil;&atilde;o Social (CAD&Uacute;NICO)</label> 
									<input type="text" class="form-control input-sm" name="nis" id="nis" maxlength="50" value="${modelo.benefNISNum}"  />
								</div>
							</div>
	
							<div class="col-sm-4">
								<div class="form-group">
									<label for="cartaoDebito">Possui Tarifa Social de &Aacute;gua: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.possuiTarSocial}">
													<input type="radio" name="radioTarifaAgua" id="tarifaAgua${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioTarifaAgua" id="tarifaAgua${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
	
							<div class="col-sm-4">
								<div class="form-group">
									<label for="cartaoDebito">Bolsa Fam&iacute;lia: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.possuiBolsaFamil}">
													<input type="radio" name="radioBolsaFamilia" id="bolsaFamilia${total.id}" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioBolsaFamilia" id="bolsaFamilia${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
						</div>
					</div>
					
					<div class="panel panel-primary">
						<div class="panel-heading"><label>Dados Pessoais Benef&iacute;ciario N&atilde;o Titular</label></div>
						<div class="panel-body">
						
							<div class="col-sm-12">
								<div class="form-group">
									<label for="nomeNTitular">Nome Completo</label> 
									<input type="text" class="form-control input-sm" name="nomeNTitular" id="nomeNTitular" maxlength="100" value="${modelo.benefNome}" />
								</div>
							</div>
						
							<div class="col-sm-2">
								<div class="form-group">
									<label for="cpfNTitular">CPF</label> 
									<input type="text" class="form-control input-sm" name="cpfNTitular" id="cpfNTitular" maxlength="14" value="${modelo.benefCpf}" />
								</div>
							</div>
								
							<div class="col-sm-2">
								<div class="form-group">
									<label for="rgNTitular">RG</label> 
									<input type="text" class="form-control input-sm" name="rgCliente" id="rgCliente" maxlength="45" value="${modelo.benefRg}"  />
								</div>
							</div>
								
							<div class="col-sm-2">
								<div class="form-group">
									<label for="dtNascimentoNTitular">Data de Nascimento</label> 
									<input type="text" class="form-control input-sm" name="dtNascimentoNTitular" id="dtNascimentoNTitular" maxlength="10" value="${modelo.benefDtNasc}" data-date-format="DD/MM/YYYY" placeholder="dd/mm/aaaa"  />
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label for="sexoNTitular">Sexo: </label> 
									<c:forEach items="${listaSexo}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.benefSexo}">
													<input type="radio" name="radioSexoNTitular" id="sexo${total.id}NTitular" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioSexoNTitular" id="sexo${total.id}NTitular" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label for="observacoes">Observa&ccedil;&otilde;es</label> 
									<textarea class="form-control" rows="3" id="observacoes" style="resize:none;" >${modelo.benefObs}</textarea>
								</div>
							</div>
						</div>
					</div>
					
					<div class="panel panel-primary">
						<div class="panel-heading"><label>Membro Familiar Vulner&aacute;vel</label></div>
						<div class="panel-body">
						
							<div class="col-sm-2">
								<div class="form-group">
									<label for="qtdeIdosos">Idosos com idade de 60 anos ou mais</label> 
									<input type="number" class="form-control input-sm" name="qtdeIdosos" id="qtdeIdosos" placeholder="Digite a quantidade" maxlength="2" value="${modelo.maior59Qtde}" />
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="qtdeAdolescente">Adolescentes com idade de 18 anos ou menos</label> 
									<input type="number" class="form-control input-sm" name="qtdeAdolescente" id="qtdeAdolescente" placeholder="Digite a quantidade" maxlength="2" value="${modelo.menor19Qtde}" />
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="qtdeAdolescente">Bebes com menos de 12 meses de idade</label> 
									<input type="number" class="form-control input-sm" name="qtdeBebes" id="qtdeBebes" placeholder="Digite a quantidade" maxlength="2" value="${modelo.menor1Qtde}" />
								</div>
							</div>
							
							<div class="col-sm-12">
								<label>Pessoas com defici&ecirc;ncia: </label>
							</div>
							
							<div class="col-sm-12">
								<div class="col-sm-1" style="padding-top: 0.5%;">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkDefVisual" id="checkDefVisual" >Visual</input>
								    </label>
							    </div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="number" class="form-control input-sm" name="defVisual" id="defVisual" placeholder="Digite a quantidade" maxlength="2" value="${modelo.defVisualQtde}" />
									</div>
								</div>
						    </div>
							
							<div class="col-sm-12">
								<div class="col-sm-1" style="padding-top: 0.5%;">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkDefAuditivo" id="checkDefAuditivo" >Auditivo</input>
								    </label>
							    </div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="number" class="form-control input-sm" name="defAuditivo" id="defAuditivo" placeholder="Digite a quantidade" maxlength="2" value="${modelo.defAuditQtde}" />
									</div>
								</div>
						    </div>
							
							<div class="col-sm-12">
								<div class="col-sm-1" style="padding-top: 0.5%;">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkDefFisico" id="checkDefFisico" >F&iacute;sico</input>
								    </label>
							    </div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="number" class="form-control input-sm" name="defFisico" id="defFisico" placeholder="Digite a quantidade" maxlength="2" value="${modelo.defFisQtde}" />
									</div>
								</div>
						    </div>
							
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkDefIntelectual" id="checkDefIntelectual" >Defici&ecirc;ncia Intelectual</input>
								    </label>
							    </div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="number" class="form-control input-sm" name="defIntelectual" id="defIntelectual" placeholder="Digite a quantidade" maxlength="2" value="${modelo.defIntelecQtde}" />
									</div>
								</div>
						    </div>
							
							<div class="col-sm-12">
								<div class="col-sm-1" style="padding-top: 0.5%;">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkDefOutros" id="checkDefOutros" >Outros</input>
								    </label>
							    </div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="number" class="form-control input-sm" name="defOutros" id="defOutros" placeholder="Digite a quantidade" maxlength="2" value="${modelo.defOutrosQtde}" />
									</div>
								</div>
						    </div>
						    
						    <div class="col-sm-12">
								<div class="form-group">
									<label for="tratamento">Membro Fam&iacute;lia em Tratamento: </label> 
									<label class="radio-inline">
										<input type="radio" name="radioTratamento" id="tratamentoSim" >Sim </input>
									</label> 
									<label class="radio-inline">
										<input type="radio" name="radioTratamento" id="tratamentoNao" >N&atilde;o </input>
									</label> 
								</div>
							</div>
						
							<div class="col-sm-12">
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkCancer" id="checkCancer" >C&acirc;ncer</input>
							    </label>
							</div> 
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkHanseniase" id="checkHanseniase" >Hansen&iacute;ase</input>
							    </label>
							</div> 
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkMental" id="checkMental" >Aliena&ccedil;&atilde;o Mental</input>
							    </label>
							</div> 
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkEsclerose" id="checkEsclerose" >Esclerose M&uacute;ltipla</input>
							    </label>
							</div> 
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkParalisia" id="checkParalisia" >Paralisia Irrevers&iacute;vel ou Incapacitante</input>
							    </label>
							</div> 
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkHepatica" id="checkHepatica" >Doen&ccedil;as Hep&aacute;ticas (F&iacute;gado)</input>
							    </label>
							</div> 
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkCardiaca" id="checkCardiaca" >Doen&ccedil;as Card&iacute;acas</input>
							    </label>
							</div> 
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkParkinson" id="checkParkinson" >Doen&ccedil;as de Parkinson</input>
							    </label>
							</div> 
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkRenais" id="checkRenais" >Doen&ccedil;as Renais (Rins)</input>
							    </label>
						    </div>
						    
						    <div class="col-sm-12">
								<div class="form-group">
									<label for="outroDoenca">Outro</label> 
									<textarea class="form-control" rows="3" id="outroDoenca" style="resize:none;" >${modelo.tratOutroDesc}</textarea>
								</div>
							</div>
	
							<div class="col-sm-12">
								<label>O Entrevistado ou Algum Membro Da Familia J&aacute; Teve Alguma Das Doen&ccedil;as Listadas Abaixo: </label> 
							</div>
							
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkAmebiase" id="checkAmebiase" >Ameb&iacute;ase</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="amebiase" id="amebiase" placeholder="Membro Familiar" maxlength="100" value="${modelo.amebiaseMemb}" />
									</div>
								</div>
						    </div>
							
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkGastroenterite" id="checkGastroenterite" >Gastroenterite</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="gastroenterite" id="gastroenterite" placeholder="Membro Familiar" maxlength="100" value="${modelo.gastroentMemb}" />
									</div>
								</div>
						    </div>
							
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkGiardiase" id="checkGiardiase" >Giard&iacute;ase e Criptosporid&iacute;ase</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="giardiase" id="giardiase" placeholder="Membro Familiar" maxlength="100" value="${modelo.giardiaseMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkTifoide" id="checkTifoide" >Febres Tif&oacute;ide e Paratif&oacute;ide</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="tifoide" id="tifoide" placeholder="Membro Familiar" maxlength="100" value="${modelo.febreTifoMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkHepatite" id="checkHepatite" >Hepatite Infecciosa</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="hepatite" id="hepatite" placeholder="Membro Familiar" maxlength="100" value="${modelo.hepatiteMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkColera" id="checkColera" >C&oacute;lera</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="colera" id="colera" placeholder="Membro Familiar" maxlength="100" value="${modelo.coleraMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkEsquistossomose" id="checkEsquistossomose" >Esquistossomose (XISTOSA)</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="esquistossomose" id="esquistossomose" placeholder="Membro Familiar" maxlength="100" value="${modelo.esquitossoMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkAscaridiase" id="checkAscaridiase" >Ascarid&iacute;ase (Lombrigas ou Bichas)</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="ascaridiase" id="ascaridiase" placeholder="Membro Familiar" maxlength="100" value="${modelo.ascaridiaseMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkTeniase" id="checkTeniase" >Ten&iacute;ase (Solit&aacute;ria)</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="teniase" id="teniase" placeholder="Membro Familiar" maxlength="100" value="${modelo.teniaseMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkLeptospirose" id="checkLeptospirose" >Leptospirose</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="leptospirose" id="leptospirose" placeholder="Membro Familiar" maxlength="100" value="${modelo.leptospiroseMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkMalaria" id="checkMalaria" >Mal&aacute;ria</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="malaria" id="malaria" placeholder="Membro Familiar" maxlength="100" value="${modelo.malariaMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkDengue" id="checkDengue" >Dengue</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="dengue" id="dengue" placeholder="Membro Familiar" maxlength="100" value="${modelo.dengueMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline"> 
								    	<input type="checkbox" name="checkFebreAmarela" id="checkFebreAmarela" >Febre Amarela</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="febreAmarela" id="febreAmarela" placeholder="Membro Familiar" maxlength="100" value="${modelo.febreAmarMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkChikungunya" id="checkChikungunya" >Chikungunya</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="chikungunya" id="chikungunya" placeholder="Membro Familiar" maxlength="100" value="${modelo.chikungMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkZika" id="checkZika" >Zika V&iacute;rus</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="zika" id="zika" placeholder="Membro Familiar" maxlength="100" value="${modelo.zicaVirusMemb}" />
									</div>
								</div>
						    </div>
						    
							<div class="col-sm-12">
								<div class="col-sm-3" style="padding-top: 0.5%;">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkCianobacterias" id="checkCianobacterias" >Cianobact&eacute;rias</input>
								    </label>
							    </div>
							    <div class="col-sm-3">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="cianobacterias" id="cianobacterias" placeholder="Membro Familiar" maxlength="100" value="${modelo.cianobacterMemb}" />
									</div>
								</div>
						    </div>
						</div>
					</div>
					
					<div class="panel panel-primary">
						<div class="panel-heading"><label>Detalhamento de Recebimento Financeiro</label></div>
						<div class="panel-body">
							<div class="col-sm-12">
								<div class="col-sm-4">
									<label class="checkbox-inline">
							    		<input type="checkbox" name="checkDoacao" id="checkDoacao" >Ajuda ou Doa&ccedil;&atilde;o</input>
							    	</label>
						    	</div>
						    	<div class="col-sm-2">
									<div class="form-group">
										<input type="number" class="form-control input-sm" name="valorDoacao" id="valorDoacao" placeholder="Valor R$" maxlength="16" value="${modelo.valDoacao}" />
									</div>
								</div>
						  	</div> 
							<div class="col-sm-12"> 
								<div class="col-sm-6">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkAposentadoria" id="checkAposentadoria" >Aposentadoria, Pens&atilde;o, Benef&iacute;cio de Presta&ccedil;&atilde;o Continuada-BPC</input>
								    </label>
								</div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="valorAposentadoria" id="valorAposentadoria" placeholder="Valor R$" maxlength="16" value="${modelo.valAposent}" />
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="col-sm-4">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkPensao" id="checkPensao" >Pens&atilde;o Aliment&iacute;cia</input>
								    </label>
							    </div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="valorPensao" id="valorPensao" placeholder="Valor R$" maxlength="16" value="${modelo.valPensaoAlimen}" />
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="col-sm-4">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkSeguroDesemp" id="checkSeguroDesemp" >Seguro Desemprego</input>
								    </label>
							    </div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="valorSeguroDesemp" id="valorSeguroDesemp" placeholder="Valor R$" maxlength="16" value="${modelo.valSegDesempr}" />
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="col-sm-4">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkSemCarteira" id="checkSemCarteira" >Empregado sem Carteira Assinada</input>
								    </label>
							    </div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="number" class="form-control input-sm" name="valorSemCarteira" id="valorSemCarteira" placeholder="Valor R$" maxlength="16" value="${modelo.valEmprInformal}" />
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="col-sm-4">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkComCarteira" id="checkComCarteira" >Empregado com Carteira Assinada</input>
								    </label>
							    </div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="valorComCarteira" id="valorComCarteira" placeholder="Valor R$" maxlength="16" value="${modelo.valEmprFormal}" />
									</div>
								</div>
						    </div>
							<div class="col-sm-12">
								<div class="col-sm-4">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkBolsaFamilia" id="checkBolsaFamilia" >Bolsa Familia</input>
								    </label>
							    </div>
							    <div class="col-sm-2">
									<div class="form-group">
										<input type="text" class="form-control input-sm" name="valorBolsaFamilia" id="valorBolsaFamilia" placeholder="Valor R$" maxlength="16" value="${modelo.valBolsaFamil}" />
									</div>
								</div>
						    </div>
						    
						    <div class="col-sm-12">
						    	<div class="col-sm-4">
									<label class="checkbox-inline">
								    	<input type="checkbox" name="checkValorOutros" id="checkValorOutros" >Outro</input>
								    </label>
							    </div>
						    	<div class="col-sm-2">
									<div class="form-group">
										<input type="number" class="form-control input-sm" name="valorOutros" id="valorOutros" placeholder="Valor R$" maxlength="16" value="${modelo.valOutro}" />
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="qtdeAdolescente">Qual</label> 
									<input type="text" class="form-control input-sm" name="valorOutrosDesc" id="valorOutrosDesc" maxlength="60" value="${modelo.valOutroDescr}" />
								</div>
							</div>
							
						</div>
					</div>
					
					<div class="panel panel-primary">
						<div class="panel-heading"><label>Grau de Escolaridade</label></div>
						<div class="panel-body">
	
							<div class="col-sm-12">
								<div class="form-group">
									<label for="ler">Grau: </label> 
									<c:forEach items="${listaGrauEnsino}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.idGrauEscol}">
													<input type="radio" name="radioEnsino" id="ensino${total.descricao}r" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioEnsino" id="ensino${total.descricao}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
					    	<div class="col-sm-6">
						    	<div class="form-group">
						    		<label for="ler">Situa&ccedil;&atilde;o: </label> 
						    		<c:forEach items="${listaSituacaoEnsino}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.grauEscolCompl}">
													<input type="radio" name="radioEnsinoSituacao" id="ensino${total.id}r" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioEnsinoSituacao" id="ensino${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-12">
								<label>Se Analfabeto, informar: </label> 
							</div>
							
							<div class="col-sm-3">
								<div class="form-group">
									<label for="ler">Consegue Ler: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.sabeLer}">
													<input type="radio" name="radioConsegueLer" id="consegueLer${total.id}r" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioConsegueLer" id="consegueLer${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
	
							<div class="col-sm-3">
								<div class="form-group">
									<label for="ler">Consegue Escrever: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.sabeEscrever}">
													<input type="radio" name="radioConsegueEscrever" id="consegueEscrever${total.id}r" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioConsegueEscrever" id="consegueEscrever${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-12">
								<label>Grau de Escolaridade Dos Membros da Fam&iacute;lia: </label> 
							</div>
							
							<div class="col-sm-12">
								<label class="checkbox-inline">
						    		<input type="checkbox" name="checkEnsinoFundamentalMembro" id="checkEnsinoFundamentalMembro" >Ensino Fundamental</input>
						    	</label>
						  	</div> 
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkEnsinoMedioMembro" id="checkEnsinoMedioMembro" >Ensino M&eacute;dio</input>
							    </label>
							</div>
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkEnsinoTecnicoMembro" id="checkEnsinoTecnicoMembro" >Especializa&ccedil;&atilde;o (Cursos T&eacute;cnicos)</input>
							    </label>
							</div>
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkEnsinoSuperiorMembro" id="checkEnsinoSuperiorMembro" >Ensino Superior</input>
							    </label>
							</div>
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkEnsinoGraduacaoMembro" id="checkEnsinoGraduacaoMembro" >P&oacute;s Gradua&ccedil;&atilde;o</input>
							    </label>
							</div>
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkEnsinoAnalfabetoMembro" id="checkEnsinoAnalfabetoMembro" >Analfabeto</input>
							    </label>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label for="profissaoResponsavel">Qual &eacute; a Profiss&atilde;o do Membro da Fam&iacute;lia Respons&aacute;vel pela Resid&ecirc;ncia</label> 
									<input type="text" class="form-control input-sm" name="profissaoResponsavel" id="profissaoResponsavel" maxlength="60" value="${modelo.profissRespFamil}"  />
								</div>
							</div>
							
						</div>
					</div>
					
					<div class="panel panel-primary">
						<div class="panel-heading"><label>Negocia&ccedil;&atilde;o</label></div>
						<div class="panel-body">
						
							<div class="col-sm-12">
								<label>Negocia&ccedil;&atilde;o D&eacute;bitos Energia El&eacute;trica: </label> 
							</div>
						
							<div class="col-sm-12">
								<div class="form-group">
									<label for="negociacao">Existe Negocia&ccedil;&atilde;o De D&eacute;bitos em Aberto: </label> 
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.energNegoc}">
													<input type="radio" name="radioNegociacaoEnergia" id="negociacaoEnergia${total.id}r" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioNegociacaoEnergia" id="negociacaoEnergia${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach>
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="qtdeParcelaEnergia">Qtde de Parcelas</label> 
									<input type="number" class="form-control input-sm" name="qtdeParcelaEnergia" id="qtdeParcelaEnergia" maxlength="2" value="${modelo.energNegocParcQtde}" /> 
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="valorParcelaEnergia">Valor da Parcela</label> 
									<input type="text" class="form-control input-sm" name="valorParcelaEnergia" id="valorParcelaEnergia" maxlength="16" value="${modelo.energNegocParcVal}" /> 
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="diaParcelaEnergia">Dia do Vencimento</label> 
									<input type="number" class="form-control input-sm" name="diaParcelaEnergia" id="diaParcelaEnergia" maxlength="2" value="${modelo.energNegocDia}" /> 
								</div>
							</div>
						
							<div class="col-sm-12">
								<label>Negocia&ccedil;&atilde;o D&eacute;bitos Ligacao de &Aacute;gua: </label>
							</div>
						
							<div class="col-sm-12">
								<div class="form-group">
									<label for="negociacao">Existe Negocia&ccedil;&atilde;o De D&eacute;bitos em Aberto: </label>
									<c:forEach items="${listaSimNao}" var="total">
										<label class="radio-inline">
											<c:choose>
												<c:when test="${total.id == modelo.aguaNegoc}">
													<input type="radio" name="radioNegociacaoAgua" id="negociacaoAgua${total.id}r" checked="true" >${total.descricao} </input>
												</c:when>
												<c:otherwise>
													<input type="radio" name="radioNegociacaoAgua" id="negociacaoAgua${total.id}" >${total.descricao} </input>
												</c:otherwise>
											</c:choose>
										</label> 
									</c:forEach> 
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="qtdeParcelaAgua">Qtde de Parcelas</label> 
									<input type="number" class="form-control input-sm" name="qtdeParcelaAgua" id="qtdeParcelaAgua" maxlength="2" value="${modelo.aguaNegocParcQtde}" /> 
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="valorParcelaAgua">Valor da Parcela</label> 
									<input type="text" class="form-control input-sm" name="valorParcelaAgua" id="valorParcelaAgua" maxlength="16" value="${modelo.aguaNegocParcVal}" /> 
								</div>
							</div>
							
							<div class="col-sm-2">
								<div class="form-group">
									<label for="diaParcelaAgua">Dia do Vencimento</label> 
									<input type="number" class="form-control input-sm" name="diaParcelaAgua" id="diaParcelaAgua" maxlength="2" value="${modelo.aguaNegocDia}" /> 
								</div>
							</div>
						</div>
					</div>
						
					<div class="panel panel-primary">
						<div class="panel-heading"><label>Demais Informa&ccedil;&otilde;es</label></div>
						<div class="panel-body">
							
							<div class="col-sm-10">
								<div class="form-group">
									<label for="empresaExecutar">Tem Conhecimento de Alguma Obra de Saneamento que Acontecer&aacute; na &Aacute;rea em que Reside? Qual Empresa ir&aacute; Executar?</label> 
									<input type="text" class="form-control input-sm" name="empresaExecutar" id="empresaExecutar" maxlength="100" value="${modelo.obraSaneamConhe}" /> 
								</div>
							</div>
							
							<div class="col-sm-12">
								<label>Quais os Benef&iacute;cios que voc&ecirc; Acredita que as Obras de Saneamento Podem Trazer para a Comunidade?</label> 
							</div>
							
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkBeneficioPrevencaoDoenca" id="checkBeneficioPrevencaoDoenca" >Preven&ccedil;&atilde;o de Doen&ccedil;as e Promoc&atilde;o da Sa&uacute;de</input>
							    </label>
							</div>
							
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkBeneficioFortalecimento" id="checkBeneficioFortalecimento" >Fortalecimento da Economia Local</input>
							    </label>
							</div>
							
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkBeneficioValorizacaoImovel" id="checkBeneficioValorizacaoImovel" >Valoriza&ccedil;&atilde;o Imobili&aacute;ria</input>
							    </label>
							</div>
							
							<div class="col-sm-12"> 
								<label class="checkbox-inline">
							    	<input type="checkbox" name="checkBeneficioValorizacaoTurismo" id="checkBeneficioValorizacaoTurismo" >Valoriza&ccedil;&atilde;o do Turismo Local</input>
							    </label>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<label>Observa&ccedil;&otilde;es</label> 
									<textarea class="form-control" rows="3" id="observacoesInformacoes" style="resize:none;" >${modelo.obsGerais}</textarea>
								</div>
							</div>
					
						</div>
					</div>
					
					
				</div>
				<div class="form-group">
			    	<div class="col-sm-offset-10 col-sm-10">
			        	<button type="submit" class="btn btn-primary btn-primary">${botao}</button>
			      	</div>
			    </div>
			</form>
		</div>
		
        <footer class="footer">
            <div class="container text-center">
                <p class="text-muted">©Copyright 2018</p>
            </div>
        </footer>
        
        <script type="text/javascript">
            $(function () {
                $('#dtExecucao').datetimepicker();
                $('#dtNascimento').datetimepicker();
                $('#dtNascimentoNTitular').datetimepicker();
            });
        </script>
    </body>
</html>