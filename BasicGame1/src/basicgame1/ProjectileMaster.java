/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgame1;

import java.awt.Graphics;

/**
 *
 * @author Aidan
 */
public class ProjectileMaster {

    static Projectile[] projList;//Array of projectiles
    static int projCount;//The current projectile selected in the array, may be next for replacement

    public ProjectileMaster() {
        projList = new Projectile[30];
        for (int i = 0; i < projList.length; i++) {
            projList[i] = new Projectile(0, 0, 0, 0, 0, 0, null);
        }
    }

    public static void addProjectile(Projectile newProj) {
        if (projCount > projList.length - 1) {
            projCount = 0;
        }
        //System.out.println(projList[projCount].getClass());
        projList[projCount] = newProj;
        projCount++;
    }

    public static Projectile intersects(GameObject shape) {
            for (Projectile projList1 : projList) {
                if (shape.contains(projList1.getLocation())) {
                    return projList1;                    
                }
            }
        return null;
    }

    public static void PaintComponent(Graphics g) {
        for (Projectile projectile : projList) {
            if (!(projectile.image == null)) {
                projectile.paintComponent(g);
            }
        }
    }
}
