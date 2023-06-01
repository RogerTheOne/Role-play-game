package Characters;
/** Name: Roger Zhang B00882222
 * Assignment 3
 * Mar 25th 2022
 */

import Attacks.Attack;
import Attacks.DamageSpell;
import Attacks.MeleeAttack;


import java.awt.*;



public class Mage extends Caster{

    public Mage(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position, maxMana);


        MeleeAttack m1 = new MeleeAttack(0, "staff", 3, 3);
        attackList.add(m1);
        DamageSpell m2 = new DamageSpell(20, "Fire Ball", 10, 20);
        attackList.add(m2);
        DamageSpell m3 = new DamageSpell(15, "Frost Ball", 7, 15);
        attackList.add(m3);
        DamageSpell m4 = new DamageSpell(30, "Lightning", 15, 20);
        attackList.add(m4);
    }


}