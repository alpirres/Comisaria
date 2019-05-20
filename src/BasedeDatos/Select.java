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
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jlove
 */
public class Select {
    /**
     * Metodo que crea una consulta SELECT en la que busca el sospechoso cuyo ID es
     * el mayor de todos los sospechosos
     * @return devuelve el ID más grande
     * @throws SQLException 
     */
    public static int getIDGlobal() throws SQLException{
        int idfinal;
        String lineaSQL="Select sosp.IDSosp"
                        + "from SOSPECHOSO sosp"
                        + "where sosp.IDSosp=max();";
		PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
		ResultSet result = preparedStmt.executeQuery();
                idfinal=result.getInt("IDSosp");
        return idfinal;
    }
    
    public ArrayList<SospSimple> buscarXTelefono(String tlf) throws SQLException{
        ArrayList<SospSimple> suspects = new ArrayList<>();
        String lineaSQL="Select sosp.*,t.NumTel, c.DirCorreo, d.NomDir, m.NumMat "
                + "from sospechoso sosp, telefono t, direccion d, correo c, matricula m "
                + "where t.NumTel="+tlf
                +" and t.IDSosp=sosp.IDSosp"
                +" and c.IDSosp=sosp.IDSosp"
                +" and d.IDSosp=sosp.IDSosp"
                +" and m.IDSosp=sosp.IDSosp";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = preparedStmt.executeQuery();
        while(rs.next()){
                    int id=rs.getInt("IDSosp");
                    HashSet<String> correos=new HashSet<>();
                    HashSet<String> matriculas=new HashSet<>();

                    rs.next();

                    do{
                        if(rs.getInt("IDSosp")!=id){
                            rs.previous();
                            SospSimple nuevo=new SospSimple(rs.getInt("IDSosp"), rs.getString("Nombre"),
                              rs.getString("Apellidos"), rs.getString("Antecedentes"),
                              rs.getInt("NumTel"), rs.getString("DirCorreo"), rs.getString("NomDir"),
                              rs.getString("NumMat"));
                            
                            suspects.add(nuevo);
                        }else{
                            //hay que recoorrer las filas pertenecientes al mismo sujeto creando los arraylist correspondientes.
                            correos.add(rs.getString("correo"));
                            matriculas.add(rs.getString("matriculas"));
                        }
                    }while(rs.next());
                }
        return suspects;
    }
    
    /**
     * SIN TERMINAR
     * @throws SQLException 
     */
    public static ArrayList<Sospechoso> selectAllSosp() throws SQLException
	{
		ArrayList<Sospechoso> suspects = new ArrayList<>();

		String lineaSQL="Select * from SOSPECHOSO";
		PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
		ResultSet rs = preparedStmt.executeQuery();
		while(rs.next()){
                    int id=rs.getInt("id_sospechoso");
                    HashSet<String> correos=new HashSet<>();
                    HashSet<String> matriculas=new HashSet<>();

                    rs.next();

                    do{
                        if(rs.getInt("id_sospechoso")!=id){
                            rs.previous();
                            //Sospechoso nuevo=new Sospechoso(rs.getString("nombre"),
                            //  rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("dni"),
                            //  new ArrayList<>(correos), new ArrayList<>(matriculas), null, null, null, null, null, null);
                            // suspects.add(nuevo);
                        }else{
                            //hay que recoorrer las filas pertenecientes al mismo sujeto creando los arraylist correspondientes.
                            correos.add(rs.getString("correo"));
                            matriculas.add(rs.getString("matriculas"));
                        }
                    }while(rs.next());


                   

                }

        return suspects;

	}
}
