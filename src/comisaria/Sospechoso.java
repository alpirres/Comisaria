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

    //Atributos
    /*
    Variable que almacena la id del ultimo sospechoso
     */
    public static int idglobal = 0;
    /*
    Variable que almacena el nombre del sospechoso
     */
    public String nombre;
    /*
    Variable que almacena los apellidos del sospechoso
     */
    public String apellidos;
    /*
    Variable que almacena la identificación del sospechoso
     */
    public int id;
    /*
    Variable que almacena los telefonos del sospechoso
     */
    public Telefono telefono;
    /*
    Variable que almacena los correos del sospechoso
     */
    public Correo correo;
    /*
    Variable que almacena las direcciones del sospechoso
     */
    public Direccion direccion;
    /*
    Variable que almacena las matrículas de vehículos del sospechoso
     */
    public Matricula matricula;
    /*
    Variable que almacena los posibles sospechosos asociados al actual
     */
    public ArrayList<Integer> acompanante;
    /*
    Variable que almacena los antecedentes penales del sospechoso
     */
    public String antecedentes;
    /*
    Variable que almacena los hechos por los que es considerado sospechoso actualmente
     */
    public String hechos;
    /*
    Variable que almacena las fotos del sospechoso
     */
    public File[] fotos;

    /**
     * Constructor de Sospechoso, donde se estructurarán todos los datos
     * necesarios.
     *
     * @param n Recibe el nombre del sospechoso
     * @param a Recibe el apellido del sospechoso
     * @param tel Recibe los telefonos del sospechoso
     * @param cor Recibe los correos del sospechoso
     * @param direc Recibe las direcciones del sospechoso
     * @param mat Recibe las matriculas del sospechoso
     * @param sus Recibe los acompañantes del sospechoso (posibles sospechosos)
     * @param ant Recibe los antecedentes del sospechoso
     * @param hech Recibe los hechos del caso del sospechoso
     */
    public Sospechoso(String n, String a, String[] tel, String[] cor, String[] direc, String[] mat, int[] sus, String ant, String hech) {
        id = sumaId();
        this.correo = new Correo(this.id, cor);
        this.direccion = new Direccion(this.id, direc);
        this.matricula = new Matricula(this.id, mat);
        this.telefono = new Telefono(this.id, tel);
        cambiaNombre(n);
        cambiaApellido(a);
        cambiaMatricula(mat);
        añadeAcompanante(sus);
        cambiaAntecedente(ant);
        cambiaHechos(hech);

    }

    /**
     * Método para la asignación del ID del sospechoso
     *
     * @return
     */
    public int sumaId() {
        idglobal++;
        return this.idglobal;
    }

    /**
     * Permite modificar el nombre del sospechoso
     *
     * @param nom
     */
    public void cambiaNombre(String nom) {

        this.nombre = nom;

    }

    /**
     * Permite modificar el apellido del sospechoso
     *
     * @param apel
     */
    public void cambiaApellido(String apel) {

        this.apellidos = apel;

    }

    /**
     * Permite guardar los telefonos del sospechoso. Comprueba si ya están
     * guardados y guarda los que no.
     *
     * @param telfo
     */
    public void cambiaTelefono(String[] telfo) {

        this.telefono.setTelefono(telfo);

    }

    /**
     * Permite guardar los correos del sospechoso. Comprueba si ya están
     * guardados y guarda los que no.
     *
     * @param corr
     */
    public void cambiaCorreo(String[] corr) {

        this.correo.setCorreo(corr);

    }

    /**
     * Permite guardar las direcciones del sospechoso.
     *
     * @param direc
     */
    public void cambiaDireccion(String[] direc) {

        this.direccion.setDireccion(direc);

    }

    /**
     * Permite guardar las matrículas del sospechoso. Comprueba si ya están
     * guardadas y guarda las que no.
     *
     * @param matri
     */
    public void cambiaMatricula(String[] matri) {

        this.matricula.setMatricula(matri);

    }

    /**
     * Permite modificar los antecedentes del sospechoso.
     *
     * @param coment
     */
    public void cambiaAntecedente(String coment) {

        this.antecedentes = coment;

    }

    /**
     * Permite modificar los hechos del sospechoso en el caso.
     *
     * @param hec
     */
    public void cambiaHechos(String hec) {

        this.hechos = hec;

    }

    /**
     * Permite añadir un nuevo acompañante del sospechoso
     *
     * @param acompa
     */
    public void añadeAcompanante(int[] acompa) {
        for (int i = 0; i < acompa.length; i++) {
            this.acompanante.add(acompa[i]);
        }

    }

    /**
     * Permite eliminar un acompañañnte del sospechoso
     *
     * @param acomp
     */
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
