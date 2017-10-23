/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controlador.ControladorMedicoTratante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.MedicoTratante;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author JavierLopez
 */
@WebServlet(name = "MedicoTratanteServlet", urlPatterns = {"/MedicoTratanteServlet"})
public class MedicoTratanteServlet extends HttpServlet {

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
            
         String rutMed= request.getParameter("");
         String nombremt= request.getParameter("");
         String estadMedic= request.getParameter("");
         
            AgregarMedico(rutMed, nombremt, estadMedic);
            dispatcher = request.getRequestDispatcher("/mtdorMedicoTratante.jsp"); 
            dispatcher.forward(request, response);
            
            
            
        }
    }
    public void AgregarMedico(String rut,String nombre,String estado)
    {
        ControladorMedicoTratante ctrMeTrata= new ControladorMedicoTratante();
        MedicoTratante mdtra= new MedicoTratante();
        mdtra.setRut(rut);
        mdtra.setNombre(nombre);
        mdtra.setEstado(estado);
        ctrMeTrata.AgregarMedico(mdtra);
                
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
