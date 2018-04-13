
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
			    <li class="active">Per&iacute;odo Execu&ccedil;&otilde;es</li>
			</ul>
			
			<c:if test="${aviso != ''}">
				<div class="alert alert-danger">
					<strong><c:out value="${aviso}"/></strong>
				</div>
			</c:if>

			<c:if test="${aviso == ''}">
				<div id="grafico" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
				
				<script>
					Highcharts.chart('grafico', {
					    title: {
					        text: 'Quantidade de Execuções por Data'
					    },
					    subtitle: {
					        text: ${periodo}
					    },
					    yAxis: {
					    	title: {
					            text: 'Quantidade'
					        },
					        type: 'logarithmic',
					        minorTickInterval: 0.1
					    },
					    xAxis: {
					    	title: {
					            text: 'Data'
					        },
					        categories: [${fn:replace(fn:replace(listaData, '[', ''), ']', '')}],
					        crosshair: true
					    },
					    series: [{
					    		name: ' ',
					    		data: [${fn:replace(fn:replace(listaQtde, '[', ''), ']', '')}]
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