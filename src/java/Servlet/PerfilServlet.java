/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controlador.ControladorPerfil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.PerfilAcceso;

/**
 *
 * @author JavierLopez
 */
@WebServlet(name = "PerfilServlet", urlPatterns = {"/PerfilServlet"})
public class PerfilServlet extends HttpServlet {

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
            
            String Perfil= request.getParameter("txtNombrePerfil");
            String EPerfil= request.getParameter("selectestado");
            

         AgregarPerfil(Perfil, EPerfil);
         dispatcher = request.getRequestDispatcher("/index.jsp"); 
         dispatcher.forward(request, response);
               
                
           
    
    }
    }
   public void AgregarPerfil(String Perfil, String EPerfil)
   {
       //controlador
       ControladorPerfil CtrPerfil= new ControladorPerfil();
       PerfilAcceso per= new PerfilAcceso();
       
       per.setNombreAcceso(Perfil);
       per.setEstado(EPerfil);
       
       CtrPerfil.AgregarPerfiles(per);
       
   }
  
      //metodo obtener Perfiles
        public ArrayList<PerfilAcceso> PerfilesListar()
            {
                controlador.ControladorPerfil ctrlpefl = new ControladorPerfil();
                ArrayList<PerfilAcceso> lista= new ArrayList<>();

                try {
                    lista=ctrlpefl.PerfilesListar();
                    return lista;
                   }
                catch (Exception e) 
                {
                    return new ArrayList<>();
                }
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
