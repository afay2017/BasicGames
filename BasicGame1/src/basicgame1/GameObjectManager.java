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
public class GameObjectManager {

    GameObject[] ObjectArray;

    public GameObjectManager(GameObject[] NewObjectArray) {
        ObjectArray = NewObjectArray;
    }

    public void setObjects(GameObject[] NewObjectArray) {
        ObjectArray = NewObjectArray;
    }

    public void addObject(GameObject NewObject) {
        GameObject[] NewObjectArray = new GameObject[(ObjectArray.length) + 1];
        for (int i = 0; i < ObjectArray.length; i++) {
            NewObjectArray[i] = ObjectArray[i];
        }
        NewObjectArray[(NewObjectArray.length) - 1] = NewObject;
        ObjectArray = NewObjectArray;
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < ObjectArray.length; i++) {
            ObjectArray[i].paint(g);

        }
    }

    public void pos() {
        for (int i = 0; i < ObjectArray.length; i++) {
            ObjectArray[i].pos();

        }
    }

    public void CheckProjectiles() {
        Projectile currentProj;
        for (int i = 0; i < ObjectArray.length; i++) {
            try {
                currentProj = ProjectileMaster.intersects(ObjectArray[i]);
                if ((currentProj.getSender().equals(ObjectArray[i].getName()))) {
                } else {
                    if (ObjectArray[i].getHP() > 0) {
                        currentProj.die();
                    }
                    ObjectArray[i].hit(currentProj);
                }
            } catch (Exception e) {}
        }
    }
}
