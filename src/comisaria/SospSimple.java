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
    
    public String toString(){
        return this.nombre+" "+ this.apellidos +" "+this.correo+" "+this.direccion+" "+this.matricula+" "+this.hechos+" "+this.antecedentes;
    }
    
    public String telToString(){
        StringBuilder sb = new StringBuilder("");
            if(telefonos.size()!=0 && telefonos != null){
                for(int i=0;i<telefonos.size();i++){
                    sb.append(telefonos.get(i)+", ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public String corToString(){
        StringBuilder sb = new StringBuilder("");
            if(correo.size()!=0 && correo != null){
                for(int i=0;i<correo.size();i++){
                    sb.append(correo.get(i)+", ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public String dirToString(){
        StringBuilder sb = new StringBuilder("");
            if(direccion.size()!=0 && direccion != null){
                for(int i=0;i<direccion.size();i++){
                    sb.append(direccion.get(i)+", ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public String matToString(){
        StringBuilder sb = new StringBuilder("");
            if(matricula.size()!=0 && matricula != null){
                for(int i=0;i<matricula.size();i++){
                    sb.append(matricula.get(i)+", ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    
    
}