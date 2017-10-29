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
             
            String rut=request.getParameter("txtrut");
            String TipoPerfil=request.getParameter("cboPerfiles");  
            String Nombre=request.getParameter("txtNombre");
            String Fecha=request.getParameter("txtfecha");  
            String correo=request.getParameter("txtemail"); 
            String id= request.getParameter("txtActualizarUser");
            //int id=Integer.parseInt(request.getParameter("txtEliminarUser"));  
             
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
                       <h2>Modificar Usuario</h2>
                <form name="frmModificarUsuario" method="post" action="./UsuariosServlet">
                    <table class="table table-hover table table-condensed table table-bordered">
                        <thead>
                            <tr>
                                <th>Rut:</th>
                                <th><input type="text" name="txtrutModificar" value="<%=rut%>" required></th>

                            </tr>
                            <tr>

                                <th>Tipo Perfil:</th>
                                <th> <select  name="cboPerfilesModificar" >
                                        <option disabled selected>Seleccione</option>
                                        <option >Operario</option>
                                        <option>Administrador</option>
                                        <option >Medico Tratante</option>
                                              
                                    </select> :Perfil <%=TipoPerfil%>


                                 </th>


                            </tr>
                            <tr>

                                <th>Nombre:</th>
                                <th><input type="text" name="txtNombreModificar"value="<%=Nombre%>"  required></th>
                                


                            </tr>
                            <tr>

                                <th>Fecha Nacimiento:</th>
                                <th><input type="date" name="txtfechaModificar" value="<%=Fecha%>"   required > :<%=Fecha%></th>
                               

                            </tr>
                            <tr>

                                <th>Correo Electronico:</th>
                                <th><input type="email" name="txtemailModificar"value="<%=correo%>" ></th>

                            </tr>
                            <tr>

                                <th></th>
                                <th><input type="text" name="txtidUnico"value="<%=id%>" readonly="readonly" class="hidden" ></th>

                            </tr>


                        

                        </thead>

                    </table>
                                <input type="submit" value="Modificar Usuario" name="btnModificarUsuario" class="btn btn-primary" onclick="IsNullSelector()">
                                <a href="mtdorUsuario.jsp">volver</a>

                                </form>
                                 
                </div>
               </div>                     
            </div>           
    </body>
</html>
