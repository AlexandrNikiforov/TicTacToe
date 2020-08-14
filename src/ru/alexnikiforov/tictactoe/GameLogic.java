package ru.alexnikiforov.tictactoe;

import java.util.Scanner;
import java.util.Random;


public class GameLogic {
    static int spaceNumber;

    public static Field f = new Field();
    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();
    static String endGameMessage;
    static boolean gameOver;

    public static void intro()    {
        System.out.println("-----TIC-TAC-TOE-----");
        System.out.println("These are the spaces numbers: ");
        System.out.println("1 | 2 | 3");
        System.out.println("---------");
        System.out.println("4 | 5 | 6");
        System.out.println("---------");
        System.out.println("7 | 8 | 9");
    }

    public static void playersMove() {
        do {
            System.out.println("Choose a space - type a number from 1 to 9:");
            spaceNumber = scanner.nextInt();

            if (!f.checkIfSpaceIsFree(spaceNumber)) {
                while (!f.checkIfSpaceIsFree(spaceNumber)) {
                    System.out.println("Invalid space number! Type another space number: ");
                    spaceNumber = scanner.nextInt();
                }
            }
            f.setSpaceNumber(spaceNumber);
            f.setMark("X");


        } while (spaceNumber < 1 || spaceNumber > 9);
        System.out.println("Your space was marked with X: ");
    }

    //this is method for regular program run
    public static void computersMove() {
        System.out.println("This is a computer's move (space was marked with 0): ");
        spaceNumber = Math.round(rand.nextInt(10) + 1);
        boolean spaceIsFree = f.checkIfSpaceIsFree(spaceNumber);
        if (!spaceIsFree) {
            while (!f.checkIfSpaceIsFree(spaceNumber)) {
                spaceNumber = Math.round(rand.nextInt(10) + 1);
            }
            f.setSpaceNumber(spaceNumber);
            f.setMark("0");
        } else {
            f.setSpaceNumber(spaceNumber);
            f.setMark("0");
        }

    }

    //computersMove method for testing
//    public static void computersMove() {
//        System.out.println("This is a computer's move (space was marked with 0): ");
//
//        do {
//            System.out.println("Choose a space - type a number from 1 to 9:");
//            spaceNumber = scanner.nextInt();
//
//            if (!f.checkIfSpaceIsFree(spaceNumber)) {
//                while (!f.checkIfSpaceIsFree(spaceNumber)) {
//                    System.out.println("Invalid space number! Type another space number: ");
//                    spaceNumber = scanner.nextInt();
//                }
//            }
//            f.setSpaceNumber(spaceNumber);
//            f.setMark("0");
//
//
//        } while (spaceNumber < 1 || spaceNumber > 9);
//        System.out.println("Your space was marked with X: ");
//    }








    public static void show () {
        f.showField();
    }


    public static boolean gameOver  () {
        if  ((f.getSpace1().equals("X") && f.getSpace2().equals("X") && f.getSpace3().equals("X"))||
            (f.getSpace4().equals("X") && f.getSpace5().equals("X") && f.getSpace6().equals("X")) ||
            (f.getSpace7().equals("X") && f.getSpace8().equals("X") && f.getSpace9().equals("X")) ||
            (f.getSpace1().equals("X") && f.getSpace4().equals("X") && f.getSpace7().equals("X")) ||
            (f.getSpace2().equals("X") && f.getSpace5().equals("X") && f.getSpace8().equals("X")) ||
            (f.getSpace3().equals("X") && f.getSpace6().equals("X") && f.getSpace9().equals("X")) ||
            (f.getSpace1().equals("X") && f.getSpace5().equals("X") && f.getSpace9().equals("X")) ||
            (f.getSpace3().equals("X") && f.getSpace5().equals("X") && f.getSpace7().equals("X"))) {
            endGameMessage = "You wins!";
            gameOver = true;
        } else if (
            (f.getSpace4().equals("0") && f.getSpace5().equals("0") && f.getSpace6().equals("0")) ||
            (f.getSpace1().equals("0") && f.getSpace2().equals("0") && f.getSpace3().equals("0")) ||
            (f.getSpace7().equals("0") && f.getSpace8().equals("0") && f.getSpace9().equals("0")) ||
            (f.getSpace1().equals("0") && f.getSpace4().equals("0") && f.getSpace7().equals("0")) ||
            (f.getSpace2().equals("0") && f.getSpace5().equals("0") && f.getSpace8().equals("0")) ||
            (f.getSpace3().equals("0") && f.getSpace6().equals("0") && f.getSpace9().equals("0")) ||
            (f.getSpace1().equals("0") && f.getSpace5().equals("0") && f.getSpace9().equals("0")) ||
            (f.getSpace3().equals("0") && f.getSpace5().equals("0") && f.getSpace7().equals("0"))) {
            endGameMessage = "Computer wins!";
            gameOver = true;
        } else if
                (!f.getSpace1().equals(" ") && !f.getSpace2().equals(" ") && !f.getSpace3().equals(" ") &&
                !f.getSpace4().equals(" ") && !f.getSpace5().equals(" ") && !f.getSpace6().equals(" ") &&
                !f.getSpace7().equals(" ") && !f.getSpace8().equals(" ") && !f.getSpace9().equals(" "))
        {
            endGameMessage = "Draw!";
            gameOver = true;
        } else {
            gameOver = false;
        }
        return gameOver;
    }

    public static void showWinnerName () {
        System.out.println(endGameMessage);
    }

    public static boolean getGameOver() {
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
