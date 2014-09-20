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

    static Tank tank;
    static Tank tank2;
    static Target target1;
    int NWidth;
    char key;
    Listener keyl;
    MouseListenerTest mouse1;
    ProjectileMaster projMaster;
    GameObjectManager objManager;
    private Target target2;
    private Projectile currentProj;

    public void Refresh(Listener keyl) {
        Globals.KeyListener = keyl;
        Globals.Width = getWidth();
    }

    public void Init() {
        projMaster = new ProjectileMaster();
        addKeyListener(keyl);
        tank = new Tank(0, 30, 800, 400,"player");
        target1 = new Target(800, 100, 80, 80,"target1");
        target2 = new Target(0, 830, 9000, 8000,"target2");
        GameObject [] tempObjectArray = {tank,target1,target2};
        objManager = new GameObjectManager(tempObjectArray);
        setSize(new Dimension(1680, 1050));
        setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        gg.fillRect(0, 0, getWidth(), getHeight());//background
        try {
            ProjectileMaster.PaintComponent(g);
            objManager.paintComponent(g);
            objManager.pos();
            objManager.CheckProjectiles();
            
        } catch (Exception e) {}
        
        
//        if (tank != null) {
//            tank.pos();
//            try {
//                currentProj = ProjectileMaster.intersects(target1);
//                if (target1.getHP() > 0)
//                    currentProj.die();
//                target1.hit(currentProj);
//            } catch (Exception e) {
//            }
//            try {
//                ProjectileMaster.intersects(target2).die();
//            } catch (Exception e) {
//                
//            }
//            
//            tank.paint(g);
//            target1.paint(g);
//            target2.paint(g);
//        }

        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {

        }
        //   System.out.println(projMaster.intersects(target1).getLocation());
        repaint(9);
    }
}
