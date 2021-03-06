
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<style>
    .dropdown-submenu {
        position: relative;
    }

    .dropdown-submenu .dropdown-menu {
        top: 0;
        left: 100%;
        margin-top: -1px;
    }
</style>
<div id="1">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="HomeBO?acao=home"style="padding: 8px;"><img src="./images/logo_deep_menu.png" alt="" style="margin: 0px;"></a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Diagnóstico <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="DiagnosticoBO?acao=consultar">Consultar</a></li>
                         <li class="divider"></li>
                        <li><a href="DiagnosticoBO?acao=cadastrar">Cadastrar</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav">
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Relatórios <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="RelComunidadeBO?acao=total">Total Executado por Comunidade</a></li>
                        <li class="divider"></li>
                        <li><a href="RelEquipeBO?acao=total">Total Executado por Equipe</a></li>
                        <li class="divider"></li>
                        <li><a href="RelComunidadeBO?acao=consultaPeriodo">Período Execução por Comunidade</a></li>
                        <li class="divider"></li>
                        <li><a href="RelEquipeBO?acao=consultaPeriodo">Período Execução por Equipe</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav">
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Mapas <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="MapaBO?acao=1" target="_blank">Diagnóstico / Comunidade</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
	        	<span class="navbar-text">Ol&aacute; ${sessionScope.user.nome}, seja bem-vindo!</span>
		    	<li><a href="UsuarioBO?acao=perfil"><span class="glyphicon glyphicon-user"></span> Perfil</a></li>
		    	<li><a href="Login?r=logout"><span class="glyphicon glyphicon-log-in"></span> Sair</a></li>
		    </ul>
        </div>
    </div>
</nav>
</div>

<script>
    $(document).ready(function () {
        $('.dropdown-submenu a.test').on("click", function (e) {
            $(this).next('ul').toggle();
            e.stopPropagation();
            e.preventDefault();
        });
    });
</script>