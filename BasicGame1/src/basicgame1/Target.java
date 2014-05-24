/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Aidan
 */
public class Target extends GameObject {

    private int X;
    private int Y;
    private int W;
    private int H;

    /**
     *
     * @param X
     * @param Y
     * @param W
     * @param H
     */
    public Target(int X, int Y, int W, int H) {
        super(X, Y, W, H, 999, null);
        this.X = X;
        this.Y = Y;
        this.W = W;
        this.H = H;

    }

    @Override
    public void paint(Graphics g) {
        if (super.getHP()>0){
        Graphics2D gg = (Graphics2D) g;
        gg.translate(X, Y);
        gg.draw3DRect(0, 0, W, H, true);
        gg.setColor(Color.red);
        gg.drawString(""+super.getHP(), 0, 0);
        gg.translate(-X, -Y);
        }
    }

    public void pos(Listener keyl) {
        super.pos(X,Y);
    }

    @Override
    public Rectangle getBounds() {
        return super.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() {
        return super.getBounds2D();
    }

    @Override
    public boolean contains(double x, double y) {
        return super.contains(x, y);
    }

    @Override
    public boolean contains(Point2D p) {
        return super.contains(p);
    }

    /**
     *
     * @param x
     * @param y
     * @param w
     * @param h
     * @return
     */
    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return super.intersects(x, y, w, h);
    }

    /**
     *
     * @param r
     * @return
     */
    @Override
    public boolean intersects(Rectangle2D r) {
        return super.intersects(r);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return super.contains(x, y, w, h);
    }

    /**
     *
     * @param r
     * @return
     */
    @Override
    public boolean contains(Rectangle2D r) {
        return super.contains(r);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return super.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return super.getPathIterator(at, flatness);
    }

}
