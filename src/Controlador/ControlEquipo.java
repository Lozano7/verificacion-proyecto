/*
 * ControlEquipo
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */

package Controlador;

import Modelo.DataBase.Conexion;
import Modelo.Simples.Equipo;
import Modelo.DataBase.EquipoDB;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para preparar los datos del Equipo a la Base de Datos
 *
 * @author Lozano
 */
public class ControlEquipo {

    private Equipo equipo;
    private EquipoDB equipoDB;
    private Conexion conexion;
    private DefaultTableModel tableModel;

    /**
     * Constructor Sin Parámetros
     */
    public ControlEquipo() {
        this.equipoDB = new EquipoDB();
        this.tableModel = new DefaultTableModel();
    }

    /**
     * Constructor con Parámetros
     *
     * @param nombreEquipo Nombre del Equipo
     * @param paisOrigen País de Origen del Equipo
     */
    public ControlEquipo(String nombreEquipo, String paisOrigen) {
        this.equipo = new Equipo(nombreEquipo, paisOrigen);
        this.equipoDB = new EquipoDB();
        this.tableModel = new DefaultTableModel();
    }

    /**
     * Método para preparar Inserción del Equipo
     */
    public void insertarEquipo() {

        try {
            String query = "insert into Equipo (nombre_equipo, pais_origen) values (?,?)";
            equipoDB.insertar(query, equipo);/* Se manda a guardar en la BBDD */
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el registro....Intentelo de nuevo");/* Error al registrar */
            
        }
    }

    /**
     * Método para preparar Listado de los Equipos
     *
     * @param tablaEquipo Tabla de Presentación de los Equipos
     */
    public void listarEquipo(JTable tablaEquipo) {

        try {
            tableModel = (DefaultTableModel) tablaEquipo.getModel();
         // Se invoca el m�todo encargado de extraer todos los datos
            List<Equipo> lista = equipoDB.listar();
            Object[] ob = new Object[2];
            
         // Se recorre el objeto que contiene toda la informacion a mostrar
            for (int i = 0; i < lista.size(); i++) {
                ob[0] = lista.get(i).getNombreEquipo();
                ob[1] = lista.get(i).getPaisOrigen();
                tableModel.addRow(ob);/* Agrega a la tabla el objeto */
            }
            tablaEquipo.setModel(tableModel);
            JOptionPane.showMessageDialog(null, "Busqueda con exito!"); /* B�squeda �xitosa */
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo"); /* B�squeda fallida */
        }
    }

    /**
     * Método para preparar Consulta del Equipo
     *
     * @param tablaEquipo Tabla de Presentación de los Equipos
     * @param nombreBuscado Nombre del Equipo a Consultar
     */
    public void consultarEquipo(JTable tablaEquipo, String nombreBuscado) {
        try {
            tableModel = (DefaultTableModel) tablaEquipo.getModel();
            tableModel.setRowCount(0);
         // Se envia el parametro para la busqueda
            List<Equipo> lista = equipoDB.consultar(nombreBuscado);
            Object[] ob = new Object[2];
            
            // Se recorre el objeto que contiene la informaci�n a mostrar
         	// mediante un for
            for (int i = 0; i < lista.size(); i++) {
            	//se realiza la comparacion
                if (lista.get(i).getNombreEquipo().compareTo(nombreBuscado) == 0) {
                    ob[0] = lista.get(i).getNombreEquipo();
                    ob[1] = lista.get(i).getPaisOrigen();
                    tableModel.addRow(ob);/* Error en la consulta */
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo");
        }
    }

    /**
     * Método para preparar Actualización del Equipo
     *
     * @param nombreBuscado Nombre del Equipo a Actualizar
     */
    public void actualizarEquipo(String nombreBuscado) {
    	
        Equipo equipoAntiguo = new Equipo(nombreBuscado, "");
        try {
        	// Creacion de la Query para actualizar datos en la BBDD
            String query = "update Equipo SET nombre_equipo = ?, pais_origen = ?  where nombre_equipo = ?";
            equipoDB.actualizar(query, equipo, equipoAntiguo);/* Se  manda la instruccion de actualizar en la BBDD */
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion....Intentelo de nuevo");/* Error al Actualizar */
        }
    }

    /**
     * Método para preparar Eliminación del Equipo
     *
     * @param nombreBuscado Nombre del Equipo a Eliminar
     */
    public void eliminarEquipo(String nombreBuscado) {
        Equipo antiguo = new Equipo(nombreBuscado, "");
        try {
        	// Creaci�n de la query encargada para eliminar el registro
            String query = "delete from Equipo where nombre_equipo = ?";
            equipoDB.eliminar(query, antiguo);/* Se manda a eliminar el registro */
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la eliminación....Intentelo de nuevo"); /* Eliminaci�n Fallida */
        }
    }

    /**
     * Método para retornar la Conexión de la Base de Datos
     *
     * @return Retorna la conexión Actual
     */
    public Conexion getConexion() {
        return conexion;
    }

    /**
     * Método para recibir la Conexión con la Base de Datos
     *
     * @param conexion Objeto de tipo Conexión
     */
    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

}
