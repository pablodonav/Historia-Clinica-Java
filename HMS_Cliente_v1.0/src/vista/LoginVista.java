/**
 * LoginVista.java
 * Adnana Catrinel Dragut
 * v1.0 28/03/2022.
 * 
 */

package vista;

import com.google.gson.Gson;
import control.Hospital;
import control.OyenteVista;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.clasesDTOs.UsuarioDTO;
import modelo.clasesProxys.Comms;
import modelo.clasesProxys.ProxyUsuario;
import org.apache.commons.codec.digest.DigestUtils;
import vista.vistasUsuarioAdmin.MenuAdminVista;
import vista.vistasUsuarioSanitario.MenuSanitarioVista;

/**
 * Clase que contiene los métodos para crear y gestionar 
 * los componentes y los eventos de la pantalla Login.
 * 
 */
public class LoginVista extends javax.swing.JFrame{
    private ProxyUsuario pxUsuario = null;
    private Comms comms = null;
    private Gson gson = null;
    private OyenteVista oyenteVista = null;
    private String idConexion = null;
    
    private static final String EMAIL_PATTERN = "^(.+)@(.+)\\.[a-z]{2,}$";

    /* Mensajes de Error */
    private String ERROR_LOGIN = 
            "No se ha podido iniciar sesión en el sistema.\n" + 
            "Vuelva a introducir las credenciales.";
    private String ERROR_SINTAXIS_EMAIL =  
            "Sintaxis de correo electrónico errónea.\n" +
            "Vuelva a introducir las credenciales.";
    private String ERROR_VERIFICACIÓN_USUARIO = 
        "El usuario introducido no existe en el sistema.\n" + 
        "Vuelva a introducir las credenciales.";
    
    /**
     * Crea e inicializa los componentes de LoginVista.
     * 
     * @param _oyenteVista
     * @param _comms
     * @param _idConexion 
     */
    public LoginVista(OyenteVista _oyenteVista, Comms _comms, String _idConexion) {
        this.pxUsuario = ProxyUsuario.getInstance();
        this.comms = _comms;
        this.gson = new Gson();
        this.oyenteVista = _oyenteVista;
        this.idConexion = _idConexion;

        initComponents();
        setResizable(false);  // deshabilita la opción de maximizar-minimizar 
        pack();   // ajusta ventana y sus componentes
        setLocationRelativeTo(null);  // centra en la pantalla
        habilitarBotonConectado(idConexion);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        panel_principal = new javax.swing.JPanel();
        panel_izqd = new javax.swing.JPanel();
        hospital_icon = new javax.swing.JLabel();
        hospital_label = new javax.swing.JLabel();
        management_label = new javax.swing.JLabel();
        system_label = new javax.swing.JLabel();
        email_label = new javax.swing.JLabel();
        asterisco_label_email = new javax.swing.JLabel();
        dni_input_field = new javax.swing.JTextField();
        b_Login = new javax.swing.JButton();
        campo_obligatorio_label = new javax.swing.JLabel();
        b_connecter = new javax.swing.JButton();
        dni_label = new javax.swing.JLabel();
        asterisco_label_dni = new javax.swing.JLabel();
        correo_input_field = new javax.swing.JTextField();
        pwd_label = new javax.swing.JLabel();
        asterisco_label_pwd = new javax.swing.JLabel();
        pwd_input_field = new javax.swing.JPasswordField();
        b_show_pwd = new javax.swing.JToggleButton();

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(51, 255, 204));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_principal.setBackground(new java.awt.Color(255, 255, 255));

        panel_izqd.setBackground(new java.awt.Color(0, 153, 153));

        hospital_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/hospital_icon.png"))); // NOI18N

        hospital_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        hospital_label.setText("HOSPITAL");

        management_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        management_label.setText("MANAGEMENT");

        system_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        system_label.setText("SYSTEM");

        javax.swing.GroupLayout panel_izqdLayout = new javax.swing.GroupLayout(panel_izqd);
        panel_izqd.setLayout(panel_izqdLayout);
        panel_izqdLayout.setHorizontalGroup(
            panel_izqdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_izqdLayout.createSequentialGroup()
                .addGap(13, 61, Short.MAX_VALUE)
                .addComponent(hospital_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_izqdLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panel_izqdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(system_label)
                    .addComponent(hospital_label)
                    .addComponent(management_label))
                .addGap(26, 26, 26))
        );
        panel_izqdLayout.setVerticalGroup(
            panel_izqdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_izqdLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(hospital_icon)
                .addGap(33, 33, 33)
                .addComponent(hospital_label)
                .addGap(31, 31, 31)
                .addComponent(management_label)
                .addGap(30, 30, 30)
                .addComponent(system_label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        email_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        email_label.setText("Email");

        asterisco_label_email.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_email.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_email.setText("*");

        dni_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dni_input_fieldKeyTyped(evt);
            }
        });

        b_Login.setBackground(new java.awt.Color(204, 204, 204));
        b_Login.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_Login.setForeground(new java.awt.Color(0, 153, 153));
        b_Login.setText("Login");
        b_Login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_Login.setEnabled(false);
        b_Login.setFocusable(false);
        b_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_LoginActionPerformed(evt);
            }
        });

        campo_obligatorio_label.setFont(new java.awt.Font("Berlin Sans FB", 2, 13)); // NOI18N
        campo_obligatorio_label.setForeground(new java.awt.Color(255, 51, 0));
        campo_obligatorio_label.setText("* Campos obligatorios");

        b_connecter.setBackground(new java.awt.Color(204, 204, 204));
        b_connecter.setText("   ");
        b_connecter.setBorder(null);
        b_connecter.setEnabled(false);
        b_connecter.setFocusable(false);
        b_connecter.setSelected(true);

        dni_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        dni_label.setText("DNI");

        asterisco_label_dni.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_dni.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_dni.setText("*");

        correo_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correo_input_fieldKeyTyped(evt);
            }
        });

        pwd_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        pwd_label.setText("Contraseña");

        asterisco_label_pwd.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_pwd.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_pwd.setText("*");

        pwd_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwd_input_fieldKeyTyped(evt);
            }
        });

        b_show_pwd.setForeground(new java.awt.Color(255, 255, 255));
        b_show_pwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/eye_icon.png"))); // NOI18N
        b_show_pwd.setBorderPainted(false);
        b_show_pwd.setContentAreaFilled(false);
        b_show_pwd.setFocusable(false);
        b_show_pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_show_pwdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addComponent(panel_izqd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                        .addComponent(pwd_label, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(asterisco_label_pwd))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                        .addComponent(email_label, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(asterisco_label_email))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                        .addComponent(dni_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(asterisco_label_dni))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(dni_input_field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                            .addComponent(correo_input_field, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pwd_input_field, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b_show_pwd)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel_principalLayout.createSequentialGroup()
                                .addGap(0, 156, Short.MAX_VALUE)
                                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(b_connecter, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel_principalLayout.createSequentialGroup()
                                        .addComponent(campo_obligatorio_label, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_izqd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addComponent(b_connecter)
                .addGap(26, 26, 26)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addComponent(dni_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dni_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_principalLayout.createSequentialGroup()
                                .addComponent(email_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(correo_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_principalLayout.createSequentialGroup()
                                        .addComponent(pwd_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pwd_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b_show_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                        .addComponent(campo_obligatorio_label)
                                        .addGap(29, 29, 29)
                                        .addComponent(b_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(panel_principalLayout.createSequentialGroup()
                                        .addComponent(asterisco_label_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panel_principalLayout.createSequentialGroup()
                                .addComponent(asterisco_label_email, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addComponent(asterisco_label_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    /**
     * Muestra un botón con el estado de la appCliente,
     * se mostrará el color verde si la conexión con el servidor
     * ha sido exitosa o el color amarillo en caso contrario. 
     * 
     * @param _idConexion 
     */
    private void habilitarBotonConectado(String _idConexion){
        if (idConexion.equals("0")){
            b_connecter.setEnabled(false);
            b_connecter.setText("Disconnected");
            b_connecter.setBackground(Color.YELLOW);
        } else{
            b_connecter.setEnabled(true);
            b_connecter.setText("Connected with id " + _idConexion);
            b_connecter.setBackground(Color.GREEN);
        }
    }
    
    /**
     * Escribe mensaje con diálogo modal.
     * 
     * @param _mensaje
     */    
    public void mensajeDialogo(String _mensaje) {
        JOptionPane.showMessageDialog(this, _mensaje, 
            Hospital.TITULO + " " + Hospital.VERSION, 
            JOptionPane.ERROR_MESSAGE,  null);    
    } 
    
    /**
     * Verifica que la sintaxis del email es correcta.
     * 
     * @param email
     * @param pwd
     * @return boolean
     */
    private boolean sintaxisCorreoCorrecta(String email){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    /**
     * Lee los datos del formulario y crea el json del usuario a verificar
     * 
     * @return String
     * @throws Exception
     */
    private String crearJsonUsuarioAVerificar() throws Exception{
        String usuarioJson = null;
        
        String dni = dni_input_field.getText();
        String email = correo_input_field.getText();
        String pwd = String.valueOf(pwd_input_field.getPassword());
        
        if (sintaxisCorreoCorrecta(email)){
            /* Se encripta la contraseña introducida por el usuario con algoritmo md5 */
            String encriptMD5_pwd = DigestUtils.md5Hex(pwd);

            UsuarioDTO usuario = new UsuarioDTO(dni, email, encriptMD5_pwd);
            usuarioJson = usuario.toJson(); 
            
        } else{     
            throw new Exception(ERROR_SINTAXIS_EMAIL);
        }
        return usuarioJson;
    }
    
    /**
     * Envía el json del usuario a verficar al servidor, y en el caso 
     * en el que las credenciales son válidas habilita la siguiente 
     * pantalla en función del usuario que ha iniciado sesión.
     * 
     * @param evt 
     */
    private void b_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_LoginActionPerformed
        try {
            String usuarioJsonSended = crearJsonUsuarioAVerificar();
            
            if (usuarioJsonSended != null && ! usuarioJsonSended.isBlank()){
                String usuarioJsonReceived = pxUsuario.verificarUsuario(usuarioJsonSended); 

                if(usuarioJsonReceived != null && ! usuarioJsonReceived.isBlank()){
                    UsuarioDTO usuario = gson.fromJson(usuarioJsonReceived, UsuarioDTO.class);
                    this.dispose();

                    if (usuario.isAdmin()){
                        new MenuAdminVista(oyenteVista, comms, idConexion).setVisible(true);
                    } else{
                        new MenuSanitarioVista(oyenteVista, comms, idConexion).setVisible(true);
                    }
                } else{
                    throw new Exception(ERROR_VERIFICACIÓN_USUARIO);
                }  
            } else{
                throw new Exception(ERROR_LOGIN);
            }
        } catch (Exception ex) {
            mensajeDialogo(ex.getMessage());
        } 
    }//GEN-LAST:event_b_LoginActionPerformed

    /**
     * Habilita el botón de Login si los campos "dni", "correo", "contraseña" y
     * "Repita contraseña" han sido completados y no poseen solo valores en blanco.
     */
    private void changed(){
        if (dni_input_field.getText().isBlank() || 
            correo_input_field.getText().isBlank() || 
            String.valueOf(pwd_input_field.getPassword()).isBlank()){
            
            b_Login.setEnabled(false);
        }
        else {
            b_Login.setEnabled(true);
        }
    }
    
    /**
     * Captura los eventos relacionados con la modificación del campo "dni".
     * 
     * @param evt 
     */
    private void dni_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dni_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_dni_input_fieldKeyTyped

    /**
     * Captura los eventos relacionados con la modificación del campo "pwd1".
     * 
     * @param evt 
     */
    private void pwd_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_pwd_input_fieldKeyTyped
    
    /**
     * Captura el evento relacionado con el cierre de la ventana y 
     * envía el evento a la capa control para realizar las acciones
     * de finalización necesarias para la appCliente.
     * 
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oyenteVista.eventoProducido(OyenteVista.Evento.SALIR, null);
    }//GEN-LAST:event_formWindowClosing

    /**
     * Captura los eventos relacionados con la modificación del campo "correo".
     * 
     * @param evt 
     */
    private void correo_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correo_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_correo_input_fieldKeyTyped

    /**
     * Muestra u oculta la contraseña introducida 
     * 
     * @param evt 
     */
    private void b_show_pwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_show_pwdActionPerformed
        if (b_show_pwd.isSelected()){
            b_show_pwd.setContentAreaFilled(true);
            pwd_input_field.setEchoChar((char)0);
        } else{
            b_show_pwd.setContentAreaFilled(false);
            pwd_input_field.setEchoChar('*');
        }
    }//GEN-LAST:event_b_show_pwdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asterisco_label_dni;
    private javax.swing.JLabel asterisco_label_email;
    private javax.swing.JLabel asterisco_label_pwd;
    private javax.swing.JButton b_Login;
    private javax.swing.JButton b_connecter;
    private javax.swing.JToggleButton b_show_pwd;
    private javax.swing.JLabel campo_obligatorio_label;
    private javax.swing.JTextField correo_input_field;
    private javax.swing.JTextField dni_input_field;
    private javax.swing.JLabel dni_label;
    private javax.swing.JLabel email_label;
    private javax.swing.JLabel hospital_icon;
    private javax.swing.JLabel hospital_label;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel management_label;
    private javax.swing.JPanel panel_izqd;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JPasswordField pwd_input_field;
    private javax.swing.JLabel pwd_label;
    private javax.swing.JLabel system_label;
    // End of variables declaration//GEN-END:variables
}
