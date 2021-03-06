/**
 * CitaDTO.java
 * Adnana Catrinel Dragut
 * v2.0 29/04/2022.
 * 
 */
package modelo.clasesDTOs;

import com.google.gson.Gson;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene los atributos y getter-setter de una Cita.
 * 
 */
public class CitaPacienteDTO {
    private int identificador;
    private String dniMedico;
    private Ubicacion ubicacion;
    private Date fecha;
    private Date tiempo;
    private String descripcion;

    /**
     * Crea una Cita
     * 
     * @param _identificador
     * @param _dniMedico
     * @param _ubicacion
     * @param _fecha
     * @param _tiempo
     * @param _descripcion 
     */
    public CitaPacienteDTO(int _identificador, String _dniMedico, Ubicacion _ubicacion, Date _fecha, Date _tiempo, String _descripcion) {
        this.identificador = _identificador;
        this.dniMedico = _dniMedico;
        this.ubicacion = _ubicacion;
        this.fecha = _fecha;
        this.tiempo = _tiempo;
        this.descripcion = _descripcion;
    }

    /**
     * Obtiene el identificador de una cita
     * 
     * @return int
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Asigna el identificador de una cita
     * 
     * @param _identificador 
     */
    public void setIdentificador(int _identificador) {
        this.identificador = _identificador;
    }

    /**
     * Obtiene el dni del médico que atiende una cita
     * 
     * @return String
     */
    public String getDniMedico() {
        return dniMedico;
    }

    
    /**
     * Asigna un médico a una cita
     * 
     * @param _dniMedico 
     */
    public void setDniMedico(String _dniMedico) {
        this.dniMedico = _dniMedico;
    }
    
    /**
     * Obtiene la ubicación de una cita
     * 
     * @return Ubicacion
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * Asigna la ubicación de una cita
     * 
     * @param _ubicacion 
     */
    public void setUbicacion(Ubicacion _ubicacion) {
        this.ubicacion = _ubicacion;
    }

    /**
     * Obtiene la fecha de una cita
     * 
     * @return Date
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Asigna la fecha de una cita
     * 
     * @param _fecha 
     */
    public void setFecha(Date _fecha) {
        this.fecha = _fecha;
    }

    /**
     * Obtiene el tiempo de una cita
     * 
     * @return Date
     */
    public Date getTiempo() {
        return tiempo;
    }

    /**
     * Asigna la hora de una cita
     * 
     * @param _tiempo 
     */
    public void setTiempo(Date _tiempo) {
        this.tiempo = _tiempo;
    }

    /**
     * Obtiene la descripción de una cita
     * 
     * @return String
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna la descripción de una cita
     * 
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Obtiene un vector de Object con los atributos de la clase cita
     * 
     * @return Object[]
     */
    public Object[] toArray(){
        List<Object> object = new ArrayList();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String strFecha= formatter.format(fecha); 
        
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm");  
        String strTime= formatterTime.format(tiempo); 
        
        object.add(identificador);
        object.add(ubicacion.getCentroHospitalario());
        object.add(dniMedico);
        object.add(strFecha);
        object.add(strTime);
        object.add(descripcion);
                
        return object.toArray();
    }
    
    /**
     * Obtiene el toString de la cita
     * 
     * @return String
     */
    @Override
    public String toString() {
        return identificador + " " + dniMedico + " " + ubicacion + 
            " " + fecha + " " + tiempo + " " + descripcion;
    }  
    
    /**
     * Obtiene el JSON de la cita
     * 
     * @return String
     */
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
