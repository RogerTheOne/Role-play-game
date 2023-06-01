package Characters;
/** Name: Roger Zhang B00882222
 * Assignment 3
 * Mar 25th 2022
 */

import Attacks.MeleeAttack;

import java.awt.*;

public class Warrior extends Melee{

    public Warrior(String name, int intellect, int maxHP, Point position, int maxEnergy) {
        super(name, intellect, maxHP, position, maxEnergy);

        MeleeAttack w1 = new MeleeAttack(0, "Punch", 5,3);
        attackList.add(w1);
        MeleeAttack w2 = new MeleeAttack(3, "Slam", 5, 5);
        attackList.add(w2);
        MeleeAttack w3 = new MeleeAttack(20, "Charge", 30, 15);
        attackList.add(w3);

    }
}