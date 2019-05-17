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
public class Consultas {
        public static boolean insertSospechoso(Sospechoso sosp) throws SQLException
	{
		boolean insertados=true;
		int i;
		//Cadena donde irán las sentencias sql de creación de tablas
		String lineaSQL;
		//Objeto de tipo Statement
		Statement sentencia;
		
		
		
		//comando sql generico para la inserción de sospechoso, y llamada a los metodos de inserts de las demas tablas
		lineaSQL="INSERT INTO SOSPECHOSO (IDSosp, Nombre, Apellidos, Antecedentes) values ("+sosp.id+","+sosp.nombre+","+sosp.apellidos+","+sosp.antecedentes+");"
                        +MatToConsulta(sosp)+DirToConsulta(sosp)+TelToConsulta(sosp)+CorrToConsulta(sosp);
	try
	{
		
		
		//conectamos el objeto preparedStmt a la base de datos
		PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
                preparedStmt.execute();
                insertados=true;
	
         // habría que cerrar la conexion
	}catch(SQLException se)
	{
		insertados=false;
		se.printStackTrace();
	}
		
		return insertados;
		
		
		
		
	}
        
        public static String MatToConsulta(Sospechoso sosp){
            StringBuilder cons=new StringBuilder();
            for(int i=0; i<sosp.matricula.matriculas.size();i++){
                cons.append("INSERT INTO MATRICULA ("+sosp.matricula.matriculas.get(i)+");"
                            +"INSERT INTO POSEE("+sosp.id+","+sosp.matricula.matriculas.get(i)+");");
            }
            return cons.toString();
        }
        public static String DirToConsulta(Sospechoso sosp){
            StringBuilder cons=new StringBuilder();
            for(int i=0; i<sosp.direccion.direcciones.size();i++){
                cons.append("INSERT INTO DIRECCION ("+sosp.direccion.direcciones.get(i)+");"
                            +"INSERT INTO VIVE("+sosp.id+","+sosp.direccion.direcciones.get(i)+");");
            }
            return cons.toString();
        }
        public static String TelToConsulta(Sospechoso sosp){
            StringBuilder cons=new StringBuilder();
            for(int i=0; i<sosp.telefono.telefonos.size();i++){
                cons.append("INSERT INTO TELEFONO ("+sosp.telefono.telefonos.get(i)+");"
                            +"INSERT INTO TIENE("+sosp.id+","+sosp.telefono.telefonos.get(i)+");");
            }
            return cons.toString();
        }
        public static String CorrToConsulta(Sospechoso sosp){
            StringBuilder cons=new StringBuilder();
            for(int i=0; i<sosp.correo.correos.size();i++){
                cons.append("INSERT INTO TELEFONO ("+sosp.correo.correos.get(i)+");"
                            +"INSERT INTO TIENE("+sosp.id+","+sosp.correo.correos.get(i)+");");
            }
            return cons.toString();
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
