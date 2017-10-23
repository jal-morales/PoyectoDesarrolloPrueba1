/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.PerfilAcceso;
import modelo.Usuarios;

/**
 *
 * @author JavierLopez
 */
public class ControladorUsuario 
{
 
    //Modificar Usaurios
     public void EliminarUsuario(int idUsuari)
    {
        try {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
            
            String consulta="DELETE FROM usuarios WHERE idusuarios="+idUsuari+";";
            
             stms.executeUpdate(consulta);
             
             
             System.out.println("Eliminado exitozamente");
            
        } catch (Exception e) {
            System.out.println("No fue elminicado correctamente");
        }
    }
    
    
    
  public void ModificarUsuarios( int id,String rut,String tipoPerf,String nombre,String fecha,String correo )
    {
               
            try {
                 //llamamos a la conexion 
            Conexion con = new Conexion();
            //llamamos a la clase conect           
                 Connection  conetar=con.getConnection("medipet");
          
            
                  String consulta  = "UPDATE usuarios SET rut='"+rut+"',tipo_perfil='"+tipoPerf+"',"
                       + "nombre='"+nombre+"',fecha_nacimiento='"+fecha+"',correo='"+correo+"' WHERE idusuarios="+id+";";
                      
                    PreparedStatement stms= conetar.prepareStatement(consulta);
                  
                  //llamamos al Statement que ejecutas sentencias Sql
                      
                        stms.executeUpdate(consulta);
                        
                       System.out.println("consulta relizada ");
                      
            } catch (Exception e) 
            {
                System.out.println("Query no ejecutada");
              e.printStackTrace();
            }
    }
    
    
    public ArrayList<Usuarios> UsuariosListar()
    { 
        ArrayList<Usuarios> usuarios_lista=new ArrayList<>();
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
            
            String consulta = "select idusuarios,rut,tipo_perfil,nombre,fecha_nacimiento,correo from usuarios;";           
            
            ResultSet rs =stms.executeQuery(consulta);
            while (rs.next())
            {                
                Usuarios User =new Usuarios();
                
                User.setIdUsuario(Integer.parseInt(rs.getString("idusuarios")));
                User.setRut(rs.getString("rut"));
                User.setTipoPerfil(rs.getString("tipo_perfil"));
                User.setNombre(rs.getString("nombre"));
                User.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                User.setCorreo(rs.getString("correo"));
                usuarios_lista.add(User);

            }
             return usuarios_lista;
        }
        catch(Exception ex)
        {
            
            ex.printStackTrace();
        }
        return new ArrayList<>();
        
    
    }
    
  public void AgregarUsuarios(Usuarios user)
    {
               
            try {
                 //llamamos a la conexion 
            Conexion con = new Conexion();
            //llamamos a la clase conect           
                 Connection  conetar=con.getConnection("medipet");
                 
               
                     String consulta  = "INSERT INTO usuarios VALUES(null,'" 
                    + user.getRut()+ "', '"
                    + user.getTipoPerfil()+ "', '"      
                    + user.getNombre()+ "', '"
                    + user.getFecha_nacimiento()+ "', '"
                    + user.getCorreo()+ "', '"
                    + user.getContraseña()+ "');";     
                  
                    PreparedStatement stms= conetar.prepareStatement(consulta);
                  
                  //llamamos al Statement que ejecutas sentencias Sql
                        if (stms!=null) 
                        {
                        stms.executeUpdate(consulta);
                        System.out.println("Query ejecutada");
                        }
                        else 
                        {
                            System.out.println("Query no ejecutada");
                        }

                   
            } catch (Exception e) 
            {
                System.out.println("Query no ejecutada");
              e.printStackTrace();
            }
            
 
        
    }
  
  
  public boolean BuscarUsserExistente(String user)
  {
      try {
          boolean respuesta;
                 //llamamos a la conexion 
            Conexion con = new Conexion();
            //llamamos a la clase conect           
                 Connection  conetar=con.getConnection("medipet");
                 
                 String  consultasiExiste="select * from usuarios where rut='"+user+"';";
                 PreparedStatement stmsSiExiste= conetar.prepareStatement(consultasiExiste);
                 
                 
                 if (stmsSiExiste!=null) 
                 {
                      return  respuesta=true;
                 }
                else
                 {
                     return respuesta=false;
                 }
      } catch (Exception e)
      {
          return false;
      }
  }
  

}
