
function valida_envia()
{ 
   	//valido el nombre 
   	if (document.fvalida.nombre.value.length==0){ 
      	alert("Tiene que escribir su nombre") 
      	document.fvalida.nombre.focus() 
      	return 0; 
   	} 
}

  
            function validar() {
          if (document.formulario.cboPerfilesModificar.value == "porsefecto") 
          { 
                  document.formulario.cboPerfilesModificar();
                  alert("Elija una opción");
                  return false;
          };
                           }				
 
         