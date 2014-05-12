/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;
import static java.lang.Math.PI;
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
    mgbullet[] projs = new mgbullet[100];
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

    public MG(Listener listener, Point start, Dimension dimensions) {
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
        for (int i = 0; i > projs.length - 1; i++) {
            projs[i] = new mgbullet(0, 0, 0, -5, -5, false);
        };
        
        fire = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (trigger == true){
                    fire();
                }else{
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
            projs[i].paintCompnent(g);
        }
        gg.translate(posX, posY);
        gg.rotate(rot);
        gg.drawImage(pic, -dimensionX*1/10, -dimensionY * 9 / 10, dimensionX, dimensionY, null);
        gg.rotate(-rot);
        gg.translate(-posX, -posY);
    }

    public void pos(Listener listener, int tankX, int tankY,boolean trigger) {
        barrelOffset = dimensionX*21/25;
        posX = startX + tankX;
        posY = startY + tankY;
        distanceX = -((posX) - listener.getX());
        distanceY = -((posY) - listener.getY());
        rot = Math.atan2(distanceY, distanceX);
        barrelX = posX + Math.cos(rot-.23) * barrelOffset;
        barrelY = posY + Math.sin(rot-.23) * barrelOffset;
        //rot = Math.atan2(barrelY-distanceY, barrelX-distanceX);
        this.trigger = trigger;

    }

    public void shoot(int bulletdimensionX, int bulletdimensionY) {
        if (projcount > projs.length - 1) {
            projcount = 0;
        }
        System.out.println(rot);
        timer.start();
        this.bulletdimensionX = bulletdimensionX;
        this.bulletdimensionY = bulletdimensionY;
        
    }
    

    public void fire() {
        timer.setDelay((int)(timer.getInitialDelay()/2+(Math.random()-.5)*10));
        sound.stop();
        sound.play();
        projs[projcount] = new mgbullet(rot + ((Math.random()-.5)/10), (int) barrelX, (int) barrelY, bulletdimensionX, bulletdimensionY, true);
        projcount++;
                
    }

}
