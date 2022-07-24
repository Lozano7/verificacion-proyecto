/*
 * Persona
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */

package Modelo.Compuestas;

/**
 *
 * @author John
 */
public class Persona {

    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected int edad;
    protected String direccion;
    protected String email;

    /**
     * Constructor Sin Parametros
     */
    public Persona() {
    }

    //Constructor Parametrizado

    /**
     * Constructor Parametrizado
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param edad
     * @param direccion
     * @param email
     */
    public Persona(String cedula, String nombres, String apellidos, 
    		int edad, String direccion, String email) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.email = email;
    }

    /* Implementaci�n de m�todos getters y setters */
    
    /**
     *
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     *
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     *
     * @return nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     *
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    /**
     *
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     *
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
