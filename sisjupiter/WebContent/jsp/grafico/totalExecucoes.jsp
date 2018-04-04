
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
    	<jsp:include page="../../menu/${sessionScope.user.perfil.menu}" ></jsp:include>
    	<div class="container">
	    	<ul class="breadcrumb">
			    <li><a href="HomeBO?acao=home">Home</a></li>
			    <li class="active">Gr&aacute;fico</a></li>
			    <li class="active">Total Execu&ccedil;&otilde;es</li>
			</ul>
			
			<c:if test="${aviso != ''}">
				<div class="alert alert-danger">
					<strong><c:out value="${aviso}"/></strong>
				</div>
			</c:if>
		
			<c:if test="${aviso == ''}">
				<div class="col-sm-12">
					<h3 class="text-center">Total de Execuções por Comunidade</h3>
			
					<div class="col-sm-6">
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
						    	<c:forEach items="${listaComunidade}" var="total">
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
						    </tbody>
						</table>
					</div>
				
					<div class="col-sm-6">
						<div id="comunidade" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
					</div>
				</div>
				
				<div class="col-sm-12">
					<h3 class="text-center">Total de Execuções por Equipe</h3>
					
					<div class="col-sm-6">
						<table class="table table-hover">
						    <thead>
						        <tr>
						            <th>Nº</th>
						            <th>Equipe</th>
						            <th>Quantidade</th>
						        </tr>
						    </thead>
						    <tbody>
						    	<% int cont1 = 1;%>
						    	<c:forEach items="${listaEquipe}" var="total">
							        <tr>
							            <td><%=cont1%></td>
							            <td>${total.nomeEquipe}</td>
							            <td>${total.qtde}</td>
							        </tr>
							       	<%cont1++;%>
						        </c:forEach>
						        <tr class="active">
						            <td colspan="2"><strong>Total</strong></td>
						            <td><strong>${totalEquipe}</strong></td>
						        </tr>
						    </tbody>
						</table>
					</div>
					
					<div class="col-sm-6">
						<div id="equipe" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
					</div>
				
				</div>
				
<!-- 				<div class="col-sm-12"> -->
<!-- 					<div id="comunidadeBarra" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div> -->
<!-- 				</div> -->

<!-- 			<div class="col-sm-12"> -->
<!-- 				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval=""> -->
<!-- 					Indicators -->
<!-- 					<ol class="carousel-indicators"> -->
<!-- 						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li> -->
<!-- 						<li data-target="#carousel-example-generic" data-slide-to="1"></li> -->
<!-- 						<li data-target="#carousel-example-generic" data-slide-to="2"></li> -->
<!-- 					</ol> -->

<!-- 					Wrapper for slides -->
<!-- 					<div class="carousel-inner"> -->
<!-- 						<div class="item active"> -->
<!-- 							<div id="equipe" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div> -->
<!-- 						</div> -->
<!-- 						<div class="item"> -->
<!-- 							<div id="comunidadeBarra" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div> -->
<!-- 						</div> -->
						
<!-- 					</div> -->

<!-- 					Controls -->
<!-- 					<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"> -->
<!-- 						<span class="glyphicon glyphicon-chevron-left"></span> -->
<!-- 					</a>  -->
<!-- 					<a class="right carousel-control" href="#carousel-example-generic" data-slide="next"> -->
<!-- 						<span class="glyphicon glyphicon-chevron-right"></span> -->
<!-- 					</a> -->
<!-- 				</div> -->
<!-- 			</div> -->

				<script>
					Highcharts.setOptions({
					    colors: Highcharts.map(Highcharts.getOptions().colors, function (color) {
					        return {
					            radialGradient: {
					                cx: 0.5,
					                cy: 0.3,
					                r: 0.7
					            },
					            stops: [
					                [0, color],
					                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
					            ]
					        };
					    })
					});
			
					// Build the chart
					Highcharts.chart('comunidade', {
					    chart: {
					        plotBackgroundColor: null,
					        plotBorderWidth: null,
					        plotShadow: false,
					        type: 'pie'
					    },
					    title: {
					        text: ''
					    },
					    tooltip: {
					        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					    },
					    plotOptions: {
					        pie: {
					            allowPointSelect: true,
					            cursor: 'pointer',
					            dataLabels: {
					                enabled: true,
					                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
					                style: {
					                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
					                },
					                connectorColor: 'silver'
					            }
					        }
					    },
					    series: [{
					        name: ' ',
					        data: [
					        	${fn:replace(fn:replace(listaComunidadeFinal, '[', ''), ']', '')}
					        ]
					    }]
					});
				</script>
				
				<script>
					// Build the chart
					Highcharts.chart('equipe', {
					    chart: {
					        plotBackgroundColor: null,
					        plotBorderWidth: null,
					        plotShadow: false,
					        type: 'pie'
					    },
					    title: {
					        text: ''
					    },
					    tooltip: {
					        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					    },
					    plotOptions: {
					        pie: {
					            allowPointSelect: true,
					            cursor: 'pointer',
					            dataLabels: {
					                enabled: true,
					                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
					                style: {
					                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
					                },
					                connectorColor: 'silver'
					            }
					        }
					    },
					    series: [{
					        name: ' ',
					        data: [
					        	${fn:replace(fn:replace(listaEquipeFinal, '[', ''), ']', '')}
					        ]
					    }]
					});
				</script>
					
				<script>
					Highcharts.chart('comunidadeBarra', {
					    chart: {
					        type: 'column'
					    },
					    title: {
					        text: 'Browser market shares. January, 2015 to May, 2015'
					    },
					    xAxis: {
					        type: 'category'
					    },
					    yAxis: {
					        title: {
					            text: 'Quantidade'
					        }
					    },
					    legend: {
					        enabled: false
					    },
					    plotOptions: {
					        series: {
					            borderWidth: 0,
					            dataLabels: {
					                enabled: true,
					                format: '{point.y:.0f}'
					            }
					        }
					    },
					    tooltip: {
					        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
					        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.0f}</b> do total de ${totalComunidade}<br/>'
					    },
	
					    series: [{
					        name: ' ',
					        colorByPoint: true,
					        data: [
					        	${fn:replace(fn:replace(listaComunidadeFinal, '[', ''), ']', '')}
					        ]
					    }]
					});
				</script>
			</c:if>
			
		</div>
		<footer class="footer">
			<div class="container text-center">
				<p class="text-muted">©Copyright 2018</p>
            </div>
        </footer>
        
        
    </body>
</html>