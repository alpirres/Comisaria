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

    String nombre;
    String apellidos;
    int id;
    Telefono telefono;
    Correo correos;
    Direccion direccion;
    Matricula matricula;
    ArrayList<Sospechoso> acompanante;
    String antecedentes;
    String hechos;
    File fotos;

    public Sospechoso(String n, String a, int i, int[] tel, String[] cor, String[] direc, String[] mat, int[] sus, String ant, String hech, File fot) {

    }

    public void cambiaNombre(String nom) {

        this.nombre = nom;

    }

    public void cambiaApellido(String apel) {

        this.apellidos = apel;

    }

    public void cambiaAntecedente(String coment) {

        this.antecedentes = coment;

    }

    public void cambiaHechos(String hec) {

        this.hechos = hec;

    }

    public void cambiaTelefono(int[] telfo) {

        this.telefono.setTelefono(telfo);

    }

    public void cambiaCorreo(String[] corr) {

        this.correos.setCorreo(corr);

    }

    public void cambiaDireccion(String[] direc) {

        this.matricula.setMatricula(direc);

    }
}
