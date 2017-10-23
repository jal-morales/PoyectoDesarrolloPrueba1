
package Servlet;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;
import controlador.ControladorMedicoTratante;
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
import modelo.MedicoTratante;
import modelo.Usuarios;
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
            
            String btnAgregar= request.getParameter("btnAgregarMedico");
            String linkEliminar= request.getParameter("txtEliminarMedico");
            String ActualizarMedico= request.getParameter("btnModificarMedico");
            
            String rutMedico= request.getParameter("txtRutMedico");
            String nombMedico= request.getParameter("txtNombreMedico");
            String estadoMedico= request.getParameter("selectEstadoMedicoTratante");
                        
            //Metodo Agregar Medico 
            if (btnAgregar!=null)             
            {
                MedicoAgregar(rutMedico, nombMedico, estadoMedico);

                 dispatcher = request.getRequestDispatcher("/mtdorMedicoTratante.jsp"); 
                 dispatcher.forward(request, response);
            }
            //Eliminar Medico
            else if (linkEliminar!=null) 
            
            {
                EliminarMedico(linkEliminar);
                 dispatcher = request.getRequestDispatcher("/mtdorMedicoTratante.jsp"); 
                 dispatcher.forward(request, response);
            }
            //Modificar Medico
            else if (ActualizarMedico!=null)
                
            {
                String nuevoNombreMed= request.getParameter("txtNombreModificar");
                String nuevoPerfilMed= request.getParameter("cboPerfilesModificar");
                    String medicoRutID= request.getParameter("txtRutMedicoA");
               
                try {
                    ModificarMedico(medicoRutID, nuevoNombreMed, nuevoPerfilMed);
                    System.out.println("Mod servlet");
                } catch (Exception e)
                {
                    System.out.println("El try del servlet ");
                    e.getStackTrace();
                }
                    
                    
                    
                    dispatcher = request.getRequestDispatcher("/mtdorMedicoTratante.jsp"); 
                   dispatcher.forward(request, response);
 
            }
            
        }
    }


    
     
        public void MedicoAgregar(String rut,String nombre,String tipoPerfil)
        {
            ControladorMedicoTratante ctrolMedic= new ControladorMedicoTratante();
            MedicoTratante med= new MedicoTratante();
         
            med.setRut(rut);
            med.setNombre(nombre);
            med.setEstado(tipoPerfil);

            ctrolMedic.AgregarMedicoTratante(med);
        }
    
    //metodo obtener Perfiles Funcionando 
    public ArrayList<MedicoTratante> MedicoListar() {
        controlador.ControladorMedicoTratante ctrlmedi = new ControladorMedicoTratante();
        ArrayList<MedicoTratante> lista_medi = new ArrayList<>();

        try {
            lista_medi = ctrlmedi.MedicosListar();

            return lista_medi;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

   public void EliminarMedico(String med)
   {
       ControladorMedicoTratante ctrmed= new ControladorMedicoTratante();
       ctrmed.EliminarMedico(med);
 
   }
   
    public void ModificarMedico(String rut,String nomb, String estado)
    {
        try { 
             ControladorMedicoTratante ctrMed= new ControladorMedicoTratante();
             MedicoTratante med= new MedicoTratante();
             med.getRut();
             med.setNombre(nomb);
             med.setEstado(estado);
             ctrMed.ModificarUsuarios(rut, nomb, estado);
             
             
        } catch (Exception e) {
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
