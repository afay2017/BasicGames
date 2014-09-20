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
    private int dimensionX;
    private int dimensionY;
    private boolean alive;
    private double rot;
    Image image;
    public String sender;
    public int damage;

    public Projectile(double rot, int x, int y, int dimensionX, int dimensionY, int damage, boolean alive, Image image, String sender) {
        this.sender = sender;
        this.rot = rot;
        this.x = x;
        this.y = y;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.alive = alive;
        this.image = image;
        this.sender = sender;
        this.damage = damage;
    }

    public Projectile(double rot, int x, int y, int dimensionX, int dimensionY, int damage, Image image, String sender) {
        this.sender = sender;
        this.rot = rot;
        this.x = x;
        this.y = y;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.alive = true;
        this.image = image;
        this.sender = sender;
        this.damage = damage;
    }

    public Projectile(double rot, int x, int y, int dimensionX, int dimensionY, int damage, boolean alive, Image image) {
        this.rot = rot;
        this.x = x;
        this.y = y;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.alive = alive;
        this.image = image;
        this.damage = damage;
    }

    public Projectile(double rot, int x, int y, int dimensionX, int dimensionY, int damage, Image image) {
        this.rot = rot;
        this.x = x;
        this.y = y;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.alive = true;
        this.image = image;
        this.damage = damage;
    }

    public Point getLocation() {
        Point p = new Point(x, y);
        return p;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getSender() {
        if (sender.isEmpty()) {
            return "null";
        }
        return sender;
    }

    public void die() {
        this.alive = false;
        x = -9999999;
        y = -9999999;
    }

    public boolean getAlive() {
        return alive;
    }

    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        // if (!image.equals(null)) {
        if (alive) {
            gg.translate(x, y);
            gg.rotate(rot);
            gg.drawImage(image, -dimensionX / 2, -dimensionY / 2, dimensionX, dimensionY, null);
            gg.rotate(-rot);
            gg.translate(-x, -y);
            x += Math.cos(rot) * 20;
            y += Math.sin(rot) * 20;
        }
        //}

    }

}
