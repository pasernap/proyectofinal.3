/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Usuario9
 */
public class TableroI extends JPanel implements ActionListener, KeyListener{
    private Timer timer; 
    private ArrayList<Circulo> circulo;
    private ArrayList<Dulce> dulce;
    private Carro personajePrincipal;
    private Sound sonido;
    private int puntaje = 0;
    private int colisiones = 0;
    int cuadro=136;
    int c=68;
    protected boolean colision=false;
    
    public boolean getColision() {
        return colision;
    }
    public void setColision(boolean colision) {
        this.colision = colision;
    }
    
    public TableroI(){
      this.sonido = new Sound("ball.wav");
      this.setFocusable(true);
      this.addKeyListener(this);
      this.personajePrincipal = new Carro(100,200);
      
      this.circulo = new ArrayList<Circulo>();
      this.dulce = new ArrayList<Dulce>();
      ///-------------------------------------linea3----------------
      this.circulo.add(new Circulo(216,66));
      this.circulo.add(new Circulo(284,66));
      this.circulo.add(new Circulo(352,66));
      this.circulo.add(new Circulo(420,66));

      this.circulo.add(new Circulo(556,66));
      this.circulo.add(new Circulo(624,66));
      this.circulo.add(new Circulo(692,66));
      this.circulo.add(new Circulo(760,66));
      //---------------------------------------linea-------------
      this.circulo.add(new Circulo(218,678));
      this.circulo.add(new Circulo(284,678));
      this.circulo.add(new Circulo(352,678));
      this.circulo.add(new Circulo(420,678));
      this.circulo.add(new Circulo(488,678));
      this.circulo.add(new Circulo(556,678));
      this.circulo.add(new Circulo(624,678));
      this.circulo.add(new Circulo(692,678));
      this.circulo.add(new Circulo(760,678));
      //---------------------------------------lineabajo-------------
      this.circulo.add(new Circulo(420,66));
      this.circulo.add(new Circulo(420,134));
      this.circulo.add(new Circulo(420,202));
      this.circulo.add(new Circulo(420,270));
      this.circulo.add(new Circulo(420,338));
      this.circulo.add(new Circulo(420,406));
      this.circulo.add(new Circulo(420,474));
      this.circulo.add(new Circulo(420,542));
      //---------------------------------------lineabajo2-------------
      this.circulo.add(new Circulo(556,66));
      this.circulo.add(new Circulo(556,134));
      this.circulo.add(new Circulo(556,202));
      this.circulo.add(new Circulo(556,270));
      this.circulo.add(new Circulo(556,338));
      this.circulo.add(new Circulo(556,406));
      this.circulo.add(new Circulo(556,474));
      this.circulo.add(new Circulo(556,542));
      //-----------------------------------------dulces----------
      this.dulce.add(new Dulce(216,-2));
      this.dulce.add(new Dulce(216,604));
      this.dulce.add(new Dulce(760,604));
      
      this.timer = new Timer(50, this);
      //this.sonido.loop();
      this.timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         //omagen---------
         
       
         
         Image fondo = loadImage("prueba2.jpg");//omagen---------
        g.drawImage(fondo, 0, 0, null);
         for(Circulo c: this.circulo)
            c.dibujar(g,this);
         
         for(Dulce d: this.dulce)
            d.dibujar(g,this);
         
         this.personajePrincipal.dibujar(g,this);
         g.drawString("Puntaje " + puntaje, 40, 40);
         
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validarColisiones();
        validarColisionesY();
        validarDulces();
         for(Circulo c: this.circulo)
         //   c.mover();
            repaint();
        
    }
     
    
    public void validarColisiones(){
        
        Rectangle recPersonaje= this.personajePrincipal.obtenerRectangulo();
        ArrayList<Circulo> copia = (ArrayList<Circulo>) this.circulo.clone();
        for(Circulo c : circulo){
           Rectangle Rec = c.obtenerRectangulo();
           
           if(recPersonaje.intersects(Rec)){
               if(recPersonaje.getX()<=Rec.getX()){
           this.personajePrincipal.setX(this.personajePrincipal.getX()-10);
           } else if(Rec.getX()<recPersonaje.getX()){
               this.personajePrincipal.setX(this.personajePrincipal.getX()+10);
           }/* else if(recPersonaje.getY()<=Rec.getY()){
           this.personajePrincipal.setY(this.personajePrincipal.getY()-34);
           }else if(Rec.getY()<recPersonaje.getY()){
               this.personajePrincipal.setY(this.personajePrincipal.getY()+34);
           }*/  
              this.colisiones++;
           }
           this.circulo=copia;
       
        }

    }
    
    public void validarColisionesY(){
        
        Rectangle recPersonaje= this.personajePrincipal.obtenerRectangulo();
        ArrayList<Circulo> copia = (ArrayList<Circulo>) this.circulo.clone();
        for(Circulo c : circulo){
           Rectangle Rec = c.obtenerRectangulo();
           
           if(recPersonaje.intersects(Rec)){
               if(recPersonaje.getY()<=Rec.getY()){
           this.personajePrincipal.setY(this.personajePrincipal.getY()-10);
           }else if(Rec.getY()<recPersonaje.getY()){
               this.personajePrincipal.setY(this.personajePrincipal.getY()+10);
           } 
              this.colisiones++;
           }
           this.circulo=copia;
       
        }

    }
    public void validarDulces(){
        Rectangle recPersonaje= this.personajePrincipal.obtenerRectangulo();
        ArrayList<Dulce> copiad = (ArrayList<Dulce>) this.dulce.clone();
        for(Dulce d : dulce){
           Rectangle RecDul = d.obtenerRectangulo();
           if(recPersonaje.intersects(RecDul)){
               copiad.remove(d);
               this.puntaje++;
           }
           this.dulce=copiad;   
           
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
       this.personajePrincipal.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
