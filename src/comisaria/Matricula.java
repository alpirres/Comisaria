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


class Matricula {
    
    private ArrayList<String> matriculas;
    protected int id;
    
    public Matricula(int id, ArrayList<String> mat){
        this.matriculas = mat; 
        this.id=id;
    }
    
    
    
    
    public ArrayList<String> getMatriculas(){

        return matriculas;
    }  
    
    public void setMatricula(String[] a){
        
        for(int i=0; i<a.length; i++){
            this.matriculas.add(a[i]);
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
    public ArrayList<String> existeMatricula(String[] a){
        ArrayList<String> matExist = null;
        
        for(int i=0; i<a.length; i++){
            for(int j=0; j<this.matriculas.size(); j++){
                if(a[i].equals(matriculas.get(j))){
                    matExist.add(a[i]);
                            
                }
            }      
        }
   
        return matExist;
    }
}
