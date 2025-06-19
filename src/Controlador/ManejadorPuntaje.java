/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Ganadores;
import Modelo.RegistroGanadores;
import Vista.FRM_RegistroGanador;
import Vista.FRM_TablaGanadores;
import Vista.Panel_BotonG;
import Vista.Panel_DatosG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ManejadorPuntaje implements ActionListener{
   Panel_DatosG  panelD;
   Panel_BotonG panelB;
   RegistroGanadores registro;
   FRM_RegistroGanador frmRegistro;
   FRM_TablaGanadores frmTabla;
   Ganadores ganador;

    public ManejadorPuntaje(Panel_DatosG panelD, Panel_BotonG panelB, FRM_RegistroGanador frmRegistro) {
        this.panelD = panelD;
        this.panelB = panelB;
        registro=new RegistroGanadores();
        this.frmRegistro = frmRegistro;
    }
   
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agregar")) {
            if(panelD.getTxtNombre().isEmpty()){
                    
                
                    JOptionPane.showMessageDialog(null,"Por favor ingrese todos los datos");
            }else{
              
                Ganadores ganador=new Ganadores(panelD.getTxtNombre(),Integer.parseInt(panelD.getTxtPuntaje()));
                JOptionPane.showMessageDialog(null, registro.agregarGanador(ganador));
            }
                
        }
        if (e.getActionCommand().equals("Salir")) {
            frmRegistro.dispose();   
        }
        
         if (e.getActionCommand().equals("Lista")) {
            frmTabla=new FRM_TablaGanadores();
            frmTabla.setVisible(true);
            frmTabla.setDatosTabla(registro.getDatosMatriz(), Ganadores.TB_Etiqueta);
        }
    }
    
    
}
