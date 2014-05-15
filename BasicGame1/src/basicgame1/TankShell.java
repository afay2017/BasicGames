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
class TankShell extends Projectile{
    private BufferedImage pic;
    private double rot;
    private int dimensionY;
    private int dimensionX;
    private double y;
    private double x;
    public boolean alive;
    private final int xinit;
    private final int yinit;
    public TankShell(double rot,int x,int y,int dimensionX, int dimensionY,boolean alive){
        super(rot, x, y, dimensionX, dimensionY, null);
        try {
            pic = ImageIO.read(getClass().getResourceAsStream("/basicgame1/TankShell.png"));
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
        super.setImage(pic);

    }
}
