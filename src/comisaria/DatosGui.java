/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import BasedeDatos.Insert;
import BasedeDatos.Select;
import java.sql.SQLException;

/**
 *
 * @author Nightm4re
 */
public class DatosGui {

    public String nombre;
    public String apellidos;
    public String hechos;
    public String antecedentes;
    public HashMap<String, String> dirItemsMap = new HashMap<String, String>();
    public HashMap<String, String> corItemsMap = new HashMap<String, String>();
    public HashMap<String, String> telItemsMap = new HashMap<String, String>();
    public HashMap<String, String> matItemsMap = new HashMap<String, String>();
    public ArrayList<Foto> listaImagenes = new ArrayList<Foto>();

    protected DatosGui() {

    }

    //Metodos para Matriculas
    protected void anadirKeyValueMat(String key, String value) {
        matItemsMap.put(key, value);
        
    }

    protected String getValueMat(String key) {
        String devuelve;

        devuelve = matItemsMap.get(key);
        return devuelve;
    }

    protected void setValueMat(String value, String key) {
        matItemsMap.replace(key, value);
        
    }

    protected HashMap getItemsMapMat() {

        return matItemsMap;
    }

    //Metodos para Direccion
    protected void anadirKeyValueDir(String key, String value) {
        dirItemsMap.put(key, value);
        

    }

    protected String getValueDir(String key) {
        String devuelve;

        devuelve = dirItemsMap.get(key);
        return devuelve;
    }

    protected void setValueDir(String value, String key) {
        dirItemsMap.replace(key, value);
        
    }

    protected HashMap getItemsMapDir() {

        return dirItemsMap;
    }

    //Metodos para Correo
    protected void anadirKeyValueCor(String key, String value) {
        corItemsMap.put(key, value);
        

    }

    protected String getValueCor(String key) {
        String devuelve;

        devuelve = corItemsMap.get(key);
        return devuelve;
    }

    protected void setValueCor(String value, String key) {
        corItemsMap.replace(key, value);
        
    }

    protected HashMap getItemsMapCor() {

        return corItemsMap;
    }

    //Metodos para numero
    protected void anadirKeyValueNum(String key, String value) {
        telItemsMap.put(key, value);

    }

    public String getValueNum(String key) {
        String devuelve;

        devuelve = telItemsMap.get(key);
        return devuelve;
    }

    protected void setValueNum(String value, String key) {
        telItemsMap.replace(key, value);

    }

    protected HashMap getItemsMapNum() {

        return telItemsMap;
    }

    protected byte[] showImagen(File archivo) {
        byte[] bytesImg = new byte[1024 * 1000];
        try {
            FileInputStream entrada = new FileInputStream(archivo);
            entrada.read(bytesImg);

        } catch (Exception e) {
        }
        return bytesImg;
    }

    protected ArrayList<String> comprobarDir() {
        ArrayList<String> noValidos = new ArrayList<String>();

        for (int i = 1; i < dirItemsMap.size(); i++) {
            
            if (dirItemsMap.get("Dirección " + i) != null) {
                
                if (!Utils.validaDireccion(dirItemsMap.get("Dirección " + i))) {
                    noValidos.add("Dirección " + i);
                    
                }
            }
        }

        return noValidos;
    }

    protected ArrayList<String> comprobarCor() {
        ArrayList<String> noValidos = new ArrayList<String>();

        for (int i = 1; i < corItemsMap.size(); i++) {
            
            if (corItemsMap.get("Correo " + i) != null) {
                
                if (!Utils.validaCorreo(corItemsMap.get("Correo " + i))) {
                    noValidos.add("Correo " + i);
                    
                }
            }
        }

        return noValidos;
    }

    protected ArrayList<String> comprobarMat() {
        ArrayList<String> noValidos = new ArrayList<String>();

        for (int i = 1; i < matItemsMap.size(); i++) {
            
            if (matItemsMap.get("Matrícula " + i) != null) {
                
                if (!Utils.validaDireccion(matItemsMap.get("Matrícula " + i))) {
                    noValidos.add("Matrícula " + i);
                    
                }
            }
        }

        return noValidos;
    }

    protected ArrayList<String> comprobarTel() {
        ArrayList<String> noValidos = new ArrayList<String>();

        for (int i = 1; i < telItemsMap.size(); i++) {
            
            if (telItemsMap.get("Número " + i) != null) {
                
                if (!Utils.validaDireccion(telItemsMap.get("Número " + i))) {
                    noValidos.add("Número " + i);
                    
                }
            }
        }

        return noValidos;
    }

    protected boolean enviarSospechoso() throws Exception {
        boolean hecho = false;
        Insert insertar = new Insert();
        ArrayList<String> telefonos = new ArrayList<String>();
        for (int i = 1; i < telItemsMap.size(); i++) {
            telefonos.add(getValueNum("Teléfono " + i));
           
        }
        
        ArrayList<String> correos = new ArrayList<String>();
        for (int i = 1; i < corItemsMap.size(); i++) {
            correos.add(corItemsMap.get("Correo " + i));

        }
        
        ArrayList<String> direcciones = new ArrayList<String>();
        for (int i = 1; i < dirItemsMap.size(); i++) {
            direcciones.add(dirItemsMap.get("Dirección " + i));

        }
        
        ArrayList<String> matriculas = new ArrayList<String>();
        for (int i = 1; i < matItemsMap.size(); i++) {
            matriculas.add(matItemsMap.get("Matrícula " + i));
            
        }
        
        
        

        
        int id = 0;
        try{
        id = Select.getIDGlobal();
        }catch(SQLException e){
            e.printStackTrace();
        }

        
        SospSimple todb = new SospSimple(id, nombre, apellidos, antecedentes,hechos, telefonos, correos, direcciones, matriculas, listaImagenes);
        try{
        hecho = insertar.insertSospechoso(todb);
        }catch(SQLException e){
            System.out.println("Error SQL");
        }
        return hecho;
    }

}
