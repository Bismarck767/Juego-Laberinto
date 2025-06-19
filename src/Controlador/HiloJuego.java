/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Vista.FRM_Laberinto;

/**
 *
 * @author Estudiante
 */
public class HiloJuego extends Thread {
    private FRM_Laberinto frmLaberinto;
    public boolean gameOver = false;
    public boolean gameWin = false;
  
    public HiloJuego(FRM_Laberinto frmAreaJuego) {
        this.frmLaberinto = frmAreaJuego;
    }
    
    public void run() {
    try {
        while (!gameOver) {
            if (!frmLaberinto.isPausa()) {
                frmLaberinto.moverPersonaje();
                frmLaberinto.moverDisparo();
                frmLaberinto.detectarDisparo();
                frmLaberinto.detectarHinata();
            }

            sleep(120);
        }

        frmLaberinto.mensaje("Has perdido, Inténtalo de nuevo");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

    
    public void detenerJuego() {
        gameOver = true;
    }
}
