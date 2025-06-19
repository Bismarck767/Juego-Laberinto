/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Usuario
 */
  public class LectorGanador
{
    public String nombreArchivo;
    ArrayList<Ganadores> arregloGanadores;

    public LectorGanador(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        
    }
    //--------Para imprimir hacer tabla ------------------------------------------
    public ArrayList<Ganadores> leer() 
    {
        try
        {
            CSVReader csvReader= null;
            java.util.List<String[]> arregloVectores=null;
           arregloGanadores=new ArrayList<>();
            
            csvReader= new CSVReader(new FileReader(nombreArchivo));
            arregloVectores =csvReader.readAll();// lee todo lo del arreglo 
            for (String []linea :arregloVectores)
            {
                    Ganadores ganador=new Ganadores(linea[0],(Integer.parseInt(linea[1])));
                    arregloGanadores.add(ganador);
            }
        }catch(FileNotFoundException e)
        {
       //no va a imprimir porque esta excepcion sucede minimo la primera vez
        }catch(IOException io)
        {
            io.printStackTrace();//archivo no encontrado, acceso no autorizado, disco lleno, entre otros.
        }catch(CsvException cs)
        {
            cs.printStackTrace();//una cantidad incorrecta de campos en una línea o caracteres de escape incorrectos.
        }
        return arregloGanadores;
    }
    
}// fin clase 