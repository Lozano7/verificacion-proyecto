/*
 * EquipoDB
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */

package Modelo.DataBase;

import Modelo.Interfaces.Crud;
import Modelo.Simples.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Eileen, Darwin Rodriguez, Anthony Lozano
 */

public class EquipoDB implements Crud {

    private Connection connector;
    private PreparedStatement statement;
    private ResultSet result;

    public EquipoDB() {
        this.connector = Conexion.establecerConexion();
    }

    /**
     * Método para Validar un Statement
     *
     * @param equipoRegistrado Comprueba si el Statement se creó Correctamente
     */
    public void validarStatement(int equipoRegistrado) {
        if (equipoRegistrado == 1) {
            JOptionPane.showMessageDialog(null, "¡Se registró correctamente el EQUIPO!",
            		"Registro Completo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Datos incongruentes, "
            		+ "porfavor revise la información", "Registro Incompleto", /* Error al registrar */
            		JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Método para Iniciar un Statement
     *
     * @param query Consulta a Realizar
     * @param objeto Objeto a Preparar
     * @return
     * @throws SQLException
     */
    public int iniciarStatement(String query, Object objeto) throws SQLException {
        try {
            Equipo equipo = (Equipo) objeto;
            statement = connector.prepareStatement(query);
            statement.setString(1, equipo.getNombreEquipo());
            statement.setString(2, equipo.getPaisOrigen());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo de Consulta", 
            		"Registro Fallido", JOptionPane.ERROR_MESSAGE);/* Error al ejecutar la consulta */
        }
        return statement.executeUpdate();
    }

    /**
     * Método para Insertar un Equipo en la Base de Datos
     *
     * @param query Consulta de Inserción
     * @param objeto Objeto a Insertar
     */
    @Override
    public void insertar(String query, Object objeto) {
        try {
            validarStatement(iniciarStatement(query, objeto));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo de Consulta", 
            		"Registro Fallido", JOptionPane.ERROR_MESSAGE);/* Error al registrar */
        }
    }

    /**
     * Método para Actualizar un Equipo en la Base de Datos
     *
     * @param query Consulta de Actualización
     * @param objeto Objeto a Actualizar
     * @param objetoAntiguo Objeto a Comparar
     */
    @Override
    public void actualizar(String query, Object objeto, Object objetoAntiguo) {
        Equipo equipo = (Equipo) objeto;
        Equipo equipoAntiguo = (Equipo) objetoAntiguo;
        try {
            statement = connector.prepareStatement(query);
            statement.setString(1, equipo.getNombreEquipo());
            statement.setString(2, equipo.getPaisOrigen());
            statement.setString(3, equipoAntiguo.getNombreEquipo());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Se modificó correctamente al EQUIPO!", 
            		"Modificar Completo", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);/* Error en la actulizacion */
        }
    }

    /**
     * Método para Eliminar un Equipo en la Base de Datos
     *
     * @param query Consulta de Eliminación
     * @param objeto Objeto a Eliminar
     */
    @Override
    public void eliminar(String query, Object objeto) {
        Equipo equipo = (Equipo) objeto;
        try {
            statement = connector.prepareStatement(query);
            statement.setString(1, equipo.getNombreEquipo());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Se eliminó correctamente el EQUIPO!", 
            		"Eliminar Completo", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);/*Error en la eliminacion*/
        }
    }

    /**
     * Método para Consultar un Equipo en la Base de Datos
     *
     * @param equipoBuscado Cédula para buscar un Director Técnico
     * @return datos Variable que contiene la informacion a mostrar.
     */
    @Override
    public List consultar(String equipoBuscado) {
        String query = "select nombre_equipo, pais_origen from Equipo "
        		+ "where nombre_equipo = '" + equipoBuscado + "'";
        List<Equipo> datos = new ArrayList<>();
        try {
            statement = connector.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                Equipo equipo = new Equipo();
                equipo.setNombreEquipo(result.getString(1));
                equipo.setPaisOrigen(result.getString(2));
                datos.add(equipo);
            }
            JOptionPane.showMessageDialog(null, "¡Se encontró correctamente al EQUIPO!", 
            		"Buscar Completo", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);/* Error al realizar la consulta */
        }
        return datos;
    }

    /**
     * Método para Listar a los Equipos de la Base de Datos
     *
     * @return datos Variable contenedora de la informaci�n a mostrar.
     */
    public List listar() {
        List<Equipo> datos = new ArrayList<>();
        String query = "select nombre_equipo, pais_origen from Equipo";
        try {
            statement = connector.prepareStatement(query);
            result = statement.executeQuery();

            while (result.next()) {
                Equipo equipo = new Equipo();
                equipo.setNombreEquipo(result.getString("nombre_equipo"));
                equipo.setPaisOrigen(result.getString("pais_origen"));
                datos.add(equipo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);/* Error al listar */
        }
        return datos;
    }

}
