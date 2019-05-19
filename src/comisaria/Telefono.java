/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import java.util.ArrayList;

/**
 *
 * @author omar
 */
public class Telefono {
//Atributos

    /*Variable para almacenar todos los telefonos del sospechoso*/
    public ArrayList<String> telefonos;
    /* Variable que almacena el id del sospechoso*/
    public int id;

    /**
     * Constructor para inicializar las variables.
     *
     * @param id Recibe el id del sospechoso
     * @param tel Recibe el listado de telefonos
     */
    public Telefono(int id, String[] tel) {
        this.setTelefono(tel);
        this.id = id;
    }

    /**
     * Método que permite guardar teléfonos una vez se comprueba que no lo están
     * ya.
     *
     * @param t Array de telefonos a guardar.
     */
    public void setTelefono(String[] t) {
        telefonos.add(t[0]);
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < telefonos.size(); j++) {
                if (!telefonos.contains(t[i])) {
                    telefonos.add(t[i]);

                }
            }

        }

    }

    /**
     * Método que permite el borrado de telefonos del listado del sospechoso
     *
     * @param elitel Array de telefonos a eliminar
     */
    public void eliminaTelefono(String[] elitel) {
        for (int i = 0; i < elitel.length; i++) {
            for (int j = 0; j < this.telefonos.size(); j++) {
                if (elitel[i].equals(this.telefonos.get(j))) {
                    this.telefonos.remove(j);
                }
            }
        }
    }
}
