import game.SudokuGameSetup;
import game.boardExample.DefinedGrid;

public class Main {

    public static void main (String[] args){
        System.out.println("Hello world");

        SudokuGameSetup sudokuGameSetup = new SudokuGameSetup(DefinedGrid.GRID_TO_SOLVE_EASY);

        sudokuGameSetup.isBoardSetupOk();
    }
}
