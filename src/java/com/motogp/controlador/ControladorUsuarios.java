/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motogp.controlador;

import com.motogp.modelo.TipoUsuario;
import com.listase.modelo.Usuario;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alison
 */
public class ControladorUsuarios {
    private List<TipoUsuario> tiposUsuario; 
    private List<Usuario> usuarios;

    public ControladorUsuarios() {
//        this.iniciarListados();
    }

    public List<TipoUsuario> getTiposUsuario() {
        return tiposUsuario;
    }

    public void setTiposUsuario(List<TipoUsuario> tiposUsuario) {
        this.tiposUsuario = tiposUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
//    private void iniciarListados(){
//        //simula archivos planos o cargada de bases de datos
//        tiposUsuario = new ArrayList<>();
//        tiposUsuario.add(new TipoUsuario(1,"Administrador"));
//        tiposUsuario.add(new TipoUsuario(2,"Consulta"));
//        
//        usuarios = new ArrayList<>();
//        usuarios.add(new Usuario("Alison Jimenez", "1007831974", "colombiana", 0, "eg", "jbcwf", "ybu", "hbub", "alisonjimenez86@gmail.com", "123",tiposUsuario.get(0)));
//        usuarios.add(new Usuario("Alison Jimenez", "1007831974", "colombiana", 0, "eg", "jbcwf", "ybu", "hbub", "alisonjimenez86@gmail.com", "123",tiposUsuario.get(1)));
//    }
    
//    public Usuario encontrarUsuCorreo(String correo){
//        
//    }
}
