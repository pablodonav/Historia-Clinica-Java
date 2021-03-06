/**
 * EpisodiosPacienteVista.java
 * Adnana Catrinel Dragut
 * v2.0 29/04/2022.
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
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.clasesDTOs.EpisodioDeAtencionDTO;
import modelo.clasesDTOs.PacienteDTO;
import modelo.clasesDTOs.Tupla;
import modelo.clasesProxys.Comms;
import modelo.clasesProxys.ProxyEpisodio;
import modelo.clasesProxys.ProxyPaciente;

/**
 * Clase que contiene los métodos para crear y gestionar 
 * los componentes y los eventos de la pantalla EpisodiosPacienteVista.
 * 
 */
public class EpisodiosPacienteVista extends javax.swing.JFrame implements PropertyChangeListener{
    private MenuGestionPacientesVista menuGestionPacientesVista = null;
    private Comms comms = null;
    private Gson gson = null;
    private OyenteVista oyenteVista = null;
    private String idConexion = null;
    private ProxyPaciente pxPaciente = null;
    private PacienteDTO pacienteSeleccionado = null;
    private List<EpisodioDeAtencionDTO> episodios = null;
    private DefaultTableModel tableModel = null;
    private boolean botonGuardarCambiosPulsado = false;
    
    private static final int INDEX_EPISODIO_NO_SELECCIONADO = -1;
    private static final int INDEX_COLUMNA_TABLA_DIAGNOSTICO = 3;
    
    /* Mensajes de Error */
    private final String ERROR_OBTENER_EPISODIOS = 
            "No se ha podido obtener la lista con episodios.";
    public final static String ERROR_EDITAR_EPISODIO = 
            "No se ha podido realizar la operación para añadir un diagnóstico al episodio.\n" + 
            "Vuelva a introducir los datos del diagnóstico.";
    
    /* Mensajes de Éxito */
    public final static String EXITO_EDITAR_EPISODIO = 
            "Se ha añadido un diagnóstico al episodio con id: ";
    
    /**
     * Crea e inicializa los componentes de EpisodiosPacienteVista.
     * 
     * @param _menuGestionPacientesVista
     * @param _oyenteVista
     * @param _comms
     * @param _idConexion
     * @param _paciente
     */
    public EpisodiosPacienteVista(MenuGestionPacientesVista _menuGestionPacientesVista, 
            OyenteVista _oyenteVista, Comms _comms, String _idConexion, PacienteDTO _paciente) {
        this.menuGestionPacientesVista  = _menuGestionPacientesVista;
        this.comms = _comms;
        this.gson = new Gson();
        this.oyenteVista = _oyenteVista;
        this.idConexion = _idConexion;
        this.pxPaciente = ProxyPaciente.getInstance();
        this.pacienteSeleccionado = _paciente;
        this.episodios = obtenerListaConEpisodios();
        comms.nuevoObservador(this);
       
        initComponents();
        setResizable(false);  //Deshabilita la opción de maximizar-minimizar 
        pack();   // ajusta ventana y sus componentes
        setLocationRelativeTo(null);  // centra en la pantalla
        habilitarBotonConectado(idConexion);
        copiarInformaciónPacienteEnInputFields();
        cargarTablaConEpisodios();
        
        /* Subraya el texto "Datos Paciente" */
        datos_paciente_label.setText("<HTML><U>Datos Paciente</U></HTML>");
        panelPrincipal.setLayout(null);
        datos_paciente_label.setLocation(300, 100);
        
        /* Subraya el texto "Lista de Episodios" */
        lista_de_episodios_label.setText("<HTML><U>Lista Episodios</U></HTML>");
        lista_de_episodios_label.setLocation(300, 175);
        
        /* Subraya el texto "Episodio Seleccionado" */
        episodio_seleccionado_label.setText("<HTML><U>Episodio Seleccionado</U></HTML>");
        episodio_seleccionado_label.setLocation(12, 360);
                
        b_AnyadirDiagnostico.setEnabled(false);
        b_GuardarCambios.setEnabled(false);
    }
    
    /**
     * Crea un EpisodioPacienteVista vacío para realizar los tests con JUnit.
     * 
     */
    public EpisodiosPacienteVista(){
        
    }

    /**
     * Asigna una tabla con episodios para realizar tests con JUnit.
     * 
     * @param tabla_con_episodios 
     */
    public void setTabla_con_episodios(JTable tabla_con_episodios) {
        this.tabla_con_episodios = tabla_con_episodios;
    }

    /**
     * Asigna una lista con episodios para realizar tests con JUnit.
     * 
     * @param episodios 
     */
    public void setEpisodios(List<EpisodioDeAtencionDTO> episodios) {
        this.episodios = episodios;
    }

    /**
     * Asigna el campo diagnostico para realizar tests con JUnit.
     * 
     * @param diagnostico_input_field 
     */
    public void setDiagnostico_input_field(JTextField diagnostico_input_field) {
        this.diagnostico_input_field = diagnostico_input_field;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        paner_superior = new javax.swing.JPanel();
        episodiosPaciente_label = new javax.swing.JLabel();
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
        lista_de_episodios_label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_con_episodios = new javax.swing.JTable();
        b_Atrás = new javax.swing.JButton();
        b_AnyadirDiagnostico = new javax.swing.JButton();
        episodio_seleccionado_label = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        id_input_field = new javax.swing.JTextField();
        fecha_label = new javax.swing.JLabel();
        fecha_input_field = new javax.swing.JTextField();
        motivo_label = new javax.swing.JLabel();
        motivo_input_field = new javax.swing.JTextField();
        diagnostico_label = new javax.swing.JLabel();
        diagnostico_input_field = new javax.swing.JTextField();
        b_GuardarCambios = new javax.swing.JButton();
        b_Refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        paner_superior.setBackground(new java.awt.Color(0, 153, 153));
        paner_superior.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        episodiosPaciente_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        episodiosPaciente_label.setText("Episodios Paciente");

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
                        .addGap(93, 93, 93)
                        .addComponent(episodiosPaciente_label)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        paner_superiorLayout.setVerticalGroup(
            paner_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hospital_icon, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
            .addGroup(paner_superiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(episodiosPaciente_label)
                .addGap(16, 16, 16)
                .addComponent(b_connected))
        );

        datos_paciente_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        datos_paciente_label.setForeground(new java.awt.Color(0, 153, 153));
        datos_paciente_label.setText("Datos Paciente ");
        datos_paciente_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        lista_de_episodios_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        lista_de_episodios_label.setForeground(new java.awt.Color(0, 153, 153));
        lista_de_episodios_label.setText("Lista de Episodios");
        lista_de_episodios_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabla_con_episodios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Fecha", "Motivo/s", "Diagnóstico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_con_episodios.setFocusable(false);
        tabla_con_episodios.setGridColor(new java.awt.Color(0, 153, 153));
        tabla_con_episodios.setRowHeight(20);
        tabla_con_episodios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla_con_episodios.setShowGrid(true);
        tabla_con_episodios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_con_episodiosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_con_episodios);

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

        b_AnyadirDiagnostico.setBackground(new java.awt.Color(204, 204, 204));
        b_AnyadirDiagnostico.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        b_AnyadirDiagnostico.setForeground(new java.awt.Color(0, 153, 153));
        b_AnyadirDiagnostico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/edit-icon.png"))); // NOI18N
        b_AnyadirDiagnostico.setText("Añadir diagnóstico");
        b_AnyadirDiagnostico.setActionCommand("   Nuevo Sanitario");
        b_AnyadirDiagnostico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_AnyadirDiagnostico.setEnabled(false);
        b_AnyadirDiagnostico.setFocusable(false);
        b_AnyadirDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_AnyadirDiagnosticoActionPerformed(evt);
            }
        });

        episodio_seleccionado_label.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        episodio_seleccionado_label.setForeground(new java.awt.Color(0, 153, 153));
        episodio_seleccionado_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        episodio_seleccionado_label.setText("Episodio Seleccionado ");
        episodio_seleccionado_label.setToolTipText("");
        episodio_seleccionado_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        id_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        id_label.setText("Id");

        id_input_field.setEditable(false);

        fecha_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        fecha_label.setText("Fecha");

        fecha_input_field.setEditable(false);

        motivo_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        motivo_label.setText("Motivo/s");

        motivo_input_field.setEditable(false);

        diagnostico_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        diagnostico_label.setText("Diagnóstico");

        diagnostico_input_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                diagnostico_input_fieldKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paner_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(episodio_seleccionado_label)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(id_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fecha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fecha_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(motivo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(324, 348, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(diagnostico_label, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(b_AnyadirDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(diagnostico_input_field)
                            .addComponent(motivo_input_field)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                .addComponent(b_Atrás, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(414, 414, 414)
                                .addComponent(b_GuardarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                .addComponent(b_Refresh)
                                .addGap(229, 229, 229)
                                .addComponent(datos_paciente_label)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
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
                                .addComponent(edad_input_field)))
                        .addContainerGap())))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(lista_de_episodios_label)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(paner_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datos_paciente_label, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_label)
                    .addComponent(apellido1_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido1_label)
                    .addComponent(nss_label)
                    .addComponent(nss_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edad_label)
                    .addComponent(nombre_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edad_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lista_de_episodios_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_AnyadirDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(episodio_seleccionado_label)
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_label)
                    .addComponent(id_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha_label)
                    .addComponent(fecha_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(motivo_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motivo_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(diagnostico_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(diagnostico_input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_Atrás, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_GuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Obtiene la lista con los episodios de un paciente
     * 
     * @return List<EpisodioDeAtencionDTO>
     * @throws Exception 
     */
    private List<EpisodioDeAtencionDTO> obtenerListaConEpisodios(){
        Gson gson = new Gson();
        List<EpisodioDeAtencionDTO> episodios = null;
        String episodiosToReceive;
        
        try {
            episodiosToReceive = pxPaciente.obtenerEpisodiosPaciente(pacienteSeleccionado.getNss());
            
            if(episodiosToReceive != null){
                /* Permite obtener los episodios en un List con EpisodioDeAtencionDTO */
                java.lang.reflect.Type listType = new TypeToken<List<EpisodioDeAtencionDTO>>(){}.getType(); 
                episodios = gson.fromJson(episodiosToReceive, listType);
            } else{
                throw new Exception(ERROR_OBTENER_EPISODIOS);
            }
        } catch (Exception ex) {
            mensajeDialogo(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
        return episodios;
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
     * Rellena la tabla con la información de los episodios del
     * paciente seleccionado.
     * 
     */
    private void cargarTablaConEpisodios(){
        tableModel = (DefaultTableModel) tabla_con_episodios.getModel();
        tableModel.getDataVector().removeAllElements();

        for (int i = 0; i < episodios.size(); i++){
            EpisodioDeAtencionDTO episodio = episodios.get(i);
            tableModel.addRow(episodio.toArray());
        }
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
     * Habilita el botón "añadir diagnóstico" en el caso en el que se ha seleccionado
     * un episodio de la tabla
     * 
     * @param evt 
     */
    private void tabla_con_episodiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_con_episodiosMouseClicked
        if (tabla_con_episodios.getSelectedRow() != INDEX_EPISODIO_NO_SELECCIONADO){
            b_AnyadirDiagnostico.setEnabled(true);
        }
    }//GEN-LAST:event_tabla_con_episodiosMouseClicked

    /**
     * Habilita el botón de Guardar cambios si el campo diagnóstico
     * ha sido modificado y no posee solo valores en blanco.
     */
    private void changed(){
        if (diagnostico_input_field.getText().isBlank() ||
               ! diagnostico_input_field.isEditable()){
            b_GuardarCambios.setEnabled(false);
        } 
        else {
            b_GuardarCambios.setEnabled(true);
        }
    }
    
    /**
     * Captura los eventos relacionados con la modificación del campo "diagnostico".
     * 
     * @param evt 
     */
    private void diagnostico_input_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diagnostico_input_fieldKeyTyped
        changed();
    }//GEN-LAST:event_diagnostico_input_fieldKeyTyped

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
     * Lee los valores de la tabla del episodio seleccionado
     * 
     * @param _indexEpisodioSeleccionado 
     */
    private void copiarInformaciónEpisodioEnInputFields(int _indexEpisodioSeleccionado){
        EpisodioDeAtencionDTO episodioSeleccionado = episodios.get(
            _indexEpisodioSeleccionado);
           
        id_input_field.setText(String.valueOf(episodioSeleccionado.getId()));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String strFecha= formatter.format(episodioSeleccionado.getFecha()); 
        fecha_input_field.setText(strFecha);
        motivo_input_field.setText(episodioSeleccionado.getMotivo());
        diagnostico_input_field.setText(episodioSeleccionado.getDiagnostico());
        
        /* Impide modificar el campo diagnóstico si el episodio está cerrado (ya tiene un diagnóstico) */
        if( ! episodioSeleccionado.getDiagnostico().isBlank()){
            diagnostico_input_field.setEditable(false);
        }
    }
    
    /**
     * Muestra la información del episodio seleccionado en la tabla
     * en los campos inferiores para poder editarlos
     * 
     * @param evt 
     */
    private void b_AnyadirDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_AnyadirDiagnosticoActionPerformed
        int indexEpisodioSeleccionado = tabla_con_episodios.getSelectedRow();       

        /* Habilita input para introducir un diagnóstico antes de copiar valores de la tabla */
        diagnostico_input_field.setEditable(true);
        
        if (indexEpisodioSeleccionado != INDEX_EPISODIO_NO_SELECCIONADO){
            copiarInformaciónEpisodioEnInputFields(indexEpisodioSeleccionado);
        }
        
        /* Deshabilita botón hasta la próxima selección */
        b_AnyadirDiagnostico.setEnabled(false);
    }//GEN-LAST:event_b_AnyadirDiagnosticoActionPerformed

    /**
     * Captura la información del diagnóstico añadido por el usuario y
     * crea el json del episodio con dicha información.
     * 
     * @return String
     * @throws Exception
     */
    public String crearJsonEpisodioEditado() throws Exception{ 
        int indexEpisodioSeleccionado = tabla_con_episodios.getSelectedRow();
        
        EpisodioDeAtencionDTO episodioSeleccionado = 
            episodios.get(indexEpisodioSeleccionado);
                        
        episodioSeleccionado.setDiagnostico(diagnostico_input_field.getText());
                
        return episodioSeleccionado.toJson();
    }
    
    /**
     * Envía la solicitud para añadir un diagnóstico al episodio de un paciente
     * 
     * @param evt 
     */
    private void b_GuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_GuardarCambiosActionPerformed
        try {
            String episodioJsonToSend  = crearJsonEpisodioEditado();
            
            if (episodioJsonToSend != null){
                /* Permite saber si el usuario actual es el que ha solicitado la operación de editar el episodio de un paciente */
                botonGuardarCambiosPulsado = true;
                
                oyenteVista.eventoProducido(OyenteVista.Evento.NUEVO_DIAGNOSTICO, 
                    new Tupla <String, String>(episodioJsonToSend, pacienteSeleccionado.getNss()));
                
                /* Deshabilita botón hasta la próxima selección */
                b_GuardarCambios.setEnabled(false);
            } else{
                throw new Exception(ERROR_EDITAR_EPISODIO);
            }
        } catch (Exception ex) {
            mensajeDialogo(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_b_GuardarCambiosActionPerformed

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
     * Refresca la lista de episodios
     * 
     * @param evt 
     */
    private void b_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_RefreshActionPerformed
        this.episodios = obtenerListaConEpisodios();
        cargarTablaConEpisodios();
    }//GEN-LAST:event_b_RefreshActionPerformed

    /**
     * Obtener el índice del episodioDeAtencionDTO seleccionado en la tabla
     * 
     * @param _idEpisodioPaciente
     * @return int
     */
    public int obtenerIndexEpisodioPaciente(int _idEpisodioPaciente){
        System.out.println("idEp " + _idEpisodioPaciente);
        for(EpisodioDeAtencionDTO episodio: episodios){
            if(episodio.getId() == _idEpisodioPaciente){
                return episodios.indexOf(episodio);
            }
        }
        return INDEX_EPISODIO_NO_SELECCIONADO;
    }
    
    /**
     * Recibe evento añadir nuevo diagnóstico
     * 
     * @param evt 
     */
    private void propiedadNuevoDiagnostico(PropertyChangeEvent evt){
        String episodioConDiagnosticoJsonToReceive = (String)evt.getNewValue();
        EpisodioDeAtencionDTO episodioDTOReceived = gson.fromJson(episodioConDiagnosticoJsonToReceive, EpisodioDeAtencionDTO.class);
        int indexEpisodioSeleccionado = obtenerIndexEpisodioPaciente(episodioDTOReceived.getId());
        
        if(botonGuardarCambiosPulsado){
            mensajeDialogo(EXITO_EDITAR_EPISODIO + episodioDTOReceived.getId(), 
                JOptionPane.INFORMATION_MESSAGE);
            botonGuardarCambiosPulsado = false;
        }
       
        /* Muestra los datos modificados en el episodio de la tabla*/
        tableModel.setValueAt(episodioDTOReceived.getDiagnostico(), indexEpisodioSeleccionado, INDEX_COLUMNA_TABLA_DIAGNOSTICO);  
        diagnostico_input_field.setEditable(false);
    }
    
    /**
     * Sobreescribe propertyChange para recibir cambios de modelo.
     * 
     * @param evt 
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(
            ProxyEpisodio.PROPIEDAD_NUEVO_DIAGNOSTICO)) {
            
            propiedadNuevoDiagnostico(evt);
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido1_input_field;
    private javax.swing.JLabel apellido1_label;
    private javax.swing.JButton b_AnyadirDiagnostico;
    private javax.swing.JButton b_Atrás;
    private javax.swing.JButton b_GuardarCambios;
    private javax.swing.JButton b_Refresh;
    private javax.swing.JButton b_connected;
    private javax.swing.JLabel datos_paciente_label;
    private javax.swing.JTextField diagnostico_input_field;
    private javax.swing.JLabel diagnostico_label;
    private javax.swing.JTextField edad_input_field;
    private javax.swing.JLabel edad_label;
    private javax.swing.JLabel episodio_seleccionado_label;
    private javax.swing.JLabel episodiosPaciente_label;
    private javax.swing.JTextField fecha_input_field;
    private javax.swing.JLabel fecha_label;
    private javax.swing.JLabel hospital_icon;
    private javax.swing.JTextField id_input_field;
    private javax.swing.JLabel id_label;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lista_de_episodios_label;
    private javax.swing.JTextField motivo_input_field;
    private javax.swing.JLabel motivo_label;
    private javax.swing.JTextField nombre_input_field;
    private javax.swing.JLabel nombre_label;
    private javax.swing.JTextField nss_input_field;
    private javax.swing.JLabel nss_label;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel paner_superior;
    private javax.swing.JTable tabla_con_episodios;
    // End of variables declaration//GEN-END:variables
}
