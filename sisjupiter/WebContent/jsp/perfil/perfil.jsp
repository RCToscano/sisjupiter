
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
    </head>
    <body>
        <jsp:include page="/menu/${sessionScope.user.perfil.menu}" ></jsp:include>
        <div class="container">
        	<ul class="breadcrumb">
			    <li><a href="HomeBO?acao=home">Home</a></li>
			    <li class="active">Perfil</li>
			</ul>
			
			<c:if test="${aviso != ''}">
				<div class="alert alert-danger">
					<strong><c:out value="${aviso}"/></strong>
				</div>
			</c:if>
			
			<c:if test="${sucesso != ''}">
				<div class="alert alert-success">
					<strong><c:out value="${sucesso}"/></strong>
				</div>
			</c:if>
			
			<h2>Perfil do Usuário</h2>
        
			<div class="well col-md-4 col-md-offset-4">
			    <ul class="nav nav-tabs">
			      <li class="active"><a href="#perfil" data-toggle="tab">Perfil</a></li>
			      <li><a href="#senha" data-toggle="tab">Senha</a></li>
			    </ul>
			    <div id="myTabContent" class="tab-content">
			      <div class="tab-pane active in" id="perfil">
			      	<form action="UsuarioBO?acao=alterarPerfil" method="post" accept-charset="iso-8859-1,utf-8">
						<label style="padding-top: 5%;">Nome</label> 
						<input type="text" class="form-control input-sm" name="nome" id="nome" maxlength="100" value="${sessionScope.user.nome}" required/>
						<label>E-mail</label> 
						<input type="email" class="form-control input-sm" name="email" id="email" maxlength="100" value="${sessionScope.user.email}" required/>
						<label>Data de Nascimento</label> 
						<input type="text" class="form-control input-sm" name="dtNascimento" id="dtNascimento" maxlength="10" value="${sessionScope.user.dtNasc}" placeholder="dd/mm/aaaa" maxlength="10" required disabled/>
						<div class="text-center" style="padding-top: 5%;">
							<button type="submit" class="btn btn-primary">Alterar</button>
						</div>
					</form>
			      </div>
			      <div class="tab-pane fade" id="senha">
			    	<form action="UsuarioBO?acao=alterarSenha" method="post" accept-charset="iso-8859-1,utf-8">
			        	<label style="padding-top: 5%;">Nova Senha</label> 
						<input type="password" class="form-control input-sm" name="senha" id="senha" maxlength="50" required/>
						<div class="text-center" style="padding-top: 5%;">
							<button type="submit" class="btn btn-primary">Alterar</button>
						</div>
			    	</form>
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
