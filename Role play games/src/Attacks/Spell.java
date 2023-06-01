package Attacks;
import Characters.RPGCharacter;

/**
 * Represent Spell attacks. Spells are used primarily by casters and they cost mana.
 * PLEASE NOTE: This class will not compile until you create the RPGCharacter class
 *
 * @author Juliano Franz
 */
public abstract class Spell extends Attack {

    /**
     * Creates a new spell
     * @param cost the cost to use the spell. This cost is represented in MANA
     * @param name the name of the spell
     * @param damage the amount of damage/heal of the attack
     * @param range the maximum range (distance) of the spell
     */
    public Spell(int cost, String name, int damage, int range) {
        super(cost, name, damage, range);
    }

    /**
     * See superclass for a description
     * @param target the RPGCharacter target of the attack
     * @param attackModifier Spells should receive the caster's intellect as a modifier
     * @return the ammount of damage or healing done with the spell
     */
    public abstract int interactWithTarget(RPGCharacter target, int attackModifier);


}
