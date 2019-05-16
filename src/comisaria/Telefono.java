/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author jlove
 */
class Telefono {

    private ArrayList<Integer> telefonos;
    protected int id;

    public Telefono(int id, ArrayList<Integer> tel) {
        int [] tmp=tel.stream().mapToInt(Integer::intValue).toArray(); //Object to INT
        setTelefono(tmp);
        this.id = id;
    }

    public ArrayList<Integer> getTelefono() {

        return telefonos;
    }

    public void setTelefono(int[] t) {
        
        int[] dir = new int[existeTelefono(t).length];

        for (int i = 0; i < existeTelefono(t).length; i++) {
            dir[i] = existeTelefono(t)[i];
        }
        
        for (int i = 0; i < dir.length; i++) {
          this.telefonos.add(dir[i]);  
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
    public Integer[] existeTelefono(int[] t) {
        ArrayList<Integer> telExist = new ArrayList<>();

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < this.telefonos.size(); j++) {
                if (t[i]== telefonos.get(j)) {
                    telExist.add(t[i]);

                }
            }
        }
        return (Integer[]) telExist.toArray();
        
    }
    
    public void eliminaTelefono(int[] elitel){
        for (int i = 0; i < elitel.length; i++) {
            for (int j = 0; j < this.telefonos.size(); j++) {
                if (elitel[i]==this.telefonos.get(j)) {
                    this.telefonos.remove(j);
                }
            }
        }
    }
}
