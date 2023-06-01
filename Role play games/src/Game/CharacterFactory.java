package Game;

import Characters.Mage;
import Characters.Priest;
import Characters.RPGCharacter;
import Characters.Warrior;

import java.awt.*;

public class CharacterFactory {

    public static RPGCharacter getCharacter(String characterClass, String characterName,
                                            int primaryStat, int maxHP, Point startPosition, int maxStat){

        if(characterClass.equalsIgnoreCase("Mage")){
            return new Mage(characterName,primaryStat,maxHP,startPosition,maxStat);
        }
        if(characterClass.equalsIgnoreCase("Priest")){
            return new Priest(characterName,primaryStat,maxHP,startPosition,maxStat);
        }
        if(characterClass.equalsIgnoreCase("Warrior")){
            return new Warrior(characterName,primaryStat,maxHP,startPosition,maxStat);
        }
        return null;
    }

    public static String getPossibleCharacters(){
        return "Mage, Priest, Warrior";
    }

}
