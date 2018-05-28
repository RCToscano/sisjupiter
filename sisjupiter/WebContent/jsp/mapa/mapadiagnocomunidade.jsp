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
        <link rel="icon" type="image/png" sizes="32x32" href="./images/favicon-32x32.png"/>
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
        <div id='divColaborador' style='background-color: #fff; position: absolute; top: 50px; min-width: 400px; right: 10px; z-index: 1; width: 20%; padding: 5px;' >
        	<div class="form-group">
        		<div class="col-sm-12 text-center">
        			<label id="labelaviso" style="color: red;"></label>
        		</div>
			</div>
        	<div class="form-group">
				<label>Comunidade:</label> 
				<select class="form-control" name="idComunidade" id="idComunidade">
	                <option value="" selected>Selecione...</option>
	                <c:forEach var="comunidade" items="${listComunidade}">
	                    <option value="${comunidade.idComunidade}" >${comunidade.nome}</option>
	                </c:forEach>
              	</select>
                <div style="padding: 5px; text-align: center;">
                	<button type="button" class="btn btn-primary btn-xs" onclick="buscarDiagnostico()">Buscar Pontos</button>
                </div>
			</div>
        </div>
        <script>

//             var listcolab = ${jsonColab};
//             var listcliente = ${jsonCli};
//             var listhospital = ${jsonHospital};
            var map;

            function initMap() {

                var myLatLng = {lat: -23.591820, lng: -46.673884};
                map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 12,
                    center: myLatLng
                });
                
                addPontoRB(map);
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
            
	        function buscarDiagnostico() {
	        	
	        	var labelaviso = document.getElementById('labelaviso');
	        	var idComunidade = document.getElementById('idComunidade');

	        	labelaviso.innerHTML = '';
	        	
	        	clearMarkers();
	        	
	            if(idComunidade.value == '') {
	            	
	            	labelaviso.innerHTML = 'Selecione a Comunidade';
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
	        	        	
	        	        	var cont = 0;
	        	            var listRelMapaDiagnostico = result;
	        	            if(listRelMapaDiagnostico != null && listRelMapaDiagnostico.length > 0) {
	        	            
	        	            	for(i = 0; i < listRelMapaDiagnostico.length; i++) {
	   
	        	                	var relMapaDiagnostico = listRelMapaDiagnostico[i];	
	        	            		if(relMapaDiagnostico.coordX != null && relMapaDiagnostico.coordY != null
	        	                			&& relMapaDiagnostico.coordX != '' && relMapaDiagnostico.coordY != ''
	        	                				&& relMapaDiagnostico.coordX != '0.0' && relMapaDiagnostico.coordY != '0.0') {
	        	            			
	        	            			if(cont == 0) {
	        	            				 	            			
	        	            				var center = new google.maps.LatLng(Number(relMapaDiagnostico.coordX), Number(relMapaDiagnostico.coordY));
		        	            		    map.panTo(center);
	        	            			}
	        	            		
	        	            			addPontoDiagnostico(map,relMapaDiagnostico);
	        	            			
	        	            			cont = cont + 1;
	        	            		}
	        	                }
	        	            }
	        	            
	        	            if(cont == 0) {
	        	            	
	        	            	labelaviso.innerHTML = 'Não foram localizados pontos';
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
	        
            function addPontoDiagnostico(map,relMapaDiagnostico) {
				
            	if(relMapaDiagnostico.coordX != null && relMapaDiagnostico.coordY != null
            			&& relMapaDiagnostico.coordX != '' && relMapaDiagnostico.coordY != ''
            				&& relMapaDiagnostico.coordX != '0.0' && relMapaDiagnostico.coordY != '0.0') {
            		
                    var image = './images/ic_pessoa_maps.png';
                    var myLatLng1 = {lat: Number(relMapaDiagnostico.coordX), lng: Number(relMapaDiagnostico.coordY)};
                    var marker1 = new google.maps.Marker({
                        position: myLatLng1,
                        map: map,
                        icon: image,
                        title: String(relMapaDiagnostico.nome)
                    });
                    
                    var contentString1 =
                            '<div id="content">' +
                            '  <div id="siteNotice"></div>' +
                            '  <div id="bodyContent">' +
                            '    <p><b>' + relMapaDiagnostico.nome + '</b></p>' +
                            '    <p>' + relMapaDiagnostico.endereco + ' ' + relMapaDiagnostico.numAtual + ' ' + relMapaDiagnostico.compl + '</p>' +
                            '    <p>Tel: ' ;                                  
             	   	if(relMapaDiagnostico.telRes != undefined && relMapaDiagnostico.telRes != null && relMapaDiagnostico.telRes != 0) {
                		
                 		contentString1 += '  ' + relMapaDiagnostico.telRes ;
                   	}
	             	if(relMapaDiagnostico.telCel != undefined && relMapaDiagnostico.telCel != null && relMapaDiagnostico.telCel != 0) {
	              		
               	   		contentString1 += '  ' + relMapaDiagnostico.telCel ;
                  	}
                   	if(relMapaDiagnostico.contatoRespCasaTel1 != undefined && relMapaDiagnostico.contatoRespCasaTel1 != null && relMapaDiagnostico.contatoRespCasaTel1 != 0) {
                		
                		contentString1 += '  ' + relMapaDiagnostico.contatoRespCasaTel1 ;
                   	}
                   	if(relMapaDiagnostico.contatoRespCasaTe2 != undefined && relMapaDiagnostico.contatoRespCasaTel2 != null && relMapaDiagnostico.contatoRespCasaTel2 != 0) {
               		
						contentString1 += '  ' + relMapaDiagnostico.contatoRespCasaTe2 ;
                   	}
                   	contentString1 +=
                	        '    </p>'            	   
                            '  </div>' +
                            '</div>';
                    var infowindow1 = new google.maps.InfoWindow({
                        content: contentString1
                    });
                    marker1.addListener('click', function () {
                        infowindow1.open(map, marker1);
                    });
            	}
            }
            
            function clearMarkers() {
                
            	var myLatLng = {lat: -23.591820, lng: -46.673884};
                map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 12,
                    center: myLatLng
                });
                
                addPontoRB(map);
            }

        </script>

        <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCQYeBkyboWkHixtUDY9NZ_crkhBDa8eFQ&signed_in=true&callback=initMap"></script>
    </body>
</html>
