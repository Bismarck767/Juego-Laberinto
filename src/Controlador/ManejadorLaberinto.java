/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FRM_Laberinto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */
public class ManejadorLaberinto implements ActionListener{
    FRM_Laberinto frmLaberinto;

    public ManejadorLaberinto(FRM_Laberinto frmLaberinto) {
        this.frmLaberinto = frmLaberinto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Pausa")) {
        frmLaberinto.setPausa(!frmLaberinto.isPausa());
        frmLaberinto.mensaje3("Juego Pausado");
      }
        
      if (e.getActionCommand().equals("Salir")) {
        frmLaberinto.dispose();
      }
    }    
            
}
