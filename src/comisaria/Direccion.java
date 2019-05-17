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
public class Direccion {
//Atributos

    /*Variable para almacenar todas las direcciones del sospechoso*/
    public ArrayList<String> direcciones;
    /* Variable que almacena el id del sospechoso*/
    protected int id;

    /**
     * Constructor de direccion para establecer las variables de forma incial.
     *
     * @param id Recibe el id del sospechoso
     * @param dir Recibe el ArrayList de direcciones a guardar
     */
    public Direccion(int id, ArrayList<String> dir) {
        this.setDireccion((String[]) dir.toArray());
        this.id = id;
    }

    /**
     * Método para obtener las direcciones almacenadas
     *
     * @return
     */
    public ArrayList<String> getDireccion() {

        return this.direcciones;
    }

    /**
     * Método para guardar las direcciones, previa comprobación de si ya
     * existen.
     *
     * @param di Array de direcciones a almacenar
     */
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
     * @param d Recibe un array de direcciones a comprobar.
     * @return String[] Un Array de String con las direcciones a guardar
     */
    public String[] existeDireccion(String[] d) {
        ArrayList<String> dirExist = new ArrayList<>();

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < this.direcciones.size(); j++) {
                if (!d[i].equals(direcciones.get(j))) {
                    dirExist.add(d[i]);

                }
            }
        }

        return (String[]) dirExist.toArray();
    }

    /**
     * Método para eliminar una o varias direcciones del listado de los mismos
     *
     * @param elidir Array de direcciones a borrar
     */
    public void eliminaDireccion(String[] elidir) {
        for (int i = 0; i < elidir.length; i++) {
            for (int j = 0; j < this.direcciones.size(); j++) {
                if (elidir[i].equals(this.direcciones.get(j))) {
                    this.direcciones.remove(j);
                }
            }
        }
    }
}
