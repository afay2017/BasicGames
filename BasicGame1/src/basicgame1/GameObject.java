package basicgame1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class GameObject implements Shape {

    private final Rectangle Bounds;
    private int X;
    private int Y;
    private int W;
    private int H;
    private int hp;
    private Image image;

    public GameObject(int X, int Y, int W, int H, int Health, Image image) {
        Bounds = new Rectangle((int) X, (int) Y, W, H);
        this.X = X;
        this.Y = Y;
        this.W = W;
        this.H = H;
        this.hp = Health;
        this.image = image;

    }

    public void paint(Graphics g) {
        if (hp > 0) {
            Graphics2D gg = (Graphics2D) g;
            gg.translate(X, Y);
            gg.drawImage(image, 0, 0, W, H, null);
            gg.translate(-X, -Y);
        }
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void pos(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public void hit(Projectile proj) {
        hp -= proj.damage;
    }

    public int getHP() {
        return hp;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) X, (int) Y, W, H);
    }

    @Override
    public Rectangle2D getBounds2D() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(double x, double y) {
        return Bounds.contains(x, y);
    }

    @Override
    public boolean contains(Point2D p) {
        return Bounds.contains(p);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return Bounds.intersects(x, y, w, h);
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return Bounds.intersects(r);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return Bounds.contains(x, y, w, h);
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return Bounds.contains(r);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return Bounds.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return Bounds.getPathIterator(at, flatness);
    }

}
