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
public class Telefono {
//Atributos

    /*Variable para almacenar todos los telefonos del sospechoso*/
    public ArrayList<Integer> telefonos;
    /* Variable que almacena el id del sospechoso*/
    protected int id;
/**
 * Constructor para inicializar las variables.
 * @param id Recibe el id del sospechoso
 * @param tel Recibe el listado de telefonos
 */
    public Telefono(int id, ArrayList<Integer> tel) {
        int [] tmp=tel.stream().mapToInt(Integer::intValue).toArray(); //Object to INT
        setTelefono(tmp);
        this.id = id;
    }
/**
 * Método para obtener el lsitado de teléfonos del sospechoso
 * @return 
 */
    public ArrayList<Integer> getTelefono() {

        return telefonos;
    }
/**
 * Método que permite guardar teléfonos una vez se comprueba que no lo están ya.
 * @param t Array de telefonos a guardar.
 */
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
     * devuelve un ArrayList con los teléfonos no existentes.
     * @param d Array de telefonos a analizar.
     * @return Integer[] Array de enteros con los telefonos que se van a guardar.
     *
     */
    public Integer[] existeTelefono(int[] t) {
        ArrayList<Integer> telExist = new ArrayList<>();

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < this.telefonos.size(); j++) {
                if (t[i]!= telefonos.get(j)) {
                    telExist.add(t[i]);

                }
            }
        }
        return (Integer[]) telExist.toArray();
        
    }
    /**
     * Método que permite el borrado de telefonos del listado del sospechoso
     * @param elitel Array de telefonos a eliminar
     */
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
