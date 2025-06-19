/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class RegistroGanadores {
    private ArrayList<Ganadores> arregloGanadores; // Lista de ganadores
    
    private String mensaje; // Mensaje de resultado de operaciones
    
    private String nombreArchivo; // Nombre del archivo de ganadores
    
    EscritorGanador escritorGanador; // Instancia de la clase EscritorGanador para escribir en el archivo
    
    LectorGanador lectorGanador; // Instancia de la clase LectorGanador para leer el archivo
    
    Ganadores ganador; // Objeto Ganadores utilizado en diferentes partes del código

    public RegistroGanadores() {
        this.arregloGanadores = new ArrayList<>(); // Inicialización de la lista de ganadores
        
        this.mensaje = ""; // Inicialización del mensaje
        
        this.nombreArchivo = "ArchivoGanadores.csv"; // Nombre del archivo de ganadores
        
        this.escritorGanador = new EscritorGanador(nombreArchivo); // Instancia de EscritorGanador
        
        this.lectorGanador = new LectorGanador(nombreArchivo); // Instancia de LectorGanador
    }

    // Método para agregar un ganador a la lista
    public String agregarGanador(Ganadores ganador) {
        if (ganador != null) {
            if (buscarIndice(ganador.getNombre()) == -1) { // Verificar si el ganador no existe en la lista
                arregloGanadores.add(ganador); // Agregar el ganador a la lista
                escritorGanador.escribir(arregloGanadores); // Escribir la lista en el archivo

                if (arregloGanadores.size() > 10) { // Si la lista supera los 10 ganadores
                    Collections.sort(arregloGanadores, new Comparator<Ganadores>() {
                        @Override
                        public int compare(Ganadores ganador1, Ganadores ganador2) {
                            int puntaje1 = ganador1.getPuntaje();
                            int puntaje2 = ganador2.getPuntaje();
                            return Integer.compare(puntaje1, puntaje2);
                        }
                    });
                    arregloGanadores.remove(arregloGanadores.size() - 1); // Remover el último ganador de la lista
                }

                mensaje = "El contacto se agregó correctamente";
            } else {
                mensaje = "Gracias por su registro revisa la tabla tal vez estes en ella, suerte!!";
            }
        }

        return mensaje;
    }

    // Método para buscar el índice de un ganador por nombre
    public int buscarIndice(String nombre) {
        arregloGanadores = new ArrayList<>(); // Limpiar el arreglo haciendo una instancia
        arregloGanadores.addAll(lectorGanador.leer()); // Llenar el arreglo con la información del archivo

        for (int indice = 0; indice < arregloGanadores.size(); indice++) {
            if (arregloGanadores.get(indice) != null) {
                if (arregloGanadores.get(indice).getNombre().equals(nombre)) {
                    return indice; // Retorna el índice del ganador si se encuentra en la lista
                }
            }
        }
        return -1; // Retorna -1 si el ganador no se encuentra en la lista
    }

    // Método para obtener los datos de los ganadores en una matriz
    public String[][] getDatosMatriz() {
        arregloGanadores = lectorGanador.leer(); // Leer los ganadores desde el archivo
        String[][] datosMatriz = new String[Math.min(arregloGanadores.size(), 10)][ganador.TB_Etiqueta.length];

        Collections.sort(arregloGanadores, new Comparator<Ganadores>() {
            @Override
            public int compare(Ganadores ganador1, Ganadores ganador2) {
                int puntaje1 = ganador1.getPuntaje();
                int puntaje2 = ganador2.getPuntaje();
                return Integer.compare(puntaje2, puntaje1); // Ordenar los ganadores de forma descendente por puntaje
            }
        });

        for (int i = 0; i < Math.min(arregloGanadores.size(), 10); i++) {
            Ganadores ganador = arregloGanadores.get(i);
            datosMatriz[i][0] = ganador.getNombre();
            datosMatriz[i][1] = "" + ganador.getPuntaje();
        }

        return datosMatriz; // Retorna la matriz con los datos de los ganadores
    }
}
