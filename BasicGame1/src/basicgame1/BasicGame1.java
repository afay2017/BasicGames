
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author WARLords
 */
public class BasicGame1 extends JFrame {


    BasicGameJPanel jPanel;
    Listener keyl;
    public BasicGame1() {
        
        setTitle("Tank");
        setSize(new Dimension(700, 500));
        keyl = new Listener();
        addKeyListener(keyl);
        addMouseListener(keyl);
        addMouseMotionListener(keyl);
        
        jPanel = new BasicGameJPanel();
        getContentPane().add(jPanel);
        
        
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        jPanel.Init();
  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BasicGame1 Win = new BasicGame1();

        Win.Loop();

    }

    public void Loop() {

//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(600);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(BasicGame1.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                while (true) {
//                    repaint();
//
//                    NWidth = getWidth();
//                    //System.out.println(NWidth);
//                }
//
//            }
//
//        }).start();
    }

    @Override
    public void paint(Graphics g) {
        jPanel.Refresh(keyl);
        jPanel.paintComponent(g);
    }
        

}
