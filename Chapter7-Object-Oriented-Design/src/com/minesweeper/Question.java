package com.minesweeper;

public class Question {
    public static void main(String[] args) {
        Game game = new Game(7, 7, 3);
        game.initialize();
        game.start();
    }
}
