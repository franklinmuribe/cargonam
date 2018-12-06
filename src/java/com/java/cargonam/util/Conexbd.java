package com.java.cargonam.util;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by IntelliJ IDEA.
 * package bcv.acceso
 * User: rmartine
 * Date: 31-may-2007
 * Time: 15:27:24
 * To change this template use File | Settings | File Templates.
 */
public class Conexbd {

   

  

    public static Connection getConnectionDirecta() {

        String driver = AlmacenPropiedades.getPropiedad("DB_DRIVER");
        String url = AlmacenPropiedades.getPropiedad("DB_URL");
        String user = AlmacenPropiedades.getPropiedad("DB_USER");
        String passw = AlmacenPropiedades.getPropiedad("DB_PWD");

        try {

            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, passw);
           
            return con;

        } catch (Exception e) {
            
            return null;
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException{
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				
	        	e.printStackTrace();
				throw new SQLException ("SQLException : Error cerrando el resulset : "+e.getMessage());
			}
		}
		
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				
	        	e.printStackTrace();
	        	
				throw new SQLException ("SQLException : Error cerrando el prepared statement : "+e.getMessage());
			}
		}		
		
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				
				throw new SQLException ("SQLException : Error cerrando la coneccion : "+e.getMessage());
			}
		}
		
	}

    
}
