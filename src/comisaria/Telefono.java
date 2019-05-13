/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import java.util.ArrayList;

/**
 *
 * @author jlove
 */


class Telefono {
    
    private ArrayList<Integer> telefonos;
    protected int id;
    
    public Telefono(int id, ArrayList<Integer> tel){
        this.telefonos = tel; 
        this.id=id;
    }
    
    
    
    
    public ArrayList<Integer> getTelefono(){
        
        return telefonos;
    }
    
    public void setTelefono(int[] t){
        
        for(int i=0; i<t.length; i++){
            this.telefonos.add(t[i]);
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
    
    public ArrayList<Integer> existeTelefono(int[] t){
        ArrayList<Integer> telExist = null;
        
        for(int i=0; i<t.length; i++){
            for(int j=0; j<this.telefonos.size(); j++){
                if(t[i] == telefonos.get(j)){
                    telExist.add(t[i]);
                            
                }
            }      
        }
        return telExist;
    }
}
