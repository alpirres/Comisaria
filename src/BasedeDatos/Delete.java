/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;
import static comisaria.Comisaria.miConexion;
import comisaria.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author alfon
 */
public class Delete {
    
    /**
     * 
     * @param codigo
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public static int eliminarSospID(int sospid) throws SQLException, Exception{		
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="delete from SOSPECHOSO where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            preparedStmt.setInt (1, sospid);
		
            // la ejecutamos
            nFilas=preparedStmt.executeUpdate();
		       
            // cerrarmos la conexion
            miConexion.cerrarConexion();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return nFilas;	
	}
	
	public static int eliminar(int codigo) throws SQLException, Exception{		
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="delete from SOSPECHOSO where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            preparedStmt.setInt (1, codigo);
		
            // la ejecutamos
            nFilas=preparedStmt.executeUpdate();
		       
            // cerrarmos la conexion
            miConexion.cerrarConexion();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return nFilas;	
	}
}
