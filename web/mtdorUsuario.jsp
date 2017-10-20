
<%@page import="modelo.PerfilAcceso"%>
<%@page import="controlador.ControladorPerfil"%>
<%@page import="controlador.ControladorUsuario"%>
<%@page import="modelo.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<%
                                
  
   ControladorUsuario ctrlUsuar=new ControladorUsuario();
  HttpSession sesion=request.getSession();
  ArrayList<Usuarios> listaUsuarios= ctrlUsuar.UsuariosListar();
                                
 %>
 
  <%
   ControladorPerfil ctrlPErfil=new ControladorPerfil();
  ArrayList<PerfilAcceso> listaPerfiles= ctrlPErfil.PerfilesListar();
                              
                                
 %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenedor de usuarios</title>
    </head>
       <div class="content"> 
<div id="menu-wrapper">
	<ul id="hmenu">
    	<li><a href="index.jsp">Inicio</a></li>
        <li><a href="#">Mantenerdores</a>
        	<ul class="sub_menu">
            	<li><a href="mtdorPerfil.jsp">Perfiles</a></li>
                <li><a href="mtdorUsuario.jsp">Usuarios</a></li>
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
           <h1>Javier trabaja en el mantenedor de usuario</h1>
            <h4>Agregar Usuario</h4>
        <form name="frmPerfil" method="post" action="./UsuariosServlet">
        <table border="1" width="5" cellspacing="1" cellpadding="2">
            <thead>
                <tr>
                    <th>Tipo perfil</th>
                    <th>Nombre</th>
                    <th>Fecha Nacimiento</th>
                     <th>Correo Electronico</th>
                     <th>Contraseña</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>
                       <select name="cmb_producto"> 
                            <option value="0">--seleccione--</option>
                           <%
                                for(PerfilAcceso x:listaPerfiles)
                                {%>
                                <option value="<%=x.getIdPerfil()
                             
                                %>">
                                    
                                    <%=   x.getNombreAcceso()%>
                                </option>
                                <%}%>
                                
                           %>
                        </select>         
                    </th>
                            <th><input type="text" name="txtNombre" placeholder="Javier Antonio" required></th>
                            <th><input type="date" name="txtfecha"  required></th>
                            <th><input type="email" name="txtemail" placeholder="jlopez@gmail.com" required></th>
                            <th><input type="password" name="txtclave" placeholder="************" required></th>
                   
                </tr>
                
            </tbody>
            
        </table><input type="submit" value="Agregar usuarios" name="btnAgregarPerfil">
        <br><br>
        </form>
        
    <h3>Cuentras Creadas</h3>
        <table border="1">
            <thead>
                <tr>
                  
                    <th>id perfil</th>
                    <th>Tipo Perfil</th>
                    <th>Nombre</th>
                    <th>Fecha Nacimiento</th>
                    <th>Correo Electronico</th>
                    <th>Acciones</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
               
                 <%
                    
                      for(Usuarios u: listaUsuarios)
                         
                        
                 {%>
                <tr>
                    
                    <td> <%=u.getIdUsuario()%></td>
                    <td> <%= u.getTipoPerfil() %></td>
                    <td> <%=u.getNombre()%></td>
                    <td> <%=u.getFecha_nacimiento()%></td>
                    <td> <%=u.getCorreo()%></td>
                    <th><a href="#">Eliminar </a></th>
                    <th><a href="#">Actualizar </a></th>
                    <%}%>
                </tr>       
               
            </tbody>
        </table>
    
    </body>
</html>
