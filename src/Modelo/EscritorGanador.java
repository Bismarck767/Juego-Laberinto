/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.opencsv.CSVWriter;
import java.awt.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class EscritorGanador{
    private String nombreArchivo;

    public EscritorGanador(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }


     //un atributo del vector 
    public java.util.List procesarClientes(ArrayList<Ganadores> arregloGanadores)
    {
        java.util.List<String[]> arregloVectores=new ArrayList<>();
        for (Ganadores ganador: arregloGanadores)
        {
         arregloVectores.add(new String []{
             ganador.getNombre(),
            ""+ganador.getPuntaje()
             });
        }
        return arregloVectores;
    }
    // este metodo recibe el arreglo de clientes se crea el canal o fluko para escribir en 
    //el archivo (CSWriter), se escribe en el archivo todo mediante el writteAll
    //llamando al metodo procesar que devuelve el arreglo de vectores 
    public void escribir (ArrayList<Ganadores> arregloGanadores)
    {
        try
        {
            CSVWriter csvOutput= new CSVWriter(new FileWriter(nombreArchivo,false));
            csvOutput.writeAll(procesarClientes(arregloGanadores));
            csvOutput.close();
        }catch(IOException io)
        {
            io.printStackTrace();
        }
    }
}// fin de la clase 


