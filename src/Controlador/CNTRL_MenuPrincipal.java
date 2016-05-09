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
import Vista.Frame.Administrar.FRM_Cursos;
import Vista.Frame.Administrar.FRM_Estudiantes;
import Vista.Frame.Chequear.FRM_VerMatriculas;
import Vista.Frame.Administrar.FRM_Matriculas;
import Vista.Frame.Administrar.FRM_Usuarios;
import Vista.Frame.Chequear.FRM_VerCursos;
import Vista.Frame.Chequear.FRM_VerEstudiantes;
import Vista.Frame.FRM_Login;
import Vista.Frame.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author DanielSQ
 */
public class CNTRL_MenuPrincipal implements ActionListener
{
    FRM_MenuPrincipal frame;
    FRM_Cursos cursos;
    FRM_Estudiantes estudiantes;
    FRM_VerEstudiantes verEstudiantes;
    FRM_VerCursos verCursos;
    FRM_Matriculas matriculas;
    FRM_VerMatriculas verMatriculas;
    FRM_Usuarios usuarios;
    FRM_Login login;
    
    ConexionBD baseDatos;
    
    /**
     * Crea el controlador del Menú Principal
     * @param frame
     */
    public CNTRL_MenuPrincipal(FRM_MenuPrincipal frame, ConexionBD baseDatos)
    {
        this.baseDatos = baseDatos;
        this.frame = frame;
        inicializarFrames(baseDatos);
    }
    
    /**
     * Inicializa todos los Frames del programa y los centra
     * @param baseDatos
     */
    public void inicializarFrames(ConexionBD baseDatos)
    {
        estudiantes = new FRM_Estudiantes(baseDatos);
        estudiantes.setLocationRelativeTo(null);
        verEstudiantes = new FRM_VerEstudiantes(baseDatos);
        verEstudiantes.setLocationRelativeTo(null);
        cursos = new FRM_Cursos(baseDatos);
        cursos.setLocationRelativeTo(null);
        verCursos = new FRM_VerCursos(baseDatos);
        verCursos.setLocationRelativeTo(null);
        matriculas = new FRM_Matriculas(baseDatos);
        matriculas.setLocationRelativeTo(null);
        verMatriculas = new FRM_VerMatriculas(baseDatos);
        verMatriculas.setLocationRelativeTo(null);
        usuarios = new FRM_Usuarios(baseDatos);
        usuarios.setLocationRelativeTo(null);
        login = new FRM_Login(baseDatos, this);
        login.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Estudiantes"))
        {
            System.out.println("Administrar Estudiantes");
            estudiantes.setVisible(true);
        }
                
        if(e.getActionCommand().equals("Cursos"))
        {
            System.out.println("Administrar Cursos");
            cursos.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Matriculas"))
        {
            matriculas.setVisible(true);
            System.out.println("Administrar Matrículas");            
        }
        
        
        if(e.getActionCommand().equals("VerEstudiantes"))
        {
            System.out.println("Ver Estudiantes");
            verEstudiantes.resetTabla();
            verEstudiantes.updateTabla();
            verEstudiantes.setVisible(true);
        }
        
        if(e.getActionCommand().equals("VerCursos"))
        {
            System.out.println("Ver Cursos");
            verCursos.resetTabla();
            verCursos.updateTabla();
            verCursos.setVisible(true);
        }
        
        if(e.getActionCommand().equals("VerMatriculas"))
        {
            verMatriculas.resetTabla();
            verMatriculas.updateTabla();
            verMatriculas.setVisible(true);
            System.out.println("Ver Matrículas");            
        }
        
        if(e.getActionCommand().equals("AdministrarUsuarios"))
        {
            usuarios.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Ingresar"))
        {
            ingresar();
        }
        
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
        }
    }
    
    public void ingresar()
    {
        String userEscrito = login.getUser();
        String passEscrito = login.getPass();
                
        if((userEscrito.equals("")) || (passEscrito.equals("")))
        {
            JOptionPane.showMessageDialog(null, "Debe llenar ambos campos");
        }
        else
        {
            String pass = baseDatos.getPass(userEscrito);

            if(passEscrito.equals(pass))
            {
                login.setVisible(false);
                frame.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Revise su nombre de usuario o contraseña");
            }
        }
    }
    
    public void usuarios()
    {
        frame.setVisible(false);
        usuarios.configuracionInicial(this);
        usuarios.setVisible(true);
    }    
        
    public void iniciarLogin()
    {
        frame.setVisible(false);
        usuarios.setVisible(false);
        login.setVisible(true);
    }
}
