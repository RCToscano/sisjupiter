
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>DiagsDeep</title>
        <link rel="icon" type="image/png" sizes="32x32" href="./images/favicon-32x32.png"/>
        <script src="./js/jquery-1.11.3.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="./css/formValidation.css"/>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="./css/menucustomcolor.css" rel="stylesheet"/>
        <link href="./css/footercustom.css" rel="stylesheet"/>
        
        <style type="text/css">
        	body {
			    margin: 0;
			}
			.intro {
			    display: block;
			    width: 100vw;
			    height: 100vh;
			    padding-top: 100px;;
			    padding-left: 0;
			    padding-right: 0;
			    padding-bottom: 0;
			    text-align: center;
			    color: white;
			    background: url(./images/bannerHome.jpg) no-repeat bottom center scroll;
			    background-position: 30% 45%;
			    background-color: white;
			    -webkit-background-size: cover;
			    -moz-background-size: cover;
			    background-size: cover;
			    -o-background-size: cover;
			}
        </style>
    </head>
    <body class="intro">
        <%@include file="./menu/menu_login.jsp" %>
        <c:choose>
            <c:when test="${!empty loginErro}">
                <script>
                    $(document).ready(function () {
                        $("[data-toggle='tooltip']").tooltip('show');
                        $('.tooltip-inner').css('background-color', 'red');
                    });
                </script>
            </c:when>                
            <c:otherwise>
                <script>
                    $(document).ready(function () {
                        $("[data-toggle='tooltip']").tooltip('destroy');
                    });
                </script>
            </c:otherwise>
        </c:choose>   
        <div class="container-fluid" style="margin-top: 60px; padding: 0px;">
   	       	<div class="form-group">
        		<div class="col-sm-12 text-left" style="margin-top: 100px;">
        			<label id="labelbody" style='color: #1c2056; font-size: 50pt;'>Diagnóstico Social</label>
        		</div>
        	</div>
        </div>
        <footer class="footer">
            <div class="container text-center">
                <p class="text-muted">©Copyright 2018</p>
            </div>
        </footer>
        <footer class="footer" style="background-color: #fff">
            <div class="container-fluid text-center" style="background-color: #fff; padding: 10px">
            	<div class="col-sm-4 text-center"><p class="text-muted">Todos os direitos reservados</p></div>
            	<div class="col-sm-4 text-center"><p class="text-muted"><label>Desenvolvido por Deepessoas</label></p></div>
            	<div class="col-sm-4 text-center"><p class="text-muted"><label style="font-size: 11px;">Rua Dr. Sodré, 122, cj.35/36, Vila Nova Conceição, São Paulo - SP</label></p></div>
            </div>
        </footer>
    </body>
</html>
