<%-- 
    Document   : datosPersonales
    Created on : 19-abr-2018, 12:06:21
    Author     : Alberto Cazorla Suárez
--%>

<%@page import="beans.Usuario"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos personales</title>
        <%
            Usuario user= (Usuario)session.getAttribute("usuario");
        %>
    </head>
    <body>
 
            <h2>Cuenta de <%= user.getNombre() %></h2>
            
             <table>
                <th>Datos personales</th>
                <tr>
                <td><b>Nombre: </b></td><td><%= user.getNombre() %> <%= user.getApellido1() %> <%= user.getApellido2() %><br/></td>
                </tr>
                <tr>
                <td><b>Dni: </b></td><td><%= user.getDni() %><br/></td>
                </tr>
                <tr>
                <td><b>Fecha de nacimiento: </b> </td><td><%= user.getFechaNacimiento() %><br/></td>
                </tr>
                <tr>
                <td><b>Direccion: </b></td><td> <%= user.getDireccion() %><br/></td>
                </tr>
                <tr>
                <td><b> Direccion de correo: </b></td><td> <%= user.getEmail() %><br/></td>
                </tr>
                <br/>
                <br/>
            </table>
            <br/>
            <br/>    
            <table>
                <th>Datos de la cuenta</th>
                <tr>
                <td><b>Numero de cuenta: </b></td><td><%= user.getNumeroCuenta() %><br/></td>
                </tr>
                <tr>
                <td><b>Saldo: </b></td><td><%= user.getEfectivo() %><br/></td>
                </tr>
                <br/>
                <br/>
            </table>
    <form action="usuario.jsp">
        <button>Back</button>
    </form>
    </body>
</html>
