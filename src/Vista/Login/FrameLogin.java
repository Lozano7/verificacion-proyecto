package Vista.Login;

import Modelo.DataBase.Conexion;

/**
 * Frame para Iniciar Sesión al Sistema
 *
 * @author John
 */
public class FrameLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrameLogin
     */
    public FrameLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        título = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelCentral = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        lblPuerto = new javax.swing.JLabel();
        cbPuerto = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        título.setBackground(new java.awt.Color(28, 11, 25));

        jLabel1.setFont(new java.awt.Font("HP Simplified", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 239, 244));
        jLabel1.setText("Iniciar Sesión");
        título.add(jLabel1);

        panelCentral.setBackground(new java.awt.Color(0, 102, 204));

        lblUsuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(236, 239, 244));
        lblUsuario.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        lblContraseña.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(236, 239, 244));
        lblContraseña.setText("Contraseña:");

        txtContraseña.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });

        btnIngresar.setBackground(new java.awt.Color(28, 11, 25));
        btnIngresar.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(236, 239, 244));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        lblPuerto.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lblPuerto.setForeground(new java.awt.Color(236, 239, 244));
        lblPuerto.setText("Puerto:");

        cbPuerto.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        cbPuerto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1521", "1522" }));

        btnSalir.setBackground(new java.awt.Color(204, 0, 51));
        btnSalir.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(236, 239, 244));
        btnSalir.setText("Salir");
        btnSalir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCentralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblUsuario)
                    .addComponent(lblContraseña)
                    .addComponent(lblPuerto))
                .addGap(33, 33, 33)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario)
                    .addComponent(txtContraseña)
                    .addComponent(cbPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addGap(18, 18, 18)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblContraseña)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuerto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(título, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addComponent(título, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        getContentPane().add(panelSuperior, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        Conexion.iniciarDatos(txtUsuario.getText(), txtContraseña.getText());
        if (Conexion.establecerConexion() != null) {
            FrameOpciones opcion = new FrameOpciones();
            opcion.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbPuerto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblPuerto;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPanel título;
    // End of variables declaration//GEN-END:variables
}
