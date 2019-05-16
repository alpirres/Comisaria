/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 *
 * @author Nightm4re
 */
public class DatosGui {
    
    
    private HashMap<String, String> dirItemsMap = new HashMap<String, String>();
    private HashMap<String, String> corItemsMap = new HashMap<String, String>();
    private HashMap<String, String> telItemsMap = new HashMap<String, String>();
    private HashMap<String, String> matItemsMap = new HashMap<String, String>();
    
    
    protected DatosGui(){
        
    }
    
        //Metodos para Matriculas
    
    protected void anadirKeyValueMat(String key, String value){
        matItemsMap.put(key,value);
        System.out.println("Insertando // '"+value+"' en '"+key+"'");
        
    }
    
    protected String getValueMat(String key){
        String devuelve;
        
        devuelve = matItemsMap.get(key);
        return devuelve;
    }
    
    protected void setValueMat(String value, String key){
        matItemsMap.replace(key, value);
        System.out.println("Reemplazando -- '"+value+"' en '"+key+"'");
    }
    
    protected HashMap getItemsMapMat(){
        
        return matItemsMap;
    }
    
        //Metodos para Direccion
    
    protected void anadirKeyValueDir(String key, String value){
        dirItemsMap.put(key,value);
        System.out.println("Insertando // '"+value+"' en '"+key+"'");
        
    }
    
    protected String getValueDir(String key){
        String devuelve;
        
        devuelve = dirItemsMap.get(key);
        return devuelve;
    }
    
    protected void setValueDir(String value, String key){
        dirItemsMap.replace(key, value);
        System.out.println("Reemplazando -- '"+value+"' en '"+key+"'");
    }
    
    protected HashMap getItemsMapDir(){
        
        return dirItemsMap;
    }
        
    //Metodos para Correo
    
    protected void anadirKeyValueCor(String key, String value){
        corItemsMap.put(key,value);
        System.out.println("Insertando // '"+value+"' en '"+key+"'");
        
    }
    

    
    protected String getValueCor(String key){
        String devuelve;
        
        devuelve = corItemsMap.get(key);
        return devuelve;
    }
    
    protected void setValueCor(String value, String key){
        corItemsMap.replace(key, value);
        System.out.println("Reemplazando -- '"+value+"' en '"+key+"'");
    }
    
    protected HashMap getItemsMapCor(){
        
        return corItemsMap;
    }
    
    //Metodos para numero
    
    protected void anadirKeyValueNum(String key, String value){
        telItemsMap.put(key,value);
        System.out.println("Insertando // '"+value+"' en '"+key+"'");
        
    }
    
    protected String getValueNum(String key){
        String devuelve;
        
        devuelve = telItemsMap.get(key);
        return devuelve;
    }
    
    protected void setValueNum(String value, String key){
        telItemsMap.replace(key, value);
        System.out.println("Reemplazando -- '"+value+"' en '"+key+"'");
    }
    
    protected HashMap getItemsMapNum(){
        
        return telItemsMap;
    }
    
    
}
