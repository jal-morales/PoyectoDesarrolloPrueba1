<%-- 
    Document   : mtdorPerfiljsp
    Created on : 19-oct-2017, 11:54:35
    Author     : JavierLopez
--%>

<%@page import="modelo.TipoMascota"%>
<%@page import="controlador.ControladorMascota"%>
<%@page import="Servlet.PerfilServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
 <%
   ControladorMascota ctrlMacta=new ControladorMascota();
  HttpSession sesion=request.getSession();
  ArrayList<TipoMascota> lista= ctrlMacta.TipoMascotasListar();
                              
                                
 %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
      <link href="css/estilos.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/estilos.css" rel="stylesheet" type="text/css" />
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="css/navbar-static-top.css" rel="stylesheet" type="text/css" />  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
 
     <form name="frmPrincipal" method="post" action="./PrincipalServlet">   
      
      <!-- Static navbar -->
    <div class="navbar navbar-inverse navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Medipet</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Inicio</a></li>
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mantenedor <b class="caret"></b></a>
              <ul class="dropdown-menu">
                  <li><a href="mtdorPerfil.jsp">Perfiles</a></li>
                  <li><a href="mtdorUsuario.jsp">Usuarios</a></li>
                  <li><a href="mtdorTipoMascota.jsp">Mascotas</a></li>
                  <li><a href="mtdorMedicoTratante.jsp">Medico Tratante</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Gestion Veterinaria <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Agregar Cliente</a></li>
                <li><a href="#">Ingresar Consulta</a></li>
                <li><a href="#">Buscar Consulta</a></li>
                <li><a href="#">Eliminar Consulta</a></li>
              </ul>
            </li>

         
        </div><!--/.nav-collapse -->
      </div>
    </div>
  <div class="container">
               <div class="row"> 
                <div class="col-sm-12">

    </form>
        <h1>Hola javier prepara esta vista de mantenedor de Mascota</h1>
        
        <h4>Agregar Tipo Mascota</h4>
        <form name="frmPerfil" method="post" action="./MascotaServlet">
        <table border="1" width="5" cellspacing="1" cellpadding="2"class="table table-hover table table-condensed table table-bordered">
            <thead>
                <tr>
                    <th>Nombre Mascota</th>
                    <th>Estado Mascota</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <input type="text" name="txtTipoMascota" placeholder="Perro" required> 
                    </td>
                    <td><select name="selectEstadoMacota">
                            <option  disabled value="0" selected="">Seleccione</option> 
                                    <option>Activo</option>
                                    <option>Inactivo</option>
                        </select>
                            </td>
                   
                </tr>
                
            </tbody>
            
        </table><input type="submit" value="Agregar Mascotas" name="btnAgregarMascotas" class="btn btn-primary">
        <br><br>
        </form>
        
    <h3>Mascotas Creadas</h3>
        <table class="table table-hover table table-condensed table table-bordered">
            <thead>
                <tr>
                  
                    
                    <th>Nombre</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                    <th></th>
                     
                </tr>
            </thead>
            <tbody>
                 <%
                    
                      for(TipoMascota x:lista)
                          
                       
                 {%>
                <tr>
                    
                    
                   <td> <%= x.getNombreTipoMascota()%></td>
                    <td> <%= x.getEstadoTipoMascota()%></td>
                     <td><a href="./ServletEliminarMascotas?txtEliminarMascota=<%=x.getIdTipoMascota()%>">Eliminar</a></td>
                    <td><a href="ModificarMascotas.jsp?idMascota=<%=x.getIdTipoMascota()%>&&nombreMascota=<%= x.getNombreTipoMascota()%>&&cboestadoMascota=<%= x.getEstadoTipoMascota()%>">Actualizar</a></td>
                     
                    
     
                </tr>
               <%}%>
            </tbody>
        </table>
    
        </div>
               </div>
           
  </div>
         </body><br>  <footer>Derechos reservados Programador Jvier Lopez</footer>
    
</html>
