<%-- 
    Document   : listarExcursiones
    Created on : 22/09/2016, 01:40:40 PM
    Author     : Karla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excursiones</title>
    </head>
    <body>
        <table>
            <thead> 
                <tr>
                    <th>Id Excursion</th>
                    <th>Destino</th>
                    <th>Actividad</th>
                    <th>Transporte</th>
                    <th>Hotel</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="excursion" items="${excursiones}">
                    <tr>
                        <td>${excursion.idExcursion}</td>
                        <td>${excursion.destino}</td>
                        <td>${excursion.actividad}</td>
                        <td>${excursion.transporte}</td>
                        <td>${excursion.hotel}</td>
                        <td><a href="ExcursionController?action=cambiar&idExcursion=${excursion.idExcursion}">Cambiar</a></td>
                        <td><a href="ExcursionController?action=borrar&idExcursion=${excursion.idExcursion}">Borrar</a></td>
                    </tr>
                </c:forEach>          

            </tbody>
        </table>
        <p>
            <a href="ExcursionController?action=agregar">Nueva excursion</a>
        </p>
    </body>
</html>
