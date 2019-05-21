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
import java.util.ArrayList;
/**
 *
 * @author alfon
 */
public class Update {
    /**
     * funcion que actualiza el nombre del sospechos
     * @param sospid id del sospechoso
     * @param nuevoNombre String con el nuevo nombre
     * @return numero de filas afectadas 
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
     * funcion que actualiza el apellido del sospechoso 
     * @param sospid int id del sospechoso
     * @param nuevoApellido String von el nuevo apellido
     * @return numero de filas afectadas
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
     * funcion que actualiza los antecedentes del sospechoso 
     * @param sospid int id del sospechoso
     * @param nuevoAntecedente String que contiene los nuevos antecedentes
     * @return numero de filas afectadas
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
     * funcion que actualiza los hechos del sospechoso 
     * @param sospid int id del sospechoso
     * @param nuevoHecho String que contiene los nuevos hechos
     * @return numero de filas afectadas
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
     * funcion que actualiza los Emails del sospechoso 
     * @param corr  objeto email de donde se obtendrá el id del sospechoso y el array de nuevos correos
     * @return numero de filas afectadas
     * @throws SQLException
     * @throws Exception 
     */
    public static int actualizarEmail(int id, ArrayList<String> corr) throws SQLException, Exception{
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update CORREO set DirCor = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            for(int i=0;i<corr.size();i++){
                preparedStmt.setString (1, corr.get(i));
                preparedStmt.setInt (2, id);

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
    
    /**
     * funcion que actualiza las matriculas 
     * @param mat objeto matrivula de donde se obtendrá el id de sospechoso y el array de nuevos correos
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public static int actualizarMatricula(int id,ArrayList<String> mat) throws SQLException, Exception{
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update MATRICULA set NumMat = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            for(int i=0;i<mat.size();i++){
                preparedStmt.setString (1, mat.get(i));
                preparedStmt.setInt (2, id);
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
    
    /**
     * funcion que actualiza las direcciones
     * @param dir objeto direccion de donde se obtendrá el id del sospechoso y el array de nuevos correos
     * @return numero de filas afectadas
     * @throws SQLException
     * @throws Exception 
     */
    public static int actualizarDireccion(int id, ArrayList<String> dir) throws SQLException, Exception{
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update DIRECCION set nomdir = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            for(int i=0;i<dir.size();i++){
                preparedStmt.setString (1, dir.get(i));
                preparedStmt.setInt (2, id);
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
    
    /**
     * funcion que actualiza los telefonos
     * @param tlf objeto telefono de donde se obtendrá el id del sospechoso y el array de nuevos correos
     * @return numero de filas afectadas
     * @throws SQLException
     * @throws Exception 
     */
    public static int actualizarTlf(int id, ArrayList<String> tlf) throws SQLException, Exception{
        //Cadena donde irán las sentencias sql
        String lineaSQL;
        //Objeto de tipo Statement
        PreparedStatement preparedStmt;
        //Número de filas actualizadas
        int nFilas=0;
        //Cadena update
        lineaSQL="update TELEFONO set DirCor = ? where IDSosp = ?";
        try{
            //conectamos el objeto preparedStmt a la base de datos
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
			
            //agregamos los valores que faltan a la linea SQL
            for(int i=0;i<tlf.size();i++){
                preparedStmt.setString (1, tlf.get(i));
                preparedStmt.setInt (2, id);
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
