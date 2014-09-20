/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Todor
 */
public class KeyListener2 implements KeyListener {

    char key;

    @Override
    public void keyTyped(KeyEvent e) {
       // System.out.println("1");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyChar();
        //System.out.println(key);

    }

    public char Key() {

        return key;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = ' ';
      // System.out.println(key);

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
