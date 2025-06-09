/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jesus
 */
public class clienteDAO {
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    public cliente Buscarcliente(String dni){
       cliente cl = new cliente();
    String sql = "SELECT * FROM cliente WHERE num_documento = ?";
    try {
        con = cn.getConecxion();
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);  // porque num_documento es varchar
        rs = ps.executeQuery();
        if (rs.next()) {
            cl.setIdcliente(rs.getInt("id_cliente"));
            cl.setNombre(rs.getString("nomcompleto"));
            cl.setCelular(rs.getString("celular"));
            cl.setDireccion(rs.getString("direccion"));
            // Puedes agregar más campos si quieres: email, estado, etc.
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    return cl;
   }
}
