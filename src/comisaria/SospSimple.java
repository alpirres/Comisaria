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
public class SospSimple {
    public int id;
    public String nombre;
    public String apellidos;
    public String antecedentes;
    public String hechos;
    public ArrayList<String> telefonos=new ArrayList<String>();
    public ArrayList<String> correo=new ArrayList<String>();
    public ArrayList<String> direccion=new ArrayList<String>();
    public ArrayList<String> matricula=new ArrayList<String>();
    
    public SospSimple(int i, String n, String ap, String an, ArrayList<String> t,ArrayList<String>  c, ArrayList<String> d, ArrayList<String> m){
        this.id=i;
        this.nombre=n;
        this.apellidos=ap;
        this.antecedentes=an;
        telefonos = t;
        System.out.println(t.get(0)+"es estos");
        correo=c;
        direccion=d;
        matricula=m;
    }
}