package Vistas;

import controlador.PerfilDAO;
import controlador.SedeDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import controlador.UsuarioDAO;
import utilidades.Alerta;
import utilidades.Fecha_Date;

public class Frm_Menu_Principal extends javax.swing.JFrame {

    UsuarioDAO controladorUsuario = new UsuarioDAO();
    SedeDAO controladorSede = new SedeDAO();
    PerfilDAO controladorPerfil = new PerfilDAO();

    Fecha_Date fech = new Fecha_Date();
    Date now = new Date(System.currentTimeMillis());
    SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");

    private int id_usuario = 0, id_sede = 0;

    public Frm_Menu_Principal(String usuario, int id_usuario, int id_sede) {
        initComponents();

        this.id_usuario = id_usuario;
        this.id_sede = id_sede;

        controladorSede.buscar_por_id(id_sede);
        controladorUsuario.buscar_por_id(id_usuario);
//        String empresa = controladorSede.getSedes().getDescripcion();

        //MOSTRAMOS EN LA PARTE INFERIOR LOS DATOS CAPTURADOS
        txtCargo.setText(controladorPerfil.obtieneDescripcion_id(controladorUsuario.getUsuario().getId_perfil()));
        txtUsuario.setText(usuario.toUpperCase());
        txtFecha.setText("" + fech.retorna_fecha_del_sistemaOrden());
        txtHora.setText(hour.format(now));

        this.setExtendedState(MAXIMIZED_BOTH);//sirve para maximizar la pantalla
setIconImage(new ImageIcon(getClass().getResource("/imagenes/logos.png")).getImage());
        this.setTitle("SISTEMA DE INVENTARIO Y VENTAS - FERRICO");
        cerrar();
    }

    public void cerrar() {
        try {
//            this.setDefaultCloseOperation(Fm_Categoria.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent w) {
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            System.err.println("error en " + e);
        }
    }

    public void confirmarSalida() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la ventana de trabajo?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            System.exit(-1);
        } else {
            Alerta alert = new Alerta("Mensaje", "Operación Cancelada");
            alert.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtHora = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/VerTabla_40px.png"))); // NOI18N
        jLabel1.setText("Hora");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel7.add(jLabel1);

        txtHora.setBackground(new java.awt.Color(255, 255, 255));
        txtHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtHora.setForeground(new java.awt.Color(102, 102, 102));
        txtHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtHora.setOpaque(true);
        jPanel7.add(txtHora);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Info_16px.png"))); // NOI18N
        jLabel10.setText("Fecha");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel10.setOpaque(true);
        jPanel7.add(jLabel10);

        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFecha.setOpaque(true);
        jPanel7.add(txtFecha);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jLabel8.setText("Perfil");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel8.setOpaque(true);
        jPanel7.add(jLabel8);

        txtCargo.setBackground(new java.awt.Color(255, 255, 255));
        txtCargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCargo.setForeground(new java.awt.Color(102, 102, 102));
        txtCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCargo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCargo.setOpaque(true);
        jPanel7.add(txtCargo);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Mant_Gen_16px.png"))); // NOI18N
        jLabel7.setText("Usuario");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setOpaque(true);
        jPanel7.add(jLabel7);

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(102, 102, 102));
        txtUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtUsuario.setOpaque(true);
        jPanel7.add(txtUsuario);

        jPanel2.add(jPanel7);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1);

        jMenu1.setForeground(new java.awt.Color(66, 66, 66));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Empresas_Gen16px.png"))); // NOI18N
        jMenu1.setText("Negocio");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Laboratorios_Gen_16px.png"))); // NOI18N
        jMenuItem3.setText("Categorías");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Laboratorios_Gen_16px.png"))); // NOI18N
        jMenuItem4.setText("Marcas");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/registro_de_compra_16px.png"))); // NOI18N
        jMenuItem2.setText("Productos");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem7.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/colaboradores_16px.png"))); // NOI18N
        jMenuItem7.setText("Clientes");
        jMenuItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(66, 66, 66));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/ventas_16px.png"))); // NOI18N
        jMenu2.setText("Facturación  ");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem5.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/ventas_16px.png"))); // NOI18N
        jMenuItem5.setText("Ventas");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu7.setForeground(new java.awt.Color(66, 66, 66));
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenu7.setText("Empresa");
        jMenu7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenu7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu7ActionPerformed(evt);
            }
        });

        jMenuItem11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem11.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Home_16px.png"))); // NOI18N
        jMenuItem11.setText("Sedes");
        jMenuItem11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem12.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/gerencia_16px.png"))); // NOI18N
        jMenuItem12.setText("Perfiles");
        jMenuItem12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem12);

        jMenuItem13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem13.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/colaboradores_16px.png"))); // NOI18N
        jMenuItem13.setText("Usuarios");
        jMenuItem13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem13);

        jMenuBar1.add(jMenu7);

        jMenu6.setForeground(new java.awt.Color(66, 66, 66));
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/reportes_16px.png"))); // NOI18N
        jMenu6.setText("Parámetros");
        jMenu6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem9.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/TipoDoc_16px.png"))); // NOI18N
        jMenuItem9.setText("Tipo de documento");
        jMenuItem9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenuItem14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem14.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/TipoDoc_16px.png"))); // NOI18N
        jMenuItem14.setText("Afectación al igv");
        jMenuItem14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenuItem15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem15.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/TipoDoc_16px.png"))); // NOI18N
        jMenuItem15.setText("Afectos a igv");
        jMenuItem15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuBar1.add(jMenu6);

        jMenu4.setForeground(new java.awt.Color(66, 66, 66));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Home_16px.png"))); // NOI18N
        jMenu4.setText("Sistema");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem8.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/cerrar.png"))); // NOI18N
        jMenuItem8.setText("Salir");
        jMenuItem8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

 Fm_Categoria formulario = new Fm_Categoria(id_usuario, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        Fm_Producto formulario = new Fm_Producto(id_usuario, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        System.exit(-1);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        Fm_Marca formulario = new Fm_Marca(id_usuario, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        Form_Venta ventas = new Form_Venta();
         ventas.setLocationRelativeTo(null);
        ventas.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
       Fm_Tipodoc formulario = new Fm_Tipodoc();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
   Fm_Sede formulario = new Fm_Sede(id_usuario, id_sede, 1);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenu7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu7ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
   
        Fm_Perfil formulario = new Fm_Perfil(0);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
             Fm_Usuario formulario = new Fm_Usuario(0, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
          Fm_Igv formulario = new Fm_Igv();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
          Fm_Grupo_Igv formulario = new Fm_Grupo_Igv();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
     Fm_Clientes formulario = new Fm_Clientes(id_usuario, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Menu_Principal("", 0, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel txtCargo;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtHora;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
