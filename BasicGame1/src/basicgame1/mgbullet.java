/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basicgame1;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Todor
 */
class mgBullet extends Projectile{
    private BufferedImage pic;
    private final double rot;
    private final int dimensionY;
    private final int dimensionX;
    private final double y;
    private final double x;
    public boolean alive;
    private final int xinit;
    private final int yinit;
    public String sender;
    public mgBullet(double rot,int x,int y,int dimensionX, int dimensionY){
        super(rot, x, y, dimensionX, dimensionY, 60 ,null);
        try {
            pic = ImageIO.read(getClass().getResourceAsStream("/basicgame1/mgBullet.png"));
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
        alive = true;
        super.setImage(pic);

    }
    public mgBullet(double rot,int x,int y,int dimensionX, int dimensionY,String Sender){
        super(rot, x, y, dimensionX, dimensionY, 60 ,null,Sender);
        sender = sender;
        try {
            pic = ImageIO.read(getClass().getResourceAsStream("/basicgame1/mgBullet.png"));
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
        alive = true;
        super.setImage(pic);

    }


}
