/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Nightm4re
 */
public class Foto {
    
    public ArrayList<File> imagenes = new ArrayList<File>();
    public ArrayList<String> descripciones = new ArrayList<String>();
    
    public Foto(File f, String d){
        imagenes.add(f);
        descripciones.add(d);
        
    }
    
    
}
