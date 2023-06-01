package Attacks;

import Characters.RPGCharacter;

/**
 * Specialization of the HealingSpell class.
 * Resurrection a unique healing spell that can bring a target back to life if the target is dead
 *
 * NOTE: This class depends on the implementation of heal method.
 *
 * @author Juliano
 */
public class Resurrection extends HealingSpell {
    /**
     * Creates a new Resurrection spell. It does not requires any parameters.
     * The default cost of the spell is 50. Range is unlimited (set to -1)
     */
    public Resurrection() {
        super(50, "Resurrection", -1,-1);
    }

    /**
     * Brings the target back to half of its maximumHP only if the target is dead.
     * It has no effect on live targets
     *
     * @param target the RPGCharacter target of the attack
     * @param attackModifier Spells should receive the caster's intellect as a modifier
     * @return the targets current hp if the target was dead. -1 if the target was already alive
     */
    @Override
    public int interactWithTarget(RPGCharacter target, int attackModifier) {
        if(target.getCurrentHP() <= 0) {
            target.heal(target.getMaxHP()/2);
            return target.getCurrentHP();
        }

        return -1;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d)",
                this.getClass().getSimpleName(),getName(), getCost());
    }
}
