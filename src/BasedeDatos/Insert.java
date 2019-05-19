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
public class Insert {
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
        /**
         * Metodo que transforma cada matricula de un sospechoso en dos consulta SQL INSERT
         * una para la tabla MATRICULA y otra para la tabla POSEE(que une matricula con sospechoso)
         * @param sosp
         * @return devuelve un String el cual son las consultas INSERT
         */
        public static String MatToConsulta(Sospechoso sosp){
            StringBuilder cons=new StringBuilder();
            for(int i=0; i<sosp.matricula.matriculas.size();i++){
                cons.append("INSERT INTO MATRICULA ("+sosp.matricula.matriculas.get(i)+");"
                            +"INSERT INTO POSEE("+sosp.id+","+sosp.matricula.matriculas.get(i)+");");
            }
            return cons.toString();
        }
        /**
         * Metodo que transforma cada direccion de un sospechoso en dos consulta SQL INSERT
         * una para la tabla DIRECCION y otra para la tabla VIVE(que une direccion con sospechoso)
         * @param sosp
         * @return devuelve un String el cual son las consultas INSERT
         */
        public static String DirToConsulta(Sospechoso sosp){
            StringBuilder cons=new StringBuilder();
            for(int i=0; i<sosp.direccion.direcciones.size();i++){
                cons.append("INSERT INTO DIRECCION ("+sosp.direccion.direcciones.get(i)+");"
                            +"INSERT INTO VIVE("+sosp.id+","+sosp.direccion.direcciones.get(i)+");");
            }
            return cons.toString();
        }
        /**
         * Metodo que transforma cada telefono de un sospechoso en dos consulta SQL INSERT
         * una para la tabla TELEFONO y otra para la tabla TIENE(que une telefono con sospechoso)
         * @param sosp
         * @return devuelve un String el cual son las consultas INSERT
         */
        public static String TelToConsulta(Sospechoso sosp){
            StringBuilder cons=new StringBuilder();
            for(int i=0; i<sosp.telefono.telefonos.size();i++){
                cons.append("INSERT INTO TELEFONO ("+sosp.telefono.telefonos.get(i)+");"
                            +"INSERT INTO TIENE("+sosp.id+","+sosp.telefono.telefonos.get(i)+");");
            }
            return cons.toString();
        }
        /**
         * Metodo que transforma cada correo de un sospechoso en dos consulta SQL INSERT
         * una para la tabla CORREO y otra para la tabla USA(que une correo con sospechoso)
         * @param sosp
         * @return devuelve un String el cual son las consultas INSERT
         */
        public static String CorrToConsulta(Sospechoso sosp){
            StringBuilder cons=new StringBuilder();
            for(int i=0; i<sosp.correo.correos.size();i++){
                cons.append("INSERT INTO CORREO ("+sosp.correo.correos.get(i)+");"
                            +"INSERT INTO USA("+sosp.id+","+sosp.correo.correos.get(i)+");");
            }
            return cons.toString();
        }
}