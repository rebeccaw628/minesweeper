import board.Board;
import util.InputHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board gameBoard = new Board(10, 10, 10);
        InputHandler inputHandler = new InputHandler();
        while(true) {
            gameBoard.printGrid();
            int rowInput = inputHandler.inputValidator("Enter a row number (1-10)", 10);
            int columnInput = inputHandler.inputValidator("Enter a column number (1-10)", 10);
            gameBoard.revealCell(rowInput, columnInput);
//            gameBoard.revealZeroMineCountCells(rowInput, columnInput);

            if (gameBoard.isGameWon(rowInput,columnInput)) {
                System.out.println("YOU WON! You steered clear of the mines. Congrats!");
                gameBoard.printGrid();
                break;
            }
            if (gameBoard.isGameLost(rowInput,columnInput)) {
                System.out.println("BOOM! You hit a mine. You lost :(");
                gameBoard.printGrid();
                break;
            }
        }

    }

}
