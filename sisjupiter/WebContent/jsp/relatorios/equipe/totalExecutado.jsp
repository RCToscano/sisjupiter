
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
       
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src="https://code.highcharts.com/highcharts.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
    </head>
    <body>
    	<jsp:include page="../../../menu/${sessionScope.user.perfil.menu}" ></jsp:include>
    	<div class="container">
	    	<ul class="breadcrumb">
			    <li><a href="HomeBO?acao=home">Home</a></li>
			    <li class="active">Relatórios</a></li>
			    <li class="active">Total Executado Equipe</li>
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
			
				<legend class="text-left">Total de Execuções por Equipe</legend>
				<div class="table-responsive" id="divTable">
					<table class="table table-hover">
					    <thead>
					        <tr>
					            <th>Nº</th>
					            <th>Equipe</th>
					            <th>Quantidade</th>
					            <th>Excel</th>
					        </tr>
					    </thead>
					    <tbody>
					    	<% int cont1 = 1;%>
					    	<c:forEach items="${listaEquipe}" var="total">
					    		<c:url value="RelEquipeBO" var="link">
		                            <c:param name="acao" value="excelEquipe"/>
									<c:param name="equipe" value="${total.idEquipe}" />
		                        </c:url>
						        <tr>
						            <td><%=cont1%></td>
						            <td>${total.nomeEquipe}</td>
						            <td>${total.qtde}</td>
						            <td>
										<a href="${link}">
											<button type="button" class="btn btn-info btn-sm" title="Clique para baixar em excel">
												<span class="glyphicon glyphicon-floppy-save"></span>
											</button>
										</a>
									</td>
						        </tr>
						       	<%cont1++;%>
					        </c:forEach>
					        <tr class="active">
					            <td colspan="2"><strong>Total</strong></td>
					            <td colspan="2"><strong>${totalEquipe}</strong></td>
					        </tr>
					    </tbody>
					</table>
				</div>
				
				<div class="col-sm-4">
					<div class="form-group">
				    	<div class="text-center">
				        	<form action="RelEquipeBO?acao=excelTotalDiag" method="post">
								<button type="submit" class="btn btn-warning"> 
									<i class="fa fa-bar-chart"></i> Gerar Excel com Diagnosticos
								</button> 
							</form>
				      	</div>
				    </div>
				</div>
				
				<div class="col-sm-4">
					<div class="form-group">
				    	<div class="text-center">
				        	<form action="RelEquipeBO?acao=excelTotal" method="post"> 
								<button type="submit" class="btn btn-warning"> 
									<i class="fa fa-bar-chart"></i> Gerar Excel com Totais
								</button> 
							</form>  
				      	</div>
				    </div>
				</div>
				
				<div class="col-sm-4">
					<div class="form-group">
				    	<div class="text-center">
				        	<form action="RelEquipeBO?acao=graficoTotal" method="post" target="_blank"> 
								<button type="submit" class="btn btn-warning"> 
									<i class="fa fa-bar-chart"></i> Visualizar Gráfico 
								</button> 
							</form> 
				      	</div>
				    </div>
				</div>
				
			</div>
		</div>
		<footer class="footer">
			<div class="container text-center">
				<p class="text-muted">©Copyright 2018</p>
            </div>
        </footer>
    </body>
</html>