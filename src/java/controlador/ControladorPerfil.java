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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.PerfilAcceso;

/**
 *
 * @author JavierLopez
 */
public class ControladorPerfil 
{
    
    
 //LIstar   
    public ArrayList<PerfilAcceso> PerfilesListar()
    { 
        ArrayList<PerfilAcceso> perfil_lista=new ArrayList<>();
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
            
            String consulta = "select idpermisos_usuarios,nombre_permiso,estado_permiso from permisos_usuarios;";           
            
            ResultSet rs =stms.executeQuery(consulta);
            while (rs.next())
            {                
                PerfilAcceso perA =new PerfilAcceso();
                perA.setIdPerfil(Integer.parseInt(rs.getString("idpermisos_usuarios")));
                perA.setNombreAcceso(rs.getString("nombre_permiso"));
                perA.setEstado(rs.getString("estado_permiso"));
                
                perfil_lista.add(perA);

            }
             return perfil_lista;
        }
        catch(Exception ex)
        {
            
            ex.printStackTrace();
        }
        return new ArrayList<>();
        
    
    }
    
//*****************************************************************************************************************************************    

    //LIstar   
    public ArrayList<PerfilAcceso> PerfilesListarActvos()
    { 
        ArrayList<PerfilAcceso> perfil_lista=new ArrayList<>();
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
            
            String consulta = "select * from permisos_usuarios where estado_permiso='Activo';";           
            
            ResultSet rs =stms.executeQuery(consulta);
            while (rs.next())
            {                
                PerfilAcceso perA =new PerfilAcceso();
                perA.setIdPerfil(Integer.parseInt(rs.getString("idpermisos_usuarios")));
                perA.setNombreAcceso(rs.getString("nombre_permiso"));
                perA.setEstado(rs.getString("estado_permiso"));
                
                perfil_lista.add(perA);

            }
             return perfil_lista;
        }
        catch(Exception ex)
        {
            
            ex.printStackTrace();
        }
        return new ArrayList<>();
        
    
    }
 
    
    
    public void AgregarPerfiles(PerfilAcceso permisos)
    {
               
            try {
                 //llamamos a la conexion 
            Conexion con = new Conexion();
            //llamamos a la clase conect           
                 Connection  conetar=con.getConnection("medipet");
          
            
                  String consulta  = "INSERT INTO permisos_usuarios VALUES(null,'" 
                    + permisos.getNombreAcceso()+ "', '"
                    + permisos.getEstado() + "');";     
                  
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
    
    public void actualizar( String perfil,String stado)
         {
         try {
                 //llamamos a la conexion 
            Conexion con = new Conexion();
            //llamamos a la clase conect           
                 Connection  conetar=con.getConnection("medipet");
          
            
                  String consulta  = "UPDATE permisos_usuarios SET estado_permiso='"+stado+"'WHERE nombre_permiso='"+perfil+"';";
           
                                      
                  
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
