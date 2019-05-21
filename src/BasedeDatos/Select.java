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
        int idfinal = 0;
        
        
        System.out.println("wtf");
        
        
        
        
        String lineaSQL="Select sosp.IDSosp "
                        + "from SOSPECHOSO sosp "
                        + "where sosp.IDSosp=(select max(idSosp) from SOSPECHOSO);";
        System.out.println("wtf 2");
		PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
                
		ResultSet result = preparedStmt.executeQuery();
                
                while(result.next()){
                    idfinal = result.getInt("IDSosp");
                    System.out.println("ESTOY PROBANDO");
                }
                
                
                System.out.println(idfinal);
                
                //System.out.println(result.getInt("IDSosp"));
                //idfinal=result.getInt("IDSosp");
        return idfinal+1;
    }
       public ArrayList<SospSimple> buscarXNombre(String nom) throws SQLException{
        ArrayList<SospSimple> suspects = new ArrayList<>();
        int iteracion=0;
        String lineaSQL="Select sosp.*,t.NumTel, c.DirCor, d.NomDir, m.NumMat "
                + "from sospechoso sosp, telefono t, direccion d, correo c, matricula m "
                + "where sosp.nombre like \"%"+nom+"%\""
                +" and t.IDSosp=sosp.IDSosp"
                +" and c.IDSosp=sosp.IDSosp"
                +" and d.IDSosp=sosp.IDSosp"
                +" and m.IDSosp=sosp.IDSosp"
                +" group by sosp.IDSosp;";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = preparedStmt.executeQuery();
        System.out.println("ID Nombre Apellidos ...");
        while(rs.next()){
                    iteracion++;
                    int id=rs.getInt("IDSosp");
                    ArrayList<String> telefonos=new ArrayList<>();
                    ArrayList<String> correos=new ArrayList<>();
                    ArrayList<String> direcciones=new ArrayList<>();
                    ArrayList<String> matriculas=new ArrayList<>();
                    ArrayList<Foto> imagenes = new ArrayList<>();

                    telefonos.add(rs.getString("NumTel"));
                    correos.add(rs.getString("DirCor"));
                    direcciones.add(rs.getString("NomDir"));
                    matriculas.add(rs.getString("NumMat"));
                    
                    System.out.println(rs.getInt("IDSosp")+rs.getString("Nombre")+rs.getString("Apellidos")+rs.getString("Antecedentes")+rs.getString("NumTel")+rs.getString("DirCor")+rs.getString("NomDir")+rs.getString("NumMat"));
                   /* rs.next();
                    do{ 
                        iteracion++;
                        if(rs.getInt("IDSosp")!=id){
                           System.out.println("Entra 1");
                        }else{
                            //hay que recoorrer las filas pertenecientes al mismo sujeto creando los arraylist correspondientes.
                            System.out.println("Entra 2");
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                            
                        }
                    }while(rs.next()==true);
                    for(int i=0;i<iteracion;i++){
                        rs.previous();
                    }*/
                    System.out.println("Entra 3");
                    SospSimple nuevo=new SospSimple(id, rs.getString("Nombre"),
                            rs.getString("Apellidos"), rs.getString("Antecedentes"),
                            telefonos , correos, direcciones, matriculas, imagenes);
                    
                    suspects.add(nuevo);
                }
        return suspects;
       }
       public ArrayList<SospSimple> buscarXApellidos(String aps)throws SQLException{
        ArrayList<SospSimple> suspects = new ArrayList<>();
        String lineaSQL="Select sosp.*,t.NumTel, c.DirCor, d.NomDir, m.NumMat "
                + "from sospechoso sosp, telefono t, direccion d, correo c, matricula m "
                + "where sosp.apellidos like \"%"+aps+"%\" "
                +" and t.IDSosp=sosp.IDSosp"
                +" and c.IDSosp=sosp.IDSosp"
                +" and d.IDSosp=sosp.IDSosp"
                +" and m.IDSosp=sosp.IDSosp;";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = preparedStmt.executeQuery();
        while(rs.next()){
                    int id=rs.getInt("IDSosp");
                    ArrayList<String> telefonos=new ArrayList<>();
                    ArrayList<String> correos=new ArrayList<>();
                    ArrayList<String> direcciones=new ArrayList<>();
                    ArrayList<String> matriculas=new ArrayList<>();
                    ArrayList<Foto> imagenes = new ArrayList<>();
                    
                    rs.next();

                    do{
                        if(rs.getInt("IDSosp")!=id){
                            rs.previous();
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                            SospSimple nuevo=new SospSimple(rs.getInt("IDSosp"), rs.getString("Nombre"),
                              rs.getString("Apellidos"), rs.getString("Antecedentes"),telefonos , correos, direcciones, matriculas, imagenes);
                            
                            suspects.add(nuevo);
                        }else{
                            //hay que recoorrer las filas pertenecientes al mismo sujeto creando los arraylist correspondientes.
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                        }
                    }while(rs.next());
                }
        return suspects;
       }
       
    public ArrayList<SospSimple> buscarXTelefono(String tlf) throws SQLException{
        ArrayList<SospSimple> suspects = new ArrayList<>();
        String lineaSQL="Select sosp.*,t.NumTel, c.DirCor, d.NomDir, m.NumMat "
                + "from sospechoso sosp, telefono t, direccion d, correo c, matricula m "
                + "where t.NumTel="+tlf
                +" and t.IDSosp=sosp.IDSosp"
                +" and c.IDSosp=sosp.IDSosp"
                +" and d.IDSosp=sosp.IDSosp"
                +" and m.IDSosp=sosp.IDSosp;";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = preparedStmt.executeQuery();
        while(rs.next()){
                    int id=rs.getInt("IDSosp");
                    ArrayList<String> telefonos=new ArrayList<>();
                    ArrayList<String> correos=new ArrayList<>();
                    ArrayList<String> direcciones=new ArrayList<>();
                    ArrayList<String> matriculas=new ArrayList<>();
                    ArrayList<Foto> imagenes = new ArrayList<>();
                    
                    rs.next();

                    do{
                        if(rs.getInt("IDSosp")!=id){
                            rs.previous();
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                            SospSimple nuevo=new SospSimple(rs.getInt("IDSosp"), rs.getString("Nombre"),
                              rs.getString("Apellidos"), rs.getString("Antecedentes"),telefonos , correos, direcciones, matriculas, imagenes);
                            
                            suspects.add(nuevo);
                        }else{
                            //hay que recoorrer las filas pertenecientes al mismo sujeto creando los arraylist correspondientes.
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                        }
                    }while(rs.next());
                }
        return suspects;
    }
    public ArrayList<SospSimple> buscarXMatricula(String mt) throws SQLException{
        ArrayList<SospSimple> suspects = new ArrayList<>();
        String lineaSQL="Select sosp.*,t.NumTel, c.DirCor, d.NomDir, m.NumMat "
                + "from sospechoso sosp, telefono t, direccion d, correo c, matricula m "
                + "where m.NumMat="+mt
                +" and t.IDSosp=sosp.IDSosp"
                +" and c.IDSosp=sosp.IDSosp"
                +" and d.IDSosp=sosp.IDSosp"
                +" and m.IDSosp=sosp.IDSosp;";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = preparedStmt.executeQuery();
        while(rs.next()){
                    int id=rs.getInt("IDSosp");
                    ArrayList<String> telefonos=new ArrayList<>();
                    ArrayList<String> correos=new ArrayList<>();
                    ArrayList<String> direcciones=new ArrayList<>();
                    ArrayList<String> matriculas=new ArrayList<>();
                    
                    rs.next();

                    do{
                        if(rs.getInt("IDSosp")!=id){
                            rs.previous();
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                            ArrayList<Foto> imagenes = new ArrayList<>();
                            
                            SospSimple nuevo=new SospSimple(rs.getInt("IDSosp"), rs.getString("Nombre"),
                              rs.getString("Apellidos"), rs.getString("Antecedentes"),telefonos , correos, direcciones, matriculas, imagenes);
                            
                            suspects.add(nuevo);
                        }else{
                            //hay que recoorrer las filas pertenecientes al mismo sujeto creando los arraylist correspondientes.
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                        }
                    }while(rs.next());
                }
        return suspects;
    }
    
    
    public ArrayList<SospSimple> buscarXCorreo(String corr) throws SQLException{
        ArrayList<SospSimple> suspects = new ArrayList<>();
        String lineaSQL="Select sosp.*,t.NumTel, c.DirCor, d.NomDir, m.NumMat "
                + "from sospechoso sosp, telefono t, direccion d, correo c, matricula m "
                + "where c.DirCor="+corr
                +" and t.IDSosp=sosp.IDSosp"
                +" and c.IDSosp=sosp.IDSosp"
                +" and d.IDSosp=sosp.IDSosp"
                +" and m.IDSosp=sosp.IDSosp;";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = preparedStmt.executeQuery();
        while(rs.next()){
                    int id=rs.getInt("IDSosp");
                    ArrayList<String> telefonos=new ArrayList<>();
                    ArrayList<String> correos=new ArrayList<>();
                    ArrayList<String> direcciones=new ArrayList<>();
                    ArrayList<String> matriculas=new ArrayList<>();
                    ArrayList<Foto> imagenes = new ArrayList<>();
                    
                    rs.next();

                    do{
                        if(rs.getInt("IDSosp")!=id){
                            rs.previous();
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                            SospSimple nuevo=new SospSimple(rs.getInt("IDSosp"), rs.getString("Nombre"),
                              rs.getString("Apellidos"), rs.getString("Antecedentes"),telefonos , correos, direcciones, matriculas, imagenes);
                            
                            suspects.add(nuevo);
                        }else{
                            //hay que recoorrer las filas pertenecientes al mismo sujeto creando los arraylist correspondientes.
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                        }
                    }while(rs.next());
                }
        return suspects;
    }
    
    public ArrayList<SospSimple> buscarXDireccion(String dir) throws SQLException{
        ArrayList<SospSimple> suspects = new ArrayList<>();
        String lineaSQL="Select sosp.*,t.NumTel, c.DirCor, d.NomDir, m.NumMat "
                + "from sospechoso sosp, telefono t, direccion d, correo c, matricula m "
                + "where d.NomDir="+dir
                +" and t.IDSosp=sosp.IDSosp"
                +" and c.IDSosp=sosp.IDSosp"
                +" and d.IDSosp=sosp.IDSosp"
                +" and m.IDSosp=sosp.IDSosp;";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Select.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = preparedStmt.executeQuery();
        while(rs.next()){
                    int id=rs.getInt("IDSosp");
                    ArrayList<String> telefonos=new ArrayList<>();
                    ArrayList<String> correos=new ArrayList<>();
                    ArrayList<String> direcciones=new ArrayList<>();
                    ArrayList<String> matriculas=new ArrayList<>();
                    ArrayList<Foto> imagenes = new ArrayList<>();
                    
                    rs.next();

                    do{
                        if(rs.getInt("IDSosp")!=id){
                            rs.previous();
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                            SospSimple nuevo=new SospSimple(rs.getInt("IDSosp"), rs.getString("Nombre"),
                              rs.getString("Apellidos"), rs.getString("Antecedentes"),telefonos , correos, direcciones, matriculas, imagenes);
                            
                            suspects.add(nuevo);
                        }else{
                            //hay que recoorrer las filas pertenecientes al mismo sujeto creando los arraylist correspondientes.
                            telefonos.add(rs.getString("NumTel"));
                            correos.add(rs.getString("DirCor"));
                            direcciones.add(rs.getString("NomDir"));
                            matriculas.add(rs.getString("NumMat"));
                        }
                    }while(rs.next());
                }
        return suspects;
    }
    
    /**
     * SIN TERMINAR
     * @throws SQLException 
     */
    public static ArrayList<SospSimple> selectAllSosp() throws SQLException
	{
		ArrayList<SospSimple> suspects = new ArrayList<>();

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
