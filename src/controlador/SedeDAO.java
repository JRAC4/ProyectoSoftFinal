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
import modelos.Sede;
import utilidades.ConfigGeneral;

/**
 *
 * @author frank
 */
public class SedeDAO{

    private Sede sede;
    ConfigGeneral config = new ConfigGeneral();

    
    public List<Sede> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Sede> listaArray = new ArrayList<Sede>();
        try {
            con = Conexion.getConexion();
            pst = con.prepareStatement("Select * from sede where estado='1' order by descripcion");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_sede = rs.getInt(1);
                String descripcion = rs.getString(2);
                String direccion = rs.getString(3);
                String celular = rs.getString(4);
                String ruc = rs.getString(5);
                String email_origen = rs.getString(6);
                String foto = rs.getString(7);
                int estado = rs.getInt(8);
                String serie_boleta = rs.getString(9);
                String serie_factura = rs.getString(10);
                listaArray.add(new Sede(id_sede, descripcion, direccion, celular, ruc,
                        email_origen, foto, estado,serie_boleta,serie_factura));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar listar" + e);
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

    
   public List<Sede> listarCnt(String dato, int cnt) {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();
    ArrayList<Sede> listaArray = new ArrayList<>();
    try {
        con = Conexion.getConexion();
        String sql = "SELECT * FROM sede WHERE descripcion LIKE ? AND estado = 1 "
                   + "ORDER BY descripcion OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
        pst = con.prepareStatement(sql);
        pst.setString(1, "%" + dato + "%");
        pst.setInt(2, cnt);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id_sede = rs.getInt(1);
            String descripcion = rs.getString(2);
            String direccion = rs.getString(3);
            String celular = rs.getString(4);
            String ruc = rs.getString(5);
            String email_origen = rs.getString(6);
            String foto = rs.getString(7);
            int estado = rs.getInt(8);
            String serie_boleta = rs.getString(9);
            String serie_factura = rs.getString(10);

            listaArray.add(new Sede(id_sede, descripcion, direccion, celular, ruc,
                                     email_origen, foto, estado, serie_boleta, serie_factura));
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println("Error en listarCnt sede: " + e);
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos");
        }
    }
    return listaArray;
}

public void registrar(Sede obj) {
    String consulta = "INSERT INTO sede (descripcion, direccion, celular, ruc, email_origen, foto, estado, serie_boleta, serie_factura) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setString(1, obj.getDescripcion());
        ps.setString(2, obj.getDireccion());
        ps.setString(3, obj.getCelular());
        ps.setString(4, obj.getRuc());
        ps.setString(5, obj.getEmail_origen());
        ps.setString(6, obj.getFoto());
        ps.setInt(7, obj.getEstado());
        ps.setString(8, obj.getSerie_boleta());
        ps.setString(9, obj.getSerie_factura());

        ps.executeUpdate();
        System.out.println("Sede registrada correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al registrar sede: " + e.getMessage());
    }
}


    
public boolean actualizar(Sede obj) {
    try (Connection con = Conexion.getConexion()) {
        // Actualizar tabla sede
        String consultaSede = "UPDATE sede SET descripcion = ?, direccion = ?, celular = ?, ruc = ?, " +
                              "email_origen = ?, foto = ?, estado = ?, serie_boleta = ?, serie_factura = ? " +
                              "WHERE id_sede = ?";
        PreparedStatement ps1 = con.prepareStatement(consultaSede);
        ps1.setString(1, obj.getDescripcion());
        ps1.setString(2, obj.getDireccion());
        ps1.setString(3, obj.getCelular());
        ps1.setString(4, obj.getRuc());
        ps1.setString(5, obj.getEmail_origen());
        ps1.setString(6, obj.getFoto());
        ps1.setInt(7, obj.getEstado());
        ps1.setString(8, obj.getSerie_boleta());
        ps1.setString(9, obj.getSerie_factura());
        ps1.setInt(10, obj.getId_sede());

        int filasSede = ps1.executeUpdate();

        // Actualizar tabla sedeconfig
        String consultaConfig = "UPDATE sedeconfig SET sede = ? WHERE id_sede = ?";
        PreparedStatement ps2 = con.prepareStatement(consultaConfig);
        ps2.setString(1, obj.getDescripcion());
        ps2.setInt(2, obj.getId_sede());

        int filasConfig = ps2.executeUpdate();

        return filasSede > 0 && filasConfig > 0;

    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
        return false;
    }
}


    
public boolean eliminar(int id_sede) {
    String consulta = "UPDATE sede SET estado = '0' WHERE id_sede = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setInt(1, id_sede);
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;

    } catch (SQLException e) {
        System.err.println("Error al eliminar sede (estado=0): " + e.getMessage());
        return false;
    }
}


    
public boolean actualizarFoto(String foto, int id_sede) {
    String consulta = "UPDATE sede SET foto = ? WHERE id_sede = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta)) {

        ps.setString(1, foto);
        ps.setInt(2, id_sede);

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;

    } catch (SQLException e) {
        System.err.println("Error al actualizar la foto: " + e.getMessage());
        return false;
    }
}

    
 public Sede buscar_por_id(Integer id) {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();

    try {
        con = Conexion.getConexion();
        pst = con.prepareStatement("SELECT * FROM sede WHERE id_sede = ?");
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int id_sede = rs.getInt("id_sede");
            String descripcion = rs.getString("descripcion");
            String direccion = rs.getString("direccion");
            String celular = rs.getString("celular");
            String ruc = rs.getString("ruc");
            String email_origen = rs.getString("email_origen");
            String foto = rs.getString("foto");
            int estado = rs.getInt("estado");
            String serie_boleta = rs.getString("serie_boleta");
            String serie_factura = rs.getString("serie_factura");

            // Constructor con solo los campos válidos
            sede = new Sede(id_sede, descripcion, direccion, celular, ruc,
                             email_origen, foto, estado, serie_boleta, serie_factura);
        }

        rs.close();

    } catch (SQLException e) {
        System.out.println("Error en buscar_por_id: " + e);
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
        return sede;
    }


    public Sede getSedes() {
        return sede;
    }

    public void setSedes(Sede sede) {
        this.sede = sede;
    }

    
   public int obtenerId_descripcion(String descripcion) {
    int id_sede = 0;
    String sql = "SELECT id_sede FROM sede WHERE descripcion = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, descripcion);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            id_sede = rs.getInt("id_sede");
        }

        rs.close();
    } catch (SQLException e) {
        System.err.println("Error en obtenerId_descripcion: " + e.getMessage());
    }

    return id_sede;
}


    
 public String obtieneDescripcion_id(int id_sede) {
    String descripcion = "";
    String sql = "SELECT descripcion FROM sede WHERE id_sede = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id_sede);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            descripcion = rs.getString("descripcion");
        }

        rs.close();
    } catch (SQLException e) {
        System.err.println("Error en obtieneDescripcion_id: " + e.getMessage());
    }

    return descripcion;
}


    
public String obtieneEmail_origen(int id_sede) {
    String email_origen = "";
    String sql = "SELECT email_origen FROM sede WHERE id_sede = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id_sede);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            email_origen = rs.getString("email_origen");
        }

        rs.close();
    } catch (SQLException e) {
        System.err.println("Error en obtieneEmail_origen: " + e.getMessage());
    }

    return email_origen;
}

    
     
 public String obtieneSeries(int id_sede, String parametro) {
    String descripcion_serie = "";
    String campo = "";

    // Determinar el campo a consultar
    if (parametro.equalsIgnoreCase("boleta")) {
        campo = "serie_boleta";
    } else if (parametro.equalsIgnoreCase("factura")) {
        campo = "serie_factura";
    } else {
        return ""; // Parámetro no válido
    }

    String sql = "SELECT " + campo + " FROM sede WHERE id_sede = ?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id_sede);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            descripcion_serie = rs.getString(1);
        }

        rs.close();
    } catch (SQLException e) {
        System.err.println("Error en obtieneSeries: " + e.getMessage());
    }

    return descripcion_serie;
}

 public int ejecutarConsultaEntero(String consulta) {
    int resultado = 0;
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(consulta);
         ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
            resultado = rs.getInt(1);
        }
    } catch (SQLException e) {
        System.err.println("Error al ejecutar consulta: " + e.getMessage());
    }
    return resultado;
}

 

}
