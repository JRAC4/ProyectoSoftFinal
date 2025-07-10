package conexion;
import java.sql.*;
public class Conexion
 { 
public static Connection getConexion(){ 
Connection con = null;
 try { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
String url = "jdbc:sqlserver://localhost:1433;databaseName=bdferricov1;encrypt=true;trustServerCertificate=true";
String usr = "sa"; 
String psw = "Gallo16_"; 
con = DriverManager.getConnection(url,usr,psw);} 
catch (ClassNotFoundException ex) { System.out.println("No hay Driver!!"); } 
catch (SQLException ex) 
{ System.out.println("Error con la BD"); }
 return con; }
 } 