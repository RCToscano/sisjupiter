<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
        <meta charset="utf-8"/>
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"></link>
        
        <title>DiagsDeep</title>
        <style>
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }
            #map {
                height: 100%;
            }
            .collapse.in, .collapse{
                height: 300px;
                overflow-y: scroll;
            }
        </style>
    </head>
    <body>
        <div id="map"></div>
        <div id='divscript' style='background-color: #fff; position: absolute; top: 30px; min-width: 50px; right: 10px; z-index: 1; width: 5%;' >
            <a href="#" id="hrfiltros"><span class="label label-primary">F I L T R O S</span></a>
            <script>
                $('#divColaborador').animate({width: 'toggle'});
                $('#hrfiltros').click(function(){
                    $('#divColaborador').animate({width: 'toggle'});
                });
            </script>
        </div>    
        <div id='divColaborador' style='background-color: #fff; position: absolute; top: 50px; min-width: 400px; right: 10px; z-index: 1; width: 20%;' >
        	<div class="form-group">
				<label>Comunidade:</label> 
				<select class="form-control" name="idComunidade" id="idComunidade">
	                <option value="" selected>Selecione...</option>
	                <c:forEach var="comunidade" items="${listComunidade}">
	                    <option value="${comunidade.idComunidade}" >${comunidade.nome}</option>
	                </c:forEach>
              	</select>
                <div style="padding: 5px; text-align: center;">
                	<button type="button" class="btn btn-primary btn-xs" onclick="buscarDiagnostico()">Buscar Diagnóstico</button>
                </div>
			</div>
        
            <div class="panel-group" id="accordion" style="margin: 0px;">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapse0">Filtrar Exibição</a>
                        </h4>
                    </div>
                    <div id="collapse0" class="panel-collapse collapse">
                        <div class="panel-body" style="padding: 5px;">                            
                            Limpar Mapa
                            <a href="#" onclick="clearMarkers();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            Colaborador / Assistido Todos
                            <a href="#" onclick="initMap();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            Colaborador Todos
                            <a href="#" onclick="exibirColaboradorTodos();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Colaborador Ativos e Em Espera
                            <a href="#" onclick="exibirColaboradorAtivoEmEspera();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Colaborador Ativos
                            <a href="#" onclick="exibirColaboradorSituacao(1);return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Colaborador Em Espera
                            <a href="#" onclick="exibirColaboradorSituacao(3);return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Colaborador Indisponivel
                            <a href="#" onclick="exibirColaboradorSituacao(2);return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
<!--                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Colaborador em Espera
                            <a href="#" onclick="exibirColaboradorSituacao(3);return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>-->
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Colaborador Reprovado
                            <a href="#" onclick="exibirColaboradorSituacao(4);return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Colaborador Inativo
                            <a href="#" onclick="exibirColaboradorSituacao(5);return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Colaborador Afastado
                            <a href="#" onclick="exibirColaboradorSituacao(6);return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Colaborador Ativos em Espera
                            <a href="#" onclick="exibirColaboradorSituacao(7);return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            Assistidos Todos
                            <a href="#" onclick="exibirClienteTodos();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Ativos
                            <a href="#" onclick="exibirClienteAtivo();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Inativos
                            <a href="#" onclick="exibirClienteInativo();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Suspensos
                            <a href="#" onclick="exibirClienteSuspenso();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Internados
                            <a href="#" onclick="exibirClienteInternado();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Viajando
                            <a href="#" onclick="exibirClienteViagem();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                        <div class="panel-body" style="padding: 5px;">                            
                            &emsp;&emsp;Prospect
                            <a href="#" onclick="exibirClienteProspec();return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                        </div>
                    </div>
                </div>
                <% int cont=1;%>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Lista Colaborador</a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse">
                        <c:forEach var="colaborador" items="${listColaborador}">
                            <div class="panel-body" style="padding: 5px;">
                                <%=cont%> - ${colaborador.colaborador}
                                <a href="#" onclick="exibirColaboradorCpf('${colaborador.cpf}', '${colaborador.coordX}', '${colaborador.coordY}');return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                            </div>
                            <%cont++;%>
                        </c:forEach>
                    </div>
                </div>
                <% cont=1;%>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Lista Assistido</a>
                        </h4>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        <c:forEach var="cliente" items="${listCliente}">
                            <div class="panel-body" style="padding: 5px;">
                                <%=cont%> - ${cliente.nome}
                                <a href="#" onclick="exibirClienteCodigo('${cliente.codigo}', '${cliente.coordX}', '${cliente.coordY}');return false;"><span class='glyphicon glyphicon-map-marker text-danger'></span></a>
                            </div>
                            <%cont++;%>
                        </c:forEach>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Rotas</a>
                            <i class="material-icons" style="font-size:20px;color:blue">transfer_within_a_station</i>
                        </h4>
                    </div>
                    <div id="collapse3" class="panel-collapse collapse">
                        <div class="panel-body" style="padding: 5px;">
                            <label id="labela"></label>
                            <input type="hidden" name="inputacoordx" id="inputacoordx" value="" />
                            <input type="hidden" name="inputacoordy" id="inputacoordy" value="" />
                        </div>
                        <div class="panel-body" style="padding: 5px;">
                            <label id="labelb"></label>
                            <input type="hidden" name="inputbcoordx" id="inputbcoordx" value="" />
                            <input type="hidden" name="inputbcoordy" id="inputbcoordy" value="" />    
                        </div>
                        <div class="panel-body" style="padding: 5px;">
                            <button type="button" class="btn btn-danger btn-xs" onclick="limparRotas()">
                              <span class="glyphicon glyphicon-erase"></span> Limpar
                            </button>
                            &emsp;&emsp;
                            <button type="button" class="btn btn-primary btn-xs" onclick="abrirRota()">Ver Rotas</button>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <script>
        
        function listarCondominio() {

            var idComunidade = document.getElementById('idComunidade');

            if(idComunidade.value == '') {
            	
            	
            }
            else {
            	
//         	    $.blockUI({ 
//         	    	message: '<img src="./images/busy.gif" />',
//         	    	css: { 
//         	    		padding:        5,
//         	    		left:           '45%', 
//         	            width:          '10%', 
//         	            border:         '1px solid #aaa'
//         	        }         		
//         	    }); 
        	    
        	    $.ajax({
        	        url: 'MapaBO?acao=2' +
        	             '&idComunidade=' + idComunidade.value
        	        ,
        	        type: "POST",
        	        dataType: 'json',
        	        success: function(result) {
        	                        
        	            var listCondominio = result;
        	            if(listCondominio != null && listCondominio.length > 0) {
        	                for(i = 0; i < listCondominio.length; i++) {
        	                	var condominio = listCondominio[i];
        	                    $('#idCondominio').append('<option value=' + condominio.idCondominio + '>' + condominio.nome + '</option>');
        	                }
        	            }
        	            //$.unblockUI();
        	        },
        	        error : function(){
        	
        	            //$.unblockUI();
        	            alert('erro');
        	        }
        	    });    
        	}
        }
        

//             var listcolab = ${jsonColab};
//             var listcliente = ${jsonCli};
//             var listhospital = ${jsonHospital};
            var map;

            function initMap() {

                var myLatLng = {lat: -23.614233, lng: -46.662033};
                map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 12,
                    center: myLatLng
                });
                
                addPontoRB(map);
                
//                 //EXIBE COLABORADORE COM SITUACAO ATIVO E EM ESPERA
//                 for(i = 0; i < listcolab.length; i++){

//                     var colaborador = listcolab[i];

//                     if(Number(colaborador.idSituacaoColab) == Number(1)
//                         || Number(colaborador.idSituacaoColab) == Number(3)) {

//                         addPontoColaborador(map,colaborador);
//                     }
//                 }

//                 //EXIBE CLIENTES TODOS
//                 for (i = 0; i < listcliente.length; i++) {
                              
//                     var cliente = listcliente[i];    
                
//                     addPontoCliente(map,cliente);
//                 }
                
//                 //EXIBE HOSPITAIS TODOS
//                 for (i = 0; i < listhospital.length; i++) {
                              
//                     var hospital = listhospital[i];    
                
//                     addPontoHospitais(map,hospital)
//                 }
            }
            
            function addPontoRB(map) {

                var myLatLng = {lat: -23.591845, lng: -46.673831};
                var contentString =
                        '<div id="content">' +
                        '  <div id="siteNotice"></div>' +
                        '  <h4 id="firstHeading" class="firstHeading">RB - Escritório</h4>' +
                        '  <div id="bodyContent">' +
                        //'    <img src="http://www.w3schools.com/images/w3schools_green.jpg" alt="W3Schools.com">'+
                        //'    <p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large </p>'+
                        //'    <p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
                        //'    https://en.wikipedia.org/w/index.php?title=Uluru</a> </p>'+
                        '    <a href="#" onclick="guardarCoordenadas(\'Escritório\', \'Deep\', -23.614233, -46.662033); return false;">Rota</a></p>' +
                        '  </div>' +
                        '</div>';

                var infowindow = new google.maps.InfoWindow({
                    content: contentString
                });

                var image = './images/favicon-32x32.png';
                var marker = new google.maps.Marker({
                    position: myLatLng,
                    map: map,
                    icon: image,
                    title: 'Deep'
                });

                marker.addListener('click', function () {
                    infowindow.open(map, marker);
                });
            }
            
            function addPontoHospitais(map,hospital) {

                var image = './images/ic_hospital.png';
                
                var myLatLng1 = {lat: Number(hospital.coordX), lng: Number(hospital.coordY)};
                var marker1 = new google.maps.Marker({
                    position: myLatLng1,
                    map: map,
                    icon: image,
                    title: String(hospital.nome)
                });
                
                var contentString1 =
                        '<div id="content">' +
                        '  <div id="siteNotice"></div>' +
                        '  <div id="bodyContent">' +
                        '    <p><b>' + hospital.nome + '</b></p>' +
                        '    <p>' + hospital.endereco + ' ' + hospital.numero + ' ' + hospital.compl + '</p>' +
                        '    <p>' + hospital.bairro + ' - ' + hospital.cidade + ' - ' + hospital.cep + '</p>' +
                        '    <p>' + hospital.ddd + ' ' + hospital.tel + '</b></p>' +
                        '    <a href="#" onclick="guardarCoordenadas(\'*\', \'' + hospital.nome + '\', ' + hospital.coordX + ', ' + hospital.coordY + '); return false;">Rota</a></p>' +
                        '  </div>' +
                        '</div>';

                var infowindow1 = new google.maps.InfoWindow({
                    content: contentString1
                });
                marker1.addListener('click', function () {
                    infowindow1.open(map, marker1);
                });
            }
            
            function exibirHospitalTodos() {
                
                for (i = 0; i < listhospital.length; i++) {
                              
                    var hospital = listhospital[i];    
                
                    addPontoHospitais(map,hospital)
                }
            }
            
            function exibirColaboradorTodos() {
                
                clearMarkers();
                
                addPontoRB(map);
                exibirHospitalTodos();

                //EXIBE COLABORADORE COM SITUACAO ATIVO E EM ESPERA
                for (i = 0; i < listcolab.length; i++) {
                                       
                    var colaborador = listcolab[i];
                    
                    addPontoColaborador(map,colaborador);
                }
            }
            
            function exibirColaboradorSituacao(situacao) {

                clearMarkers();

                addPontoRB(map);
                exibirHospitalTodos();

                for (i = 0; i < listcolab.length; i++) {
                                       
                    var colaborador = listcolab[i];
                    
                    if(Number(colaborador.idSituacaoColab) == Number(situacao)) {
                    
                        addPontoColaborador(map,colaborador);
                    }    
                }
            }
            
            function exibirColaboradorAtivoEmEspera() {

                clearMarkers();

                addPontoRB(map);
                exibirHospitalTodos();

                for (i = 0; i < listcolab.length; i++) {
                                       
                    var colaborador = listcolab[i];                                       
                                       
                    if(Number(colaborador.idSituacaoColab) == Number(1)
                            || Number(colaborador.idSituacaoColab) == Number(3)) {
                    
                        addPontoColaborador(map,colaborador);
                    }    
                }
            }
            
            function exibirColaboradorCpf(cpf) {

                for (i = 0; i < listcolab.length; i++) {
                                       
                    var colaborador = listcolab[i];                                       
                                       
                    if(String(colaborador.cpf) == String(cpf)) {
                        
                        map.setCenter({lat:Number(colaborador.coordX), lng:Number(colaborador.coordY)});
                    
                        addPontoColaborador(map,colaborador);
                    }    
                }
            }

            function addPontoColaborador(map,colaborador) {

                var image;
                if (Number(colaborador.idSituacaoColab) == 1) {
                    image = './images/colab_ativo.png';
                }
                else if (Number(colaborador.idSituacaoColab) == 2) {
                    image = './images/colab_indisp.png';
                }
                else if (Number(colaborador.idSituacaoColab) == 3) {
                    image = './images/colab_espera.png';
                }
                else if (Number(colaborador.idSituacaoColab) == 4) {
                    image = './images/colab_reprovado.png';
                }
                else if (Number(colaborador.idSituacaoColab) == 5) {
                    image = './images/colab_inativo.png';
                }
                else if (Number(colaborador.idSituacaoColab) == 6) {
                    image = './images/colab_afastado.png';
                }
                else if (Number(colaborador.idSituacaoColab) == 7) {
                    image = './images/colab_ativoemespera.png';
                }

                var myLatLng1 = {lat: Number(colaborador.coordX), lng: Number(colaborador.coordY)};
                var marker1 = new google.maps.Marker({
                    position: myLatLng1,
                    map: map,
                    icon: image,
                    title: String(colaborador.colaborador)
                });
                
                var textoEscala = '';
                var listEscala = colaborador.listRelMapColabEscala;
                for(j = 0; j < listEscala.length; j++){
                    
                    var escala = listEscala[j];                    
                    textoEscala +=  escala.cliente + ' - ' + escala.dtInicio + ' - ' + escala.dtFim + '<br/>';
                }

                var contentString1 =
                        '<div id="content">' +
                        '  <div id="siteNotice"></div>' +
                        '  <div id="bodyContent">' +
                        //'    <img src="http://www.w3schools.com/images/w3schools_green.jpg" alt="W3Schools.com">'+
                        '    <p><b>Nome: </b> ' + colaborador.colaborador + ' </p>' +
                        '    <p><b>Idade: </b> ' + colaborador.idade + ' <b>Situação: </b> ' + colaborador.situacao + ' </p>' +
                        '    ' + textoEscala + ' </p>' +
                        '    <a href="ColabCadAlt?acao=2&cpf=' + colaborador.cpf + '" target="_blank">Cadastro</a>&emsp;&emsp;' +
                        '    <a href="#" onclick="guardarCoordenadas(\'Colaborador\', \'' + colaborador.colaborador + '\', ' + colaborador.coordX + ', ' + colaborador.coordY + '); return false;">Rota</a>' +
                        '  </div>' +
                        '</div>';

                var infowindow1 = new google.maps.InfoWindow({
                    content: contentString1
                });
                marker1.addListener('click', function () {
                    infowindow1.open(map, marker1);
                });
            }
            
            function exibirClienteTodos() {

                clearMarkers();
                
                addPontoRB();
                exibirHospitalTodos();
                
                for (i = 0; i < listcliente.length; i++) {
                                       
                    var cliente = listcliente[i];                   
                                       
                    addPontoCliente(map, cliente);
                }
            }
            
            function exibirClienteCodigo(codigo) {
              
                for (i = 0; i < listcliente.length; i++) {
                    
                    var cliente = listcliente[i]; 
                                       
                    if(String(cliente.codigo) == String(codigo)) {

                        map.setCenter({lat:Number(cliente.coordX), lng:Number(cliente.coordY)});
                        
                        addPontoCliente(map,cliente);
                    }
                }
            }
            
            function exibirClienteAtivo() {

                clearMarkers();

                addPontoRB(map);
                exibirHospitalTodos();

                for (i = 0; i < listcliente.length; i++) {
                                       
                    var cliente = listcliente[i];                                       
                                       
                    if(Number(cliente.idSituacaoCli) == Number(1)) {
                    
                        addPontoCliente(map,cliente);
                    }    
                }
            }
            
            function exibirClienteInativo() {

                clearMarkers();

                addPontoRB(map);
                exibirHospitalTodos();

                for (i = 0; i < listcliente.length; i++) {
                                       
                    var cliente = listcliente[i];                                       
                                       
                    if(Number(cliente.idSituacaoCli) == Number(2)) {
                    
                        addPontoCliente(map,cliente);
                    }    
                }
            }
            
            function exibirClienteSuspenso() {

                clearMarkers();

                addPontoRB(map);
                exibirHospitalTodos();

                for (i = 0; i < listcliente.length; i++) {
                                       
                    var cliente = listcliente[i];                                       
                                       
                    if(Number(cliente.idSituacaoCli) == Number(3)) {
                    
                        addPontoCliente(map,cliente);
                    }    
                }
            }
            
            function exibirClienteInternado() {

                clearMarkers();

                addPontoRB(map);
                exibirHospitalTodos();

                for (i = 0; i < listcliente.length; i++) {
                                       
                    var cliente = listcliente[i];                                       
                                       
                    if(Number(cliente.idSituacaoCli) == Number(4)) {
                    
                        addPontoCliente(map,cliente);
                    }    
                }
            }
            
            function exibirClienteViagem() {

                clearMarkers();

                addPontoRB(map);
                exibirHospitalTodos();

                for (i = 0; i < listcliente.length; i++) {
                                       
                    var cliente = listcliente[i];                                       
                                       
                    if(Number(cliente.idSituacaoCli) == Number(5)) {
                    
                        addPontoCliente(map,cliente);
                    }    
                }
            }
            
            function exibirClienteProspec() {

                clearMarkers();

                addPontoRB(map);
                exibirHospitalTodos();

                for (i = 0; i < listcliente.length; i++) {
                                       
                    var cliente = listcliente[i];                                       
                                       
                    if(Number(cliente.idSituacaoCli) == Number(6)) {
                    
                        addPontoCliente(map,cliente);
                    }    
                }
            }
            
            function addPontoCliente(map, cliente) {    
                
                var image;
                if (Number(cliente.idSituacaoCli) == 1) {
                    image = './images/cliente_ativo.png';
                }
                else if (Number(cliente.idSituacaoCli) == 2) {
                    image = './images/cliente_inativo.png';
                }
                else if (Number(cliente.idSituacaoCli) == 3) {
                    image = './images/cliente_suspenso.png';
                }
                else if (Number(cliente.idSituacaoCli) == 4) {
                    image = './images/cliente_internado.png';
                }
                else if (Number(cliente.idSituacaoCli) == 5) {
                    image = './images/cliente_viagem.png';
                }
                else if (Number(cliente.idSituacaoCli) == 6) {
                    image = './images/cliente_prospect.png';
                }
                else {
                    image = './images/cliente.png';
                }
                
                var myLatLng1 = {lat: Number(cliente.coordX), lng: Number(cliente.coordY)};
                var marker1 = new google.maps.Marker({
                    position: myLatLng1,
                    map: map,
                    icon: image,
                    title: String(cliente.cliente)
                });
                
                var textoEscala = '';
                var listEscala = cliente.listRelMapCliEscala;
                for(j = 0; j < listEscala.length; j++){
                    
                    var escala = listEscala[j];                    
                    textoEscala +=  escala.colaborador + ' - ' + escala.dtInicio + ' - ' + escala.dtFim + '<br/>';
                }

                var contentString1 =
                        '<div id="content">' +
                        '  <div id="siteNotice"></div>' +
                        '  <div id="bodyContent">' +
                        //'    <img src="http://www.w3schools.com/images/w3schools_green.jpg" alt="W3Schools.com">'+
                        '    <p><b>Nome: </b> ' + cliente.cliente + ' </p>' +
                        '    <p><b>Idade: </b> ' + cliente.idade + ' <b>Situação: </b> ' + cliente.situacao + '  </p>' +
                        '    <p><b>Endereco: </b> ' + cliente.endereco + ' ' + cliente.endereco + ' ' + cliente.compl + '</p>' +
                        '    ' + textoEscala + ' </p>' +
                        '    <a href="AssistCadAlt?acao=3&codclientebusca=' + cliente.codigo + '" target="_blank">Cadastro</a>&emsp;&emsp;' +
                        '    <a href="#" onclick="guardarCoordenadas(\'Cliente\', \'' + cliente.cliente + '\', ' + cliente.coordX + ', ' + cliente.coordY + '); return false;">Rota</a></p>' +
                        '  </div>' +
                        '</div>';

                var infowindow1 = new google.maps.InfoWindow({
                    content: contentString1
                });
                marker1.addListener('click', function () {
                    infowindow1.open(map, marker1);
                });
            }
            
            function clearMarkers() {
                
                var myLatLng = {lat: -23.614233, lng: -46.662033};
                map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 12,
                    center: myLatLng
                });
                
                addPontoRB(map);
            }
            
            function guardarCoordenadas(origem, nome, coordx, coordy){
                
                var labela = document.getElementById('labela');
                var inputacoordx = document.getElementById('inputacoordx');
                var inputacoordy = document.getElementById('inputacoordy');
                
                var labelb = document.getElementById('labelb');
                var inputbcoordx = document.getElementById('inputbcoordx');
                var inputbcoordy = document.getElementById('inputbcoordy');
                
                if(inputacoordx.value == ''){
                    
                    labela.innerHTML = '<span class=\'label label-warning\'>A</span> ' + origem + ' - ' + nome;
                    inputacoordx.value = coordx;
                    inputacoordy.value = coordy;
                }
                else if(inputbcoordx.value == ''){
                    
                    labelb.innerHTML = '<span class=\'label label-success\'>B</span> ' + origem + ' - ' + nome;
                    inputbcoordx.value = coordx;
                    inputbcoordy.value = coordy;
                }
                else{
                    
                    labela.innerHTML = '<span class=\'label label-warning\'>A</span> ' + origem + ' - ' + nome;
                    inputacoordx.value = coordx;
                    inputacoordy.value = coordy;
                    
                    labelb.innerHTML = '';
                    inputbcoordx.value = '';
                    inputbcoordy.value = '';
                }
            }
            
            function abrirRota(){
                
                var inputacoordx = document.getElementById('inputacoordx');
                var inputacoordy = document.getElementById('inputacoordy');
                
                var inputbcoordx = document.getElementById('inputbcoordx');
                var inputbcoordy = document.getElementById('inputbcoordy');
                
                if(inputacoordx.value == '' 
                        || inputacoordy.value == ''
                            || inputbcoordx.value == ''
                                || inputbcoordy.value == ''){
                      
                      alert('Por favor selecionar ponto origem e destino');
                }
                else {
                    
                    window.open('http://maps.google.com/maps?saddr=' + inputacoordx.value + ',' + inputacoordy.value + '&daddr=' + inputbcoordx.value + ',' + inputbcoordy.value ,'_blank');
                }
            }
            
            function limparRotas(){
                
                var labela = document.getElementById('labela');
                var inputacoordx = document.getElementById('inputacoordx');
                var inputacoordy = document.getElementById('inputacoordy');
                
                var labelb = document.getElementById('labelb');
                var inputbcoordx = document.getElementById('inputbcoordx');
                var inputbcoordy = document.getElementById('inputbcoordy');
                
                labela.innerHTML = '';
                inputacoordx.value = '';
                inputacoordy.value = '';

                labelb.innerHTML = '';
                inputbcoordx.value = '';
                inputbcoordy.value = '';
            }
            
        </script>

        <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCQYeBkyboWkHixtUDY9NZ_crkhBDa8eFQ&signed_in=true&callback=initMap"></script>
    </body>
</html>
