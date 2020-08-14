package ru.alexnikiforov.tictactoe;

public class GameRunner {

    public static void main(String[] args) {
        GameLogic.intro();

        while (!GameLogic.getGameOver()) {
            GameLogic.playersMove();
            GameLogic.show();
            if (GameLogic.gameOver()) {
                break;
            }
            GameLogic.computersMove();
            GameLogic.show();
            if (GameLogic.gameOver()) {
                break;
            }
        }
        GameLogic.showWinnerName();

        //Draw test
//        GameLogic.f.setSpace1("X");
//        GameLogic.f.setSpace2("0");
//        GameLogic.f.setSpace3("X");
//        GameLogic.f.setSpace4("0");
//        GameLogic.f.setSpace5("0");
//        GameLogic.f.setSpace6("X");
//        GameLogic.f.setSpace7("0");
//        GameLogic.f.setSpace8("X");
//        GameLogic.f.setSpace9("0");
//        GameLogic.f.showField();
//        GameLogic.gameOver();
//        GameLogic.showWinnerName();


    }
}
