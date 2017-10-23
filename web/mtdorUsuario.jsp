
<%@page import="Servlet.UsuariosServlet"%>
<%@page import="modelo.PerfilAcceso"%>
<%@page import="controlador.ControladorPerfil"%>
<%@page import="controlador.ControladorUsuario"%>
<%@page import="modelo.Usuarios"%>
<%@page import="java.util.ArrayList"%>



<%

    HttpSession sesion = request.getSession();
    ControladorUsuario ctrlUsuar = new ControladorUsuario();
    ArrayList<Usuarios> listaUsuarios = ctrlUsuar.UsuariosListar();
  //-------------------------------------------------------------------

    ControladorPerfil ctrlPErfil = new ControladorPerfil();
    ArrayList<PerfilAcceso> listaPerfiles = ctrlPErfil.PerfilesListarActvos();


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
                         
    <script type="text/javascript">
function popup(meh)
{
    var x = screen.width/2 - 700/2;
    var y = screen.height/2 - 450/2;
    window.open(meh.href, 'sharegplus','height=700,width=700,left='+x+',top='+y);
}
</script>
        <title>Mantenedor de usuarios</title>
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
                    <h1>Javier trabaja en el mantenedor de usuario</h1>
        <h4>Agregar Usuario</h4>
        <form name="frmPerfil" method="post" action="./UsuariosServlet">
            <table class="table table-hover table table-condensed table table-bordered">
                <thead>
                    <tr>
                        <th>Rut</th>
                        <th>Tipo perfil</th>
                        <th>Nombre</th>
                        <th>Fecha Nacimiento</th>
                        <th>Correo Electronico</th>
                        <th>Contraseña</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th><input type="text" name="txtrut" placeholder="17336928-k" required></th>
                        <th>
                            <select name="cboPerfiles"> 
                                <option disabled value="0" reque>--seleccione--</option>
                                <%                               for (PerfilAcceso x : listaPerfiles) {%>
                                         <option  value="<%=x.getNombreAcceso()%>">

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

            </table><input type="submit" value="Agregar usuarios" name="btnAgregarUsuario" class="btn btn-primary">
            <br><br>
        </form><!--fin formulario de Agregar Usuarios-->
                                
   
  <!--Inicio formulario de Listar y acciones de  Usuarios-->      
  <form name="frmAcciones" method="post" action="/.UsuariosServlet">

                        <h3>Usuarios Creados</h3>
                        <table class="table table-hover table table-condensed table table-bordered" >
                            <thead>
                                <tr>

                                    <th>Rut</th>
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

                                    for (Usuarios u : listaUsuarios) {%>
                                <tr>

                                    <td> <%= u.getRut()%></td>
                                    <td> <%= u.getTipoPerfil()%></td>
                                    <td> <%=u.getNombre()%></td>
                                    <td> <%=u.getFecha_nacimiento()%></td>
                                    <td> <%=u.getCorreo()%></td>
                                    <td><a href="./ServletEliminarUsuarios?txtEliminarUser=<%=u.getIdUsuario()%> " target="popup" onClick="popup()" target="_blank">Eliminar</a></td>
                                    <td> <a href="ModificarUsuarios.jsp?txtActualizarUser=<%=u.getIdUsuario()%>&&txtrut=<%= u.getRut()%> 
                                            &&cboPerfiles=<%= u.getTipoPerfil()%>&&txtNombre=<%=u.getNombre()%>
                                            &&txtfecha=<%=u.getFecha_nacimiento()%> &&txtemail=<%=u.getCorreo()%>
                                            &&txtclave=<%=u.getContraseña()%> "target="popup" onClick="popup()" target="_blank"  >Actualizar</a></td>

                                    <%}%>

                                </tr>       

                            </tbody>
                        </table>
                    </form>


                </div>

            </div>
        </div>
    </body>

    <br>
    <footer>Derechos reservados Programador Jvier Lopez</footer>
</html>
