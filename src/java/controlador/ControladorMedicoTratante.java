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
import modelo.MedicoTratante;
import modelo.Usuarios;

/**
 *
 * @author JavierLopez
 */







public class ControladorMedicoTratante 

{
    //metodo Agregar
 public void AgregarMedicoTratante(MedicoTratante medt)
    {
               
            try {
                 //llamamos a la conexion 
             Conexion con= new Conexion();
               Connection conectar= con.getConnection("medipet");
                 
               
                     String consulta  = "INSERT INTO medico_tratante VALUES('" 
                    + medt.getRut()+ "', '"
                    + medt.getNombre()+ "', '"     
                    + medt.getEstado()+ "');";     
                  
                    PreparedStatement stms= conectar.prepareStatement(consulta);
                   
                  //llamamos al Statement que ejecutas sentencias Sql
                        if (stms!=null) 
                        {
                        stms.executeUpdate(consulta);
                        System.out.println("Query ejecutada");
                        }
                        else 
                        {
                            System.out.println("Query no ejecutada Error if del controlador medico");
                        }

                   
            } catch (Exception e) 
            {
                System.out.println("Query no ejecutada error Try...de controlador medico");
              e.printStackTrace();
            }
            
 
        
    }

    
 //listar Medicos
        public ArrayList<MedicoTratante> MedicosListar()
    { 
        ArrayList<MedicoTratante> medicos_lista=new ArrayList<>();
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
            
            String consulta = "select rutMedico,nombreMedico,Estado_Medico from medico_tratante;"; 
            
            
            ResultSet rs =stms.executeQuery(consulta);
            while (rs.next())
            {                
                MedicoTratante meDco =new MedicoTratante();
                
               
                meDco.setRut(rs.getString("rutMedico"));
                meDco.setNombre(rs.getString("nombreMedico"));
                meDco.setEstado(rs.getString("Estado_Medico"));
                medicos_lista.add(meDco);

            }
             return medicos_lista;
        }
        catch(Exception ex)
        {
            
            ex.printStackTrace();
        }
        return new ArrayList<>();
        
    }
        
        
     
        
 //metodo Actualizar medico Funcionando        
  public void ModificarUsuarios(String rutMed,String Nombre,String TipoEstad)
    {
               
            try {
                 //llamamos a la conexion 
            Conexion con = new Conexion();
            //llamamos a la clase conect           
           Connection  conetar=con.getConnection("medipet");
          
            
                  String consulta  = "UPDATE medico_tratante SET nombreMedico='"+Nombre+"',Estado_Medico='"+TipoEstad+"' WHERE rutMedico='"+rutMed+"';";
                      
                    PreparedStatement stms= conetar.prepareStatement(consulta);
                  
                  //llamamos al Statement que ejecutas sentencias Sql
                    if (stms!=null) 
                    {
                     stms.executeUpdate(consulta);
                     System.out.println("consulta relizada Controlador");
                    }
                    else
                     {
                           System.out.println("stms");
                     }
                      
                        
                      
            } catch (Exception e) 
            {
                System.out.println("Query no ejecutada revisar try....");
              e.printStackTrace();
            }
    }
    
   
   public void EliminarMedico(String rut)
   {
       try {
             Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
            
            String consulta="DELETE FROM medico_tratante WHERE rutMedico='"+rut+"';";
            
            stms.executeUpdate(consulta);
            
            if (stms!=null) 
            {
                System.out.println("Qry eliminar medico Ejecutada");
            }
            else
            {
                System.out.println("No se pudo eliminar revisar dentro try Medico");
            }
            
            
       } catch (Exception e) 
       {
           System.out.println("Error, controlador Medico try.....");
       }
           
   }
    
}



