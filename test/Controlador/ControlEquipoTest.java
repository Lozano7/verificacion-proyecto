/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DataBase.Conexion;
import javax.swing.JTable;
import org.junit.Test;
/**
 *
 * @author John
 */
public class ControlEquipoTest {

    public ControlEquipoTest() {
    }

    public void inicioTest() {
        String user = "john";
        String password = "12345";
        Conexion.iniciarDatos(user, password);
    }

    /**
     *
     */
    @Test
    public void testRegistrarEquipoCP001() {
        System.out.println("registrarEquipo");
        inicioTest();
        ControlEquipo instance = new ControlEquipo("Guayaquil-FC", "Ecuador");
        instance.insertarEquipo();
    }

    /**
     *
     */
    @Test
    public void testEliminarEquipoCP003() {
        System.out.println("eliminarEquipo");
        inicioTest();
        String nombreBuscado = "Guayaquil-FC";
        ControlEquipo instance = new ControlEquipo();
        instance.eliminarEquipo(nombreBuscado);
    }

    /**
     *
     */
    @Test
    public void testBuscarEquipoCP004() {
        System.out.println("buscarEquipo");
        inicioTest();
        JTable tablaEquipo = new JTable();
        String nombreBuscado = "Guayaquil-FC";
        ControlEquipo instance = new ControlEquipo();
        instance.consultarEquipo(tablaEquipo, nombreBuscado);
    }

    /**
     *
     */
    @Test
    public void testActualizarEquipoCP005() {
        System.out.println("actualizarEquipo");
        inicioTest();
        String nombreBuscado = "Guayaquil-FC";
        ControlEquipo instance = new ControlEquipo();
        instance.actualizarEquipo(nombreBuscado);
    }
}
