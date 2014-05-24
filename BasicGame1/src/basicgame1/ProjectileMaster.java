/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Aidan
 */
public class ProjectileMaster {

    Projectile[] projList;//Array of projectiles
    int projCount;//The current projectile selected in the array, may be next for replacement
    Image tankpic;

    public ProjectileMaster() {
        projList = new Projectile[12];
        for (int i = 0; i < projList.length; i++) {
            projList[i] = new Projectile(0, 0, 0, 0, 0, 0, null);
        }
         try {
            tankpic = ImageIO.read(getClass().getResourceAsStream("/basicgame1/TankBody.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addProjectile(Projectile newProj) {
        if (projCount > projList.length - 1) {
            projCount = 0;
        }
        //System.out.println(projList[projCount].getClass());
        projList[projCount] = newProj;
        projCount++;
    }

    public Projectile intersects(GameObject shape) {
            for (Projectile projList1 : projList) {
                if (shape.contains(projList1.getLocation())) {
                    return projList1;                    
                }
            }
        return null;
    }

    public void PaintComponent(Graphics g) {
        for (Projectile projectile : projList) {
            if (!(projectile.image == null)) {
                projectile.paintComponent(g);
            }
        }
    }
}
