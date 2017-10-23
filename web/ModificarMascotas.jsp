<%-- 
    Document   : ModificarUsuarios
    Created on : 21-oct-2017, 0:30:48
    Author     : JavierLopez
--%>
 <%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.PerfilAcceso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.ControladorPerfil"%>


  <%
             //session.getAttribute("txtNombre");
             
            String idMasocta=request.getParameter("idMascota");
            String nomMascota=request.getParameter("nombreMascota");  
            String estaMascota= request.getParameter("cboestadoMascota");

        %>
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
       
       
            </head>
    <body style="background-color: rgba(152, 130, 163, 0.010);">
     
 
            <div class="container">
               <div class="row"> 
                <div class="col-sm-12">
                       <h2>Modificar Mascota</h2>
                <form name="frmModificarmascota" method="post" action="./MascotaServlet">
                    <table class="table table-hover table table-condensed table table-bordered">
                        <thead>
                            <tr>
                                <th>Nombre:</th>
                                <th><input type="text" name="txtnomModificarMascota" value="<%=nomMascota%>" required></th>

                            </tr>
                            <tr>

                                <th>Tipo Estado</th>
                                <th> <select  name="cboMascotaEstadoModificar" >
                                        <option disabled selected>Seleccione</option>
                                        <option >Activo</option>
                                        <option>Inactivo</option>
                                    
                                              
                                    </select> Estado: <%=estaMascota%>


                                 </th>
                                
            
                                    <input type="text" name="txtidMascotaAModificar" value="<%=idMasocta%>" readonly="readonly" class="hidden">
                            </tr>
                           
                                  
                                     
                                     
                                 
                            

                        </thead>

                    </table>
                                <input type="submit" value="Modificar Mascota" name="btnModificarMascota" class="btn btn-primary">
                                <a href="mtdorTipoMascota.jsp">volver</a>

                                </form>
                                 
                </div>
               </div>                     
            </div>           
    </body>
</html>
