/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.model;

/**
 *
 * @author Karla
 */
public class Excursion {
    private int idExcursion;
    private String destino;
    private String actividad;
    private String transporte;
    private String hotel;

    public Excursion(int idExcursion, String destino, String actividad, String transporte, String hotel) {
        this.idExcursion = idExcursion;
        this.destino = destino;
        this.actividad = actividad;
        this.transporte = transporte;
        this.hotel = hotel;
    }
    
    public Excursion(){
        this(0,"","","","");
    }

    public int getIdExcursion() {
        return idExcursion;
    }

    public void setIdExcursion(int idExcursion) {
        this.idExcursion = idExcursion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Excursion{" + "idExcursion=" + idExcursion + ", destino=" + destino + ", actividad=" + actividad + ", transporte=" + transporte + ", hotel=" + hotel + '}';
    }
    
       
    
}
