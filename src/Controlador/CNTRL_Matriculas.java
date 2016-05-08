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
import Vista.Frame.Administrar.FRM_Matriculas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author DanielSQ
 */
public class CNTRL_Matriculas implements ActionListener {

    ConexionBD baseDatos;
    FRM_Matriculas frame;
    
    public CNTRL_Matriculas(ConexionBD baseDatos, FRM_Matriculas frame)
    {
        this.baseDatos = baseDatos;
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Agregar"))
        {
            realizar();
            System.out.println("Agregar");
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            eliminar();
            System.out.println("Eliminar");
        }
        if(e.getActionCommand().equals("Reiniciar"))
        {
            resetFrame();
        }
    }
    
    /**
     * Envía el código del estudiante para buscar en la base de datos.
     * Lo realiza cada vez que se escribe, por lo cual no requiere el botón buscar.
     * 
     * Si el código se encuentra, llena los campos de texto y bloquea el botón de agregar.
     * Si no se encuentra, limpia los campos de nombre y dirección, y bloquea los botones de modificar y eliminar.
     */
    public void buscarEstudiante()
    {
        System.out.println("Buscar");
        
        String estudianteID = frame.getEstudianteID();
        
        String[] info= baseDatos.buscarEstudiante(estudianteID);
        
        if(info[0] != null)
        {
            frame.fillFieldsEstudiante(info);
            frame.estudianteEncontrado(true);
        }
        else
        {
            frame.clearPartialFieldsEstudiante();
            frame.estudianteEncontrado(false);
        }
    }
    
    /**
     * Envía el código del curso para buscar en la base de datos.
     * Lo realiza cada vez que se escribe, por lo cual no requiere el botón buscar.
     * 
     * Si el código se encuentra, llena los campos de texto y bloquea el botón de agregar.
     * Si no se encuentra, limpia los campos de nombre y dirección, y bloquea los botones de modificar y eliminar.
     */
    public void buscarCurso()
    {
        System.out.println("Buscar");
        
        String estudianteID = frame.getCursoID();
        
        String[] info= baseDatos.buscarCurso(estudianteID);
        
        if(info[0] != null)
        {
            frame.fillFieldsCurso(info);
            frame.cursoEncontrado(true);
        }
        else
        {
            frame.clearPartialFieldsCurso();
            frame.cursoEncontrado(false);
        }
    }
    
    /**
     * Envía el código de estudiante y de curso para realizar la matrícula
     */
    public void realizar()
    {
        String estudianteID = frame.getEstudianteID();
        String cursoID = frame.getCursoID();
        
        if(baseDatos.agregarMatricula(estudianteID, cursoID))
        {
            JOptionPane.showMessageDialog(null, "Matrícula Realizada con Éxito");
            resetFrame();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error al realizar la Matrícula.\nPor favor intente más tarde.");
        }
    }
    
    /**
     * Envía el código de estudiante y de curso para eliminar la matrícula
     */
    public void eliminar()
    {
        String estudianteID = frame.getEstudianteID();
        String cursoID = frame.getCursoID();
        
        if(baseDatos.eliminarMatricula(estudianteID, cursoID))
        {
            JOptionPane.showMessageDialog(null, "Matrícula Eliminada con Éxito");
            resetFrame();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error al Eliminar la Matrícula.\nPor favor intente más tarde.");
        }
    }
    
    /**
     * Envía el código de estudiante y de curso para saber si existe la matrícula
     * @return si la matrícula existe
     */
    public boolean buscarMatricula()
    {
        boolean encontrado = false;
        
        if(baseDatos.buscarMatricula(frame.getEstudianteID(), frame.getCursoID()))
        {
            encontrado = true;
        }
        
        return encontrado;
    }
    
    /**
     * Reinicia todos los campos y deshabilita los botones
     */
    public void resetFrame()
    {
        frame.clearFields();
        frame.disableBotones();
    }
}
