/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controlador.ControladorUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuarios;


/**
 *
 * @author JavierLopez
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/UsuariosServlet"})
public class UsuariosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
           

               RequestDispatcher dispatcher;
            String rutPerfil= request.getParameter("txtrut");
            String tipo_perfil= request.getParameter("cboPerfiles");
            String nombreU=request.getParameter("txtNombre");
            String fecha_nac= request.getParameter("txtfecha");
            String correo=request.getParameter("txtemail");
            String pass= request.getParameter("txtclave");
           
             
            AgregarUsser(rutPerfil,tipo_perfil, nombreU, fecha_nac, correo, pass);
             dispatcher = request.getRequestDispatcher("/mtdorUsuario.jsp"); 
             dispatcher.forward(request, response);
 
        }
    }

    
   
    
    //metodo obtener Perfiles
        public ArrayList<Usuarios> UsuariosListar()
            {
                controlador.ControladorUsuario ctrlusu = new ControladorUsuario();
                ArrayList<Usuarios> lista_usua= new ArrayList<>();

                try {
                    lista_usua=ctrlusu.UsuariosListar();
                    
                    return lista_usua;
                   }
                catch (Exception e) 
                {
                    return new ArrayList<>();
                }
            }
        
        
        public void AgregarUsser(String rut,String tipoPerfil,String nombre,String fecha,String correo,String pass)
        {
            ControladorUsuario ctrolUsser= new ControladorUsuario();
            Usuarios usser= new Usuarios();
            
            usser.setRut(rut);
            usser.setTipoPerfil(tipoPerfil);
            usser.setNombre(nombre);
            usser.setFecha_nacimiento(fecha);
            usser.setCorreo(correo);
            usser.setContraseña(correo);
            
            ctrolUsser.AgregarUsuarios(usser);
        }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
