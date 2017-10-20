<%-- 
    Document   : mtdorPerfiljsp
    Created on : 19-oct-2017, 11:54:35
    Author     : JavierLopez
--%>

<%@page import="Servlet.PerfilServlet"%>
<%@page import="controlador.ControladorPerfil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.PerfilAcceso"%>
 <%
   ControladorPerfil ctrlPErfil=new ControladorPerfil();
  HttpSession sesion=request.getSession();
  ArrayList<PerfilAcceso> lista= ctrlPErfil.PerfilesListar();
                              
                                
 %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
 
         <div class="content"> 
<div id="menu-wrapper">
	<ul id="hmenu">
    	<li><a href="index.jsp">Inicio</a></li>
        <li><a href="#">Mantenerdores</a>
        	<ul class="sub_menu">
            	<li><a href="mtdorPerfil.jsp">Perfiles</a></li>
                <li><a href="#">Usuarios</a></li>
                <li><a href="#">Mascotas</a></li>
                <li><a href="#">Medico Tratante</a></li>
            </ul>
        </li>
        <li><a href="#">Consulta Medica</a>
        	<ul class="sub_menu">
            	<li><a href="Operaciones/VerCamaras/VerCam001.php">Ingresgar consulta </a></li>
                <li><a href="Operaciones/GestorCam.php">Buscar consulta </a></li>
                <li><a href="Operaciones/GestorPedidos.php">Eliminar consulta</a></li>
   			</ul>     
        </li>
        <li><a href="#">Gestion</a>
        	<ul class="sub_menu">
            	<li><a href="../GRAFICO.xls">Gestiona Consultas</a></li>
                <li><a href="Informes/RptCamaras.php">Consultas Pendientes</a></li>
                <li><a href="Informes/RptGraficaCam/GrafCam001.php">Consultas Realizadas</a></li>
        	</ul>
        </li>    
        <li><a href="#">Historia Atenciones</a>
        	<ul class="sub_menu">
            	<li><a href="#">Acerca de</a></li>
                <li><a href="#">Heldesck</a></li>
			</ul>
         </li>
    </ul>
</div> 
        <h1>Hola javier prepara esta vista de mantenedor de perfil</h1>
        
        <h4>Agregar Perfil</h4>
        <form name="frmPerfil" method="post" action="">
        <table border="1" width="5" cellspacing="1" cellpadding="2">
            <thead>
                <tr>
                    <th>Nombre Perfil</th>
                    <th>Estado Pefil</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="txtNombrePerfil" placeholder="Administrador"></td>
                            <td><select>
                                    <option value=null>Seleccione</option> 
                                    <option>Activo</option>
                                    <option>Inactivo</option>
                        </select>
                            </td>
                   
                </tr>
                
            </tbody>
            
        </table><input type="submit" value="Agregar Perfil" name="btnAgregarPerfil">
        <br><br>
        </form>
        
    <h3>Cuentras Creadas</h3>
        <table border="1">
            <thead>
                <tr>
                  
                    <th>id perfil</th>
                    <th>Nombre</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                     
                </tr>
            </thead>
            <tbody>
                 <%
                    
                      for(PerfilAcceso x:lista)
                        
                 {%>
                <tr>
                    
                    <td> <%=x.getIdPerfil()%></td>
                   <td> <%= x.getNombreAcceso()%></td>
                    <td> <%=x.getEstado()%></td>
                    <th><a href="#">Eliminar </a></th>
                    <th><a href="#">Actualizar </a></th>
                    <%}%>
                    
                    
                </tr>
               
            </tbody>
        </table>
    

    </body>
</html>
