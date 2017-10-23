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
public class TipoMascota 
{
    private int idTipoMascota;
    private String nombreTipoMascota;
    private String estadoTipoMascota;

    public TipoMascota(int idTipoMascota, String nombreTipoMascota, String estadoTipoMascota) {
        this.idTipoMascota = idTipoMascota;
        this.nombreTipoMascota = nombreTipoMascota;
        this.estadoTipoMascota = estadoTipoMascota;
    }

    public TipoMascota() {
    }

    public int getIdTipoMascota() {
        return idTipoMascota;
    }

    public void setIdTipoMascota(int idTipoMascota) {
        this.idTipoMascota = idTipoMascota;
    }

    public String getNombreTipoMascota() {
        return nombreTipoMascota;
    }

    public void setNombreTipoMascota(String nombreTipoMascota) {
        this.nombreTipoMascota = nombreTipoMascota;
    }

    public String getEstadoTipoMascota() {
        return estadoTipoMascota;
    }

    public void setEstadoTipoMascota(String estadoTipoMascota) {
        this.estadoTipoMascota = estadoTipoMascota;
    }

   
    
    
}
