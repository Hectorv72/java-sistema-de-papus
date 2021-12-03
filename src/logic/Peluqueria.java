/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 *
 * @author D_Soft_01
 */
@Entity
public class Peluqueria implements Serializable {
    @Id
    private int clienteN;
    
    @Basic
    private String nombre;
    private String raza;
    private String color;
    private String alergico;
    private String atencionEsp;
    private String nombreDuenio;
    private String celDuenio;
    private String observaciones;
    
    public Peluqueria(){}

    public Peluqueria(int clienteN, String nombre, String raza, String color, String alergico, String atencionEsp, String nombreDuenio, String celDuenio, String observaciones) {
        this.clienteN = clienteN;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencionEsp = atencionEsp;
        this.nombreDuenio = nombreDuenio;
        this.celDuenio = celDuenio;
        this.observaciones = observaciones;
    }

    public int getClienteN() {
        return clienteN;
    }

    public void setClienteN(int clienteN) {
        this.clienteN = clienteN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtencionEsp() {
        return atencionEsp;
    }

    public void setAtencionEsp(String atencionEsp) {
        this.atencionEsp = atencionEsp;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    public String getCelDuenio() {
        return celDuenio;
    }

    public void setCelDuenio(String celDuenio) {
        this.celDuenio = celDuenio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
