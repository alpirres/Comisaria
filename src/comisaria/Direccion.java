/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import java.util.ArrayList;

/**
 *
 * @author Nightm4re
 */


class Direccion {
    
    private ArrayList<String> direcciones;
    protected int id;
    
    public Direccion(int id, ArrayList<String> dir){
        this.direcciones = dir; 
        this.id=id;
    }
    
    
    
    
    public ArrayList<String> getMatriculas(){

        return direcciones;
    }  
    
    public void setMatricula(String[] a){
        
        for(int i=0; i<a.length; i++){
            this.direcciones.add(a[i]);
        }
        
    }
    
    /** 
     * Recibe un Array de String, comprueba si hay alguna coincidencia 
     * y devuelve un ArrayList con las coincidencias.
     * 
     * @Author: Nightm4re
     * @param d
     * @return ArrayList<String>
     * 
     */
    
    public ArrayList<String> existeMatricula(String[] d){
        ArrayList<String> dirExist = null;
        
        for(int i=0; i<d.length; i++){
            for(int j=0; j<this.direcciones.size(); j++){
                if(d[i].equals(direcciones.get(j))){
                    dirExist.add(d[i]);
                            
                }
            }      
        }
   
        return dirExist;
    }
}
