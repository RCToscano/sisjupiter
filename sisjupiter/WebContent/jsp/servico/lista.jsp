
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
        <script src="http://malsup.github.io/jquery.blockUI.js"></script>
        <script src="http://malsup.github.io/jquery.form.js"></script>
        <script src='./js/funcoes.auxiliares.js'></script>
        <script src='./js/servico/lista.js'></script>
    </head>
    <body>
    	<jsp:include page="../../menu/${sessionScope.user.perfil.menu}" ></jsp:include>
    	<div class="container">
	    	<ul class="breadcrumb">
			    <li><a href="HomeBO?acao=home">Home</a></li>
			    <li><a href="ServicoBO?acao=consultar">Servi&ccedil;o</a></li>
			    <li><a href="ServicoBO?acao=consultar">Consulta</a></li>
			    <li class="active">Lista</li>
			</ul>
			
			<c:if test="${aviso != ''}">
				<div class="alert alert-danger">
					<strong><c:out value="${aviso}"/></strong>
				</div>
			</c:if>
		
			<h2>Lista de Execu&ccedil;&otilde;es</h2>

			<form class="form-horizontal">
				<input type="hidden" id="dtInicio" name="dtInicio" value="${dtInicio}" />
				<input type="hidden" id="dtFim" name="dtFim" value="${dtFim}" />
				<input type="hidden" id="rg" name="rg" value="${rg}" />
				<input type="hidden" id="cpf" name="cpf" value="${cpf}" />
				<input type="hidden" id="comunidade" name="comunidade" value="${comunidade}" />
				<input type="hidden" id="endereco" name="endereco" value="${endereco}" />
				<input type="hidden" id="inicio" name="inicio" value="${inicio}" />
				<input type="hidden" id="fim" name="fim" value="${fim}" />
				<input type="hidden" id="paginaAtual" name="paginaAtual" value="1" />
				<input type="hidden" id="paginas" name="paginas" value="${paginas}" />
				<input type="hidden" id="qtdePaginas" name="qtdePaginas" value="${qtdePaginas}" />
			
				<input class="form-control" id="myInput" type="text" placeholder="Utilize para procurar..."></input> <br />
				<div class="table-responsive" id="divTable">
					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th style="width:0.5%;">Nº</th>
								<th style="width:15%;">Cliente</th>
								<th style="width:11%;">CPF</th>
								<th style="width:11%;">RG</th>
								<th style="width:25%;">Comunidade</th>
								<th style="width:25%;">Endere&ccedil;o</th>
								<th style="width:11%;">Data Execu&ccedil;&atilde;o</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="myTable">
							<% int cont = 1;%>
							<c:forEach items="${lista}" var="total">
								<c:url value="ServicoBO" var="link">
		                            <c:param name="acao" value="detalhe"/>
		                            <c:param name="id" value="${total.idDiagnostico}"/>
		                            <c:param name="dtInicio" value="${dtInicio}" />
									<c:param name="dtFim" value="${dtFim}" />
									<c:param name="rg" value="${rg}" />
									<c:param name="cpf" value="${cpf}" />
									<c:param name="comunidade" value="${comunidade}" />
									<c:param name="endereco" value="${endereco}" />
									<c:param name="inicio" value="${inicio}" />
									<c:param name="fim" value="${fim}" />
		                        </c:url>
								<tr>
									<td><%=cont%></td>
									<td><small>${total.nomeCliente}</small></td>
									<td><small>${total.cpf}</small></td>
									<td><small>${total.rg}</small></td>
									<td><small>${total.nomeComunidade}</small></td>
									<td><small>${total.endereco}</small></td>
									<td><small>${total.dataExecucao}</small></td>
									<td>
										<a href="${link}">
											<button type="button" class="btn btn-info btn-sm" title="Clique para visualizar o detalhe do serviço">
												<span class="glyphicon glyphicon-search"></span>
											</button>
										</a>
									</td>
								</tr>
								<%cont++;%>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div class="text-center" id="divPaginacao">
					<ul class="pagination">
						<li class="previous disabled"><a href="#">Anterior</a></li>
						<c:forEach items="${paginas}" var="total">
							<c:choose>
								<c:when test="${total == 1}">
									<li class="active"><a href="javascript:void(0)" onclick="paginar(${total});">${total}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="javascript:void(0)" onclick="paginar(${total});">${total}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					  	<li class="next"><a href="javascript:void(0)" onclick="paginarProximo();">Próximo</a></li>
					</ul>
				</div>
				
			</form>
		</div>
		
		<footer class="footer">
			<div class="container text-center">
				<p class="text-muted">©Copyright 2018</p>
            </div>
        </footer>
        
        <script>
        	$(document).ready(function(){
			  $("#myInput").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#myTable tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			});
        
	        jQuery(document).ready(function($) {
	            $(".clickable-row").click(function() {
	                window.location = $(this).data("href");
	            });
	        });
	        
	        $(document).ready(function(){
	            $('[data-toggle="tooltip"]').tooltip(); 
	        });
		</script>
    </body>
</html>
