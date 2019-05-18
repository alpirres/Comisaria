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
 * @author jlove
 */
public class Update {
    	public static int actualizarSocio(int codigo, String nuevoNombre) throws SQLException
	{
				
		//Cadena donde irán las sentencias sql
		String lineaSQL;
		//Objeto de tipo Statement
		PreparedStatement preparedStmt;
		//Número de filas actualizadas
		int nFilas=0;
		
		
		//Cadena update
		lineaSQL="update SOCIOS set nombreSocio = ? where codigoSocio = ?";
		try
		{		
		
			//conectamos el objeto preparedStmt a la base de datos
			preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
			//agregamos los valores que faltan a la linea SQL
		    preparedStmt.setString   (1, nuevoNombre);
		    preparedStmt.setInt (2, codigo);
		
			// la ejecutamos
			nFilas=preparedStmt.executeUpdate();
		       
			// habría que cerrar la conexion
		}catch(SQLException se)
		{
		
			se.printStackTrace();
		}
		
		return nFilas;
		
	}
}
