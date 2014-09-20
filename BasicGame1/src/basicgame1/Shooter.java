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
class Shooter {

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
    TankShell[] projs = new TankShell[100];
    int projcount;
    public String name;
    double rot;
    private double barrelX;
    private double barrelY;
    private int barrelOffset;
    private final AudioClip sound;
    private final ActionListener reload;
    boolean loaded;
    private final Timer timer;

    public Shooter(Listener listener, Point start, Dimension dimensions) {
        name = "unnamedShooter";
        try {
            pic = ImageIO.read(getClass().getResourceAsStream("/basicgame1/Gun.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.start = start;
        this.listener = listener;
        startX = (int) start.getX();
        startY = (int) start.getY();
        dimensionX = (int) dimensions.getWidth();
        dimensionY = (int) dimensions.getHeight();
        sound = Applet.newAudioClip(getClass().getResource("/basicgame1/TankFire.wav"));
        reload = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loaded = true;
                timer.stop();

            }
        };
        timer = new Timer(150, reload);
        timer.setInitialDelay(1000);
    }
    public Shooter(Listener listener, Point start, Dimension dimensions, String Name) {
        name = Name;
        try {
            pic = ImageIO.read(getClass().getResourceAsStream("/basicgame1/Gun.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.start = start;
        this.listener = listener;
        startX = (int) start.getX();
        startY = (int) start.getY();
        dimensionX = (int) dimensions.getWidth();
        dimensionY = (int) dimensions.getHeight();
        sound = Applet.newAudioClip(getClass().getResource("/basicgame1/TankFire.wav"));
        reload = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loaded = true;
                timer.stop();

            }
        };
        timer = new Timer(150, reload);
        timer.setInitialDelay(1000);
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
        gg.drawImage(pic, -dimensionY / 6, -dimensionY / 2, dimensionX, dimensionY, null);
        gg.rotate(-rot);
        gg.translate(-posX, -posY);
    }

    public void pos(Listener listener, int tankX, int tankY) {
        barrelOffset = dimensionX * 19 / 20;
        posX = startX + tankX;
        posY = startY + tankY;
        distanceX = -((posX) - listener.getX());
        distanceY = -((posY + tankY) - listener.getY());
        rot = rot * .95 + Math.atan2(distanceY, distanceX) * .05;
        if (rot > .2) {
            rot = .2;
        } else if (rot < -.8) {
            rot = -.8;
        }
        barrelX = posX + Math.cos(rot) * barrelOffset;
        barrelY = posY + Math.sin(rot) * barrelOffset;
    }

    public void shoot(int dimensionX, int dimensionY) {
        //System.out.println(loaded);
        if (loaded) {
            ProjectileMaster.addProjectile(new TankShell(rot, (int) barrelX, (int) barrelY, dimensionX, dimensionY,name));
            sound.stop();
            sound.play();
            loaded = false; 
        }
        timer.start();
    }
}
