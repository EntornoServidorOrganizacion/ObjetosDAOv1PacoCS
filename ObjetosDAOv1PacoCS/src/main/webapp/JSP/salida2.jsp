<%-- 
    Document   : salida2
    Created on : 12 nov. 2018, 17:26:31
    Author     : paco
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salida 2</title>
    </head>
    <body>
        <h1>Alumnos y equipos: </h1>
        <p>Nombre | Grupo | Equipo y su id</p>
        <c:forEach var="alumnoEquipo" items="${alumnosYequipos}">
            Nombre: ${alumnoEquipo.nombre} | Grupo: ${alumnoEquipo.grupo} | Equipo: ${alumnoEquipo.equipo.marca} con id ${alumnoEquipo.equipo.idEquipo}</br>
        </c:forEach>

        <br><br>
        <c:url var="index" value="/index.jsp"/>
        <a href="${index}">Menú</a>
    </body>
</html>
