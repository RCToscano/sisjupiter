
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
			    <li class="active">Servi&ccedil;o</a></li>
			    <li class="active">Consulta</li>
			</ul>
			
			<div id="divAviso" name="divAviso" class="alert alert-danger" style="display:${display};">
				<strong><label id='aviso' name='aviso'/>${aviso}</strong>
			</div>

			<c:if test="${informacao != ''}">
				<div class="alert alert-warning">
					<strong><c:out value="${informacao}"/></strong>
				</div>
			</c:if>
		
			
			<h2>Consulta de Servi&ccedil;o</h2>
			
			<div class="alert alert-info">
				<strong>Informação!</strong> 
				Você pode escolher um ou mais campos abaixo para consultar, mas pelo menos um deverá ser preenchido.
			</div>
			
			
			<form action="ServicoBO?acao=pesquisar" method="post" accept-charset="iso-8859-1,utf-8" onSubmit="return validaForm()">
				<div class="form-inline col-sm-12" style="padding-bottom: 1%;">
					<label for="email">Período de</label> 
					<input type="text" class="form-control input-sm" data-date-format="DD/MM/YYYY" name="dtInicio" id="dtInicio" placeholder="dd/mm/aaaa" maxlength="10" value="${dtInicio}"/>
					<label for="pwd">à</label> 
					<input type="text" class="form-control input-sm" data-date-format="DD/MM/YYYY" name="dtFim" id="dtFim" placeholder="dd/mm/aaaa" maxlength="10" value="${dtFim}"/>
				</div>
				
				<div class="col-sm-2">
					<div class="form-group">
						<label>CPF</label> 
						<input type="text" class="form-control input-sm" name="cpf" id="cpf" maxlength="14" value="${cpf}" onKeyPress="mascaraCpf(this)"/>
					</div>
				</div>
				
				<div class="col-sm-2">
					<div class="form-group">
						<label>RG</label> 
						<input type="text" class="form-control input-sm" name="rg" id="rg" maxlength="14" value="${rg}"/>
					</div>
				</div>
				
				<div class="col-sm-4">
					<div class="form-group">
						<label>Comunidade:</label> 
						<select class="form-control" name="comunidade" id="comunidade">
	                        <option value="" selected>Selecione...</option>
	                        <c:forEach var="listaComunidades" items="${listaComunidades}">
	                        	<c:choose>
	                             <c:when test="${comunidade == listaComunidades.idComunidade}">
	                                 <option value="${listaComunidades.idComunidade}" selected="true">${listaComunidades.nome}</option>
	                             </c:when>
	                             <c:otherwise>
	                             	<option value="${listaComunidades.idComunidade}" >${listaComunidades.nome}</option>
	                             </c:otherwise>
	                            </c:choose>
	                        </c:forEach>
	                    </select>
					</div>
				</div>
				
				<div class="col-sm-6">
					<div class="form-group">
						<label>Endere&ccedil;o</label> 
						<input type="text" class="form-control input-sm" name="endereco" id="endereco" maxlength="100" value="${endereco}"  />
					</div>
				</div>
				
				<div class="col-sm-12">
					<div class="form-group">
				    	<div class="text-center">
				        	<button type="submit" class="btn btn-primary">Consultar</button>
				      	</div>
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
                $('#dtInicio').datetimepicker({locale: 'pt-br'});
                $('#dtFim').datetimepicker({locale: 'pt-br'});
            });
        </script>
    </body>
</html>