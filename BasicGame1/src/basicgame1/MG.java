/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author Todor
 */
class MG {

    Image pic;
    Point start;
    int startX;
    int startY;
    int dimensionX;
    int dimensionY;
    int distanceX;
    int distanceY;
    int posX;
    int posY;
    Listener listener;
    Projectile[] projs = new Projectile[100];
    int projcount;
    Timer timer;
    ActionListener fire;
    boolean trigger;
    double rot;
    private double barrelX;
    private double barrelY;
    private int barrelOffset;
    private int bulletdimensionX;
    private int bulletdimensionY;
    private final AudioClip sound;
    private int tankY;
    private int tankX;
    private ProjectileMaster projectileMaster;
    mgBullet testBullet;

    public MG(Listener listener, Point start, Dimension dimensions, ProjectileMaster projectileMaster) {
        testBullet = new mgBullet(rot + ((Math.random() - .5) / 10), (int) barrelX, (int) barrelY, bulletdimensionX, bulletdimensionY);
        this.projectileMaster = projectileMaster;
        try {
            pic = ImageIO.read(getClass().getResourceAsStream("/basicgame1/MG.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.start = start;
        this.listener = listener;
        startX = (int) start.getX();
        startY = (int) start.getY();
        dimensionX = (int) dimensions.getWidth();
        dimensionY = (int) dimensions.getHeight();
        sound = Applet.newAudioClip(getClass().getResource("/basicgame1/MGFire.wav"));

        fire = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (trigger == true) {
                    fire();
                } else {
                    timer.stop();
                }

            }
        };
        timer = new Timer(150, fire);
        timer.setInitialDelay(300);

    }

    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;

        for (int i = 0; i < projs.length - 1; i++) {
            if (projs[i] == (null)) {
                break;
            }
            projs[i].paintComponent(g);
        }
        gg.translate(posX, posY);
        gg.rotate(rot);
        gg.drawImage(pic, -dimensionX * 1 / 10, -dimensionY * 9 / 10, dimensionX, dimensionY, null);
        gg.rotate(-rot);
        gg.translate(-posX, -posY);
    }

    public void pos(Listener listener, int tankX, int tankY, boolean trigger) {
        barrelOffset = dimensionX * 21 / 25;
        posX = startX + tankX;
        this.tankX = tankX;
        this.tankY = tankY;
        posY = startY + tankY;
        distanceX = -((posX) - listener.getX());
        distanceY = -((posY) - listener.getY());
        rot = rot*.8 + Math.atan2(distanceY, distanceX)*.2;
        if (rot > .5) {
            rot = .5;
        } else if (rot < -1) {
            rot = -1;
        }
        barrelX = posX + Math.cos(rot - .23) * barrelOffset;
        barrelY = posY + Math.sin(rot - .23) * barrelOffset;
        this.trigger = trigger;
    }

    public void shoot(int bulletdimensionX, int bulletdimensionY) {
        if (projcount > projs.length - 1) {
            projcount = 0;
        }
        timer.start();
        this.bulletdimensionX = bulletdimensionX;
        this.bulletdimensionY = bulletdimensionY;

    }

    public void fire() {
        timer.setDelay((int) (timer.getInitialDelay() / 2 + (Math.random() - .5) * 5));
        sound.stop();
        sound.play();
       //System.out.println(rot);
        projectileMaster.addProjectile(new mgBullet(rot + ((Math.random() - .5) / 20), (int) barrelX, (int) barrelY, bulletdimensionX, bulletdimensionY));
    }

}
