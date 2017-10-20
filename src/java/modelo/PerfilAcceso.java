/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author JavierLopez
 */
public class PerfilAcceso 
{
    private int idPerfil;
    private String nombreAcceso;
    private String estado;

    public PerfilAcceso() {
    }

    public PerfilAcceso(int idPerfil, String nombreAcceso, String estado) {
        this.idPerfil = idPerfil;
        this.nombreAcceso = nombreAcceso;
        this.estado = estado;
    }

  
   
    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombreAcceso() {
        return nombreAcceso;
    }

    public void setNombreAcceso(String nombreAcceso) {
        this.nombreAcceso = nombreAcceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
