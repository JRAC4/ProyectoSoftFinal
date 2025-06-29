/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.SedeConfig;

/**
 *
 * @author frank
 */
public class SedeconfigDAO{

    private SedeConfig sedeconfig;

    
public List<SedeConfig> listarCnt(String dato, int cnt) {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();
    ArrayList<SedeConfig> listaArray = new ArrayList<>();
    try {
        con = Conexion.getConexion();
        String sql = "SELECT * FROM sedeconfig WHERE sede LIKE ? "
                   + "ORDER BY sede OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
        pst = con.prepareStatement(sql);
        pst.setString(1, "%" + dato + "%");
        pst.setInt(2, cnt);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id_sedeconfig = rs.getInt(1);
            int id_sede = rs.getInt(2);
            int modelo_codbar = rs.getInt(3);
            String sede = rs.getString(4);
            listaArray.add(new SedeConfig(id_sedeconfig, id_sede, modelo_codbar, sede));
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println("Error en listar SedeConfig: " + e);
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar");
        }
    }
    return listaArray;
}

    
   public void registrar(SedeConfig obj) {
    String consulta = "INSERT INTO sedeconfig(modelo_codbar, id_sede, sede) VALUES (?, ?, ?)";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setInt(1, obj.getModelo_codbar());
        ps.setInt(2, obj.getId_sede());
        ps.setString(3, obj.getSede());

        ps.executeUpdate();
        System.out.println("Registro de sedeconfig exitoso.");

    } catch (SQLException e) {
        System.err.println("Error al registrar sedeconfig: " + e.getMessage());
    }
}


    
 public boolean actualizar(SedeConfig obj) {
    String consulta = "UPDATE sedeconfig SET modelo_codbar = ?, id_sede = ?, sede = ? WHERE id_sedeconfig = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setInt(1, obj.getModelo_codbar());
        ps.setInt(2, obj.getId_sede());
        ps.setString(3, obj.getSede());
        ps.setInt(4, obj.getId_sedeconfig());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        System.err.println("Error al actualizar sedeconfig: " + e.getMessage());
        return false;
    }
}


    
  public boolean eliminar(int id) {
    String consulta = "DELETE FROM sedeconfig WHERE id_sedeconfig = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setInt(1, id);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        System.err.println("Error al eliminar sedeconfig: " + e.getMessage());
        return false;
    }
}


    
    public SedeConfig buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        try {
            con = Conexion.getConexion();
            pst = con.prepareStatement("select * from sedeconfig where id_sedeconfig='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_sedeconfig = rs.getInt(1);
                int id_sede = rs.getInt(2);
                int modelo_codbar = rs.getInt(3);
                String sede = rs.getString(4);
                sedeconfig = new SedeConfig(id_sedeconfig, id_sede, modelo_codbar, sede);
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
        return sedeconfig;
    }

    public SedeConfig getSedeConfig() {
        return sedeconfig;
    }

    public void setSedeConfig(SedeConfig sedeconfig) {
        this.sedeconfig = sedeconfig;
    }

}
