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
public class Matricula {
//Atributos

    /*Variable para almacenar todas las matrículas del sospechoso*/
    public ArrayList<String> matriculas;
    /* Variable que almacena el id del sospechoso*/
    public int id;

    /**
     * Constructor para inicializar las variables
     *
     * @param id Toma el id del sospechoso
     * @param mat Recibe un ArrayList variable de matrículas.
     */
    public Matricula(int id, String[] mat) {
        this.setMatricula(mat);
        this.id = id;
    }

    /**
     * Método para guardar matrículas una vez se comprueban que no estén en el
     * listado
     *
     * @param a
     */
    public void setMatricula(String[] a) {
        int contador = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < this.matriculas.size(); j++) {
                if (!a[i].equals(this.matriculas.get(j))) {
                    contador++;
                }
            }
            if (contador == this.matriculas.size()) {
                this.matriculas.add(a[i]);
                contador = 0;
            }
        }

    }

    /**
     * Método que permite eliminar una serie de matrículas recibidas
     *
     * @param elimat Array de matrículas a eliminar.
     */
    public void eliminaMatricula(String[] elimat) {
        for (int i = 0; i < elimat.length; i++) {
            for (int j = 0; j < this.matriculas.size(); j++) {
                if (elimat[i].equals(this.matriculas.get(j))) {
                    this.matriculas.remove(j);
                }
            }
        }
    }
}
