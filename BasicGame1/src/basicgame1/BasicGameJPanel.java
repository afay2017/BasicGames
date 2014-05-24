/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Todor
 */
public class BasicGameJPanel extends JPanel {

    Tank tank;
    Tank tank2;
    Target target1;
    int NWidth;
    char key;
    Listener keyl;
    MouseListenerTest mouse1;
    ProjectileMaster projMaster;
    private Target target2;
    private Projectile currentProj;

    public void Refresh(Listener keyl) {
        this.keyl = keyl;
        // mouse1.mouseClicked(new MouseEvent(this, 0, 0, 1, 78, 6, 435, true));
    }

    public void Init() {
        projMaster = new ProjectileMaster();
        addKeyListener(keyl);
        tank = new Tank(0, 30, 800, 400, projMaster);
        target1 = new Target(800, 100, 80, 80);
        target2 = new Target(0, 430, 9000, 8000);
        setSize(new Dimension(1680, 1050));
        setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        NWidth = getWidth();
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        gg.fillRect(0, 0, NWidth, getHeight());//background
        try {
            projMaster.PaintComponent(g);
        } catch (Exception e) {
        }

        if (tank != null) {
            tank.pos(keyl);
            try {
                currentProj = projMaster.intersects(target1);
                currentProj.die();
                target1.hit(currentProj);
            } catch (Exception e) {
            }
            try {
                projMaster.intersects(target2).die();
            } catch (Exception e) {
            }
            
            tank.paint(g, NWidth);
            target1.paint(g);
            target2.paint(g);
        }

        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {

        }
        //   System.out.println(projMaster.intersects(target1).getLocation());
        repaint(9);
    }

    public void reCheckProjectiles() {

    }

}
