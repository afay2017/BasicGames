/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author Aidan
 */
public class Projectile {

    private int x;
    private int y;
    private final int dimensionX;
    private final int dimensionY;
    private final boolean alive;
    private double rot;
    private Image image;

    public Projectile(double rot, int x, int y, int dimensionX, int dimensionY, boolean alive, Image image) {
        this.rot = rot;
        this.x = x;
        this.y = y;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.alive = alive;
        this.image = image;
    }

    public Projectile(double rot, int x, int y, int dimensionX, int dimensionY, Image image) {
        this.rot = rot;
        this.x = x;
        this.y = y;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.alive = true;
        this.image = image;
    }

    public Point getLocation() {
        Point p = new Point(x, y);
        return p;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
       // if (!image.equals(null)) {
            if (alive) {
                gg.translate(x, y);
                gg.rotate(rot);
                gg.drawImage(image, -dimensionY / 2, -dimensionY / 2, dimensionX, dimensionY, null);
                gg.rotate(-rot);
                gg.translate(-x, -y);
                x += Math.cos(rot) * 20;
                y += Math.sin(rot) * 20;
            }
        //}

    }

}
