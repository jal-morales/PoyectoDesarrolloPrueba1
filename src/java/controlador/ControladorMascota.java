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
import modelo.TipoMascota;

/**
 *
 * @author JavierLopez
 */
public class ControladorMascota 

{
 
    public void AgreagarTipoMascota(TipoMascota tipomascota)
    {
        try {
             Conexion con= new Conexion();
          Connection conectar= con.getConnection("medipet");
          
          String consulta  = "INSERT INTO tipomascotas VALUES(null,'" 
                    + tipomascota.getNombreTipoMascota()+ "', '"
                    + tipomascota.getEstadoTipoMascota()+ "');";  
          
           PreparedStatement stms= conectar.prepareStatement(consulta);
           
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
            e.getStackTrace();
            System.out.println("No se pudo crear mascota mensaje del Exception");
        }
      } 
        
     //LIstar solo activos 
    public ArrayList<TipoMascota> TipoMascotasListarActvos()
    { 
        ArrayList<TipoMascota> mascota_lista=new ArrayList<>();
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
            
            String consulta = "select idtipo_mascota,mascota_tipo,mascota_estado from tipomascotas;";           
            
            ResultSet rs =stms.executeQuery(consulta);
            while (rs.next())
            {                
                TipoMascota tipMas =new TipoMascota();
                tipMas.setIdTipoMascota(Integer.parseInt(rs.getString("idtipo_mascota")));
                tipMas.setNombreTipoMascota(rs.getString("mascota_tipo"));
                tipMas.setEstadoTipoMascota(rs.getString("mascota_estado"));
                
                mascota_lista.add(tipMas);

            }
             return mascota_lista;
        }
        catch(Exception ex)
        {
            
            ex.printStackTrace();
        }
        return new ArrayList<>();
        
    
    
    }
    
    
     //LIstar Todos
    public ArrayList<TipoMascota> TipoMascotasListar()
    { 
        ArrayList<TipoMascota> mascota_lista=new ArrayList<>();
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
            
            String consulta = "select idtipo_mascota,mascota_tipo,mascota_estado from tipomascotas;";           
            
            ResultSet rs =stms.executeQuery(consulta);
            while (rs.next())
            {                
                TipoMascota tipMas =new TipoMascota();
                tipMas.setIdTipoMascota(Integer.parseInt(rs.getString("idtipo_mascota")));
                tipMas.setNombreTipoMascota(rs.getString("mascota_tipo"));
                tipMas.setEstadoTipoMascota(rs.getString("mascota_estado"));
                
                mascota_lista.add(tipMas);

            }
             return mascota_lista;
        }
        catch(Exception ex)
        {
            
            ex.printStackTrace();
        }
        return new ArrayList<>();
        
    
        
    
    }
 //-------Eliminar Mascota   
     public void EliminarMascota(int idmascota)
         {
             try {
                 
                 Conexion con = new Conexion();
             Connection conectar= con.getConnection("medipet");
             
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conectar.createStatement();
            
            String consulta="DELETE FROM tipomascotas WHERE idtipo_mascota="+idmascota+";";
            
             stms.executeUpdate(consulta);
             
             
             System.out.println("Eliminado exitozamente");
             } catch (Exception e) {
             }
             
         }
     
     
     //modificar mascota
     
     public void modificarMascota(int id, String nombre, String estado)
     {
         try {
                  
                 Conexion con = new Conexion();
             Connection conectar= con.getConnection("medipet");
             
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conectar.createStatement();
            
            String consulta="UPDATE tipomascotas SET mascota_tipo='"+nombre+"',mascota_estado='"+estado+"'"
                    + " WHERE idtipo_mascota="+id+";";
            
            stms.executeUpdate(consulta);
             System.out.println("Consulta realizada en Controlador mascota");
                  
         } catch (Exception e) 
         {
             System.out.println("Fallo la actualizacion de Mascota");
             e.getStackTrace();
         }
     
     }
}
