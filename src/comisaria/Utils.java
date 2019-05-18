/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisaria;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Omar
 */
public class Utils {

    /**
     * 
     * @param telef
     * @return 
     */
    public static boolean validaTelefono(String telef) {
        boolean correcto = false;
        String expresion = "^[6|7|8|9]([0-9]){8}$";
        if (Pattern.matches(expresion,telef)) {
            correcto = true;
        }
        return correcto;
    }
    /**
     * 
     * @param correo
     * @return 
     */
    public static boolean validaCorreo(String correo) {
        boolean correcto = false;
        String expresion = "^\\w+((\\-|\\w)*(\\.(\\-|\\w)+)*)\\@\\d*[a-zA-Z](\\d|[a-zA-Z])*\\.[a-zA-Z]{2,10}$";
        if (Pattern.matches(expresion,correo)) {
            correcto = true;
        }

        return correcto;

    }
    /**
     * 
     * @param matri
     * @return 
     */
    public static boolean validaMatricula(String matri) {
        boolean correcto = false;
        String expresion = "^((A((L?B?)|(OE)|V)?)|(B(A|I|U)?)|(C((A(C|S)?)|C|S|E|O|R|U)?)|(FP)|(G(C|E|R|U))|(HU?)|(IF?)|J|(L(E|O|U)?)|(M(A|E|L|U)?)|(NA)|(OR?)|(P(A|M|O)?)|(RM)|(S((H?A?)|(E?G?)|O|S)?)|(T(A|(E(R|G)?)|F|G|O)?)|(V(A|I)?)|(ZA?))\\-\\d{5,6}$";
        String expresion2 = "^\\b((A(B|L|V)?)|(B(A|I|U)?)|(C(A|C|S|E|O|R|U)?)|(G(C|E|I|R|U))|(HU?)|(IB)|J|(L(E|O|R|U)?)|(M(A|L|U)?)|(NA)|(O(R|U)?)|(P(M|O)?)|(S(A|E|G|H|O|S)?)|(T(E|F|O)?)|(V(A|I)?)|(ZA?))\\-\\d{4}\\-[A-PS-Z]{1,2}\\b$";
        if (Pattern.matches(expresion,matri)) {
            correcto = true;
        } else if (Pattern.matches(expresion2,matri)) {
            correcto = true;
        }
        return correcto;
    }
    
    /**
     * 
     * @param direc
     * @return 
     */
    public static boolean validaDireccion(String direc) {
        boolean correcto = false;
        String expresion = "^\\w+.\\d+$";
        if (Pattern.matches(expresion,direc)) {
            correcto = true;
        }
        return correcto;
    }
    /**
     * funcion que valida que se introduzaca en el campo la primera letra con mayuscula 
     * @param nom String que recibe el contenido del campo a validar
     * @return booleanoo si valida
     */
    public static boolean validaNombre(String nom) {
        boolean correcto = false;
        String expresion = "^((([A-Z]|[Á-É-Í-Ó-Ú])([a-z]|[ñ]|[á-é-í-ó-ú])+)(.|\\s))+$";
        if (Pattern.matches(expresion,nom)) {
            correcto = true;
        }
        return correcto;
    }
}
