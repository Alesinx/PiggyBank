<%-- 
    Document   : darAlta
    Created on : 02-may-2018, 18:29:47
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>darDeAlta</title>
    </head>
    <body>
        <h1>DAR DE ALTA</h1>
        <form action="GuardarAltaServlet" method="post">
            Nombre: <input type ="text" name ="name"> DNI:<input type ="text" name ="dni"><br/>
            Apellido1: <input type ="text" name ="apellido1"><br/>
            Apellido2: <input type ="text" name ="apellido2"><br/>
            <br/><br/>
            N.Cuenta: <input type ="text" name ="numCuenta">
            efectivo: <input type ="text" name ="efectivo">
            <br/><br/>
            Contrasenia: <input type ="text" name ="contrasenia"><br/>
            Direccion: <input type ="text" name ="direccion"><br/>
            email: <input type ="text" name ="email"><br/>
            FechaNacimiento: 
            <br>
             dia: <input type ="text" name ="dia" size="2" maxlength="2">
             mes: <input type ="text" name ="mes" size="2" maxlength="2">
             anyo: <input type ="text" name ="anyo" size="4" maxlength="4"><br>
            Tipo de usuario:
            <input type="radio" name="typeUser" value="1" checked> admin<br>
            <input type="radio" name="typeUser" value="2">user only<br>
            <button>Okay</button>
             
        </form>
    </body>
</html>
