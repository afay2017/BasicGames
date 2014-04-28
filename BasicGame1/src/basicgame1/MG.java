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
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
    projectile [] projs = new projectile [100];
    int projcount;

    double rot;

    public MG(Listener listener, Point start, Dimension dimensions) {
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
        for (int i = 0;i > projs.length-1; i++){
            projs[i] = new projectile(0, 0, 0, -100, -100, false);
        }
    }

    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;

        gg.translate(posX, posY);
        gg.rotate(rot);
        gg.drawImage(pic, -dimensionY / 2, -dimensionY / 2, dimensionX, dimensionY, null);
        gg.rotate(-rot);
        gg.translate(-posX, -posY);
        
        for (int i = 0; i < projs.length-1;i++){
            if (projs[i]==(null)){
                break;
            }
            projs[i].paintCompnent(g);
            
        }
        gg.setColor(Color.red);
        gg.drawLine(posX, posY, distanceX+posX, distanceY+posY);
        gg.translate(posX, posY);
        gg.rotate(rot);
        gg.drawLine(0, 0, 90, 0);
        gg.rotate(-rot);
        gg.translate(-posX,-posY);
        

    }

    public void pos(Listener listener, int tankX, int tankY) {
        posX = startX + tankX;
        posY = startY + tankY;
        distanceX = -((posX) - listener.getX());
        distanceY = -((posY + tankY) - listener.getY());
        rot = Math.atan2(distanceY, distanceX);
        //System.out.println(distanceY + " " + distanceX + " " + rot);

    }
    public void shoot(int dimensionX,int dimensionY){
        projs[projcount] = new projectile(rot,posX,posY,dimensionX,dimensionY,true);
        projcount++;
        if (projcount > projs.length-1)
            projcount = 0;
        
    }

}
