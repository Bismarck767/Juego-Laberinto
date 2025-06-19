/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.HiloJuego;
import Controlador.ManejadorLaberinto;
import Modelo.Ganadores;
import Modelo.RegistroGanadores;
import java.awt.Color;
import Vista.Panel_Laberinto;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.event.KeyListener;



/**
 *
 * @author Usuario
 */
public class FRM_Laberinto extends javax.swing.JFrame implements KeyListener {

    String estadoPersonaje = "suelo";// esta variable me ayudara despues para poder saber la posicion del personaje
    
    HiloJuego hilo;// llamamos el hilo de juego
    
    FRM_Menu menu;// ocupo llamar esta clase para poder reproducir la musica
    
  
   
   
    
    Panel_Laberinto panelD;//Este panelDatos es el que tiene implementado el laberinto
    
    private Clip sonidoFondo;// esta es la biblioteca que me permite tener sonido
    
    private final int posicionInicialX = 80;// ocupo esta variable para cada vez que reinicio el juego para poder mandarlo a esa posicion
    
    private final int posicionInicialY = 120;// esta igual es la y de este metodo
    
    private boolean pausa = false;// este es el metodo booleano que me ayuda para el proceso
    
    private int posicionActualX;//verificar la posicion actual para poder reiniciar y igualarlo a la posicion inicial
    
    private int posicionActualY;//verificar la posicion actual de y para poder igualarla
    
    ManejadorLaberinto manejador;// esta parte la ocupo para llamar al manejador que contro pausa y salir
    
    FRM_RegistroGanador frmGanador; //este es para llamar los que estan registrados 
    
    public final int altoBloque = 60;// el alto del bloque que cuesta el altoBloque

    /**
     * Creates new form FRM_Laberinto
     */
    public FRM_Laberinto() {
        initComponents();
        // Inicialización de variables y objetos
         
        manejador=new ManejadorLaberinto(this);//el manejado que instancia el ManejadorLaberinto 
        EcuchaElemento(manejador);
        hilo = new HiloJuego(this);
        
        hilo.start();
        
        posicionActualX = posicionInicialX;
        
        this.frmGanador=frmGanador;
        
        
        
        posicionActualY = posicionInicialY;
        
        panelD = new Panel_Laberinto();
        // este estoda las clases instanciadas
        
        addKeyListener(this);
        
        
        try {
            sonidoFondo = AudioSystem.getClip();
            sonidoFondo.open(AudioSystem.getAudioInputStream(getClass().getResource("/musica/Cancion.wav")));//dar la direccion de musica que ocupo al sistema
            sonidoFondo.loop(1);
        } catch (Exception e) {
            e.getMessage();
        }

    }
     public boolean isPausa() {
        return pausa;
    }
     
  //estos dos metodos de ispausa y setPausa son los que ayudan a dicen al frmLaberinto que se detenga
    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    
    

    public void detenerMusica() {
        sonidoFondo.stop();// le dice al sonidoFondo que se detenga
    }//que sea detener la musicaMusica
    

    public void EcuchaElemento(ActionListener manejador){
        Pausa.addActionListener(manejador);//este menu item es el que pausa el juego esta conectado con un boolean de pausa que mas abajo se puede ver
        Salir.addActionListener(manejador);//esete me cierra el programa.
      
    }//escucha los elemenmto Menu Bar
            

    public void moverPersonaje() {
        if (panelD != null) {
           
            int[][] laberinto = panelD.obtnerlaberinto();
            int bloqueX = jlPersonaje.getX() / 60;  // Usar 60 como ancho del bloque
            int bloqueY = jlPersonaje.getY() / 60;  // Usar 60 como alto del bloque

            if (estadoPersonaje.equals("subiendo")) {
                if (bloqueY > 0 && laberinto[bloqueY - 1][bloqueX] != 1) {//esta linea de codigo le indica al sistema que solo se puede caminar por los numeros 0
                    jlPersonaje.setLocation(jlPersonaje.getX(), jlPersonaje.getY() - 60);// el personaje podra andar de 60 en 60  por que es la medidad del lab
                   
                }
            }

            if (estadoPersonaje.equals("bajando")) {
                if (bloqueY < laberinto.length - 1 && laberinto[bloqueY + 1][bloqueX] != 1) {//esta linea de codigo le indica al sistema que solo se puede caminar por los numeros 0
                    jlPersonaje.setLocation(jlPersonaje.getX(), jlPersonaje.getY() + 60);// el personaje podra andar de 60 en 60  por que es la medidad del lab
                    
                }
            }

            if (estadoPersonaje.equals("izquierda")) {
                if (bloqueX > 0 && laberinto[bloqueY][bloqueX - 1] != 1) {//esta linea de codigo le indica al sistema que solo se puede caminar por los numeros 0
                    jlPersonaje.setLocation(jlPersonaje.getX() - 60, jlPersonaje.getY());// el personaje podra andar de 60 en 60  por que es la medidad del lab
                   
                }
            }

            if (estadoPersonaje.equals("derecha")) {
                if (bloqueX < laberinto[0].length - 1 && laberinto[bloqueY][bloqueX + 1] != 1) {//esta linea de codigo le indica al sistema que solo se puede caminar por los numeros 0
                    jlPersonaje.setLocation(jlPersonaje.getX() + 60, jlPersonaje.getY());// el personaje podra andar de 60 en 60  por que es la medidad del lab
                    
                }
            }
        };

    }

    public void moverDisparo() {
        ball.setLocation(ball.getX() + 30, ball.getY() - 30);//todo estos codigos controlan el disparo y la velocidad
        
        ball2.setLocation(ball2.getX() - 30, ball2.getY());
        
        ball3.setLocation(ball3.getX() + 30, ball3.getY());
        
        ball4.setLocation(ball4.getX() - 30, ball4.getY());
        
        ball5.setLocation(ball5.getX() - 30, ball5.getY());
        
        ball6.setLocation(ball6.getX() - 30, ball6.getY());
        
        ball9.setLocation(ball9.getX() + 30, ball9.getY() + 30);
        
        ball7.setLocation(ball7.getX(), ball7.getY() + 30);
        
        hinata.setLocation(hinata.getX(), hinata.getY());

        if (ball.getY() < -50) {//esta parte le dice al ataque en que parte tenen que retornar
            ball.setLocation(itachi.getX(), itachi.getY());
        }

        if (ball2.getX() < -50) {
            ball2.setLocation(itachi.getX() - 5, ball2.getY());//estas partes es para que retorne en las posiciones del personaje
        }

        if (ball3.getX() > 1250) {//por lo menos en este caso se le dkice que ball es mayor de 1250 entonces en pantalla se refleja la indicacion
            ball3.setLocation(gaara3.getX(), gaara3.getY());
        }

        if (ball4.getX() < -50) {
            ball4.setLocation(gaara.getX() - 20, ball4.getY());
        }

        if (ball5.getX() < -50) {
            ball5.setLocation(itachi2.getX() - 20, ball5.getY());
        }

        if (ball6.getX() < -50) {
            ball6.setLocation(gaara2.getX() - 20, ball6.getY());
        }

        if (ball7.getY() > 1000) {// en este especifico en y entonces la ball7 avanzara hasta que se cumpla la condicion
            ball7.setLocation(itachi3.getX(), itachi3.getY());
        }

        if (ball9.getY() > 1250) {
            ball9.setLocation(gaara1.getX(), gaara1.getY());
        }

    }

    public void detectarHinata() {
        int personajeX = jlPersonaje.getX();
        int personajeY = jlPersonaje.getY();
        int personaje2x = hinata.getX();
        int personaje2y = hinata.getY();

        if (personaje2x < (personajeX + jlPersonaje.getWidth()) && (personaje2x + hinata.getWidth()) > personajeX
                && (personaje2y + hinata.getHeight()) > personajeY && personaje2y < (personajeY + jlPersonaje.getHeight())) {

            hilo.gameOver = false;
            mensajeG("Has ganado");

        }
    }

    public void detectarDisparo() {
        //Variables de direccion
        int personajeX = jlPersonaje.getX();
        
        int personajeY = jlPersonaje.getY();
        
        int disparo4x = ball4.getX();
        
        int disparo4y = ball4.getY();
        
        int disparoX = ball.getX();
        
        int disparoY = ball.getY();
        
        int disparo2X = ball2.getX();
        
        int disparo2Y = ball2.getY();
        
        int disparo3x = ball3.getX();
        
        int disparo3y = ball3.getY();
        
        int disparo5x = ball5.getX();
        
        int disparo5y = ball5.getY();
        
        int disparo6x = ball6.getX();
        
        int disparo6y = ball6.getY();
        
        int disparo7x = ball7.getX();
        
        int disparo7y = ball7.getY();
        
        int disparo8x = ball9.getX();
        
        int disparo8y = ball9.getY();
        //Todos estos metodos se les da las equivalencias a todas estas variables para que puedan saber en cual punto puede chocar
           
        
        //cada uno de este busca la posicion especifica con Width y con Height eso hace que sea exacto la colision donde la posicion de disparo es menor que la de personaje y asi viceversa
        
        if ((disparoX < (personajeX + jlPersonaje.getWidth()) && (disparoX + ball.getWidth()) > personajeX
                && (disparoY + ball.getHeight()) > personajeY && disparoY < (personajeY + jlPersonaje.getHeight()))
                || (disparo2X < (personajeX + jlPersonaje.getWidth()) && (disparo2X + ball2.getWidth()) > personajeX
                && (disparo2Y + ball2.getHeight()) > personajeY && disparo2Y < (personajeY + jlPersonaje.getHeight()))) {
            System.out.print("Yogurt");
  
            hilo.gameOver = true;//este le manda un mensaje al hilo diciendo se detecto colision el usuario ha perdido

        }
        

        if (disparo3x < (personajeX + jlPersonaje.getWidth()) && (disparo3x + ball3.getWidth()) > personajeX
                && (disparo3y + ball3.getHeight()) > personajeY && disparo3y < (personajeY + jlPersonaje.getHeight())) {

            hilo.gameOver = true;//este le manda un mensaje al hilo diciendo se detecto colision el usuario ha perdido
        }
        

        if (disparo4x < (personajeX + jlPersonaje.getWidth()) && (disparo4x + ball4.getWidth()) > personajeX
                && (disparo4y + ball4.getHeight()) > personajeY && disparo4y < (personajeY + jlPersonaje.getHeight())) {

            hilo.gameOver = true;//este le manda un mensaje al hilo diciendo se detecto colision el usuario ha perdido
        }
        

        if (disparo5x < (personajeX + jlPersonaje.getWidth()) && (disparo5x + ball5.getWidth()) > personajeX
                && (disparo5y + ball5.getHeight()) > personajeY && disparo5y < (personajeY + jlPersonaje.getHeight())) {

            hilo.gameOver = true;//este le manda un mensaje al hilo diciendo se detecto colision el usuario ha perdido
        }

        
        if (disparo6x < (personajeX + jlPersonaje.getWidth()) && (disparo6x + ball6.getWidth()) > personajeX
                && (disparo6y + ball6.getHeight()) > personajeY && disparo6y < (personajeY + jlPersonaje.getHeight())) {

            hilo.gameOver = true;//este le manda un mensaje al hilo diciendo se detecto colision el usuario ha perdido
        }

        
        if (disparo7x < (personajeX + jlPersonaje.getWidth()) && (disparo7x + ball7.getWidth()) > personajeX
                && (disparo7y + ball7.getHeight()) > personajeY && disparo7y < (personajeY + jlPersonaje.getHeight())) {

            hilo.gameOver = true;//este le manda un mensaje al hilo diciendo se detecto colision el usuario ha perdido
        }

        if (disparo8x < (personajeX + jlPersonaje.getWidth()) && (disparo8x + ball9.getWidth()) > personajeX
                && (disparo8y + ball9.getHeight()) > personajeY && disparo8y < (personajeY + jlPersonaje.getHeight())) {

            hilo.gameOver = true;//este le manda un mensaje al hilo diciendo se detecto colision el usuario ha perdido
        }

    }
    
    public void mensaje3(String mensaje) {
    Icon icono = new ImageIcon(getClass().getResource("/img/Ganadorr.gif"));
    Object[] opciones = {"Renudar", "Salir"};//usa el la biblioteca Obeject para poder hacer mas de una opcion en un JOptionPane

    int seleccion = JOptionPane.showOptionDialog(
            null,
            mensaje,
            "Perdiste!!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE,
            icono,
            opciones,
            opciones[0]// estas es la posicion cero para poder renudar el codigo
    );
    
    if (seleccion == JOptionPane.YES_OPTION) {
        // Aquí puedes agregar el código para renudar el juego
        setPausa(false); // Establece la pausa como false para renudar el juego
    } else {
        dispose();
        detenerMusica();
        menu=new FRM_Menu();
        
    }
}


    public void mensaje(String mensaje) {
        Icon icono = new ImageIcon(getClass().getResource("/img/Perdistes.gif"));
        Object[] opciones = {"Reiniciar", "Salir"};

        int seleccion = JOptionPane.showOptionDialog(
                null,
                mensaje,
                "Perdiste!!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE,
                icono,
                opciones,
                opciones[0]
        );
        if (seleccion == JOptionPane.YES_OPTION) {
            
            reiniciarJuego();
        } else {
            System.exit(0);

        }
    }// este mensaje reinicia el sistema 
    
    

    public void mensajeG(String mensaje) {
        Icon icono = new ImageIcon(getClass().getResource("/img/ganador.gif"));
        Object[] opciones = {"Registrar Partida", "Salir"};

        int seleccion = JOptionPane.showOptionDialog(
                null,
                mensaje,
                "Ganastes!!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE,
                icono,
                opciones,
                opciones[0]
        );
        if (seleccion == JOptionPane.YES_OPTION) {
                new FRM_RegistroGanador().setVisible(true);//la ventana que nos ayuda a registra la excelente partida que uno hace
                dispose();
                detenerMusica();
                menu=new FRM_Menu();
                //llamamos y detenemos la musica
            
                
                
        } else {
            System.exit(0);

        }
    }

    public void reiniciarJuego() {
        if (hilo == null && hilo.isAlive()) {//mientras hilo==null se cumple la condicion para de tener elo juego y volverlo a ejecutar
            hilo.detenerJuego();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Resto del código para reiniciar el juego
        estadoPersonaje = "suelo";
        posicionActualX = posicionInicialX;//para poder mandar al personaje a la posicion original
        posicionActualY = posicionInicialY;
        jlPersonaje.setLocation(posicionActualX, posicionActualY);

        // Eliminar las posiciones antiguas de los disparos
        // Crear un nuevo hilo y reiniciar el juego
        hilo = new HiloJuego(this);
        hilo.start();

        sonidoFondo.loop(Clip.LOOP_CONTINUOUSLY);
    }//en si el metodo de reiniciar juego ayuda a volver a naruto a la posicion original
    

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            estadoPersonaje = "subiendo";
        } else if (keyCode == KeyEvent.VK_S) {
            estadoPersonaje = "bajando";
        } else if (keyCode == KeyEvent.VK_A) {
            estadoPersonaje = "izquierda";
        } else if (keyCode == KeyEvent.VK_D) {
            estadoPersonaje = "derecha";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        estadoPersonaje = "suelo";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Laberinto2 = new Vista.Panel_Laberinto();
        jLabel1 = new javax.swing.JLabel();
        jlPersonaje = new javax.swing.JLabel();
        itachi = new javax.swing.JLabel();
        ball = new javax.swing.JLabel();
        ball2 = new javax.swing.JLabel();
        morado = new javax.swing.JLabel();
        ball3 = new javax.swing.JLabel();
        gaara2 = new javax.swing.JLabel();
        gaara3 = new javax.swing.JLabel();
        gaara1 = new javax.swing.JLabel();
        itachi2 = new javax.swing.JLabel();
        itachi3 = new javax.swing.JLabel();
        gaara = new javax.swing.JLabel();
        ball4 = new javax.swing.JLabel();
        ball5 = new javax.swing.JLabel();
        ball6 = new javax.swing.JLabel();
        ball7 = new javax.swing.JLabel();
        ball9 = new javax.swing.JLabel();
        hinata = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Pausa = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enemigo3.gif"))); // NOI18N
        jLabel1.setText("jLabel1");

        jlPersonaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usare esta88.png"))); // NOI18N

        itachi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enemigo3.gif"))); // NOI18N

        ball.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ataque4.png"))); // NOI18N

        ball2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ataque4.png"))); // NOI18N

        morado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/villano.gif"))); // NOI18N
        morado.setText("jLabel2");

        ball3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ataque7.png"))); // NOI18N
        ball3.setText("jLabel3");

        gaara2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/villano.gif"))); // NOI18N
        gaara2.setText("jLabel2");

        gaara3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/villano.gif"))); // NOI18N
        gaara3.setText("jLabel4");

        gaara1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/villano.gif"))); // NOI18N
        gaara1.setText("jLabel3");

        itachi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enemigo3.gif"))); // NOI18N
        itachi2.setText("jLabel5");

        itachi3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enemigo3.gif"))); // NOI18N
        itachi3.setText("jLabel6");

        gaara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/villano.gif"))); // NOI18N

        ball4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ataque 1.jpg"))); // NOI18N
        ball4.setText("jLabel2");

        ball5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ataque7.png"))); // NOI18N
        ball5.setText("jLabel2");

        ball6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ataque4.png"))); // NOI18N
        ball6.setText("jLabel3");

        ball7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ataque 1.5.5.jpg"))); // NOI18N
        ball7.setText("jLabel4");

        ball9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ataque7.png"))); // NOI18N
        ball9.setText("jLabel9");

        hinata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hinata1.png"))); // NOI18N
        hinata.setText("jLabel2");

        javax.swing.GroupLayout panel_Laberinto2Layout = new javax.swing.GroupLayout(panel_Laberinto2);
        panel_Laberinto2.setLayout(panel_Laberinto2Layout);
        panel_Laberinto2Layout.setHorizontalGroup(
            panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gaara1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gaara3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(morado, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(700, 700, 700))
                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                        .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gaara, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                        .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ball2)
                                            .addComponent(ball))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(itachi, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(128, 128, 128)
                                        .addComponent(hinata, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(600, 600, 600))
                                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                        .addComponent(ball9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 544, Short.MAX_VALUE)
                                        .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ball7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(itachi3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(378, 378, 378)
                                        .addComponent(ball6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_Laberinto2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(ball3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                                .addGap(383, 383, 383)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                                .addGap(992, 992, 992)
                                                .addComponent(ball4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(gaara2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                        .addComponent(ball5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(itachi2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(728, 728, 728))))
            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jlPersonaje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_Laberinto2Layout.setVerticalGroup(
            panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                        .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(gaara2)
                                .addComponent(ball7, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ball9)
                                    .addComponent(ball6))
                                .addComponent(gaara1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addComponent(jlPersonaje)
                        .addGap(23, 23, 23)
                        .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                        .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(itachi2)
                                            .addComponent(ball5))
                                        .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                                .addGap(311, 311, 311)
                                                .addComponent(gaara))
                                            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                                .addGap(332, 332, 332)
                                                .addComponent(ball4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(177, 177, 177)
                                        .addComponent(morado))
                                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ball)
                                            .addComponent(ball2)))
                                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(itachi)))
                                .addGap(1966, 1966, 1966)
                                .addComponent(jLabel1))
                            .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                                .addGap(446, 446, 446)
                                .addGroup(panel_Laberinto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ball3)
                                    .addComponent(gaara3)))))
                    .addGroup(panel_Laberinto2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(itachi3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(278, 278, 278)
                        .addComponent(hinata)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panel_Laberinto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2130, 3170));

        jMenu1.setText("File");

        Pausa.setText("Pausa");
        Pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PausaActionPerformed(evt);
            }
        });
        jMenu1.add(Pausa);

        Salir.setText("Salir");
        jMenu1.add(Salir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PausaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PausaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_Laberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_Laberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_Laberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_Laberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_Laberinto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Pausa;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JLabel ball;
    private javax.swing.JLabel ball2;
    private javax.swing.JLabel ball3;
    private javax.swing.JLabel ball4;
    private javax.swing.JLabel ball5;
    private javax.swing.JLabel ball6;
    private javax.swing.JLabel ball7;
    private javax.swing.JLabel ball9;
    private javax.swing.JLabel gaara;
    private javax.swing.JLabel gaara1;
    private javax.swing.JLabel gaara2;
    private javax.swing.JLabel gaara3;
    private javax.swing.JLabel hinata;
    private javax.swing.JLabel itachi;
    private javax.swing.JLabel itachi2;
    private javax.swing.JLabel itachi3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jlPersonaje;
    private javax.swing.JLabel morado;
    private Vista.Panel_Laberinto panel_Laberinto2;
    // End of variables declaration//GEN-END:variables

