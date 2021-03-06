/**
 * EditarSanitarioVista.java
 * Adnana Catrinel Dragut
 * v2.0 08/04/2022.
 * 
 */
package vista.vistasUsuarioAdmin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import control.Hospital;
import control.OyenteVista;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.table.DefaultTableModel;
import modelo.clasesDTOs.SanitarioDTO;
import modelo.clasesProxys.Comms;
import modelo.clasesProxys.ProxySanitario;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Clase que contiene los métodos para crear y gestionar 
 * los componentes y los eventos de la pantalla EditarSanitarioVista.
 * 
 */
public class EditarSanitarioVista extends javax.swing.JFrame implements PropertyChangeListener{
    private MenuAdminVista menuAdminVista = null;
    private Comms comms = null;
    private Gson gson = null;
    private OyenteVista oyenteVista = null;
    private String idConexion = null;
    private ProxySanitario pxSanitario = null;
    private List<SanitarioDTO> sanitarios = null;
    private DefaultTableModel tableModel = null;
    private boolean botonGuardarCambiosPulsado = false;
    private boolean botonEliminarPulsado = false;
    
    private static final int INDEX_COLUMNA_DNI = 3;
    private static final int INDEX_SANITARIO_NO_SELECCIONADO = -1;
    private static final String EMAIL_PATTERN = "^(.+)@(.+)\\.[a-z]{2,}$";
    
    /* Mensajes de Error */
    private final String ERROR_OBTENER_SANITARIOS = 
            "No se ha podido obtener la lista con sanitarios.";
    public static final String ERROR_DAR_BAJA_SANITARIO = 
            "No se ha podido realizar la operación para dar de baja un sanitario.";
    public static final String ERROR_EDITAR_SANITARIO = 
            "No se ha podido realizar la operación para editar un sanitario.";
    private final String ERROR_SINTAXIS_EMAIL =  
            "Sintaxis de correo electrónico errónea.\n" +
            "Vuelva a introducir las credenciales.";
    private final String ERROR_CONSTRASEÑAS_DIFERENTES =  
            "Las contraseñas introducidas no coinciden.\n" +
            "Vuelva a introducir las credenciales.";
    
    /* Mensajes de Éxito */
    public final static String EXITO_DAR_BAJA_SANITARIO = 
           "Se ha dado de baja al sanitario con dni: ";
    public final static String EXITO_EDITAR_SANITARIO = 
           "Se ha modificado al sanitario con dni: " ;

    /**
     * Crea e inicializa los componentes de EditarSanitarioVista.
     * 
     * @param _menuAdminVista
     * @param _oyenteVista
     * @param _comms
     * @param _idConexion
     */
    public EditarSanitarioVista(MenuAdminVista _menuAdminVista, 
            OyenteVista _oyenteVista, Comms _comms,
            String _idConexion) {
        this.menuAdminVista  = _menuAdminVista;
        this.comms = _comms;
        this.gson = new Gson();
        this.oyenteVista = _oyenteVista;
        this.idConexion = _idConexion;
        this.pxSanitario = ProxySanitario.getInstance();
        this.sanitarios = obtenerListaConSanitarios();
        comms.nuevoObservador(this);
                
        initComponents();
        setResizable(false);  //Deshabilita la opción de maximizar-minimizar 
        pack();   // ajusta ventana y sus componentes
        setLocationRelativeTo(null);  // centra en la pantalla
        habilitarBotonConectado(_idConexion);
        cargarTablaConSanitarios();
        
        /* Subraya el texto "Lista Sanitarios" */
        lista_de_sanitarios_label.setText("<HTML><U>Lista Sanitarios</U></HTML>");
        panel_principal.setLayout(null);
        lista_de_sanitarios_label.setLocation(300, 100);
        
        /* Subraya el texto "Sanitario Seleccionado" */
        sanitario_seleccionado_label.setText("<HTML><U>Sanitario Seleccionado </U></HTML>");
        sanitario_seleccionado_label.setHorizontalAlignment(LEFT);
        
        b_ModificarSanitario.setEnabled(false);
        b_EliminarSanitario.setEnabled(false);
        b_GuardarCambios.setEnabled(false);
    }
    
    /**
     * Crea un EditarSanitarioVista vacío para realizar los tests con JUnit.
     * 
     */
    public EditarSanitarioVista(){
    }

    /**
     * Asigna una tabla con sanitarios para realizar tests con JUnit.
     * 
     * @param _tabla_con_sanitarios 
     */
    public void setTabla_con_sanitarios(JTable _tabla_con_sanitarios) {
        this.tabla_con_sanitarios = _tabla_con_sanitarios;
    }

    /**
     * Asigna el campo nombre para realizar tests con JUnit.
     * 
     * @param _nombre_input_field 
     */
    public void setNombre_input_field(JTextField _nombre_input_field) {
        this.nombre_input_field = _nombre_input_field;
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
        lista_de_sanitarios_label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_con_sanitarios = new javax.swing.JTable();
        b_GuardarCambios = new javax.swing.JButton();
        b_EliminarSanitario = new javax.swing.JButton();
        sanitario_seleccionado_label = new javax.swing.JLabel();
        nueva_contraseña_label = new javax.swing.JLabel();
        b_ModificarSanitario = new javax.swing.JButton();
        pwd1_input_field = new javax.swing.JPasswordField();
        b_Atrás = new javax.swing.JButton();
        nombre_label = new javax.swing.JLabel();
        nombre_input_field = new javax.swing.JTextField();
        apellido1_label = new javax.swing.JLabel();
        apellido1_input_field = new javax.swing.JTextField();
        apellido2_label = new javax.swing.JLabel();
        apellido2_input_field = new javax.swing.JTextField();
        dni_label = new javax.swing.JLabel();
        dni_input_field = new javax.swing.JTextField();
        tlfn_label = new javax.swing.JLabel();
        tlfn_input_field = new javax.swing.JTextField();
        correo_label = new javax.swing.JLabel();
        correo_input_field = new javax.swing.JTextField();
        puesto_label = new javax.swing.JLabel();
        puesto_comboBox = new javax.swing.JComboBox<>();
        paner_superior = new javax.swing.JPanel();
        editarSanitario_label = new javax.swing.JLabel();
        hospital_icon = new javax.swing.JLabel();
        b_connecter = new javax.swing.JButton();
        repita_contraseña_label = new javax.swing.JLabel();
        pwd2_input_field = new javax.swing.JPasswordField();
        b_Refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_principal.setBackground(new java.awt.Color(255, 255, 255));

        lista_de_sanitarios_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        lista_de_sanitarios_label.setForeground(new java.awt.Color(0, 153, 153));
        lista_de_sanitarios_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lista_de_sanitarios_label.setText("Lista de Sanitarios");
        lista_de_sanitarios_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        tabla_con_sanitarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido 1", "Apellido 2", "DNI", "Teléfono", "Correo", "Puesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_con_sanitarios.setFocusable(false);
        tabla_con_sanitarios.setGridColor(new java.awt.Color(0, 153, 153));
        tabla_con_sanitarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla_con_sanitarios.setShowGrid(true);
        tabla_con_sanitarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_con_sanitariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_con_sanitarios);

        b_GuardarCambios.setBackground(new java.awt.Color(204, 204, 204));
        b_GuardarCambios.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_GuardarCambios.setForeground(new java.awt.Color(0, 153, 153));
        b_GuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/save_icon.png"))); // NOI18N
        b_GuardarCambios.setText("Guardar cambios");
        b_GuardarCambios.setActionCommand("   Nuevo Sanitario");
        b_GuardarCambios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_GuardarCambios.setEnabled(false);
        b_GuardarCambios.setFocusable(false);
        b_GuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_GuardarCambiosActionPerformed(evt);
            }
        });

        b_EliminarSanitario.setBackground(new java.awt.Color(204, 204, 204));
        b_EliminarSanitario.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_EliminarSanitario.setForeground(new java.awt.Color(0, 153, 153));
        b_EliminarSanitario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/minus_icon.png"))); // NOI18N
        b_EliminarSanitario.setText("Eliminar Sanitario");
        b_EliminarSanitario.setActionCommand("   Nuevo Sanitario");
        b_EliminarSanitario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_EliminarSanitario.setEnabled(false);
        b_EliminarSanitario.setFocusable(false);
        b_EliminarSanitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_EliminarSanitarioActionPerformed(evt);
            }
        });

        sanitario_seleccionado_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        sanitario_seleccionado_label.setForeground(new java.awt.Color(0, 153, 153));
        sanitario_seleccionado_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sanitario_seleccionado_label.setText("Sanitario Seleccionado ");
        sanitario_seleccionado_label.setToolTipText("");
        sanitario_seleccionado_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        nueva_contraseña_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nueva_contraseña_label.setText("Nueva Contraseña");

        b_ModificarSanitario.setBackground(new java.awt.Color(204, 204, 204));
        b_ModificarSanitario.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_ModificarSanitario.setForeground(new java.awt.Color(0, 153, 153));
        b_ModificarSanitario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/edit-icon.png"))); // NOI18N
        b_ModificarSanitario.setText("Modificar Sanitario");
        b_ModificarSanitario.setActionCommand("   Nuevo Sanitario");
        b_ModificarSanitario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_ModificarSanitario.setEnabled(false);
        b_ModificarSanitario.setFocusable(false);
        b_ModificarSanitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ModificarSanitarioActionPerformed(evt);
            }
        });

        pwd1_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwd1_input_fieldKeyTyped(evt);
            }
        });

        b_Atrás.setBackground(new java.awt.Color(204, 204, 204));
        b_Atrás.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_Atrás.setForeground(new java.awt.Color(0, 153, 153));
        b_Atrás.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/atras_icon.png"))); // NOI18N
        b_Atrás.setText("   Atrás");
        b_Atrás.setActionCommand("   Nuevo Sanitario");
        b_Atrás.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_Atrás.setFocusable(false);
        b_Atrás.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_AtrásActionPerformed(evt);
            }
        });

        nombre_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nombre_label.setText("Nombre");

        nombre_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_input_fieldKeyTyped(evt);
            }
        });

        apellido1_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        apellido1_label.setText("Apellido 1");

        apellido1_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido1_input_fieldKeyTyped(evt);
            }
        });

        apellido2_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        apellido2_label.setText("Apellido 2");

        apellido2_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido2_input_fieldKeyTyped(evt);
            }
        });

        dni_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        dni_label.setText("DNI");

        dni_input_field.setEnabled(false);

        tlfn_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tlfn_label.setText("Teléfono");

        tlfn_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tlfn_input_fieldKeyTyped(evt);
            }
        });

        correo_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        correo_label.setText("Correo");

        correo_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correo_input_fieldKeyTyped(evt);
            }
        });

        puesto_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        puesto_label.setText("Puesto");

        puesto_comboBox.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        puesto_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Médico", "Enfermero", "Especialista", "Auxiliar", "Otros" }));
        puesto_comboBox.setSelectedIndex(-1);
        puesto_comboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                puesto_comboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        paner_superior.setBackground(new java.awt.Color(0, 153, 153));
        paner_superior.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        editarSanitario_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        editarSanitario_label.setText("Editar Sanitario");

        hospital_icon.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        hospital_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/hospital_icon.png"))); // NOI18N
        hospital_icon.setMaximumSize(new java.awt.Dimension(70, 70));
        hospital_icon.setMinimumSize(new java.awt.Dimension(70, 70));
        hospital_icon.setPreferredSize(new java.awt.Dimension(70, 70));

        b_connecter.setBackground(new java.awt.Color(204, 204, 204));
        b_connecter.setText("   ");
        b_connecter.setBorder(null);
        b_connecter.setEnabled(false);
        b_connecter.setFocusable(false);
        b_connecter.setSelected(true);

        javax.swing.GroupLayout paner_superiorLayout = new javax.swing.GroupLayout(paner_superior);
        paner_superior.setLayout(paner_superiorLayout);
        paner_superiorLayout.setHorizontalGroup(
            paner_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paner_superiorLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(hospital_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(paner_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paner_superiorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_connecter, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paner_superiorLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(editarSanitario_label)
                        .addGap(0, 282, Short.MAX_VALUE))))
        );
        paner_superiorLayout.setVerticalGroup(
            paner_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hospital_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(paner_superiorLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(editarSanitario_label)
                .addGap(12, 12, 12)
                .addComponent(b_connecter))
        );

        repita_contraseña_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        repita_contraseña_label.setText("Repita Contraseña");

        pwd2_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwd2_input_fieldKeyTyped(evt);
            }
        });

        b_Refresh.setBackground(new java.awt.Color(204, 204, 204));
        b_Refresh.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_Refresh.setForeground(new java.awt.Color(0, 153, 153));
        b_Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/refresh_icon.png"))); // NOI18N
        b_Refresh.setActionCommand("   Nuevo Sanitario");
        b_Refresh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_Refresh.setFocusable(false);
        b_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addComponent(paner_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_principalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(b_ModificarSanitario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_EliminarSanitario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sanitario_seleccionado_label, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                        .addComponent(nombre_label)
                                        .addGap(18, 18, 18)
                                        .addComponent(nombre_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(apellido1_label)
                                        .addGap(18, 18, 18)
                                        .addComponent(apellido1_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(apellido2_label)
                                        .addGap(18, 18, 18)
                                        .addComponent(apellido2_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                            .addComponent(b_Atrás, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(b_GuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                            .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                                    .addComponent(nueva_contraseña_label)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(pwd1_input_field))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                                    .addComponent(dni_label)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(dni_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(tlfn_label)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tlfn_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(panel_principalLayout.createSequentialGroup()
                                                    .addComponent(correo_label)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(correo_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(puesto_label)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(puesto_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panel_principalLayout.createSequentialGroup()
                                                    .addComponent(repita_contraseña_label)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(pwd2_input_field))))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(473, 473, 473))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addComponent(b_Refresh)
                        .addGap(230, 230, 230)
                        .addComponent(lista_de_sanitarios_label)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addComponent(paner_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lista_de_sanitarios_label)
                    .addComponent(b_Refresh))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_EliminarSanitario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_ModificarSanitario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sanitario_seleccionado_label)
                .addGap(18, 18, 18)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_label)
                    .addComponent(apellido1_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido1_label)
                    .addComponent(nombre_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido2_label)
                    .addComponent(apellido2_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dni_label)
                    .addComponent(dni_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlfn_label)
                    .addComponent(tlfn_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo_label)
                    .addComponent(correo_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puesto_label)
                    .addComponent(puesto_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nueva_contraseña_label)
                    .addComponent(pwd1_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(repita_contraseña_label)
                    .addComponent(pwd2_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(b_Atrás, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(b_GuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 748, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Obtiene la lista con los sanitarios dados de alta en el sistema
     * 
     * @return List<SanitarioDTO>
     * @throws Exception 
     */
    private List<SanitarioDTO> obtenerListaConSanitarios(){
        Gson gson = new Gson();
        List<SanitarioDTO> sanitarios = null;
        String sanitariosToReceive;
        
        try {
            sanitariosToReceive = pxSanitario.obtenerSanitarios();
            
            if (sanitariosToReceive != null){
                /* Permite obtener los sanitarios en un List con SanitarioDTO*/
                java.lang.reflect.Type listType = new TypeToken<List<SanitarioDTO>>(){}.getType(); 
                sanitarios = gson.fromJson(sanitariosToReceive, listType);
            } else{
                throw new Exception(ERROR_OBTENER_SANITARIOS);
            }
        } catch (Exception ex) {
            mensajeDialogo(ex.getMessage(), JOptionPane.ERROR);
        }
        
        return sanitarios;
    }
    
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
     * @param _messageType
     */    
    public void mensajeDialogo(String _mensaje, int _messageType) {
        JOptionPane.showMessageDialog(this, _mensaje, 
            Hospital.TITULO + " " + Hospital.VERSION, 
            _messageType,  null);    
    } 
    
    /**
     * Rellena la tabla con la información de los sanitarios 
     * existentes en el sistema.
     * 
     */
    public void cargarTablaConSanitarios(){
        tableModel = (DefaultTableModel) tabla_con_sanitarios.getModel();
        tableModel.getDataVector().removeAllElements();
        
        for (int i = 0; i < sanitarios.size(); i++){
            SanitarioDTO sanitario = sanitarios.get(i);
            tableModel.addRow(sanitario.toArray());
        }
    }
    
    /**
     * Cierra la ventana actual y regresa a la ventana MenuAdminVista
     * 
     * @param evt 
     */
    private void b_AtrásActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_AtrásActionPerformed
        comms.eliminarObservador(this);
        this.dispose();
        menuAdminVista.setVisible(true);
    }//GEN-LAST:event_b_AtrásActionPerformed

    /**
     * Obtener el dni del sanitario seleccionado en la tabla
     * 
     * @param _indexSanitarioSeleccionado
     * @return String
     */
    public String obtenerDniSanitarioSeleccionado(int _indexSanitarioSeleccionado){
        return  String.valueOf(tabla_con_sanitarios.getValueAt(
                    _indexSanitarioSeleccionado, INDEX_COLUMNA_DNI));
    }
    
    /**
     * Envía la solicitud para dar de baja un sanitario a la capa control
     * 
     * @param evt 
     */
    private void b_EliminarSanitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_EliminarSanitarioActionPerformed
        int indexSanitarioSeleccionado = tabla_con_sanitarios.getSelectedRow();
                
        if (indexSanitarioSeleccionado != INDEX_SANITARIO_NO_SELECCIONADO){
            /* Permite saber si el usuario actual es el que ha solicitado la operación de eliminar un sanitario */
            botonEliminarPulsado = true;
            
            String dniSanitario = obtenerDniSanitarioSeleccionado(indexSanitarioSeleccionado);

            oyenteVista.eventoProducido(OyenteVista.Evento.DAR_BAJA_SANITARIO,
                dniSanitario);
        }   
        
        /* Deshabilita botones hasta la próxima selección */
        b_EliminarSanitario.setEnabled(false);
        b_ModificarSanitario.setEnabled(false);
    }//GEN-LAST:event_b_EliminarSanitarioActionPerformed

    /**
     * Modifica el atributo "nombre" del sanitario almacenado en el 
     * List sanitarios (_sanitarioSeleccionado), si el campo nombre
     * ha sido modificado.
     * 
     * @param _sanitarioSeleccionado
     */
    public void modificarNombreSanitario(SanitarioDTO _sanitarioSeleccionado){
        if (! nombre_input_field.getText().equals(_sanitarioSeleccionado.getNombre())){
            _sanitarioSeleccionado.setNombre(nombre_input_field.getText());
        }
    }
    
    /**
     * Modifica el atributo "apellido1" del sanitario almacenado en el 
     * List sanitarios (_sanitarioSeleccionado), si el campo 
     * apellido1 ha sido modificado.
     * 
     * @param _sanitarioSeleccionado
     */
    private void modificarApellido1Sanitario(
            SanitarioDTO _sanitarioSeleccionado){
        
        if (! apellido1_input_field.getText().equals(
                _sanitarioSeleccionado.getApellido1())){
            
            _sanitarioSeleccionado.setApellido1(apellido1_input_field.getText());
        }
    }
    
    /**
     * Modifica el atributo "apellido2" del sanitario almacenado en el 
     * List sanitarios (_sanitarioSeleccionado), si el campo 
     * apellido2 ha sido modificado.
     * 
     * @param _sanitarioSeleccionado
     */
    private void modificarApellido2Sanitario(
            SanitarioDTO _sanitarioSeleccionado){
        
        if (! apellido2_input_field.getText().equals(
                _sanitarioSeleccionado.getApellido2())){
            
            _sanitarioSeleccionado.setApellido2(apellido2_input_field.getText());
        }
    }
    
    /**
     * Modifica el atributo "teléfono" del sanitario almacenado en el 
     * List sanitarios (_sanitarioSeleccionado), si el campo 
     * teléfono ha sido modificado.
     * 
     * @param _sanitarioSeleccionado 
     */
    private void modificarTelefonoSanitario(
            SanitarioDTO _sanitarioSeleccionado){
        if (Integer.parseInt(tlfn_input_field.getText()) !=
                _sanitarioSeleccionado.getTelefono()){
            
            _sanitarioSeleccionado.setTelefono(Integer.parseInt(
                tlfn_input_field.getText()));
        }
    }
    
    /**
     * Modifica el atributo "correo" del sanitario almacenado en el 
     * List sanitarios (_sanitarioSeleccionado), si el campo 
     * correo ha sido modificado.
     * 
     * @param _sanitarioSeleccionado
     * @throws Exception
     */
    private void modificarCorreoSanitario(SanitarioDTO _sanitarioSeleccionado) throws Exception{
        String nuevoCorreo = _sanitarioSeleccionado.getCorreoElectronico();
        
        if (! correo_input_field.getText().equals(nuevoCorreo)){
            if (sintaxisCorreoCorrecta(nuevoCorreo)){
                _sanitarioSeleccionado.setCorreoElectronico(correo_input_field.getText());
            } else{
                throw new Exception(ERROR_SINTAXIS_EMAIL);
            }
        }
    }
    
    /**
     * Modifica el atributo "puesto" del sanitario almacenado en el 
     * List sanitarios (_sanitarioSeleccionado), si el campo 
     * puesto ha sido modificado.
     * 
     * @param _sanitarioSeleccionado
     */
    private void modificarPuestoSanitario(SanitarioDTO _sanitarioSeleccionado){
        if (! String.valueOf(
                puesto_comboBox.getSelectedItem()).equalsIgnoreCase(
                    _sanitarioSeleccionado.getPuestoTrabajo())){
            
            _sanitarioSeleccionado.setPuestoTrabajo(String.valueOf(
                puesto_comboBox.getSelectedItem()));
        }   
    }
    
    /**
     * Modifica el atributo "contraseña" del sanitario almacenado en el 
     * List sanitarios (_sanitarioSeleccionado), si el campo 
     * contraseña ha sido modificado.
     * 
     * @param _sanitarioSeleccionado
     * @throws Exception
     */
    private void modificarContraseñaSanitario(
            SanitarioDTO _sanitarioSeleccionado) throws Exception{
        String pwd1 = String.valueOf(pwd1_input_field.getPassword());
        String pwd2 = String.valueOf(pwd2_input_field.getPassword());
        
        if (! pwd1.isBlank()){
            if (pwd1.equals(pwd2)){
                /* Se encripta la contraseña introducida por el usuario con algoritmo md5 */
                String encriptMD5_pwd = DigestUtils.md5Hex(String.valueOf(
                    pwd2_input_field.getPassword()));
               _sanitarioSeleccionado.setContraseña(encriptMD5_pwd); 
            } else{
                throw new Exception(ERROR_CONSTRASEÑAS_DIFERENTES);
            }
        }  
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
     * Captura la información de los campos editados por el usuario y
     * crea el json del sanitario editado con dicha información.
     * 
     * @return String
     * @throws Exception
     */
    private String crearJsonSanitarioEditado() throws Exception{ 
        int indexSanitarioSeleccionado = tabla_con_sanitarios.getSelectedRow();
        SanitarioDTO sanitarioSeleccionado = 
            sanitarios.get(indexSanitarioSeleccionado);
                        
        modificarNombreSanitario(sanitarioSeleccionado);
        modificarApellido1Sanitario(sanitarioSeleccionado);
        modificarApellido2Sanitario(sanitarioSeleccionado);
        modificarTelefonoSanitario(sanitarioSeleccionado);
        modificarCorreoSanitario(sanitarioSeleccionado);
        modificarPuestoSanitario(sanitarioSeleccionado);
        modificarContraseñaSanitario(sanitarioSeleccionado);
                
        return sanitarioSeleccionado.toJson();
    }
    
    /**
     * Envía la solicitud para editar un sanitario a la capa control
     * 
     * @param evt 
     */
    private void b_GuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_GuardarCambiosActionPerformed
        try {
            String sanitarioJsonToSend = crearJsonSanitarioEditado();
            
            if (sanitarioJsonToSend != null){
                /* Permite saber si el usuario actual es el que ha solicitado la operación de modificar datos de un sanitario */
                botonGuardarCambiosPulsado = true;
                
                oyenteVista.eventoProducido(OyenteVista.Evento.EDITAR_SANITARIO, sanitarioJsonToSend); 
                
                /* Borra entrada de los campos de la contraseña para la próxima modificación */
                pwd1_input_field.setText("");
                pwd2_input_field.setText("");
                
                /* Deshabilita botones hasta la próxima selección */
                b_GuardarCambios.setEnabled(false);
            } else{
                throw new Exception(ERROR_EDITAR_SANITARIO);
            }   
        } catch (Exception ex) {
            mensajeDialogo(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_b_GuardarCambiosActionPerformed

    /**
     * Obtiene el índice del ítem que se corresponde con el puesto
     * pasado por parámetro si dicho puesto existe, o el valor
     * -1 si dicho puesto no está incluido en los ítems.
     * 
     * @param _puestoActualSanitario
     * @return int
     */
    private int getIndexMatchingItemComboBox(String _puestoActualSanitario){
        for (int i = 0; i < puesto_comboBox.getItemCount(); i++){
            if(puesto_comboBox.getItemAt(i) != null){
                if (puesto_comboBox.getItemAt(i).toString().equalsIgnoreCase(_puestoActualSanitario)){
                    return i;
                }
            }
        }
        return -1;
    }
    
    /**
     * Lee los valores de la tabla del sanitario seleccionado
     * 
     * @param _indexSanitarioSeleccionado 
     */
    private void copiarInformaciónSanitarioEnInputFields(int _indexSanitarioSeleccionado){
        SanitarioDTO sanitarioSeleccionado = sanitarios.get(
            _indexSanitarioSeleccionado);
        int indexPuestoSanitario = getIndexMatchingItemComboBox(
            sanitarioSeleccionado.getPuestoTrabajo());    
        
        nombre_input_field.setText(sanitarioSeleccionado.getNombre());
        apellido1_input_field.setText(sanitarioSeleccionado.getApellido1());
        apellido2_input_field.setText(sanitarioSeleccionado.getApellido2());
        dni_input_field.setText(sanitarioSeleccionado.getDni());
        tlfn_input_field.setText(String.valueOf(sanitarioSeleccionado.getTelefono()));
        correo_input_field.setText(sanitarioSeleccionado.getCorreoElectronico());
        puesto_comboBox.setSelectedIndex(indexPuestoSanitario);  
    }
    
    /**
     * Muestra la información del sanitario seleccionado en la tabla
     * en los campos inferiores para poder editarlos
     * 
     * @param evt 
     */
    private void b_ModificarSanitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ModificarSanitarioActionPerformed
        int indexSanitarioSeleccionado = tabla_con_sanitarios.getSelectedRow();       

        if (indexSanitarioSeleccionado != INDEX_SANITARIO_NO_SELECCIONADO){
            copiarInformaciónSanitarioEnInputFields(indexSanitarioSeleccionado);
        }
        
        /* Deshabilita botones hasta la próxima selección */
        b_EliminarSanitario.setEnabled(false);
        b_ModificarSanitario.setEnabled(false);
    }//GEN-LAST:event_b_ModificarSanitarioActionPerformed

    /**
     * Habilita los botones en el caso en el que se ha seleccionado
     * un sanitario de la tabla
     * 
     * @param evt 
     */
    private void tabla_con_sanitariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_con_sanitariosMouseClicked
        if (tabla_con_sanitarios.getSelectedRow() != INDEX_SANITARIO_NO_SELECCIONADO){
            b_EliminarSanitario.setEnabled(true);
            b_ModificarSanitario.setEnabled(true);
        }
    }//GEN-LAST:event_tabla_con_sanitariosMouseClicked

    /**
     * Habilita el botón de Login si todos los campos de la tabla
     * han sido completados y no poseen solo valores en blanco.
     */
    private void changed(){
        if (nombre_input_field.getText().isBlank() || 
            apellido1_input_field.getText().isBlank() ||
            apellido2_input_field.getText().isBlank() ||
            dni_input_field.getText().isBlank() || 
            tlfn_input_field.getText().isBlank() ||
            correo_input_field.getText().isBlank() ||
            puesto_comboBox.getSelectedItem() == null){
  
            b_GuardarCambios.setEnabled(false);
        } else if( ! String.valueOf(pwd1_input_field.getPassword()).isBlank() && 
                String.valueOf(pwd2_input_field.getPassword()).isBlank()){
            
            b_GuardarCambios.setEnabled(false);
        }
        else {
            b_GuardarCambios.setEnabled(true);
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
     * Captura los eventos relacionados con la modificación del campo "teléfono".
     * 
     * @param evt 
     */
    private void tlfn_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tlfn_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_tlfn_input_fieldKeyTyped
  
    /**
     * Captura los eventos relacionados con la modificación del campo "correo".
     * 
     * @param evt 
     */
    private void correo_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correo_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_correo_input_fieldKeyTyped
     
    /**
     * Captura los eventos relacionados con la modificación del campo "contraseña".
     * 
     * @param evt 
     */
    private void pwd1_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd1_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_pwd1_input_fieldKeyTyped
        
    /**
     * Captura los eventos relacionados con la modificación del campo "Repite Contraseña".
     * 
     * @param evt 
     */
    private void pwd2_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd2_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_pwd2_input_fieldKeyTyped

    /**
     * Captura los eventos relacionados con la modificación del campo "puesto".
     * 
     * @param evt 
     */
    private void puesto_comboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_puesto_comboBoxPopupMenuWillBecomeInvisible
        changed();
    }//GEN-LAST:event_puesto_comboBoxPopupMenuWillBecomeInvisible

    /**
     * Refresca la lista de sanitarios
     * 
     * @param evt 
     */
    private void b_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_RefreshActionPerformed
        this.sanitarios = obtenerListaConSanitarios();
        cargarTablaConSanitarios();
    }//GEN-LAST:event_b_RefreshActionPerformed
    
    /**
     * Obtener el índice del sanitarioDTO seleccionado en la tabla
     * 
     * @param _dniSanitario
     * @return int
     */
    private int obtenerIndexSanitario(String _dniSanitario){
        System.out.println("idSan " + _dniSanitario);
        for(SanitarioDTO sanitario: sanitarios){
            if(sanitario.getDni().equals(_dniSanitario)){
                return sanitarios.indexOf(sanitario);
            }
        }
        return INDEX_SANITARIO_NO_SELECCIONADO;
    }
    
    /**
     * Recibe evento dar baja sanitario
     * 
     * @param evt 
     */
    private void propiedadDarBajaSanitario(PropertyChangeEvent evt){
        String dniSanitario = (String)evt.getNewValue();
        int indexSanitarioSeleccionado = obtenerIndexSanitario(dniSanitario);

        if(botonEliminarPulsado){
            mensajeDialogo(EXITO_DAR_BAJA_SANITARIO + 
                dniSanitario, JOptionPane.INFORMATION_MESSAGE);
        }

        sanitarios.remove(indexSanitarioSeleccionado);
        tableModel.removeRow(indexSanitarioSeleccionado);
    }
    
    /**
     * Recibe evento editar sanitario
     * 
     * @param evt 
     */
    private void propiedadEditarSanitario(PropertyChangeEvent evt){
        String sanitarioJsonToReceive = (String)evt.getNewValue();
        SanitarioDTO sanitarioDTOReceived = gson.fromJson(
            sanitarioJsonToReceive, SanitarioDTO.class);
        int indexSanitarioSeleccionado = obtenerIndexSanitario(sanitarioDTOReceived.getDni());

        if(botonGuardarCambiosPulsado){
            mensajeDialogo(EXITO_EDITAR_SANITARIO + 
                sanitarioDTOReceived.getDni(), JOptionPane.INFORMATION_MESSAGE);
            botonGuardarCambiosPulsado = false;
        }

        /* Muestra los datos modificados en el sanitario de la tabla*/
        for (int i = 0; i < sanitarioDTOReceived.toArray().length; i++){
            tableModel.setValueAt(sanitarioDTOReceived.toArray()[i], 
                    indexSanitarioSeleccionado, i);  
        }
    }
    
    /**
     * Sobreescribe propertyChange para recibir cambios de modelo.
     * 
     * @param evt 
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(
                ProxySanitario.PROPIEDAD_DAR_BAJA_SANITARIO)) {
            
            propiedadDarBajaSanitario(evt);
        } 
        else if (evt.getPropertyName().equals(
                                ProxySanitario.PROPIEDAD_EDITAR_SANITARIO)) {

            propiedadEditarSanitario(evt);
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido1_input_field;
    private javax.swing.JLabel apellido1_label;
    private javax.swing.JTextField apellido2_input_field;
    private javax.swing.JLabel apellido2_label;
    private javax.swing.JButton b_Atrás;
    private javax.swing.JButton b_EliminarSanitario;
    private javax.swing.JButton b_GuardarCambios;
    private javax.swing.JButton b_ModificarSanitario;
    private javax.swing.JButton b_Refresh;
    private javax.swing.JButton b_connecter;
    private javax.swing.JTextField correo_input_field;
    private javax.swing.JLabel correo_label;
    private javax.swing.JTextField dni_input_field;
    private javax.swing.JLabel dni_label;
    private javax.swing.JLabel editarSanitario_label;
    private javax.swing.JLabel hospital_icon;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lista_de_sanitarios_label;
    private javax.swing.JTextField nombre_input_field;
    private javax.swing.JLabel nombre_label;
    private javax.swing.JLabel nueva_contraseña_label;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JPanel paner_superior;
    private javax.swing.JComboBox<String> puesto_comboBox;
    private javax.swing.JLabel puesto_label;
    private javax.swing.JPasswordField pwd1_input_field;
    private javax.swing.JPasswordField pwd2_input_field;
    private javax.swing.JLabel repita_contraseña_label;
    private javax.swing.JLabel sanitario_seleccionado_label;
    private javax.swing.JTable tabla_con_sanitarios;
    private javax.swing.JTextField tlfn_input_field;
    private javax.swing.JLabel tlfn_label;
    // End of variables declaration//GEN-END:variables
}
