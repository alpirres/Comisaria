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
    public int id;
    /*Variable para almacenar todos los correos del sospechoso*/
    public ArrayList<String> correos;

    /**
     * Constructor de la clase para establecer los valores de las variables
     *
     * @param id Id obtenida del sospechoso
     * @param dir ArrayList variable de direcciones a introducir
     */
    public Correo(int id, String[] dir) {
        this.setCorreo(dir);
        this.id = id;
    }

    /**
     * Permite guardar nuevos correos en la variable comprobando previamente que
     * no están guardados ya.
     *
     * @param mail Array de correos a guardar
     */
    public void setCorreo(String[] mail) {
        int contador = 0;

        for (int i = 0; i < mail.length; i++) {
            for (int j = 0; j < this.correos.size(); j++) {
                if (!mail[i].equals(this.correos.get(j))) {
                    contador++;
                }
            }
            if (contador == this.correos.size()) {
                this.correos.add(mail[i]);
                contador=0;
            }
        }

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
