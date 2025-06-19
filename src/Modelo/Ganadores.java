/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Ganadores {

    private String nombre;
    private int puntaje;
    public static final String[]TB_Etiqueta={"Nombre","posicion"};
    public Ganadores(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
   public Ganadores() {
        this.nombre = "";
        this.puntaje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + ", puntaje=" + puntaje ;
    }
   
   
    
}
