/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controlador.ControladorCiente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author JavierLopez
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

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
            String rutCliente= request.getParameter("txtrutCliente");
            String nomCliente= request.getParameter("txtNombreCliente");
            String dir_cliente= request.getParameter("txtDireccionCliente");
            String fechaNcimi_cliente= request.getParameter("txtfechNacimientoClientex");
            String correo_cliente= request.getParameter("txtEmailCliente");
            String sexo_cliente= request.getParameter("selectorSexoCliente");
            
            
            String btnAgregar= request.getParameter("btnAgregarCliente");
            //metodo agregar
            
            if (btnAgregar!=null) 
            {
                AgregarCliente(rutCliente, nomCliente, dir_cliente, fechaNcimi_cliente, correo_cliente, sexo_cliente);
                dispatcher = request.getRequestDispatcher("/gestionCliente.jsp");
                dispatcher.forward(request, response);
            }
            
           
        }
    }
    
    
    
    public void AgregarCliente(String rut,String nombre,String direccion,String fecha_nacimienti,String correo,String sexo)
    {
        ControladorCiente ctrClient = new ControladorCiente();
        Cliente cte= new Cliente();
        
        cte.setRut(rut);
        cte.setNombre(nombre);
        cte.setDireccion(direccion);
        cte.setFechaNacimiento(fecha_nacimienti);
        cte.setCorreoElectronico(correo);
        cte.setSexo(sexo);
       ctrClient.AgregarCliente(cte);
    
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
