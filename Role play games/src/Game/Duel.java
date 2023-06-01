package Game;

import Characters.Caster;
import Characters.RPGCharacter;

import java.awt.*;
import java.util.Scanner;

public class Duel {
    private  RPGCharacter player1Char;
    private  RPGCharacter player2Char;
    private Scanner kb;

    public void run() {
        kb = new Scanner(System.in);
        System.out.println("Welcome to the 1v1 Duel!");

        player1Char = createPlayerChar(1, 0);
        player2Char = createPlayerChar(2, 3);

        System.out.printf("The duel of:\n%s\n\tvs.\n%s\n\n\n", player1Char,player2Char);

        gameLoop();

    }

    public RPGCharacter createPlayerChar(int playerNumber, int xCoordinate){
        System.out.printf("P%d, what is your char's name? ", playerNumber);
        String p1Name = kb.nextLine();
        RPGCharacter result = null;

        while (result == null) {

            System.out.printf("P%d what is your class? - %s\n",
                    playerNumber, CharacterFactory.getPossibleCharacters());
            String p1Class = kb.nextLine();

            result = CharacterFactory.getCharacter(
                    p1Class, p1Name, 20, 100, new Point(xCoordinate, 0), 100);
        }
        return result;
    }

    public void gameTurn( ) {

        printPlayersPositions();

        System.out.printf("P1's turn: %s\nWhat do you want to do? (1 - move, 2 - attack)\n", player1Char);
        int choice = kb.nextInt();
        if(choice == 1){
            System.out.println("Move in X by how much? ");
            player1Char.move(kb.nextInt(),0);
        }
        else {
            System.out.printf("Attacks:\n%s",player1Char.getAttacks());

            System.out.print("Attack number? ");
            int hpLeft = player1Char.attack(player2Char, kb.nextInt());

            if(hpLeft >=0){
                System.out.printf("P2 has %d HP left\n\n", hpLeft);
            }else {
                printAttackOutcome(player1Char,hpLeft);
            }
        }

        if(player2Char.getCurrentHP() <=0){
            return;
        }

        System.out.printf("P2's turn: %s\nWhat do you want to do? (1 - move, 2 - attack)\n", player2Char);
        choice = kb.nextInt();
        if(choice == 1){
            System.out.println("Move in X by how much? ");
            player2Char.move(kb.nextInt(),0);
        }
        else {
            System.out.printf("Attacks:\n%s",player2Char.getAttacks());

            System.out.print("Attack number? ");
            int hpLeft = player2Char.attack(player1Char, kb.nextInt());
            if(hpLeft >=0){
                System.out.printf("P1 has %d HP left\n\n", hpLeft);
            }
            else {
                printAttackOutcome(player2Char,hpLeft);
            }
        }

    }

    public void gameLoop(){
        while (player1Char.getCurrentHP() > 0 && player2Char.getCurrentHP() > 0){
            gameTurn();
        }

        if(player1Char.getCurrentHP() <= 0){
            System.out.println("P2 Won!");
        }

        if(player2Char.getCurrentHP() <= 0){
            System.out.println("P1 Won!");
        }

    }

    public void printPlayersPositions(){
        double distance = player1Char.getPosition().distance(player2Char.getPosition());

        System.out.println("\n");

        System.out.print(player1Char.getName());
        for (int i = 0; i < distance; i++) {
            System.out.print(" - ");
        }
        System.out.print(player2Char.getName());

        System.out.println("\n\n");

    }

    public void  printAttackOutcome(RPGCharacter attacker, int attackResultValue){
        if(attackResultValue == -1){
            System.out.println("Invalid Attack Index");
        }
        else if(attackResultValue == -2){
            System.out.println("Out of Range!");
        }
        else if(attackResultValue == -3){
            if(attacker instanceof Caster){
                System.out.println("Not enough Mana");
            }
            else {
                System.out.println("Not enough Energy");
            }
        }
    }



}
