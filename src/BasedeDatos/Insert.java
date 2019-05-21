/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import static comisaria.Comisaria.miConexion;
import comisaria.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlove
 */
public class Insert {

    public boolean insertSospechoso(SospSimple sosp) throws SQLException, Exception {
        boolean insertados = true;
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO Sospechoso (IDSosp, Nombre, Apellidos, Antecedentes, Hechos) values (?, ?, ?, ?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos
            Comisaria.miConexion.conectar();
            PreparedStatement preparedStmt = Comisaria.miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            preparedStmt.setInt(1, sosp.id);
            preparedStmt.setString(2, sosp.nombre);
            preparedStmt.setString(3, sosp.apellidos);
            preparedStmt.setString(4, sosp.antecedentes);
            preparedStmt.setString(5, sosp.hechos);

            // la ejecutamos
            preparedStmt.execute();
            // habría que cerrar la conexion
            MatToConsulta(sosp);
            DirToConsulta(sosp);
            TelToConsulta(sosp);
            CorrToConsulta(sosp);
            FotoToConsulta(sosp);

        } catch (SQLException se) {
            se.printStackTrace();
        }
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
     * Metodo que transforma cada matricula de un sospechoso en dos consulta SQL
     * INSERT una para la tabla MATRICULA y otra para la tabla POSEE(que une
     * matricula con sospechoso)
     *
     * @param sosp
     */
    public void MatToConsulta(SospSimple sosp) {
        boolean insertados = true;
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO matricula (IDSosp, NumMat) values (?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos

            PreparedStatement preparedStmt = Comisaria.miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            for (int i = 0; i < sosp.matricula.size(); i++) {
                preparedStmt.setInt(1, sosp.id);
                preparedStmt.setString(2, sosp.matricula.get(i));
                // la ejecutamos
                preparedStmt.execute();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    /**
     * Metodo que transforma cada direccion de un sospechoso en dos consulta SQL
     * INSERT una para la tabla DIRECCION y otra para la tabla VIVE(que une
     * direccion con sospechoso)
     *
     * @param sosp
     */
    public void DirToConsulta(SospSimple sosp) {
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO direccion (IDSosp, NomDir) values (?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos

            PreparedStatement preparedStmt = Comisaria.miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            for (int i = 0; i < sosp.direccion.size(); i++) {
                preparedStmt.setInt(1, sosp.id);
                preparedStmt.setString(2, sosp.direccion.get(i));
                // la ejecutamos
                preparedStmt.execute();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    /**
     * Metodo que transforma cada telefono de un sospechoso en dos consulta SQL
     * INSERT una para la tabla TELEFONO y otra para la tabla TIENE(que une
     * telefono con sospechoso)
     *
     * @param sosp
     */
    public void TelToConsulta(SospSimple sosp) {
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO telefono (IDSosp, NumTel) values (?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos

            PreparedStatement preparedStmt = Comisaria.miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            for (int i = 0; i < sosp.telefonos.size(); i++) {
                preparedStmt.setInt(1, sosp.id);
                preparedStmt.setString(2, sosp.telefonos.get(i));

                System.out.println(sosp.telefonos.size());
                System.out.println("IMPRIMIENDO TELEFONOS " + sosp.telefonos.get(i));

                // la ejecutamos
                preparedStmt.execute();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    /**
     * Metodo que transforma cada correo de un sospechoso en dos consulta SQL
     * INSERT una para la tabla CORREO y otra para la tabla USA(que une correo
     * con sospechoso)
     *
     * @param sosp
     */
    public void CorrToConsulta(SospSimple sosp) {
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO correo (IDSosp, DirCor) values (?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos

            PreparedStatement preparedStmt = Comisaria.miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            for (int i = 0; i < sosp.correo.size(); i++) {
                preparedStmt.setInt(1, sosp.id);
                preparedStmt.setString(2, sosp.correo.get(i));
                // la ejecutamos
                preparedStmt.execute();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /*public void FotoToConsulta(Sospechoso sosp){
            String cons;
            for(int i=0; i<sosp.fotos.size(); i++){
                cons="INSERT INTO FOTO ("+
            }
        }*/

    public void FotoToConsulta(SospSimple sosp) {
         String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO FOTO (IDSosp, IDFoto, Descripcion, ImgData) values (?, ?, ?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos

            PreparedStatement preparedStmt = Comisaria.miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            for (int i = 0; i < sosp.correo.size(); i++) {
                preparedStmt.setInt(1, sosp.id);
                preparedStmt.setInt(2, i+1);
                preparedStmt.setString(3, sosp.fotos.get(i).descripciones.get(i));
                FileInputStream fis = new FileInputStream (sosp.fotos.get(i).imagenes.get(i));
                preparedStmt.setBinaryStream(4, fis);
                              
                // la ejecutamos
                preparedStmt.execute();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
