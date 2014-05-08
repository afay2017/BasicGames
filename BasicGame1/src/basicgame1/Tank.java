/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author WARLords
 */
public class Tank implements Shape {

    private Image tankpic;
    double X;
    double Y = 30;
    int sX;
    int sY;
    double Vx;
    int WWIDTH;
    int W;
    int H;

    //KeyListener key;
    char key;
    Listener keyl;
    Rectangle Bounds;
    Shooter shooter;
    MG mg;

    public Tank(double X, double Y, int W, int H) {
        try {
            tankpic = ImageIO.read(getClass().getResourceAsStream("/basicgame1/TankBody.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.X = X;
        this.Y = Y;
        this.W = W;
        this.H = H;
        Bounds  = new Rectangle((int) X, (int) Y, W, H);
        shooter = new Shooter  (keyl, new Point (W*23/40,H*26/40), new Dimension (W/2,H/10));
        mg      = new MG       (keyl, new Point (W*13/40,H*11/40), new Dimension (W/6,H/10));
    }

    public void paint(Graphics g, int WindowWIDTH) {
        Graphics2D gg = (Graphics2D) g;

        shooter.paint(g);
        mg.paint(g);
        gg.translate(X, Y);
        gg.drawImage(tankpic, 0, 0, W, H, null);
        gg.translate(-X, -Y);
        this.WWIDTH = WindowWIDTH;
    }

    public void pos(Listener keyl) {
        shooter.pos(keyl,(int)X,(int)Y);
        mg.pos(keyl,(int)X,(int)Y);
        key = keyl.Key();
        //System.out.println(Vx + " " + X);
        if (key == ' '){
            if (Vx > 0)
                Vx -= .5;
            if (Vx < 0)
                Vx += .5;
        }
        if (key == 'a') {
           // System.out.println(key);
            Vx -= 1;
            key = ' ';
        }
        if (key == 'd') {
            Vx += 1;
            key = ' ';
        }
        if (X > WWIDTH) {
            X = -W+1;
        } else if (X < -W) {
            X = WWIDTH;
        }
        if (Vx > 60){
            Vx = 60;
        }
        if (Vx < -30){
            Vx = -30;
        }
        X += Vx / 10;
        Bounds.setBounds((int) X, (int) Y, W, H);
        firecheck(keyl);

    }
    public void firecheck(Listener keyl){
        if (keyl.clicked){
            shooter.shoot(100, 20);
            keyl.clickReset();
        }
    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//        // System.out.println("1");
//                                                                                                                                                                                                                                                                                     //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        key = e.getKeyChar();
//
//        System.out.println(key);
//        //System.out.println("2");
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//       // key = ' ';
//
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
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
        if (Bounds.contains(x, y)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Point2D p) {
        if (Bounds.contains(p)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        if (Bounds.intersects(x, y, w, h)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        if (Bounds.intersects(r)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        if (Bounds.contains(x, y, w, h)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Rectangle2D r) {
        if (Bounds.contains(r)) {
            return true;
        } else {
            return false;
        }
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
