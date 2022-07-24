/*
 * Equipo
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */


package Modelo.Simples;

/**
 * 
 * @author Eileen, Darwin Rodriguez, Anthony Lozano
 */
public class Equipo {

    private String nombreEquipo;
    private String paisOrigen;

    /**
     * Constructor con Parámetros
     *
     * @param nombreEquipo Nombre del Equipo
     * @param paisOrigen País de Origen del Equipo
     */
    public Equipo(String nombreEquipo, String paisOrigen) {
        this.nombreEquipo = nombreEquipo;
        this.paisOrigen = paisOrigen;
    }

    /**
     * Constructor sin Parámetros
     */
    public Equipo() {
    }

    /* Implementaci�n de m�todos getters y setters */
    
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

}
