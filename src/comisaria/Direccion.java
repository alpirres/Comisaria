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
public class Direccion {

    public ArrayList<String> direcciones;
    protected int id;

    public Direccion(int id, ArrayList<String> dir) {
        this.setDireccion((String[]) dir.toArray());
        this.id = id;
    }

    public ArrayList<String> getDireccion() {

        return this.direcciones;
    }

    public void setDireccion(String[] di) {
        String[] dir = new String[existeDireccion(di).length];

        for (int i = 0; i < existeDireccion(di).length; i++) {
            dir[i] = existeDireccion(di)[i];
        }
        
        for (int i = 0; i < dir.length; i++) {
          this.direcciones.add(dir[i]);  
        }
        

    }

    /**
     * Recibe un Array de String, comprueba si hay alguna coincidencia y
     * devuelve un ArrayList con las coincidencias.
     *
     * @Author: Nightm4re
     * @param d
     * @return ArrayList<String>
     *
     */
    public String[] existeDireccion(String[] d) {
        ArrayList<String> dirExist = new ArrayList<>();

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < this.direcciones.size(); j++) {
                if (d[i].equals(direcciones.get(j))) {
                    dirExist.add(d[i]);

                }
            }
        }

        return (String[]) dirExist.toArray();
    }
    
    public void eliminaDireccion(String[] elidir){
        for (int i = 0; i < elidir.length; i++) {
            for (int j = 0; j < this.direcciones.size(); j++) {
                if (elidir[i].equals(this.direcciones.get(j))) {
                    this.direcciones.remove(j);
                }
            }
        }
    }
}
