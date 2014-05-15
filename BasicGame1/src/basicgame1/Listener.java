/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Todor
 */
public class Listener implements MouseListener, MouseMotionListener, KeyListener{
    int x;
    int y;
    boolean pressed;
    boolean clicked;
    MouseEvent e;
    
    char key;

    @Override
    public void mouseClicked(MouseEvent e) {
    clicked = true;
       // System.out.println(x);
        
    }
    public void clickReset(){
        clicked = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        this.e = e;
     //   System.out.println(x);
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println(x);
        pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println(x);
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // System.out.println(x);
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        this.e = e;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
        x = e.getX();
        y = e.getY();
        this.e = e;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       // System.out.println("1");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        //System.out.println(x);
        key = e.getKeyChar();

    }

    public char Key() {

        return key;
        
    }
    public int getX() {

        return x;
        
    }
    public int getY() {

        return y;
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = ' ';

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


