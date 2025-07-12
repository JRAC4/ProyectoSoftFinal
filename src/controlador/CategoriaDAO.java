package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Categoria;
import utilidades.ConfigGeneral;

public class CategoriaDAO {

    private Categoria categoria;
    ConfigGeneral config = new ConfigGeneral();

    public List<Categoria> listar(int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Categoria> listaArray = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            String sql = "SELECT * FROM categoria WHERE estado='1' AND id_sede=? ORDER BY descripcion";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id_sedes);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id_categoria = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                listaArray.add(new Categoria(id_categoria, descripcion, estado, id_usuario, id_sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Categoria: " + e);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e);
            }
        }
        return listaArray;
    }

    public List<Categoria> listarCnt(String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Categoria> listaArray = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            String sql = "SELECT TOP (?) * FROM categoria WHERE estado='1' AND descripcion LIKE ? AND id_sede=? ORDER BY id_categoria DESC";
            pst = con.prepareStatement(sql);
            pst.setInt(1, cnt);
            pst.setString(2, "%" + dato + "%");
            pst.setInt(3, id_sedes);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id_categoria = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                listaArray.add(new Categoria(id_categoria, descripcion, estado, id_usuario, id_sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listarCnt Categoria: " + e);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e);
            }
        }
        return listaArray;
    }

    public void registrar(Categoria obj) {
        String sql = "INSERT INTO categoria(descripcion, estado, id_usuario, id_sede) VALUES (?, ?, ?, ?)";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, obj.getDescripcion());
            pst.setInt(2, obj.getEstado());
            pst.setInt(3, obj.getId_usuario());
            pst.setInt(4, obj.getId_sede());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar categoria: " + e);
        }
    }

    public void actualizar(Categoria obj) {
        String sql = "UPDATE categoria SET descripcion=?, id_usuario=?, id_sede=? WHERE id_categoria=?";
        String sqlProducto = "UPDATE producto_listado SET descripcion_categoria=? WHERE id_categoria=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql);
             PreparedStatement pst2 = con.prepareStatement(sqlProducto)) {

            pst.setString(1, obj.getDescripcion());
            pst.setInt(2, obj.getId_usuario());
            pst.setInt(3, obj.getId_sede());
            pst.setInt(4, obj.getId_categoria());
            pst.executeUpdate();

            pst2.setString(1, obj.getDescripcion());
            pst2.setInt(2, obj.getId_categoria());
            pst2.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar categoria: " + e);
        }
    }

    public void eliminar(int id, int id_usuarios, int id_sedes) {
        String sql = "UPDATE categoria SET estado='0' WHERE id_categoria=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria: " + e);
        }
    }

    public int obtenerId_descripcion(String descripcion) {
        int id_categoria = 0;
        String sql = "SELECT id_categoria FROM categoria WHERE descripcion=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, descripcion);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id_categoria = rs.getInt("id_categoria");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error en obtenerId_descripcion: " + e.getMessage());
        }
        return id_categoria;
    }

    public String obtieneDescripcion_id(int id_categoria) {
        String descripcion = "";
        String sql = "SELECT descripcion FROM categoria WHERE id_categoria=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id_categoria);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                descripcion = rs.getString("descripcion");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error en obtieneDescripcion_id: " + e.getMessage());
        }
        return descripcion;
    }

    public Categoria buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        try {
            con = Conexion.getConexion();
            String sql = "SELECT * FROM categoria WHERE id_categoria=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id_categoria = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                categoria = new Categoria(id_categoria, descripcion, estado, id_usuario, id_sede);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en buscar_por_id: " + e);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e.getMessage());
            }
        }
        return categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}