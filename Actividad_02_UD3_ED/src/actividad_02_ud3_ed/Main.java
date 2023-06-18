/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_02_ud3_ed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

    /**
     * En un bucle do-while, se imprimen las posibles opciones del menú de operaciones, permitiendo al usuario
     * introducir un número en función de la operación que se desea realizar. Se puede ingresar y retirar dinero,
     * además de consultar el saldo disponible. La opción 4 correspone a salir del programa e introducir algo que no
     * sea uno de los números enteros indicados devlverá un mensaje de error.
     */
    public static void main(String[] args) {
        int opcion = 0;
        CCuenta cuenta1 = new CCuenta("Juan López","1000-2365-85-123456789",2500,0);
        do {
            try {
                System.out.println("""
                        
                        MENÚ DE OPERACIONES
                        -------------------
                        1 - Ingresar
                        2 - Retirar
                        3 - Ver saldo disponible
                        4 - Finalizar"""
                );
                opcion = Integer.parseInt(dato.readLine());
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuánto desea ingresar?: ");
                        float ingresar = Integer.parseInt(dato.readLine());
                        operativaCuenta(cuenta1, ingresar, opcion);
                        break;
                    case 2:
                        System.out.println("¿Cuánto desea retirar?: ");
                        float retirar = Integer.parseInt(dato.readLine());
                        operativaCuenta(cuenta1, retirar, opcion);
                        break;
                    case 3:
                        System.out.println("El saldo actual es " + cuenta1.getSaldo());
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.err.println("Opción errónea");
                        break;
                }
            }
            catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (opcion != 4);
    }

    /**
     * @param cuenta La cuenta sobre la que se va a operar.
     * @param cantidad La cantidad a ingresar o retirar, dependiendo de la opción.
     * @param opcion Entero que representa las opciones ingresar o retirar.
     */
    public static void operativaCuenta(CCuenta cuenta, float cantidad, int opcion) {
        if (opcion == 2) {
            try {
                cuenta.retirar(cantidad);
            }
            catch (Exception e) {
                System.out.print("Fallo al retirar");
            }
        }
        else if (opcion == 1) {
            try {
                System.out.println("Ingreso en cuenta");
                cuenta.ingresar(cantidad);
            }
            catch (Exception e) {
                System.out.print("Fallo al ingresar");
            }
        }
    }
}