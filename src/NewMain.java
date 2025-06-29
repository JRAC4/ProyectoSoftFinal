
import controlador.SedeDAO;
import java.util.List;
import modelos.Sedes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author frank
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args) {
     SedeDAO controlador = new SedeDAO();
    List<Sedes> resultado = controlador.listarCnt("", 5); // prueba con "" para traer los primeros 5 activos

    for (Sedes s : resultado) {
        System.out.println("ID: " + s.getId_sede());
        System.out.println("Descripción: " + s.getDescripcion());
        System.out.println("Dirección: " + s.getDireccion());
        System.out.println("Celular: " + s.getCelular());
        System.out.println("RUC: " + s.getRuc());
        System.out.println("Email: " + s.getEmail_origen());
        System.out.println("Foto: " + s.getFoto());
        System.out.println("Estado: " + s.getEstado());
        System.out.println("Serie Boleta: " + s.getSerie_boleta());
        System.out.println("Serie Factura: " + s.getSerie_factura());
        System.out.println("--------------------------------------------------");
    }
}

    
}
