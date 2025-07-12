package controlador;

import conexion.Conexion;
import modelos.Tipodoc;
import utilidades.ConfigGeneral;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipodocDAO {
    private Tipodoc tipodoc;
    ConfigGeneral config = new ConfigGeneral();

    public List<Tipodoc> listar() {
        List<Tipodoc> listaArray = new ArrayList<>();
        String sql = "SELECT * FROM tipodoc WHERE estado = 1 AND estado_view = 1";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
              int id_tipodoc = rs.getInt(1);
                String descripcion = rs.getString(2);
                int longitud = rs.getInt(3);
                int estado = rs.getInt(4);
                String codigo = rs.getString(5);
                int estado_view = rs.getInt(6);
                String simbolo = rs.getString(7);
                listaArray.add(new Tipodoc(id_tipodoc, descripcion, estado, longitud,
                        codigo, estado_view, simbolo));
            }
        } catch (SQLException e) {
            System.out.println("Error en listar Tipodoc: " + e.getMessage());
        }
        return listaArray;
    }

    public List<Tipodoc> listarCnt(String dato, int cnt) {
        List<Tipodoc> listaArray = new ArrayList<>();
        String sql = "SELECT * FROM tipodoc WHERE estado = 1 AND descripcion LIKE ? ORDER BY descripcion OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%" + dato + "%");
            pst.setInt(2, cnt);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int id_tipodoc = rs.getInt(1);
                String descripcion = rs.getString(2);
                int longitud = rs.getInt(3);
                int estado = rs.getInt(4);
                String codigo = rs.getString(5);
                int estado_view = rs.getInt(6);
                String simbolo = rs.getString(7);
                listaArray.add(new Tipodoc(id_tipodoc, descripcion, estado, longitud,
                        codigo, estado_view, simbolo));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en listarCnt: " + e.getMessage());
        }
        return listaArray;
    }

    public void registrar(Tipodoc obj) {
        String sql = "INSERT INTO tipodoc(descripcion, estado, longitud, codigo, estado_view, simbolo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, obj.getDescripcion());
            pst.setInt(2, obj.getEstado());
            pst.setInt(3, obj.getLongitud());
            pst.setString(4, obj.getCodigo());
            pst.setInt(5, obj.getEstado_view());
            pst.setString(6, obj.getSimbolo());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en registrar: " + e.getMessage());
        }
    }

    public void actualizar(Tipodoc obj) {
        String sql = "UPDATE tipodoc SET descripcion = ?, longitud = ?, codigo = ?, estado_view = ?, simbolo = ? WHERE id_tipodoc = ?";
        String sqlCliente = "UPDATE cliente SET tipodoc = ? WHERE id_tipodoc = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst1 = con.prepareStatement(sql);
             PreparedStatement pst2 = con.prepareStatement(sqlCliente)) {
            pst1.setString(1, obj.getDescripcion());
            pst1.setInt(2, obj.getLongitud());
            pst1.setString(3, obj.getCodigo());
            pst1.setInt(4, obj.getEstado_view());
            pst1.setString(5, obj.getSimbolo());
            pst1.setInt(6, obj.getId_tipodoc());
            pst1.executeUpdate();

            pst2.setString(1, obj.getSimbolo());
            pst2.setInt(2, obj.getId_tipodoc());
            pst2.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en actualizar: " + e.getMessage());
        }
    }

    public void actualizarActivar(int id_tipodoc) {
        actualizarEstadoView(id_tipodoc, 1);
    }

    public void actualizarDesactivar(int id_tipodoc) {
        actualizarEstadoView(id_tipodoc, 0);
    }

    private void actualizarEstadoView(int id, int estado) {
        String sql = "UPDATE tipodoc SET estado_view = ? WHERE id_tipodoc = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, estado);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en actualizarEstadoView: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "UPDATE tipodoc SET estado = 0 WHERE id_tipodoc = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en eliminar: " + e.getMessage());
        }
    }

    public String obtieneCodigo_id(int id_tipodoc) {
        String sql = "SELECT codigo FROM tipodoc WHERE id_tipodoc = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id_tipodoc);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) return rs.getString("codigo");
            }
        } catch (SQLException e) {
            System.err.println("Error obtieneCodigo_id: " + e.getMessage());
        }
        return "";
    }

    public String obtieneDescripcion_id(int id_tipodoc) {
        String sql = "SELECT descripcion FROM tipodoc WHERE id_tipodoc = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id_tipodoc);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) return rs.getString("descripcion");
            }
        } catch (SQLException e) {
            System.err.println("Error obtieneDescripcion_id: " + e.getMessage());
        }
        return "";
    }

    public String obtieneSimbolo_id(String descripcion) {
        String sql = "SELECT simbolo FROM tipodoc WHERE descripcion = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, descripcion);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) return rs.getString("simbolo");
            }
        } catch (SQLException e) {
            System.err.println("Error obtieneSimbolo_id: " + e.getMessage());
        }
        return "";
    }

    public int obtenerId_descripcion(String simbolo) {
        String sql = "SELECT id_tipodoc FROM tipodoc WHERE simbolo = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, simbolo);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) return rs.getInt("id_tipodoc");
            }
        } catch (SQLException e) {
            System.err.println("Error obtenerId_descripcion: " + e.getMessage());
        }
        return 0;
    }

    public Tipodoc buscar_por_id(int id) {
        String sql = "SELECT * FROM tipodoc WHERE id_tipodoc = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    tipodoc = new Tipodoc(
                            rs.getInt(1), rs.getString(2), rs.getInt(4),
                            rs.getInt(3), rs.getString(5),
                            rs.getInt(6), rs.getString(7)
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en buscar_por_id: " + e.getMessage());
        }
        return tipodoc;
    }

    public Tipodoc getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(Tipodoc tipodoc) {
        this.tipodoc = tipodoc;
    }
}
