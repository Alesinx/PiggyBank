<%-- 
    Document   : movimientos
    Created on : 29-abr-2018, 23:07:10
    Author     : Alejandro
--%>


<%@page import="java.util.Collection"%>
<%@page import="beans.Movimientos"%>
<%@page import="java.util.List"%>

<%@page import="beans.Usuario"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <%
        Usuario user= (Usuario)session.getAttribute("usuario");
        Collection<Movimientos> coleccion = user.getMovimientosCollection();
    %>
    <head>
        <!-- <meta>-->
        <title>Movimientos</title>
    </head>
    <body>
        <h2>Movimientos de <%= user.getNombre()  %> <%= user.getApellido1()  %> <%= user.getApellido2()  %></h2>
        <table border="1">
            <tr>
                <th>fecha</th>
                <th>Concepto</th>
                <th>cantidad</th>
                
            </tr>
            <% 
                for (Movimientos movimiento : coleccion) {
            %>
            <tr>
                <td> <%= movimiento.getFecha() %> </td>
                <td> <%= movimiento.getConcepto() %> </td>
                <td> <%= movimiento.getCantidad() %> </td>

            </tr>
            <% 
                }
            %>
        </table>
        <br/>
        <input type="button" value=" Nueva transferencia " onClick="location.href = '/Piggybank-war/nuevaTransferencia.jsp'">
        <br/>
        <br/>
        <input type="button" value=" Volver " onClick="location.href = '/Piggybank-war/usuario.jsp'">
    </body>
</html>

