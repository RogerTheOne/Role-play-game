package Characters;
/** Name: Roger Zhang B00882222
 * Assignment 3
 * Mar 25th 2022
 */
import Attacks.Attack;
import Attacks.DamageSpell;
import Attacks.HealingSpell;
import Attacks.MeleeAttack;

import java.awt.*;

public abstract class Caster extends RPGCharacter{
    private int maxMana;
    private int currentMana;

    public Caster(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, 1,  maxHP, position);
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int attack(RPGCharacter character, int attackIndex){
        // when the attackIndex not in the range of the arraylist
        if (attackIndex < 0 || attackIndex >= attackList.size()){
            return -1;
        }
        // when the target out of range if the attackIndex is in the arrayList
        Attack obj = attackList.get(attackIndex); //Obtain the target within the measured attack range


        // calculate the distance between the two point
        if (super.getPosition().distance(character.getPosition()) > obj.getRange()){
            // the distance method is retrieved from https://docs.oracle.com/javase/8/docs/api/java/awt/geom/Point2D.html#distance-double-double-
            return -2;
        }

        // Mana is the cost to perform the attack
        if (currentMana < obj.getCost()){ // Identify if the mana is less than the cost, getCost() has indicated in the Attack class
            return -3;
        }else{
            currentMana -= obj.getCost();
        }


        // using intanceof to find if the attack type belongs to the existing obj
        if (obj instanceof HealingSpell){
            obj.interactWithTarget(this, intellect); // healing itself by adding intellect as modifier
        }else if (obj instanceof MeleeAttack){
            obj.interactWithTarget(character, 0); // attack the character by adding intellect as attack modifier
        }else {
            obj.interactWithTarget(character, intellect);
        }

        return character.getCurrentHP(); // return the current HP of the target as requested
    }

    public String toString(){
        return this.getName() + " (" + this.getClass() + " - " + currentHP + "/" + this.getMaxHP() + "\n" + currentMana + "/" + maxMana;
    }
}
