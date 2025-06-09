
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
    Connection con;
    String url="jdbc:mysql://localhost:3306/bdferricov1?serverTimezone=UTC";
    String user="root";
    String pass="Jrac20421234";
    public Connection getConecxion(){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
        System.out.println("✅ Conexión exitosa");
    } catch (ClassNotFoundException e) {
        System.err.println("❌ No se encontró el driver JDBC");
        e.printStackTrace();
    } catch (SQLException e) {
        System.err.println("❌ Error al conectar con la base de datos");
        e.printStackTrace();
    }
    return con;
    }
}


