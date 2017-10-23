<%@page import="java.sql.Connection"%>
<%@page import="bd.Conexion"%>
<%

  //style="background-image:url(img/inicio2.jpg) "

%>


<%@page import="java.util.ArrayList"%>
<%@page import="modelo.PerfilAcceso"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/estilos.css" rel="stylesheet" type="text/css" />
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="css/navbar-static-top.css" rel="stylesheet" type="text/css" />
    <title>Trabajo Programacion en Java</title>

</head>
<body >

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

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <section >
        <p>Clínica Veterinaria Medipet

            Desde 1998 el propósito fundamental de esta área ha sido  la prevención de enfermedades. Para ello nuestros veterinarios en Santiago centro entregan la información y herramientas necesarias para que el dueño pueda mantener a su mascota en forma sana y segura, de acuerdo a los actuales estándares de tenencia responsable de mascotas.
            Hacemos un uso intensivo de las nuevas tecnologías, siendo pioneros en Internet usado como medio natural de comunicación con los clientes, en Centralvet nuestros clientes pueden acceder al carnet de vacunas de su mascota el cual siempre esta en linea en la web.

            Promoción AM!</p> 
    </section>
 
        <p>
          <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
        </p>
      </div>
 <footer>Derechos reservados Programador Jvier Lopez</footer>
    </div> <!-- /container -->


</body><br>
   
</html>
