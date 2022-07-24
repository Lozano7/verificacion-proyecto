
/*
 * Contrato
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */


package Modelo.Compuestas;

import Modelo.Simples.Equipo;
import Modelo.Simples.Estado;
import java.util.Date;

/**
 * @author Eileen, Darwin Rodriguez, Anthony Lozano
 */
public class Contrato {

    private String codigoContrato;
    private Date fechaInicio;
    private Date fechaFin;
    private Estado estado;
    private Equipo equipo;
    private DirectorTecnico directorTecnico;

    /**
     * Constructor por Defecto
     */
    public Contrato() {
    }

    /**
     * Constructor con Parámetros
     *
     * @param codigoContrato Código para el Contrato
     * @param fechaInicio Inicio del Contrato
     * @param fechaFin Fin del Contrato
     * @param estadoContrato Estado del Contrato
     * @param equipoAsociado Equipo asociado al Contrato
     * @param directorTecnico Director Técnico asociado al Contrato
     */
    public Contrato(String codigoContrato, Date fechaInicio, 
    		Date fechaFin, Estado estadoContrato, Equipo equipoAsociado,
            DirectorTecnico directorTecnico) {
    	
        this.codigoContrato = codigoContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estadoContrato;
        this.equipo = equipoAsociado;
        this.directorTecnico = directorTecnico;
    }

    /* Implementaci�n de m�todos getters y setters */
    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public DirectorTecnico getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(DirectorTecnico directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

}
