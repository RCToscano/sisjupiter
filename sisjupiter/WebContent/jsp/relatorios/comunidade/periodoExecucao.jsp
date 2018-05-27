
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
        
        
    </head>
    <body>
    	<jsp:include page="../../../menu/${sessionScope.user.perfil.menu}" ></jsp:include>
    	<div class="container">
	    	<ul class="breadcrumb">
			    <li><a href="HomeBO?acao=home">Home</a></li>
			    <li class="active">Relatórios</a></li>
			    <li class="active">Período Execução Comunidade</li>
			</ul>
			
			<div class="col-md-8 col-md-offset-2">
				<div id="divAviso" name="divAviso" class="alert alert-danger" style="display:${display};">
					<strong><label id='aviso' name='aviso'/>${aviso}</strong>
				</div>
				
				<c:if test="${not empty sucesso}">
					<div class="alert alert-success">
						<strong><c:out value="${sucesso}"/></strong>
					</div>
				</c:if>
				
				<c:if test="${not empty informacao}">
					<div class="alert alert-warning">
						<strong><c:out value="${informacao}"/></strong>
					</div>
				</c:if>
		
				<legend class="text-left">Período de Execução por Comunidade</legend>
			
				<form action="RelComunidadeBO?acao=periodoExecucao" method="post">
					<div class="form-inline col-sm-12" style="padding-bottom: 1%;">
						<label for="email">Período de</label> 
						<input type="text" class="form-control input-sm" data-date-format="DD/MM/YYYY" name="dtInicio" id="dtInicio" placeholder="dd/mm/aaaa" maxlength="10" value="${dtInicio}" required/>
						<label for="pwd">à</label> 
						<input type="text" class="form-control input-sm" data-date-format="DD/MM/YYYY" name="dtFim" id="dtFim" placeholder="dd/mm/aaaa" maxlength="10" value="${dtFim}" required/>
				        <button type="submit" class="btn btn-primary btn-primary">Consultar</button>
					</div>
				</form>
			
			</div>
			
			<c:if test="${not empty lista}">
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<div class="table-responsive" id="divTable">
							<table class="table table-hover">
							    <thead>
							        <tr>
							            <th>Nº</th>
							            <th>Comunidade</th>
							            <th>Quantidade</th>
							        </tr>
							    </thead>
							    <tbody>
							    	<% int cont = 1;%>
							    	<c:forEach items="${lista}" var="total">
								        <tr>
								            <td><%=cont%></td>
								            <td>${total.nomeComunidade}</td>
								            <td>${total.qtde}</td>
								        </tr>
								       	<%cont++;%>
							        </c:forEach>
							        <tr class="active">
							            <td colspan="2"><strong>Total</strong></td>
							            <td><strong>${totalComunidade}</strong></td>
							        </tr>
									<tr> 
										<td colspan="3" style="text-align: center"> 
											<form action="RelComunidadeBO?acao=graficoPeriodo" method="post" target="_blank"> 
												<input type="hidden" id="dtInicio" name="dtInicio" value="${dtInicio}"/>
												<input type="hidden" id="dtFim" name="dtFim" value="${dtFim}"/>
												<button type="submit" class="btn btn-warning"> 
													<i class="fa fa-bar-chart"></i> Gráfico 
												</button> 
											</form> 
										</td> 
									</tr> 
							    </tbody>
							</table>
						</div>
					</div>
				</div>
			</c:if>
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