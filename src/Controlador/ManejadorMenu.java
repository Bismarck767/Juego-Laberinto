/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Ganadores;
import Modelo.RegistroGanadores;
import Vista.FRM_Historia;
import Vista.FRM_Instrucciones;
import Vista.FRM_Laberinto;
import Vista.FRM_Menu;
import Vista.FRM_TablaGanadores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */

 
public class ManejadorMenu implements ActionListener{
    FRM_Menu frmenu;
    RegistroGanadores registro;
    FRM_TablaGanadores frmTabla;

    public ManejadorMenu(FRM_Menu frmenu) {
        this.frmenu = frmenu;
        registro=new RegistroGanadores();
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Iniciar Juego")){
       new FRM_Laberinto().setVisible(true);//llama el FRM_Laberinto para que sea visible
        frmenu.detenerMusica();//ocupo detener la musica para que se reproduzca la nueva
    }
     if(e.getActionCommand().equals("Instrucciones")){
        new  FRM_Instrucciones().setVisible(true);
    }
     
     if(e.getActionCommand().equals("Historia")){
        new   FRM_Historia().setVisible(true);
    }
     if(e.getActionCommand().equals("Puntuaciones")){
         
       
        frmTabla=new FRM_TablaGanadores();
            frmTabla.setVisible(true);
            frmTabla.setDatosTabla(registro.getDatosMatriz(), Ganadores.TB_Etiqueta);
    }
    }
    
}
