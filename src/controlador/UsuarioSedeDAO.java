package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.UsuarioSede;
import utilidades.ConfigGeneral;

/**
 *
 * @author frank
 */
public class UsuarioSedeDAO {

    ConfigGeneral config = new ConfigGeneral();

    
    public List<UsuarioSede> listarporUsuario(int idusuario) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<UsuarioSede> listaArray = new ArrayList<UsuarioSede>();
        try {
            con = Conexion.getConexion();
            pst = con.prepareStatement("select * from usuario_sede where id_usuario='" + idusuario + "' ");
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_usuario_sede = rs.getInt(1);
                int id_usuario = rs.getInt(2);
                int id_sede = rs.getInt(3);
                listaArray.add(new UsuarioSede(id_usuario_sede, id_usuario, id_sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar UsuarioSede" + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return listaArray;
    }

    
 public void registrar(UsuarioSede obj) {
    String consulta = "INSERT INTO usuario_sede(id_usuario, id_sede) VALUES (?, ?)";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setInt(1, obj.getId_usuario());
        ps.setInt(2, obj.getId_sede());

        ps.executeUpdate();
        System.out.println("Usuario-Sede registrada correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al registrar usuario_sede: " + e.getMessage());
    }
}


    
  public void eliminar(int id_usuario,int idusuario,int id_sede) {
    String consulta = "DELETE FROM usuario_sede WHERE id_usuario = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setInt(1, id_usuario);

        ps.executeUpdate();
        System.out.println("Todas las asociaciones de usuario eliminadas.");

    } catch (SQLException e) {
        System.err.println("Error al eliminar usuario_sede: " + e.getMessage());
    }
}


}
