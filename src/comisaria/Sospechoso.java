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

    
    public Sospechoso(String n, String a, int i, int[] tel, String[] cor, String[] direc, String[] mat, int[] sus, String ant, String hech, File fot){
        
    }
    
    public boolean cambiaNombre(String nom){
        boolean hecho=false;
        this.nombre=nom;
        if(this.nombre.equals(nom)){
            hecho=true;
        }
        return hecho;
    }
    
    public boolean cambiaApellido(String apel){
        boolean hecho=false;
        this.apellidos=apel;
        if(this.apellidos.equals(apel)){
            hecho=true;
        }
        return hecho;
    }
    
    public boolean cambiaAntecedente(String coment){
        boolean hecho=false;
        this.antecedentes=coment;
        if(this.antecedentes.equals(coment)){
            hecho=true;
        }
        return hecho;
    }
    
    public boolean cambiaHechos(String hec){
        boolean hecho=false;
        this.hechos=hec;
        if(this.hechos.equals(hec)){
            hecho=true;
        }
        return hecho;
    }
    
    public boolean cambiaTelefono(int[] telfo){
        boolean hecho=false;
        for (int i = 0; i < telfo.length; i++) {
            if(Utils.validaTelefono(telfo[i])){
                this.telefono.setTelefono(telfo[i]);
            }
            if (i==telfo.length) {
                hecho=true;
            }
        }
        return hecho;
    }
    
    public boolean cambiaCorreo(String[] corr){
        boolean hecho=false;
        for (int i = 0; i < corr.length; i++) {
            if(Utils.validaCorreo(corr[i])){
                this.correos.setCorreo(corr[i]);
            }
            if (i==corr.length) {
                hecho=true;
            }
        }
        return hecho;
    }
    
    public boolean cambiaDireccion(String[] direc){
        boolean hecho=false;
        for (int i = 0; i < direc.length; i++) {
            this.matricula.setMatricula(direc);
        }
        return hecho;
    }
}
