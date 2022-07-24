/*
 * DirectorDB
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */

package Modelo.DataBase;

import Modelo.Compuestas.DirectorTecnico;
import Modelo.Interfaces.Crud;
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

public class DirectorDB implements Crud {

    private Connection connector;
    private PreparedStatement statement;
    private ResultSet result;
    private Conexion conexion;

    /**
     * Método para Validar un Statement
     *
     * @param directorRegistrado Comprueba si el Statement se creó Correctamente
     */
    public void validarStatement(int directorRegistrado) {
        if (directorRegistrado == 1) {
            JOptionPane.showMessageDialog(null, "¡Se registró correctamente!", 
            		"Registro Completo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Datos incongruentes, "
            		+ "porfavor revise la información", "Registro Incompleto", 
            		JOptionPane.INFORMATION_MESSAGE); /* Error al registrar  */
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
            DirectorTecnico director = (DirectorTecnico) objeto;
            statement = connector.prepareStatement(query);
            statement.setString(1, director.getCedula());
            statement.setString(2, director.getNombres());
            statement.setString(3, director.getApellidos());
            statement.setInt(4, director.getEdad());
            statement.setString(5, director.getEmail());
            statement.setInt(6, director.getEquiposDirigidos());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo de Consulta", 
            		"Registro Fallido", JOptionPane.ERROR_MESSAGE); /* Error al iniciar el Statement */
        }
        return statement.executeUpdate();
    }

    /**
     * Método para Insertar un Director Técnico en la Base de Datos
     *
     * @param query Consulta de Inserción
     * @param objeto Objeto a Insertar
     */
    @Override
    public void insertar(String query, Object objeto) {
        try {
            connector = Conexion.establecerConexion();
            validarStatement(iniciarStatement(query, objeto));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo de Registro", 
            		"Registro Fallido", JOptionPane.ERROR_MESSAGE);/* Error al registrar */
        }
    }

    /**
     * Método para Actualizar un Director Técnico en la Base de Datos
     *
     * @param query Consulta de Actualización
     * @param objeto Objeto a Actualizar
     * @param objetoAntiguo Objeto a Comparar
     */
    @Override
    public void actualizar(String query, Object objeto, Object objetoAntiguo) {
        DirectorTecnico director = (DirectorTecnico) objeto;
        DirectorTecnico directorAntiguo = (DirectorTecnico) objetoAntiguo;
        try {
            connector = Conexion.establecerConexion();
            statement = connector.prepareStatement(query);
            statement.setString(1, director.getCedula());
            statement.setString(2, director.getNombres());
            statement.setString(3, director.getApellidos());
            statement.setInt(4, director.getEdad());
            statement.setString(5, director.getEmail());
            statement.setInt(6, director.getEquiposDirigidos());
            statement.setString(7, directorAntiguo.getCedula());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Se modificó correctamente"
            		+ " al Director Tecnico!", "Modificar Completo",
            		JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);/* Error en la actulizacion */
        }
    }

    /**
     * Método para Eliminar un Director Técnico en la Base de Datos
     *
     * @param query Consulta de Eliminación
     * @param objeto Objeto a Eliminar
     */
    @Override
    public void eliminar(String query, Object objeto) {
        DirectorTecnico dt = (DirectorTecnico) objeto;
        int resultado = 0;
        try {
            connector = Conexion.establecerConexion();
            statement = connector.prepareStatement(query);
            statement.setString(1, dt.getCedula());
            resultado = statement.executeUpdate();
            if (resultado == 1) {
                System.out.println("Eliminado Exitosamente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);/*Error en la eliminacion*/
        }
    }

    /**
     * Método para Consultar un Director Técnico en la Base de Datos
     *
     * @param cedula Cédula para buscar un Director Técnico
     * @return
     */
    @Override
    public List consultar(String cedula) {
        String query = "select cedula, nombres, apellidos, edad, "
        		+ "email,equipos_dirigidos from DirectorTecnico "
        		+ "Where cedula = '" + cedula + "'";
        List<DirectorTecnico> datos = new ArrayList<>();
        try {
            connector = Conexion.establecerConexion();
            statement = connector.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                DirectorTecnico dt = new DirectorTecnico();
                dt.setCedula(result.getString(1));
                dt.setNombres(result.getString(2));
                dt.setApellidos(result.getString(3));
                dt.setEdad(result.getInt(4));
                dt.setEmail(result.getString(5));
                dt.setEquiposDirigidos(result.getInt(6));
                datos.add(dt);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    /**
     * Método para Listar a los Directores Técnicos de la Base de Datos
     *
     * @return
     */
    public List listar() {
        List<DirectorTecnico> datos = new ArrayList<>();
        String query = "select cedula, nombres, apellidos, edad, "
        		+ "email, equipos_dirigidos from DirectorTecnico";
        try {
            connector = Conexion.establecerConexion();
            statement = connector.prepareStatement(query);
            result = statement.executeQuery();

            while (result.next()) {
                DirectorTecnico dt = new DirectorTecnico();
                dt.setCedula(result.getString(1));
                dt.setNombres(result.getString(2));
                dt.setApellidos(result.getString(3));
                dt.setEdad(result.getInt(4));
                dt.setEmail(result.getString(5));
                dt.setEquiposDirigidos(result.getInt(6));
                datos.add(dt);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    public Conexion establecerConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

}
