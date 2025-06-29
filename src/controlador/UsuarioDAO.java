/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import conexion.Conexion;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Usuario;
import utilidades.ConfigGeneral;
import utilidades.encriptar;

/**
 *
 * @author frank
 */
public class UsuarioDAO{

    private Usuario usuario;
    ConfigGeneral config = new ConfigGeneral();

    
    public List<Usuario> listar() {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();
    ArrayList<Usuario> listaArray = new ArrayList<>();

    try {
        con = Conexion.getConexion();
        pst = con.prepareStatement("SELECT * FROM usuario WHERE estado = '1' ORDER BY usuario");

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id_usuario = rs.getInt(1);
            String usu = rs.getString(2);
            String password = rs.getString(3);
            int estado = rs.getInt(4);
            int id_perfil = rs.getInt(5);
            int id_sede = rs.getInt(6);
            listaArray.add(new Usuario(id_usuario, usu, password, estado, id_perfil, id_sede));
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println("Error en listar: " + e);
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

    
    public List<Usuario> listarCntDes(String dato, int cnt) {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();
    ArrayList<Usuario> listaArray = new ArrayList<>();

    try {
        con = Conexion.getConexion();
        String sql = "SELECT * FROM usuario WHERE estado = '1' AND usuario LIKE ? "
                   + "ORDER BY id_usuario DESC OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
        pst = con.prepareStatement(sql);
        pst.setString(1, "%" + dato + "%");
        pst.setInt(2, cnt);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id_usuario = rs.getInt(1);
            String usu = rs.getString(2);
            String password = rs.getString(3);
            int estado = rs.getInt(4);
            int id_perfil = rs.getInt(5);
            int id_sede = rs.getInt(6);
            listaArray.add(new Usuario(id_usuario, usu, password, estado, id_perfil, id_sede));
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println("Error en listarCntDes: " + e);
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

    
    public List<Usuario> listarCnt(String dato, int cnt) {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();
    ArrayList<Usuario> listaArray = new ArrayList<>();

    try {
        con = Conexion.getConexion();
        String sql = "SELECT * FROM usuario WHERE estado = '1' AND usuario LIKE ? AND usuario != 'SISTEMA' "
                   + "ORDER BY id_usuario DESC OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
        pst = con.prepareStatement(sql);
        pst.setString(1, "%" + dato + "%");
        pst.setInt(2, cnt);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id_usuario = rs.getInt(1);
            String usu = rs.getString(2);
            String password = rs.getString(3);
            int estado = rs.getInt(4);
            int id_perfil = rs.getInt(5);
            int id_sede = rs.getInt(6);
            listaArray.add(new Usuario(id_usuario, usu, password, estado, id_perfil, id_sede));
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println("Error en listarCnt: " + e);
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

    
public void registrar(Usuario obj) {
    String consulta = "INSERT INTO usuario (usuario, estado, password, id_perfil, id_sede) "
                    + "VALUES (?, ?, ?, ?, ?)";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setString(1, obj.getUsuario());
        ps.setInt(2, obj.getEstado());
        ps.setString(3, encriptar.encriptarPassword(obj.getPassword())); // Encriptado en Java
        ps.setInt(4, obj.getId_perfil());
        ps.setInt(5, obj.getId_sede());

        ps.executeUpdate();
        System.out.println("Usuario registrado correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al registrar usuario: " + e.getMessage());
    }
}



    
public void actualizar(Usuario obj) {
    String consulta = "UPDATE usuario SET usuario = ?, password = ?, id_perfil = ?, id_sede = ? "
                    + "WHERE id_usuario = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setString(1, obj.getUsuario());
        ps.setString(2, encriptar.encriptarPassword(obj.getPassword())); // Encriptado en Java
        ps.setInt(3, obj.getId_perfil());
        ps.setInt(4, obj.getId_sede());
        ps.setInt(5, obj.getId_usuario());

        ps.executeUpdate();
        System.out.println("Usuario actualizado correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al actualizar usuario: " + e.getMessage());
    }
}


public void eliminar(int id_usuario) {
    String consulta = "UPDATE usuario SET estado = '0' WHERE id_usuario = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setInt(1, id_usuario);
        ps.executeUpdate();
        System.out.println("Usuario dado de baja correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al eliminar usuario: " + e.getMessage());
    }
}


    
public int obtenerId_descripcion(String usuario) {
    int id_usuario = 0;
    String sql = "SELECT id_usuario FROM usuario WHERE usuario = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            id_usuario = rs.getInt("id_usuario");
        }

        rs.close();
    } catch (SQLException e) {
        System.err.println("Error en obtenerId_descripcion: " + e.getMessage());
    }

    return id_usuario;
}


    
  public String obtenerUsuarioporId(int id_usuario) {
    String usuario = "";
    String sql = "SELECT usuario FROM usuario WHERE id_usuario = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id_usuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            usuario = rs.getString("usuario");
        }

        rs.close();
    } catch (SQLException e) {
        System.err.println("Error en obtenerUsuarioporId: " + e.getMessage());
    }

    return usuario;
}


    
public int obtenerId_descripcionSede(String usuario) {
    int id_sede = 0;
    String sql = "SELECT id_sede FROM usuario WHERE usuario = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            id_sede = rs.getInt("id_sede");
        }

        rs.close();
    } catch (SQLException e) {
        System.err.println("Error en obtenerId_descripcionSede: " + e.getMessage());
    }

    return id_sede;
}

    
 public Usuario buscar_por_id(Integer id) {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();
    Usuario usuario = null;

    try {
        con = Conexion.getConexion();
        pst = con.prepareStatement("SELECT id_usuario, usuario, password, estado, id_perfil, id_sede FROM usuario WHERE id_usuario = ?");

        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int id_usuario = rs.getInt("id_usuario");
            String usu = rs.getString("usuario");
            String password = rs.getString("password"); // SHA-256 en Base64
            int estado = rs.getInt("estado");
            int id_perfil = rs.getInt("id_perfil");
            int id_sede = rs.getInt("id_sede");
            usuario = new Usuario(id_usuario, usu, password, estado, id_perfil, id_sede);
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

    return usuario;
}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
public boolean validaUsuario(String usuario, String password) {
    String sql = "SELECT id_usuario FROM usuario WHERE usuario = ? AND password = ? AND estado = '1'";

    try (Connection con = Conexion.getConexion();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, usuario);
        pst.setString(2, encriptar.encriptarPassword(password)); // Reutiliza la misma lógica de encriptación
        ResultSet rs = pst.executeQuery();
        boolean existe = rs.next(); // Si hay algún resultado, el usuario y la contraseña coinciden
        rs.close();
        return existe;

    } catch (SQLException e) {
        System.out.println("Error en la conexión: " + e.getMessage());
    }

    return false;
}


    
public int obtenerId_perfil(int id_usuario) {
    int id_perfil = 0;
    String sql = "SELECT id_perfil FROM usuario WHERE id_usuario = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id_usuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            id_perfil = rs.getInt("id_perfil");
        }

        rs.close();
    } catch (SQLException e) {
        System.err.println("Error en obtenerId_perfil: " + e.getMessage());
    }

    return id_perfil;
}
}
