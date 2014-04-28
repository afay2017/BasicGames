/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author Todor
 */
public class BasicGameJPanel extends JPanel{

    Tank tank;
    Tank tank2;
    int NWidth;
    char key;
    Listener keyl; 
    MouseListenerTest mouse1;
    public void Refresh(Listener keyl){
        this.keyl = keyl;
       // mouse1.mouseClicked(new MouseEvent(this, 0, 0, 1, 78, 6, 435, true));
    }
    public void Init() {
        
        addKeyListener(keyl);
        tank = new Tank(0, 30, 400, 200);
        tank2 = new Tank(60, 60, 150, 100);
        setSize(new Dimension(700, 500));
        setVisible(true);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        NWidth = getWidth();
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        

        if (tank != null) {
            gg.fillRect(0, 0, NWidth, getHeight());
            tank.pos(keyl);
            tank.paint(g, NWidth);

        }

        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {

        }
        repaint(9);
    }

        //add custom drawing here

}
