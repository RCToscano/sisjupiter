
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

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">RB Cuidadores</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Colaborador <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="ColabCadAlt?acao=1">Cadastrar Colaborador</a></li>
                        <li class="divider"></li>
                        <li><a href="ColabCadAlt?acao=consultar">Consultar Colaborador</a></li>
                        <li class="divider"></li>
                        <li><a href="ColabLista?acao=1">Listar Colaborador</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-submenu">
                            <a class="test" tabindex="-1" href="#">Registros de Valores <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a tabindex="-1" href="ColabRegValGer?acao=0">Cadastro</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="ColabRegValGer?acao=1">Consulta</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="ColabRegValGer?acao=5">Totais</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Assistido <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="AssistCadAlt?acao=1">Cadastrar Assistido</a></li>
                        <li class="divider"></li>
                        <li><a href="AssistLista?acao=1">Listar Assistido</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-submenu">
                            <a class="test" tabindex="-1" href="#">Avaliação Diagnóstica<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a tabindex="-1" href="AssistAvalDiag?acao=1">Cadastrar</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="AssistAvalDiag?acao=3">Consultar</a></li>
                            </ul>
                        </li>
                        <li class="divider"></li>
                        <li class="dropdown-submenu">
                            <a class="test" tabindex="-1" href="#">Contratos<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a tabindex="-1" href="ContratoCadAlt?acao=1">Cadastro / Alteração</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="ContratoCadAlt?acao=12">Lista</a></li>
                            </ul>
                        </li>
                        <li class="divider"></li>
                        <li class="dropdown-submenu">
                            <a class="test" tabindex="-1" href="#">Registros de Valores <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a tabindex="-1" href="ClienteRegValGer?acao=0">Cadastro</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="ClienteRegValGer?acao=1">Consulta</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="ClienteRegValGer?acao=5">Totais</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Adminstrativo <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="Ocorrencia?acao=14">Ocorrências</a></li>
                        <li class="divider"></li>
                        <li><a href="IndicacaoColabCliCons?acao=1">Consultar Indicação</a></li>
                        <li class="divider"></li>
                        <li><a href="EnvioEmail?acao=1">Escrever E-mail</a></li>
                        <li class="divider"></li>
                        <li><a href="Mapa?acao=1" target="_blank">Maps - Geral</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Escala<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="EscalaGer?acao=0" target="_blank">Programar</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-submenu">
                            <a class="test" tabindex="-1" href="#">Relatórios Escala <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a tabindex="-1" href="EscalaGer?acao=9">Lista Período</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="EscalaGer?acao=19">Lista Período Grupo</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="EscalaRelat?acao=5">Totais Colaborador</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="EscalaRelat?acao=7">Totais Assistido</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="EscalaRelat?acao=12">Totais Assistido Mensal</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="EscalaRelat?acao=9">Totais Assistido Plantão</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="EscalaGer?acao=11">Anotações</a></li>
                            </ul>
                        </li>
                        <li class="divider"></li>
                        <li><a href="EscalaGer?acao=16">Consultar Horário Saída</a></li>
                    </ul>
                </li>
                <li><a href="Login?r=logout">Sair</a></li>
            </ul>
<!--            <form id="signin" class="navbar-form navbar-right" role="form">
                <a href="#">Logout</a>
                <button type="submit" class="btn btn-primary btn-success">Logout</button>
            </form>-->
        </div>
    </div>
</nav>

<script>
    $(document).ready(function () {
        $('.dropdown-submenu a.test').on("click", function (e) {
            $(this).next('ul').toggle();
            e.stopPropagation();
            e.preventDefault();
        });
    });
</script>