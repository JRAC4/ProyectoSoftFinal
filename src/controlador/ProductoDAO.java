package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Producto;
import modelos.ProductoView;
import utilidades.ConfigGeneral;

public class ProductoDAO {

    private Producto producto;
    ConfigGeneral config = new ConfigGeneral();

    public List<ProductoView> listar(String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<ProductoView> listaArray = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            pst = con.prepareStatement("SELECT TOP (?) * FROM producto_listado WHERE " +
                    "((descripcion LIKE ? AND id_sede = ? AND estado = 1) " +
                    "OR (codigo LIKE ? AND id_sede = ? AND estado = 1)) ORDER BY id_producto DESC");
            pst.setInt(1, cnt);
            pst.setString(2, "%" + dato + "%");
            pst.setInt(3, id_sedes);
            pst.setString(4, "%" + dato + "%");
            pst.setInt(5, id_sedes);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductoView p = new ProductoView(
                        rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getString(12),
                        rs.getString(13), rs.getInt(14), rs.getString(15),
                        rs.getString(16), rs.getDouble(17));
                listaArray.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar: " + e);
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

    public List<Producto> listar(int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Producto> listaArray = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            pst = con.prepareStatement("SELECT * FROM producto WHERE id_sede = ? ORDER BY descripcion");
            pst.setInt(1, id_sedes);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getString(12),
                        rs.getDouble(13), rs.getInt(14));
                listaArray.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar: " + e);
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

    public void registrar(Producto obj) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = Conexion.getConexion();
            String consulta = "INSERT INTO producto (id_categoria, descripcion, codigo, precio, estado, ubicacion, " +
                    "id_usuario, id_sede, id_marca, id_igv, codigo_agrupacion, igv_agrupacion, stock) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(consulta);
            pst.setInt(1, obj.getId_categoria());
            pst.setString(2, obj.getDescripcion());
            pst.setString(3, obj.getCodigo());
            pst.setDouble(4, obj.getPrecio());
            pst.setInt(5, obj.getEstado());
            pst.setString(6, obj.getUbicacion());
            pst.setInt(7, obj.getId_usuario());
            pst.setInt(8, obj.getId_sede());
            pst.setInt(9, obj.getId_marca());
            pst.setInt(10, obj.getId_igv());
            pst.setString(11, obj.getCodigo_agrupacion());
            pst.setDouble(12, obj.getIgv_agrupacion());
            pst.setInt(13, obj.getStock());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e);
            }
        }
    }

    public void actualizar(Producto obj) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = Conexion.getConexion();
            String consulta = "UPDATE producto SET id_categoria = ?, descripcion = ?, codigo = ?, precio = ?, estado = ?, " +
                    "ubicacion = ?, id_usuario = ?, id_marca = ?, id_igv = ?, codigo_agrupacion = ?, igv_agrupacion = ?, stock = ? " +
                    "WHERE id_producto = ?";
            pst = con.prepareStatement(consulta);
            pst.setInt(1, obj.getId_categoria());
            pst.setString(2, obj.getDescripcion());
            pst.setString(3, obj.getCodigo());
            pst.setDouble(4, obj.getPrecio());
            pst.setInt(5, obj.getEstado());
            pst.setString(6, obj.getUbicacion());
            pst.setInt(7, obj.getId_usuario());
            pst.setInt(8, obj.getId_marca());
            pst.setInt(9, obj.getId_igv());
            pst.setString(10, obj.getCodigo_agrupacion());
            pst.setDouble(11, obj.getIgv_agrupacion());
            pst.setInt(12, obj.getStock());
            pst.setInt(13, obj.getId_producto());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e);
            }
        }
    }

    public void actualizarPrecio(int id_producto, double precio) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = Conexion.getConexion();
            String consulta = "UPDATE producto SET precio = ? WHERE id_producto = ?";
            pst = con.prepareStatement(consulta);
            pst.setDouble(1, precio);
            pst.setInt(2, id_producto);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar precio: " + e);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e);
            }
        }
    }

    public void eliminar(int id, int id_usuarios, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = Conexion.getConexion();
            String consulta = "UPDATE producto SET estado = 0 WHERE id_producto = ?";
            pst = con.prepareStatement(consulta);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e);
            }
        }
    }

    public Producto buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        try {
            con = Conexion.getConexion();
            pst = con.prepareStatement("SELECT * FROM producto WHERE id_producto = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                producto = new Producto(
                        rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getString(12),
                        rs.getDouble(13), rs.getInt(14));
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
        return producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int obtenerId_descripcion(String descripcion) {
        int id_producto = 0;
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT id_producto FROM producto WHERE descripcion = ?")) {
            pst.setString(1, descripcion);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id_producto = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("error obtenerId_descripcion: " + e.getLocalizedMessage());
        }
        return id_producto;
    }

    public String obtieneDescripcion_id(int id_producto) {
        String descripcion = "";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT descripcion FROM producto WHERE id_producto = ?")) {
            pst.setInt(1, id_producto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                descripcion = rs.getString(1);
            }
        } catch (SQLException e) {
            System.err.println("error obtieneDescripcion_id: " + e.getLocalizedMessage());
        }
        return descripcion;
    }

    public double obtienePrecio_id(int id_producto) {
        double precio = 0;
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT precio FROM producto WHERE id_producto = ?")) {
            pst.setInt(1, id_producto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                precio = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.err.println("error obtienePrecio_id: " + e.getLocalizedMessage());
        }
        return precio;
    }

    public int obtenerId_codigo(String codigo) {
        int id_producto = 0;
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT id_producto FROM producto WHERE codigo = ?")) {
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id_producto = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("error obtenerId_codigo: " + e.getLocalizedMessage());
        }
        return id_producto;
    }

    public double obtieneIGV(int id_producto) {
        double igv_agrupacion = 0;
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT igv_agrupacion FROM producto WHERE id_producto = ?")) {
            pst.setInt(1, id_producto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                igv_agrupacion = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.err.println("error obtieneIGV: " + e.getLocalizedMessage());
        }
        return igv_agrupacion;
    }

    public String obtieneCodigoGrupoIGV(int id_producto) {
        String codigo_agrupacion = "";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement("SELECT codigo_agrupacion FROM producto WHERE id_producto = ?")) {
            pst.setInt(1, id_producto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                codigo_agrupacion = rs.getString(1);
            }
        } catch (SQLException e) {
            System.err.println("error obtieneCodigoGrupoIGV: " + e.getLocalizedMessage());
        }
        return codigo_agrupacion;
    } 
//    
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Producto BuscarPro(String cod){
        
        Producto producto = new Producto();
        String sql = "SELECT * FROM producto WHERE id_producto = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }
    
    public Producto BuscarId(int id){
        Producto pro = new Producto();
        String sql = "SELECT m.id_marca AS id_marca, m.descripcion AS nombre_marca, p.* FROM producto p INNER JOIN marca m ON p.id_marca = m.id_marca WHERE p.id_producto = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId_producto(rs.getInt("id_producto"));
                
                pro.setCodigo(rs.getString("codigo")); // Si es String en la BD
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setId_marca(rs.getInt("id_marca"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getDouble("precio"));

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pro;
    }
}
