package controlador;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelos.GrupoIgv;
import utilidades.ConfigGeneral;

public class GrupoIgvDAO {

    private GrupoIgv fac_grupo_igv;
    ConfigGeneral config = new ConfigGeneral();

    public List<GrupoIgv> listar() {
        List<GrupoIgv> lista = new ArrayList<>();
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(
                     "SELECT * FROM grupo_igv WHERE estado_view = 1 ORDER BY descripcion");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new GrupoIgv(
                        rs.getInt("id_grupo_igv"),
                        rs.getString("codigo"),
                        rs.getString("descripcion"),
                        rs.getDouble("igv"),
                        rs.getInt("estado_view")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error en listar: " + e.getMessage());
        }
        return lista;
    }

    public List<GrupoIgv> listarCnt(String dato, int limite) {
        List<GrupoIgv> lista = new ArrayList<>();
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(
                     "SELECT * FROM grupo_igv WHERE descripcion LIKE ? OR codigo LIKE ? " +
                     "ORDER BY descripcion OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY")) {
            pst.setString(1, "%" + dato + "%");
            pst.setString(2, "%" + dato + "%");
            pst.setInt(3, limite);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    lista.add(new GrupoIgv(
                            rs.getInt("id_grupo_igv"),
                            rs.getString("codigo"),
                            rs.getString("descripcion"),
                            rs.getDouble("igv"),
                            rs.getInt("estado_view")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en listarCnt: " + e.getMessage());
        }
        return lista;
    }

    public void registrar(GrupoIgv obj) {
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(
                     "INSERT INTO grupo_igv (codigo, descripcion, igv, estado_view) VALUES (?, ?, ?, ?)")) {
            pst.setString(1, obj.getCodigo());
            pst.setString(2, obj.getDescripcion());
            pst.setDouble(3, obj.getIgv());
            pst.setInt(4, obj.getEstado_view());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en registrar: " + e.getMessage());
        }
    }

    public void actualizar(GrupoIgv obj) {
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(
                     "UPDATE grupo_igv SET codigo = ?, descripcion = ?, igv = ?, estado_view = ? WHERE id_grupo_igv = ?")) {
            pst.setString(1, obj.getCodigo());
            pst.setString(2, obj.getDescripcion());
            pst.setDouble(3, obj.getIgv());
            pst.setInt(4, obj.getEstado_view());
            pst.setInt(5, obj.getId_grupo_igv());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en actualizar: " + e.getMessage());
        }
    }

    public void actualizarActivar(int id_grupo_igv) {
        cambiarEstado(id_grupo_igv, 1);
    }

    public void actualizarDesactivar(int id_grupo_igv) {
        cambiarEstado(id_grupo_igv, 0);
    }

    private void cambiarEstado(int id, int estado) {
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(
                     "UPDATE grupo_igv SET estado_view = ? WHERE id_grupo_igv = ?")) {
            pst.setInt(1, estado);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al cambiar estado: " + e.getMessage());
        }
    }

    public void eliminar(int id_grupo_igv) {
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement("DELETE FROM grupo_igv WHERE id_grupo_igv = ?")) {
            pst.setInt(1, id_grupo_igv);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en eliminar: " + e.getMessage());
        }
    }

    public GrupoIgv buscar_por_id(Integer id) {
        GrupoIgv resultado = null;
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM grupo_igv WHERE id_grupo_igv = ?")) {
            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    resultado = new GrupoIgv(
                            rs.getInt("id_grupo_igv"),
                            rs.getString("codigo"),
                            rs.getString("descripcion"),
                            rs.getDouble("igv"),
                            rs.getInt("estado_view")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en buscar_por_id: " + e.getMessage());
        }
        return resultado;
    }

    public int obtenerId_descripcion(String descripcion) {
        int id = 0;
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT id_grupo_igv FROM grupo_igv WHERE descripcion = ?")) {
            pst.setString(1, descripcion);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en obtenerId_descripcion: " + e.getMessage());
        }
        return id;
    }

    public String obtieneDescripcion_id(int id_grupo_igv) {
        return obtenerCampoTexto("descripcion", id_grupo_igv);
    }

    public String obtieneCodigo_id(int id_grupo_igv) {
        return obtenerCampoTexto("codigo", id_grupo_igv);
    }

    public double obtieneIGV_id(int id_grupo_igv) {
        double valor = 0;
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT igv FROM grupo_igv WHERE id_grupo_igv = ?")) {
            pst.setInt(1, id_grupo_igv);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    valor = rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en obtieneIGV_id: " + e.getMessage());
        }
        return valor;
    }

    private String obtenerCampoTexto(String campo, int id) {
        String valor = "";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT " + campo + " FROM grupo_igv WHERE id_grupo_igv = ?")) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    valor = rs.getString(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en obtenerCampoTexto (" + campo + "): " + e.getMessage());
        }
        return valor;
    }

    public GrupoIgv getObFac_cat7() {
        return fac_grupo_igv;
    }

    public void setObFac_cat7(GrupoIgv fac_grupo_igv) {
        this.fac_grupo_igv = fac_grupo_igv;
    }
}
