
package Modelo;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Darlin
 */
public class ClsConexion {
    private final String base="dbcomisiones";
    private final String user="root";
    private final String password="2001";
    private final String url="jdbc:mysql:localhost:3306"+ base;
    private Connection con=null; //obtener y guardar la conexion
    //crear metodo de tipo connection
    public Connection getConexion() {
        try{
            //ruta del driver, controlador para realizar la conexion
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(this.url,this.user,this.password);
        }catch(SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClsConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
