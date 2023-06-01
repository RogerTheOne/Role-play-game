package Characters;
/** Name: Roger Zhang B00882222
 * Assignment 3
 * Mar 25th 2022
 */

import Attacks.DamageSpell;
import Attacks.HealingSpell;
import Attacks.MeleeAttack;
import Attacks.Resurrection;

import java.awt.*;

public class Priest extends Caster {


    public Priest(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position, maxMana);

        MeleeAttack p1 = new MeleeAttack(0, "Wand", 3, 3);
        attackList.add(p1);
        DamageSpell p2 = new DamageSpell(10, "Smite", 10, 7);
        attackList.add(p2);
        HealingSpell p3 = new HealingSpell(20, "Flash heal", 15,15);
        attackList.add(p3);
        Resurrection p4 = new Resurrection();
        attackList.add(p4);


    }
}