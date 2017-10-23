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
             
      
            String rutMedico=request.getParameter("RutMedico");  
            String NombreMedicos=request.getParameter("txtNombreMed"); 
            String StadoMedico=request.getParameter("txtEstadoMed"); 
          
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
                       <h2>Modificar Medico</h2>
                <form name="frmModificarMedico" method="post" action="./MedicoTratanteServlet">
                    <table class="table table-hover table table-condensed table table-bordered">
                        <thead>
                            <tr>
                                <th>Rut:</th>
                                <th><input type="text" name="txtRutMedicoA" value="<%=rutMedico%>" disabled></th>

                            </tr>
                            <tr>

                                <th>Tipo Perfil:</th>
                                <th> <select  name="cboPerfilesModificar" >
                                        <option disabled selected>Seleccione</option>
                                        <option >-Seleccione-</option>
                                        <option>Activo</option>
                                        <option >Inactivo</option>
                                              
                                    </select> :Perfil <%=StadoMedico%>


                                 </th>


                            </tr>
                            <tr>

                                <th>Nombre:</th>
                                <th><input type="text" name="txtNombreModificar"value="<%=NombreMedicos%>"  required></th>
                                
                        

                            </tr>
                          

                        

                        </thead>

                    </table>
                                <input type="submit" value="Modificar Medico" name="btnModificarMedico" class="btn btn-primary">
                                <a href="mtdorMedicoTratante.jsp">volver</a>

                                </form>
                                 
                </div>
               </div>                     
            </div>           
    </body>
</html>
