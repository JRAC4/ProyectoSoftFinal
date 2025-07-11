package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Cntcarga;
import utilidades.ConfigGeneral;

/**
 *
 * @author frank
 */
public class CntcargaDAO{

    private Cntcarga cntcarga;
    ConfigGeneral config = new ConfigGeneral();

    
    public List<Cntcarga> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Cntcarga> listaCnt_carga = new ArrayList<Cntcarga>();
        try {
            con = Conexion.getConexion();
            pst = con.prepareStatement("select * from cntcarga where estado='1' order by cantidad ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_cntcarga = rs.getInt(1);
                int cantidad = rs.getInt(2);
                int estado = rs.getInt(3);
                listaCnt_carga.add(new Cntcarga(id_cntcarga, cantidad, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Cnt_carga" + e);
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
        return listaCnt_carga;
    }

    
    public List<Cntcarga> listarCnt(int cntcarga) {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();
    ArrayList<Cntcarga> listaCnt_carga = new ArrayList<>();
    try {
        con = Conexion.getConexion();
        String sql = "SELECT * FROM cntcarga WHERE estado = 1 ORDER BY cantidad OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
        pst = con.prepareStatement(sql);
        pst.setInt(1, cntcarga); // cantidad de filas que quieres traer

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id_cntcarga = rs.getInt(1);
            int cantidad = rs.getInt(2);
            int estado = rs.getInt(3);
            listaCnt_carga.add(new Cntcarga(id_cntcarga, cantidad, estado));
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println("Error en listarCnt Cnt_carga: " + e);
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos");
        }
    }
    return listaCnt_carga;
}
    
   public void registrar(Cntcarga obj) {
    String consulta = "INSERT INTO cntcarga(cantidad, estado) VALUES (?, ?)";
    
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setInt(1, obj.getCantidad());   // Asumiendo que cantidad es int
        ps.setInt(2, obj.getEstado());

        ps.executeUpdate(); // Ejecuta la consulta

        System.out.println("Registro insertado correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al registrar en cntcarga: " + e.getMessage());
    }
}


    
   public boolean actualizar(Cntcarga obj) {
    String consulta = "UPDATE cntcarga SET cantidad = ? WHERE id_cntcarga = ?";
    
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setInt(1, obj.getCantidad());             // cantidad a actualizar
        ps.setInt(2, obj.getIdcant_carga());         // id del registro

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;  // true si al menos un registro fue actualizado

    } catch (SQLException e) {
        System.err.println("Error al actualizar cntcarga: " + e.getMessage());
        return false;
    }
}

    
public boolean eliminar(int id) {
    String consulta = "UPDATE cntcarga SET estado = '0' WHERE id_cntcarga = ?";
    
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setInt(1, id);

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0; // true si se afectó al menos un registro

    } catch (SQLException e) {
        System.err.println("Error al eliminar (actualizar estado) en cntcarga: " + e.getMessage());
        return false;
    }
}

    
    public Cntcarga buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        try {
            con = Conexion.getConexion();
            pst = con.prepareStatement("select * from cntcarga where id_cntcarga='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_cntcarga = rs.getInt(1);
                int cantidad = rs.getInt(2);
                int estado = rs.getInt(3);
                cntcarga = new Cntcarga(id_cntcarga, cantidad, estado);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en buscar_por_id " + e);
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
        return cntcarga;
    }

    public Cntcarga getCnt_carga() {
        return cntcarga;
    }

    public void setCnt_carga(Cntcarga cntcarga) {
        this.cntcarga = cntcarga;
    }

}
