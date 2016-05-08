/*
 * Tarea 02
 * Sistema Academico con conexion a Base de Datos
 * 
 * Estudiante: Daniel Somarribas Quir�s
 * Carnet: b57072
 * Mayo, 2016
 */
package Vista.Frame;

import Controlador.CNTRL_MenuPrincipal;
import Modelo.Database.ConexionBD;

/**
 *
 * @author DanielSQ
 */
public class FRM_MenuPrincipal extends javax.swing.JFrame 
{
    ConexionBD baseDatos;
    CNTRL_MenuPrincipal controlador;
    /**
     * Creates new form MenuPrincipal
     */
    public FRM_MenuPrincipal() {        
        baseDatos = new ConexionBD();        
        controlador = new CNTRL_MenuPrincipal(this, baseDatos);
        initComponents();
        addController(controlador);
    }
    
    /**
     * Añade el controlador a los botones del menú
     * @param controlador
     */
    public void addController(CNTRL_MenuPrincipal controlador)
    {
        jmi_Salir.addActionListener(controlador);
        jmi_Estudiantes.addActionListener(controlador);
        jmi_VerEstudiantes.addActionListener(controlador);
        jmi_Cursos.addActionListener(controlador);
        jmi_VerCursos.addActionListener(controlador);
        jmi_Matriculas.addActionListener(controlador);
        jmi_VerMatriculas.addActionListener(controlador);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmn_Archivo = new javax.swing.JMenu();
        jmi_Salir = new javax.swing.JMenuItem();
        jmn_Administrar = new javax.swing.JMenu();
        jmi_Estudiantes = new javax.swing.JMenuItem();
        jmi_Cursos = new javax.swing.JMenuItem();
        jmi_Matriculas = new javax.swing.JMenuItem();
        jmn_Ver = new javax.swing.JMenu();
        jmi_VerEstudiantes = new javax.swing.JMenuItem();
        jmi_VerCursos = new javax.swing.JMenuItem();
        jmi_VerMatriculas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador Académico");
        setResizable(false);

        jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N

        jmn_Archivo.setText("Archivo");

        jmi_Salir.setText("Salir");
        jmn_Archivo.add(jmi_Salir);

        jMenuBar1.add(jmn_Archivo);

        jmn_Administrar.setText("Administrar");

        jmi_Estudiantes.setText("Estudiantes");
        jmn_Administrar.add(jmi_Estudiantes);

        jmi_Cursos.setText("Cursos");
        jmn_Administrar.add(jmi_Cursos);

        jmi_Matriculas.setText("Matrículas");
        jmi_Matriculas.setActionCommand("Matriculas");
        jmi_Matriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_MatriculasActionPerformed(evt);
            }
        });
        jmn_Administrar.add(jmi_Matriculas);

        jMenuBar1.add(jmn_Administrar);

        jmn_Ver.setText("Ver");

        jmi_VerEstudiantes.setText("Estudiantes");
        jmi_VerEstudiantes.setActionCommand("VerEstudiantes");
        jmi_VerEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_VerEstudiantesActionPerformed(evt);
            }
        });
        jmn_Ver.add(jmi_VerEstudiantes);

        jmi_VerCursos.setText("Cursos");
        jmi_VerCursos.setActionCommand("VerCursos");
        jmi_VerCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_VerCursosActionPerformed(evt);
            }
        });
        jmn_Ver.add(jmi_VerCursos);

        jmi_VerMatriculas.setText("Matrículas");
        jmi_VerMatriculas.setActionCommand("VerMatriculas");
        jmn_Ver.add(jmi_VerMatriculas);

        jMenuBar1.add(jmn_Ver);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jl_Fondo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jl_Fondo)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_VerEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_VerEstudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_VerEstudiantesActionPerformed

    private void jmi_VerCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_VerCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_VerCursosActionPerformed

    private void jmi_MatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_MatriculasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_MatriculasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FRM_MenuPrincipal menuPrincipal;
                menuPrincipal = new FRM_MenuPrincipal();
                menuPrincipal.setLocationRelativeTo(null);
                menuPrincipal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jl_Fondo;
    private javax.swing.JMenuItem jmi_Cursos;
    private javax.swing.JMenuItem jmi_Estudiantes;
    private javax.swing.JMenuItem jmi_Matriculas;
    private javax.swing.JMenuItem jmi_Salir;
    private javax.swing.JMenuItem jmi_VerCursos;
    private javax.swing.JMenuItem jmi_VerEstudiantes;
    private javax.swing.JMenuItem jmi_VerMatriculas;
    private javax.swing.JMenu jmn_Administrar;
    private javax.swing.JMenu jmn_Archivo;
    private javax.swing.JMenu jmn_Ver;
    // End of variables declaration//GEN-END:variables
}