/*
 * Conexion
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */

package Modelo.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase para Administrar la Conexión con la Base de Datos
 *
 * @author John
 */
public class Conexion {

    private static final String DATABASEURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String user;
    private static String password;

    /**
     * Método para Establecer Conexión con la Base de Datos
     *
     * @return Presenta NULL si no se Estableció Conexión
     */
    public static Connection establecerConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connector = DriverManager.getConnection(Conexion.DATABASEURL,
            		Conexion.user, Conexion.password);
            return connector;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase no Encontrada.", 
            		"Conexión Erronéa", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método para Validar la Conexión con la Base de Datos
     *
     * @param connector Objeto que contiene la Conexión con la Base de Datos
     * @return
     */
    public static Connection validarConexion(Connection connector) {
        if (connector != null) {
            JOptionPane.showMessageDialog(null, "¡Conectado Exitosamente!", 
            		"Conexion Establecida", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "¡Error de Conexión!", 
            		"Conexion no Establecida", JOptionPane.ERROR_MESSAGE);
        }
        return connector;
    }

    /**
     * Método para Validar la Conexión con la Base de Datos
     *
     * @param user Usuario para Iniciar Sesión en la Base de Datos
     * @param password Contraseña para Iniciar Sesión en la Base de Datos
     */
    public static void iniciarDatos(String user, String password) {
        setUSER(user);
        setPASSWORD(password);
    }

    public static String getUSER() {
        return user;
    }

    public static void setUSER(String USER) {
        Conexion.user = USER;
    }

    public static String getPASSWORD() {
        return password;
    }

    public static void setPASSWORD(String PASSWORD) {
        Conexion.password = PASSWORD;
    }

}
