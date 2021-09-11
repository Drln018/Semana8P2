
package Modelo;

//traer herencia de la conexion

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class ConsultasVendedores extends ClsConexion{

    public boolean registrar(ClsVendedores vende){
        PreparedStatement ps= null;
        Connection con= (Connection) getConexion();
        
        String sql="insert into tb_comisiones(nombre, enero, febrero, marzo)values(?,?,?,?)";
        try{
            ps=con.prepareStatement(sql);
            //enviamos los datos
            ps.setString(1, vende.getNombre());
            ps.setInt(2, vende.getEnero());
            ps.setInt(3, vende.getFebrero());
            ps.setInt(4, vende.getMarzo());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally {
            try{
                //cerrar la base
                con.close(); 
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
    public boolean modificar(ClsVendedores vende){
        PreparedStatement ps= null;
        Connection con= (Connection) getConexion();
        
        String sql="update tb_comisiones set nombre=?, enero=?, febrero=?, marzo=? where id=?";
        try{
            ps=con.prepareStatement(sql);
            //enviamos los datos
            ps.setString(1, vende.getNombre());
            ps.setInt(2, vende.getEnero());
            ps.setInt(3, vende.getFebrero());
            ps.setInt(4, vende.getMarzo());
            ps.setInt(5, vende.getId());
            ps.execute(); //si se ejecuta
            
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally {
            try{
                //cerrar la base
                con.close(); 
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
    public boolean eliminar(ClsVendedores vende){
        PreparedStatement ps= null;
        Connection con= (Connection) getConexion();
        
        String sql="delete from tb_comisiones where id=?";
        try{
            ps=con.prepareStatement(sql);
            //enviamos los datos
           
            ps.setInt(1, vende.getId());
            ps.execute(); //si se ejecuta
            
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally {
            try{
                //cerrar la base
                con.close(); 
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
    public boolean buscar(ClsVendedores vende){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con= (Connection) getConexion();
        
        String sql="select * from tb_comisiones where codigo=?";
        try{
            ps=con.prepareStatement(sql);
            //enviamos los datos
           
            ps.setInt(1, vende.getCodigo());
            ps.execute(); //si se ejecuta
            rs=ps.executeQuery(); //regresa el resultado
            //if para pasar los resultados
            if(rs.next()){
                vende.setId(rs.getInt("id"));
                vende.setCodigo(rs.getInt("codigo"));
                vende.setNombre(rs.getString("nombre"));
                vende.setEnero(rs.getInt("enero"));
                vende.setFebrero(rs.getInt("febrero"));
                vende.setMarzo(rs.getInt("marzo"));
                return true;//saldra del metodo
            }
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally {
            try{
                //cerrar la base
                con.close(); 
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
}
