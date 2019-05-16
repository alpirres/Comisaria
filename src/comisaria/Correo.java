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

    int id;
    private ArrayList<String> correos;

    public Correo(int id, ArrayList<String> dir) {
        this.setCorreo((String[]) dir.toArray());
        this.id = id;
    }
    
    public ArrayList<String> getCorreo() {
        return this.correos;
    }

    public void setCorreo(String[] mail) {
        String[] cor = new String[existeCorreo(mail).length];

        for (int i = 0; i < existeCorreo(mail).length; i++) {
            cor[i] = existeCorreo(mail)[i];
        }
        
        for (int i = 0; i < cor.length; i++) {
          this.correos.add(cor[i]);  
        }
    }
    
    public String[] existeCorreo(String[] corre){
        ArrayList<String> almacen = new ArrayList<>();
        
        for (int i = 0; i < corre.length; i++) {
            for (int j = 0; j < this.correos.size(); j++) {
                if (!corre[i].equals(this.correos.get(j))) {
                    almacen.add(corre[i]);

                }
            }
        }

        return (String[]) almacen.toArray();
    }
    
    public void eliminaCorreo(String[] elicorr){
        for (int i = 0; i < elicorr.length; i++) {
            for (int j = 0; j < this.correos.size(); j++) {
                if (elicorr[i].equals(this.correos.get(j))) {
                    this.correos.remove(j);
                }
            }
        }
    }

}
