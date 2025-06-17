/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

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

/**
 *
 * @author frank
 */
public class UsuarioDAO extends SQL{

    private Usuario usuario;

    public List<Usuario> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        conexion conectar = new conexion();
        ArrayList<Usuario> listaArray = new ArrayList<Usuario>();
        try {
            con = conectar.getConecxion();
            pst = con.prepareStatement("select * from usuario where estado='1'  "
                    + "  order by usuario");

            ResultSet rs = pst.executeQuery();//si hay consulta 
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
            System.out.println("Error en listar Cnt_carga" + e);
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

    public List<Usuario> listarCntDes(String dato, int cnt) {
        Connection con = null;
        PreparedStatement pst = null;
        conexion conectar = new conexion();
        ArrayList<Usuario> listaArray = new ArrayList<Usuario>();
        try {
            con = conectar.getConecxion();
            pst = con.prepareStatement("select * from usuario where estado='1' "
                    + " and usuario  like '%" + dato + "%'  "
                    + "  order by id_usuario desc limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
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
            System.out.println("Error en listar Cnt_carga" + e);
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

    public List<Usuario> listarCnt(String dato, int cnt) {
        Connection con = null;
        PreparedStatement pst = null;
        Conexion conectar = new Conexion();
        ArrayList<Usuario> listaArray = new ArrayList<Usuario>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from usuario where estado='1' "
                    + " and usuario  like '%" + dato + "%' and usuario!='SISTEMA' "
                    + "  order by id_usuario desc limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
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
            System.out.println("Error en listar Cnt_carga" + e);
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

    public void registrar(Usuario obj) {
        String consulta = "INSERT INTO usuario(usuario, estado,password ,id_perfil,id_sede) "
                + "VALUES ('" + obj.getUsuario() + "','" + obj.getEstado() + "',"
                + "AES_ENCRYPT('" + obj.getPassword() + "','linePasswordcodex'),"
                + "'" + obj.getId_perfil() + "','" + obj.getId_sede() + "')";
        grabarTabla(consulta);

    }

    public void actualizar(Usuario obj) {
        String consulta = "UPDATE usuario SET usuario='" + obj.getUsuario() + "',"
                + " password=AES_ENCRYPT('" + obj.getPassword() + "','linePasswordcodex'), "
                + "id_perfil='" + obj.getId_perfil() + "',id_sede='" + obj.getId_sede() + "' "
                + " WHERE id_usuario='" + obj.getId_usuario() + "'";
        actualizaTabla(consulta);

    }

    public void eliminar(int id_usuario) {
        String consulta = "UPDATE usuario SET estado='0' "
                + "WHERE id_usuario='" + id_usuario + "'";
        actualizaTabla(consulta);

    }

    public int obtenerId_descripcion(String usuario) {
        int id_sede = 0;

        try {
            id_sede = obtenerEntero("Select id_usuario from usuario where usuario='" + usuario + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return id_sede;
    }

    public String obtenerUsuarioporId(int id_usuario) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select usuario from usuario where id_usuario='" + id_usuario + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    public int obtenerId_descripcionSede(String usuario) {
        int id_sede = 0;

        try {
            id_sede = obtenerEntero("Select id_sede from usuario where `usuario`='" + usuario + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return id_sede;
    }

    public Usuario buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        conexion conectar = new conexion();
        try {
            con = conectar.getConecxion();
            pst = con.prepareStatement("select id_usuario,usuario,"
                    + "AES_DECRYPT(password, 'linePasswordcodex') as password,estado,"
                    + "id_perfil,id_sede from usuario where id_usuario='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_usuario = rs.getInt(1);
                String usu = rs.getString(2);
                String password = rs.getString(3);
                int estado = rs.getInt(4);
                int id_perfil = rs.getInt(5);
                int id_sede = rs.getInt(6);
                usuario = new Usuario(id_usuario, usu, password, estado, id_perfil, id_sede);
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
        return usuario;
    }

    public Usuario getObUsuario() {
        return usuario;
    }

    public void setObUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean validaUsuario(String usuario, String password) {
        Connection con = null;
        PreparedStatement pst = null;
        conexion conectar = new conexion();
        try {
            con = conectar.getConecxion();
            String sql = "select id_usuario,usuario,password,id_sede from usuario where "
                    + " usuario='" + usuario + "' and "
                    + " AES_DECRYPT(password, 'linePasswordcodex')='" + password + "' "
                    + " and estado='1'";
            pst = con.prepareStatement(sql);
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


    public int obtenerId_perfil(int id_usuario) {
        int id_perfil = 0;

        try {
            id_perfil = obtenerEntero("Select id_perfil from usuario where id_usuario='" + id_usuario + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return id_perfil;
    }
}
