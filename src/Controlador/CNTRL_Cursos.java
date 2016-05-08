/*
 * Tarea 02
 * Sistema Academico con conexion a Base de Datos
 * Nota: Para usar esta aplicación se requiere una base de datos en mysql de nombre "academico"
 * 
 * Curso: Daniel Somarribas Quir�s
 * Carnet: b57072
 * Mayo, 2016
 */
package Controlador;

import Modelo.Database.ConexionBD;
import Vista.Frame.Administrar.FRM_Cursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Clase para el controlador del administrador de estudiantes
 * @author DanielSQ
 */
public class CNTRL_Cursos implements ActionListener
{
    ConexionBD baseDatos;
    FRM_Cursos frame;
    
    /**
     * Crea el controlador del Administrador de Cursos
     * @param frame
     * @param baseDatos
     */
    public CNTRL_Cursos(FRM_Cursos frame, ConexionBD baseDatos)
    {
        this.frame = frame;
        this.baseDatos = baseDatos;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
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
     * Agrega el estudiante a la base de datos.
     * 
     * Obtiene el código, el nombre y la dirección del estudiante del frame y lo añade a la base.
     * La base determina si el código ya está usado (es llave primaria)
     */
    public void agregar()
    {
        String[] info = frame.getInfo();
        
        String estudianteID = info[0];
        String nombre = info[1];
        String direccion = info[2];
        
        System.out.println("Curso:\n"
                +"ID: "+estudianteID+"\n"
                +"Nombre: "+nombre+"\n"
                +"Dirección: "+direccion+"");
        
        if(nombre.equals("") || direccion.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
        else
        {
            if(baseDatos.agregarCurso(estudianteID, nombre, direccion))
            {
                System.out.println("Curso Agregado Correctamente");
                frameReset();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No se ha podido Agregar el Curso.\n"
                        +"Asegúrese de que el código de curso no esté repetido y que los créditos sean un número.");
            }
        }
    }
    
    /**
     * Envía el código del curso para buscar en la base de datos.
     * Lo realiza cada vez que se escribe, por lo cual no requiere el botón buscar.
     * 
     * Si el código se encuentra, llena los campos de texto y bloquea el botón de agregar.
     * Si no se encuentra, limpia los campos de nombre y dirección, y bloquea los botones de modificar y eliminar.
     */
    public void buscar()
    {
        System.out.println("Buscar");
        
        String estudianteID = frame.getID();
        
        String[] info= baseDatos.buscarCurso(estudianteID);
        
        if(info[0] != null)
        {
            frame.fillFields(info);
            frame.siEntidadConf();
        }
        else
        {
            frame.clearPartialFields();
            frame.noEntidadConf();
        }
    }
    
    /**
     * Envía la nueva información a la conexión de la base, y le pide cambiarla.
     */
    public void modificar()
    {
        String[] info = frame.getInfo();
        
        String estudianteID = info[0];
        String nombre = info[1];
        String direccion = info[2];
        
        if(baseDatos.modificarCurso(estudianteID, nombre, direccion))
        {
            JOptionPane.showMessageDialog(null, "Curso Modificado Correctamente");
            frameReset();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se ha podido Modificar el Curso.");
        }
    }
    
    /**
     * Envía el código del Curso a la base de datos para Eliminar
     */
    public void eliminar()
    {
        String estudianteID = frame.getID();
        
        if(baseDatos.eliminarCurso(estudianteID))
        {
            JOptionPane.showMessageDialog(null, "Curso Eliminado Correctamente");
            frameReset();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se ha podido Eliminar el Curso");
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
