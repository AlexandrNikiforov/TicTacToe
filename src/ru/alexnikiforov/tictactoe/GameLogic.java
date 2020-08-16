package ru.alexnikiforov.tictactoe;

import java.util.Scanner;
import java.util.Random;


public class GameLogic {
    private int spaceNumber;
    private  Field field = new Field();
    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();
    private String endGameMessage;
    private boolean gameOver;
    
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
        showWinnerName();
    }
    

    private void intro()    {
        System.out.println("-----TIC-TAC-TOE-----");
        System.out.println("These are the spaces numbers: ");
        field.showField();

    }

    private void playersMove() {
        do {
            System.out.println("Choose a space - type a number from 1 to 9:");
            spaceNumber = scanner.nextInt() - 1;
            if (spaceNumber >= 0 && spaceNumber < 9) {

                if (!field.checkIfSpaceIsFree(spaceNumber)) {
                    while (!field.checkIfSpaceIsFree(spaceNumber)) {
                        System.out.println("Invalid space number! Type another space number: ");
                        spaceNumber = scanner.nextInt();
                    }
                }
                field.setValue(spaceNumber, "X");


            } else {
                System.out.println("Invalid value!");
            }
        }
            while (spaceNumber < 0 || spaceNumber > 8) ;
            System.out.println("Your space was marked with X: ");
        }

    private void computersMove() {
        System.out.println("This is a computer's move (space was marked with 0): ");
        spaceNumber = Math.round(rand.nextInt(9));
        boolean spaceIsFree = field.checkIfSpaceIsFree(spaceNumber);
        if (!spaceIsFree) {
            while (!field.checkIfSpaceIsFree(spaceNumber)) {
                spaceNumber = Math.round(rand.nextInt(9));
            }
            field.setValue(spaceNumber, "0");
        } else {
            field.setValue(spaceNumber, "0");
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
            endGameMessage = "You wins!";
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
            endGameMessage = "Computer wins!";
            gameOver = true;
        } else if
                (!field.getValues(0).equals("1") && !field.getValues(1).equals("2") && !field.getValues(2).equals("3") &&
                !field.getValues(3).equals("4") && !field.getValues(4).equals("5") && !field.getValues(5).equals("6") &&
                !field.getValues(6).equals("7") && !field.getValues(7).equals("8") && !field.getValues(8).equals("9"))
        {
            endGameMessage = "Draw!";
            gameOver = true;
        } else {
            gameOver = false;
        }
        return gameOver;
    }

    private void showWinnerName () {
        System.out.println(endGameMessage);
    }

    private boolean getGameOver() {
        return gameOver;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
