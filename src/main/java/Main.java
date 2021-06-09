import game.SudokuGame;
import game.boardExample.DefinedGrid;

public class Main {

    public static void main (String[] args){
        System.out.println("Hello world");

        SudokuGame sudokuGame= new SudokuGame(DefinedGrid.GRID_TO_SOLVE_EASY);
    }
}
