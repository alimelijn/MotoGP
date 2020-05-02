/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import com.motogp.modelo.TipoUsuario;
import java.io.Serializable;

/**
 *
 * @author Alison
 */
public class Usuario implements Serializable{
    private String nombrePiloto;
    private String identificacion;
    private short codigo;
    private String nacionalidad;
    private int numeroParticipacion;
    private String marcaMoto;
    private String colorMoto;
    private String cilindrajeMoto;
    private String tiempoClasificacion;
    private String correo;
    private String contrasenia;
    private TipoUsuario tipoUsuario;          

    public Usuario() {
    }

    public Usuario(String nombrePiloto, String identificacion, short codigo , String nacionalidad, int numeroParticipacion, String marcaMoto, String colorMoto, String cilindrajeMoto, String tiempoClasificacion, String correo, String contrasenia, TipoUsuario tipoUsuario) {
        this.nombrePiloto = nombrePiloto;
        this.identificacion = identificacion;
        this.codigo = codigo;
        this.nacionalidad = nacionalidad;
        this.numeroParticipacion = numeroParticipacion;
        this.marcaMoto = marcaMoto;
        this.colorMoto = colorMoto;
        this.cilindrajeMoto = cilindrajeMoto;
        this.tiempoClasificacion = tiempoClasificacion;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    

    public String getNombrePiloto() {
        return nombrePiloto;
    }

    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getNumeroParticipacion() {
        return numeroParticipacion;
    }

    public void setNumeroParticipacion(int numeroParticipacion) {
        this.numeroParticipacion = numeroParticipacion;
    }

    public String getMarcaMoto() {
        return marcaMoto;
    }

    public void setMarcaMoto(String marcaMoto) {
        this.marcaMoto = marcaMoto;
    }

    public String getColorMoto() {
        return colorMoto;
    }

    public void setColorMoto(String colorMoto) {
        this.colorMoto = colorMoto;
    }

    public String getCilindrajeMoto() {
        return cilindrajeMoto;
    }

    public void setCilindrajeMoto(String cilindrajeMoto) {
        this.cilindrajeMoto = cilindrajeMoto;
    }

    public String getTiempoClasificacion() {
        return tiempoClasificacion;
    }

    public void setTiempoClasificacion(String tiempoClasificacion) {
        this.tiempoClasificacion = tiempoClasificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }
    
    
    
    
}
