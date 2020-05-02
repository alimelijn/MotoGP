/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import com.listase.modelo.Usuario;
import java.io.Serializable;

/**
 *
 * @author Alison
 */
public class NodoUS implements Serializable{
    private Usuario dato;
    private NodoUS siguiente;

    public NodoUS(Usuario dato) {
        this.dato = dato;
    }

    public Usuario getDato() {
        return dato;
    }

    public void setDato(Usuario dato) {
        this.dato = dato;
    }

    public NodoUS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoUS siguiente) {
        this.siguiente = siguiente;
    }

    
}
