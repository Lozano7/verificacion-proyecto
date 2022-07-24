/*
 * Grupo de Verificacion y Validaci�n de Software: Proyecto
 * 
 * Esta clase contiene todos los m�todos que se implementaron y fueron
 * escogidos por los casos de uso solicitados para aplicarle las guias 
 * y buenas pr�cticas de Sun.
 */

/*
 * ControlPersona
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */

package Controlador;

import Modelo.Compuestas.Persona;
import Modelo.DataBase.Conexion;
import Modelo.DataBase.PersonaDB;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase contiene los m�todos para poder ejecutar el CRUD del proyecto que
 * se desarrollo  por otro compa�ero en el curso de Construccion de Software.
 * 
 * @version 1.0.2
 * @author Eileen, Darwin Rodriguez
 */
public class ControlPersona {

    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected int edad;
    protected String direccion;
    protected String email;
    private Persona persona;
    private PersonaDB conector;
    private Conexion conexion;
    private DefaultTableModel tableModel;

    //Constructor sin parametros usados para las busquedas 
    public ControlPersona() {
        this.conector = new PersonaDB();
        this.tableModel = new DefaultTableModel();
    }

    //Constructor con parametros usados para los registros y modificaciones
    public ControlPersona(String ced, String nombres, String apellidos, 
    		int edad, String direccion, String email) {
        this.cedula = ced;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.email = email;
        this.persona = new Persona(this.cedula, this.nombres, 
        		this.apellidos, this.edad, this.direccion, this.email);
        this.conector = new PersonaDB();
        this.tableModel = new DefaultTableModel();
    }

    /**
	 * Metodo que permite registrar a una persona en la base de datos SQL.
	 */
	public void registrarPersona() {
		conector.setConexion(conexion);
		try {

			// Creacion de la Query para insertar datos en la BBDD
			String query = "INSERT INTO PERSONA (CEDULA, " 
					+ "EDAD, NOMBRES, APELLIDOS, DIRECCION, "
					+ "EMAIL) VALUES (?,?,?,?,?,?)";
			conector.insertar(query,
					persona); /* Se manda a guardar en la BBDD */
			JOptionPane.showMessageDialog(null,
					"Registro realizado con exito!"); /* Registro exitoso */
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro...."
					+ "Intentelo de nuevo"); /* Error al registrar */
		}
	}

	/**
	 * Metodo que permite la edici�n de una persona, esta se edita pasando un
	 * par�metro de busqueda.
	 * 
	 * @param cedula
	 *            Se busca la persona por su cedula.
	 */
	public void actualizarPersona(String cedula) {
		conector.setConexion(conexion);
		Persona personaAntigua = new Persona(cedula, "", "", 0, "", "");
		try {

			// Creaci�n de la Query para actualizar datos en la BBDD
			String query = "update PERSONA SET cedula = ?," 
					+ " nombres = ?, apellidos = ?, edad = ?,"
					+ " direccion = ?, email = ?,  where cedula = ?";
			conector.actualizar(query, persona,
					personaAntigua); /* Se  manda la instruccion de actualizar en la BBDD */
			JOptionPane.showMessageDialog(null, "Modificacion realizada con exito!"); /*
																						 * Actualizaci�n
																						 * �xitosa
																						 */
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion...."
					+ "Intentelo de nuevo"); /* Error al Actualizar */
		}
	}

	/**
	 * M�todo que permite la busqueda y de una persona mediante el paso de un
	 * par�metro de b�squeda y otro par�metro para presentar el resultado
	 * 
	 * @param tabla
	 *            Objeto a llenar los datos devueltos.
	 * @param cedula
	 *            Se busca la persona por su cedula.
	 */
	public void buscarPersona(JTable tabla, String cedula) {
		conector.setConexion(conexion);
		boolean validar = false;
		try {
			tableModel = (DefaultTableModel) tabla.getModel();

			// Se env�a el par�metro de busqueda
			List<Persona> listaPersona = conector.consultar(cedula);
			Object[] objetoPersona = new Object[6];

			// Se recorre el objeto que contiene la informaci�n a mostrar
			// mediante un for
			for (int i = 0; i < listaPersona.size(); i++) {
				if (listaPersona.get(i).getCedula().compareTo(cedula) == 0) {
					objetoPersona[0] = listaPersona.get(i).getCedula();
					objetoPersona[1] = listaPersona.get(i).getNombres();
					objetoPersona[2] = listaPersona.get(i).getApellidos();
					objetoPersona[3] = listaPersona.get(i).getEdad();
					objetoPersona[4] = listaPersona.get(i).getDireccion();
					objetoPersona[5] = listaPersona.get(i).getEmail();
					tableModel.addRow(
							objetoPersona); /* Agrega a la tabla el objeto */
					validar = true;
				}
			}
			tabla.setModel(tableModel);
			if (validar) {
				tabla.setModel(tableModel);
				JOptionPane.showMessageDialog(null,
						"Busqueda con exito!"); /* Busqueda exitosa */
			} else {
				JOptionPane.showMessageDialog(null,
						"No est� registrado"); /* Busqueda fallida */
			}

		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda...."
					+ "Intentelo de nuevo"); /* Error en la consulta */
		}
	}

	/**
	 * Metodo que permite la visualizaci�n de todas las personas almacenadas en
	 * la base de datos.
	 * 
	 * @param tabla
	 *            Objeto que presenta la informaci�n devuelta.
	 */
	public void listarPersona(JTable tabla) {
		conector.setConexion(conexion);
		try {
			tableModel = (DefaultTableModel) tabla.getModel();

			// Se invoca el m�todo encargado de extraer todos los datos
			List<Persona> listaPersona = conector.listar();
			Object[] objetoPersona = new Object[6];

			// Se recorre el objeto que contiene toda la informacion a mostrar
			for (int i = 0; i < listaPersona.size(); i++) {
				objetoPersona[0] = listaPersona.get(i).getCedula();
				objetoPersona[1] = listaPersona.get(i).getNombres();
				objetoPersona[2] = listaPersona.get(i).getApellidos();
				objetoPersona[3] = listaPersona.get(i).getEdad();
				objetoPersona[4] = listaPersona.get(i).getDireccion();
				objetoPersona[5] = listaPersona.get(i).getEmail();
				tableModel.addRow(
						objetoPersona); /* Agrega a la tabla el objeto */
			}
			tabla.setModel(tableModel);
			JOptionPane.showMessageDialog(null,
					"Busqueda con exito!"); /* B�squeda �xitosa */
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda...."
					+ "Intentelo de nuevo"); /* B�squeda fallida */
		}
	}

	/**
	 * Metodo que permite el borrado fisico de un registro mediante la busqueda
	 * de un criterio especificado.
	 * 
	 * @param cedula
	 *            Se busca la persona por su cedula.
	 */
	public void eliminarPersona(String cedula) {
		conector.setConexion(conexion);

		// Se instancia el objeto Persona para su eliminaci�n
		Persona personaAntigua = new Persona(cedula, "", "", 0, "", "");
		try {

			// Creacion de la query encargada para eliminar el registro
			String query = "delete from PERSONA where cedula = ?";
			conector.eliminar(query,
					personaAntigua); /* Se manda a eliminar el registro */
			JOptionPane.showMessageDialog(null,
					"Eliminacion realizada con exito!"); /*
															 * Eliminaci�n �xitosa
															 */
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar la eliminaci�n...."
					+ "Intentelo de nuevo"); /* Eliminaci�n Fallida */
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