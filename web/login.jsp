<%-- 
    Document   : index
    Created on : 06-10-2017, 15:45:41
    Author     : Consultor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" 
        integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <title>JSP Page</title>
    
    </head>
    
    <body style="background-image:url(img/inicio2.jpg) ">
        

        <form name="frm_principal" action="./ServletPrincipal" method="POST">
            <table align="center">
                <tr>
                    <td colspan="2"> 
                        <legend>Login 
                    <div>
                        <input type="text" name="txtUsuario" placeholder="Usuario" required>
                    </div>
                    <div>
                        <input type="password" name="txtpasword" placeholder="Password" required><br><br>
                        <input type="submit" name="btn_ingresar" value="Ingresar" /> 
                        <input type="submit" name="btn_limpiar_" value="Cancelar" />
                    </div>

                </legend>
                    </td>
                
                </tr>


            </table>
        </form>
    </body><br>
     <footer>Derechos reservados Programador Jvier Lopez</footer>
</html>
