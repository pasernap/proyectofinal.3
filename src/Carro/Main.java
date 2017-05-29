/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Usuario9
 */
public class Main {
  
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(1200,800));
        //frame.add(new TableroA());//adicionando el panel
        //frame.add(new TableroE());//adicionando el panel
        //frame.add(new TableroI());//adicionando el panel
        //frame.add(new TableroO());//adicionando el panel
        frame.add(new TableroU());//adicionando el panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
