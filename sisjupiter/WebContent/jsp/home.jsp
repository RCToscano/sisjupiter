
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
    </head>
    <body>
        <jsp:include page="/menu/${sessionScope.user.perfil.menu}" ></jsp:include>
        <div class="container">
        
		<div class="row">
			<div class="col-sm-4 col-md-3">
				<div class="thumbnail">
					<div class="caption">
						<h3>Cadastro de Servi&ccedil;os</h3>
						<p>Cadastre os servi&ccedil;os executados em campo.</p>
						<p><a href="ServicoBO?acao=cadastrar" class="btn btn-primary" role="button">Acessar</a></p>
					</div>
				</div>
			</div>
			<div class="col-sm-4 col-md-3">
				<div class="thumbnail">
					<div class="caption">
						<h3>Consulta de Servi&ccedil;os</h3>
						<p>Pesquise por per&iacute;odo de execu&ccedil;&atilde;o ou cliente.</p>
						<p><a href="ServicoBO?acao=consultar" class="btn btn-primary" role="button">Acessar</a></p>
					</div>
				</div>
			</div>
			<div class="col-sm-4 col-md-3">
				<div class="thumbnail">
					<div class="caption">
						<h3>Relat&oacute;rio Di&aacute;rio</h3>
						<p>Veja o relat&oacute;rio di&aacute;rio de execu&ccedil;&otilde;es dos servi&ccedil;os.</p>
						<p><a href="#" class="btn btn-primary" role="button" disabled>Acessar</a></p>
					</div>
				</div>
			</div>
			<div class="col-sm-4 col-md-3">
				<div class="thumbnail">
					<div class="caption">
						<h3>Gr&aacute;fico Di&aacute;rio</h3>
						<p>Veja o gr&aacute;fico di&aacute;rio de execu&ccedil;&otilde;es dos servi&ccedil;os.</p>
						<p><a href="#" class="btn btn-primary" role="button" disabled>Acessar</a></p>
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
