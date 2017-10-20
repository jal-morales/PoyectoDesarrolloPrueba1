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

    //Eliminar 
    
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
    
    
    
  public void AgregarUsuarios(Usuarios user)
    {
               
            try {
                 //llamamos a la conexion 
            Conexion con = new Conexion();
            //llamamos a la clase conect           
                 Connection  conetar=con.getConnection("medipet");
          
            
                  String consulta  = "INSERT INTO usuarios VALUES(null,'" 
                    + user.getTipoPerfil()+ "', '"
                    + user.getRut()+ "', '"      
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

}
