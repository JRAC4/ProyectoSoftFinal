package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Marca;
import utilidades.ConfigGeneral;

public class MarcaDAO {

    private Marca marca;
    ConfigGeneral config = new ConfigGeneral();

    public List<Marca> listar(int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Marca> listaArray = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            String sql = "SELECT * FROM marca WHERE estado='1' AND id_sede=? ORDER BY descripcion";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id_sedes);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id_marca = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                listaArray.add(new Marca(id_marca, descripcion, estado, id_usuario, id_sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Marca: " + e);
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

    public List<Marca> listarCnt(String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Marca> listaArray = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            String sql = "SELECT TOP (?) * FROM marca WHERE estado='1' AND descripcion LIKE ? AND id_sede=? ORDER BY id_marca DESC";
            pst = con.prepareStatement(sql);
            pst.setInt(1, cnt);
            pst.setString(2, "%" + dato + "%");
            pst.setInt(3, id_sedes);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id_marca = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                listaArray.add(new Marca(id_marca, descripcion, estado, id_usuario, id_sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listarCnt Marca: " + e);
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

    public void registrar(Marca obj) {
        String sql = "INSERT INTO marca(descripcion, estado, id_usuario, id_sede) VALUES (?, ?, ?, ?)";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, obj.getDescripcion());
            pst.setInt(2, obj.getEstado());
            pst.setInt(3, obj.getId_usuario());
            pst.setInt(4, obj.getId_sede());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar marca: " + e);
        }
    }

    public void actualizar(Marca obj) {
        String sql = "UPDATE marca SET descripcion=?, id_usuario=?, id_sede=? WHERE id_marca=?";
        String sqlMarca = "UPDATE producto_listado SET marca_descripcion=? WHERE id_marca=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql);
             PreparedStatement pst2 = con.prepareStatement(sqlMarca)) {
            pst.setString(1, obj.getDescripcion());
            pst.setInt(2, obj.getId_usuario());
            pst.setInt(3, obj.getId_sede());
            pst.setInt(4, obj.getId_marca());
            pst.executeUpdate();

            pst2.setString(1, obj.getDescripcion());
            pst2.setInt(2, obj.getId_marca());
            pst2.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar marca: " + e);
        }
    }

    public void eliminar(int id, int id_usuarios, int id_sedes) {
        String sql = "UPDATE marca SET estado='0' WHERE id_marca=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar marca: " + e);
        }
    }

    public int obtenerId_descripcion(String descripcion) {
        int id_marca = 0;
        String sql = "SELECT id_marca FROM marca WHERE descripcion=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, descripcion);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id_marca = rs.getInt("id_marca");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error en obtenerId_descripcion: " + e.getMessage());
        }
        return id_marca;
    }

    public String obtieneDescripcion_id(int id_marca) {
        String descripcion = "";
        String sql = "SELECT descripcion FROM marca WHERE id_marca=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id_marca);
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

    public Marca buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        try {
            con = Conexion.getConexion();
            String sql = "SELECT * FROM marca WHERE id_marca=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id_marca = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                marca = new Marca(id_marca, descripcion, estado, id_usuario, id_sede);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en buscar_por_id: " + e);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e);
            }
        }
        return marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
