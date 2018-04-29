<%-- 
    Document   : usuario
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
        <title>Pagina de usuario</title>
        <%
            Usuario user= (Usuario)session.getAttribute("usuario");
        %>
    </head>
    <body>
 
            
             <table>
                <th>Cuenta de <%= user.getNombre() %></th>
                <tr>
                <td><b>Nombre: </b></td><td><%= user.getNombre() %> <%= user.getApellido1() %> <%= user.getApellido2() %><br/></td>
                </tr>
                <tr>
                <td><b>Numero de cuenta: </b></td><td><%= user.getNumeroCuenta() %><br/></td>
                </tr>
                <tr>
                <td><b>Saldo: </b></td><td><%= user.getEfectivo() %><br/></td>
                </tr>
                <br/>
                <br/>
            </table>
                <br/>
                <input type="button" value="Ver datos personales" onClick="location.href = '/Piggybank-war/datosPersonales.jsp'">
                <br/>
                <input type="button" value="Ver movimientos" onClick="location.href = '/Piggybank-war/movimientos.jsp'">
                <br/>
                 
                <%-- 
                    ZONA DE ADMINISTRADORES
                --%>
                
                <% 
                  if (user.getTipoUsuario() == 1){
                 %>
                 
                 <h1>Administración</h1><br/>
                 <input type="button" value="Dar de alta" onClick="location.href = '/Piggybank-war/darAlta.jsp'">
                 <br/>
                 <form method="post" action="CargarListaUsuariosServlet">
                     <button>Lista de usuarios</button>
                 </form>
                 <br/>
                 
                 <%
                     }
                 %>
    </body>
</html>
