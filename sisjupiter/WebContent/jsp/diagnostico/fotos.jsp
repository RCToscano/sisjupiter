
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>Deep</title>
        <link rel="icon" type="image/png" sizes="32x32" href="./images/favicon-32x32.png"/>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="./css/menucustomcolor.css" rel="stylesheet"/>
        <link href="./css/footercustom.css" rel="stylesheet"/>
        <script src="./js/jquery-1.11.3.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css" />
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
		<script type="text/javascript" src="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>
        <script src='./js/funcoes.auxiliares.js'></script>
        <script src='./js/servico/consulta.js'></script>
    </head>
    <body>
    	<jsp:include page="../../menu/${sessionScope.user.perfil.menu}" ></jsp:include>
    	<div class="container">
	    	<ul class="breadcrumb">
			    <li><a href="HomeBO?acao=home">Home</a></li>
			    <li class="active">Diagnóstico</li>
			    <li class="active">Fotos</li>
			</ul>
			
			<div id="divAviso" name="divAviso" class="alert alert-danger" style="display:${display};">
				<strong><label id='aviso' name='aviso'/>${aviso}</strong>
			</div>

			<c:if test="${not empty informacao}">
				<div class="alert alert-warning">
					<strong><c:out value="${informacao}"/></strong>
				</div>
			</c:if>
		
			
			<h2>Fotos do Diagnóstico ${idDiagnostico}</h2>
			

			<div class="panel-group">
				
				<div class="panel panel-primary">
					<div class="panel-heading"><label>Informações do Servi&ccedil;o</label></div>
					<div class="panel-body">
					
						<div class="col-sm-2">
							<div class="form-group">
								<label for="id">ID: </label> 
								<input type="text" class="form-control input-sm" name="id" id="id" value="${idDiagnostico}" disabled />
							</div>
						</div>
					
						<div class="col-sm-6">
							<div class="form-group">
								<label for="sel1">Cadastrante *:</label> 
								<select class="form-control" name="cadastrante" id="cadastrante" disabled>
                                	<option value="" selected>Selecione...</option>
                                    <c:forEach var="listaEquipe" items="${listaEquipe}">
                                    	<c:choose>
	                                        <c:when test="${idEquipe == listaEquipe.idEquipe}">
	                                            <option value="${listaEquipe.idEquipe}" selected="true">${listaEquipe.equipe}</option>
	                                        </c:when>
                                        </c:choose>
                                    </c:forEach>
                                </select>
							</div>
						</div>
						
						<div class="col-sm-2">
							<div class="form-group">
								<label for="dtExecucao">Data de Execu&ccedil;&atilde;o *: </label> 
								<input type="text" class="form-control input-sm" name="dtExecucao" id="dtExecucao" data-date-format="DD/MM/YYYY" placeholder="dd/mm/aaaa" maxlength="10" value="${dtExecucao}" disabled />
							</div>
						</div>
						
					</div> <!-- Fim Painel Body -->
				</div> <!-- Fim Painel -->
				
				<c:choose>
					<c:when test="${empty listaFotos}">
						<div class="panel panel-primary">
							<div class="panel-body">
								<div class="col-sm-12">
									<div class="alert alert-warning">
										<strong>Nenhuma foto encontrada para o Diagnóstico</strong>
									</div>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<c:forEach var="foto" items="${listaFotos}">
							<div class="panel panel-primary">
								<div class="panel-body">
									<div class="col-sm-12 text-center">
										<img src="Serializacao?imagem=${foto.arquivo}" alt="" style="max-width: 100%; margin: 0px;"></img>
									</div>
								</div>
							</div>
		                </c:forEach>
					</c:otherwise>
				</c:choose>
			</div> <!-- Fim Painel -->
		</div>

		<footer class="footer">
			<div class="container text-center">
				<p class="text-muted">©Copyright 2018</p>
            </div>
        </footer>
        
        <script type="text/javascript">
            $(function () {
                $('#dtInicio').datetimepicker({locale: 'pt-br'});
                $('#dtFim').datetimepicker({locale: 'pt-br'});
            });
        </script>
    </body>
</html>