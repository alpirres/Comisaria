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
class Correo {
    private int idCorreo;
    private ArrayList<String> correos;
    
    public ArrayList<String> getCorreo(){
        return this.correos;
    }
    public void setCorreo(String mail){
        correos.add(mail);
    }
    
    
}
