<%-- 
    Document   : listaUsuarios
    Created on : 29-abr-2018, 17:04:24
    Author     : Alberto Cazorla Suárez
--%>

<%@page import="beans.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Usuario> listaUsuarios = (List<Usuario>)request.getAttribute("listaUsuarios");

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
    </head>
    <body>
        <h1>Base de datos de usuarios del banco</h1>
        <table border="1">
            <tr>
            <th>DNI</th>                
            <th>NOMBRE</th>                            
            <th>NUMERO DE CUENTA</th>
            <th></th>                                   
            </tr>
            <% 
                for (Usuario user:listaUsuarios) {
            %>    
            <tr>
                <td>
                <%= user.getDni() %>
                </td>
                <td>
                <%= user.getNombre() %> <%= user.getApellido1() %> <%= user.getApellido2() %>
                </td>                
                <td>
                <%= user.getNumeroCuenta() %>
                </td>                       
                <td>
                    <a href="NuevoMovimientoServlet?dni=<%= user.getDni() %>">Nuevo movimiento</a>
                </td>                                                             
            </tr>
            <% 
                }
            %>    
            
        </table>
            <input type="button" value="Volver" onClick="location.href = '/Piggybank-war/usuario.jsp'">
        
    </body>
</html>
