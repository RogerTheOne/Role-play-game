package Characters;
import Attacks.Attack;
/** Name: Roger Zhang B00882222
 * Assignment 3
 * Mar 25th 2022
 */

import java.awt.*;
import java.util.ArrayList;

public abstract class RPGCharacter implements Comparable<RPGCharacter>{
    private String name;
    private int maxHP;
    private Point position;

    protected int currentHP;
    protected int intellect;
    protected int strength;
    protected ArrayList<Attack> attackList;


    public RPGCharacter (String name, int intellect, int strength, int maxHP, Point position){
        this.name = name;
        this.intellect = intellect;
        this.strength = strength;
        this.maxHP = maxHP;
        this.position = position;
        this.currentHP = maxHP;
        this.attackList = new ArrayList<>();
    }


    public int getCurrentHP() {
        return currentHP;
    }

    public Point getPosition() {
        return position;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public String getName() {
        return name;
    }



    public void move(int x, int y){
        position.translate(x, y);
    }

    public boolean takeDamage(int damage){
        currentHP -= damage; // calculate the current hp after the damage
        if (currentHP <= 0){
            currentHP = 0; // current hp could not be a negative number
            return false;
        }else{
            return true;
        }

    }

    public boolean heal(int addBlood) {
        currentHP += addBlood; // calculate the current hp after heal
        if (currentHP < maxHP) {
            return false;
        } else if (currentHP >= maxHP) {
            currentHP = maxHP; // current hp should not be larger than max hp
            return true;
        }
        return false;
    }



    public abstract int attack(RPGCharacter character, int attackIndex);

    public String getAttacks(){
        String represent = "";
        for (int i = 0; i < attackList.size(); i++){
            represent += i + " - " + attackList.get(i) + "\n";
        }
        return represent;
    }

    public String toString(){
        return name + " (" + getClass().getSimpleName() + ") " + currentHP + "/" + maxHP;
    }

    public int compareTo(RPGCharacter obj){
        if (currentHP < obj.currentHP){
            return 1;
        }else if (currentHP == obj.currentHP){
            return 0;
        }else{
            return -1;
        }
    }



}