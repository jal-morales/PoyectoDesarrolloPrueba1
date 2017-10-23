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
public class MedicoTratante 
{
    
    private String rut;
    private String nombre;
    private String estado;
    
    public MedicoTratante() {
    }

    public MedicoTratante(String rut, String nombre, String estado) {
        this.rut = rut;
        this.nombre = nombre;
        this.estado = estado;
      
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
