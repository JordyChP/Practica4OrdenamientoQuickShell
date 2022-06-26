/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DAO.PersonaDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.TipoOrdenacion;
import javax.swing.JOptionPane;
import vista.modelo.ModeloTablaPersona;
//import vista.modelo.ModeloTablaAuto;

/**
 *
 * @author jy
 */
public class FrmPersona extends javax.swing.JDialog {

    private ModeloTablaPersona mtp = new ModeloTablaPersona();
    private PersonaDao personaDao = new PersonaDao();

    /**
     * Creates new form FrmEstudiante
     */
    public FrmPersona(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
    }

    private void limpiar() {
        personaDao.setPersona(null);

    }

    private void cargarTabla() {
        mtp.setLista(personaDao.listar());
        jTable1.setModel(mtp);
        jTable1.updateUI();
    }

    private void guardar() {

        String[] persona = {"Hugo", "Leo", "Pablo", "Enzo", "Oliver", "Marc", "Erick", "Luca", "Liam", "Saul", "Cristian", "David",
            "Daniel", "Alejando", "Manuel", "Thiago", "Bruno", "GRIS", "Iker", "Victor", "Omar", "Cesar", "Emilio", "Diego"};
        try {
            for (int i = 0; i < 200; i++) {

                personaDao.getPersona().setNombre(persona[(int) (Math.floor(Math.random() * ((persona.length - 1) - 0 + 1) + 0))]);
                personaDao.getPersona().setCedula(String.valueOf(new Integer((int) ((Math.random() * 1000000000)))));
                //personaDao.getLista().insertarNodo(personaDao.getPersona());ç
                personaDao.guardar();
                this.limpiar();
            }

            JOptionPane.showMessageDialog(null, "Se ha guardado");
            cargarTabla();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void ordenar() {
        ListaEnlazada aux = new ListaEnlazada<>() ;
        TipoOrdenacion select = null;

        int select1 = cbxMetodo.getSelectedIndex();
        String atributo = cbxAtributo.getSelectedItem().toString();
        if (cbxTipoOrdenamiento.getSelectedIndex() == 0) {
            select = TipoOrdenacion.ASCENDENTE;
        } else {
            select = TipoOrdenacion.DESCENDENTE;
        }
        
        if (select1 == 0) {
            aux = personaDao.listar().QuisortClase(atributo, 0, personaDao.listar().size() - 1, select);
        } else {
            aux = personaDao.listar().ShellClase(select, atributo);

        }
        mtp.setLista(aux);
        jTable1.setModel(mtp);
        jTable1.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbdireccion1 = new javax.swing.JComboBox<>();
        cbmetodo1 = new javax.swing.JComboBox<>();
        cbatributo1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        cbxMetodo = new javax.swing.JComboBox<>();
        cbxAtributo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxTipoOrdenamiento = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 20, 330, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 60, 630, 430);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        cbdireccion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        jPanel3.add(cbdireccion1);
        cbdireccion1.setBounds(10, 140, 180, 30);

        cbmetodo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "quickshort", "Shell" }));
        jPanel3.add(cbmetodo1);
        cbmetodo1.setBounds(10, 20, 180, 30);

        cbatributo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "modelo", "color", "placa" }));
        cbatributo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbatributo1ActionPerformed(evt);
            }
        });
        jPanel3.add(cbatributo1);
        cbatributo1.setBounds(10, 80, 180, 30);

        jButton3.setText("Ordenar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(10, 190, 180, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(700, 30, 200, 260);

        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "quickshort", "Shell" }));
        jPanel2.add(cbxMetodo);
        cbxMetodo.setBounds(20, 40, 180, 30);

        cbxAtributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "cedula" }));
        cbxAtributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAtributoActionPerformed(evt);
            }
        });
        jPanel2.add(cbxAtributo);
        cbxAtributo.setBounds(220, 40, 180, 30);

        jLabel1.setText("Metodo de Ordenamiento");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 20, 180, 17);

        jLabel2.setText("Metodo de Ordenamiento");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 20, 180, 17);

        jLabel3.setText("Tipo de Ordenamiento");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(420, 20, 180, 17);

        jLabel5.setText("Tipo de Modelo");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(220, 20, 180, 17);

        cbxTipoOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        cbxTipoOrdenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoOrdenamientoActionPerformed(evt);
            }
        });
        jPanel2.add(cbxTipoOrdenamiento);
        cbxTipoOrdenamiento.setBounds(420, 40, 180, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 510, 640, 90);

        jButton4.setText("Cargar tabla");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(380, 20, 290, 30);

        jButton5.setText("Ordenar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(40, 610, 640, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 690, 680);

        setSize(new java.awt.Dimension(717, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cargarTabla();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbatributo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbatributo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbatributo1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbxAtributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAtributoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAtributoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ordenar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbxTipoOrdenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoOrdenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoOrdenamientoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPersona dialog = new FrmPersona(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbatributo1;
    private javax.swing.JComboBox<String> cbdireccion1;
    private javax.swing.JComboBox<String> cbmetodo1;
    private javax.swing.JComboBox<String> cbxAtributo;
    private javax.swing.JComboBox<String> cbxMetodo;
    private javax.swing.JComboBox<String> cbxTipoOrdenamiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
