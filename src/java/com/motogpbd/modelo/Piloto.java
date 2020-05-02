/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motogpbd.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alison
 */
@Entity
@Table(name = "piloto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piloto.findAll", query = "SELECT p FROM Piloto p")
    , @NamedQuery(name = "Piloto.findByIdentificacion", query = "SELECT p FROM Piloto p WHERE p.identificacion = :identificacion")
    , @NamedQuery(name = "Piloto.findByNombrePiloto", query = "SELECT p FROM Piloto p WHERE p.nombrePiloto = :nombrePiloto")
    , @NamedQuery(name = "Piloto.findByNacionalidad", query = "SELECT p FROM Piloto p WHERE p.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Piloto.findByNumeroParticipacion", query = "SELECT p FROM Piloto p WHERE p.numeroParticipacion = :numeroParticipacion")
    , @NamedQuery(name = "Piloto.findByMarcaMoto", query = "SELECT p FROM Piloto p WHERE p.marcaMoto = :marcaMoto")
    , @NamedQuery(name = "Piloto.findByColorMoto", query = "SELECT p FROM Piloto p WHERE p.colorMoto = :colorMoto")
    , @NamedQuery(name = "Piloto.findByCilindrajeMoto", query = "SELECT p FROM Piloto p WHERE p.cilindrajeMoto = :cilindrajeMoto")
    , @NamedQuery(name = "Piloto.findByTiempoClasificacion", query = "SELECT p FROM Piloto p WHERE p.tiempoClasificacion = :tiempoClasificacion")})
public class Piloto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_piloto")
    private String nombrePiloto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_participacion")
    private int numeroParticipacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "marca_moto")
    private String marcaMoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "color_moto")
    private String colorMoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cilindraje_moto")
    private String cilindrajeMoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tiempo_clasificacion")
    private String tiempoClasificacion;

    public Piloto() {
    }

    public Piloto(String identificacion) {
        this.identificacion = identificacion;
    }

    public Piloto(String identificacion, String nombrePiloto, String nacionalidad, int numeroParticipacion, String marcaMoto, String colorMoto, String cilindrajeMoto, String tiempoClasificacion) {
        this.identificacion = identificacion;
        this.nombrePiloto = nombrePiloto;
        this.nacionalidad = nacionalidad;
        this.numeroParticipacion = numeroParticipacion;
        this.marcaMoto = marcaMoto;
        this.colorMoto = colorMoto;
        this.cilindrajeMoto = cilindrajeMoto;
        this.tiempoClasificacion = tiempoClasificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombrePiloto() {
        return nombrePiloto;
    }

    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piloto)) {
            return false;
        }
        Piloto other = (Piloto) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.motogpbd.modelo.Piloto[ identificacion=" + identificacion + " ]";
    }
    
}
