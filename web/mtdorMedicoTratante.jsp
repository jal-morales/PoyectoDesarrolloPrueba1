<%-- 
    Document   : mtdorPerfiljsp
    Created on : 19-oct-2017, 11:54:35
    Author     : JavierLopez
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.MedicoTratante"%>
<%@page import="controlador.ControladorMedicoTratante"%>
<%

    HttpSession sesion = request.getSession();
    ControladorMedicoTratante ctrlMEd = new ControladorMedicoTratante();
    ArrayList<MedicoTratante> listaMedi = ctrlMEd.MedicosListar();
  //-------------------------------------------------------------------


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
        <title>Mantenedor Medicos Tratante</title>
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
        <h1>Hola javier prepara esta vista de mantenedor de Medicos Tratante</h1>
        
        <h4>Agregar Perfil</h4>
        <form name="frmMedicoTratante" method="post" action="./MedicoTratanteServlet">
        <table border="1" width="5" cellspacing="1" cellpadding="2"class="table table-hover table table-condensed table table-bordered">
            <thead>
                <tr>
                    <th>Rut</th>
                    <th>Nombre Medico</th>
                    <th>Estado </th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <input type="text" name="txtRutMedico" placeholder="17336928-k" required>
                    </td>
                     <td>
                        <input type="text" name="txtNombreMedico" placeholder="Javier Lopez" required>
                    </td>
                    <td><select name="selectEstadoMedicoTratante">
                                    <option disabled value="0">Seleccione</option> 
                                    <option>Activo</option>
                                    <option>Inactivo</option>
                        </select>
                            </td>
                   
                </tr>
                
            </tbody>
            
        </table><br><input type="submit" value="Agregar Medico" name="btnAgregarMedico" class="btn btn-primary">
        <br><br>
        </form>
        
    <h3>Medicos Creados</h3>
        <table class="table table-hover table table-condensed table table-bordered">
            <thead>
                <tr>
                  
                    
                    <th>Rut</th>
                    <th>Nombre</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                    <th></th>
                    
                     
                </tr>
            </thead>
            <tbody>

                <%                  for (MedicoTratante u : listaMedi) 
                             
                {%>
                
                <tr>

                    <td> <%= u.getRut()%></td>
                    <td> <%=  u.getNombre()%></td>
                    <td> <%=u.getEstado()%></td>
                    <td><a href="./MedicoTratanteServlet?txtEliminarMedico=<%=u.getRut()%>" target="popup" onClick="popup()" target="_blank">Eliminar</a></td>
                    <td> <a href="ModificarMedico.jsp?RutMedico=<%= u.getRut()%>&&txtNombreMed=<%=  u.getNombre()%> &&txtEstadoMed=<%=u.getEstado()%>"target="popup" onClick="popup()" target="_blank"  >Actualizar</a></td>

                    <%}%>

                </tr>       

            </tbody>
        </table>
</div>
               </div>
           <footer>Derechos reservados Programador Jvier Lopez</footer>
       </div>

         </body><br>
         
     
</html>
