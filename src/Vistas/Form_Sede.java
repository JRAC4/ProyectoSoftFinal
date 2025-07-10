/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import controlador.SedeDAO;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelos.Sedes;
import utilidades.Alerta;
import utilidades.AlertaBien;
import utilidades.AlertaError;
import utilidades.Archivos_Planos;
import utilidades.ConfigGeneral;
import utilidades.CopiarArchivo;
import utilidades.Encriptar;
import utilidades.FormatoCombox;
import utilidades.FormatoTextField;
import utilidades.Validador_de_Campos;

public class Form_Sede extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();
    SedeDAO controlador = new SedeDAO(); //llamamos al mentenimiento general del objeto  
    Archivos_Planos arc = new Archivos_Planos();

    Encriptar encrip = new Encriptar();
    FormatoCombox JCX = new FormatoCombox();
    FormatoTextField JTF = new FormatoTextField();
    
    Validador_de_Campos validar = new Validador_de_Campos();

    private int opcion_visual = config.getOpcion_visual();
    private String ruta = config.getRuta();
    String foto = "", origen = "", destino = "";
    int idrecepcionado = 0, ver = 0, id_usuario = 0;

    public Form_Sede(java.awt.Frame parent, boolean modal, int idrecepcionado, int ver, int id_usuario) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE SEDE");
        this.idrecepcionado = idrecepcionado;
        this.id_usuario = id_usuario;
        this.ver = ver;


        JTF.modelo_1TF(txtDescripcion, opcion_visual);
        JTF.modelo_1TF(txtEmailOrigen, opcion_visual);
        JTF.modelo_1TF(txtDireccion, opcion_visual);

        JTF.modelo_1TF(txtCelular, opcion_visual);
        JTF.modelo_1TF(txtRuc, opcion_visual);

        
        JTF.modelo_1TF(txtSerieBoleta, opcion_visual);
        JTF.modelo_1TF(txtSerieFactura, opcion_visual);


        validar.validarSoloNumeros(txtCelular);
        validar.validarSoloNumeros(txtRuc);
        lblIdEmpresa.setText(idrecepcionado + "");
        lblIdEmpresa.setVisible(false);
        txtRuta.setVisible(false);
//emp.icono.general
        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());
//        validar.validarSoloNumeros(txtDescripcion);

        if (idrecepcionado == 0) {
            txtDescripcion.requestFocus();
            /////////////////////////////////////////////////////////////////////////////
            //para MOSTRAR LA IMAGEN COMO ICONO DENTRO DEL LABEL emp.icono.general
            mostrarFotoPoDefecto("sinfoto.png");
            txtRuta.setText("sinfoto.png");
            ///////////////////////////////////////////////////////////////////////////// 
        } else {
            controlador.buscar_por_id(idrecepcionado);
            String descripcion = controlador.getSedes().getDescripcion();
            String direccion = controlador.getSedes().getDireccion();
            String celular = controlador.getSedes().getCelular();
            String ruc = controlador.getSedes().getRuc();
            String email_origen = controlador.getSedes().getEmail_origen();
            String foto = controlador.getSedes().getFoto();

            
            String serie_boleta = controlador.getSedes().getSerie_boleta();
            String serie_factura = controlador.getSedes().getSerie_factura();

            
            txtSerieBoleta.setText(serie_boleta);
            txtSerieFactura.setText(serie_factura);
            

//            ////////////////////////////////////////////////////////////////////////////
            txtDescripcion.setText(descripcion + "");
            txtDireccion.setText(direccion + "");
            txtCelular.setText(celular + "");
            txtRuc.setText(ruc + "");

            txtEmailOrigen.setText(email_origen + "");
            txtRuta.setText(foto + "");

            txtDescripcion.requestFocus();
            mostrarFotoPoDefecto(foto);
            /////////////////////////////////////////////////////////////////////////////
        }
        if (ver == 1) {
            txtDescripcion.setEnabled(false);
            txtDireccion.setEnabled(false);

            txtCelular.setEnabled(false);
            txtRuc.setEnabled(false);

            txtEmailOrigen.setEnabled(false);

            btnRegistrar.setEnabled(false);
            btnFoto.setEnabled(false);
            btnRestaurarFoto.setEnabled(false);

            
            txtSerieBoleta.setEnabled(false);
            txtSerieFactura.setEnabled(false);

        }

    }


    public void mostrarFotoPoDefecto(String f) {
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        //para MOSTRAR LA IMAGEN COMO ICONO DENTRO DEL LABEL

        //para MOSTRAR LA IMAGEN COMO ICONO DENTRO DEL LABEL
        ImageIcon fot = new ImageIcon(ruta + "/Fotos/Sede/" + f);
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(151, 151, Image.SCALE_DEFAULT));//lo de 140 y 170 es para q la imagen salga ese tamaño
        lblFoto.setIcon(icono);
        this.repaint();
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        lblIdEmpresa = new javax.swing.JLabel();
        fcBuscarFoto = new javax.swing.JFileChooser();
        txtRuta = new javax.swing.JLabel();
        lblIdVersion = new javax.swing.JLabel();
        lblRespuesta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        txtRuc = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtDescripcion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtDireccion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtEmailOrigen = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtCelular = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnFoto = new javax.swing.JButton();
        btnRestaurarFoto = new javax.swing.JButton();
        txtSerieFactura = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtSerieBoleta = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

        lblIdEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtRuta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRuta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblIdVersion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblRespuesta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Decripción *");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 132, -1));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/guardar_16px.png"))); // NOI18N
        btnRegistrar.setMnemonic('R');
        btnRegistrar.setText("Registrar");
        btnRegistrar.setToolTipText("Realizar NuevoRegistro");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 115, 30));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Ruc *");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 5, 125, -1));

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Dirección *");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 62, 138, -1));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Email*");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 158, 201, -1));

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Celular");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 158, 215, -1));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Foto ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, 125, -1));

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 158, 146, 139));

        txtRuc.setAnchoDeBorde(1.0F);
        txtRuc.setDescripcion("Ingrese una descripción");
        txtRuc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 26, 309, 30));

        txtDescripcion.setAnchoDeBorde(1.0F);
        txtDescripcion.setDescripcion("Ingrese una descripción");
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 26, 441, 30));

        txtDireccion.setAnchoDeBorde(1.0F);
        txtDireccion.setDescripcion("Ingrese una descripción");
        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 756, 30));

        txtEmailOrigen.setAnchoDeBorde(1.0F);
        txtEmailOrigen.setDescripcion("Ingrese una descripción");
        txtEmailOrigen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtEmailOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 178, 295, 30));

        txtCelular.setAnchoDeBorde(1.0F);
        txtCelular.setDescripcion("Ingrese una descripción");
        txtCelular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 178, 303, 30));

        btnFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/guardar_16px.png"))); // NOI18N
        btnFoto.setText("Subir foto");
        btnFoto.setToolTipText("Opcion de Cargar foto");
        btnFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 26));

        btnRestaurarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/eliminar_16px.png"))); // NOI18N
        btnRestaurarFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRestaurarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarFotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestaurarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 42, 26));

        txtSerieFactura.setAnchoDeBorde(1.0F);
        txtSerieFactura.setDescripcion("Ingrese una descripción");
        txtSerieFactura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtSerieFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 295, 30));

        txtSerieBoleta.setAnchoDeBorde(1.0F);
        txtSerieBoleta.setDescripcion("Ingrese una descripción");
        txtSerieBoleta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtSerieBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 303, 30));

        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Serie de Boletas Electronicas");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Serie de Facturas Electronicas");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 191, -1));

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
        return txtDescripcion.getText();
    }

    public String leeDireccion() {
        return txtDireccion.getText();
    }

    public String leeRuc() {
        return txtRuc.getText().toUpperCase();
    }


    public String leeCelular() {
        return txtCelular.getText().toUpperCase();
    }

    public String leeEmailOrigen() {
        return txtEmailOrigen.getText();
    }



    public String leeRuta() {
        return txtRuta.getText();
    }

    public int leeId() {
        return Integer.parseInt(lblIdEmpresa.getText());
    }

       public String leeSerieBoleta() {
        return txtSerieBoleta.getText().toUpperCase();
    }
          public String leeSerieFactura() {
        return txtSerieFactura.getText().toUpperCase();
    }
            
                   

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtEmailOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailOrigenActionPerformed

    private void txtEmailDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailDestinoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtPagoMoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoMoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoMoraActionPerformed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtEmailClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtEmailClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailClave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailClave1ActionPerformed

    private void btnRestaurarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarFotoActionPerformed
        if (!txtRuta.getText().equalsIgnoreCase("sinfoto.png")) {
            arc.Eliminar_archivo(config.getRuta() + "/Fotos/Sede/" + txtRuta.getText());
        }
        controlador.actualizarFoto("sinfoto.png", leeId());
        mostrarFotoPoDefecto("sinfoto.png");
        txtRuta.setText("sinfoto.png");
    }//GEN-LAST:event_btnRestaurarFotoActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        //busca la foto y lo graba en el paquete Imagen

        int resp;
        FileNameExtensionFilter f = new FileNameExtensionFilter(".JPG", ".PNG");
        fcBuscarFoto.setFileFilter(f);
        resp = fcBuscarFoto.showOpenDialog(this);

        if (resp == JFileChooser.APPROVE_OPTION) {

            origen = fcBuscarFoto.getSelectedFile().toString();
            foto = fcBuscarFoto.getName(fcBuscarFoto.getSelectedFile());
            System.out.println(fcBuscarFoto.getSelectedFile().toString());
            System.out.println();
            ////////lo alamcenamos en la carpeta
            //            destino = System.getProperty("user.dir") + "C:\\Program Files (x86)\\MESA-7\\FOTOS\\" + fcBuscarFoto.getName(fcBuscarFoto.getSelectedFile());
            destino = ruta + "/Fotos/Sede/" + fcBuscarFoto.getName(fcBuscarFoto.getSelectedFile());
            //            destino = System.getProperty("user.home")+ "\\MESA-7\\FOTOS\\" + fcBuscarFoto.getName(fcBuscarFoto.getSelectedFile());
            /////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////
            //para MOSTRAR LA IMAGEN COMO ICONO DENTRO DEL LABEL para mostrarlo al instante de cargar la foto al sistema
            ImageIcon fot = new ImageIcon(origen);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));//lo de 140 y 170 es para q la imagen salga ese tamaño
            lblFoto.setIcon(icono);
            this.repaint();
            txtRuta.setText(foto);///foto contiene el nombre del archivo q se guardara en la BD
            /////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////
            //
            CopiarArchivo.getInstance().copiar(origen, destino);
            return;
        } else if (resp == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación Cancelada");
            return;
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnFotoActionPerformed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked

    }//GEN-LAST:event_lblFotoMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una descripción válida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }

        if (txtDireccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una dirección válida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtDireccion.requestFocus();
            return;
        }

        if (txtRuc.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un RUC válido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtRuc.requestFocus();
            return;
        }

        if (txtSerieBoleta.getText().trim().isEmpty()) {
            txtSerieBoleta.requestFocus();
            new AlertaError("Mensaje", "Ingrese una serie para la Boleta Electrónica").setVisible(true);
            return;
        }

        if (txtSerieFactura.getText().trim().isEmpty()) {
            txtSerieFactura.requestFocus();
            new AlertaError("Mensaje", "Ingrese una serie para la Factura Electrónica").setVisible(true);
            return;
        }

        try {
            if (idrecepcionado == 0) {
                // Verificar si la descripción ya existe
                String consulta = "SELECT COUNT(*) FROM sede WHERE descripcion = '" + leeDescripcion() + "'";
                int count = controlador.ejecutarConsultaEntero(consulta); // Método auxiliar que retorna el count

                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "La Sede ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txtDescripcion.setText("");
                    txtDescripcion.requestFocusInWindow();
                    return;
                }

                // Crear objeto sin los campos eliminados
                Sedes sedes = new Sedes(
                    0, leeDescripcion(), leeDireccion(), leeCelular(), leeRuc(),
                    leeEmailOrigen(), leeRuta(), 1, leeSerieBoleta(), leeSerieFactura()
                );

                controlador.registrar(sedes);

                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea realizar otro registro?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {
                    txtDescripcion.setText("");
                    txtDescripcion.requestFocusInWindow();
                } else {
                    this.dispose();
                }

                new AlertaBien("Mensaje", "Registro Exitoso").setVisible(true);

            } else {
                // Verifica si la descripción ya existe para otro id
                String consulta = "SELECT COUNT(*) FROM sede WHERE descripcion = '" + leeDescripcion() + "' AND id_sede <> " + leeId();
                int count = controlador.ejecutarConsultaEntero(consulta);

                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "La Sede ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txtDescripcion.setText("");
                    txtDescripcion.requestFocusInWindow();
                    return;
                }

                Sedes sedes = new Sedes(
                    leeId(), leeDescripcion(), leeDireccion(), leeCelular(), leeRuc(),
                    leeEmailOrigen(), leeRuta(), 1, leeSerieBoleta(), leeSerieFactura()
                );

                controlador.actualizar(sedes);
                this.dispose();

                new Alerta("Mensaje", "Actualización Exitosa").setVisible(true);
            }

        } catch (Exception e) {
            System.err.println("Error al registrar sede: " + e.getLocalizedMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold 
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold 
        //</editor-fold> 

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Sede dialog = new Form_Sede(new javax.swing.JFrame(), true, 0, 0, 0);
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
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRestaurarFoto;
    private javax.swing.JFileChooser fcBuscarFoto;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblIdEmpresa;
    private javax.swing.JLabel lblIdVersion;
    public static javax.swing.JLabel lblRespuesta;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCelular;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDireccion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtEmailOrigen;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtRuc;
    private javax.swing.JLabel txtRuta;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtSerieBoleta;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtSerieFactura;
    // End of variables declaration//GEN-END:variables
}
