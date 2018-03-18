
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SisPesquisa</title>
        <script src="./js/jquery-1.11.3.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="./css/formValidation.css"/>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="./css/menucustomcolor.css" rel="stylesheet"/>
        <link href="./css/footercustom.css" rel="stylesheet"/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
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
        <div class="container">
            
        </div>
        <footer class="footer">
            <div class="container text-center">
                <p class="text-muted">©Copyright 2018</p>
            </div>
        </footer>
    </body>
</html>
