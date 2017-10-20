/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuarios;

/**
 *
 * @author JavierLopez
 */
public class ControladorUsuario 
{
    //LIstar   
    public ArrayList<Usuarios> UsuariosListar()
    { 
        ArrayList<Usuarios> usuario_lista=new ArrayList<>();
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            //STATEMENT PERMITE EJECUTAR CONSULTA SQL 
            Statement stms = conexion.createStatement();
            
            String consulta = "select idusuarios,tipo_perfi,nombre,fecha_nacimiento,correo,contraseña from usuarios;";           
            
            ResultSet rs =stms.executeQuery(consulta);
            while (rs.next())
            {                
               Usuarios usuarios =new Usuarios();
               usuarios.setIdUsuario(Integer.parseInt(rs.getString("idusuarios")));
               usuarios.setTipoPerfil("tipo_perfi");
               usuarios.setNombre("nombre");
               usuarios.setFecha_nacimiento("fecha_nacimiento");
               usuarios.setCorreo("correo");
               usuarios.setContraseña("contraseña");
                
                usuario_lista.add(usuarios);

            }
             return usuario_lista;
        }
        catch(Exception ex)
        {
            
            ex.printStackTrace();
        }
        return new ArrayList<>();
        
    
    }
    
}
