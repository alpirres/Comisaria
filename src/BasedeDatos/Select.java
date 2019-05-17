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
public class Select {
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
}
