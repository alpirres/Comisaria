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
        public boolean insertSospechoso(Sospechoso sosp) throws SQLException{
		boolean insertados=true;
		int i;
		//Cadena donde irán las sentencias sql de creación de tablas
		String lineaSQL;
		//Objeto de tipo Statement
		Statement sentencia;		
		//comando sql generico para la inserción de sospechoso, y llamada a los metodos de inserts de las demas tablas
		String cons="INSERT INTO SOSPECHOSO (IDSosp, Nombre, Apellidos, Antecedentes) values ("+sosp.id+","+sosp.nombre+","+sosp.apellidos+","+sosp.antecedentes+");";
                ejecutaSQL(cons);
                //SospToConsulta(sosp);
                MatToConsulta(sosp);
                DirToConsulta(sosp);
                TelToConsulta(sosp);
                CorrToConsulta(sosp);
               // FotoToConsulta(sosp);
		return insertados;
	}
        /*
        public void SospToConsulta(Sospechoso sosp){
            String cons;
            for(int i=0; i<sosp.acompanante.size();i++){
                cons="INSERT INTO ACOMPANIA ("+sosp.id+","+sosp.acompanante.get(i)+");";
                ejecutaSQL(cons);
            }
        }*/
        
        /**
         * Metodo que transforma cada matricula de un sospechoso en dos consulta SQL INSERT
         * una para la tabla MATRICULA y otra para la tabla POSEE(que une matricula con sospechoso)
         * @param sosp
         */
        public void MatToConsulta(Sospechoso sosp){
            String cons;
            for(int i=0; i<sosp.matricula.matriculas.size();i++){
                cons="INSERT INTO MATRICULA ("+sosp.id+","+sosp.matricula.matriculas.get(i)+");";
                ejecutaSQL(cons);
            }
        }
        /**
         * Metodo que transforma cada direccion de un sospechoso en dos consulta SQL INSERT
         * una para la tabla DIRECCION y otra para la tabla VIVE(que une direccion con sospechoso)
         * @param sosp
         */
        public void DirToConsulta(Sospechoso sosp){
            String cons;
            for(int i=0; i<sosp.direccion.direcciones.size();i++){
                cons="INSERT INTO DIRECCION ("+sosp.id+","+sosp.direccion.direcciones.get(i)+");";
                ejecutaSQL(cons);
            }
        }
        /**
         * Metodo que transforma cada telefono de un sospechoso en dos consulta SQL INSERT
         * una para la tabla TELEFONO y otra para la tabla TIENE(que une telefono con sospechoso)
         * @param sosp
         */
        public void TelToConsulta(Sospechoso sosp){
            String cons;
            for(int i=0; i<sosp.telefono.telefonos.size();i++){
                cons="INSERT INTO TELEFONO ("+sosp.id+","+sosp.telefono.telefonos.get(i)+");";
                ejecutaSQL(cons);
            }
        }
        /**
         * Metodo que transforma cada correo de un sospechoso en dos consulta SQL INSERT
         * una para la tabla CORREO y otra para la tabla USA(que une correo con sospechoso)
         * @param sosp
         */
        public void CorrToConsulta(Sospechoso sosp){
            String cons;
            for(int i=0; i<sosp.correo.correos.size();i++){
                cons="INSERT INTO CORREO ("+sosp.id+","+sosp.correo.correos.get(i)+");";
                ejecutaSQL(cons);
            }
        }
        /*public void FotoToConsulta(Sospechoso sosp){
            String cons;
            for(int i=0; i<sosp.fotos.size(); i++){
                cons="INSERT INTO FOTO ("+
            }
        }*/
        
        public void ejecutaSQL(String lineaSQL){
            try
            {
		//conectamos el objeto preparedStmt a la base de datos
		PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
                preparedStmt.execute();
	
         // habría que cerrar la conexion
            }catch(SQLException se)
            {
                    se.printStackTrace();
            }
        }
        
}
