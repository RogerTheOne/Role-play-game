package Attacks;
import Characters.RPGCharacter;

/**
 * Concrete implementation of Damage Spells, that it, spells that deal damage
 *
 * @author Juliano Franz
 */
public class DamageSpell extends Spell{

    /**
     * Creates a new DamageSpell
     * @param cost the cost to use the spell. This cost is represented in MANA
     * @param name the name of the spell
     * @param damage the amount of damage/heal of the attack
     * @param range the maximum range (distance) of the spell
     */
    public DamageSpell(int cost, String name, int damage, int range) {
        super(cost, name, damage, range);
    }

    /**
     * Concrete implementation of the spells interaction with the target to deal damage
     *
     * @param target the RPGCharacter target of the attack
     * @param attackModifier Spells should receive the caster's intellect as a modifier
     * @return the amount of damage done
     */
    @Override
    public int interactWithTarget(RPGCharacter target, int attackModifier) {
        target.takeDamage(getDamage() + attackModifier);
        return getDamage() + attackModifier;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d) - Damage: %d",
                "DamageSpell",getName(), getCost(), getDamage());
    }
}
