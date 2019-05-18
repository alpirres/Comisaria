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
public class Correo {

    //Atributos
    /* Variable que almacena el id del sospechoso*/
    int id;
    /*Variable para almacenar todos los correos del sospechoso*/
    public ArrayList<String> correos;

    /**
     * Constructor de la clase para establecer los valores de las variables
     *
     * @param id Id obtenida del sospechoso
     * @param dir ArrayList variable de direcciones a introducir
     */
    public Correo(int id, ArrayList<String> dir) {
        this.setCorreo((String[]) dir.toArray());
        this.id = id;
    }

    /**
     * Getter del ArrayList de correos. Permite obtener el listado de correos
     * asociados al sospechoso
     *
     * @return
     */
    public ArrayList<String> getCorreo() {
        return this.correos;
    }

    /**
     * Permite guardar nuevos correos en la variable comprobando previamente que
     * no están guardados ya.
     *
     * @param mail Array de correos a guardar
     */
    public void setCorreo(String[] mail) {
        String[] cor = new String[existeCorreo(mail).length];

        for (int i = 0; i < existeCorreo(mail).length; i++) {
            cor[i] = existeCorreo(mail)[i];
        }

        for (int i = 0; i < cor.length; i++) {
            this.correos.add(cor[i]);
        }
    }

    /**
     * Método de comprobación de existencia de correos ya guardados
     *
     * @param corre Array de correos
     * @return
     */
    public String[] existeCorreo(String[] corre) {
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

    /**
     * Método que permite eliminar un correo almacenado comprobando si está
     * introducido.
     *
     * @param elicorr Array de correos a eliminar
     */
    public void eliminaCorreo(String[] elicorr) {
        for (int i = 0; i < elicorr.length; i++) {
            for (int j = 0; j < this.correos.size(); j++) {
                if (elicorr[i].equals(this.correos.get(j))) {
                    this.correos.remove(j);
                }
            }
        }
    }

}
