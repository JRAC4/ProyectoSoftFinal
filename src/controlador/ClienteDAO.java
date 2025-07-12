package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Cliente;

public class ClienteDAO {

    private Cliente cliente;

    public List<Cliente> listarCnt(String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Cliente> listaArray = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            String sql = "SELECT TOP (?) * FROM cliente WHERE estado='1' AND id_sede=? AND ("
                    + "nomcompleto LIKE ? OR num_documento LIKE ? OR celular LIKE ? OR email LIKE ?) "
                    + "ORDER BY id_cliente DESC";
            pst = con.prepareStatement(sql);
            pst.setInt(1, cnt);
            pst.setInt(2, id_sedes);
            for (int i = 3; i <= 6; i++) pst.setString(i, "%" + dato + "%");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listaArray.add(new Cliente(
                    rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getInt(7), rs.getString(8), rs.getInt(9),
                    rs.getInt(10), rs.getString(11), rs.getInt(12)
                ));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Cliente: " + e.getMessage());
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión");
            }
        }
        return listaArray;
    }

    public void registrar(Cliente obj) {
        String sql = "INSERT INTO cliente (tipodoc, num_documento, direccion, celular, email, estado, nomcompleto, id_usuario, id_sede, observacion, id_tipodoc) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, obj.getTipodoc());
            pst.setString(2, obj.getNum_documento());
            pst.setString(3, obj.getDireccion());
            pst.setString(4, obj.getCelular());
            pst.setString(5, obj.getEmail());
            pst.setInt(6, obj.getEstado());
            pst.setString(7, obj.getNomcompleto());
            pst.setInt(8, obj.getId_usuario());
            pst.setInt(9, obj.getId_sede());
            pst.setString(10, obj.getObservacion());
            pst.setInt(11, obj.getId_tipodoc());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar cliente: " + e);
        }
    }

    public void actualizar(Cliente obj) {
        String sql = "UPDATE cliente SET tipodoc=?, num_documento=?, direccion=?, celular=?, email=?, nomcompleto=?, id_usuario=?, id_sede=?, observacion=?, id_tipodoc=? "
                   + "WHERE id_cliente=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, obj.getTipodoc());
            pst.setString(2, obj.getNum_documento());
            pst.setString(3, obj.getDireccion());
            pst.setString(4, obj.getCelular());
            pst.setString(5, obj.getEmail());
            pst.setString(6, obj.getNomcompleto());
            pst.setInt(7, obj.getId_usuario());
            pst.setInt(8, obj.getId_sede());
            pst.setString(9, obj.getObservacion());
            pst.setInt(10, obj.getId_tipodoc());
            pst.setInt(11, obj.getId_cliente());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e);
        }
    }

    public void actualizarFoto(String foto, int id_cliente) {
        String sql = "UPDATE cliente SET foto=? WHERE id_cliente=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, foto);
            pst.setInt(2, id_cliente);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar foto: " + e);
        }
    }

    public void actualizarCorreo(String email, int id_cliente) {
        String sql = "UPDATE cliente SET email=? WHERE id_cliente=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, email);
            pst.setInt(2, id_cliente);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar correo: " + e);
        }
    }

    public void eliminar(int id, int id_usuarios, int id_sedes) {
        String sql = "UPDATE cliente SET estado='0' WHERE id_cliente=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e);
        }
    }

    public Cliente buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        try {
            con = Conexion.getConexion();
            String sql = "SELECT * FROM cliente WHERE id_cliente=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                    rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getInt(7), rs.getString(8), rs.getInt(9),
                    rs.getInt(10), rs.getString(11), rs.getInt(12)
                );
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en buscar_por_id: " + e);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión");
            }
        }
        return cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int obtenerId_descripcion(String nomcompleto) {
        int id_cliente = 0;
        String sql = "SELECT id_cliente FROM cliente WHERE nomcompleto=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nomcompleto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id_cliente = rs.getInt("id_cliente");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("error obtenerId_nomcompleto: " + e.getMessage());
        }
        return id_cliente;
    }

    public String obtieneDescripcion_id(int id_cliente) {
        String nombre = "";
        String sql = "SELECT nomcompleto FROM cliente WHERE id_cliente=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id_cliente);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nomcompleto");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("error obtieneDescripcion_id: " + e.getMessage());
        }
        return nombre;
    }

    public String obtieneDatosCliente(String campo, String documento) {
        String dato = "";
        String sql = "SELECT " + campo + " FROM cliente WHERE num_documento=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, documento);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString(campo);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("error obtieneDatosCliente: " + e.getMessage());
        }
        return dato;
    }

    public boolean validaCliente(String num_documento) {
        boolean existe = false;
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        try {
            con = Conexion.getConexion();
            String sql = "SELECT id_cliente FROM cliente WHERE num_documento=? AND estado='1'";
            pst = con.prepareStatement(sql);
            pst.setString(1, num_documento);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                existe = true;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en validaCliente: " + e);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión");
            }
        }
        return existe;
    }
    
    public Cliente Buscarcliente(String dni) {
    Cliente cl = new Cliente();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Conexion cn = new Conexion(); // Asegúrate que esta clase devuelve conexión a SQL Server

    String sql = "SELECT * FROM cliente WHERE num_documento = ?";
    try {
        con = cn.getConexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        rs = ps.executeQuery();
        if (rs.next()) {
            cl.setId_cliente(rs.getInt("id_cliente"));
            cl.setNomcompleto(rs.getString("nomcompleto"));
            cl.setCelular(rs.getString("celular"));
            cl.setDireccion(rs.getString("direccion"));
            // Puedes agregar más campos si quieres
        }
    } catch (SQLException e) {
        System.out.println("Error en Buscarcliente: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
    return cl;
}

    
    
}
