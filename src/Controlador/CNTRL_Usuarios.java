/*
 * Tarea 02
 * Sistema Academico con conexion a Base de Datos
 * 
 * Estudiante: Daniel Somarribas Quir�s
 * Carnet: b57072
 * Mayo, 2016
 */
package Controlador;

import Modelo.Database.ConexionBD;
import Vista.Frame.Administrar.FRM_Usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author DanielSQ
 */
public class CNTRL_Usuarios implements ActionListener{
    FRM_Usuarios frame;
    ConexionBD baseDatos;
    
    public CNTRL_Usuarios(FRM_Usuarios frame, ConexionBD baseDatos)
    {
        this.frame = frame;
        this.baseDatos = baseDatos;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Agregar"))
        {
            agregar();
            System.out.println("Agregar");    
        }
        
        if(e.getActionCommand().equals("Modificar"))
        {
            modificar();
            System.out.println("Modificar");
        }
        
        if(e.getActionCommand().equals("Eliminar"))
        {
            eliminar();
            System.out.println("Eliminar");
        }
    }
    
    /**
     * Agrega el usuario a la base de datos.
     * 
     * Obtiene el código, el nombre y la contraseña del usuario del frame y lo añade a la base.
     * La base determina si el usuario ya está usado (es llave primaria)
     */
    public void agregar()
    {
        String[] info = frame.getInfo();
        
        String user = info[0];
        String nombre = info[1];
        String pass = info[2];
        
        System.out.println("Usuario:\n"
                +"ID: "+user+"\n"
                +"Nombre: "+nombre+"\n"
                +"Dirección: "+pass+"");
        
        if(nombre.equals("") || pass.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
        else
        {
            if(baseDatos.agregarUser(user, nombre, pass))
            {
                System.out.println("Usuario Agregado Correctamente");
                frameReset();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No se ha podido Agregar el Usuario.\n");
            }
        }
    }
    
    /**
     * Envía el nombre de usuario para buscar en la base de datos.
     * Lo realiza cada vez que se escribe, por lo cual no requiere el botón buscar.
     * 
     * Si el nombre se encuentra, llena los campos de texto y bloquea el botón de agregar.
     * Si no se encuentra, limpia los campos de nombre y contraseña, y bloquea los botones de modificar y eliminar.
     */
    public void buscar()
    {
        System.out.println("Buscar");
        
        String user = frame.getUser();
        
        String[] info= baseDatos.buscarUser(user);
        
        if(info[0] != null)
        {
            frame.fillField(info[0]);
            frame.siEntidadConf();
        }
        else
        {
            frame.clearPartialField();
            frame.noEntidadConf();
        }
    }
    
    /**
     * Envía la nueva información a la conexión de la base, y le pide cambiarla.
     */
    public void modificar()
    {
        String[] info = frame.getInfo();
        
        String user = info[0];
        String nombre = info[1];
        String pass = info[2];
        
        if(baseDatos.modificarUser(user, nombre, pass))
        {
            JOptionPane.showMessageDialog(null, "Usuario Modificado Correctamente");
            frameReset();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se ha podido Modificar el Usuario.");
        }
    }
    
    /**
     * Envía el código del Estudiante a la base de datos para Eliminar
     */
    public void eliminar()
    {
        String user = frame.getUser();
                
        if(baseDatos.eliminarUser(user))
        {
            JOptionPane.showMessageDialog(null, "Usuario Eliminado Correctamente");
            frameReset();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se ha podido Eliminar el Usuario");
        }
    }
    
    /**
     * Reinicia el Frame
     */
    public void frameReset()
    {
        frame.clearFields();
        frame.nadaConf();
    }
}
