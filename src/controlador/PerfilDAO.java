package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Perfil;
import utilidades.ConfigGeneral;

/**
 *
 * @author frank
 */
public class PerfilDAO{

    private Perfil perfil;
    ConfigGeneral config = new ConfigGeneral();

    
    public List<Perfil> listarSinDes() {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Perfil> listaArray = new ArrayList<Perfil>();
        try {
            con = Conexion.getConexion();
           pst = con.prepareStatement("SELECT * FROM perfil WHERE estado = 1 " +
        "AND descripcion != 'DESARROLLADOR' ORDER BY id_perfil ASC");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_perfil = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                listaArray.add(new Perfil(id_perfil, descripcion, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Perfil" + e);
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

    
    public List<Perfil> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Perfil> listaArray = new ArrayList<Perfil>();
        try {
            con = Conexion.getConexion();
           pst = con.prepareStatement("SELECT * FROM perfil WHERE estado = 1 ORDER BY id_perfil ASC");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_perfil = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                listaArray.add(new Perfil(id_perfil, descripcion, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Perfil" + e);
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

    
    public List<Perfil> listarCnt(String dato, int cnt) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Perfil> listaArray = new ArrayList<Perfil>();
        try {
            con = Conexion.getConexion();
pst = con.prepareStatement("SELECT * FROM perfil WHERE estado = 1 " +
        "AND descripcion LIKE ? ORDER BY id_perfil DESC OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY");
pst.setString(1, "%" + dato + "%");
pst.setInt(2, cnt);
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_perfil = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                listaArray.add(new Perfil(id_perfil, descripcion, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Perfil" + e);
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

    
    public List<Perfil> listarCntSinDes(String dato, int cnt) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        ArrayList<Perfil> listaArray = new ArrayList<Perfil>();
        try {
            con = Conexion.getConexion();
pst = con.prepareStatement("SELECT * FROM perfil WHERE estado = 1 " +
        "AND descripcion LIKE ? AND descripcion != 'DESARROLLADOR' " +
        "ORDER BY id_perfil DESC OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY");
pst.setString(1, "%" + dato + "%");
pst.setInt(2, cnt);
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_perfil = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                listaArray.add(new Perfil(id_perfil, descripcion, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Perfil" + e);
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

    
public void registrar(Perfil obj) {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();
    try {
        con = Conexion.getConexion();
        String consulta = "INSERT INTO perfil(descripcion, estado) VALUES (?, ?)";
        pst = con.prepareStatement(consulta);
        pst.setString(1, obj.getDescripcion());
        pst.setInt(2, obj.getEstado());
        pst.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error en registrar: " + e);
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar");
        }
    }
}

    
 public void actualizar(Perfil obj) {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();
    try {
        con = Conexion.getConexion();
        String consulta = "UPDATE perfil SET descripcion = ? WHERE id_perfil = ?";
        pst = con.prepareStatement(consulta);
        pst.setString(1, obj.getDescripcion());
        pst.setInt(2, obj.getId_perfil());
        pst.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error en actualizar: " + e);
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar");
        }
    }
}

    
public void eliminar(int id) {
    Connection con = null;
    PreparedStatement pst = null;
    Conexion Conexion = new Conexion();
    try {
        con = Conexion.getConexion();
        String consulta = "UPDATE perfil SET estado = 0 WHERE id_perfil = ?";
        pst = con.prepareStatement(consulta);
        pst.setInt(1, id);
        pst.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error en eliminar: " + e);
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar");
        }
    }
}

    
public int obtenerId_descripcion(String descripcion) {
    int id_perfil = 0;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Conexion Conexion = new Conexion();
    try {
        con = Conexion.getConexion();
        String sql = "SELECT id_perfil FROM perfil WHERE descripcion = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, descripcion);
        rs = pst.executeQuery();
        if (rs.next()) {
            id_perfil = rs.getInt("id_perfil");
        }
    } catch (SQLException e) {
        System.err.println("Error obtenerId_descripcion: " + e.getLocalizedMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar");
        }
    }
    return id_perfil;
}

    
 public String obtieneDescripcion_id(int id_perfil) {
    String descripcion = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Conexion Conexion = new Conexion();
    try {
        con = Conexion.getConexion();
        String sql = "SELECT descripcion FROM perfil WHERE id_perfil = ?";
        pst = con.prepareStatement(sql);
        pst.setInt(1, id_perfil);
        rs = pst.executeQuery();
        if (rs.next()) {
            descripcion = rs.getString("descripcion");
        }
    } catch (SQLException e) {
        System.err.println("Error obtieneDescripcion_id: " + e.getLocalizedMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar");
        }
    }
    return descripcion;
}

    
    public Perfil buscar_por_id(Integer id) {
        Connection con = null;
        ResultSet rs= null;
        PreparedStatement pst = null;
        Conexion Conexion = new Conexion();
        try {
            con = Conexion.getConexion();
             String sql = "SELECT * FROM perfil WHERE id_perfil = ?";
        pst = con.prepareStatement(sql);
        pst.setInt(1, id);
            rs = pst.executeQuery();//si hay consulta 
            if (rs.next()) {
            int id_perfil = rs.getInt("id_perfil");
            String descripcion = rs.getString("descripcion");
            int estado = rs.getInt("estado");
            perfil = new Perfil(id_perfil, descripcion, estado);
        }
    } catch (SQLException e) {
        System.out.println("Error en buscar_por_id: " + e);
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar");
        }
    }
    return perfil;
}

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
public boolean valida_Campos(String sql) {
    try (Connection con = Conexion.getConexion();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        return rs.next(); // true si hay al menos un resultado
    } catch (SQLException e) {
        System.err.println("Error en valida_Campos: " + e.getMessage());
    }
    return false;
}



}
