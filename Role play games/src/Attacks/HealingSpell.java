package Attacks;
import Characters.RPGCharacter;

/**
 * Concrete implementation of the HealingSpell.
 * NOTE: This class will not complie until you have the heal method implemented on RPG character
 *
 * @author Juliano Franz
 */
public class HealingSpell extends Spell {

    /**
     * Creates a new HealingSpell, that is a spell that heals the target instead of inflicting damage
     *
     * @author Juliano Franz
     *
     * @param cost the cost to use the spell. This cost is represented in MANA
     * @param name the name of the spell
     * @param damage the amount of heal done by the spell
     * @param range the maximum range (distance) of the spell
     */
    public HealingSpell(int cost, String name, int damage, int range) {
        super(cost, name, damage, range);
    }

    /**
     * Concrete implementation of the interaction with the target.
     * Healing spells will call the heal method on the target instead of dealing damage
     *
     * @param target the RPGCharacter target of the attack
     * @param attackModifier Spells should receive the caster's intellect as a modifier
     * @return The amount of healing done.
     */
    @Override
    public int interactWithTarget(RPGCharacter target, int attackModifier) {
        target.heal(getDamage() + attackModifier /2);
        return getDamage() + attackModifier /2;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d) - Heal: %d",
                "HealingSpell",getName(), getCost(), getDamage());
    }
}
