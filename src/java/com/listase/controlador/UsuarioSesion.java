/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listase.excepciones.UsuarioExcepcion;
import com.listase.modelo.Usuario;
import com.listase.modelo.ListaUS;
import com.listase.modelo.NodoUS;
import com.listase.utilidades.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.connector.StateMachineConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

/**
 *
 * @author Alison
 */
@Named(value = "usuarioSesion")
@SessionScoped
public class UsuarioSesion implements Serializable {
    private ListaUS listaUsuario;
    private Usuario usuario;
    private String alInicio="1";
    private boolean deshabilitarFormulario=true;
    private NodoUS ayudante;   
    private String textoVista="Gráfico";
    
    private List listadoUsuario;
    
    private DefaultDiagramModel model;
    
    private short codigoEliminar;
    
    private ControladorLocalidades controlLocalidades;
    
    private String codigoDeptoSel;
    
    private short usuarioSeleccionado;
    
    private Usuario usuarioDiagrama;
    
    /**
     * Creates a new instance of UsuarioSesion
     */
    public UsuarioSesion() {        
    }
    
    @PostConstruct
    private void inicializar()
    {       
        listaUsuario = new ListaUS();        
        //LLenado de la bds
        listaUsuario.adicionarNodo(new Usuario("LUIS", "123", 1 , "COLOMBIA", 1234, "HONDA", "NEGRO", "GP", "3,4", "luis@gmail.com", "123",2));
        ayudante = listaUsuario.getCabeza();
        usuario = ayudante.getDato();     
        //Me llena el objeto List para la tabla
        listaUsuario = (ListaUS) listaUsuario.obtenerListaUsuario();
//        listaUsuario = listaUsuario.obtenerListaUsuario();
        pintarLista();
   }

    public Usuario getUsuarioDiagrama() {
        return usuarioDiagrama;
    }

    public void setUsuarioDiagrama(Usuario usuarioDiagrama) {
        this.usuarioDiagrama = usuarioDiagrama;
    }
    
    public short getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(short usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
    
    public String getCodigoDeptoSel() {
        return codigoDeptoSel;
    }

    public void setCodigoDeptoSel(String codigoDeptoSel) {
        this.codigoDeptoSel = codigoDeptoSel;
    }

    
    
    public ControladorLocalidades getControlLocalidades() {
        return controlLocalidades;
    }

    public void setControlLocalidades(ControladorLocalidades controlLocalidades) {
        this.controlLocalidades = controlLocalidades;
    }
     
    
    
    public DiagramModel getModel() {
        return model;
    }
     
    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));
         
        if(label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
        }
         
        return conn;
    }

    public short getCodigoEliminar() {
        return codigoEliminar;
    }

    public void setCodigoEliminar(short codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }

    
    
    public String getTextoVista() {
        return textoVista;
    }

    public void setTextoVista(String textoVista) {
        this.textoVista = textoVista;
    }

    
    
    public List getListadoUsuario() {
        return listadoUsuario;
    }

    public void setListadoUsuario(List listadoUsuario) {
        this.listadoUsuario = listadoUsuario;
    }
    
    

    public boolean isDeshabilitarFormulario() {
        return deshabilitarFormulario;
    }

    public void setDeshabilitarFormulario(boolean deshabilitarFormulario) {
        this.deshabilitarFormulario = deshabilitarFormulario;
    }

  
    
    

    public String getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(String alInicio) {
        this.alInicio = alInicio;
    }
    
    public ListaUS getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ListaUS listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    public void guardarUsuario()
    {
        //obtiene el consecutivo
        usuario.setCodigo((short)(listaUsuario.contarNodos()+1));
        if(alInicio.compareTo("1")==0)
        {
            listaUsuario.adicionarNodoAlInicio(usuario);
        }
        else
        {
            listaUsuario.adicionarNodo(usuario);
        }  
        //Vuelvo a llenar la lista para la tabla
        listadoUsuario = listaUsuario.obtenerListaUsuario();
        pintarLista();
        deshabilitarFormulario=true;
        JsfUtil.addSuccessMessage("El usuario se ha guardado exitosamente");
        
    }
    
    public void habilitarFormulario()
    {
        deshabilitarFormulario=false;
        usuario = new Usuario();
    }
    
    public void irSiguiente()
    {
        if(ayudante.getSiguiente()!=null)
        {
            ayudante = ayudante.getSiguiente();
            usuario = ayudante.getDato();
        }        
    }
    
    public void irPrimero()
    {
        if(listaUsuario.getCabeza()!=null)
        {
            ayudante = listaUsuario.getCabeza();
            usuario = ayudante.getDato();
            
        }
        else
        {
            usuario = new Usuario();
        }
        listadoUsuario = listaUsuario.obtenerListaUsuario();
        pintarLista();
             
    }
    
    public void irUltimo()
    {
        if(listaUsuario.getCabeza()!=null)
        {            
            while(ayudante.getSiguiente()!=null)
            {
                ayudante = ayudante.getSiguiente();
            }
            usuario=ayudante.getDato();
        }
    }
    
    public void cambiarVistauUsuario()
    {
        if(textoVista.compareTo("Tabla")==0)
        {
            textoVista = "Gráfico";
        }
        else
        {
            textoVista = "Tabla";
        }
    }
    
    public void invertirLista(){
        //Invierte la lista
        listaUsuario.invertirLista();
        irPrimero();
    }
    
    
    public void pintarLista() {
        //Instancia el modelo
        model = new DefaultDiagramModel();
        //Se establece para que el diagrama pueda tener infinitas flechas
        model.setMaxConnections(-1);

        StateMachineConnector connector = new StateMachineConnector();
        connector.setOrientation(StateMachineConnector.Orientation.ANTICLOCKWISE);
        connector.setPaintStyle("{strokeStyle:'#3399ff',lineWidth:2}");
        model.setDefaultConnector(connector);

        ///Adicionar los elementos
        if (listaUsuario.getCabeza() != null) {
            //llamo a mi ayudante
            NodoUS temp = listaUsuario.getCabeza();
            int posX=2;
            int posY=2;
            //recorro la lista de principio a fin
            while(temp !=null)
            {
                //Parado en un elemento
                //Crea el cuadrito y lo adiciona al modelo
                Element ele = new Element(temp.getDato().getIdentificacion()+" "+
                        temp.getDato().getNombrePiloto(), 
                        posX+"em", posY+"em");
                ele.setId(String.valueOf(temp.getDato().getIdentificacion()));
                //adiciona un conector al cuadrito
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));
                model.addElement(ele);                    
                temp=temp.getSiguiente();
                posX=  posX+5;
                posY= posY+6;
            }            
           
            //Pinta las flechas            
           /* for(int i=0; i < model.getElements().size() -1; i++)
            {
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(1), 
                        model.getElements().get(i+1).getEndPoints().get(0), "Next"));
            }
            */
        }
    }
    
    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("elementId");
         
        usuarioSeleccionado = Short.valueOf(id.replaceAll("frmUsuario:diagrama-", ""));
        System.out.println(usuarioSeleccionado);
        
        
    }

        public void eliminarUsuario()
    {
        listaUsuario.eliminarUsuario(usuarioSeleccionado);
        irPrimero();
    }
    
//    public void adelantarUsuario(){
//    
//    }
//    
    public void obtenerUsuarioDiagrama()
    {
        try {
            usuarioDiagrama = listaUsuario.obtenerUsuario(usuarioSeleccionado);
        } catch (UsuarioExcepcion ex) {
            Logger.getLogger(UsuarioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarAlFinal()
    {
        try {
            ///Buscar el infante y guardar los datos en una variable temporal
            Usuario infTemporal = listaUsuario.obtenerUsuario(usuarioSeleccionado);
            // Eliminar el nodo
            listaUsuario.eliminarUsuario(usuarioSeleccionado);
            // Adicionarlo al final
            listaUsuario.adicionarNodo(infTemporal);
            
            pintarLista();
        } catch (UsuarioExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void enviarAlInicio()
    {
        try {
            ///Buscar el infante y guardar los datos en una variable temporal
            Usuario infTemporal = listaUsuario.obtenerUsuario(usuarioSeleccionado);
            // Eliminar el nodo
            listaUsuario.eliminarUsuario(usuarioSeleccionado);
            // Adicionarlo al inicio
            listaUsuario.adicionarNodoAlInicio(infTemporal);
            
            pintarLista();
        } catch (UsuarioExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
}
