/*
 * DirectorTecnico
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */


package Modelo.Simples;

import Modelo.Compuestas.Persona;

/**
 *
 * @author John
 */
public class DirectorTecnico extends Persona {

    private int equiposDirigidos;

    /**
     * Constructor Parametrizado
     *
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param edad
     * @param direccion
     * @param email
     * @param equiposDirigidos
     */
    public DirectorTecnico(String cedula, String nombres, 
    		String apellidos, int edad, String direccion, 
    		String email,
            int equiposDirigidos) {
        this.equiposDirigidos = equiposDirigidos;
    }

    /* Implementaci�n de m�todos getters y setters */
    
    /**
     *
     * @return equiposDirigos
     */
    public int getEquiposDirigidos() {
        return equiposDirigidos;
    }

    /**
     *
     * @param equiposDirigidos
     */
    public void setEquiposDirigidos(int equiposDirigidos) {
        this.equiposDirigidos = equiposDirigidos;
    }
}
