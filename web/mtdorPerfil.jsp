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
    ControladorPerfil ctrlPErfil = new ControladorPerfil();
    HttpSession sesion = request.getSession();
    ArrayList<PerfilAcceso> lista = ctrlPErfil.PerfilesListar();


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- ~$tylos-->
        <link href="js/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">

        <!-- acciones js-->
        <script src="js/jquery-3.2.1.min.js" ></script>
        <!-- acciones boostrap-->  
        <script src="js/bootstrap-3.3.7-dist/js/bootstrap.js" ></script>        
        <script type="text/javascript" language="javascript"></script>
                         
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
                </form>

                 <div class="container">
               <div class="row"> 
                <div class="col-sm-12">
                    
                    <form name="frmActualizar" method="post" action="./PerfilServlet">  
            
                <h1>Modulo Mantenedor de Perfiles</h1>

               
                    <div class="Actualizar">
                        <h3>
                            Perfiles a modificar 
                        </h3>
                        <table class="table table-hover table table-condensed table table-bordered">
                            <thead>
                                <tr>
                                    <th>Nombre Perfil</th>
                                    <th>Estado Pefil</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <select name="slectModificarTipoPerfil">
                                            <option disabled value="0" selected="">Seleccione</option> 
                                            <option>Administrador</option>
                                            <option>Operario</option>
                                            <option>Medico Tratante</option>

                                        </select>
                                    </td>
                                    <td><select name="selectModificarEstadoPerfil">
                                            <option disabled value="0">Seleccione</option> 
                                            <option>Activo</option>
                                            <option>Inactivo</option>
                                        </select></td>
                                        
                        </table> 
                        <input type="submit" value="Modificar Perfil" name="btnModificarPerfil" class="btn btn-primary">
                        <br><br>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        </tbody>
                        </table>

                    </div>
                </form>




                <h3>Perfiles Creados</h3>
                <table class="table table-hover table table-condensed table table-bordered">
                    <thead>
                        <tr>


                            <th>Nombre</th>
                            <th>Estado</th>
                           

                        </tr>
                    </thead>
                    <tbody>
                        <%                     for (PerfilAcceso x : lista) {%>
                        <tr>


                            <td> <%= x.getNombreAcceso()%></td>
                            <td> <%=x.getEstado()%></td>

                        </tr>
                        <%}%>
                    </tbody>
                </table>
                </div>   
               </div>
                </div>
                    

    </body><br>
    <footer>Derechos reservados Programador Jvier Lopez</footer>
</html>
