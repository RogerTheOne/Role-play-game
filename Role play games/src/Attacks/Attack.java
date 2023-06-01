package Attacks;
import Characters.RPGCharacter;

/***
 * Base Attack class. It creates the foundation for all specialized attacks such as Spells and Melees.
 * PLEASE NOTE: This class will not compile until you create the RPGCharacter class
 *
 * @author Juliano Franz
 */
public abstract class Attack {
    private int cost;
    private String name;
    private int damage;
    private int range;

    /**
     * Creates a new attack object given a the cost (mana/energy), name, damage and range
     * @param cost the cost to perform this attack. It could be mana or energy
     * @param name the name of the attack
     * @param damage how much damage the attack will deal.
     * @param range the maximum range for attacking another target. Unitless
     */
    public Attack(int cost, String name, int damage, int range) {
        this.cost = cost;
        this.name = name;
        this.damage = damage;
        this.range = range;
    }

    public int getCost(){
        return cost;
    }

    public int getDamage(){
        return damage;
    }

    public int getRange(){
        return range;
    }

    public String getName() {
        return name;
    }

    /**
     * Method used to interact (deal damage or heal) a target
     * @param target the RPGCharacter target of the attack
     * @param attackModifier the attack modifier used to change the attacks damage,  for example
     * @return the amount of damage or healing done with the attack.
     */
    public abstract int interactWithTarget(RPGCharacter target, int attackModifier);

    @Override
    public String toString() {
        return String.format("%s - %s (%d) - Damage: %d",
                "Attack",name, cost, damage);
    }
}
