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
//Atributos

    /*Variable para almacenar todas las matrículas del sospechoso*/
    public ArrayList<String> matriculas;
    /* Variable que almacena el id del sospechoso*/
    protected int id;

    /**
     * Constructor para inicializar las variables
     *
     * @param id Toma el id del sospechoso
     * @param mat Recibe un ArrayList variable de matrículas.
     */
    public Matricula(int id, ArrayList<String> mat) {
        this.setMatricula((String[]) mat.toArray());
        this.id = id;
    }

    /**
     * Método que devuelve el listado de matrículas completas.
     *
     * @return
     */
    public ArrayList<String> getMatriculas() {

        return matriculas;
    }

    /**
     * Método para guardar matrículas una vez se comprueban que no estén en el
     * listado
     *
     * @param a
     */
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
     * Recibe un Array de matrículas para guardar las que no lo estén ya.
     *
     * @param d
     * @return String[] Devuelve un array de matrículas no guardadas
     */
    public String[] existeMatricula(String[] a) {
        ArrayList<String> matExist = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < this.matriculas.size(); j++) {
                if (!a[i].equals(matriculas.get(j))) {
                    matExist.add(a[i]);

                }
            }
        }

        return (String[]) matExist.toArray();
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
