/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import com.listase.excepciones.UsuarioExcepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alison
 */
public class ListaUS implements Serializable{
    private NodoUS cabeza;
    
    public ListaUS() {
    }

    public NodoUS getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoUS cabeza) {
        this.cabeza = cabeza;
    }
    
    public void adicionarNodo(Usuario usuario)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoUS(usuario);
        }
        else
        {
            //Lamo a mi ayudante
            NodoUS temp= cabeza;
            while(temp.getSiguiente()!=null) //Mientras que en siguiente exista algo
            {
                temp= temp.getSiguiente();
            }
            //temp va estar ubicado en el ultimo nodo
            temp.setSiguiente(new NodoUS(usuario));
        }
        
    }
    
    public void adicionarNodoAlInicio(Usuario usuario)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoUS(usuario);
        }
        else
        {
            NodoUS temp= new NodoUS(usuario);
            temp.setSiguiente(cabeza);
            cabeza= temp;
        }
    }
    
    public short contarNodos()
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            //llamar a mi ayudante
            NodoUS temp= cabeza;
            short cont=1;
            while(temp.getSiguiente()!=null)
            {
                temp=temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    
    public String obtenerListadoUsuario()
    {
        
        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        
        return listarUsuarios("");
    }
    
    public String listarUsuarios(String listado)
    {
        if(cabeza !=null)
        {
            NodoUS temp= cabeza;            
            while(temp!=null)
            {
                listado += temp.getDato()+"\n";
                temp=temp.getSiguiente();
                
            }
            return listado;
        }
        return "No hay usuarios";
    }
    
    
     public List obtenerListaUsuario()
    {
        List<Usuario> listado = new ArrayList<>();
        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        listarUsuarios(listado);
        return listado;
    }
    
    public void listarUsuarios(List listado)
    {
        if(cabeza !=null)
        {
            NodoUS temp= cabeza;            
            while(temp!=null)
            {
                //listado += temp.getDato()+"\n";
                listado.add(temp.getDato());
                temp=temp.getSiguiente();                
            }            
        }
        
    }
    
//    public float promediarEdades()
//    {
//        int sumaEdades= 0;
//        int contador=0;
//        if(cabeza !=null)
//        {
//            Nodo temp= cabeza;            
//            while(temp!=null)
//            {          
//                //sumaEdades= sumaEdades+ temp.getDato().getEdad();
//                sumaEdades += temp.getDato().getEdad();
//                contador++;
//                temp=temp.getSiguiente();                
//            }   
//            return sumaEdades/(float) contador;
//        }
//        return 0;
//        
//    }
    
    
    public void invertirLista()
    {
        if(cabeza!=null)
        {
            //Crear una lista temporal la cabeza de la lista temporal está vacía
            ListaUS listaTemporal = new ListaUS();
            // Llamo un ayudante
            NodoUS temp= cabeza;
            //Recorro la lista de principio a fin
            while(temp!=null)
            {         
               //Parado en cada nodo , se extrae la información y se
                // envía a la otra lista al inicio
                listaTemporal.adicionarNodoAlInicio(temp.getDato());
                temp=temp.getSiguiente();                
            }   
            //Igualo la cabeza de mi lista principal a la cabeza de la lista temporal
            cabeza= listaTemporal.getCabeza();
        }
    }

    public void eliminarUsuario(String identificacion) throws UsuarioExcepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getIdentificacion().equals(identificacion))
            {
                cabeza=cabeza.getSiguiente();
                return;
            }
            else
            {
                NodoUS temp=cabeza;
                while(temp.getSiguiente()!=null)
                {
                    if(temp.getSiguiente().getDato().getIdentificacion().equals(identificacion))
                    {
                        //el que sigue es el que hay que eliminar
                        temp.setSiguiente(temp.getSiguiente().getSiguiente());
                        return;
                    }
                    temp = temp.getSiguiente();
                }
                
                throw new UsuarioExcepcion("El código "+identificacion +" no existe en la lista");
            }
        }
        throw new UsuarioExcepcion("La lista de usuario está vacía");
    }
    
    
     public Usuario obtenerUsuario(short codigo ) throws UsuarioExcepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getCodigo()==codigo)
            {                
                return cabeza.getDato();
            }
            else
            {
                NodoUS temp=cabeza;
                while(temp!=null)
                {
                    if(temp.getDato().getCodigo()==codigo)
                    {                                                
                        return temp.getDato();
                    }
                    temp = temp.getSiguiente();
                }
                
                throw new UsuarioExcepcion("El código "+ codigo +" no existe en la lista");
            }
        }
        throw new UsuarioExcepcion("La lista de infantes está vacía");
    }

    public void eliminarUsuario(short usuarioSeleccionado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
