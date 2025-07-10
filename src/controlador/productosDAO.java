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
import modelos.Producto;

/**
 *
 * @author jesus
 */
public class productosDAO {
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
                producto.setDescrip(rs.getString("descripcion"));
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
                
                pro.setCodig(rs.getString("codigo")); // Si es String en la BD
                pro.setDescrip(rs.getString("descripcion"));
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
