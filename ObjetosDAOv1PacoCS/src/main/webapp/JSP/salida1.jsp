<%-- 
    Document   : salida
    Created on : 11 nov. 2018, 15:20:51
    Author     : paco
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salida 1</title>
    </head>
    <body>
        <h1>Alumnos: </h1>
        <p>Nombre y Grupo</p>
        <c:forEach var="alumno" items="${alumnos}">
            Nombre: ${alumno.nombre} | Grupo: ${alumno.grupo}</br>
        </c:forEach>

        <br><br>
        <c:url var="index" value="/index.jsp"/>
        <a href="${index}">Menú</a>
    </body>
</html>
