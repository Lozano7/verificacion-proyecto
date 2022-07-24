/*
 * DirectorTecnico
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */

package Modelo.Compuestas;

/**
 * @author Eileen, Darwin Rodriguez, Anthony Lozano
 */
public class DirectorTecnico {

    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected int edad;
    protected String email;
    protected int equiposDirigidos;

    /**
     * Constructor por Defecto
     */
    public DirectorTecnico() {
    }

    /**
     * Constructor con Parámetros
     *
     * @param cedula Cédula del Director Técnico
     * @param nombres Nombres del Director Técnico
     * @param apellidos Apellidos del Director Técnico
     * @param edad Edad del Director Técnico
     * @param email Email del Director Técnico
     * @param equiposDirigidos Experiencia con Administración de Equipos
     */
    public DirectorTecnico(String cedula, String nombres, 
    		String apellidos, int edad, String email, 
    		int equiposDirigidos) {
    	
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.equiposDirigidos = equiposDirigidos;
    }

    /* Implementaci�n de m�todos getters y setters */
    public DirectorTecnico(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEquiposDirigidos() {
        return equiposDirigidos;
    }

    public void setEquiposDirigidos(int equiposDirigidos) {
        this.equiposDirigidos = equiposDirigidos;
    }

}
