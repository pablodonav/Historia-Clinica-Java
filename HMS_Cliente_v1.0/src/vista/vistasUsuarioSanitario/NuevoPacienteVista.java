/**
 * NuevoPacienteVista.java
 * Adnana Catrinel Dragut
 * v2.0 19/04/2022.
 * 
 */
package vista.vistasUsuarioSanitario;

import com.google.gson.Gson;
import control.Hospital;
import control.OyenteVista;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;
import modelo.clasesDTOs.PacienteDTO;
import modelo.clasesProxys.Comms;
import modelo.clasesProxys.ProxyPaciente;

/**
 * Clase que contiene los métodos para crear y gestionar 
 * los componentes y los eventos de la pantalla NuevoPacienteVista.
 * 
 */
public class NuevoPacienteVista extends javax.swing.JFrame implements PropertyChangeListener{
    private MenuSanitarioVista menuSanitarioVista = null;
    private Comms comms = null;
    private Gson gson = null;
    private OyenteVista oyenteVista = null;
    private String idConexion = null;
    private boolean botonGuardarPulsado = false;
    
    /* Mensajes de Error */
    public final static String ERROR_NUEVO_PACIENTE = 
            "No se ha podido realizar la operación para añadir un nuevo paciente.\n" + 
            "Vuelva a introducir los datos.";
    
    /* Mensajes de Éxito */
    public final static String EXITO_NUEVO_PACIENTE = 
            "Se ha añadido al paciente con nss: ";
    
    /**
     * Crea e inicializa los componentes de NuevoPacienteVista.
     * 
     * @param _menuSanitarioVista
     * @param _oyenteVista
     * @param _comms
     * @param _idConexion 
     */
    public NuevoPacienteVista(MenuSanitarioVista _menuSanitarioVista, 
            OyenteVista _oyenteVista, Comms _comms, String _idConexion) {
        this.menuSanitarioVista  = _menuSanitarioVista;
        this.comms = _comms;
        this.gson = new Gson();
        this.oyenteVista = _oyenteVista;
        this.idConexion = _idConexion;
        comms.nuevoObservador(this);
        
        initComponents();
        setResizable(false);  //Deshabilita la opción de maximizar-minimizar 
        pack();   // ajusta ventana y sus componentes
        setLocationRelativeTo(null);  // centra en la pantalla
        habilitarBotonConectado(idConexion);
        
        /* Subraya el texto "Datos" */
        datos_label.setText("<HTML><U>Datos</U></HTML>");
        panel_principal.setLayout(null);
        datos_label.setLocation(340, 100);
                    
        b_Guardar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        paner_superior = new javax.swing.JPanel();
        nuevoPaciente_label = new javax.swing.JLabel();
        hospital_icon = new javax.swing.JLabel();
        b_connected = new javax.swing.JButton();
        datos_label = new javax.swing.JLabel();
        asterisco_label_nombre = new javax.swing.JLabel();
        nombre_label1 = new javax.swing.JLabel();
        asterisco_label_prim_apellido = new javax.swing.JLabel();
        apellido1_label = new javax.swing.JLabel();
        asterisco_label_segun_apellido = new javax.swing.JLabel();
        apellido2_label = new javax.swing.JLabel();
        asterisco_label_edad = new javax.swing.JLabel();
        edad_label = new javax.swing.JLabel();
        asterisco_label_peso = new javax.swing.JLabel();
        peso_label = new javax.swing.JLabel();
        asterisco_label_altura = new javax.swing.JLabel();
        altura_label = new javax.swing.JLabel();
        asterisco_label_nss = new javax.swing.JLabel();
        nss_label = new javax.swing.JLabel();
        asterisco_label_alergias = new javax.swing.JLabel();
        alergias_label = new javax.swing.JLabel();
        b_Cancelar = new javax.swing.JButton();
        b_Guardar = new javax.swing.JButton();
        campo_obligatorio_label = new javax.swing.JLabel();
        nombre_input_field = new javax.swing.JTextField();
        apellido1_input_field = new javax.swing.JTextField();
        apellido2_input_field = new javax.swing.JTextField();
        edad_input_field = new javax.swing.JTextField();
        peso_input_field = new javax.swing.JTextField();
        altura_input_field = new javax.swing.JTextField();
        nss_input_field = new javax.swing.JTextField();
        alergias_input_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_principal.setBackground(new java.awt.Color(255, 255, 255));

        paner_superior.setBackground(new java.awt.Color(0, 153, 153));
        paner_superior.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        nuevoPaciente_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        nuevoPaciente_label.setText("Nuevo Paciente");

        hospital_icon.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        hospital_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/hospital_icon.png"))); // NOI18N
        hospital_icon.setMaximumSize(new java.awt.Dimension(70, 70));
        hospital_icon.setMinimumSize(new java.awt.Dimension(70, 70));
        hospital_icon.setPreferredSize(new java.awt.Dimension(70, 70));

        b_connected.setBackground(new java.awt.Color(204, 204, 204));
        b_connected.setText("   ");
        b_connected.setBorder(null);
        b_connected.setEnabled(false);
        b_connected.setFocusable(false);
        b_connected.setSelected(true);

        javax.swing.GroupLayout paner_superiorLayout = new javax.swing.GroupLayout(paner_superior);
        paner_superior.setLayout(paner_superiorLayout);
        paner_superiorLayout.setHorizontalGroup(
            paner_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paner_superiorLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(hospital_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(paner_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paner_superiorLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(nuevoPaciente_label)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paner_superiorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_connected, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        paner_superiorLayout.setVerticalGroup(
            paner_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hospital_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(paner_superiorLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(nuevoPaciente_label)
                .addGap(11, 11, 11)
                .addComponent(b_connected))
        );

        datos_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        datos_label.setForeground(new java.awt.Color(0, 153, 153));
        datos_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datos_label.setText("Datos");
        datos_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        asterisco_label_nombre.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_nombre.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_nombre.setText("*");

        nombre_label1.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        nombre_label1.setText("Nombre");

        asterisco_label_prim_apellido.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_prim_apellido.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_prim_apellido.setText("*");

        apellido1_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        apellido1_label.setText("1º. Apellido");

        asterisco_label_segun_apellido.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_segun_apellido.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_segun_apellido.setText("*");

        apellido2_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        apellido2_label.setText("2º. Apellido");

        asterisco_label_edad.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_edad.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_edad.setText("*");

        edad_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        edad_label.setText("Edad");

        asterisco_label_peso.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_peso.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_peso.setText("*");

        peso_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        peso_label.setText("Peso");

        asterisco_label_altura.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_altura.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_altura.setText("*");

        altura_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        altura_label.setText("Altura");

        asterisco_label_nss.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_nss.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_nss.setText("*");

        nss_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        nss_label.setText("NSS");

        asterisco_label_alergias.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_alergias.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_alergias.setText("*");

        alergias_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        alergias_label.setText("Alergias");

        b_Cancelar.setBackground(new java.awt.Color(204, 204, 204));
        b_Cancelar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_Cancelar.setForeground(new java.awt.Color(0, 153, 153));
        b_Cancelar.setText("Cancelar");
        b_Cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_Cancelar.setFocusable(false);
        b_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_CancelarActionPerformed(evt);
            }
        });

        b_Guardar.setBackground(new java.awt.Color(204, 204, 204));
        b_Guardar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_Guardar.setForeground(new java.awt.Color(0, 153, 153));
        b_Guardar.setText("Guardar");
        b_Guardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_Guardar.setFocusable(false);
        b_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_GuardarActionPerformed(evt);
            }
        });

        campo_obligatorio_label.setFont(new java.awt.Font("Berlin Sans FB", 2, 13)); // NOI18N
        campo_obligatorio_label.setForeground(new java.awt.Color(255, 51, 0));
        campo_obligatorio_label.setText("* Campos obligatorios");

        nombre_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_input_fieldKeyTyped(evt);
            }
        });

        apellido1_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido1_input_fieldKeyTyped(evt);
            }
        });

        apellido2_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido2_input_fieldKeyTyped(evt);
            }
        });

        edad_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edad_input_fieldKeyTyped(evt);
            }
        });

        peso_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                peso_input_fieldKeyTyped(evt);
            }
        });

        altura_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altura_input_fieldKeyTyped(evt);
            }
        });

        nss_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nss_input_fieldKeyTyped(evt);
            }
        });

        alergias_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alergias_input_fieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paner_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(asterisco_label_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(asterisco_label_edad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                                .addComponent(nombre_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombre_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                                .addComponent(edad_label)
                                .addGap(5, 5, 5)
                                .addComponent(edad_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(asterisco_label_peso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(peso_label)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_principalLayout.createSequentialGroup()
                                .addComponent(peso_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(asterisco_label_altura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(altura_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(altura_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(asterisco_label_nss)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nss_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nss_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_principalLayout.createSequentialGroup()
                                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel_principalLayout.createSequentialGroup()
                                        .addComponent(asterisco_label_prim_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(apellido1_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(apellido1_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(asterisco_label_segun_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(apellido2_label))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(datos_label)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apellido2_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addComponent(asterisco_label_alergias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alergias_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alergias_input_field))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                                .addComponent(b_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campo_obligatorio_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addComponent(paner_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datos_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellido1_label)
                    .addComponent(apellido2_label)
                    .addComponent(asterisco_label_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asterisco_label_prim_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asterisco_label_segun_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_label1)
                    .addComponent(nombre_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido1_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido2_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edad_label)
                    .addComponent(asterisco_label_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peso_label)
                    .addComponent(asterisco_label_peso, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altura_label)
                    .addComponent(asterisco_label_altura, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nss_label)
                    .addComponent(asterisco_label_nss, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edad_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peso_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altura_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nss_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alergias_label)
                    .addComponent(asterisco_label_alergias, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alergias_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campo_obligatorio_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
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
            b_connected.setEnabled(false);
            b_connected.setText("Disconnected");
            b_connected.setBackground(Color.YELLOW);
        } else{
            b_connected.setEnabled(true);
            b_connected.setText("Connected with id " + _idConexion);
            b_connected.setBackground(Color.GREEN);
        }
    }
    
    /**
     * Escribe mensaje con diálogo modal.
     * 
     * @param _mensaje
     * @param _messageType
     */    
    public void mensajeDialogo(String _mensaje, int _messageType) {
        JOptionPane.showMessageDialog(this, _mensaje, 
            Hospital.TITULO + " " + Hospital.VERSION, 
            _messageType,  null);    
    } 
    
    /**
     * Cierra la ventana actual y regresa a la ventana MenuSanitarioVista
     * 
     * @param evt 
     */
    private void b_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_CancelarActionPerformed
        this.dispose();
        menuSanitarioVista.setVisible(true);
    }//GEN-LAST:event_b_CancelarActionPerformed

    /**
     * Captura la información de los campos rellenados por el usuario y
     * crea el json del paciente nuevo con dicha información
     * 
     * @return String
     */
    private String crearJsonPacienteNuevo(){
        String nombre = nombre_input_field.getText();
        String apellido1 = apellido1_input_field.getText();
        String apellido2 = apellido2_input_field.getText();
        String edad = edad_input_field.getText();
        String peso = peso_input_field.getText();
        String altura = altura_input_field.getText();
        String nss = nss_input_field.getText();
        String alergias = alergias_input_field.getText();
                
        PacienteDTO paciente = new PacienteDTO(nss, nombre, apellido1, apellido2, 
            alergias, Integer.parseInt(edad), Double.parseDouble(peso), Double.parseDouble(altura));
        
        return paciente.toJson();
    }
    
    /**
     * Envía la solicitud para dar de alta un paciente a la capa control
     * 
     * @param evt 
     */
    private void b_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_GuardarActionPerformed
        String pacienteJsonToSend = crearJsonPacienteNuevo();

        if (pacienteJsonToSend != null){
            /* Permite saber si el usuario actual es el que ha solicitado la operación de añadir un nuevo paciente */
            botonGuardarPulsado = true;
                
            oyenteVista.eventoProducido(OyenteVista.Evento.NUEVO_PACIENTE, pacienteJsonToSend);
        } else{
            mensajeDialogo(ERROR_NUEVO_PACIENTE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_b_GuardarActionPerformed

    /**
     * Captura el evento relacionado con el cierre de la ventana, y 
     * envía el evento a la capa control para realizar las acciones
     * de finalización necesarias para la appCliente.
     * 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oyenteVista.eventoProducido(OyenteVista.Evento.SALIR, null);
    }//GEN-LAST:event_formWindowClosing

    /**
     * Habilita el botón de Guardar si todos los campos 
     * han sido completados y no poseen solo valores en blanco.
     */
    private void changed(){
        if (nombre_input_field.getText().isBlank() || 
            apellido1_input_field.getText().isBlank() ||
            apellido2_input_field.getText().isBlank() ||
            edad_input_field.getText().isBlank() || 
            peso_input_field.getText().isBlank() ||
            altura_input_field.getText().isBlank()||
            nss_input_field.getText().isBlank() ||
            alergias_input_field.getText().isBlank()){
  
            b_Guardar.setEnabled(false);
        }
        else {
            b_Guardar.setEnabled(true);
        }
    }
    
    /**
     * Captura los eventos relacionados con la modificación del campo "nombre".
     * 
     * @param evt
     */
    private void nombre_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_nombre_input_fieldKeyTyped

    /**
     * Captura los eventos relacionados con la modificación del campo "apellido1".
     * 
     * @param evt
     */
    private void apellido1_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido1_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_apellido1_input_fieldKeyTyped

    /**
     * Captura los eventos relacionados con la modificación del campo "apellido2".
     * 
     * @param evt
     */
    private void apellido2_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido2_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_apellido2_input_fieldKeyTyped

    /**
     * Captura los eventos relacionados con la modificación del campo "edad".
     * 
     * @param evt
     */
    private void edad_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edad_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_edad_input_fieldKeyTyped

    /**
     * Captura los eventos relacionados con la modificación del campo "peso".
     * 
     * @param evt
     */
    private void peso_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_peso_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_peso_input_fieldKeyTyped

    /**
     * Captura los eventos relacionados con la modificación del campo "altura".
     * 
     * @param evt
     */
    private void altura_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altura_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_altura_input_fieldKeyTyped

    /**
     * Captura los eventos relacionados con la modificación del campo "nss".
     * 
     * @param evt
     */
    private void nss_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nss_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_nss_input_fieldKeyTyped

    /**
     * Captura los eventos relacionados con la modificación del campo "alergias".
     * 
     * @param evt
     */
    private void alergias_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alergias_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_alergias_input_fieldKeyTyped
    
    /**
     * Recibe evento añadir nuevo paciente
     * 
     * @param evt 
     */
    private void propiedadNuevoPaciente(PropertyChangeEvent evt){
        String pacienteJsonToReceive = (String)evt.getNewValue();
        PacienteDTO pacienteDTOReceived = gson.fromJson(
           pacienteJsonToReceive, PacienteDTO.class);

        if(botonGuardarPulsado){
            mensajeDialogo(EXITO_NUEVO_PACIENTE + 
                pacienteDTOReceived.getNss(), JOptionPane.INFORMATION_MESSAGE);
        }

        comms.eliminarObservador(this);
        this.dispose();
        menuSanitarioVista.setVisible(true);      
    }
    
    /**
     * Sobreescribe propertyChange para recibir cambios de modelo.
     * 
     * @param evt 
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(
                ProxyPaciente.PROPIEDAD_NUEVO_PACIENTE)) {
            
            propiedadNuevoPaciente(evt);
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alergias_input_field;
    private javax.swing.JLabel alergias_label;
    private javax.swing.JTextField altura_input_field;
    private javax.swing.JLabel altura_label;
    private javax.swing.JTextField apellido1_input_field;
    private javax.swing.JLabel apellido1_label;
    private javax.swing.JTextField apellido2_input_field;
    private javax.swing.JLabel apellido2_label;
    private javax.swing.JLabel asterisco_label_alergias;
    private javax.swing.JLabel asterisco_label_altura;
    private javax.swing.JLabel asterisco_label_edad;
    private javax.swing.JLabel asterisco_label_nombre;
    private javax.swing.JLabel asterisco_label_nss;
    private javax.swing.JLabel asterisco_label_peso;
    private javax.swing.JLabel asterisco_label_prim_apellido;
    private javax.swing.JLabel asterisco_label_segun_apellido;
    private javax.swing.JButton b_Cancelar;
    private javax.swing.JButton b_Guardar;
    private javax.swing.JButton b_connected;
    private javax.swing.JLabel campo_obligatorio_label;
    private javax.swing.JLabel datos_label;
    private javax.swing.JTextField edad_input_field;
    private javax.swing.JLabel edad_label;
    private javax.swing.JLabel hospital_icon;
    private javax.swing.JTextField nombre_input_field;
    private javax.swing.JLabel nombre_label1;
    private javax.swing.JTextField nss_input_field;
    private javax.swing.JLabel nss_label;
    private javax.swing.JLabel nuevoPaciente_label;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JPanel paner_superior;
    private javax.swing.JTextField peso_input_field;
    private javax.swing.JLabel peso_label;
    // End of variables declaration//GEN-END:variables
}
