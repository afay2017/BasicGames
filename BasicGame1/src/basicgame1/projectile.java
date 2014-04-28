/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basicgame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Todor
 */
class projectile{
    private BufferedImage pic;
    private double rot;
    private int dimensionY;
    private int dimensionX;
    private double y;
    private double x;
    public boolean alive;
    private final int xinit;
    private final int yinit;
    public projectile(double rot,int x,int y,int dimensionX, int dimensionY,boolean alive){
        try {
            pic = ImageIO.read(getClass().getResourceAsStream("/basicgame1/Gun.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.x = x;
        xinit = x;
        yinit = y;
        this.y = y;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.rot = rot;
        this.alive = alive;
       
    }
     public void paintCompnent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        if (alive){
        gg.translate(x, y);
        gg.rotate(rot);
        gg.setColor(Color.red);
        gg.drawImage(pic, -dimensionY / 2, -dimensionY / 2, dimensionX, dimensionY, null);
        gg.drawRect(-dimensionY/2, -dimensionY/2, dimensionX, dimensionY);
        gg.drawRect(0, 0, dimensionX, dimensionY);
        gg.rotate(-rot);
        gg.translate(-x, -y);
        gg.translate(xinit,yinit);
        gg.rotate(rot);    
        gg.drawLine(0, 0, 999, 0);
        gg.rotate(-rot);
        gg.translate(-xinit,-yinit);
        gg.drawLine(xinit, yinit, (int)x, (int)y);
        System.out.println();
        x += Math.acos(rot)*5;
        y += Math.asin(rot)*5;
        }
        
        

    }
     
    
}
