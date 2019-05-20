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
    public ArrayList<String> telefonos=new ArrayList<>();
    public ArrayList<String> correo=new ArrayList<>();
    public ArrayList<String> direccion=new ArrayList<>();
    public ArrayList<String> matricula=new ArrayList<>();
    
    public SospSimple(int i, String n, String ap, String an, ArrayList t,ArrayList  c, ArrayList d, ArrayList m){
        this.id=i;
        this.nombre=n;
        this.apellidos=ap;
        this.antecedentes=an;
        telefonos=new ArrayList<>(t);
        correo=new ArrayList<>(c);
        direccion=new ArrayList<>(d);
        matricula=new ArrayList<>(m);
    }
}