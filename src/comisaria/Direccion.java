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
    public int id;

    /**
     * Constructor de direccion para establecer las variables de forma incial.
     *
     * @param id Recibe el id del sospechoso
     * @param dir Recibe el ArrayList de direcciones a guardar
     */
    public Direccion(int id, String[] dir) {
        this.setDireccion(dir);
        this.id = id;
    }

    /**
     * Método para guardar las direcciones, previa comprobación de si ya
     * existen.
     *
     * @param di Array de direcciones a almacenar
     */
    public void setDireccion(String[] di) {
        int contador = 0;

        for (int i = 0; i < di.length; i++) {
            for (int j = 0; j < this.direcciones.size(); j++) {
                if (!di[i].equals(this.direcciones.get(j))) {
                    contador++;
                }
            }
            if (contador == this.direcciones.size()) {
                this.direcciones.add(di[i]);
                contador = 0;
            }
        }

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
