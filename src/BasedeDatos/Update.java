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
public class Update {
    /**
     * 
     * @param sospid
     * @param nuevoNombre
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public static int actualizarNombreSosp(int sospid, String nuevoNombre) throws SQLException, Exception{		
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update SOSPECHOSO set nombre = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            preparedStmt.setString   (1, nuevoNombre);
            preparedStmt.setInt (2, sospid);
		
            // la ejecutamos
            nFilas=preparedStmt.executeUpdate();
		       
            //cerramos la conexion
            miConexion.cerrarConexion();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return nFilas;	
	}
    
    /**
     * 
     * @param sospid
     * @param nuevoApellido
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public static int actualizarApellidoSosp(int sospid, String nuevoApellido) throws SQLException, Exception{		
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update SOSPECHOSO set apellido = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            preparedStmt.setString   (1, nuevoApellido);
            preparedStmt.setInt (2, sospid);
		
            // la ejecutamos
            nFilas=preparedStmt.executeUpdate();
		       
            //cerramos la conexion
            miConexion.cerrarConexion();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return nFilas;	
	}
    
    /**
     * 
     * @param sospid
     * @param nuevoAntecedente
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public static int actualizarAntecedentesSosp(int sospid, String nuevoAntecedente) throws SQLException, Exception{		
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update SOSPECHOSO set antecedentes = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            preparedStmt.setString   (1, nuevoAntecedente);
            preparedStmt.setInt (2, sospid);
		
            // la ejecutamos
            nFilas=preparedStmt.executeUpdate();
		       
            //cerramos la conexion
            miConexion.cerrarConexion();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return nFilas;	
	}
    
    /**
     * 
     * @param sospid
     * @param nuevoHecho
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public static int actualizarHechosSosp(int sospid, String nuevoHecho) throws SQLException, Exception{		
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update SOSPECHOSO set nombre = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            preparedStmt.setString   (1, nuevoHecho);
            preparedStmt.setInt (2, sospid);
		
            // la ejecutamos
            nFilas=preparedStmt.executeUpdate();
		       
            //cerramos la conexion
            miConexion.cerrarConexion();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return nFilas;	
	}
    
    /**
     * 
     * @param sospid
     * @param nuevoEmail
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public static int actualizarEmail(Correo corr) throws SQLException, Exception{
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update USA set dircorreo = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            for(int i=0;i<corr.correos.size();i++){
                preparedStmt.setString (1, corr.correos.get(i));
                preparedStmt.setInt (2, corr.id);

                // la ejecutamos
                nFilas=preparedStmt.executeUpdate();
            }       
            //cerramos la conexion
            miConexion.cerrarConexion();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return nFilas;	
	}
    
    public static int actualizarMatricula(Matricula mat) throws SQLException, Exception{
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update POSEE set NumMat = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            for(int i=0;i<mat.matriculas.size();i++){
                preparedStmt.setString (1, mat.matriculas.get(i));
                preparedStmt.setInt (2, mat.id);
                // la ejecutamos
                nFilas=preparedStmt.executeUpdate();
            }
            //cerramos la conexion
            miConexion.cerrarConexion();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return nFilas;	
	}
    
    public static int actualizarDireccion(Direccion dir) throws SQLException, Exception{
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update VIVE set nomdir = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            for(int i=0;i<dir.direcciones.size();i++){
                preparedStmt.setString (1, dir.direcciones.get(i));
                preparedStmt.setInt (2, dir.id);
                // la ejecutamos
                nFilas=preparedStmt.executeUpdate();
            }
            //cerramos la conexion
            miConexion.cerrarConexion();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return nFilas;	
	}
    
    public static int actualizarTlf(Telefono tlf) throws SQLException, Exception{
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update Usa set dircorreo = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            for(int i=0;i<tlf.telefonos.size();i++){
                preparedStmt.setString (1, tlf.telefonos.get(i));
                preparedStmt.setInt (2, tlf.id);
                // la ejecutamos
                nFilas=preparedStmt.executeUpdate();
            }
            //cerramos la conexion
            miConexion.cerrarConexion();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return nFilas;	
	}
}
