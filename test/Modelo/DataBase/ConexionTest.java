/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DataBase;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John
 */
public class ConexionTest {

    public ConexionTest() {
    }

    /**
     * Test of establecerConexion method, of class Conexion.
     */
    @Test
    public void testEstablecerConexionCP002() {
        System.out.println("testEstablecerConexion");
        String user = "john";
        String password = "1234";
        Conexion.iniciarDatos(user, password);
        Connection result = Conexion.establecerConexion();
        Connection expResult = Conexion.validarConexion(result);
        assertEquals(expResult, result);
    }
}
