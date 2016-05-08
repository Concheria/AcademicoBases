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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
