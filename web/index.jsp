<%@page import="java.util.ArrayList"%>
<%@page import="modelo.PerfilAcceso"%>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Trabajo Programacion en Java</title>
  <link href="./css/bootstrap.min.css" rel="stylesheet">
  <link href="./css/main.css" rel="stylesheet">
  <script src="./js/jquery.min.js"></script>
  <script src="./js/bootstrap.min.js"></script>
</head>
<body>
     
    
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
            	<li><a href="">Ingresgar consulta </a></li>
                <li><a href="">Buscar consulta </a></li>
                <li><a href="">Eliminar consulta</a></li>
   			</ul>     
        </li>
        <li><a href="#">Gestion</a>
        	<ul class="sub_menu">
            	<li><a href="">Gestiona Consultas</a></li>
                <li><a href="">Consultas Pendientes</a></li>
                <li><a href="">Consultas Realizadas</a></li>
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
       
    
             
    </body>
</html>
