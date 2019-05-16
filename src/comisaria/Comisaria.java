/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import BasedeDatos.Conexion;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alfon
 */
public class Comisaria {

    /**
     * @param args
     * @throws Exception
     */
    //Objeto de tipo Conexion para gestionar la conexion a la base de datos 
    public static Conexion miConexion;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //Realizamos la conexión 
        miConexion=new Conexion("127.0.0.1","comisaria","root","");
        miConexion.inicializar();
        if (miConexion.conectar()==false) 
        { 
            System.out.println("No se ha podido conectar a la base de datos");
        } else {
            System.out.println("Conexión satisfactoria a la base de datos");
        }
         

    }

}
