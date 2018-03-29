
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
				<div id="comunidade" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
				<div id="equipe" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
				
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
					        text: 'Total de Execuções por Comunidade'
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
					        text: 'Total de Execuções por Equipe'
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
					        name: 'Share',
					        data: [
					        	${fn:replace(fn:replace(listaEquipeFinal, '[', ''), ']', '')}
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