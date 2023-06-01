package Characters;
/** Name: Roger Zhang B00882222
 * Assignment 3
 * Mar 25th 2022
 */


import Attacks.Attack;

import java.awt.*;

public abstract class Melee extends RPGCharacter{
    private int maxEnergy;
    private int currentEnergy;

    public Melee(String name, int strength, int maxHP, Point position, int maxEnergy){
        super(name, 1, strength, maxHP, position);
        this.maxEnergy = maxEnergy;
        this.currentEnergy = maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public int attack(RPGCharacter character, int attackIndex) {
        // when the attackIndex not in the range of the arraylist
        if (attackIndex < 0 || attackIndex >= attackList.size()) {
            return -1;
        }
        // when the target out of range if the attackIndex is in the arrayList
        Attack obj = attackList.get(attackIndex); //Obtain the target within the measured attack range


        // calculate the distance between the two point
        if (super.getPosition().distance(character.getPosition()) > obj.getRange()) {
            // the distance method is retrieved from https://docs.oracle.com/javase/8/docs/api/java/awt/geom/Point2D.html#distance-double-double-
            return -2;
        }

        if (currentEnergy < obj.getCost()) {
            return -3;
        } else {
            currentEnergy -= obj.getCost(); // compute the rest of the energy
            obj.interactWithTarget(character, strength);
            return character.getCurrentHP();
        }
    }

    public String toString(){
        return this.getName() + " (" + this.getClass() + " - " + currentHP + "/" + this.getMaxHP() + "\n" + currentEnergy + "/" + maxEnergy;
    }


}