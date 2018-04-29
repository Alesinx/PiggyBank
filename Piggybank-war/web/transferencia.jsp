<%-- 
    Document   : transferencia
    Created on : 29-abr-2018, 23:27:06
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Transferencia</title>
    </head>

    <body>
        <h1>Transferencia</h1>
        <form action="guardarTransferencia" method="POST">
            <table>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad" max="30" maxlength="30" value=""/></td>
                </tr>
                <tr>
                    <td>Concepto</td>
                    <td><input type="text" name="concepto" max="30" maxlength="30" value=""/></td>
                </tr>
            </table>
            <input type="submit" value="Confirmar" />
        </form>
    </body>
</html>