/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import controlador.IgvDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelos.Igv;
import utilidades.Alerta;
import utilidades.ConfigGeneral;
import utilidades.FormatoTextField;
import utilidades.SQL;
import utilidades.Validador_de_Campos;

public class Form_Igv extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();
    IgvDAO controlador = new IgvDAO();
    SQL sql = new SQL();

    FormatoTextField JTF = new FormatoTextField();
    Validador_de_Campos validar = new Validador_de_Campos();

    private int opcion_visual = config.getOpcion_visual();
    int idrecepcionado = 0, ver = 0;
//        this.id_usuarios=id_usuarios;
//        this.id_sedes=id_usuarios;

    public Form_Igv(java.awt.Frame parent, boolean modal, int idrecepcionado, int ver) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE CATÁLOGO 7 - AFECTACIÓN DEL IGV");
        this.idrecepcionado = idrecepcionado;
        this.ver = ver;
        JTF.modelo_1TF(txtCodigo, opcion_visual);
        JTF.modelo_1TF(txtDescripcion, opcion_visual);
        JTF.modelo_1TF(txtCodigoTributo, opcion_visual);
        lblIdEmpresa.setText(idrecepcionado + "");
        lblIdEmpresa.setVisible(false);
//emp.icono.general
        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());
//        validar.validarSoloNumeros(txtDescripcion);
        if (idrecepcionado == 0) {
            txtCodigo.requestFocus();
        } else {
            controlador.buscar_por_id(idrecepcionado);
            String codigo = controlador.getObFac_cat7().getCodigo();
            String codigo_tributo = controlador.getObFac_cat7().getCodigo_tributo();
            String descripcion = controlador.getObFac_cat7().getDescripcion();
//            ////////////////////////////////////////////////////////////////////////////
            txtCodigo.setText(codigo + "");
            txtCodigoTributo.setText(codigo_tributo + "");
            txtDescripcion.setText("" + descripcion);
            txtCodigo.requestFocus();
            /////////////////////////////////////////////////////////////////////////////
        }
        if (ver == 1) {
            txtCodigo.setEnabled(false);
            txtCodigoTributo.setEnabled(false);
            txtDescripcion.setEnabled(false);
            btnRegistrar.setEnabled(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        lblIdEmpresa = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtDescripcion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoTributo = new org.edisoncor.gui.textField.TextFieldRectBackground();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

        lblIdEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Código *");

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/guardar_16px.png"))); // NOI18N
        btnRegistrar.setMnemonic('R');
        btnRegistrar.setText("Registrar");
        btnRegistrar.setToolTipText("Realizar NuevoRegistro");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Decripción *");

        txtCodigo.setAnchoDeBorde(1.0F);
        txtCodigo.setDescripcion("Ingrese el código");
        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtDescripcion.setAnchoDeBorde(1.0F);
        txtDescripcion.setDescripcion("Ingrese su descripción");
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Código de Tributo");

        txtCodigoTributo.setAnchoDeBorde(1.0F);
        txtCodigoTributo.setDescripcion("Ingrese su descripción");
        txtCodigoTributo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCodigoTributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoTributoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigoTributo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoTributo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlantillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlantillaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlantillaActionPerformed

    private void txtPlantillaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlantillaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlantillaKeyReleased

    private void txtCodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarraActionPerformed

    private void txtCodigoBarraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarraKeyReleased

    public String leeDescripcion() {
        return txtDescripcion.getText().toUpperCase();
    }

    public int leeId() {
        return Integer.parseInt(lblIdEmpresa.getText());
    }

    public String leeCodigo() {
        return txtCodigo.getText().toUpperCase();
    }

    public String leeCodigoTributo() {
        return txtCodigoTributo.getText();
    }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtCodigo.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un Código válido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtCodigo.requestFocus();
            return;
        }
        if (txtDescripcion.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una Descripción válida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
        try {
            if (idrecepcionado == 0) {
                String consulta = "Select descripcion from igv where descripcion='" + leeDescripcion() + "' ";
                if (sql.valida_Campos(consulta)) {
                    JOptionPane.showMessageDialog(null, "La Descripción ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txtCodigo.setText("");
                    txtCodigo.requestFocusInWindow();
                    return;
                }
                Igv cat7_igv = new Igv(0, leeCodigo(), leeDescripcion(),
                        leeCodigoTributo(), 1);
                controlador.registrar(cat7_igv);

                int opcion = JOptionPane.showConfirmDialog(null, "Desea Realizar otro Registro?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {
                    txtCodigo.setText("");
                    txtDescripcion.setText("");
                    txtCodigo.requestFocusInWindow();
                } else {
                    this.dispose();
                }

                Alerta alert = new Alerta("Mensaje", "Registro Exitoso");
                alert.setVisible(true);
            } else {

                String consulta = "Select descripcion from igv where descripcion='" + leeDescripcion() + "' and "
                        + " id_igv='" + leeId() + "'  ";
                if (!sql.valida_Campos(consulta)) {
                    String consulta_reg = "Select descripcion from igv where descripcion='" + leeDescripcion() + "'";
                    if (sql.valida_Campos(consulta_reg)) {
                        JOptionPane.showMessageDialog(null, "La Descripción ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        txtCodigo.setText("");
                        txtDescripcion.setText("");
                        txtCodigoTributo.setText("");
                        txtCodigo.requestFocusInWindow();
                        return;
                    }
                }

                Igv cat7_igv = new Igv(leeId(), leeCodigo(), leeDescripcion(),
                        leeCodigoTributo(), 1);
                controlador.actualizar(cat7_igv);
                this.dispose();
                Alerta alert = new Alerta("Mensaje", "Actualización Exitosa");
                alert.setVisible(true);
            }

        } catch (Exception e) {
            System.err.println("error al registrar igv " + e.getLocalizedMessage());
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtLongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLongitudActionPerformed

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtLongitudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLongitudKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLongitudKeyReleased

    private void txtCodigoTributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoTributoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoTributoActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Igv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Igv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Igv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Igv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold   
        //</editor-fold 
        //</editor-fold>
        //</editor-fold   
        //</editor-fold 

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Igv dialog = new Form_Igv(new javax.swing.JFrame(), true, 0, 0);
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
    private javax.swing.JLabel LTABLA;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblIdEmpresa;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCodigo;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCodigoTributo;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
