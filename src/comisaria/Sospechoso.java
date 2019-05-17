/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import java.io.File;
import java.util.ArrayList;
import comisaria.Utils;

/**
 *
 * @author Omar
 */
public class Sospechoso {

    public String nombre;
    public String apellidos;
    public int id;
    public Telefono telefono;
    public Correo correos;
    public Direccion direccion;
    public Matricula matricula;
    public ArrayList<Integer> acompanante;
    public String antecedentes;
    public String hechos;
    public File[] fotos;

    public Sospechoso(String n, String a, int[] tel, String[] cor, String[] direc, String[] mat, int[] sus, String ant, String hech) {
        cambiaNombre(n);
        cambiaApellido(a);
        cambiaTelefono(tel);
        cambiaCorreo(cor);
        cambiaDireccion(direc);
        cambiaMatricula(mat);
        añadeAcompanante(sus);
        cambiaAntecedente(ant);
        cambiaHechos(hech);

    }

    public void cambiaNombre(String nom) {

        this.nombre = nom;

    }

    public void cambiaApellido(String apel) {

        this.apellidos = apel;

    }

    public void cambiaTelefono(int[] telfo) {

        this.telefono.setTelefono(telfo);

    }

    public void cambiaCorreo(String[] corr) {

        this.correos.setCorreo(corr);

    }

    public void cambiaDireccion(String[] direc) {

        this.direccion.setDireccion(direc);

    }

    public void cambiaMatricula(String[] matri) {

        this.matricula.setMatricula(matri);

    }

    public void cambiaAntecedente(String coment) {

        this.antecedentes = coment;

    }

    public void cambiaHechos(String hec) {

        this.hechos = hec;

    }

    public void añadeAcompanante(int[] acompa) {
        for (int i = 0; i < acompa.length; i++) {
            this.acompanante.add(acompa[i]);
        }

    }

    public void eliminaAcompanante(int[] acomp) {
        for (int i = 0; i < acomp.length; i++) {
            for (int j = 0; j < this.acompanante.size(); j++) {
                if (acomp[i] == this.acompanante.get(j)) {
                    this.acompanante.remove(j);
                }
            }
        }
    }
}
