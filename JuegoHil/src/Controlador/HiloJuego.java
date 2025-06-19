/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FRM_AreaJuego;

/**
 *
 * @author Estudiante
 */
public class HiloJuego extends Thread {
    FRM_AreaJuego frmAreaJuego;
    public boolean gameOver= false;

    public HiloJuego(FRM_AreaJuego frmAreaJuego) {
        this.frmAreaJuego = frmAreaJuego;
    }
    
    public void run()
    {
        try
        {
            while(!gameOver)
            {
                frmAreaJuego.moverFondo();
                frmAreaJuego.moverPersonaje();
                frmAreaJuego.moverMalo();
                frmAreaJuego.detectarColision();
                frmAreaJuego.detectarDisparo();
                frmAreaJuego.moverDisparo();
                sleep(30);
                
                
            }
            frmAreaJuego.mensaje("Juego terminado");
            frmAreaJuego.dispose();
        }catch(Exception e)
        {
            e.getMessage();
        }
    }
    
}//Fin de class
