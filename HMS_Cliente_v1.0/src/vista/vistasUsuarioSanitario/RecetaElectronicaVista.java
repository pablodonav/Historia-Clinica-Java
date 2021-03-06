/**
 * RecetaElectrónicaVista.java
 * Adnana Catrinel Dragut
 * v2.0 07/05/2022.
 * 
 */
package vista.vistasUsuarioSanitario;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import control.Hospital;
import control.OyenteVista;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.clasesDTOs.MedicamentoDTO;
import modelo.clasesDTOs.MedicamentoPacienteDTO;
import modelo.clasesDTOs.PacienteDTO;
import modelo.clasesDTOs.Tupla;
import modelo.clasesProxys.Comms;
import modelo.clasesProxys.ProxyMedicamento;
import modelo.clasesProxys.ProxyPaciente;

/**
 * Clase que contiene los métodos para crear y gestionar 
 * los componentes y los eventos de la pantalla RecetaElectrónicaVista.
 * 
 */
public class RecetaElectronicaVista extends javax.swing.JFrame implements PropertyChangeListener{
    private MenuGestionPacientesVista menuGestionPacientesVista = null;
    private Comms comms = null;
    private Gson gson = null;
    private OyenteVista oyenteVista = null;
    private String idConexion = null;
    private ProxyPaciente pxPaciente = null;
    private ProxyMedicamento pxMedicamento = null;
    private PacienteDTO pacienteSeleccionado = null;
    private List<MedicamentoPacienteDTO> medicamentosPaciente = null;
    private List<MedicamentoDTO> medicamentosDisponibles = null;
    private DefaultTableModel tableModel = null;
    private boolean botonAnyadirPulsado = false;
    private boolean botonEliminarPulsado = false;
    
    private final int INDEX_MEDICAMENTO_NO_SELECCIONADO = -1;
    private final int INDEX_COMBO_BOX_CODIGO_MEDICAMENTO = 0;
    private final int INDEX_COMBO_BOX_NOMBRE_MEDICAMENTO = 1;
    
    /* Mensajes de Error */
    private final String ERROR_OBTENER_MEDICAMENTOS = 
            "No se ha podido obtener la lista con medicamentos.";
    public final static String ERROR_NUEVO_MEDICAMENTO = 
            "No se ha podido realizar la operación para añadir un nuevo medicamento al paciente.\n" + 
            "Vuelva a introducir los datos del nuevo medicamento.";
    public final static String ERROR_ELIMINAR_MEDICAMENTO = 
            "No se ha podido realizar la operación para eliminar un medicamento del paciente.";
    public final static String ERROR_FECHAS_NUEVO_MEDICAMENTO = 
            "No se ha podido realizar la operación, la fecha de fin debe ser posterior a la fecha de inicio.\n" +
            "Vuelva a introducir los datos del nuevo medicamento.";
    
    /* Mensajes de Éxito */
    public final static String EXITO_NUEVO_MEDICAMENTO = 
            "Se ha añadido un nuevo medicamento con código: ";
    public final static String EXITO_ELIMINAR_MEDICAMENTO = 
            "Se ha eliminado el medicamento con código: ";
    
    /**
     * Crea e inicializa los componentes de RecetaElectronicaVista.
     * 
     * @param _menuGestionPacientesVista
     * @param _oyenteVista
     * @param _comms
     * @param _idConexion
     * @param _paciente 
     */
    public RecetaElectronicaVista(MenuGestionPacientesVista _menuGestionPacientesVista, 
            OyenteVista _oyenteVista, Comms _comms, String _idConexion, PacienteDTO _paciente) {
        
        this.menuGestionPacientesVista  = _menuGestionPacientesVista;
        this.comms = _comms;
        this.gson = new Gson();
        this.oyenteVista = _oyenteVista;
        this.idConexion = _idConexion;
        this.pxPaciente = ProxyPaciente.getInstance();
        this.pxMedicamento = ProxyMedicamento.getInstance();
        this.pacienteSeleccionado = _paciente;
        this.medicamentosPaciente = obtenerListaConMedicamentosPaciente();
        this.medicamentosDisponibles = obtenerListaConMedicamentosDisponibles();
        comms.nuevoObservador(this);
       
        initComponents();
        setResizable(false);  //Deshabilita la opción de maximizar-minimizar 
        pack();   // ajusta ventana y sus componentes
        setLocationRelativeTo(null);  // centra en la pantalla
        habilitarBotonConectado(idConexion);
        copiarInformaciónPacienteEnInputFields();
        cargarTablaConMedicamentos();
        cargarMedicamentosEnComboBox();
        
        /* Subraya el texto "Datos Paciente" */
        datos_paciente_label.setText("<HTML><U>Datos Paciente</U></HTML>");
        panel_principal.setLayout(null);
        datos_paciente_label.setLocation(320, 100);
        
        /* Subraya el texto "Nuevo Medicamento" */
        nuevo_medicamento_label.setText("<HTML><U>Nuevo Medicamento</U></HTML>");
        panel_principal.setLayout(null);
        nuevo_medicamento_label.setLocation(12, 170);
        
        /* Subraya el texto "Lista De Medicamentos" */
        lista_de_medicamentos_label.setText("<HTML><U>Lista Medicamentos</U></HTML>");
        panel_principal.setLayout(null);
        lista_de_medicamentos_label.setLocation(12, 280);
        
        b_AnyadirMedicamento.setEnabled(false);
        b_EliminarMedicamento.setEnabled(false);
    }
    
    public RecetaElectronicaVista(){
        
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
        registroVacunacion_label = new javax.swing.JLabel();
        hospital_icon = new javax.swing.JLabel();
        b_connected = new javax.swing.JButton();
        datos_paciente_label = new javax.swing.JLabel();
        nombre_label = new javax.swing.JLabel();
        nombre_input_field = new javax.swing.JTextField();
        apellido1_label = new javax.swing.JLabel();
        apellido1_input_field = new javax.swing.JTextField();
        nss_label = new javax.swing.JLabel();
        nss_input_field = new javax.swing.JTextField();
        edad_label = new javax.swing.JLabel();
        edad_input_field = new javax.swing.JTextField();
        nuevo_medicamento_label = new javax.swing.JLabel();
        medicamento_label = new javax.swing.JLabel();
        asterisco_label_medicamento = new javax.swing.JLabel();
        medicamento_comboBox = new javax.swing.JComboBox<>();
        fecha_inicio_label = new javax.swing.JLabel();
        asterisco_label_fecha_inicio = new javax.swing.JLabel();
        fecha_inicio_chooser = new com.toedter.calendar.JDateChooser();
        fecha_fin_label = new javax.swing.JLabel();
        fecha_fin_chooser = new com.toedter.calendar.JDateChooser();
        asterisco_label_fecha_fin = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_con_medicamentos = new javax.swing.JTable();
        lista_de_medicamentos_label = new javax.swing.JLabel();
        b_AnyadirMedicamento = new javax.swing.JButton();
        b_EliminarMedicamento = new javax.swing.JButton();
        b_Atrás = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_principal.setBackground(new java.awt.Color(255, 255, 255));

        paner_superior.setBackground(new java.awt.Color(0, 153, 153));
        paner_superior.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        registroVacunacion_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        registroVacunacion_label.setText("Receta Electrónica");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_connected, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paner_superiorLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(registroVacunacion_label)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        paner_superiorLayout.setVerticalGroup(
            paner_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hospital_icon, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
            .addGroup(paner_superiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registroVacunacion_label)
                .addGap(15, 15, 15)
                .addComponent(b_connected))
        );

        datos_paciente_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        datos_paciente_label.setForeground(new java.awt.Color(0, 153, 153));
        datos_paciente_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datos_paciente_label.setText("Datos Paciente ");
        datos_paciente_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        nombre_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nombre_label.setText("Nombre");

        nombre_input_field.setEditable(false);

        apellido1_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        apellido1_label.setText("Apellido 1");

        apellido1_input_field.setEditable(false);

        nss_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nss_label.setText("NSS");

        nss_input_field.setEditable(false);

        edad_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        edad_label.setText("Edad");

        edad_input_field.setEditable(false);

        nuevo_medicamento_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        nuevo_medicamento_label.setForeground(new java.awt.Color(0, 153, 153));
        nuevo_medicamento_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nuevo_medicamento_label.setText("Nuevo Medicamento");
        nuevo_medicamento_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        medicamento_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        medicamento_label.setText("Medicamento");

        asterisco_label_medicamento.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_medicamento.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_medicamento.setText("*");

        medicamento_comboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                medicamento_comboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        fecha_inicio_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        fecha_inicio_label.setText(" Fecha Inicio");

        asterisco_label_fecha_inicio.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_fecha_inicio.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_fecha_inicio.setText("*");

        fecha_inicio_chooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fecha_inicio_chooserPropertyChange(evt);
            }
        });

        fecha_fin_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        fecha_fin_label.setText(" Fecha Fin");

        fecha_fin_chooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fecha_fin_chooserPropertyChange(evt);
            }
        });

        asterisco_label_fecha_fin.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        asterisco_label_fecha_fin.setForeground(new java.awt.Color(255, 0, 0));
        asterisco_label_fecha_fin.setText("*");

        tabla_con_medicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_con_medicamentos.setFocusable(false);
        tabla_con_medicamentos.setGridColor(new java.awt.Color(0, 153, 153));
        tabla_con_medicamentos.setRowHeight(20);
        tabla_con_medicamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla_con_medicamentos.setShowGrid(true);
        tabla_con_medicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_con_medicamentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_con_medicamentos);

        lista_de_medicamentos_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        lista_de_medicamentos_label.setForeground(new java.awt.Color(0, 153, 153));
        lista_de_medicamentos_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lista_de_medicamentos_label.setText("Lista De Medicamentos");
        lista_de_medicamentos_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b_AnyadirMedicamento.setBackground(new java.awt.Color(204, 204, 204));
        b_AnyadirMedicamento.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_AnyadirMedicamento.setForeground(new java.awt.Color(0, 153, 153));
        b_AnyadirMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/plus_icon.png"))); // NOI18N
        b_AnyadirMedicamento.setText("Añadir Medicamento");
        b_AnyadirMedicamento.setActionCommand("   Nuevo Sanitario");
        b_AnyadirMedicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_AnyadirMedicamento.setEnabled(false);
        b_AnyadirMedicamento.setFocusable(false);
        b_AnyadirMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_AnyadirMedicamentoActionPerformed(evt);
            }
        });

        b_EliminarMedicamento.setBackground(new java.awt.Color(204, 204, 204));
        b_EliminarMedicamento.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_EliminarMedicamento.setForeground(new java.awt.Color(0, 153, 153));
        b_EliminarMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/minus_icon.png"))); // NOI18N
        b_EliminarMedicamento.setText("Eliminar Medicamento");
        b_EliminarMedicamento.setActionCommand("   Nuevo Sanitario");
        b_EliminarMedicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_EliminarMedicamento.setEnabled(false);
        b_EliminarMedicamento.setFocusable(false);
        b_EliminarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_EliminarMedicamentoActionPerformed(evt);
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

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paner_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addComponent(lista_de_medicamentos_label)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_principalLayout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nuevo_medicamento_label)
                                        .addGroup(panel_principalLayout.createSequentialGroup()
                                            .addGap(267, 267, 267)
                                            .addComponent(datos_paciente_label))
                                        .addGroup(panel_principalLayout.createSequentialGroup()
                                            .addComponent(nombre_label)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(nombre_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(apellido1_label)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(apellido1_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(nss_label)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(nss_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(edad_label)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(edad_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(b_AnyadirMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panel_principalLayout.createSequentialGroup()
                                                .addComponent(medicamento_label)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(asterisco_label_medicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(medicamento_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(fecha_inicio_label)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(asterisco_label_fecha_inicio)
                                                .addGap(17, 17, 17)
                                                .addComponent(fecha_inicio_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fecha_fin_label)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(asterisco_label_fecha_fin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fecha_fin_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(b_EliminarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addComponent(b_Atrás, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addComponent(paner_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datos_paciente_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_label)
                    .addComponent(apellido1_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido1_label)
                    .addComponent(nss_label)
                    .addComponent(nss_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edad_label)
                    .addComponent(nombre_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edad_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(nuevo_medicamento_label)
                .addGap(18, 18, 18)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(asterisco_label_medicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicamento_label)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(asterisco_label_fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fecha_fin_label))
                                .addComponent(fecha_inicio_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addComponent(fecha_fin_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fecha_inicio_label)
                                .addComponent(asterisco_label_fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(medicamento_comboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(b_AnyadirMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lista_de_medicamentos_label)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_EliminarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_Atrás, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
     * Obtiene la lista con los medicamentos de un paciente
     * 
     * @return List<MedicamentoPacienteDTO>
     * @throws Exception 
     */
    private List<MedicamentoPacienteDTO> obtenerListaConMedicamentosPaciente(){
        Gson gson = new Gson();
        List<MedicamentoPacienteDTO> medicamentos = null;
        String medicamentosToReceive;
        
        try {
            medicamentosToReceive = pxPaciente.obtenerMedicamentosPaciente(pacienteSeleccionado.getNss());
            System.out.println(medicamentosToReceive);
            if(medicamentosToReceive != null){
                /* Permite obtener los medicamentos en un List con MedicamentoPacienteDTO */
                java.lang.reflect.Type listType = new TypeToken<List<MedicamentoPacienteDTO>>(){}.getType(); 
                medicamentos = gson.fromJson(medicamentosToReceive, listType);
            } else{
                throw new Exception(ERROR_OBTENER_MEDICAMENTOS);
            }
        } catch (Exception ex) {
            mensajeDialogo(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
        return medicamentos;
    }
    
    /**
     * Rellena la tabla con la información de los medicamentos 
     * de la receta electrónica del paciente seleccionado.
     * 
     */
    private void cargarTablaConMedicamentos(){
        tableModel = (DefaultTableModel) tabla_con_medicamentos.getModel();

        for (int i = 0; i < medicamentosPaciente.size(); i++){
            MedicamentoPacienteDTO medicamento = medicamentosPaciente.get(i);
            tableModel.addRow(medicamento.toArray());
        }
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
     * Introduce la información del paciente seleccionado en los input fields
     * del apartado correspondiente a "Datos Paciente".
     * 
     */
    private void copiarInformaciónPacienteEnInputFields(){
        nombre_input_field.setText(pacienteSeleccionado.getNombre());
        apellido1_input_field.setText(pacienteSeleccionado.getApellido1());
        nss_input_field.setText(pacienteSeleccionado.getNss());
        edad_input_field.setText(String.valueOf(pacienteSeleccionado.getEdad()));
    }
    
    /**
     * Obtiene la lista con los medicamentos disponibles en el sistema 
     * 
     * @return List<MedicamentoDTO>
     * @throws Exception 
     */
    private List<MedicamentoDTO> obtenerListaConMedicamentosDisponibles(){
        Gson gson = new Gson();
        List<MedicamentoDTO> medicamentosDisponibles = null;
        String medicamentosToReceive = null;
        
        try {
            medicamentosToReceive = pxMedicamento.obtenerMedicamentosDisponibles();
            
            System.out.println("medicamentos paciente:" + medicamentosToReceive);
            if (medicamentosToReceive != null){
                /* Permite obtener los medicamentos disponibles en un List con MedicamentoDTO*/
                java.lang.reflect.Type listType = new TypeToken<List<MedicamentoDTO>>(){}.getType(); 
                medicamentosDisponibles = gson.fromJson(medicamentosToReceive, listType);
            } else{
                throw new Exception(ERROR_OBTENER_MEDICAMENTOS);
            }
        } catch (Exception ex) {
            mensajeDialogo(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
        return medicamentosDisponibles;
    }
    
    /**
     * Introduce en el comboBox los medicamentos disponibles en el sistema.
     * 
     */
    private void cargarMedicamentosEnComboBox(){
        medicamento_comboBox.setEditable(true);
        for(MedicamentoDTO medicamento: medicamentosDisponibles){
            medicamento_comboBox.addItem(medicamento.getCodigo()+ "-" + medicamento.getNombre());
        }
        medicamento_comboBox.setEditable(false);
        
        /* No muestra ninguna selección en el comboBox sin entrada del usuario */
        medicamento_comboBox.setSelectedIndex(INDEX_MEDICAMENTO_NO_SELECCIONADO);
        medicamento_comboBox.setSelectedItem(null);
    }
    
    /**
     * Habilita el botón Guardar si todos los campos 
     * han sido completados y no poseen solo valores en blanco.
     * 
     */
    private void changed(){  
        if (medicamento_comboBox.getSelectedItem() == null ||
            fecha_fin_chooser.getDate() == null ||
            fecha_inicio_chooser.getDate() == null){
            
            b_AnyadirMedicamento.setEnabled(false);
        }
        else {
            b_AnyadirMedicamento.setEnabled(true);
        }
    }
    
    /**
     * Captura los eventos relacionados con la modificación del campo "medicamento".
     * 
     * @param evt
     */
    private void medicamento_comboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_medicamento_comboBoxPopupMenuWillBecomeInvisible
        changed();
    }//GEN-LAST:event_medicamento_comboBoxPopupMenuWillBecomeInvisible

    /**
     * Captura los eventos relacionados con la modificación del campo "fecha_inicio".
     * 
     * @param evt
     */
    private void fecha_fin_chooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fecha_fin_chooserPropertyChange
        changed();
    }//GEN-LAST:event_fecha_fin_chooserPropertyChange

    /**
     * Captura los eventos relacionados con la modificación del campo "fecha_fin".
     * 
     * @param evt
     */
    private void fecha_inicio_chooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fecha_inicio_chooserPropertyChange
        changed();
    }//GEN-LAST:event_fecha_inicio_chooserPropertyChange

    /**
     * Obtiene el medicamentoDTO del medicamento seleccionado
     * 
     * @param _codigo
     * @param _nombre
     * @return MedicamentoDTO
     */
    private MedicamentoDTO obtenerMedicamentoDeComboBox(String _codigo, String _nombre){
        for(MedicamentoDTO medicamento: medicamentosDisponibles){
            if(medicamento.getCodigo() == Integer.parseInt(_codigo) &&
               medicamento.getNombre().equals(_nombre)){
                
                return medicamento;
            }
        }
        return null;
    }
    
    /**
     * Verificar si la fecha de fin de un medicamento es posterior 
     * a la fecha de inicio
     * 
     * @param _fechaInicio
     * @param _fechaFin
     * @return 
     */
    public boolean fechaFinPosteriorAFechaInicio(Date _fechaInicio, Date _fechaFin){
        if(_fechaInicio.compareTo(_fechaFin) < 0){
            return true;
        }
        return false;
    }
    
    /**
     * Captura la información de los campos rellenados por el usuario y
     * crea el json con un nuevo medicamento
     * 
     * @return String
     */
    private String crearJsonMedicamentoNuevo() throws Exception{
        String medicamentoPacienteJson = null;
        String datosMedicamentoComboBox[] = String.valueOf(medicamento_comboBox.getSelectedItem()).split("-");
        MedicamentoDTO medicamentoAdministrada  = obtenerMedicamentoDeComboBox(datosMedicamentoComboBox[INDEX_COMBO_BOX_CODIGO_MEDICAMENTO], 
                                                                datosMedicamentoComboBox[INDEX_COMBO_BOX_NOMBRE_MEDICAMENTO]);
        Date fechaInicio = fecha_inicio_chooser.getDate();
        Date fechaFin = fecha_fin_chooser.getDate();
        
        if(fechaFinPosteriorAFechaInicio(fechaInicio, fechaFin)){
            MedicamentoPacienteDTO medicamentoPaciente = new MedicamentoPacienteDTO(0, medicamentoAdministrada, fechaInicio, fechaFin);
            medicamentoPacienteJson = medicamentoPaciente.toJson();
        }else{
            throw new Exception(ERROR_FECHAS_NUEVO_MEDICAMENTO);
        }
        return medicamentoPacienteJson;
    }
    
    /**
     * Envía una solicitud a la capa control para añadir un nuevo medicamento a un paciente
     * 
     * @param evt 
     */
    private void b_AnyadirMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_AnyadirMedicamentoActionPerformed
        try {
            String medicamentoJsonToSend = crearJsonMedicamentoNuevo();
            
            if (medicamentoJsonToSend != null){
                /* Permite saber si el usuario actual es el que ha solicitado la operación de añadir un nuevo medicamento */
                botonAnyadirPulsado = true;
                
                oyenteVista.eventoProducido(OyenteVista.Evento.NUEVO_MEDICAMENTO, 
                    new Tupla <String, String>(medicamentoJsonToSend,
                                           pacienteSeleccionado.getNss()));
                
                /* Desactivar botón hasta la próxima selección */
                b_AnyadirMedicamento.setEnabled(false);
            } else{
                throw new Exception(ERROR_NUEVO_MEDICAMENTO);
            }
        } catch (Exception ex) {
            mensajeDialogo(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_b_AnyadirMedicamentoActionPerformed
    
    /**
     * Obtener el id del medicamento seleccionado en la tabla
     * 
     * @param _indexMedicamentoSeleccionado
     * @return String
     */
    private String obtenerIdMedicamentoSeleccionado(int _indexMedicamentoSeleccionado){
        return String.valueOf(medicamentosPaciente.get(_indexMedicamentoSeleccionado).getId());
    }
    
    /**
     * Envía una solicitud a la capa control para eliminar un medicamento de la receta electrónica de un paciente
     * 
     * @param evt 
     */
    private void b_EliminarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_EliminarMedicamentoActionPerformed
        int indexMedicamentoSeleccionado = tabla_con_medicamentos.getSelectedRow();
                
        if (indexMedicamentoSeleccionado != INDEX_MEDICAMENTO_NO_SELECCIONADO){
            /* Permite saber si el usuario actual es el que ha solicitado la operación de eliminar un medicamento */
            botonEliminarPulsado = true;
            
            String idMedicamentoPaciente = obtenerIdMedicamentoSeleccionado(tabla_con_medicamentos.getSelectedRow());
            
            oyenteVista.eventoProducido(OyenteVista.Evento.ELIMINAR_MEDICAMENTO, 
                    new Tupla <String, String>(String.valueOf(idMedicamentoPaciente),
                                           pacienteSeleccionado.getNss()));
        }   
        
        /* Deshabilita botones hasta la próxima selección */
        b_EliminarMedicamento.setEnabled(false);
    }//GEN-LAST:event_b_EliminarMedicamentoActionPerformed

    /**
     * Cierra la ventana actual y regresa a la ventana MenuGestionPacientesVista
     * 
     * @param evt 
     */
    private void b_AtrásActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_AtrásActionPerformed
        comms.eliminarObservador(this);
        this.dispose();
        menuGestionPacientesVista.setVisible(true);
    }//GEN-LAST:event_b_AtrásActionPerformed

    /**
     * Captura el evento relacionado con el cierre de la ventana, y 
     * envía el evento a la capa control para realizar las acciones
     * de finalización necesarias para la appCliente.
     * 
     * @param evt
     */  
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oyenteVista.eventoProducido(OyenteVista.Evento.SALIR, null);
    }//GEN-LAST:event_formWindowClosing

    /**
     * Habilita los botones en el caso en el que se ha seleccionado
     * un medicamento de la tabla
     * 
     * @param evt 
     */
    private void tabla_con_medicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_con_medicamentosMouseClicked
        if (tabla_con_medicamentos.getSelectedRow() != INDEX_MEDICAMENTO_NO_SELECCIONADO){
            b_EliminarMedicamento.setEnabled(true);
        }
    }//GEN-LAST:event_tabla_con_medicamentosMouseClicked

    /**
     * Recibe evento añadir nuevo medicamento
     * 
     * @param _evt 
     */
    private void propiedadNuevoMedicamento(PropertyChangeEvent _evt){
        String medicamentoJsonToReceive = (String)_evt.getNewValue();
        MedicamentoPacienteDTO medicamentoDTOReceived = gson.fromJson(medicamentoJsonToReceive, MedicamentoPacienteDTO.class);
        
        if(botonAnyadirPulsado){
            mensajeDialogo(EXITO_NUEVO_MEDICAMENTO + medicamentoDTOReceived.getMedicamento().getCodigo(),
                JOptionPane.INFORMATION_MESSAGE);
            
            botonAnyadirPulsado = false;
        }
       
        medicamentosPaciente.add(medicamentoDTOReceived);
        tableModel.addRow(medicamentoDTOReceived.toArray());  
        System.out.println("Medicamento index: " + medicamentosPaciente.indexOf(medicamentoDTOReceived));
        System.out.println("Medicamento id: " + medicamentoDTOReceived.getId());
    }  
    
    /**
     * Obtener el índice del medicamentoPacienteDTO seleccionado en la tabla
     * 
     * @param _idMedicamentoPaciente
     * @return int
     */
    private int obtenerIndexMedicamentoPaciente(int _idMedicamentoPaciente){
        System.out.println("idMed " + _idMedicamentoPaciente);
        for(MedicamentoPacienteDTO medicamento: medicamentosPaciente){
            if(medicamento.getId() == _idMedicamentoPaciente){
                return medicamentosPaciente.indexOf(medicamento);
            }
        }
        return INDEX_MEDICAMENTO_NO_SELECCIONADO;
    }
     
    /**
     * Recibe evento eliminar un medicamento de la receta de un paciente
     * 
     * @param _evt 
     */
    private void propiedadEliminarMedicamento(PropertyChangeEvent _evt){
        String idMedicamentoJsonToReceive = (String)_evt.getNewValue();
        int indexMedicamentoSeleccionado = obtenerIndexMedicamentoPaciente(Integer.parseInt(idMedicamentoJsonToReceive));

        String codigoMedicamento = String.valueOf(medicamentosPaciente.get(indexMedicamentoSeleccionado).getMedicamento().getCodigo());

        if (botonEliminarPulsado){
            mensajeDialogo(EXITO_ELIMINAR_MEDICAMENTO + 
                codigoMedicamento, JOptionPane.INFORMATION_MESSAGE);
            
            botonEliminarPulsado = false;
        }
        
        medicamentosPaciente.remove(indexMedicamentoSeleccionado);
        tableModel.removeRow(indexMedicamentoSeleccionado);
    }
    
    /**
     * Sobreescribe propertyChange para recibir cambios de modelo.
     * 
     * @param _evt 
     */
    @Override
    public void propertyChange(PropertyChangeEvent _evt) {
        if (_evt.getPropertyName().equals(
            ProxyMedicamento.PROPIEDAD_NUEVO_MEDICAMENTO)) {
            
            propiedadNuevoMedicamento(_evt);
        } else if (_evt.getPropertyName().equals(
            ProxyMedicamento.PROPIEDAD_ELIMINAR_MEDICAMENTO)) {
            
            propiedadEliminarMedicamento(_evt);
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido1_input_field;
    private javax.swing.JLabel apellido1_label;
    private javax.swing.JLabel asterisco_label_fecha_fin;
    private javax.swing.JLabel asterisco_label_fecha_inicio;
    private javax.swing.JLabel asterisco_label_medicamento;
    private javax.swing.JButton b_AnyadirMedicamento;
    private javax.swing.JButton b_Atrás;
    private javax.swing.JButton b_EliminarMedicamento;
    private javax.swing.JButton b_connected;
    private javax.swing.JLabel datos_paciente_label;
    private javax.swing.JTextField edad_input_field;
    private javax.swing.JLabel edad_label;
    private com.toedter.calendar.JDateChooser fecha_fin_chooser;
    private javax.swing.JLabel fecha_fin_label;
    private com.toedter.calendar.JDateChooser fecha_inicio_chooser;
    private javax.swing.JLabel fecha_inicio_label;
    private javax.swing.JLabel hospital_icon;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lista_de_medicamentos_label;
    private javax.swing.JComboBox<String> medicamento_comboBox;
    private javax.swing.JLabel medicamento_label;
    private javax.swing.JTextField nombre_input_field;
    private javax.swing.JLabel nombre_label;
    private javax.swing.JTextField nss_input_field;
    private javax.swing.JLabel nss_label;
    private javax.swing.JLabel nuevo_medicamento_label;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JPanel paner_superior;
    private javax.swing.JLabel registroVacunacion_label;
    private javax.swing.JTable tabla_con_medicamentos;
    // End of variables declaration//GEN-END:variables
}
