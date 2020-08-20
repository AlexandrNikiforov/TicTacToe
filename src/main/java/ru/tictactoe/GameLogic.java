package main.java.ru.tictactoe;

import java.util.Scanner;
import java.util.Random;


public class GameLogic {
    private int spaceNumber;
    private  Field field = new Field();
    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();
    private String endGameMessage;
    private boolean gameOver;
    private int messageNumber;
    
    public void start () {
        intro();

        while (!getGameOver()) {
            playersMove();
            show();
            if (gameOver()) {
                break;
            }
            computersMove();
            show();
            if (gameOver()) {
                break;
            }
        }
    }
    

    private void intro()    {
        printsMessages ();
        messageNumber = 0;
        field.showField();

    }

    private void playersMove() {
        do {
            messageNumber = 1;
            System.out.println("Choose a space - type a number from 1 to 9:");
            spaceNumber = scanner.nextInt() - 1;
            if (spaceNumber >= 0 && spaceNumber < 9) {

                if (!field.checkIfSpaceIsFree(spaceNumber)) {
                    while (!field.checkIfSpaceIsFree(spaceNumber) || spaceNumber<0 || spaceNumber>8) {
                        messageNumber = 2;
                        printsMessages ();
                        spaceNumber = scanner.nextInt()-1;
                    }
                }
                field.setValue(spaceNumber, "X");


            } else {
                messageNumber = 3;
                printsMessages ();
            }
        }
            while (spaceNumber < 0 || spaceNumber > 8) ;
            messageNumber = 4;
            printsMessages ();
        }

    private void computersMove() {
        messageNumber = 5;
        printsMessages ();
        spaceNumber = Math.round(rand.nextInt(9));
        boolean spaceIsFree = field.checkIfSpaceIsFree(spaceNumber);
        if (!spaceIsFree) {
            while (!field.checkIfSpaceIsFree(spaceNumber)) {
                spaceNumber = Math.round(rand.nextInt(9));
            }
            field.setValue(spaceNumber, "O");
        } else {
            field.setValue(spaceNumber, "O");
        }

    }

    private void show () {
        field.showField();
    }


    private boolean gameOver  () {
        if  ((field.getValues(0).equals("X") && field.getValues(1).equals("X") && field.getValues(2).equals("X"))||
            (field.getValues(3).equals("X") && field.getValues(4).equals("X") && field.getValues(5).equals("X")) ||
            (field.getValues(6).equals("X") && field.getValues(7).equals("X") && field.getValues(8).equals("X")) ||
            (field.getValues(0).equals("X") && field.getValues(3).equals("X") && field.getValues(6).equals("X")) ||
            (field.getValues(1).equals("X") && field.getValues(4).equals("X") && field.getValues(7).equals("X")) ||
            (field.getValues(2).equals("X") && field.getValues(5).equals("X") && field.getValues(8).equals("X")) ||
            (field.getValues(0).equals("X") && field.getValues(4).equals("X") && field.getValues(8).equals("X")) ||
            (field.getValues(2).equals("X") && field.getValues(4).equals("X") && field.getValues(6).equals("X"))) {

            messageNumber = 6;
            printsMessages ();
            gameOver = true;
        } else if (
            ((field.getValues(0).equals("0") && field.getValues(1).equals("0") && field.getValues(2).equals("0"))||
            (field.getValues(3).equals("0") && field.getValues(4).equals("0") && field.getValues(5).equals("0")) ||
            (field.getValues(6).equals("0") && field.getValues(7).equals("0") && field.getValues(8).equals("0")) ||
            (field.getValues(0).equals("0") && field.getValues(3).equals("0") && field.getValues(6).equals("0")) ||
            (field.getValues(1).equals("0") && field.getValues(4).equals("0") && field.getValues(7).equals("0")) ||
            (field.getValues(2).equals("0") && field.getValues(5).equals("0") && field.getValues(8).equals("0")) ||
            (field.getValues(0).equals("0") && field.getValues(4).equals("0") && field.getValues(8).equals("0")) ||
            (field.getValues(2).equals("0") && field.getValues(4).equals("0") && field.getValues(6).equals("0")))) {
            messageNumber = 7;
            printsMessages ();
            gameOver = true;
        } else if
                (!field.getValues(0).equals("1") && !field.getValues(1).equals("2") && !field.getValues(2).equals("3") &&
                !field.getValues(3).equals("4") && !field.getValues(4).equals("5") && !field.getValues(5).equals("6") &&
                !field.getValues(6).equals("7") && !field.getValues(7).equals("8") && !field.getValues(8).equals("9"))
        {
            messageNumber = 8;
            printsMessages ();
            gameOver = true;
        } else {
            gameOver = false;
        }
        return gameOver;
    }


    private void printsMessages () {

        switch (messageNumber) {

            case 0:
                System.out.println("-----TIC-TAC-TOE-----");
                System.out.println("These are the spaces numbers: ");
                break;

            case 1:
                System.out.println("Choose a space - type a number from 1 to 9:");
                break;

            case 2:
                System.out.println("Invalid space number! Type another space number: ");
                break;

            case 3:
                System.out.println("Invalid space number! Type another space number:");
                break;

            case 4:
                System.out.println("Your space was marked with X: ");
                break;

            case 5:
                System.out.println("This is a computer's move (space was marked with 0): ");
                break;

            case 6:
                System.out.println("You wins!");
                break;

            case 7:
                System.out.println("Computer wins!");
                break;

            case 8:
                System.out.println("Draw!");
                break;
        }
    }


    private boolean getGameOver() {
        return gameOver;
    }


}
