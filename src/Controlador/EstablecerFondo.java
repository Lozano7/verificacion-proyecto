/*
 * CONTROLEQUIPO
 * 
 *@version 1.0.2
 * 
 * 23 JUL 2022
 * 
 */


package Controlador;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Esta clase contiene los m�todos para poder ejecutar el CRUD del proyecto que
 * se desarrollo  por otro compa�ero en el curso de Construccion de Software.
 * 
 * @version 1.0.2
 * @author Eileen, Darwin Rodriguez, Anthony Lozano
 */
public class EstablecerFondo extends JPanel {

    private Image imagen;
    private String urlImagen;

    /**
     * Constructor con Parámetros
     *
     * @param urlImagen: Ruta de la Imagen
     */
    public EstablecerFondo(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
    /**
     * Metodo que pinta una imagen como fondo en los paneles 
     *
     * @param urlImagen: Ruta de la Imagen
     */

    @Override
    public void paint(Graphics g) {
        this.imagen = new ImageIcon(getClass().getResource(urlImagen)).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
