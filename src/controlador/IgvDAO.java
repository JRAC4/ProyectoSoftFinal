package controlador;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelos.Igv;
import utilidades.ConfigGeneral;

public class IgvDAO {

    private Igv igv;
    ConfigGeneral config = new ConfigGeneral();

    public List<Igv> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Igv> lista = new ArrayList<>();

        try {
            con = new Conexion().getConexion();
            pst = con.prepareStatement("SELECT * FROM igv WHERE estado_view = 1 ORDER BY descripcion");
            rs = pst.executeQuery();

            while (rs.next()) {
                int id_igv = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                String codigo_tributo = rs.getString(4);
                int estado_view = rs.getInt(5);
                lista.add(new Igv(id_igv, codigo, descripcion, codigo_tributo, estado_view));
            }
        } catch (SQLException e) {
            System.err.println("Error en listar: " + e.getMessage());
        } finally {
            cerrarRecursos(rs, pst, con);
        }
        return lista;
    }

    public List<Igv> listarCnt(String dato, int limite) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Igv> lista = new ArrayList<>();

        try {
            con = new Conexion().getConexion();
            pst = con.prepareStatement(
                "SELECT * FROM igv WHERE descripcion LIKE ? OR codigo LIKE ? " +
                "ORDER BY codigo OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY"
            );
            pst.setString(1, "%" + dato + "%");
            pst.setString(2, "%" + dato + "%");
            pst.setInt(3, limite);

            rs = pst.executeQuery();

            while (rs.next()) {
               int id_fac_cat7_igv = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                String codigo_tributo = rs.getString(4);
                int estado_view = rs.getInt(5);
                lista.add(new Igv(id_fac_cat7_igv, codigo, descripcion, codigo_tributo, estado_view));
            }
        } catch (SQLException e) {
            System.err.println("Error en listarCnt: " + e.getMessage());
        } finally {
            cerrarRecursos(rs, pst, con);
        }
        return lista;
    }

    public void registrar(Igv obj) {
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(
                 "INSERT INTO igv (codigo, descripcion, codigo_tributo, estado_view) VALUES (?, ?, ?, ?)")) {
            pst.setString(1, obj.getCodigo());
            pst.setString(2, obj.getDescripcion());
            pst.setString(3, obj.getCodigo_tributo());
            pst.setInt(4, obj.getEstado_view());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en registrar: " + e.getMessage());
        }
    }

    public void actualizar(Igv obj) {
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(
                 "UPDATE igv SET codigo=?, descripcion=?, codigo_tributo=?, estado_view=? WHERE id_igv=?")) {
            pst.setString(1, obj.getCodigo());
            pst.setString(2, obj.getDescripcion());
            pst.setString(3, obj.getCodigo_tributo());
            pst.setInt(4, obj.getEstado_view());
            pst.setInt(5, obj.getId_igv());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en actualizar: " + e.getMessage());
        }
    }

    public void eliminar(int id_igv) {
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement("DELETE FROM igv WHERE id_igv = ?")) {
            pst.setInt(1, id_igv);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en eliminar: " + e.getMessage());
        }
    }

    public Igv buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = new Conexion().getConexion();
            pst = con.prepareStatement("SELECT * FROM igv WHERE id_igv = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                igv = new Igv(
                        rs.getInt("id_igv"),
                        rs.getString("codigo"),
                        rs.getString("descripcion"),
                        rs.getString("codigo_tributo"),
                        rs.getInt("estado_view"));
            }
        } catch (SQLException e) {
            System.err.println("Error en buscar_por_id: " + e.getMessage());
        }
        return igv;
    }
    
        public Igv getObFac_cat7() {
        return igv;
    }

    public void setObFac_cat7(Igv igv) {
        this.igv = igv;
    }

    public void actualizarActivar(int id_igv) {
        cambiarEstado(id_igv, 1);
    }

    public void actualizarDesactivar(int id_igv) {
        cambiarEstado(id_igv, 0);
    }

    private void cambiarEstado(int id_igv, int estado) {
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(
                 "UPDATE igv SET estado_view = ? WHERE id_igv = ?")) {
            pst.setInt(1, estado);
            pst.setInt(2, id_igv);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en cambiarEstado: " + e.getMessage());
        }
    }

    public int obtenerId_descripcion(String descripcion) {
        int id = 0;
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(
                 "SELECT id_igv FROM igv WHERE descripcion = ?")) {
            pst.setString(1, descripcion);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_igv");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error en obtenerId_descripcion: " + e.getMessage());
        }
        return id;
    }

    public String obtieneDescripcion_id(int id_igv) {
        return obtenerCampoPorId("descripcion", id_igv);
    }

    public String obtieneCodigo_id(int id_igv) {
        return obtenerCampoPorId("codigo", id_igv);
    }

    public String obtieneCodigoTributo_id(int id_igv) {
        return obtenerCampoPorId("codigo_tributo", id_igv);
    }

    private String obtenerCampoPorId(String campo, int id_igv) {
        String valor = "";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(
                 "SELECT " + campo + " FROM igv WHERE id_igv = ?")) {
            pst.setInt(1, id_igv);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                valor = rs.getString(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error en obtenerCampoPorId (" + campo + "): " + e.getMessage());
        }
        return valor;
    }



    private void cerrarRecursos(ResultSet rs, PreparedStatement pst, Connection con) {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}
