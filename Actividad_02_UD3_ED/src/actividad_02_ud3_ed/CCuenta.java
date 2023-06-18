/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_02_ud3_ed;

/**
 * @author Ana
 */
public class CCuenta {
    protected String nombre;
    private String numCuenta;
    private double saldo;
    private double tipoInteres;

    public CCuenta() {}

   /**
    * @param nombre Nombre del titular de la cuenta.
    * @param numCuenta Número de la cuenta.
    * @param saldo Saldo disponible de la cuenta.
    * @param tipoInteres El tipo de interés asociado a la cuenta.
    */
    public CCuenta(String nombre, String numCuenta, double saldo, double tipoInteres) {
        this.nombre = nombre;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.tipoInteres = tipoInteres;
    }

    /**
     * @param nombre El nombre a asignar a la cuenta.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return El nombre del titular de la cuenta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el número de cuenta.
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * @param numCuenta el número de la cuenta.
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * @return El saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo el nuevo saldo en la cuenta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return el tipo de interés asociado a esta cuenta.
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
     * @param tipoInteres el interés asociado a esta cuenta.
     */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    /**
     * @param cantidad la cantidad que se desea ingresar.
     * @throws IllegalArgumentException cuando se intenta ingresar una cantidad igual o menor a 0.
     */
    public void ingresar(double cantidad) throws IllegalArgumentException {
        if (cantidad == 0) {
            throw new IllegalArgumentException("No ha retirado nada");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("No se puede retirar una cantidad negativa");
        }
        setSaldo(saldo + cantidad);
    }

    /**
     * @param cantidad la cantidad que se desea retirar.
     * @throws IllegalArgumentException si la cantidad a retirar es igual o menor a 0.
     * @throws Exception cuando la cantidad es superior al saldo disponible.
     */
    public void retirar(double cantidad) throws Exception {
        if (cantidad == 0) {
            throw new IllegalArgumentException("No ha retirado nada");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("No se puede retirar una cantidad negativa");
        }
        if (getSaldo() < cantidad) {
            throw new Exception("No se hay suficiente saldo");
        }
        setSaldo(saldo - cantidad);
    }
}