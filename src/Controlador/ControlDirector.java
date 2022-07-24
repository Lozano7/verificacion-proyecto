/*
 * ControlEquipo
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */

package Controlador;

import Modelo.Compuestas.DirectorTecnico;
import Modelo.DataBase.Conexion;
import Modelo.DataBase.DirectorDB;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para preparar los datos de los Directores Técnicos a la Base de Datos
 *
 * @author Eileen
 */
public class ControlDirector {

    private String cedula;
    private String nombres;
    private String apellidos;
    private int edad;
    private String email;
    private int equiposDirigidos;
    private DirectorTecnico director;
    private DirectorDB controlador;
    private Conexion conexion;
    private DefaultTableModel tableModel;

    /**
     * Constructor por Defecto
     */
    public ControlDirector() {
        this.controlador = new DirectorDB();
        this.tableModel = new DefaultTableModel();
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
    public ControlDirector(String cedula, String nombres, String apellidos, int edad, String email, int equiposDirigidos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.equiposDirigidos = equiposDirigidos;

    }

    /**
     * Método para Instanciar un Objeto de tipo Director Técnico
     */
    public void instanciarDirector() {
        this.director = new DirectorTecnico(this.cedula, this.nombres, this.apellidos, this.edad, this.email, this.equiposDirigidos);
        this.controlador = new DirectorDB();
        this.tableModel = new DefaultTableModel();
    }

    /**
     * Método para preparar Inserción del Director Técnico
     */
    public void insertarDirector() {
        controlador.setConexion(conexion);
        try {
        	// Creacion de la Query para insertar datos en la BBDD
            String query = "INSERT INTO DirectorTecnico (CEDULA, NOMBRES, APELLIDOS, EDAD, EMAIL,EQUIPOS_DIRIGIDOS) VALUES (?,?,?,?,?,?)";
            controlador.insertar(query, director);/* Se manda a guardar en la BBDD */
            JOptionPane.showMessageDialog(null, "Registro realizado con exito!");/* Registro exitoso */
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el registro....Intentelo de nuevo");/* Error al registrar */
        }
    }

    /**
     * Método para preparar Actualización del Director Técnico
     *
     * @param cedula Cédula del Director Técnico a Actualizar
     */
    public void actualizarDirector(String cedula) {
        DirectorTecnico directorAntiguo = new DirectorTecnico(cedula);
        try {
        	// Creacion de la Query para la actualizacion en la base de dato
            String query = "update DirectorTecnico SET CEDULA = ?, NOMBRES = ?, APELLIDOS = ?, EDAD = ?, EMAIL = ?, EQUIPOS_DIRIGIDOS = ?  where cedula = ?";
            controlador.actualizar(query, director, directorAntiguo);/* Se actualiza en la BBDD */
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion.... Intentelo de nuevo");/* Error en la actulizacion */
        }
    }

    /**
     * Método para preparar Consulta del Director Técnico
     *
     * @param tablaDirector Tabla de Presentación de los Director Técnicos
     * @param cedula Cédula del Director Técnico a Consultar
     * @return Presenta si se encontro al Director Técnico
     */
    public boolean consultarDirector(JTable tablaDirector, String cedula) {
        controlador.setConexion(conexion);
        boolean validarBusqueda = false;
        try {
            tableModel = (DefaultTableModel) tablaDirector.getModel();
            tableModel.setRowCount(0);
            
            // Se env�a el par�metro de busqueda
            List<DirectorTecnico> lista = controlador.consultar(cedula);
            Object[] ob = new Object[6];
            
            // Se recorre el objeto que contiene la informaci�n a mostrar
            // mediante un for
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getCedula().compareTo(cedula) == 0) {
                    ob[0] = lista.get(i).getCedula();
                    ob[1] = lista.get(i).getNombres();
                    ob[2] = lista.get(i).getApellidos();
                    ob[3] = lista.get(i).getEdad();
                    ob[4] = lista.get(i).getEmail();
                    ob[5] = lista.get(i).getEquiposDirigidos();
                    tableModel.addRow(ob);
                    validarBusqueda = true;
                }
            }
            tablaDirector.setModel(tableModel);
            if (validarBusqueda) {
                tablaDirector.setModel(tableModel);
                JOptionPane.showMessageDialog(null, "Busqueda con exito!"); /* Busqueda exitosa */
            } else {
                JOptionPane.showMessageDialog(null, "No está registrado");/* Busqueda fallida */
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo"); /* Error en la consulta */
        }
        return validarBusqueda;
    }

    /**
     * Método para preparar Listado del Director Técnico
     *
     * @param tabla Tabla de Presentación de los Director Técnicos
     */
    public void listarDirector(JTable tabla) {
        try {
            tableModel = (DefaultTableModel) tabla.getModel();
            List<DirectorTecnico> lista = controlador.listar();
            Object[] ob = new Object[7];
            for (int i = 0; i < lista.size(); i++) {
                ob[0] = lista.get(i).getCedula();
                ob[1] = lista.get(i).getNombres();
                ob[2] = lista.get(i).getApellidos();
                ob[3] = lista.get(i).getEdad();
                ob[4] = lista.get(i).getEmail();
                ob[5] = lista.get(i).getEquiposDirigidos();
                tableModel.addRow(ob);
            }
            tabla.setModel(tableModel);
            JOptionPane.showMessageDialog(null, "Busqueda con exito!");/* Busqueda exitosa */
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo");/* Error en la consulta */
        }
    }

    /**
     * Método para preparar Eliminación del Director Técnico
     *
     * @param cedula Cédula del Director Técnico a Eliminar
     */
    public void eliminarDirector(String cedula) {
        controlador.setConexion(conexion);
        DirectorTecnico directorAntiguo = new DirectorTecnico(cedula);
        try {
            String query = "delete from DirectorTecnico where cedula = ?"; /*Se crea la query para la consulta*/
            controlador.eliminar(query, directorAntiguo);
            JOptionPane.showMessageDialog(null, "Eliminacion realizada con exito!");/* Se elimina con exito*/
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la eliminación....Intentelo de nuevo"); /*Error en la eliminacion*/
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
     * @param conexion Objeto de Tipo Conexión
     */
    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
}
