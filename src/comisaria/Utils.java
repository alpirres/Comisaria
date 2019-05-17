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

    public static boolean validaTelefono(int telef) {
        boolean correcto = false;
        StringBuilder almacen = new StringBuilder();
        almacen.append(telef);
        String texto = almacen.toString();
        String expresion = "^[6|7|8|9]([0-9]){8}$";
        Pattern patron = Pattern.compile(expresion);

        Matcher matcher = patron.matcher(texto);
        if (matcher.matches()) {
            correcto = true;
        }

        return correcto;

    }

    public static boolean validaCorreo(String correo) {
        boolean correcto = false;
        StringBuilder almacen = new StringBuilder();
        almacen.append(correo);
        String texto = almacen.toString();
        String expresion = "^\\w+((\\-|\\w)*(\\.(\\-|\\w)+)*)\\@\\d*[a-zA-Z](\\d|[a-zA-Z])*\\.[a-zA-Z]{2,10}$";
        Pattern patron = Pattern.compile(expresion);

        Matcher matcher = patron.matcher(texto);
        if (matcher.matches()) {
            correcto = true;
        }

        return correcto;

    }

    public static boolean validaMatricula(String matri) {
        boolean correcto = false;
        StringBuilder almacen = new StringBuilder();
        almacen.append(matri);
        String texto = almacen.toString();
        String expresion = "^((A((L?B?)|(OE)|V)?)|(B(A|I|U)?)|(C((A(C|S)?)|C|S|E|O|R|U)?)|(FP)|(G(C|E|R|U))|(HU?)|(IF?)|J|(L(E|O|U)?)|(M(A|E|L|U)?)|(NA)|(OR?)|(P(A|M|O)?)|(RM)|(S((H?A?)|(E?G?)|O|S)?)|(T(A|(E(R|G)?)|F|G|O)?)|(V(A|I)?)|(ZA?))\\-\\d{5,6}$";
        String expresion2 = "^\\b((A(B|L|V)?)|(B(A|I|U)?)|(C(A|C|S|E|O|R|U)?)|(G(C|E|I|R|U))|(HU?)|(IB)|J|(L(E|O|R|U)?)|(M(A|L|U)?)|(NA)|(O(R|U)?)|(P(M|O)?)|(S(A|E|G|H|O|S)?)|(T(E|F|O)?)|(V(A|I)?)|(ZA?))\\-\\d{4}\\-[A-PS-Z]{1,2}\\b$";
        Pattern patron = Pattern.compile(expresion);
        Pattern patron2 = Pattern.compile(expresion2);

        Matcher matcher = patron.matcher(texto);
        Matcher matcher2 = patron2.matcher(texto);
        if (matcher.matches()) {
            correcto = true;
        } else {
            if (matcher2.matches()) {
                correcto = true;
            }
        }

        return correcto;

    }

    public static boolean validaDireccion(String direc) {
        boolean correcto = false;
        StringBuilder almacen = new StringBuilder();
        almacen.append(direc);
        String texto = almacen.toString();
        String expresion = "^\\w+.\\d+$";
        Pattern patron = Pattern.compile(expresion);

        Matcher matcher = patron.matcher(texto);
        if (matcher.matches()) {
            correcto = true;
        }

        return correcto;

    }

    public static boolean validaNombre(String nom) {
        boolean correcto = false;
        StringBuilder almacen = new StringBuilder();
        almacen.append(nom);
        String texto = almacen.toString();
        String expresion = "^((([A-Z]|[Á-É-Í-Ó-Ú])([a-z]|[ñ]|[á-é-í-ó-ú])+)(.|\\s))+$";
        Pattern patron = Pattern.compile(expresion);

        Matcher matcher = patron.matcher(texto);
        if (matcher.matches()) {
            correcto = true;
        }

        return correcto;

    }

    public static boolean validaApellido(String apell) {
        boolean correcto = false;
        StringBuilder almacen = new StringBuilder();
        almacen.append(apell);
        String texto = almacen.toString();
        String expresion = "^((([A-Z]|[Á-É-Í-Ó-Ú])([a-z]|[ñ]|[á-é-í-ó-ú])+)(.|\\s))+$";
        Pattern patron = Pattern.compile(expresion);

        Matcher matcher = patron.matcher(texto);
        if (matcher.matches()) {
            correcto = true;
        }

        return correcto;

    }
}
