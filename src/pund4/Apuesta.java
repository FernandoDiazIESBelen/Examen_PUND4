/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pund4;

/**
 * 
 * @author Usuario
 * @since 29/04/2024
 * @version 1.0
 */
public class Apuesta {

   /**
    * Metodo de selección del atributo goles_local
    * @return 
    */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * Metodo de acceso al atributo goles_local
     * @param goles_local 
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

   
    /**
     * Metodo de selección del atributo goles_visitantes
     * @return 
     */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * Metodo de acceso al atributo goles_visitante
     * @param goles_visitante 
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * Metodo de selección del atributo apostado
     * @return 
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * Metodo de acceso al atributo apostado
     * @param apostado 
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    /**
     * Atributo privado dinero_disp
     */
    private int dinero_disp;
    /**
     * Atributo privado goles_local
     */
    private int goles_local;
    /**
     * Atributos privado goles_visitantes
     */
    private int goles_visitante;
    /**
     * Atributos privado apostado
     */
    private int apostado;

    /**
     * Contructor por defecto
     */
    public Apuesta() {
    }

    /**
     * Contructor con parámetros
     * @param dinero_disp parametro para el dinero disponible
     * @param goles_local parametro para los goles locales
     * @param goles_visitante parametro para los goles de los visitantes
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    
    /**
     * Método para obtener el valor del atributo dinero_disp
     * @return 
     */
    public int getDinero_disp() {
        return dinero_disp;
    }
    
    /**
     * Método para modificar el valor del atributo dinero_disp
     * @param dinero_disp 
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /**
     * Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     * @param dinero parametro para la apuesta
     * @throws Exception una excepción para no apostar más de lo que tienes
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }
    
    /**
     * Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * @param local parametro para los resultados locales
     * @param visitante parametro para los resultados visitantes
     * @return
     * @throws Exception 
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    /**
     * Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
    * @param cantidad_goles_local parametro para la saber cantidad de goles locales
    * @param cantidad_goles_visit parametro para saber la cantidad de goles visitantes
    * @throws Exception 
    */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}