/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;
import static comisaria.Comisaria.miConexion;
import comisaria.Sospechoso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jlove
 */
public class Consultas {
        public static boolean insertarSospechoso(Sospechoso sosp) throws SQLException
	{
		boolean insertados=true;
		int i;
		//Cadena donde irán las sentencias sql de creación de tablas
		String lineaSQL;
		//Objeto de tipo Statement
		Statement sentencia;
		
		
		
		//comando sql generico para la inserción
		lineaSQL="INSERT INTO SOSPECHOSO (Nombre, Apellidos, Antecedentes) values ("+sosp.nombre+","+sosp.apellidos+","+sosp.antecedentes+");";
	try
	{
		
		
		//conectamos el objeto preparedStmt a la base de datos
		 PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
		
		 for(i=1; i<3; i++)
		 {
			 preparedStmt.setString(1, sosp.nombre);
			 preparedStmt.setString(2, sosp.apellidos);
			 preparedStmt.setString(3, nuevoSocio.getApellidosSocio());
			 preparedStmt.setString(4, nuevoSocio.getDireccionSocio());
			 preparedStmt.setString(5, nuevoSocio.getEmailSocio());
			 preparedStmt.setString(6, nuevoSocio.getTelefonoSocio());

			// la ejecutamos
			preparedStmt.execute();
	 }
         // habría que cerrar la conexion
	}catch(SQLException se)
	{
		insertados=false;
		se.printStackTrace();
	}
		
		return insertados;
		
		
		
		
	}
	
	//Método que nos muestra todos los socios que hay insertados actualmente
	public static void mostrarSocios() throws SQLException
	{
		//Número de filas afectadas
		int nFilas=0;
		String lineaSQL="Select * from SOCIOS";
		PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
		ResultSet resultado = preparedStmt.executeQuery();
		System.out.println("LISTADO DE SOCIOS");
		System.out.println("Código   Nombre   Apellidos   Dirección   Teléfono   Email");
		
		
		while(resultado.next())
		{
			nFilas ++;
			System.out.println(resultado.getInt("codigoSocio")+"   "+resultado.getString("nombreSocio")+"   "+resultado.getString("apellidosSocio")+"   "+resultado.getString("direccionSocio")+"   "+resultado.getString("telefonoSocio")+"   "+resultado.getString("emailSocio"));
			
		}
		System.out.println("Se han mostrado "+nFilas+" de la tabla Socios");
		
	}
	
	//Método que actualiza el nombre de un socio dado por su código
	//Devuelve el número de filas actualizadas
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
	
	//Método qu elimina un socio por su código
	//Devuelve el número de filas afectadas
	public static int eliminarSocioPorCodigo(int codigo) throws SQLException
	{
				
		//Cadena donde irán las sentencias sql
		String lineaSQL;
		//Objeto de tipo Statement
		PreparedStatement preparedStmt;
		//Número de filas actualizadas
		int nFilas=0;
		
		
		//Cadena update
		lineaSQL="delete from SOCIOS where codigoSocio = ?";
		try
		{		
		
			//conectamos el objeto preparedStmt a la base de datos
			preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
			//agregamos los valores que faltan a la linea SQL
		    preparedStmt.setInt (1, codigo);
		
			// la ejecutamos
			nFilas=preparedStmt.executeUpdate();
		       
			// habría que cerrar la conexion
		}catch(SQLException se)
		{
		
			se.printStackTrace();
		}
		
		return nFilas;
		
	}
	
	//Método qu elimina todos los socios
	//Devuelve el número de filas afectadas
	public static int eliminarSocios() throws SQLException
	{
				
		//Cadena donde irán las sentencias sql
		String lineaSQL;
		//Objeto de tipo Statement
		PreparedStatement preparedStmt;
		//Número de filas actualizadas
		int nFilas=0;
		
		
		//Cadena update
		lineaSQL="delete from SOCIOS";
		try
		{		
		
			//conectamos el objeto preparedStmt a la base de datos
			preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
					
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
