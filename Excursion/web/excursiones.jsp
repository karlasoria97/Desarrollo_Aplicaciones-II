<%-- 
    Document   : excursiones
    Created on : 22/09/2016, 01:45:45 PM
    Author     : Karla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar excursiones</title>
    </head>
    <body>
        <form action="ExcursionController" method="post">
            <fieldset>
                <div>
                    <label>Id excursion:</label>
                    <input type="text" name="idExcursiones" value="${excursion.idExcursion}" readonly="readonly"/>
                </div>
                <div>
                    <label>Destino:</label>
                    <input type="text" name="destino" value="${excursion.destino}"/>
                </div>
                <div>
                    <label>Actividad:</label>
                    <input type="text" name="actividad" value="${excursion.actividad}"/>
                </div>
                <div>
                    <label>Transporte:</label>
                    <input type="text" name="transporte" value="${excursion.transporte}"/>
                </div>
                <div>
                    <label>Hotel:</label>
                    <input type="text" name="hotel" value="${excursion.hotel}"/>
                </div>
                <div>
                  
                    <input type="submit" value="Guardar"/>
                </div>
                
            </fieldset>
        </form>
    </body>
</html>
