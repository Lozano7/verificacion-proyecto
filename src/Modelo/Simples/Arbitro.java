/*
 * Arbitro
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
public class Arbitro extends Persona {

    private int partidosArbitrados;

    /**
     * Constructor parametrizado
     * 
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param edad
     * @param direccion
     * @param email
     * @param partidosArbitrados
     */
    public Arbitro(String cedula, String nombres, String apellidos, 
    		int edad, String direccion, String email,
            int partidosArbitrados) {
        this.partidosArbitrados = partidosArbitrados;
    }

    /**
     * Constructor sin par�metros
     */
    public Arbitro() {

    }

    /* Implementaci�n de m�todos getters y setters */
    
    /**
     *
     * @return partidosArbitrados
     */
    public int getPartidosArbitrados() {
        return partidosArbitrados;
    }

    /**
     *
     * @param partidosArbitrados
     */
    public void setPartidosArbitrados(int partidosArbitrados) {
        this.partidosArbitrados = partidosArbitrados;
    }

}
