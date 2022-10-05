<%-- 
    Document   : index
    Created on : 3 oct. 2022, 23:36:17
    Author     : MenaresDesarrollo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingreso de Alumnos</h1>
        
        <!--action define a donde se ira el formulario -->
        <form name="frmForm1" action="proceso" method="get">
            <label>ID</label><br>
            <input type="text" name="txtId" size="3"/>
            <br><br>

            <label>Nombre</label><br>
            <input type="text" name="txtNombre" />
            <br><br>
                
            <label>Apellido</label><br>
            <input type="text" name="txtApellido" />
            <br><br>
            
            <label>Rut</label><br>
            <input type="text" name="txtRut" />
            <br><br>
            
            <label>Email</label><br>
            <input type="text" name="txtEmail" />
            <br>
            <br><br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
