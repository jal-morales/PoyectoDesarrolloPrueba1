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
        
    
        <form name="frm_principal" action="./PerfilServlet" method="POST">
            <table align="center">
                <tr>
                    <td colspan="2"> BIENVENIDO A MEDIPET </td>
                </tr>
                <tr>
                    <td> <input type="submit" name="btnPerfil" value="Mantenedor Perfiles" /> </td>
                    <td> <input type="submit" name="btnUsuarios" value="Agregar Usuarios" /> </td>
                    <td> <input type="submit" name="btnClientes" value=" Ingreso Cliente" /> </td>
                    <td> <input type="submit" name="btnMascotas" value="Ingreso Mascota" /> </td>
                    <td> <input type="submit" name="btnHistrico" value="Historiar de atenciones" /> </td>
                    
                    <td> <input type="submit" name="btn_ventas" value="Mantenedor" /> </td>
                </tr>
            </table>
        </form><br>
        
        <div clasclass="Principal" >
            <form name="frmAgregarPerfil"  method="POST" action="./PerfilServlet">

            <h3>Agregar Perfiles</h3>
            <br>
            <table>
                <tr>
                    <td>
                        Nombre Tipo Usuario:                      
                    </td>  
                
                </tr>
                
                <tr>
                    <td>
                         <input type="text" name="txtAgregarPerfil" placeholder="Administrador">
                    </td>
                    
                </tr>
                
                <tr>
                    <td>
                        Estado usuario:                      
                    </td>                   
                </tr>
                
                <tr>
                    
                    <td>
                        <input type="text" name="sltorEstadoPerfil" >
                        <br>
                        <input type="submit" name="txtAgregarUsuarios" value="Agregar Perfiles" >
                    </td>
                    
                </tr>
              
               
            </table ><br>
              </form>

        <form name="frmListarPerfiles">
            <h2>Listado de Perfiles</h2>

                <table>
                    <tr>
                        <td>Nª---</td>
                        <td>Nombre Perfil ---</td>
                        <td>Estado Perfil</td>
                    </tr>
                     <tr>
                        <td>1</td>
                        <td>Administrador</td>
                        <td>Activo</td>
                    </tr>
                     <tr>
                        <td>2</td>
                        <td>Operario</td>
                        <td>Activo</td>
                    </tr>
                     <tr>
                        <td>3</td>
                        <td>Otros</td>
                        <td>Inactivo</td>
                    </tr>
                </table>
             
        </form>
        
        
         <form name="frmModificarPerfil" class="frmAgregarperfiles">

            <h3>Editar  Perfiles</h3>
            <br>
            <table>
                <tr>
                    <td>
                        Tipo Usuario:                      
                    </td>  
                
                </tr>
                
                <tr>
                    <td>
                        <select>
                            <option>---Seleccione---</option>
                            <option>Administrador</option>
                            <option>Operario</option>
                            <option>Otros</option>
                        </select>
                    </td>
                    
                </tr>
                
                <tr>
                    <td>
                        Estado usuario:                      
                    </td>                   
                </tr>
                
                <tr>
                    
                    <td>
                        <select name="sltorEstadoPerfil">
                            <option>---Seleccione---</option>
                            <option>Activo</option>
                            <option>Inactivo</option>
                        </select><br>
                        <input type="submit" name="txtAgregarUsuarios" value="Modificar Perfil" >
                    </td>
                    
                </tr>
              
               
            </table ><br>
              </form>
        </div>
        

    </body>
</html>
