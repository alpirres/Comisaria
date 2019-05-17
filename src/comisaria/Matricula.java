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
public class Matricula {

    public ArrayList<String> matriculas;
    protected int id;

    public Matricula(int id, ArrayList<String> mat) {
        this.setMatricula((String[]) mat.toArray());
        this.id = id;
    }

    public ArrayList<String> getMatriculas() {

        return matriculas;
    }

    public void setMatricula(String[] a) {

        String[] dir = new String[existeMatricula(a).length];

        for (int i = 0; i < existeMatricula(a).length; i++) {
            dir[i] = existeMatricula(a)[i];
        }
        
        for (int i = 0; i < dir.length; i++) {
          this.matriculas.add(dir[i]);  
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
    public String[] existeMatricula(String[] a) {
        ArrayList<String> matExist = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < this.matriculas.size(); j++) {
                if (a[i].equals(matriculas.get(j))) {
                    matExist.add(a[i]);

                }
            }
        }

        return (String[]) matExist.toArray();
    }
    
    public void eliminaMatricula(String[] elimat){
        for (int i = 0; i < elimat.length; i++) {
            for (int j = 0; j < this.matriculas.size(); j++) {
                if (elimat[i].equals(this.matriculas.get(j))) {
                    this.matriculas.remove(j);
                }
            }
        }
    }
}
