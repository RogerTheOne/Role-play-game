package Attacks;

import Characters.RPGCharacter;

/**
 * Concrete implementation of Melee Attacks, that is physical attacks. MeleeAttack should consume energy
 *
 * NOTE: This class will not compile until the takeDamage method is implemented.
 *
 * @author Juliano Franz
 */
public class MeleeAttack extends Attack {


    /**
     * Creates a new MeleeAttack
     * @param cost the cost of the attack as Energy
     * @param name the name of the attack
     * @param damage the attack's damage
     * @param range the maximum range (distance) of the attack
     */
    public MeleeAttack(int cost, String name, int damage, int range) {
        super(cost, name, damage, range);
    }

    /**
     * Metho used to deal damage to a target using a MeleeAttack.
     * MeleeAttacks should receive the character's strength as the modifier
     *
     * @param target the RPGCharacter target of the attack
     * @param attackModifier the attack modifier should be the character's strength.
     * @return the damage dealt with the melee attack.
     */
    public int interactWithTarget(RPGCharacter target, int attackModifier){
        target.takeDamage(getDamage() + attackModifier);
        return getDamage() + attackModifier;
    }
}
