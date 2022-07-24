/*
 * PersonaDB
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */
package Modelo.DataBase;

import Modelo.Interfaces.Crud;
import Modelo.Compuestas.Persona;
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
 *
 * @author Eileen
 */
public class PersonaDB implements Crud {
	private Connection connector;
	private PreparedStatement statement;
	private ResultSet result;
	private Conexion conexion;

	/**
	 * M�todo para iniciar un Statement
	 * 
	 * @param query
	 * @param objeto
	 * @return
	 * @throws SQLException
	 */
	public int iniciarStatement(String query, Object objeto) throws SQLException {
		try {
			Persona persona = (Persona) objeto;
			statement = connector.prepareStatement(query);
			statement.setString(1, persona.getCedula());
			statement.setString(2, persona.getNombres());
			statement.setString(3, persona.getApellidos());
			statement.setInt(4, persona.getEdad());
			statement.setString(5, persona.getDireccion());
			statement.setString(6, persona.getEmail());
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Fallo de Consulta", 
					"Registro Fallido", JOptionPane.ERROR_MESSAGE);
		}
		return statement.executeUpdate();
	}

	// Valida que el Registro se haya realizado correctamente

	/**
	 *
	 * @param valor
	 *            variable que contiene dato a validar
	 */
	public void validarStatement(int valor) {
		if (valor == 1) {
			JOptionPane.showMessageDialog(null, "¡Se registró correctamente!", 
					"Registro Completo",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Datos incongruentes, " 
					+ "porfavor revise la información",
					"Registro Incompleto", JOptionPane.INFORMATION_MESSAGE);/* Error al registrar */
		}
	}

	/**
	 * M�todo que permite registrar a una persona
	 * 
	 * @param query
	 *            sentencia sql
	 * @param objeto
	 *            Objeto Persona
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
	 * M�todo que permite modificar una persona
	 * 
	 * @param query
	 *            Sentencia SQL
	 * @param objeto
	 *            Objeto Persona a modificar
	 * @param ob
	 */
	@Override
	public void actualizar(String query, Object objeto, Object ob) {
		Persona persona = (Persona) objeto;
		int answer = 0;
		try {
			connector = Conexion.establecerConexion();
			statement = connector.prepareStatement(query);
			statement.setString(1, persona.getCedula());
			statement.setString(2, persona.getNombres());
			statement.setString(3, persona.getApellidos());
			statement.setInt(4, persona.getEdad());
			statement.setString(5, persona.getDireccion());
			statement.setString(6, persona.getEmail());
			answer = statement.executeUpdate();
			if (answer == 1) {
				System.out.println("Modificado Exitosamente!");
			}
		} catch (SQLException ex) {
			Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);/* Error en la actulizacion */
		}
	}

	/**
	 *
	 * @param query
	 *            Sentencia SQL
	 * @param objeto
	 *            Objeto Persona que se va a eliminar
	 */
	@Override
	public void eliminar(String query, Object objeto) {
		Persona persona = (Persona) objeto;
		int answer = 0;
		try {
			connector = Conexion.establecerConexion();
			statement = connector.prepareStatement(query);/*Se crea la query para la consulta*/
			statement.setString(1, persona.getCedula());
			answer = statement.executeUpdate();
			if (answer == 1) {
				System.out.println("Eliminado Exitosamente!");/* Se elimina con exito*/
			}
		} catch (SQLException ex) {
			Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);/*Error en la eliminacion*/
		}
	}

	/**
	 * M�todo que permite la b�squeda de una persona
	 * 
	 * @param cedula
	 *            Cedula de la persona a buscar
	 * @return datos Regresa una lista de personas encontradas.
	 */
	@Override
	// Metodo para imprimir en consola
	public List consultar(String cedula) {
		String query = "select cedula, nombres, apellidos, edad, "
				+ "direccion, email from PERSONA where cedula = '"
				+ cedula + "'";
		List<Persona> datos = new ArrayList<>();
		try {
			connector = Conexion.establecerConexion();
			statement = connector.prepareStatement(query);
			result = statement.executeQuery();
			while (result.next()) {
				Persona persona = new Persona();
				persona.setCedula(result.getString(1));
				persona.setNombres(result.getString(2));
				persona.setApellidos(result.getString(3));
				persona.setEdad(result.getInt(4));
				persona.setDireccion(result.getString(5));
				persona.setEmail(result.getString(6));
				datos.add(persona);
			}
		} catch (SQLException ex) {
			Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);/* Error en la consulta */
		}
		return datos;
	}

	/**
	 * M�todo que permite la consulta de todas las personas almacenadas en la
	 * base de datos
	 * 
	 * @return datos Regresa una lista completa de todos los registros.
	 */
	public List listar() {
		List<Persona> datos = new ArrayList<>();
		String query = "select cedula, nombres, apellidos, edad, " 
						+ "direccion, email from PERSONA";
		try {
			connector = Conexion.establecerConexion();
			statement = connector.prepareStatement(query);
			result = statement.executeQuery();

			while (result.next()) {
				Persona persona = new Persona();
				persona.setCedula(result.getString("Cedula"));
				persona.setNombres(result.getString("Nombres"));
				persona.setApellidos(result.getString("Apellidos"));
				persona.setEdad(result.getInt("Edad"));
				persona.setDireccion(result.getString("Direccion"));
				persona.setEmail(result.getString("Email"));
				datos.add(persona);
			}

		} catch (SQLException ex) {
			Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return datos;
	}

	/**
	 * M�todo que permite establecer la conexi�n a una base de datos
	 * 
	 * @return conexion
	 */
	public Conexion establecerConexion() {
		return conexion;
	}

	/**
	 * M�todo que permite la asignaci�n de una conexi�n
	 * 
	 * @param conexion
	 */
	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	

}
