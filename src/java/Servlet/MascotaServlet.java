/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controlador.ControladorMascota;
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
import modelo.TipoMascota;

/**
 *
 * @author JavierLopez
 */
@WebServlet(name = "MascotaServlet", urlPatterns = {"/MascotaServlet"})
public class MascotaServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher dispatcher;
            String TipoMascota= request.getParameter("txtTipoMascota");
            String EstadoMascota=request.getParameter("selectEstadoMacota");
            
            //botones accion
            String btnAgregarMascota= request.getParameter("btnAgregarMascotas");
            String btnModificarMascota= request.getParameter("btnModificarMascota");
            
            //controlador de accion
            if (btnAgregarMascota!=null) 
            {
                AgregartipoMAscota(TipoMascota, EstadoMascota);
                dispatcher = request.getRequestDispatcher("/mtdorTipoMascota.jsp");
                dispatcher.forward(request, response);
            }
            
            //modificar Mascota
            else if (btnModificarMascota!=null) 
            {
                String nombre_mascota= request.getParameter("txtnomModificarMascota");
                String estado_mascota= request.getParameter("cboMascotaEstadoModificar");
                int id_mascota=Integer.parseInt(request.getParameter("txtidMascotaAModificar"));
                try {
                    ActualizarMascota(id_mascota, nombre_mascota, estado_mascota);
                    dispatcher = request.getRequestDispatcher("/mtdorTipoMascota.jsp");
                    dispatcher.forward(request, response);
                } catch (Exception e) 
                
                {
                    System.out.println("No se pudo modificar , Revisar servlet condicion modificar");
                    e.getStackTrace();
                    dispatcher = request.getRequestDispatcher("/mtdorTipoMascota.jsp");
                    dispatcher.forward(request, response);
                }
               
            }
            
            
          
        }
    }
    
    //crear metodo de entrada
    public void AgregartipoMAscota(String nombreTipoMascota, String estadoMascota)
    {
            //llamamos al controladro
        ControladorMascota CtrMcta= new ControladorMascota();
        TipoMascota tmcta=new TipoMascota();
        
        tmcta.setNombreTipoMascota(nombreTipoMascota);
        tmcta.setEstadoTipoMascota(estadoMascota);
        
        CtrMcta.AgreagarTipoMascota(tmcta);
    }

     //metodo obtener Perfiles
        public ArrayList<TipoMascota> MascotasListarAll()
            {
                controlador.ControladorMascota ctrlMcta = new ControladorMascota();
                ArrayList<TipoMascota> lista= new ArrayList<>();

                try {
                    lista=ctrlMcta.TipoMascotasListar();
                    return lista;
                   }
                catch (Exception e) 
                {
                    return new ArrayList<>();
                }
            }
        
        
        public void ActualizarMascota(int idmas,String nombre,String estado)
        {
            ControladorMascota ctrMasc= new ControladorMascota();
            TipoMascota tmas= new TipoMascota();
            
            tmas.setIdTipoMascota(idmas);
            tmas.setNombreTipoMascota(nombre);
            tmas.setEstadoTipoMascota(estado);
            ctrMasc.modificarMascota(idmas, nombre, estado);
                    
            
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
