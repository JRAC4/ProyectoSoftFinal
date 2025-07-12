/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Cliente;

/**
 *
 * @author jesus
 */
public class ClienteDAO {
    private Cliente cliente;

    
    public List<Cliente> listarCnt(String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Cliente> listaArray = new ArrayList<Cliente>();
        try {
                 con = Conexion.getConexion();
            String sql = "SELECT TOP (?) * FROM cliente WHERE estado='1' AND id_sede=? AND ("
                       + "nomcompleto LIKE ? OR num_documento LIKE ? OR celular LIKE ? OR email LIKE ?) "
                       + "ORDER BY id_cliente DESC";
            pst = con.prepareStatement(sql);
            pst.setInt(1, cnt);
            pst.setInt(2, id_sedes);
            for (int i = 3; i <= 6; i++) {
                pst.setString(i, "%" + dato + "%");
            }

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id_cliente = rs.getInt(1);
                String tipodoc = rs.getString(2);
                String num_documento = rs.getString(3);
                String direccion = rs.getString(4);
                String celular = rs.getString(5);
                String email = rs.getString(6);
                int estado = rs.getInt(7);
                String nomcompleto = rs.getString(8);
                int id_usuario = rs.getInt(9);
                int id_sede = rs.getInt(10);
                String observacion = rs.getString(11);
                int id_tipodoc = rs.getInt(12);
                listaArray.add(new Cliente(id_cliente, tipodoc, num_documento,  direccion, celular, email,
                        estado, nomcompleto, id_usuario, id_sede,observacion,id_tipodoc));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Cliente " + e.getMessage());
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

    
   public void registrar(Cliente obj) {
    String sql = "INSERT INTO cliente(tipodoc, num_documento, direccion, celular, email, estado, "
               + "nomcompleto, id_usuario, id_sede, observacion, id_tipodoc) "
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
        System.out.println("Error al registrar cliente: " + e.getMessage());
    }
}


    
public void actualizar(Cliente obj) {
    String sql = "UPDATE cliente SET tipodoc=?, num_documento=?, direccion=?, celular=?, email=?, "
               + "nomcompleto=?, id_usuario=?, id_sede=?, observacion=?, id_tipodoc=? "
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
        System.out.println("Error al actualizar cliente: " + e.getMessage());
    }
}

    
    public void eliminar(int id, int id_usuarios, int id_sedes) {
        String sql = "UPDATE cliente SET estado='0' WHERE id_cliente=?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en eliminar cliente: " + e.getMessage());
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
            while (rs.next()) {
                int id_cliente = rs.getInt(1);
                String tipodoc = rs.getString(2);
                String num_documento = rs.getString(3);
                String direccion = rs.getString(4);
                String celular = rs.getString(5);
                String email = rs.getString(6);
                int estado = rs.getInt(7);
                String nomcompleto = rs.getString(8);
                int id_usuario = rs.getInt(9);
                int id_sede = rs.getInt(10);
                String observacion = rs.getString(11); 
                int id_tipodoc = rs.getInt(12); 
                cliente = new Cliente(id_cliente, tipodoc, num_documento,  direccion, celular, email,
                        estado, nomcompleto, id_usuario, id_sede,observacion,id_tipodoc);
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
        String sql = "SELECT id_cliente FROM cliente WHERE nomcompleto = ?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nomcompleto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id_cliente = rs.getInt("id_cliente");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error obtenerId_descripcion: " + e.getMessage());
        }
        return id_cliente;
    }

    public String obtieneDescripcion_id(int id_cliente) {
        String nomcompleto = "";
        String sql = "SELECT nomcompleto FROM cliente WHERE id_cliente = ?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id_cliente);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nomcompleto = rs.getString("nomcompleto");
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error obtieneDescripcion_id: " + e.getMessage());
        }
        return nomcompleto;
    }

    public String obtieneDatosCliente(String campo, String documento) {
        String dato = "";
        String sql = "SELECT " + campo + " FROM cliente WHERE num_documento = ?";
        try (Connection con = new Conexion().getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, documento);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error obtieneDatosCliente: " + e.getMessage());
        }
        return dato;
    }


    
    public boolean validaCliente(String num_documento) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        try {
            con = Conexion.getConexion();
           String sql = "SELECT id_cliente FROM cliente WHERE num_documento = ? AND estado = '1'";
            pst = con.prepareStatement(sql);
            pst.setString(1, num_documento);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {//recorre haver si SI HUVO REGISTRO con ese ID Y ESA CLAVE
                return true;   //retorna lo q encontro en la BD
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error en la conexión " + e);
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

        return false;
    }
    
     public Cliente Buscarcliente(String dni){
          Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
       cliente = new Cliente();
    String sql = "SELECT * FROM cliente WHERE num_documento = ?";
    try {
        con = Conexion.getConexion();
        pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        pst.setString(1, dni);  // porque num_documento es varchar
        rs = pst.executeQuery();
        if (rs.next()) {
            cliente.setId_cliente(rs.getInt("id_cliente"));
            cliente.setNomcompleto(rs.getString("nomcompleto"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setDireccion(rs.getString("direccion"));
           
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    return cliente;
   }

//         
//public void actualizarFoto(String foto, int id_cliente) {
//    String sql = "UPDATE cliente SET foto=? WHERE id_cliente=?";
//    try (Connection con = new Conexion().getConexion();
//         PreparedStatement pst = con.prepareStatement(sql)) {
//        pst.setString(1, foto);
//        pst.setInt(2, id_cliente);
//        pst.executeUpdate();
//    } catch (SQLException e) {
//        System.out.println("Error en actualizarFoto: " + e.getMessage());
//    }
//}
//
//
//    
//  public void actualizarCorreo(String email, int id_cliente) {
//        String sql = "UPDATE cliente SET email=? WHERE id_cliente=?";
//        try (Connection con = new Conexion().getConexion();
//             PreparedStatement pst = con.prepareStatement(sql)) {
//            pst.setString(1, email);
//            pst.setInt(2, id_cliente);
//            pst.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Error en actualizarCorreo: " + e.getMessage());
//        }
//    }
     
     
}
